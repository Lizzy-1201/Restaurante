package gt.edu.tienda.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "receta")
public class Receta {

	@Id
	@Column(name = "idproductosalida")
	private Long id;
	
	@OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL)
	private List<RecetaDetalle> detalle;
}
