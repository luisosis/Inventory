package com.utp.integrador.inventory.inventorymodule.business;

import com.utp.integrador.inventory.inventorymodule.model.api.Product;

import java.util.List;

public interface InventoryService {
    List<Product> getAllProducts();
}
