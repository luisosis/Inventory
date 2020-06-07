package com.utp.integrador.inventory.inventorymodule.dao;

import com.utp.integrador.inventory.inventorymodule.model.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> getUser(String username);
}
