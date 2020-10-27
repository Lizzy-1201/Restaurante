package gt.edu.tienda.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.Medida;

public interface IMedidaRepositorio extends CrudRepository<Medida, Integer> {
	
	Optional<Medida> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM medida d WHERE UPPER(d.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<Medida> findByLikeDescripcion(@Param("descripcion")String descripcion);
	
	
}
