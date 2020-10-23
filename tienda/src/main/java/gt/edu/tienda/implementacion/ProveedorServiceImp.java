package gt.edu.tienda.implementacion;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Proveedor> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findByNombre(nombre);
	}

	
  @Override 
  public List<Proveedor> findByLikeNombre(String nombre) { 
	  // TODO Auto-generated method stub 
  return repositorio.findByLikeNombre(nombre); 
  }
 



}
