package gt.edu.tienda.repositorio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.TransaccionInventario;

public interface ITransaccionInventarioRepositorio extends CrudRepository<TransaccionInventario, Long>{
	
	List<TransaccionInventario> getByFecha(Date fecha);
	
	@Query(value = "SELECT * FROM transaccion_inventario ti WHERE ti.fecha BETWEEN :fecha1 AND :fecha2", nativeQuery = true)
	List<TransaccionInventario> getByFechaEntre(
			@Param("fecha1") Date fecha1, @Param("fecha2") Date fecha2);
	
	@Query(value = "SELECT * FROM transaccion_inventario ti WHERE ti.fecha <= :fecha", nativeQuery = true)
	List<TransaccionInventario> getByFechaMenorIgualA(@Param("fecha") Date fecha);

	@Query(value = "SELECT * FROM transaccion_inventario ti WHERE ti.fecha >= :fecha", nativeQuery = true)
	List<TransaccionInventario> getByFechaMayorIgualA(@Param("fecha") Date fecha);
	
	Optional<TransaccionInventario> getByReferencia(String referencia);
	
	List<TransaccionInventario> getByIdEmpleado(int empleadoId);
	
	List<TransaccionInventario> getByAnio(int anio);
	
	@Query(value = "SELECT * FROM transaccion_inventario ti WHERE ti.anio = :anio AND ti.idperiodo = :periodo",
			nativeQuery = true)
	List<TransaccionInventario> getByAnioPeriodo(
			@Param("anio")   int anio, 
			@Param("periodo")int periodo);
	
	List<TransaccionInventario> getByIdProveedor(int proveedorId);
	
	Optional<TransaccionInventario> getByTransaccionOrigen (Long transaccionId);

}
