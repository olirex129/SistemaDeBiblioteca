/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bibliotecaoa.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class Prestamo {
    
    private int codigo;
    private LocalDate fechaDePrestamo;
    private LocalDate fechaDeDevolucion;
    private boolean pedidoHecho;
    private List<Libro> libros;
    
    public Prestamo(){
        this.libros = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaDePrestamo() {
        return fechaDePrestamo;
    }

    public void setFechaDePrestamo(LocalDate fechaDePrestamo) {
        this.fechaDePrestamo = fechaDePrestamo;
    }

    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(LocalDate fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public boolean isPedidoHecho() {
        return pedidoHecho;
    }

    public void setPedidoHecho() {
        this.pedidoHecho = true;
    }
    
    public void agregarLibro(Libro libro){
        this.libros.add(libro);
    }
    
    public List<Libro> getListaLibros(){
    return libros;
} 
    
    // este toString sirve para imprimir bien lo que necesita ver el usuario 

    @Override
    public String toString() {
        if(fechaDeDevolucion==null && fechaDePrestamo==null){
            return "Prestamo{" + "codigo=" + codigo +  ", pedidoHecho=" + pedidoHecho + ", libros=" + libros + '}';
        }
        
        else if(fechaDeDevolucion==null){
            return "Prestamo{" + "codigo=" + codigo + ",fechaDePrestamo= " + fechaDePrestamo + ", pedidoHecho=" + pedidoHecho + ", libros=" + libros + '}';
        }
        else{
        return "Prestamo{" + "codigo=" + codigo + ", fechaDePrestamo=" + fechaDePrestamo + ", fechaDeDevolucion=" + fechaDeDevolucion + ", pedidoHecho=" + pedidoHecho + ", libros=" + libros + '}';
        }
    }
    
    
    
    
    
    
    
}
    