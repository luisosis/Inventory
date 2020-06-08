package com.utp.integrador.inventory.inventorymodule.business.impl;

import com.utp.integrador.inventory.inventorymodule.business.InventoryService;
import com.utp.integrador.inventory.inventorymodule.dao.InventoryDao;
import com.utp.integrador.inventory.inventorymodule.dao.UserDao;
import com.utp.integrador.inventory.inventorymodule.dao.VentaDao;
import com.utp.integrador.inventory.inventorymodule.model.api.Product;
import com.utp.integrador.inventory.inventorymodule.model.api.ProductSupport;
import com.utp.integrador.inventory.inventorymodule.model.api.User;
import com.utp.integrador.inventory.inventorymodule.model.entity.ProductEntity;
import com.utp.integrador.inventory.inventorymodule.model.entity.UserEntity;
import com.utp.integrador.inventory.inventorymodule.model.entity.VentaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    @Qualifier("mongodbProducto")
    private InventoryDao inventoryDao;

    @Autowired
    @Qualifier("mongodbUser")
    private UserDao userDao;

    @Autowired
    private VentaDao ventaDao;

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
                    .nombre(p.getNombre())
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

    /**
     * Obtiene los productos mas vendidos y menos vendidos
     *
     * @return lista de dos productos
     */
    @Override
    public List<ProductSupport> getProductsSales() {
        return parseToApiVenta(ventaDao.getAllVentas());
    }

    private List<ProductSupport> parseToApiVenta(List<VentaEntity> entities) {

        List<Product> listaProductos = parse(inventoryDao.getAllProducts());

        String codigos[] = new String[listaProductos.size()];
        int i = 0;
        for (Product product : listaProductos) {
            codigos[i] = product.getCodigo();
            i++;
        }

        List<ProductSupport> listaProductosSupport = new ArrayList<>();
        Set<String> setCodigos = new HashSet<>();
        ProductSupport productSupport;
        for (VentaEntity venta : entities) {
            productSupport = ProductSupport.builder()
                    .codigo(venta.getCodigo_producto())
                    .cantidadVendida(showOutput(venta))
//                    .nombre(getName(venta, listaProductos))
                    .build();
            listaProductosSupport.add(productSupport);
            setCodigos.add(venta.getCodigo_producto());
        }

        Map<Integer, String> mapCodesAuxiliar = new HashMap<>();
        int cont = 0;
        for (String m : setCodigos) {
            mapCodesAuxiliar.put(cont, m);
            cont++;
        }

        /*procesamiento de data*/
        int sumaCantidadAuxiliar;
        List<ProductSupport> listaProductosSupportAuxiliar = new ArrayList<>();
        ProductSupport productSupportAuxiliar;

        for (int j = 0; j < mapCodesAuxiliar.size(); j++) {
            sumaCantidadAuxiliar = 0;
            for (int l = 0; l < listaProductosSupport.size(); l++) {

                if (mapCodesAuxiliar.get(j).equals(listaProductosSupport.get(l).getCodigo())) {
                    sumaCantidadAuxiliar = sumaCantidadAuxiliar + listaProductosSupport.get(l).getCantidadVendida();
                }

                if (l == (listaProductosSupport.size() - 1)) {
                    productSupportAuxiliar = ProductSupport.builder()
                            .codigo(mapCodesAuxiliar.get(j))
                            .cantidadVendida(sumaCantidadAuxiliar)
//                            .nombre(listaProductosSupport.get(l).getNombre())
                            .build();
                    listaProductosSupportAuxiliar.add(productSupportAuxiliar);
                }
            }
        }
        return listaProductosSupportAuxiliar;
    }

    private int showOutput(VentaEntity ventaEntity) {
        int cantidad = 0;
        if (ventaEntity.getTipo_operacion() == 1) {
            cantidad = ventaEntity.getCantidad();
        }
        return cantidad;
    }

//    private String getName(VentaEntity ventaEntity, List<Product> listaProductos) {
//        String name = null;
//        for (Product p : listaProductos) {
//            System.out.println("afuera : " + p.getNombre());
//            if (ventaEntity.getCodigo_producto().equals(p.getCodigo())) {
//                System.out.println("adentro equals : " + p.getNombre());
//                name = p.getNombre();
//            }
//        }
//        return name;
//    }
}
