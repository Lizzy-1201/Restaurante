package gt.edu.tienda.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.Data;

@Data
@Entity
@Table(name = "transaccion_inventario")
public class TransaccionInventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtransaccion")
	private int id;
	
	@Column(name = "idempleado")
	private int idEmpleado;
	
	@Column(name = "idtienda")
	private int idTienda;
	
	@Column(name = "idtipo")
	private int idTipo;
	
	@Column(name = "anio")
	private int anio;
	
	@Column(name = "idperiodo")
	private int idPeriodo;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "transaccionorigen")
	private int transaccionOrigen;
	
	@Column(name = "idproveedor")
	private int idProveedor;
	
	@Column(name = "idtipodocto")
	private int tipoDocto;
	
	@Column(name = "doctoreferencia")
	private String referencia;
	
	// Detalle de la transaccion
	@OneToMany(
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	@JoinColumn(name = "idtransaccion")
	private List<TransaccionInventarioDetalle> detalles = new ArrayList<>();
}
