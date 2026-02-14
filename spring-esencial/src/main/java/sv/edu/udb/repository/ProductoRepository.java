package sv.edu.udb.repository;
import sv.edu.udb.repository.domain.Producto;


public interface ProductoRepository {
    Producto guardarProducto(final String nombre, final Double precio);
}
