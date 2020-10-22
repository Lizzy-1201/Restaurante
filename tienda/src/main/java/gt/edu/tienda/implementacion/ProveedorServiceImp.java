package gt.edu.tienda.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.Proveedor;
import gt.edu.tienda.repositorio.IProveedorRepositorio;
import gt.edu.tienda.service.IProveedorService;

@Service
public class ProveedorServiceImp extends GenericServiceImp<Proveedor, Integer> implements IProveedorService{

	@Autowired
	private IProveedorRepositorio repositorio;
	
	@Override
	public CrudRepository<Proveedor, Integer> getRepository() {
		return repositorio;
	}

}
