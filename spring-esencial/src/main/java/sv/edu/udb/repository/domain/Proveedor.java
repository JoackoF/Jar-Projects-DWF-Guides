package sv.edu.udb.repository.domain;

import java.util.List;

public class Proveedor {
    private Integer id;
    private String nombre;
    private List<Producto> productosOfrecidos;
    public Proveedor(final Integer id, final String nombre, final List<Producto>
            productosOfrecidos) {
        this.id = id;
        this.nombre = nombre;
        this.productosOfrecidos = productosOfrecidos;
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
    public List<Producto> getProductosOfrecidos() {
        return productosOfrecidos;
    }
    public void setProductosOfrecidos(List<Producto> productosOfrecidos) {
        this.productosOfrecidos = productosOfrecidos;
    }
}
