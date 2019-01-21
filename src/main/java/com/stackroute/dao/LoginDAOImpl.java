package com.stackroute.dao;

import com.stackroute.model.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public LoginDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean databaseSave(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserName(String username) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, username);
        Hibernate.initialize(user);
        return user;
    }


}
