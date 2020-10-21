package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.modelo.Rol;
import gt.edu.tienda.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolRestController {

	@Autowired
	private IRolService rolService;
	
	@GetMapping("/")
	public List<Rol> getAll(){
		return rolService.getAll();
	}
	
}
