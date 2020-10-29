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


import gt.edu.tienda.service.IProductoService;
import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.modelo.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Producto>> getAll(){
		List<Producto> list = productoService.getAll();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		if(StringUtils.isEmpty(producto.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Producto>(productoService.save(producto), HttpStatus.OK);
		}
	}
	
	@PutMapping
	public ResponseEntity<Producto> update(@RequestBody Producto producto) {
		if(StringUtils.isEmpty(producto.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Producto>(productoService.save(producto), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{producto_id}")
	public ResponseEntity delete(@PathVariable int producto_id) {
		
		Producto producto = productoService.get(producto_id);
		
		if(producto == null) {
			return new ResponseEntity(new Mensaje("El medida no existe"), HttpStatus.NOT_FOUND);
		} else {
			productoService.delete(producto_id);
			return new ResponseEntity(new Mensaje("Medida eliminado"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{producto_id}")
	public ResponseEntity<Producto> get(@PathVariable int producto_id) {
		
		Producto producto = productoService.get(producto_id);
		
		if(producto == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/descripcion/{producto_descripcion}")
	public ResponseEntity<Producto> getByDescripcion(@PathVariable String producto_descripcion) {
		
		Producto producto = productoService.findByDescripcion(producto_descripcion).get();
		
		if(producto == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@GetMapping("/descripcion/like/{producto_descripcion}")
	public ResponseEntity<List<Producto>> getByLikeDescripcion(@PathVariable String producto_descripcion) {
		
		List<Producto> listproducto = productoService.findByLikeDescripcion(producto_descripcion);
		
		if(listproducto == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Producto>>(listproducto, HttpStatus.OK);
	}
	
	
	
}
