package com.utp.integrador.inventory.inventorymodule.business.impl;

import com.utp.integrador.inventory.inventorymodule.business.InventoryService;
import com.utp.integrador.inventory.inventorymodule.dao.InventoryDao;
import com.utp.integrador.inventory.inventorymodule.model.api.Product;
import com.utp.integrador.inventory.inventorymodule.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("productos: " + inventoryDao.getAllProducts().size());
        return parse(inventoryDao.getAllProducts());
    }

    private List<Product> parse(List<ProductEntity> list) {

        List<Product> listProducts = new ArrayList<>();
        Product product;
        for (ProductEntity p : list) {
            product = com.utp.integrador.inventory.inventorymodule.model.api.Product.builder()
                    .codigo(p.getCodigo())
                    .nomnbre(p.getNombre())
                    .categoria(p.getCategoria())
                    .stock(p.getStock())
                    .precio(p.getPrecio())
                    .build();
            listProducts.add(product);
        }
        return listProducts;
    }
}
