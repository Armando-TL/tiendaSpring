package com.armando.demo;

import com.armando.demo.controller.ProductoController;
import com.armando.demo.dao.ProductoDao;
import com.armando.demo.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorREST {

    @Autowired
    private ProductoDao productoDao;

    @GetMapping("/")
    public String inicio(Model model) {
        List<Producto> productos = productoDao.findAll();
        model.addAttribute("productos", productos);
        return "index";
    }

    @Autowired
    private ProductoController productoController;

    @PostMapping("/crear")
    public String insertProduct(@RequestParam String nombre, @RequestParam int precio, @RequestParam int unidades) {

        productoController.crearProducto(nombre, precio, unidades);

        return "redirect:/"; // Redirige a la página principal 
    }

    @PostMapping("/modificar")
    public String updateProduct(@RequestParam int id, @RequestParam String nombre, @RequestParam int precio, @RequestParam int unidades) {
        productoController.modificarProducto(id, nombre, precio, unidades);
        return "redirect:/"; // Redirige a la página principal 
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam int id) {
        productoController.eliminarProducto(id);
        return "redirect:/";
    }
}
