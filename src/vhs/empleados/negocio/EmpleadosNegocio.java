package vhs.empleados.negocio;

import java.util.Set;

import vhs.empleados.model.Direccion;
import vhs.empleados.model.Empleado;
import vhs.empleados.model.Evento;

public interface EmpleadosNegocio {
	public abstract Empleado getEmpleado(String cif);

	public abstract Set<Empleado> getAllEmpleados();

	public abstract void insertaEmpleado(Empleado emp);

	public abstract void modificaEmpleado(Empleado emp);

	public abstract void eliminaEmpleado(String cif);
	
	public abstract void insertaEmpleados(Set<Empleado> sEmpleados);
	
	public abstract Direccion direccionEmpleados(int id);
	
	public abstract Set<Evento> getAllEventos();
	
}
