package gt.edu.tienda.service;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.common.GenericServiceAPI;
import gt.edu.tienda.modelo.Producto;

public interface IProductoService extends GenericServiceAPI<Producto, Integer>{
	
	Optional<Producto> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM producto p WHERE UPPER(p.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<Producto> findByLikeDescripcion(@Param("descripcion")String descripcion);
	
	Optional<Producto> findByParaVenta(String paraventa);

	@Query(value = "SELECT * FROM producto pv WHERE UPPER(pv.paraventa) LIKE '%'||UPPER(:paraventa)||'%'", 
			nativeQuery = true)
	List<Producto> findByLikefindByParaVenta(@Param("paraventa")String paraventa);

	Optional<Producto> findByEsProducido(String descripcion);

	@Query(value = "SELECT * FROM producto ep WHERE UPPER(ep.esproducido) LIKE '%'||UPPER(:esproducido)||'%'", 
			nativeQuery = true)
	List<Producto> findByLikeEsProducido(@Param("esproducido")String esproducido);


	
}