package com.ak.kick.service;

import com.ak.kick.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ak on 7/6/17.
 */
@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getList(){
        String sql = "select id, name, password, age from user";

        return jdbcTemplate.query(sql, (RowMapper<User>) (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getNString("name"));
            user.setAge(rs.getInt("age"));
            user.setPassword(rs.getString("password"));
            return user;
        });

    }


}
