package gt.edu.tienda.service;

import java.util.List;

import gt.edu.tienda.common.GenericServiceAPI;
import gt.edu.tienda.modelo.TipoTransaccion;

public interface ITipoTransaccionService extends GenericServiceAPI<TipoTransaccion, Integer>{

	List<TipoTransaccion> findByFactor(int factor);
}
