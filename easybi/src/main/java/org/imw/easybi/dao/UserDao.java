package org.imw.easybi.dao;

import org.imw.easybi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {

   User findByUsername(String username);
}
