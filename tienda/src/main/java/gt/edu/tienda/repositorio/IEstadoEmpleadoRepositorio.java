package gt.edu.tienda.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.EstadoEmpleado;

public interface IEstadoEmpleadoRepositorio extends CrudRepository<EstadoEmpleado, Integer> {
	
	Optional<EstadoEmpleado> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM estado_empleado d WHERE UPPER(d.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<EstadoEmpleado> findByLikeDescripcion(@Param("descripcion")String descripcion);
	
	
}
