package gt.edu.tienda.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import gt.edu.tienda.common.GenericServiceImp;
import gt.edu.tienda.modelo.TipoDocumento;
import gt.edu.tienda.repositorio.ITipoDocumentoRepositorio;
import gt.edu.tienda.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImp extends GenericServiceImp<TipoDocumento, Integer> implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoRepositorio repositorio;

	@Override
	public CrudRepository<TipoDocumento, Integer> getRepository() {
		return repositorio;
	}
}
