package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.modelo.Tienda;
import gt.edu.tienda.service.ITiendaService;

@RestController
@RequestMapping("/tienda")
public class TiendaRestController {
	
	@Autowired
	private ITiendaService tiendaService;
	
	@GetMapping("/")
	public List<Tienda> getAll(){
		return tiendaService.getAll();
	}

}
