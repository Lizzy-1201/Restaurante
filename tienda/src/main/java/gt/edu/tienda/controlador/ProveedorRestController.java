package gt.edu.tienda.controlador;

import java.util.List;
import java.util.NoSuchElementException;

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


import gt.edu.tienda.service.IProveedorService;
import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.modelo.Proveedor;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {

	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/")
	public ResponseEntity<List<Proveedor>> getAll(){
		List<Proveedor> list = proveedorService.getAll();
		if (list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Proveedor>>(list, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor) {
		if(StringUtils.isEmpty(proveedor.getNombre())) {
			return new ResponseEntity(new Mensaje("El nombre del proveedor es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Proveedor>(proveedorService.save(proveedor), HttpStatus.OK);
		}
	}
	
	@PutMapping
	public ResponseEntity<Proveedor> update(@RequestBody Proveedor proveedor) {
		if(StringUtils.isEmpty(proveedor.getNombre())) {
			return new ResponseEntity(new Mensaje("El nombre del proveedor es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Proveedor>(proveedorService.save(proveedor), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{proveedor_id}")
	public ResponseEntity delete(@PathVariable int proveedor_id) {
		
		Proveedor proveedor = proveedorService.get(proveedor_id);
		
		if(proveedor == null) {
			return new ResponseEntity(new Mensaje("El proveedor no existe"), HttpStatus.NOT_FOUND);
		} else {
			proveedorService.delete(proveedor_id);
			return new ResponseEntity(new Mensaje("Proveedor eliminado"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{proveedor_id}")
	public ResponseEntity<Proveedor> get(@PathVariable int proveedor_id) {
		
		Proveedor proveedor = proveedorService.get(proveedor_id);
		
		if(proveedor == null) {
			return new ResponseEntity(new Mensaje("Proveedor no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}
	
	@GetMapping("/nombre/{proveedor_nombre}")
	public ResponseEntity<Proveedor> getByNombre(@PathVariable String proveedor_nombre) {
		
		Proveedor proveedor;
		try {
			proveedor = proveedorService.findByNombre(proveedor_nombre).get();
		} catch (NoSuchElementException e) {
			proveedor = null;
		}
		
		if(proveedor == null) {
			return new ResponseEntity(new Mensaje("Proveedor no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}

	@GetMapping("/nombre/like/{proveedor_nombre}")
	public ResponseEntity<List<Proveedor>> getByLikeNombre(@PathVariable String proveedor_nombre) {
		
		List<Proveedor> listProveedor = proveedorService.findByLikeNombre(proveedor_nombre);
		
		if(listProveedor.isEmpty()) {
			return new ResponseEntity(new Mensaje("Proveedor no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Proveedor>>(listProveedor, HttpStatus.OK);
	}
	
	
	
}
