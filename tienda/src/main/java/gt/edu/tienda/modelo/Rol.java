package gt.edu.tienda.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="rol")
public class Rol {
	
	@Id
	@GeneratedValue
	@Column(name = "id_rol")
	private int id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "activo")
	private int activo;
	

}
