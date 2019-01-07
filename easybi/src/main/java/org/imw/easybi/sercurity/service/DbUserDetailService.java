package org.imw.easybi.sercurity.service;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbUserDetailService extends JdbcDaoImpl {
    @Override
    protected List<UserDetails> loadUsersByUsername(final String username) {
        this.setAuthoritiesByUsernameQuery("");
        return this.getJdbcTemplate().query(super.getUsersByUsernameQuery(), new String[]{username}, new RowMapper<UserDetails>() {
            @Override
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;
            }
        });
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List<GrantedAuthority> combinedAuthorities) {
        return userFromUserQuery;
    }
}
