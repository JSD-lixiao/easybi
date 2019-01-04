package org.imw.easybi.service;

import org.imw.easybi.dao.UserDao;
import org.imw.easybi.pojo.User;
import org.imw.easybi.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) {
        UUID uuid = UUID.randomUUID();
        user.setActivationCode(uuid.toString());
        user.setStatus("0");
        MailUtil.send_mail(user);
        return userDao.save(user);
    }
}
