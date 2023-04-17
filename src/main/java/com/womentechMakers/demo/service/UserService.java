package com.womentechMakers.demo.service;

import com.womentechMakers.demo.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAll();
    User update(User user);
    void delete(long id);
}
