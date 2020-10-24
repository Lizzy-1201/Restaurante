package gt.edu.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.common.GenericServiceAPI;
import gt.edu.tienda.modelo.Proveedor;

public interface IProveedorService extends GenericServiceAPI<Proveedor, Integer>{
	
	Optional<Proveedor> findByNombre(String nombre);

	@Query(value = "SELECT * FROM proveedor p WHERE p.nombre LIKE '%'||UPPER(:nombre)||'%'", 
			nativeQuery = true)
	List<Proveedor> findByLikeNombre(@Param("nombre")String nombre);

	
}
