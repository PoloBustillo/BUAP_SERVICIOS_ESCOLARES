package buap.intro_programacion.models;

import java.util.ArrayList;

//Uriel
public class Grado {

    private String id;
    private ArrayList lista;

    public Grado(String id, ArrayList lista) {
        this.id = id;
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Grado{" + "id=" + id + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }

}
