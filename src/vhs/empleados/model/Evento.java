package vhs.empleados.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="eventos")
public class Evento implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private Timestamp fecha;
	private Empleado asistentes;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	name="empleado_evento",
	joinColumns=@JoinColumn(name="id_evento"),
	inverseJoinColumns=@JoinColumn(name="cif")
	)
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	public Evento(String title, Timestamp fecha) {
		super();
		this.title = title;
		this.fecha = fecha;
	}
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	public Empleado getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(Empleado asistentes) {
		this.asistentes = asistentes;
	}
	@Override
	public String toString() {
		return "Evento [id=" + id + ", title=" + title + ", fecha=" + fecha + ", emp=" + asistentes + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
