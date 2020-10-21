package gt.edu.tienda.common;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {
	
	void save (T entity);
	
	void delete (ID id);
	
	T get(ID id);
	
	List<T> getAll();

}
