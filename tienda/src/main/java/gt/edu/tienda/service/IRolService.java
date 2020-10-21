package gt.edu.tienda.service;

import java.util.List;


import gt.edu.tienda.modelo.Rol;

public interface IRolService{

	void save (Rol entity);
	
	void delete (int id);
	
	Rol get(int id);
	
	List<Rol> getAll();
	
}
