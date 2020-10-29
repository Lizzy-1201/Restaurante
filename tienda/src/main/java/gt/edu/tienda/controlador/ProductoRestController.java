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
		if (list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> save(@RequestBody Producto producto ) {
		if(StringUtils.isEmpty(producto.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del producto es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			if (StringUtils.isEmpty(producto.getParaventa())) {
				return new ResponseEntity(new Mensaje("Debe indicar si el producto es para venta"), HttpStatus.BAD_REQUEST);			
		} else {
			if (StringUtils.isEmpty(producto.getEsproducido())) {
				return new ResponseEntity(new Mensaje("Debe indicar si el producto es para produccion"), HttpStatus.BAD_REQUEST);			
		} else {
			return new ResponseEntity<Producto>(productoService.save(producto), HttpStatus.OK);
		       }
		   }
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
			return new ResponseEntity(new Mensaje("El Producto no existe"), HttpStatus.NOT_FOUND);
		} else {
			productoService.delete(producto_id);
			return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{producto_id}")
	public ResponseEntity<Producto> getById(@PathVariable int producto_id) {
		
		Producto producto = productoService.get(producto_id);
		
		if(producto == null) {
			return new ResponseEntity(new Mensaje("Producto no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/descripcion/{producto_descripcion}")
	public ResponseEntity<Producto> getByDescripcion(@PathVariable String producto_descripcion) {
		
		Producto producto;
		try {
			producto = productoService.findByDescripcion(producto_descripcion).get();
			
		} catch (NoSuchElementException e) {
			producto = null;
		}
		
		if(producto == null) {
			return new ResponseEntity(new Mensaje("Producto no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@GetMapping("/descripcion/like/{producto_descripcion}")
	public ResponseEntity<List<Producto>> getByLikeDescripcion(@PathVariable String producto_descripcion) {
		
		List<Producto> listproducto = productoService.findByLikeDescripcion(producto_descripcion);
		
		if(listproducto == null) {
			return new ResponseEntity(new Mensaje("Producto no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Producto>>(listproducto, HttpStatus.OK);
	}
	
	@GetMapping("/paraventa/{producto_paraventa}")
	public ResponseEntity<List<Producto>> getByParaventa(@PathVariable int producto_paraventa) {
		
		List<Producto> list = productoService.findByParaventa(producto_paraventa);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}

	@GetMapping("/esProducido/{producto_producido}")
	public ResponseEntity<List<Producto>> getByEsProducido(@PathVariable int producto_producido) {
		
		List<Producto> listproducto = productoService.findByEsproducido(producto_producido);
		
		if(listproducto == null) {
			return new ResponseEntity(new Mensaje("Producto no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Producto>>(listproducto, HttpStatus.OK);
	}

	
	
	
}
