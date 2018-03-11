package vhs.empleados.negocio;

import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import vhs.empleados.DAO.EmpleadosDAO;
import vhs.empleados.DAO.EmpleadosDAOHB;
import vhs.empleados.model.Direccion;
import vhs.empleados.model.Empleado;
import vhs.empleados.model.Evento;
import vhs.empleados.util.HibernateUtil;

public class EmpleadosNegocioImpl implements EmpleadosNegocio {

	// aqui llama a la interface y programamos con las interfaces
	private EmpleadosDAO dao = new EmpleadosDAOHB();

	@Override
	public Empleado getEmpleado(String cif) {
//		Session session = null;
//		Transaction tx = null;
		Empleado emp = null;
//		try {
			
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			
//			
//			tx = session.beginTransaction();
			
			
			emp = dao.getEmpleado(cif);
			
//			Hibernate.initialize(emp.getDir());
			
			
//			tx.commit();
		
		
//		} catch (RuntimeException ex) {
//			if (tx != null) {
//
//				tx.rollback();
//			}
//			throw ex;
//		}

		return emp;
	}

	@Override
	public Set<Empleado> getAllEmpleados() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Empleado emp = null;
		Set<Empleado> empleados ;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			empleados = dao.getAllEmpleados();
			
			
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null) {

				tx.rollback();
			}
			throw ex;
		}

		return empleados;
	}

	@Override
	public void insertaEmpleado(Empleado emp) {
//		Session session = null;
//		Transaction tx = null;
//		try {
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		tx = session.beginTransaction();
//		
		dao.insertaEmpleado(emp);
		
//		tx.commit();
//		} catch (RuntimeException ex) {
//		if (tx != null) {
//		tx.rollback();
//		}
//		throw ex;
//		}

	}

	@Override
	public void modificaEmpleado(Empleado emp) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		
		dao.modificaEmpleado(emp);;
		
		tx.commit();
		} catch (RuntimeException ex) {
		if (tx != null) {
		tx.rollback();
		}
		throw ex;
		}
		

	}

	@Override
	public void eliminaEmpleado(String cif) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		
		dao.eliminaEmpleado(cif);
		
		tx.commit();
		} catch (RuntimeException ex) {
		if (tx != null) {
		tx.rollback();
		}
		throw ex;
		}
		
	}

	@Override
	public void insertaEmpleados(Set<Empleado> sEmpleados) {
		// TODO Auto-generated method stub
//		Session session = null;
//		Transaction tx = null;
//		try {
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		tx = session.beginTransaction();
		for (Empleado emp : sEmpleados) {
		dao.insertaEmpleado(emp);
		}
//		tx.commit();
//		} catch (RuntimeException ex) {
//		if (tx != null) {
//		tx.rollback();
//		}
//		throw ex;
//		}
	}

	@Override
	public Direccion direccionEmpleados(int id) {
//		Session session = null;
//		Transaction tx = null;
		Direccion emp = null;
//		try {
//			
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			
//			
//			tx = session.beginTransaction();
			
			
			emp = dao.direccionEmpleados(id);
			
			
//			tx.commit();
//		
//		
//		} catch (RuntimeException ex) {
//			if (tx != null) {
//
//				tx.rollback();
//			}
//			throw ex;
//		}

		return emp;
	}

	@Override
	public Set<Evento> getAllEventos() {
		// TODO Auto-generated method stub
		
		Set<Evento> eventos ;
		eventos = dao.getAllEventos();
		return eventos;
	}
	
}
