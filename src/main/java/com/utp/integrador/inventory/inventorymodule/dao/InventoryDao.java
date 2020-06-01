package com.utp.integrador.inventory.inventorymodule.dao;

import com.utp.integrador.inventory.inventorymodule.model.entity.ProductEntity;

import java.util.List;

public interface InventoryDao {

    List<ProductEntity> getAllProducts();
}
