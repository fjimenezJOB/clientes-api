package com.voltex.clientes.clientespedidosapi.service;

import java.util.List;

import com.voltex.clientes.clientespedidosapi.dao.UserRepository;
import com.voltex.clientes.clientespedidosapi.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User insertUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User findByUserNameAndPwd(String userName, String pwd){
        return userRepository.findByUserNameAndPwd(userName, pwd);
    }
}
