package sv.edu.udb.service;
import org.junit.jupiter.api.Test;
import sv.edu.udb.repository.ProductoRepository;
import sv.edu.udb.repository.ProveedorRepository;
import sv.edu.udb.repository.domain.Proveedor;
import sv.edu.udb.repository.implementation.ProductoRepositoryImpl;
import sv.edu.udb.repository.implementation.ProveedorRepositoryImpl;
import static org.junit.jupiter.api.Assertions.*;

class InventarioServiceTest {
    @Test
    void cuandoLaInstanciaProductoRepositoryEsNulaError() {
        final ProductoRepository productoRepository = null;
        final ProveedorRepository proveedorRepository = new ProveedorRepositoryImpl();
        assertThrows(NullPointerException.class, () -> new
                InventarioService(productoRepository, proveedorRepository));
    }
    @Test
    void cuandoLaInstanciaProveedorRepositoryEsNulaError() {
        final ProductoRepository productoRepository = new ProductoRepositoryImpl();
        final ProveedorRepository proveedorRepository = null;
        assertThrows(NullPointerException.class, () -> new
                InventarioService(productoRepository, proveedorRepository));
    }
    @Test
    void cuandoInventarioServiceEsInstanciadoEjecutaOperacion() {
        final ProductoRepository productoRepository = new ProductoRepositoryImpl();
        final ProveedorRepository proveedorRepository = new ProveedorRepositoryImpl();
        final InventarioService inventarioService = new InventarioService(productoRepository, proveedorRepository);
        final String nombreProveedor = "Boquitas Diana";
        final Proveedor proveedor =
                inventarioService.agregarProveedorConProducto(nombreProveedor);
        assertNotNull(inventarioService);
        assertNotNull(proveedor);
        assertEquals(nombreProveedor, proveedor.getNombre());
        assertEquals(2, proveedor.getProductosOfrecidos().size());
    }
}
