package gt.edu.tienda.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Data
@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private int id;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "paraventa")
	@Nullable
	private int paraventa;
	
	@Column(name = "esproducido")
	@Nullable
	private int esproducido;


}
