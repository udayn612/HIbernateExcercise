package com.stackroute.dao;

import com.stackroute.model.User;

public interface LoginDAO {

    public boolean databaseSave(User user);
    public User getUserName(String username);
}
