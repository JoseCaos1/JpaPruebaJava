package jpaprueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import jpaprueba.logica.Alumno;
import jpaprueba.logica.Carrera;
import jpaprueba.logica.Controladora;
import jpaprueba.logica.Materia;
import jpaprueba.persistencia.ControladoraPersistencia;

public class JpaPrueba {

	public static void main(String[] args) {

		//ControladoraPersistencia controlPersis = new ControladoraPersistencia();
		Controladora control = new Controladora();

		//Para cuando creamos solo alumno con persistente
		/*
		Alumno alu= new Alumno(30, "Luisina", "JPA", new Date());
		control.crearAlumno(alu);
		 */

		//control.eliminarAlumno(15);
		/*
		Alumno alu =new Alumno(32, "lusiita", "JPA", new Date());
		control.crearAlumno(alu);
		alu.setApellido("de Paula");
		control.editarAlumno(alu);
		 */
		/*
		Alumno alu = control.traeAlumno(30);
		System.out.println("--------------BUSQUEDA INDIVIDUAL ---------------");
		System.out.println("El alumno es: " + alu.toString());
		System.out.println("--------------BUSQUEDA DE TODOS ---------------");
		ArrayList<Alumno> listaAlumnos = control.traerListaAlumnos();
		for (Alumno al : listaAlumnos) {
			System.out.println("El alumno es: " + al.toString());
		}
		System.out.println("------------------------------------------------");
*/

		/*
		//Creacion de la carrera
		Carrera carre = new Carrera(25, "Tecnicatura en Programacion");

		//Guardado carrera en BD
		control.crearCarrera(carre);

		//Cuando tenemos alumno y carrera
		Alumno a1 = new Alumno(23, "Ibra", "The Yorkie", new Date(), carre);

		//Guardamos el alumno en la BD
		control.crearAlumno(a1);
		
		//Vemos el resultado
		System.out.println("------------------------------");
		System.out.println("---------DATOS ALUMNO---------");
		Alumno alu = control.traeAlumno(23);
		System.out.println("Alumno: " + alu.getNombre() + " " +alu.getApellido() );
		System.out.println("Cursa la carrera de: " + alu.getCarre().getNombre());
*/


		//Creacion lista de materias y las agregamos
		LinkedList<Materia> listaMaterias = new LinkedList<Materia>();

		//Creacion Carrera con lista de materias
		Carrera carre = new Carrera(15, "Tecnicatura en Progeamacion", listaMaterias);

		//Guardado carrera en BD
		control.crearCarrera(carre);
		
		//Creacion de materia en base de 1:n
		Materia mate1 = new Materia(58, "Programacion I", "Cuatrimestral",carre);
		Materia mate2  = new Materia(59, "Programacion II", "Cuatrimestral", carre);

		Materia mate3= new Materia(60, "Programacion Avanzada", "Anual", carre);
		
		//Guardado Materias en BD
		control.crearMateria(mate1);
		control.crearMateria(mate2);
		control.crearMateria(mate3);

		//Agregar a la lista las materias
		listaMaterias.add(mate1);
		listaMaterias.add(mate2);
		listaMaterias.add(mate3);

		carre.setListaMaterias(listaMaterias);
		control.editarCarrera(carre);

		//Creacion Alumno en la BD
		Alumno a1 = new Alumno(23, "Ibra", "The Yorkie", new Date(), carre);

		//Guardamos el alumno en la BD
		control.crearAlumno(a1);

		//Vemos el resultado
		System.out.println("--------------------------");
		System.out.println("--------DATOS ALUMNO------");
		Alumno alu = control.traeAlumno(23);
		System.out.println("Alumno: " + alu.getNombre() + "" + alu.getApellido());
		System.out.println("Cursa la carrera de: " + alu.getCarre().getNombre());
		

		
	}
}
