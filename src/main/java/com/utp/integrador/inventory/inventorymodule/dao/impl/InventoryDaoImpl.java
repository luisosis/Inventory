package com.utp.integrador.inventory.inventorymodule.dao.impl;

import com.utp.integrador.inventory.inventorymodule.dao.InventoryDao;
import com.utp.integrador.inventory.inventorymodule.dao.impl.repository.mongodb.InventoryRepository;
import com.utp.integrador.inventory.inventorymodule.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<ProductEntity> getAllProducts() {
        System.out.println("productos Repositorio: " + inventoryRepository.findAll().size());
        return inventoryRepository.findAll();
    }
}
