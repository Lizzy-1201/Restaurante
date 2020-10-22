package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.modelo.TipoDocumento;
import gt.edu.tienda.service.ITipoDocumentoService;

@RestController
@RequestMapping("/tipoDocto")
public class TipoDocumentoRestController {

	@Autowired
	private ITipoDocumentoService tipoDoctoService;
	
	@GetMapping("/")
	public List<TipoDocumento> getAll(){
		return tipoDoctoService.getAll();
	}
}
