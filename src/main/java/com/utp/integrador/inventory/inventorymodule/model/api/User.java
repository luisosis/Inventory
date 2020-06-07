package com.utp.integrador.inventory.inventorymodule.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private String username;

    private String email;

    private String name;

    private String password;

//    private String rol;
}
