package vhs.empleados.ui;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vhs.empleados.model.Direccion;
import vhs.empleados.model.Empleado;
import vhs.empleados.model.Evento;
import vhs.empleados.negocio.EmpleadosNegocio;
import vhs.empleados.negocio.EmpleadosNegocioImpl;
import vhs.empleados.util.HibernateUtil;

public class GestorEmpleadosConsola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GestorEmpleadosConsola().go();

	}

	public EmpleadosNegocio negocio = new EmpleadosNegocioImpl();
	
	private void go() {
		// TODO Auto-generated method stub
		System.out.println("inicio....");
		Session session = null;
		Transaction tx = null;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		Empleado emp = new Empleado("43675229E", "Richie", "Sambora", 58);
//		//emp.setEdad(20);
//		session.persist(emp);
//		emp.setEdad(20);
//		session.getTransaction().commit();
//		session.close();
try {
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			
			tx = session.beginTransaction();
			
//			testRecuperaEmpleado();
//			testInsertaVariosEmpleado();
//			testreasignaDireccion();
//			testcreaUsuarioConDireccion();
			
			testGetEventos();
			
			tx.commit();
		
		
		} catch (RuntimeException ex) {
			if (tx != null) {

				tx.rollback();
			}
			throw ex;
		}	
	
//		testInsertaEmpleado();
		
//		testTodosEmpleados();
		
//		testUpdateEmpleados();
		
//		testDeleteEmpleados();
		
//		testDeleteAllEmpleados();
		
	//	testDirecciones();
		HibernateUtil.shutdown();
		System.out.println("fin.....");
	}

	private void testGetEventos() {
		// TODO Auto-generated method stub
		Set<Evento> eventos ;
		eventos=negocio.getAllEventos();
		
		for(Evento emp:eventos) {
			System.out.println(emp.toString());
		}
		
	}

	private void testDirecciones() {
		// TODO Auto-generated method stub
		System.out.println(negocio.direccionEmpleados(1));
	}

	private void testDeleteAllEmpleados() {
		// TODO Auto-generated method stub
		//negocio.eliminaEmpleado(cif);;
	}

	private void testDeleteEmpleados() {
		// TODO Auto-generated method stub
		negocio.eliminaEmpleado("02632595");
	}

	private void testUpdateEmpleados() {
		// TODO Auto-generated method stub
		Empleado emp = new Empleado("02632595", "Sonia", "Masip", 40);
		negocio.modificaEmpleado(emp);
		
	}

	private void testTodosEmpleados() {
		// TODO Auto-generated method stub
		Set<Empleado> empleados ;
		empleados=negocio.getAllEmpleados();
		
		for(Empleado emp:empleados) {
			System.out.println(emp.toString());
		}
		
	}

	private void testInsertaEmpleado() {
		// TODO Auto-generated method stub
		Empleado emp = new Empleado("51684977K", "Sonia", "Masip", 18);
		negocio.insertaEmpleado(emp);
		
	}
	
	private void testInsertaVariosEmpleado() {
		// TODO Auto-generated method stub
		Set<Empleado> empl = new HashSet<>();
		empl.add(new Empleado("51684977Q", "chirli", "fer", 18));
		empl.add(new Empleado("51684977X", "castr", "alt", 25));
		negocio.insertaEmpleados(empl);
		
	}

	private void testRecuperaEmpleado() {
		// TODO Auto-generated method stub
		Empleado empAux = negocio.getEmpleado("40948574G"); 
		
		System.out.println(empAux);
		//esto es un proxy, por lo que hasta que no se llama no  tiene datos
		//e implementa en el maping
		System.out.println(empAux.getDir());
		
	}
	
	private void testreasignaDireccion() {
		// TODO Auto-generated method stub
		Empleado empAux = negocio.getEmpleado("40948574G"); 
		Direccion dir = negocio.direccionEmpleados(2);
		
		empAux.setDir(dir);
		System.out.println(empAux);
		//esto es un proxy, por lo que hasta que no se llama no  tiene datos
		//e implementa en el maping
		System.out.println(empAux.getDir());
		
	}
	private void testcreaUsuarioConDireccion() {
		// TODO Auto-generated method stub
		Empleado emp = new Empleado("51684977Y", "Sonia", "Masip", 18);
		Direccion dir =new Direccion("calahorrra 19",28032);
		emp.setDir(dir);
		negocio.insertaEmpleado(emp);
		
	}
	
	

}
