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


import gt.edu.tienda.service.IMenuService;
import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.modelo.Menu;


@RestController
@RequestMapping("/menu")
public class MenuRestController {

	@Autowired
	private IMenuService menuService;
	
	@GetMapping("/")
	public ResponseEntity<List<Menu>> getAll(){
		List<Menu> list = menuService.getAll();
		if (list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Menu>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Menu> save(@RequestBody Menu menu ) {
		if(StringUtils.isEmpty(menu.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del menu es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			if (StringUtils.isEmpty(menu.getIdmenupadre())) {
				return new ResponseEntity(new Mensaje("Debe indicar si cuanta con id del menu padre"), HttpStatus.BAD_REQUEST);			
		} else {
			if (StringUtils.isEmpty(menu.getUrl())) {
				return new ResponseEntity(new Mensaje("Debe colocar la url"), HttpStatus.BAD_REQUEST);			
		} else {
			return new ResponseEntity<Menu>(menuService.save(menu), HttpStatus.OK);
		       }
		   }
		}
	}
	
	@PutMapping
	public ResponseEntity<Menu> update(@RequestBody Menu menu) {
		if(StringUtils.isEmpty(menu.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Menu>(menuService.save(menu), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{menu_id}")
	public ResponseEntity delete(@PathVariable int menu_id) {
		
		Menu producto = menuService.get(menu_id);
		
		if(producto == null) {
			return new ResponseEntity(new Mensaje("El menu no existe"), HttpStatus.NOT_FOUND);
		} else {
			menuService.delete(menu_id);
			return new ResponseEntity(new Mensaje("Menu eliminado"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{menu_id}")
	public ResponseEntity<Menu> getById(@PathVariable int menu_id) {
		
		Menu menu = menuService.get(menu_id);
		
		if(menu == null) {
			return new ResponseEntity(new Mensaje("Menu no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	}
	
	@GetMapping("/descripcion/{menu_descripcion}")
	public ResponseEntity<Menu> getByDescripcion(@PathVariable String menu_descripcion) {
		
		Menu menu;
		try {
			menu = menuService.findByDescripcion(menu_descripcion).get();
			
		} catch (NoSuchElementException e) {
			menu = null;
		}
		
		if(menu == null) {
			return new ResponseEntity(new Mensaje("Menu no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	}

	@GetMapping("/descripcion/like/{menu_descripcion}")
	public ResponseEntity<List<Menu>> getByLikeDescripcion(@PathVariable String menu_descripcion) {
		
		List<Menu> listmenu = menuService.findByLikeDescripcion(menu_descripcion);
		
		if(listmenu == null) {
			return new ResponseEntity(new Mensaje("Menu no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Menu>>(listmenu, HttpStatus.OK);
	}
	
	@GetMapping("/idmenupadre/{menu_idmenupadre}")
	public ResponseEntity<List<Menu>> getByIdmenupadre(@PathVariable int menu_idmenupadre) {
		
		List<Menu> list = menuService.findByIdmenupadre(menu_idmenupadre);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Menu>>(list, HttpStatus.OK);
	}

	@GetMapping("/url/{menu_url}")
	public ResponseEntity<List<Menu>> getByUrl(@PathVariable String menu_url) {
		
		List<Menu> listmenu = menuService.findByUrl(menu_url);
		
		if(listmenu == null) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Menu>>(listmenu, HttpStatus.OK);
	}

	
	
	
}
