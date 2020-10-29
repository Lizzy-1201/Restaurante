package gt.edu.tienda.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.Producto;
import gt.edu.tienda.repositorio.IProductoRepositorio;
import gt.edu.tienda.service.IProductoService;

@Service
public class ProductoServiceImp extends GenericServiceImp<Producto, Integer> implements IProductoService{

	@Autowired
	private IProductoRepositorio repositorio;
	
	@Override
	public CrudRepository<Producto, Integer> getRepository() {
		return repositorio;
	}

	@Override
	public Optional<Producto> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return repositorio.findByDescripcion(descripcion);
	}

	
    @Override 
    public List<Producto> findByLikeDescripcion(String descripcion) { 
	    // TODO Auto-generated method stub 
    return repositorio.findByLikeDescripcion(descripcion); 
    }

    @Override
    public List<Producto> findByParaventa(int paraventa) {
	    // TODO Auto-generated method stub
	return repositorio.findByParaventa(paraventa);
    }
    
    @Override
    public List<Producto> findByEsproducido(int esproducido) {
    	// TODO Auto-generated method stub
    	return repositorio.findByEsproducido(esproducido);
    }

}
