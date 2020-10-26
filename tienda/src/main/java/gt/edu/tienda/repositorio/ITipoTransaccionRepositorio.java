package gt.edu.tienda.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gt.edu.tienda.modelo.TipoTransaccion;

public interface ITipoTransaccionRepositorio extends CrudRepository<TipoTransaccion, Integer>{
	
	List<TipoTransaccion> findByFactor(int factor);
	
}
