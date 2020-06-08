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
@Document(value = "Venta")
public class VentaEntity {

    @Id
    private ObjectId _id;

    private String codigo_persona;

    private int cantidad;

    private int tipo_operacion;

    private String codigo_producto;
}
