package gt.edu.tienda.implementacion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	public Optional<TransaccionInventario> getByTransaccionOrigen(int transaccionId) {
		return repositorio.getByTransaccionOrigen(transaccionId);
	}

}
