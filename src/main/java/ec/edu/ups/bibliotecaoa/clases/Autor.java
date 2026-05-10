/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bibliotecaoa.clases;

/**
 *
 * @author olive
 */
public class Autor extends Persona{
    
    private String apellido;
    private String nacionalidad;

    public Autor(String apellido, String nacionalidad) {
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }
    
    public Autor(){
    }

    public Autor(String apellido, String nombre, String nacionalidad, int añoDeNacimiento) {
        super(nombre, añoDeNacimiento);
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\n" +
               "\t" +"Apellido=" + apellido + "\n" +
               "\t" +"Nacionalidad=" + nacionalidad ;
        return resultado;
    }
    
    
    
    
    
    
    
    
}
