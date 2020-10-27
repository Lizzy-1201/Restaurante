package gt.edu.tienda.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.Medida;
import gt.edu.tienda.repositorio.IMedidaRepositorio;
import gt.edu.tienda.service.IMedidaService;

@Service
public class MedidaServiceImp extends GenericServiceImp<Medida, Integer> implements IMedidaService{

	@Autowired
	private IMedidaRepositorio repositorio;
	
	@Override
	public CrudRepository<Medida, Integer> getRepository() {
		return repositorio;
	}

	@Override
	public Optional<Medida> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return repositorio.findByDescripcion(descripcion);
	}

	
  @Override 
  public List<Medida> findByLikeDescripcion(String descripcion) { 
	  // TODO Auto-generated method stub 
  return repositorio.findByLikeDescripcion(descripcion); 
  }
 



}
