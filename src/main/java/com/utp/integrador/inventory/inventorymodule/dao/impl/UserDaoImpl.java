package com.utp.integrador.inventory.inventorymodule.dao.impl;

import com.utp.integrador.inventory.inventorymodule.dao.UserDao;
import com.utp.integrador.inventory.inventorymodule.dao.impl.repository.mongodb.UserRepository;
import com.utp.integrador.inventory.inventorymodule.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("mongodbUser")
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getUser(String username) {
//        System.out.println("usuario Repositorio: " + userRepository.findAll().size());
        return userRepository.findAll();
    }
}
