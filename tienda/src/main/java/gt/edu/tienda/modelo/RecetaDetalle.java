package gt.edu.tienda.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "receta_detalle")
public class RecetaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrecetadetalle")
	private Long idRecetaDetalle;
	
	@ManyToOne
	@JoinColumn(name = "idproductosalida")
	@JsonIgnore
	private Receta maestro;
	
	@Column(name = "cantidad")
	private double cantidad;
	
	
	
}
