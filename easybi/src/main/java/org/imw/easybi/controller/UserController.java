package org.imw.easybi.controller;

import org.imw.easybi.dao.UserDao;
import org.imw.easybi.pojo.User;
import org.imw.easybi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    private final  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        logger.info(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword().trim()));
        user.setRoles("ROLE_USER");
        return userService.add(user);
    }
    @DeleteMapping("deleteUser")
    public void deleteUser(String id){
        userDao.deleteById(id);
    }
}
