package gt.edu.tienda.service;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.common.GenericServiceAPI;
import gt.edu.tienda.modelo.Medida;

public interface IMedidaService extends GenericServiceAPI<Medida, Integer>{
	
	Optional<Medida> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM medida m WHERE UPPER(m.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<Medida> findByLikeDescripcion(@Param("descripcion")String descripcion);

	
}
