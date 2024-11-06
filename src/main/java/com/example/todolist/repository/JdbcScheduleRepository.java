package com.example.todolist.repository;

import com.example.todolist.dto.ScheduleResponseDto;
import com.example.todolist.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

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

    public JdbcScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("schedule_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", schedule.getTitle());
        parameters.put("userName", schedule.getUserName());
        parameters.put("content", schedule.getContent());
        parameters.put("password", schedule.getPassword());
        parameters.put("createdAt", schedule.getCreatedAt());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ScheduleResponseDto(key.longValue(), schedule.getTitle(), schedule.getUserName(), schedule.getContent(), schedule.getCreatedAt());

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        return jdbcTemplate.query("select * from schedule ", scheduleRowMapper());


    }

    @Override
    public Optional<Schedule> findScheduleById(Long id) {
        List<Schedule> result = jdbcTemplate.query("select * from schedule where schedule_id = ?", scheduleRowMapper2(), id);
        return result.stream().findAny();
    }

    @Override
    public int  updateSchedule(Long id, String title ,String userName, String content, String password) {
         return jdbcTemplate.update("update schedule set title =?, username = ?,content =? ,updated_at = ?  where schedule_id =? and password = ?",title,userName,content, LocalDate.now(),id,password);
    }

    @Override
    public void deleteSchedule(Long id ,String password) {
        jdbcTemplate.update("delete from schedule where schedule_id = ? and password = ?" ,id,password);
    }


    private RowMapper<Schedule> scheduleRowMapper2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("schedule_id"),
                        rs.getString("title"),
                        rs.getString("username"),
                        rs.getString("content"),
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
                        rs.getString("username"),
                        rs.getString("content"),
                        rs.getDate("created_at").toLocalDate(),
                        Optional.ofNullable(rs.getDate("updated_at")).map(Date::toLocalDate).orElse(null)
                );
            }
        };
    }
}
