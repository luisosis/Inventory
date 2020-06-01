package com.utp.integrador.inventory.inventorymodule.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private String codigo;
    private String nomnbre;
    private String categoria;
    private int stock;
    private Double precio;
}
