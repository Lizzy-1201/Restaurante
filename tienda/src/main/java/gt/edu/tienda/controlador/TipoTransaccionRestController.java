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

import gt.edu.tienda.modelo.TipoTransaccion;
import gt.edu.tienda.service.ITipoTransaccionService;

@RestController
@RequestMapping("/tipoTransaccion")
public class TipoTransaccionRestController {

	@Autowired
	private ITipoTransaccionService tipTransaService;
	
	@GetMapping("/")
	public List<TipoTransaccion> getAll(){
		return tipTransaService.getAll();
	}
	
	@PostMapping
	public void save(TipoTransaccion ttr) {
		if (ttr.getDescripcion() != null) {
			tipTransaService.save(ttr);
		}
	}
	
	@PutMapping
	public TipoTransaccion update(TipoTransaccion ttr) {
		tipTransaService.save(ttr);
		return ttr;
	}
	
	@DeleteMapping("/{tipo_transa_id}")
	public void delete(@PathVariable int tipo_transa_id) {
		
		TipoTransaccion ttr = tipTransaService.get(tipo_transa_id);
		
		if(ttr == null) {
			throw new RuntimeException("Tipo de transaccion no existe " + tipo_transa_id);
		} else {
			tipTransaService.delete(tipo_transa_id);
		}
	}
	
	@GetMapping("/{tipo_transa_id}")
	public TipoTransaccion get(@PathVariable int tipo_transa_id) {
		
		TipoTransaccion ttr = tipTransaService.get(tipo_transa_id);
		
		if(ttr == null) {
			throw new RuntimeException("Tipo de transaccion no existe " + tipo_transa_id);
		}
		
		return ttr;
	}

}
