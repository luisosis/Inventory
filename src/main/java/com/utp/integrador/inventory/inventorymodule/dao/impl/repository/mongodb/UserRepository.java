package com.utp.integrador.inventory.inventorymodule.dao.impl.repository.mongodb;

import com.utp.integrador.inventory.inventorymodule.model.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

//    UserEntity findByUserName(final String username);
}
