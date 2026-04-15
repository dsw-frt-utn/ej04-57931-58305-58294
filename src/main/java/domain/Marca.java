
package domain;

/**
 *
 * @author lucia
 */
public class Marca {
    private String nombre;
    private String pais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Marca(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }
    
}
