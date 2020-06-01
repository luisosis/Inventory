package com.utp.integrador.inventory.inventorymodule.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "Producto")
public class ProductEntity {

    @Id
    private ObjectId _id;

    private String codigo;

    private String nombre;

    private String categoria;

    private int stock;

    private Double precio;
}
