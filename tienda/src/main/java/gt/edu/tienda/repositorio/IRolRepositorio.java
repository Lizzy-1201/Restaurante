package gt.edu.tienda.repositorio;

import org.springframework.data.repository.CrudRepository;

import gt.edu.tienda.modelo.Rol;

public interface IRolRepositorio extends CrudRepository<Rol, Integer>{
	
	Rol findRolById (int id);

}
