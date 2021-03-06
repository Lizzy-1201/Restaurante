package gt.edu.tienda.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipo_transaccion")
public class TipoTransaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipo")
	private int id;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "factor")
	private int factor;
}
