package com.utp.integrador.inventory.inventorymodule.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductsNeedProvider {

    private String codigo;
    private int cantidadActual;
    private int stockMinimo;
    private String nombre;
    private Boolean sendAlert;
}
