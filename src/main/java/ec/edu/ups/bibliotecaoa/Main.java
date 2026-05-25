/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.bibliotecaoa;

import ec.edu.ups.bibliotecaoa.clases.Autor;
import ec.edu.ups.bibliotecaoa.clases.Libro;
import ec.edu.ups.bibliotecaoa.clases.Prestamo;
import ec.edu.ups.bibliotecaoa.clases.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author olive
 */
public class Main {

    public static void main(String[] args) {
        
        
        
        System.out.println("----PEDIDOS DE LIBROS----");
        System.out.println("--Antes de ingresar al menu");
        System.out.println("--Registre su cuenta");
        
        // inicializando el Scanner
        Scanner teclado = new Scanner(System.in);
        
        // creacion de atributos basicos de la cuenta
        
        System.out.println("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese su año de nacimiento: ");
        int añoDeNacimiento = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese su numero de telefono: ");
        String telefono = teclado.nextLine();
        
        // creacion de la cuenta (atributo fuerte del usuario
        System.out.println("-----------------------------------");
        System.out.println("Ingrese su correo: ");
        String correoUsuario = teclado.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contraseñaUsuario = teclado.nextLine();
        
        // inicio de sesion
        
        String correo = null;
        String contraseña = null;
        
        System.out.println("---INICIE SESION---");
        do{
        System.out.println("Ingrese su correo: ");
        correo = teclado.nextLine();
        System.out.println("Ingrese su contraseña: ");
        contraseña = teclado.nextLine();
        if(!correoUsuario.equals(correo)){
            System.out.println("Su correo no existe: ");
        }
        if(!contraseñaUsuario.equals(contraseña)){
            System.out.println("X-Su contraseña o correo es incorrecto-X");
        }
        }while(!correoUsuario.equals(correo) || !contraseñaUsuario.equals(contraseña));
        
        //creacion del usuario solo con atributos basicos y cuenta
        
        System.out.println("Cuenta creada e iniciada correctamente");
        
        Usuario usuario = new Usuario(nombre,añoDeNacimiento,telefono,correoUsuario,contraseñaUsuario);
        
        int menu = 0;
        
        // Variables que deben de estar creadas afuera del while para que existan fuera de esta

        List<Libro> librosEnExistencia = new ArrayList<>();
        Prestamo prestamo = new Prestamo();
        prestamo.setCodigo(1);
        
        
        // creacion de autores para los libros
        
        Autor stephen = new Autor("King", "Stephen", "Estadounidense", 1947);
        Autor jane = new Autor("Austen", "Jane", "Britanica", 1775);
        Autor miguel = new Autor("deCervantes", "Miguel", "Español", 1547);
        
        // creacion de los libros en existencia 
        
        // Libros con el autor Stepen King
        
        librosEnExistencia.add(new Libro("978-1-5011-4351-9", "It", 1986, "Terror", true, "Viking", stephen));
        librosEnExistencia.add(new Libro("978-0-345-80348-1", "ElResplandor", 1977, "Terror", true, "Doubleday", stephen));
        librosEnExistencia.add(new Libro("978-1-9821-7361-6", "Misery", 1987, "Suspenso", false, "Viking", stephen));

        // Libros con el autor Jane Austen
        
        librosEnExistencia.add(new Libro("978-0-14-143951-8", "OrgulloYPrejuicio", 1813, "Romance", true, "T. Egerton", jane));
        librosEnExistencia.add(new Libro("978-0-14-143958-7", "Emma", 1815, "Comedia", true, "John Murray", jane));

        // Libros con el autor Miguel de Cervantes
        
        librosEnExistencia.add(new Libro("978-8-42-041214-6", "DonQuijotedelaMancha", 1605, "Clasico", true, "Juan de la Cuesta", miguel));
        
        do{
            System.out.println("----Menu----");
            System.out.println("1. Ver que libros estan en existencia");
            System.out.println("2. Ingresar un libro a tu pedido ");
            System.out.println("3. Ver que tienes en tu prestamo");
            System.out.println("4. Hacer el prestamo");
            System.out.println("5. Hacer una devolucion");
            System.out.println("6. Salir");
            menu = teclado.nextInt();
            switch(menu){
                
                //ver que libros se pueden prestar
                
                case 1:
                    for (Libro libro : librosEnExistencia) {
                        System.out.println(libro);
                        System.out.println();
                    }
                    break;
                    
                // añadir los/el libro que quiera pedir el usuario    
                case 2:
                    
                    if(!prestamo.isPedidoHecho()){
                    
                    boolean pedirOtro = false;
                    
                    do{
                        // El menu
                        System.out.println("--Ingrese el titulo del libro y su autor para ingresar su libro al prestamo--");
                        System.out.println("-Ingrese el titulo del libro buscado: ");
                        String tituloBuscado = teclado.next();
                        System.out.println("-Ingrese el nombre del autor del libro buscado: ");
                        String nombreDelAutorBuscado = teclado.next();
                        
                        // Se busca el libro por titulo y nombre del autor
                        
                        
                        Libro.buscarLibro(librosEnExistencia, tituloBuscado, nombreDelAutorBuscado, prestamo);
                        
                        System.out.println("¿Quiere pedir otro libro?");
                        System.out.print("true/false: ");
                        pedirOtro = teclado.nextBoolean();
                        
                    }while(pedirOtro);
                    }
                    else{
                        System.out.println("No puede volver a pedir otro prestamo ya realizado");
                    }
                    
                    break;
                    
                    // revisar que se tiene en el pedido
                    
                case 3:
                    if(prestamo.getListaLibros().size()==0){
                        System.out.println("      !!ERROR!!");
                        System.out.println("Aun no ha agragado nada al prestamo");
                        System.out.println("o devolvio todos los libros prestados");
                    }
                    else{
                        System.out.println(prestamo);
                    }
                    break;
                    
                    // Hacer el prestamo
                    
                case 4:
                    if(prestamo.getListaLibros().size()==0){
                        System.out.println("       !!ADVERTENCIA!!");
                        System.out.println("No puede hacer el prestamo si no a añadido ningun libro");
                    }
                    else{
                        if(!prestamo.isPedidoHecho()){
                            LocalDate fechaDePrestamo = LocalDate.now(); 
                            prestamo.prestamoHecho(fechaDePrestamo);
                            usuario.añadirPrestamo(prestamo);
                            System.out.println("// Su prestamo esta hecho //");
                        }
                        else{
                            System.out.println("// Ya hizo su pedido //");
                        }
                    }
                    break;
                    
                    // devolucion
                    
                case 5:
                    System.out.println("--Que libro quiere devolver?");
                    System.out.println("Titulo del libro: ");
                    String libroDevolver = teclado.next();
                    System.out.println("Nombre del autor: ");
                    String libroDevolverAutor = teclado.next();
                    
                    Libro.devolverLibro(librosEnExistencia, libroDevolver, libroDevolverAutor, prestamo);
                    
                    break;
            }
            
        }while(menu!=6);
        
        
        
        
        
        
       
    
    }
}

