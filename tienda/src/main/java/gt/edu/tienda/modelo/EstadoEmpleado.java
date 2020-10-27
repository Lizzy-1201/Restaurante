package gt.edu.tienda.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="estado_empleado")
public class EstadoEmpleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestado")
	private int id;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;

}
