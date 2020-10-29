package gt.edu.tienda.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.Producto;

public interface IProductoRepositorio extends CrudRepository<Producto, Integer> {
	
	Optional<Producto> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM producto p WHERE UPPER(p.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<Producto> findByLikeDescripcion(@Param("descripcion")String descripcion);
	
//	Optional<Producto> findByParaventa(String paraventa);

	List<Producto> findByParaventa(int paraventa);
	
//	Optional<Producto> findByEsproducido(String esproducido);
	
	List<Producto> findByEsproducido(int esproducido);
	
	
}
