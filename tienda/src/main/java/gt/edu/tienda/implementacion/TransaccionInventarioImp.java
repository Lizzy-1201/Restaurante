package gt.edu.tienda.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.TransaccionInventario;
import gt.edu.tienda.repositorio.ITransaccionInventarioRepositorio;
import gt.edu.tienda.service.ITransaccionInventarioService;

@Service
public class TransaccionInventarioImp extends GenericServiceImp<TransaccionInventario, Integer> implements ITransaccionInventarioService{

	@Autowired
	private ITransaccionInventarioRepositorio repositorio;
	
	@Override
	public CrudRepository<TransaccionInventario, Integer> getRepository() {
		return repositorio;
	}

}
