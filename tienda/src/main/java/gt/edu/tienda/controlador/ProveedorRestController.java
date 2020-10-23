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
	
	@PostMapping
	public void save(Proveedor proveedor) {
		if(proveedor.getNombre() != null) {
			proveedorService.save(proveedor);
		}
	}
	
	@PutMapping
	public Proveedor update(@RequestBody Proveedor proveedor) {
		proveedorService.save(proveedor);
		return proveedor;
	}
	
	@DeleteMapping("/{proveedor_id}")
	public void delete(@PathVariable int proveedor_id) {
		
		Proveedor proveedor = proveedorService.get(proveedor_id);
		
		if(proveedor == null) {
			throw new RuntimeException("Proveedor no existe "+proveedor_id);
		} else {
			proveedorService.delete(proveedor_id);
		}
	}
	
	@GetMapping("/{proveedor_id}")
	public Proveedor get(@PathVariable int proveedor_id) {
		
		Proveedor proveedor = proveedorService.get(proveedor_id);
		
		if(proveedor == null) {
			throw new RuntimeException("Proveedor no existe " + proveedor_id);
		}
		
		return proveedor;
	}
}
