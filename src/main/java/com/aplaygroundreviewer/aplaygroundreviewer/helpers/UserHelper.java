package com.aplaygroundreviewer.aplaygroundreviewer.helpers;

import com.aplaygroundreviewer.aplaygroundreviewer.models.dao.UserDao;
import com.aplaygroundreviewer.aplaygroundreviewer.models.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class UserHelper {
    @Autowired
    UserDao userDao;

    public boolean isCredentialsValid(User user){
        List<User> userList = (List<User>) userDao.findAll();

        if (userList.contains(user)){
                return true;
        }
        return false;
    }
}
