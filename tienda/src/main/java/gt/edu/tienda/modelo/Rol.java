package gt.edu.tienda.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol {
	
	@Id
	@Column(name = "id_rol")
	private int id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "activo")
	private int activo;
	

}
