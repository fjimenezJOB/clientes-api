package com.voltex.clientes.clientespedidosapi.dao;

import com.voltex.clientes.clientespedidosapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer>{
    
    User findByUserNameAndPwd(String userName, String pwd);
}
