package domain;

import javax.persistence.*;

@Entity
public class Alumno  implements BaseEntity<Long> {
	
	@Id
	@Column (name="DNI")
	private Long id;

	private String nombres;
	

	private String apellidoPaterno;


	private String apellidoMaterno;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Alumno(long dni, String nombres, String ApePat, String ApeMat)	{
		id=dni;
		this.nombres=nombres;
		apellidoPaterno=ApePat;
		apellidoMaterno=ApeMat;
	}
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
