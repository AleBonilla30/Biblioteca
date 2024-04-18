package model;

import java.io.Serializable;

public class LibroTerror extends Libro implements Serializable {
    private int calificacion;

    public LibroTerror() {
    }

    public LibroTerror(String autor, int numPaginas, String ISBN, int calificacion) {
        super(autor, numPaginas, ISBN);
        this.calificacion = calificacion;
    }

    @Override
    public void mostraDatos() {
        super.mostraDatos();
        System.out.println("calificacion: " + calificacion);
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
