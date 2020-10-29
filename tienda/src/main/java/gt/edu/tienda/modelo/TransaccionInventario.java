package gt.edu.tienda.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transaccion_inventario")
public class TransaccionInventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtransaccion")
	private Long id;
	
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
	@Nullable
	private Long transaccionOrigen;
	
	@Column(name = "idproveedor")
	@Nullable
	private Integer idProveedor;
	
	@Column(name = "idtipodocto")
	@Nullable
	private Long tipoDocto;
	
	@Column(name = "doctoreferencia")
	@Nullable
	private String referencia;
	
	@OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL)
	private List<TransaccionInventarioDetalle> detalles;


}
