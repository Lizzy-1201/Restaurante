package gt.edu.tienda.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.Menu;
import gt.edu.tienda.repositorio.IMenuRepositorio;
import gt.edu.tienda.service.IMenuService;

@Service
public class MenuServiceImp extends GenericServiceImp<Menu, Integer> implements IMenuService{

	@Autowired
	private IMenuRepositorio repositorio;
	
	@Override
	public CrudRepository<Menu, Integer> getRepository() {
		return repositorio;
	}

	@Override
	public Optional<Menu> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return repositorio.findByDescripcion(descripcion);
	}

	
    @Override 
    public List<Menu> findByLikeDescripcion(String descripcion) { 
	    // TODO Auto-generated method stub 
    return repositorio.findByLikeDescripcion(descripcion); 
    }

    @Override
    public List<Menu> findByIdmenupadre(int idmenupadre) {
	    // TODO Auto-generated method stub
	return repositorio.findByIdmenupadre(idmenupadre);
    }
    
    @Override
    public List<Menu> findByUrl(String url) {
    	// TODO Auto-generated method stub
    	return repositorio.findByUrl(url);
    }


}
