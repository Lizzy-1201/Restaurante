package gt.edu.tienda.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.edu.tienda.modelo.Rol;
import gt.edu.tienda.repositorio.IRolRepositorio;
import gt.edu.tienda.service.IRolService;

@Service
public class RolServiceImp implements IRolService {

	@Autowired
	private IRolRepositorio repositorio;
	
	@Override
	public void save(Rol entity) {
		repositorio.save(entity);
		
	}
	
	@Override
	public void delete(int id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public Rol get(int id) {
		Rol rol = repositorio.findRolById(id);
		return rol;
	}

	@Override
	public List<Rol> getAll() {
		List<Rol> listRol = (List<Rol>)repositorio.findAll();
		return listRol;
	}


}
