package org.imw.easybi.controller;

import org.imw.easybi.dao.UserDao;
import org.imw.easybi.pojo.User;
import org.imw.easybi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        return userService.add(user);
    }
    @DeleteMapping("deleteUser")
    public void deleteUser(String id){
        userDao.deleteById(id);
    }

    @PostMapping("getClient")
    public Object getClient(){
        logger.info("getClient has runned");
        logger.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
       return SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }
}
