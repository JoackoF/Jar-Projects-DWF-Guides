package sv.edu.udb.repository.domain;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    public Producto(final Integer id, final String nombre, final Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
