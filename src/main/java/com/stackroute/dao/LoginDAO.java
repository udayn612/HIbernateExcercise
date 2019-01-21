package com.stackroute.dao;

import com.stackroute.model.User;

public interface LoginDAO {

    public boolean addToDatabase(User user);
    public User getUserName(String username);
}
