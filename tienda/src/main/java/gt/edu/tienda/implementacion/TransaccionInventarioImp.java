package gt.edu.tienda.implementacion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.TransaccionInventario;
import gt.edu.tienda.modelo.TransaccionInventarioDetalle;
import gt.edu.tienda.repositorio.ITransaccionInventarioDetalleRepositorio;
import gt.edu.tienda.repositorio.ITransaccionInventarioRepositorio;
import gt.edu.tienda.service.ITransaccionInventarioService;

@Service
public class TransaccionInventarioImp extends GenericServiceImp<TransaccionInventario, Long> implements ITransaccionInventarioService{

	@Autowired
	private ITransaccionInventarioRepositorio repositorio;
	
	@Autowired ITransaccionInventarioDetalleRepositorio detalleRepositorio;
	
	
	  @Override 
	  public TransaccionInventario save(TransaccionInventario ti) { 
		  //Crea una nueva transacción 
		  TransaccionInventario newTransaccion = new TransaccionInventario(); 
		  TransaccionInventario savedTransaccion = new TransaccionInventario();
		  // Si es una actualización no insertará nada
		  newTransaccion.setAnio(ti.getAnio());
		  newTransaccion.setFecha(ti.getFecha());
		  newTransaccion.setIdEmpleado(ti.getIdEmpleado());
		  newTransaccion.setIdPeriodo(ti.getIdPeriodo());
		  newTransaccion.setIdProveedor(ti.getIdProveedor());
		  newTransaccion.setIdTienda(ti.getIdTienda());
		  newTransaccion.setIdTipo(ti.getIdTipo());
		  newTransaccion.setReferencia(ti.getReferencia());
		  newTransaccion.setTipoDocto(ti.getTipoDocto());
		  newTransaccion.setTransaccionOrigen(ti.getTransaccionOrigen());

		  if(ti.getId() == null){
//			  newTransaccion.setAnio(ti.getAnio());
//			  newTransaccion.setFecha(ti.getFecha());
//			  newTransaccion.setIdEmpleado(ti.getIdEmpleado());
//			  newTransaccion.setIdPeriodo(ti.getIdPeriodo());
//			  newTransaccion.setIdProveedor(ti.getIdProveedor());
//			  newTransaccion.setIdTienda(ti.getIdTienda());
//			  newTransaccion.setIdTipo(ti.getIdTipo());
//			  newTransaccion.setReferencia(ti.getReferencia());
//			  newTransaccion.setTipoDocto(ti.getTipoDocto());
//			  newTransaccion.setTransaccionOrigen(ti.getTransaccionOrigen());
			  savedTransaccion = repositorio.save(newTransaccion);
			  // Asigna el identificador al detalle
			  for(TransaccionInventarioDetalle tid : ti.getDetalles()) {
				  tid.setMaestro(savedTransaccion);
				  // Añade el detalle a la lista
				  detalleRepositorio.save(tid);
			  }			  
		  } else {
			  newTransaccion.setId(ti.getId());
			  newTransaccion.setDetalles(ti.getDetalles());
//			  savedTransaccion = repositorio.save(newTransaccion);
			  for(TransaccionInventarioDetalle tid : newTransaccion.getDetalles()) {
				  tid.setMaestro(ti);
				  // Añade el detalle a la lista
				  //detalleRepositorio.save(tid);
			  }	
			  savedTransaccion = repositorio.save(newTransaccion);
			  
		  }
		  //savedTransaccion.setDetalles(ti.getDetalles());
		  return savedTransaccion;
	  
	  }
	 	
	@Override
	public CrudRepository<TransaccionInventario, Long> getRepository() {
		return repositorio;
	}

	@Override
	public List<TransaccionInventario> getByFecha(Date fecha) {
		return repositorio.getByFecha(fecha);
	}

	@Override
	public List<TransaccionInventario> getByFechaEntre(Date fecha1, Date fecha2) {
		return repositorio.getByFechaEntre(fecha1, fecha2);
	}

	@Override
	public List<TransaccionInventario> getByFechaMenorIgualA(Date fecha) {
		return repositorio.getByFechaMenorIgualA(fecha);
	}

	@Override
	public List<TransaccionInventario> getByFechaMayorIgualA(Date fecha) {
		return repositorio.getByFechaMayorIgualA(fecha);
	}

	@Override
	public Optional<TransaccionInventario> getByReferencia(String referencia) {
		return repositorio.getByReferencia(referencia);
	}

	@Override
	public List<TransaccionInventario> getByIdEmpleado(int empleadoId) {
		return repositorio.getByIdEmpleado(empleadoId);
	}

	@Override
	public List<TransaccionInventario> getByAnio(int anio) {
		return repositorio.getByAnio(anio);
	}

	@Override
	public List<TransaccionInventario> getByAnioPeriodo(int anio, int periodo) {
		return repositorio.getByAnioPeriodo(anio, periodo);
	}

	@Override
	public List<TransaccionInventario> getByIdProveedor(int proveedorId) {
		return repositorio.getByIdProveedor(proveedorId);
	}

	@Override
	public Optional<TransaccionInventario> getByTransaccionOrigen(Long transaccionId) {
		return repositorio.getByTransaccionOrigen(transaccionId);
	}

}
