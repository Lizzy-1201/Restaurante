package gt.edu.tienda.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "transaccion_inventario_det")
public class TransaccionInventarioDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtransacciondet")
	private Long idDetalle;
	
	@Column(name = "linea")
	private int linea;
	
	@Column(name = "idproducto")
	private Long idProducto;
	
	@Column(name = "unidades")
	private double unidades;
	
	@Column(name = "costounitario")
	private double costoUnitario;
	
	@Column(name = "costototal")
	private double costoTotal;
	
	@ManyToOne
	@JoinColumn(name = "idtransaccion")
	@JsonIgnore
	private TransaccionInventario maestro;
	
	@JsonIgnore
	public TransaccionInventario getMaestro() {
		return maestro;
	}
	
	
}
