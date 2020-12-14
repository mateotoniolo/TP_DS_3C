package PKs;

import java.io.Serializable;

public class ProvinciaPK implements Serializable{
	Integer id_provincia;
	Integer id_pais;
	public ProvinciaPK(Integer provincia, Integer pais) {
		super();
		this.id_provincia = provincia;
		this.id_pais = pais;
	}
	
	
}
