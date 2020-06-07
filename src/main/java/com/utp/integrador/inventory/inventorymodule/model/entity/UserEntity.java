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
@Document(value = "Usuario")
public class UserEntity {

    @Id
    private ObjectId _id;

    private String username;

    private String password;

    private String email;

    private String name;
}
