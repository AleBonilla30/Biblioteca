package model;

import utils.TipoHumor;

import java.io.Serializable;

public class LibroComedia extends Libro implements Serializable {
    private TipoHumor tipoHumor;

    public LibroComedia() {
    }

    public LibroComedia(String autor, int numPaginas, String ISBN, TipoHumor tipoHumor) {
        super(autor, numPaginas, ISBN);
        this.tipoHumor = tipoHumor;
    }

    @Override
    public void mostraDatos() {
        super.mostraDatos();
        System.out.println("Tipo de Humor: " + tipoHumor);
    }

    public TipoHumor getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(TipoHumor tipoHumor) {
        this.tipoHumor = tipoHumor;
    }
}
