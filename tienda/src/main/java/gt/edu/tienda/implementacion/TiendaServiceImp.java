package gt.edu.tienda.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.Tienda;
import gt.edu.tienda.repositorio.ITiendaRepositorio;
import gt.edu.tienda.service.ITiendaService;

@Service
public class TiendaServiceImp extends GenericServiceImp<Tienda, Integer> implements ITiendaService{

	@Autowired
	private ITiendaRepositorio repositorio;
	
	@Override
	public CrudRepository<Tienda, Integer> getRepository() {
		return repositorio;
	}

}
