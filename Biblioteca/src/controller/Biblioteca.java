package controller;

import model.Libro;
import utils.CatalogoException;
import utils.CatalogoNoexisteException;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca <L extends Libro> implements Serializable {
    private static final long serialVersionUID = 1231243242342l;
    Scanner scanner = new Scanner(System.in);
    private String nombre, director;
    private Catalogo catalogo;


    public Biblioteca() {

    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }
    public void mostrarDatosBiblioteca(){
        System.out.println();
        System.out.println("Los datos de la biblioteca \uD83C\uDFEB");
        System.out.println("Nombre: " + nombre);
        System.out.println("Director: " + director);
        System.out.println();
    }
    public void construirCatalogoLibros(int numLibros){
            this.catalogo = new Catalogo(numLibros);

    }
    public void consultarEspacio(){
        catalogo.espacioDisponible();
    }
    public int consultarNumeroLibros(){
        return catalogo.ConsultarNumLibros();
    }
    public void agregarLibrosCatalogo(L libro) {
        try{
            if (catalogo == null){
                throw  new CatalogoNoexisteException("El catálogo no existe en la Biblioteca 📂");


            }  else {
                catalogo.agregarLibros(libro);
            }

            }catch (CatalogoNoexisteException  e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", 0);
            scanner.nextLine();
          } catch (CatalogoException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", 0);
        }

    }
    public void ficheroExportar(){
        catalogo.exportarFichero();
    }

    public void listarLibrosCatalogo(){
        catalogo.listaLibros();
        }


    public void sacarLibros(){
        try {
            catalogo.sacarLibro();
        }catch (CatalogoException e){
           JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }
    public void buscarLibro(){
        try {
            catalogo.buscarInfoLibro();
        }catch (CatalogoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    class Catalogo {
        private int maximoLibros;
        private ArrayList<L> listaLibros;

        public Catalogo(int maximoLibros) {
            this.maximoLibros = maximoLibros;
            listaLibros = new ArrayList<>();
        }

        public void construirCatalogo(int maximoLibros)  {
            this.maximoLibros = maximoLibros;
        }

        public int ConsultarNumLibros() {
            int resultado = listaLibros.size();
            System.out.println();
            System.out.println("El numero de libros en el catalogo es 📚: "+resultado);
            return resultado;
        }
        public int espacioDisponible(){
            int resultado = maximoLibros - listaLibros.size();
            System.out.println();
            System.out.println("Espacio disponible en el catálogo 📂: "+resultado);
            return resultado;
        }

        public void agregarLibros(L libro) throws CatalogoException {
            int espacioDisponible = espacioDisponible();
             if (estaLibro(libro.getISBN()) != null ){
                throw new CatalogoException("El libro con ISBN "+libro.getISBN()+" ya esta en el catálogo ❌");

            }  else if ( espacioDisponible <= 0 ) {
                throw new CatalogoException("El catalogo está lleno, no hay espacio disponible ❌");

            } else {
                listaLibros.add(libro);
                System.out.println("Libro agregado correctamente ✔\uFE0F📕");
            }

        }
        public void exportarFichero(){
            ObjectOutputStream fichero = null;
            File file = new File("src/resource/Libro.obj");
            try {
                fichero = new ObjectOutputStream(new FileOutputStream(file));
                for (L libros:listaLibros) {
                    fichero.writeObject(libros);
                    JOptionPane.showMessageDialog(null,"Catalogo exportado correctamente ✔📂","Escribiendo",0);
                }
            } catch (IOException e) {

                JOptionPane.showMessageDialog(null,"Error al exportar el catalogo ❌ " +e.getMessage(),"Error",0);
            }finally {
                try {
                    fichero.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"Error en el cerrado ❌ " +e.getMessage(),"Error", 0);
                }catch (NullPointerException e){
                    JOptionPane.showMessageDialog(null, "Cerrado en nulo "+e.getMessage(), "Error",0);
                }
            }

        }

        public Libro estaLibro(String isbn) {
            for (L libro : listaLibros) {
                if (libro.getISBN().equals(isbn)) {
                    return libro;
                }
            }
            return null;
        }

        public void sacarLibro() throws CatalogoException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el ISBN del libro que deseas borrar 🗑: ");
            String isbnABorrar= scanner.nextLine();
            boolean encontrado = false;
            for (L libro : listaLibros) {
                if (libro.getISBN().equalsIgnoreCase(isbnABorrar)) {
                    listaLibros.remove(libro);
                    System.out.println("Libro eliminado correctamente ❌📗");
                    encontrado = true;
                    break;

                }
            }
            if (!encontrado) {
                throw new CatalogoException("Error no se puede borrar el libro, no se encuentra en el catalogo ❌");
            }
        }

        public void listaLibros(){
            for (L item:listaLibros) {
                System.out.println();
                System.out.println("◆ Libro en el catálogo ◆ ");
                item.mostraDatos();
                System.out.println();
            }
        }

        public void buscarInfoLibro() throws CatalogoException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el ISBN de el libro que deseas buscar 📝: ");
            String isbnBuscado = scanner.nextLine();
            boolean buscar = false;
            for (L item : listaLibros) {
                if (item.getISBN().equalsIgnoreCase(isbnBuscado)) {
                    buscar = true;
                    item.mostraDatos();
                    break;
                }
            }
            if (!buscar){
                throw new CatalogoException("El libro con ISBN "+isbnBuscado+" no se encuentra en el catalogo ❌");
            }
        }
    }
}
