package com.utp.integrador.inventory.inventorymodule.dao.impl.repository.mongodb;

import com.utp.integrador.inventory.inventorymodule.model.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<ProductEntity,String> {
}
