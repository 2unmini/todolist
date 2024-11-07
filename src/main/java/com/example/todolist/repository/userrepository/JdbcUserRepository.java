package com.example.todolist.repository.userrepository;

import com.example.todolist.dto.user.UserRequestDto;
import com.example.todolist.dto.user.UserResponseDto;
import com.example.todolist.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) { // application.properties에서 설정한 Datasource 가져와 JDBCTemplate의 주입
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public UserResponseDto saveUser(User user) { // DB에 INSERT
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_name", user.getUserName());
        parameters.put("email", user.getEmail());
        parameters.put("createdAt", user.getCreatedAt());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new UserResponseDto(key.longValue(), user.getUserName(), user.getEmail(), user.getCreatedAt());
    }

    @Override
    public Optional<User> findUserById(Long id) { //DB에 맞는 조건을 걸어 select
        List<User> userList = jdbcTemplate.query("select * from user where user_id = ?", userRowMapper(), id);
        return userList.stream().findAny();
    }

    @Override
    public int updateById(Long id, UserRequestDto userRequestDto) { //DB에 맞는 조건을 걸어 update
        return jdbcTemplate.update("update user set user_name = ?, email =? where user_id =?", userRequestDto.getUserName(), userRequestDto.getEmail(), id);
    }

    private RowMapper<User> userRowMapper() {
        return new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(
                        rs.getLong("user_id"),
                        rs.getString("user_name"),
                        rs.getString("email"),
                        rs.getDate("created_at").toLocalDate(),
                        Optional.ofNullable(rs.getDate("updated_at")).map(Date::toLocalDate).orElse(null)
                );
            }
        };
    }


}
