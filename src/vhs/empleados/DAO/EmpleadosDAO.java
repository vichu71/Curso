package vhs.empleados.DAO;

import java.util.Set;

import vhs.empleados.model.Direccion;
import vhs.empleados.model.Empleado;
import vhs.empleados.model.Evento;

public interface EmpleadosDAO {
	public abstract Empleado getEmpleado(String cif);

	public abstract Set<Empleado> getAllEmpleados();

	public abstract void insertaEmpleado(Empleado emp);

	public abstract void modificaEmpleado(Empleado emp);

	public abstract void eliminaEmpleado(String cif);
	
	public abstract void eliminaAllEmpleados();
	
	public abstract Direccion direccionEmpleados(int id);
	
	public abstract Set<Evento> getAllEventos();
	
	
}
