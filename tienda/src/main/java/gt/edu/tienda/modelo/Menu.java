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
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmenu")
	private int id;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "idmenupadre")
	@Nullable
	private int idmenupadre;
	
	@Column(name = "url", length = 100)
	@Nullable
	private String url;


}
