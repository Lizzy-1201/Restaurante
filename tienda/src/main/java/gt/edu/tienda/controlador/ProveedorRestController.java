package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.service.IProveedorService;
import gt.edu.tienda.modelo.Proveedor;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {

	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/")
	public List<Proveedor> getAll(){
		return proveedorService.getAll();
	}
}
