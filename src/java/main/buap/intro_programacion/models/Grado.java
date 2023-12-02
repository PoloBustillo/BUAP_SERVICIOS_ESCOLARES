package buap.intro_programacion.models;

public class Grado {
    private String id;
    private String[] lista;

    public Grado(String id) {
        this.id = id;
    }

    public Grado(String[] lista) {
        this.lista = lista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getLista() {
        return lista;
    }

    public void setLista(String[] lista) {
        this.lista = lista;
    }

}
