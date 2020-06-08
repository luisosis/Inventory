package com.utp.integrador.inventory.inventorymodule.dao.impl.repository.mongodb;

import com.utp.integrador.inventory.inventorymodule.model.entity.VentaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends MongoRepository<VentaEntity, String> {

//    UserEntity findByUserName(final String username);
}
