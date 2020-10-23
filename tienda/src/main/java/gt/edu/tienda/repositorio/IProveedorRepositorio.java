package gt.edu.tienda.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.Proveedor;

public interface IProveedorRepositorio extends CrudRepository<Proveedor, Integer> {
	
	Optional<Proveedor> findByNombre(String nombre);

	@Query(value = "SELECT * FROM proveedor p WHERE p.nombre LIKE %:nombre%", nativeQuery = true)
	List<Proveedor> findByLikeNombre(@Param("nombre")String nombre);
	
	//boolean existByNombre(String nombre);
	
}
