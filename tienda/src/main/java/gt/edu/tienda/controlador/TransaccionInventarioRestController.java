package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.modelo.TransaccionInventario;
import gt.edu.tienda.service.ITransaccionInventarioService;

@RestController
@RequestMapping("/transaccionInventario")
public class TransaccionInventarioRestController {

	@Autowired
	private ITransaccionInventarioService transaccionService;
	
	@GetMapping("/")
	public List<TransaccionInventario> getAll(){
		return transaccionService.getAll();
	}
	
	@PostMapping
	public void save(TransaccionInventario ti) {
		transaccionService.save(ti);
	}
	
	@PutMapping
	public TransaccionInventario update(TransaccionInventario ti) {
		transaccionService.save(ti);
		return ti;
	}
	
	@DeleteMapping("/{transaccion_id}")
	public void delete(@PathVariable int transaccion_id) {
		
		TransaccionInventario ti = transaccionService.get(transaccion_id);
		
		if(ti == null) {
			throw new RuntimeException("Transacción de Inventario no existe " + transaccion_id);
		} else {
			transaccionService.delete(transaccion_id);
		}
	}
}
