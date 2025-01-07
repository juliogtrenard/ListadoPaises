package es.juliogtrenard.listadopaises.model;

import java.util.Objects;

/**
 * Clase con informacion de un pais
 */
public class Pais {
    /**
     * ID del pais
     */
    private int id;

    /**
     * Nombre del pais
     */
    private String pais;

    /**
     * Capital del pais
     */
    private String capital;

    /**
     * Numero de habitantes
     */
    private int num_habitantes;

    /**
     * Constructor con sus parametros
     *
     * @param id Identificador del país
     * @param pais nombre del país
     * @param capital Capital del país
     * @param num_habitantes Numero de habitantes del país
     */
    public Pais(int id, String pais, String capital, int num_habitantes) {
        this.id = id;
        this.pais = pais;
        this.capital = capital;
        this.num_habitantes = num_habitantes;
    }

    /**
     * Constructor vacio
     */
    public Pais() {}

    /**
     * Getter para ID del país
     *
     * @return id del país
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para ID del país
     *
     * @param id nueva id del país
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para el nombre del país
     *
     * @return nombre del país
     */
    public String getPais() {
        return pais;
    }

    /**
     * Setter para el nombre del país
     *
     * @param pais nuevo nombre del país
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Getter para la capital del país
     *
     * @return capital del país
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Setter para la capital del país
     *
     * @param capital nueva capital del país
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Getter para el número de habitantes del país
     *
     * @return número de habitantes del país
     */
    public int getNum_habitantes() {
        return num_habitantes;
    }

    /**
     * Setter para el número de habitantes del país
     *
     * @param num_habitantes nuevo número de habitantes del país
     */
    public void setNum_habitantes(int num_habitantes) {
        this.num_habitantes = num_habitantes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return id == pais.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
