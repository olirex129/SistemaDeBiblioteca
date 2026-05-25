/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bibliotecaoa.clases;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author olive
 */
public class Libro {
    
    // ISBN en String porque este tiene - en su composicion de 13 numeros
    private String ISBN;
    private String titulo;
    private int añoDePublicacion;
    private String genero;
    private boolean disponible;
    private String editorial;
    private Autor autor;
    
    public Libro(){
    }

    public Libro(String ISBN, String titulo, int añoDePublicacion, String genero, boolean disponible, String editorial) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.añoDePublicacion = añoDePublicacion;
        this.genero = genero;
        this.disponible = disponible;
        this.editorial = editorial;
    }

    public Libro(String ISBN, String titulo, int añoDePublicacion, String genero, boolean disponible, String editorial, Autor autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.añoDePublicacion = añoDePublicacion;
        this.genero = genero;
        this.disponible = disponible;
        this.editorial = editorial;
        this.autor = autor;
    }
    
    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoDePublicacion() {
        return añoDePublicacion;
    }

    public void setAñoDePublicacion(int añoDePublicacion) {
        this.añoDePublicacion = añoDePublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro" + "\n" +
               "-ISBN:" + ISBN + "\n" +
               "-Titulo: " + titulo + "\n" +
               "-Año de publicacion: " + añoDePublicacion + "\n" +
               "-Genero: " + genero + "\n" +
               "-Disponible: " + disponible + "\n" +
               "-Editorial: " + editorial + "\n" +
               "-Autor: " + autor ;
    }
    
    public void reservarLibro(){
        this.disponible = false;
    }
    
    public void devolverLibro(){
        this.disponible = true;
    }
    
    public static void buscarLibro(List<Libro> librosEnExistencia,String tituloBuscado,String nombreDelAutorBuscado,Prestamo prestamo){
        
        boolean seEncontro = false;
                        
                        for (Libro libro : librosEnExistencia){
                            
                            if(tituloBuscado.equalsIgnoreCase(libro.getTitulo()) && nombreDelAutorBuscado.equalsIgnoreCase(libro.getAutor().getNombre())){
                                
                                if(!libro.isDisponible()){
                                    System.out.println("X-Su libro no esta disponible-X");
                                }
                                else{
                                    prestamo.agregarLibro(libro);
                                    System.out.println("Se a añadido el libro: " + libro.getTitulo());
                                    libro.reservarLibro();
                                }
                                seEncontro = true;
                                
                            }
                        }
                        if(!seEncontro){
                                System.out.println("!!No se pudo encontrar su libro");
                            }
    }
    
    public static void devolverLibro(List<Libro> librosEnExistencia,String libroDevolver, String libroDevolverAutor,Prestamo prestamo){
        boolean existeLibro = false;
                    for (Libro libro : librosEnExistencia){
                        
                        
                            
                            if(libroDevolver.equalsIgnoreCase(libro.getTitulo()) && libroDevolverAutor.equalsIgnoreCase(libro.getAutor().getNombre())){
                                
                                existeLibro=true;
                                
                                if(libro.isDisponible()){
                                    System.out.println("!!No puede devolver un libro que está disponible");
                                }
                                else{
                                    System.out.println("Se a devuelto el libro: " + libro.getTitulo());
                                    libro.devolverLibro();
                                    LocalDate fechaDeDevolucion = LocalDate.now();
                                    prestamo.setFechaDeDevolucion(fechaDeDevolucion);
                                    
                                }
                                Libro libroRemover = null;
                                if(prestamo.getListaLibros().size()!=0){
                                    for(Libro libro1 : prestamo.getListaLibros()){
                                        if(libro1.equals(libro)){
                                            libroRemover = libro1;
                                        }
                                        
                                    }
                                    prestamo.getListaLibros().remove(libroRemover);
                                }
                                
                            }
                    
                
                    }
                    if(!existeLibro){
                        System.out.println("             !!ERROR!!");
                        System.out.println("El titulo del libro o el autor no existen");
                    }
    }
    
    
    
}
