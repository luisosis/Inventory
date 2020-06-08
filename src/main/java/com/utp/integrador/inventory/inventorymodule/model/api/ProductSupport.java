package com.utp.integrador.inventory.inventorymodule.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductSupport {

    private String codigo;
//    private String nombre;
    private int cantidadVendida;
}
