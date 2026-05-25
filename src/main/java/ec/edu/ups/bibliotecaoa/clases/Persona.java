/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bibliotecaoa.clases;

/**
 *
 * @author oliver v
 */
public class Persona {
    //
    private String nombre;
    
    private int añoDeNacimiento;

    public Persona(){
    }
    
    public Persona(String nombre, int añoDeNacimiento) {
        this.nombre = nombre;
        this.añoDeNacimiento = añoDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoDeNacimiento() {
        return añoDeNacimiento;
    }

    public void setAñoDeNacimiento(int añoDeNacimiento) {
        this.añoDeNacimiento = añoDeNacimiento;
    }

    @Override
    public String toString() {
        return  
                "\n" + "\t" +"Nombre=" + nombre + "\n" +
                "\t" + "AñoDeNacimiento=" + añoDeNacimiento ;
    }   
    
    
}
