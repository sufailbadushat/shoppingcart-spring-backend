package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {

    @Query(value = "SELECT `id`, `address`, `email_id`, `name`, `password`, `phone_number` FROM `user` WHERE `email_id`=:email_id AND `password`=:password",nativeQuery = true)
    List<User> LoginUser(@Param("email_id") String email_id, @Param("password")String password);
}
