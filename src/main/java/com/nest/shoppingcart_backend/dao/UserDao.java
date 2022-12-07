package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}
