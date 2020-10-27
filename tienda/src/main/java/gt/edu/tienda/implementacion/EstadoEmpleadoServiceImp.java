package gt.edu.tienda.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.EstadoEmpleado;
import gt.edu.tienda.repositorio.IEstadoEmpleadoRepositorio;
import gt.edu.tienda.service.IEstadoEmpleadoService;

@Service
public class EstadoEmpleadoServiceImp extends GenericServiceImp<EstadoEmpleado, Integer> implements IEstadoEmpleadoService{

	@Autowired
	private IEstadoEmpleadoRepositorio repositorio;
	
	@Override
	public CrudRepository<EstadoEmpleado, Integer> getRepository() {
		return repositorio;
	}

	@Override
	public Optional<EstadoEmpleado> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return repositorio.findByDescripcion(descripcion);
	}

	
  @Override 
  public List<EstadoEmpleado> findByLikeDescripcion(String descripcion) { 
	  // TODO Auto-generated method stub 
  return repositorio.findByLikeDescripcion(descripcion); 
  }
 



}
