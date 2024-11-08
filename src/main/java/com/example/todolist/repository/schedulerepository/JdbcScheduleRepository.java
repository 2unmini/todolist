package com.example.todolist.repository.schedulerepository;

import com.example.todolist.dto.schedule.ScheduleResponseDto;
import com.example.todolist.dto.UserScheduleResponseDto;
import com.example.todolist.entity.Paging;
import com.example.todolist.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcScheduleRepository(DataSource dataSource) { // application.properties에서 설정한 Datasource 가져와 JDBCTemplate의 주입
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) { // DB에 INSERT
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("schedule_id").usingColumns("title", "user_id", "content", "password", "created_at");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", schedule.getTitle());
        parameters.put("user_id", schedule.getUserId());
        parameters.put("content", schedule.getContent());
        parameters.put("password", schedule.getPassword());
        parameters.put("createdAt", schedule.getCreatedAt());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ScheduleResponseDto(key.longValue(), schedule.getTitle(), schedule.getUserId(), schedule.getContent(), schedule.getCreatedAt());

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() { //DB에 select

        return jdbcTemplate.query("select * from schedule ", scheduleRowMapper());


    }

    @Override
    public Optional<Schedule> findScheduleById(Long id) { //DB에 맞는 조건을 걸어 select
        List<Schedule> result = jdbcTemplate.query("select * from schedule where schedule_id = ?", scheduleIdRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public int updateSchedule(Long id, String title, Long userId, String content, String password) { //DB에 맞는 조건을 걸어 update
        return jdbcTemplate.update("update schedule set title =?,content =? ,updated_at = ?  where schedule_id =? and password = ?", title, content, LocalDate.now(), id, password);
    }

    @Override
    public int deleteSchedule(Long id) { //DB에 맞는 조건을 걸어 delete
        return jdbcTemplate.update("delete from schedule where schedule_id = ?", id);
    }

    @Override
    public List<UserScheduleResponseDto> findByPage(Paging paging) { //원하는 크기에 따라 보여줄 페이지번호와 보여줄 페이지 크기 DB에 select
        return jdbcTemplate.query("select * from schedule ,user limit ?,?", UserScheduleRowMapper(), (paging.getPage() - 1) * paging.getSize(), paging.getSize());
    }

    @Override
    public int findPassword(Long id, String password) { // 비번이 맞는지 확인하는 기능
        return jdbcTemplate.queryForObject("select count(*) from schedule where schedule_id = ? and password =?", new Object[]{id, password}, Integer.class);
    }


    private RowMapper<UserScheduleResponseDto> UserScheduleRowMapper() {
        return new RowMapper<UserScheduleResponseDto>() {
            @Override
            public UserScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new UserScheduleResponseDto(
                        rs.getLong("schedule_id"),
                        rs.getString("title"),
                        rs.getLong("user_id"),
                        rs.getString("user_name"),
                        rs.getString("content"),
                        rs.getDate("created_at").toLocalDate(),
                        Optional.ofNullable(rs.getDate("updated_at")).map(Date::toLocalDate).orElse(null)

                );
            }
        };
    }


    private RowMapper<Schedule> scheduleIdRowMapper() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("schedule_id"),
                        rs.getString("title"),
                        rs.getLong("user_id"),
                        rs.getString("content"),
                        rs.getString("password"),
                        rs.getDate("created_at").toLocalDate(),
                        Optional.ofNullable(rs.getDate("updated_at")).map(Date::toLocalDate).orElse(null)
                );
            }
        };
    }


    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("schedule_id"),
                        rs.getString("title"),
                        rs.getLong("user_id"),
                        rs.getString("content"),
                        rs.getDate("created_at").toLocalDate(),
                        Optional.ofNullable(rs.getDate("updated_at")).map(Date::toLocalDate).orElse(null)
                );
            }
        };
    }
}
