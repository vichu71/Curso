package vhs.empleados.DAO;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import vhs.empleados.model.Direccion;
import vhs.empleados.model.Empleado;
import vhs.empleados.model.Evento;
import vhs.empleados.util.HibernateUtil;

public class EmpleadosDAOHB implements EmpleadosDAO {

	
	private Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
		}
	@Override
	public Empleado getEmpleado(String cif) {
		return (Empleado) getSession().get(Empleado.class, cif);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Empleado> getAllEmpleados() {
		// TODO Auto-generated method stub
		
		return new HashSet<Empleado>(getSession().createQuery("from Empleado").list());
	}

	@Override
	public void insertaEmpleado(Empleado emp) {
		// TODO Auto-generated method stub
		
		getSession().persist(emp);
		
	}

	@Override
	public void modificaEmpleado(Empleado emp) {
		// TODO Auto-generated method stub
		getSession().update(emp);
	}

	@Override
	public void eliminaEmpleado(String cif) {
		// TODO Auto-generated method stub
//		Empleado empAux = new Empleado();
//		empAux.setCif(cif);
		
		Empleado empAux =this.getEmpleado(cif);
		getSession().delete(empAux);

	}
	@Override
	public void eliminaAllEmpleados() {
	getSession().createQuery("delete Empleado").executeUpdate();
	}
	
	public Direccion direccionEmpleados(int id) {
		
		return (Direccion) getSession().get(Direccion.class, id);
	}
	@Override
	public Set<Evento> getAllEventos() {
		return new HashSet<Evento>(getSession().createQuery("from Evento").list());
	}
	
}
