package com.utp.integrador.inventory.web;

import com.utp.integrador.inventory.inventorymodule.business.impl.InventoryServiceImpl;
import com.utp.integrador.inventory.inventorymodule.model.api.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryService;

    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE})
    public List<Product> getProducts() {
        return inventoryService.getAllProducts();
    }
}
