package gt.edu.tienda.service;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.common.GenericServiceAPI;
import gt.edu.tienda.modelo.EstadoEmpleado;

public interface IEstadoEmpleadoService extends GenericServiceAPI<EstadoEmpleado, Integer>{
	
	Optional<EstadoEmpleado> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM descripcion d WHERE UPPER(d.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<EstadoEmpleado> findByLikeDescripcion(@Param("descripcion")String descripcion);

	
}
