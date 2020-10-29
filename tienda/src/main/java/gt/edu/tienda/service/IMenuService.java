package gt.edu.tienda.service;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.common.GenericServiceAPI;
import gt.edu.tienda.modelo.Menu;

public interface IMenuService extends GenericServiceAPI<Menu, Integer>{
	
	Optional<Menu> findByDescripcion(String descripcion);

	@Query(value = "SELECT * FROM menu m WHERE UPPER(m.descripcion) LIKE '%'||UPPER(:descripcion)||'%'", 
			nativeQuery = true)
	List<Menu> findByLikeDescripcion(@Param("descripcion")String descripcion);

	List<Menu> findByIdmenupadre(int idmenupadre);

	List<Menu> findByUrl(String url);
	
}
