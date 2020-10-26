package gt.edu.tienda.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.TipoTransaccion;
import gt.edu.tienda.repositorio.ITipoTransaccionRepositorio;
import gt.edu.tienda.service.ITipoTransaccionService;

@Service
public class TipoTransaccionImp extends GenericServiceImp<TipoTransaccion, Integer> implements ITipoTransaccionService{

	@Autowired
	private ITipoTransaccionRepositorio repositorio;
	
	@Override
	public CrudRepository<TipoTransaccion, Integer> getRepository() {
		return repositorio;
	}

	@Override
	public List<TipoTransaccion> findByFactor(int factor) {
		return repositorio.findByFactor(factor);
	}
	

}
