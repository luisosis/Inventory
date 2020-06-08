package com.utp.integrador.inventory.inventorymodule.dao.impl;

import com.utp.integrador.inventory.inventorymodule.dao.VentaDao;
import com.utp.integrador.inventory.inventorymodule.dao.impl.repository.mongodb.VentaRepository;
import com.utp.integrador.inventory.inventorymodule.model.entity.VentaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaDaoImpl implements VentaDao {

    @Autowired
    private VentaRepository ventaRepository;


    @Override
    public List<VentaEntity> getAllVentas() {
        return ventaRepository.findAll();
    }
}
