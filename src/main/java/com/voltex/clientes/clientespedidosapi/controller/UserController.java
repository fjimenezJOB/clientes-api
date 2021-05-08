package com.voltex.clientes.clientespedidosapi.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.voltex.clientes.clientespedidosapi.model.User;
import com.voltex.clientes.clientespedidosapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.java.Log;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Log
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestParam( "username") String username, @RequestParam ("password") String pwd){
        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPwd(pwd);
        return new ResponseEntity<User>(userService.insertUser(newUser), HttpStatus.OK);
    }
    
    @PostMapping("/getAutentication")
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String pwd) {

        User userFound = userService.findByUserNameAndPwd(username, pwd);

        if(userFound != null) {
            log.info("User with username: " + username + " AUTENTICATED");
            String token = getJWTToken(username);
            userFound.setToken(token);
            return new ResponseEntity<>(userFound, HttpStatus.OK);
        }else{
            log.info("User with username: " + username + " NOT FOUND");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setId("softtekJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
