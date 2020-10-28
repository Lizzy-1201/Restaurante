package gt.edu.tienda.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.TransaccionInventarioDetalle;
import gt.edu.tienda.repositorio.ITransaccionInventarioDetalleRepositorio;
import gt.edu.tienda.service.ITransaccionInventarioDetalleService;

public class TransaccionInventarioDetalleImp extends GenericServiceImp<TransaccionInventarioDetalle, Long> implements ITransaccionInventarioDetalleService{

	@Autowired
	private ITransaccionInventarioDetalleRepositorio repositorio;
	@Override
	public CrudRepository<TransaccionInventarioDetalle, Long> getRepository() {
		return repositorio;
	}

}
