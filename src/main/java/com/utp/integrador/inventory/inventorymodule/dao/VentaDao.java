package com.utp.integrador.inventory.inventorymodule.dao;

import com.utp.integrador.inventory.inventorymodule.model.entity.UserEntity;
import com.utp.integrador.inventory.inventorymodule.model.entity.VentaEntity;

import java.util.List;

public interface VentaDao {

    List<VentaEntity> getAllVentas();
}
