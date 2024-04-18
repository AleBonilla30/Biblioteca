package model;

import java.io.Serializable;

public abstract class Libro implements Serializable {
    private static final long serialVersionUID = 1231243242342l;
    private String autor, ISBN;
    private int numPaginas;

    public Libro() {
    }

    public Libro(String autor, int numPaginas, String ISBN) {
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.ISBN = ISBN;
    }

    public void mostraDatos(){
        System.out.println("◾◾◾◾◾Los datos del libro 📕◾◾◾◾◾");
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Numero de Paginas: " + numPaginas);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
}
