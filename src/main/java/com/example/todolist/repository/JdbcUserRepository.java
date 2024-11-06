package com.example.todolist.repository;

import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcUserRepository implements UserRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public UserResponseDto saveUser(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("userName",user.getUserName());
        parameters.put("email",user.getEmail());
        parameters.put("createdAt",user.getCreatedAt());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new UserResponseDto(key.longValue(),user.getUserName(),user.getEmail(),user.getCreatedAt());
    }
}
