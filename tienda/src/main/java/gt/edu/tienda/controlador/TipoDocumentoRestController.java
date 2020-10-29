package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.modelo.TipoDocumento;
import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.service.ITipoDocumentoService;

@RestController
@RequestMapping("/tipoDocto")
public class TipoDocumentoRestController {

	@Autowired
	private ITipoDocumentoService tipoDoctoService;
	
	@GetMapping("/")
	public ResponseEntity<List<TipoDocumento>> getAll(){
		List<TipoDocumento> list = tipoDoctoService.getAll();
		if (list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TipoDocumento>>(list, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<TipoDocumento> save(@RequestBody TipoDocumento td) {
		if (StringUtils.isEmpty(td.getDescripcion())) {
			return new ResponseEntity(new Mensaje("Descripción es obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<TipoDocumento>(tipoDoctoService.save(td), HttpStatus.OK);
		}
	}
	
	@PutMapping
	public ResponseEntity<TipoDocumento> update(@RequestBody TipoDocumento td) {
		if (StringUtils.isEmpty(td.getDescripcion())) {
			return new ResponseEntity(new Mensaje("Descripción es obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<TipoDocumento>(tipoDoctoService.save(td), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{tipo_docto_id}")
	public ResponseEntity delete(@PathVariable int tipo_docto_id) {
		
		TipoDocumento td = tipoDoctoService.get(tipo_docto_id);
		if(td == null) {
			return new ResponseEntity(new Mensaje("Tipo de Documento no existe"), HttpStatus.NOT_FOUND);
		} else {
			tipoDoctoService.delete(tipo_docto_id);
			return new ResponseEntity(new Mensaje("Tipo de Documento eliminado"), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/{tipo_docto_id}")
	public ResponseEntity<TipoDocumento> getById(@PathVariable int tipo_docto_id) {
		
		TipoDocumento td = tipoDoctoService.get(tipo_docto_id);
		if(td == null) {
			return new ResponseEntity(new Mensaje("Tipo de Documento no existe"), HttpStatus.NOT_FOUND);
		} else {
			tipoDoctoService.delete(tipo_docto_id);
			return new ResponseEntity<TipoDocumento>(td, HttpStatus.OK);
		}
		
	}
}
