package gt.edu.tienda.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transaccion_inventario_det")
public class TransaccionInventarioDetalle {
	
	@Id
	@Column(name = "idtransacciondet")
	private Long idTransaccionDet;
	
	@Column(name = "idtransaccion")
	private int idTransaccion;
	
	@Column(name = "linea")
	private int linea;
	
	@Column(name = "idproducto")
	private int idProducto;
	
	@Column(name = "unidades")
	private double unidades;
	
	@Column(name = "costounitario")
	private double costoUnitario;
	
	@Column(name = "costototal")
	private double costoTotal;

}
