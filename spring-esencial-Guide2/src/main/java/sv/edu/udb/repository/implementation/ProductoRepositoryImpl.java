package sv.edu.udb.repository.implementation;
import sv.edu.udb.repository.ProductoRepository;
import sv.edu.udb.repository.domain.Producto;

import java.util.random.RandomGenerator;

public class ProductoRepositoryImpl implements ProductoRepository {
    @Override
    public Producto guardarProducto(final String nombre, final Double precio) {
        return new Producto(RandomGenerator.of("Random").nextInt(),
                nombre, precio);
    }
}
