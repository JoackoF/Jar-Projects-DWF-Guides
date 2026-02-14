package sv.edu.udb.repository;


import sv.edu.udb.repository.domain.Producto;
import sv.edu.udb.repository.domain.Proveedor;

import java.util.List;

public interface ProveedorRepository {
    Proveedor guardarProveedor(final String nombre, final List<Producto> productos);
}
