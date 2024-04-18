package model;

import utils.Trama;

import java.io.Serializable;

public class LibroPoliciaca extends Libro implements Serializable {
    private Trama trama;
    private String personajes;

    public LibroPoliciaca() {
    }

    public LibroPoliciaca(String autor, int numPaginas, String ISBN, Trama trama, String personajes) {
        super(autor, numPaginas, ISBN);
        this.trama = trama;
        this.personajes = personajes;
    }

    @Override
    public void mostraDatos() {
        super.mostraDatos();
        System.out.println("trama: " + trama);
        System.out.println("personajes: " +personajes);


    }

    public Trama getTrama() {
        return trama;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }

    public String getPersonajes() {
        return personajes;
    }

    public void setPersonajes(String personajes) {
        this.personajes = personajes;
    }
}
