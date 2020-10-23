package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public void save(TipoDocumento td) {
		if (td.getDescripcion() != null) {
			tipoDoctoService.save(td);
		}
	}
	
	@PutMapping
	public TipoDocumento update(@RequestBody TipoDocumento td) {
		tipoDoctoService.save(td);
		return td;
	}
	
	@DeleteMapping("/{tipo_docto_id}")
	public void delete(@PathVariable int tipo_docto_id) {
		
		TipoDocumento td = tipoDoctoService.get(tipo_docto_id);
		if(td == null) {
			throw new RuntimeException("Tipo de Documento no existe "+tipo_docto_id);
		} else {
			tipoDoctoService.delete(tipo_docto_id);
		}
	}
	
	@GetMapping("/{tipo_docto_id}")
	public TipoDocumento get(@PathVariable int tipo_docto_id) {
		
		TipoDocumento td = tipoDoctoService.get(tipo_docto_id);
		
		if(td == null) {
			throw new RuntimeException("Tipo de Documento no existe "+tipo_docto_id);
		}
		
		return td;
	}
}
