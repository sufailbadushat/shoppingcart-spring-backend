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
    public HashMap<String,String> UserLogin(@RequestBody User user){

        System.out.println(user.getEmailId());
        System.out.println(user.getPassword());

        List<User> result= userDao.LoginUser(user.getEmailId(),user.getPassword());

        HashMap<String,String> hashMap=new HashMap<>();
        if (result.size()==0){
           hashMap.put("status","failed");
           hashMap.put("message","user doesn't exist.");
        }
        else {
            int id=result.get(0).getId();
            hashMap.put("userId",String.valueOf(id));
            hashMap.put("status","success");
        }
        return hashMap;
    }
}
