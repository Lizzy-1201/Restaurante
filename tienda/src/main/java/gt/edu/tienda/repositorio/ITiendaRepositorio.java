package gt.edu.tienda.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.Tienda;

public interface ITiendaRepositorio extends CrudRepository<Tienda, Integer> {
	
	@Query(value = "SELECT * FROM tienda t WHERE t.direccion LIKE '%'||UPPER(:direccion)||'%'",
			nativeQuery = true)
	List<Tienda> findByLikeDireccion(@Param("direccion") String direccion);

}
