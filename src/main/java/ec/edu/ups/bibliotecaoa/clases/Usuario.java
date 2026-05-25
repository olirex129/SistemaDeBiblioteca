/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bibliotecaoa.clases;

/**
 *
 * @author oliver v
 */
public class Usuario extends Persona{
    
    private String telefono;
    
    private Cuenta cuenta;
    private Prestamo prestamo;

    public Usuario(String telefono, Cuenta cuenta) {
        this.telefono = telefono;
        this.cuenta = cuenta;
    }
    
    public Usuario(){
    }

    public Usuario(String nombre, int añoDeNacimiento,String telefono,String cuenta,String contraseña) {
        super(nombre, añoDeNacimiento);
        this.telefono = telefono;
        this.cuenta = new Cuenta(cuenta,contraseña);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
    
    //metodo

    public void añadirPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "telefono=" + telefono + ", cuenta=" + cuenta + ", prestamo=" + prestamo + '}';
    }

    
    
    
    
    
    
    
    
    
    
}
