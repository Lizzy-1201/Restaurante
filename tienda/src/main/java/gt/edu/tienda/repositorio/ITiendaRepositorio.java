package gt.edu.tienda.repositorio;

import org.springframework.data.repository.CrudRepository;

import gt.edu.tienda.modelo.Tienda;

public interface ITiendaRepositorio extends CrudRepository<Tienda, Integer> {

}
