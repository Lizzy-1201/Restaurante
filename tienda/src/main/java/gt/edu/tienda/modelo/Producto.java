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
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmedida")
	private int id;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "paraVenta")
	private int paraventa;
	
	@Column(name = "esProducido")
	private int esproducido;


}
