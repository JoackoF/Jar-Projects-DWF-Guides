package sv.edu.udb.service;

import sv.edu.udb.repository.ProductoRepository;
import sv.edu.udb.repository.ProveedorRepository;
import sv.edu.udb.repository.domain.Producto;
import sv.edu.udb.repository.domain.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventarioService {
    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    public InventarioService(final ProductoRepository productoRepository,
                             final ProveedorRepository proveedorRepository) {
        this.productoRepository = Objects.requireNonNull(productoRepository);
        this.proveedorRepository = Objects.requireNonNull(proveedorRepository);
    }
    public Proveedor agregarProveedorConProducto(final String nombre) {
        final List<Producto> listadoProductos = new ArrayList<>();
        final Producto producto1 = productoRepository.guardarProducto("test_1", 20D);
        final Producto producto2 = productoRepository.guardarProducto("test_2", 50D);
        listadoProductos.add(producto1);
        listadoProductos.add(producto2);
        return proveedorRepository.guardarProveedor(nombre, listadoProductos);
    }
}
