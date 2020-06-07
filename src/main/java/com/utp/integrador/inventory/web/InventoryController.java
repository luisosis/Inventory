package com.utp.integrador.inventory.web;

import com.utp.integrador.inventory.inventorymodule.business.impl.InventoryServiceImpl;
import com.utp.integrador.inventory.inventorymodule.model.api.Product;
import com.utp.integrador.inventory.inventorymodule.model.api.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("inventory")
@AllArgsConstructor
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryService;
    private Object Throwable;

    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE})
    public User validateUser(@RequestBody User userRequest) {
        return inventoryService.validateUser(userRequest);
    }


    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE})
    public List<Product> getProducts() {
        return inventoryService.getAllProducts();
    }

    @GetMapping(value = "/products2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE})
    public String getAllProducts(Model model) {
        model.addAttribute("productos", "hola soy productos");
        return "Productos";
    }


//    @RequestMapping("/")
//    public String index(Model model) {
//        model.addAttribute("list", "prueba");
//        return "index";
//    }
}
