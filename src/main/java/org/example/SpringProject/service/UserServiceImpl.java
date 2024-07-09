package org.example.SpringProject.service;

import org.example.SpringProject.dao.UserDao;
import org.example.SpringProject.dao.UserDaoImpl;
import org.example.SpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers(int count) {
        return userDao.getUsers(count);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
