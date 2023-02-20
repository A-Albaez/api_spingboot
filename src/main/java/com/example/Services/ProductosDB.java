package com.example.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Models.Productos;

public class ProductosDB {
    Connection cn;

    public ProductosDB(){
        cn = new Conexion().OpenDb();
    }

    public List<Productos> ObtenerProductos(){
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM productos";

            List<Productos> productos = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Productos producto = new Productos(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getFloat("precio"),
                    result.getString("fotoUrl"),
                    result.getString("categoria")
                );

                productos.add(producto);
            }
            result.close();
            stmt.close();
            return productos;

        } catch (Exception e) {
            int x = 1;
        }

        return null;
    }

    public int GuardarProductos( Productos producto){
        int resultado = 0;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement( "CALL InsertarProductos(?,?,?,?)");
            ps.setString(1,producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setString(3, producto.getCategoria());
            ps.setString(4, producto.getFoto());

            resultado = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            int x = 1;
        }
        return resultado;
    }

    public int ActualizarProductos( Productos producto){
        int resultado =0;
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement( "CALL ActualizarProductos(?,?,?,?,?)");
            ps.setString(1,producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setString(3, producto.getCategoria());
            ps.setString(4, producto.getFoto());
            ps.setInt(5, producto.getId());

            resultado = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            int x = 1;
        }
        return resultado;
    }

    public int EliminarProducto(int id) {
        int resultado = 0; 
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement("DELETE FROM productos WHERE ID = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            int x = 1;
        }
        return resultado;
    }
}
