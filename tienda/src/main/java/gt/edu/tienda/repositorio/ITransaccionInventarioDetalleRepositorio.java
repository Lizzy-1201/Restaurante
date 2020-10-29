package gt.edu.tienda.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gt.edu.tienda.modelo.TransaccionInventarioDetalle;

public interface ITransaccionInventarioDetalleRepositorio extends CrudRepository<TransaccionInventarioDetalle, Long>{

	@Query(value = "SELECT count(*) from public.reconstruye_inventario(:tienda,:producto)", 
			nativeQuery = true)
	void reconstruyeInventario(
			@Param("tienda") int tienda, 
			@Param("producto") Long producto
		);
}
