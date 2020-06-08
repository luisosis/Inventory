package com.utp.integrador.inventory.inventorymodule.business;

import com.utp.integrador.inventory.inventorymodule.model.api.Product;
import com.utp.integrador.inventory.inventorymodule.model.api.ProductSupport;
import com.utp.integrador.inventory.inventorymodule.model.api.User;

import java.util.List;

public interface InventoryService {
    List<Product> getAllProducts();

    User validateUser(User user);

    List<ProductSupport> getProductsSales();
}
