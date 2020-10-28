package gt.edu.tienda.modelo;

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
import javax.persistence.SequenceGenerator;
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
//	@SequenceGenerator(name = "transaccion_id", sequenceName = "transaccion_seq", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaccion_id")
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
	
//	@OneToMany(
//		mappedBy = "maestro",
//		targetEntity = TransaccionInventarioDetalle.class,
//		cascade = CascadeType.ALL
//		orphanRemoval = true
//	)
//	@JoinColumn(referencedColumnName = "idtransaccion")
//	@OneToMany
//	@JoinColumn(name = "idtransaccion")
	@OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL)
	private List<TransaccionInventarioDetalle> detalles;


}
