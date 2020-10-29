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
	
	Optional<Producto> findByParaVenta(String paraventa);

	@Query(value = "SELECT * FROM producto pv WHERE UPPER(pv.paraventa) LIKE '%'||UPPER(:paraventa)||'%'", 
			nativeQuery = true)
	List<Producto> findByLikeParaVenta(@Param("paraventa")String paraventa);
	
	Optional<Producto> findByEsProducido(String esproducido);
	
	@Query(value = "SELECT * FROM producto ep WHERE UPPER(ep.esproducido) LIKE '%'||UPPER(:esproducido)||'%'", 
			nativeQuery = true)
	List<Producto> findByLikeEsProducido(@Param("esproducido")String esproducido);
	
	
}
