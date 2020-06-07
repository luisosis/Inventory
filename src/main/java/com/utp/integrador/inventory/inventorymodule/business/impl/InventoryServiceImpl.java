package com.utp.integrador.inventory.inventorymodule.business.impl;

import com.utp.integrador.inventory.inventorymodule.business.InventoryService;
import com.utp.integrador.inventory.inventorymodule.dao.InventoryDao;
import com.utp.integrador.inventory.inventorymodule.dao.UserDao;
import com.utp.integrador.inventory.inventorymodule.model.api.Product;
import com.utp.integrador.inventory.inventorymodule.model.api.User;
import com.utp.integrador.inventory.inventorymodule.model.entity.ProductEntity;
import com.utp.integrador.inventory.inventorymodule.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    @Qualifier("mongodbProducto")
    private InventoryDao inventoryDao;

    @Autowired
    @Qualifier("mongodbUser")
    private UserDao userDao;

    /**
     * Servicio que obtiene toda la lista de productos del inventario
     *
     * @return Lista de productos
     */
    @Override
    public List<Product> getAllProducts() {
        System.out.println("productos: " + inventoryDao.getAllProducts().size());
        return parse(inventoryDao.getAllProducts());
    }


    private List<Product> parse(List<ProductEntity> list) {

        List<Product> listProducts = new ArrayList<>();
        Product product;
        for (ProductEntity p : list) {
            product = com.utp.integrador.inventory.inventorymodule.model.api.Product.builder()
                    .codigo(p.getCodigo())
                    .nomnbre(p.getNombre())
                    .categoria(p.getCategoria())
                    .stock(p.getStock())
                    .precio(p.getPrecio())
                    .build();
            listProducts.add(product);
        }
        return listProducts;
    }

    /**
     * Servicio que obtiene usuarios y los valida
     *
     * @return String username
     */
    @Override
    public User validateUser(User user) {
        return parseToApi(userDao.getUser(user.getUsername()), user);
    }

    private String mapperToApi(UserEntity userEntity) {
        return userEntity.getUsername();
    }

    private User parseToApi(List<UserEntity> userEntities, User user) {

        List<User> list = new ArrayList<>();
        User userReturn = new User();
        for (UserEntity p : userEntities) {
            if (validateUser(p, user)) {
                userReturn = User.builder()
                        .username(p.getUsername())
                        .email(p.getEmail())
                        .name(p.getName())
                        .build();
            }
        }
        return userReturn;
    }

    private Boolean validateUser(UserEntity entity, User user) {
        return entity.getUsername().equals(user.getUsername())
                && entity.getPassword().equals(user.getPassword());
    }
}
