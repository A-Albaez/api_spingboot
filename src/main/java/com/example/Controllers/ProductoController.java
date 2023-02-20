package com.example.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Models.Productos;
import com.example.Services.*;

@RestController
public class ProductoController {

    @GetMapping("/productos/all")
    public List<Productos> ObtenerTodosProductos(){
        return new ProductosDB().ObtenerProductos();
    }

    @PostMapping("/producto")
    public int InsertarProductos(@RequestBody Productos productos){
        return new ProductosDB().GuardarProductos(productos);
    }

    @PutMapping("/producto")
    public int ActualizarProductos( @RequestBody Productos productos){
        return new ProductosDB().ActualizarProductos(productos);
    }

    @DeleteMapping("/producto/{productoId}")
    public int Delete(@PathVariable("productoId") int id) {
        return new ProductosDB().EliminarProducto(id);
    }

}
