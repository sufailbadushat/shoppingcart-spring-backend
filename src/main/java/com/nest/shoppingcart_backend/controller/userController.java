package com.nest.shoppingcart_backend.controller;


import com.nest.shoppingcart_backend.dao.UserDao;
import com.nest.shoppingcart_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class userController {

    @Autowired
    UserDao userDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addUser" ,consumes = "application/json", produces = "application/json")
    public Map<String, String> addUser(@RequestBody User user){

        userDao.save(user);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return (hashMap);

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginUser" ,consumes = "application/json", produces = "application/json")
    public List<User> UserLogin(@RequestBody User user){
        String username=String.valueOf(user.getEmailId());
        String password=String.valueOf((user.getPassword()));
        System.out.println(username);
        System.out.println(password);

        return (List<User>) userDao.LoginUser(user.getEmailId(),user.getPassword());
    }
}
