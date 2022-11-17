package com.anhnh.springJWT.service;

import com.anhnh.springJWT.domain.Role;
import com.anhnh.springJWT.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
