package com.armando.demo.controller;
// @author armando

import com.armando.demo.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class ProductoController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearProducto(String nombre, int precio, int existencia) {
        entityManager.persist(new Producto(nombre, precio, existencia));
    }

    @Transactional
    public void eliminarProducto(int id) {
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
        }

    }

    @Transactional
    public void modificarProducto(int id, String nombre, int precio, int existencia) {
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setExistencia(existencia);
            entityManager.merge(producto);
        }
    }

//    input[type=number]::-webkit-inner-spin-button,
//            input[type=number]::-webkit-outer-spin-button {
//                -webkit-appearance: none;
//                margin: 0;
//            }
//
//            input[type=number] {
//                -moz-appearance:textfield;
//            }
//    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCIA");
//    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
//    private EntityTransaction transaction = null;
//
//    public void crearProducto(String nombre, double precio, int existencia) {
//
//        try {
//            transaction = entityManager.getTransaction();
//
//            transaction.begin();
//
//            entityManager.persist(new Producto(nombre, precio, existencia));
//            transaction.commit();
//
//        } catch (RollbackException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//
//    }
}
