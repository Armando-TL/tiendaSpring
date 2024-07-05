package com.armando.demo.dao;

// @author armando
import com.armando.demo.model.Producto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {
    
}
