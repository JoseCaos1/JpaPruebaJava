package jpaprueba.persistencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaprueba.logica.Alumno;
import jpaprueba.logica.Carrera;
import jpaprueba.logica.Materia;
import jpaprueba.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
	
	AlumnoJpaController aluJpa = new AlumnoJpaController();
	CarreraJpaController carreJpa = new CarreraJpaController();
	MateriaJpaController mateJpaa=new MateriaJpaController();

// ---------------ALUMNO------------------------	

	public void crearAlumno(Alumno alu) {
		aluJpa.create(alu);
	}

	public void eliminarAlumno(int id) {
		try {
			aluJpa.destroy(id);
		} catch (NonexistentEntityException ex) {
			Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void editarAlumno(Alumno alu) {
		try {
			aluJpa.edit(alu);
		} catch (Exception ex) {
			Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Alumno traerAlumno(int id) {
		return aluJpa.findAlumno(id);
	}

	public ArrayList<Alumno> traerListaAlumnos() {
		
		List<Alumno> listita =  aluJpa.findAlumnoEntities();
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(listita);
		return listaAlumnos;
	}


// ---------------CARRERA------------------------	
	public void crearCarrera(Carrera carre) {
		carreJpa.create(carre);
	}

	public void eliminarCarrera(int id) {
		try {
			carreJpa.destroy(id);
		} catch (NonexistentEntityException ex) {
			Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void editarCarrera(Carrera carre) {
		try {
			carreJpa.edit(carre);
		} catch (Exception ex) {
			Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Carrera traerCarrera(int id) {
		return carreJpa.findCarrera(id);
	}

	public ArrayList<Carrera> traerListaCarreras() {
		List<Carrera> lista = carreJpa.findCarreraEntities();
		ArrayList<Carrera> listaCarreras = new ArrayList<>(lista);
		return listaCarreras;
	}

	//--------------------MATERIA ------------------------------------------

	public void crearMateria(Materia mate) {
		mateJpaa.create(mate);
	}

	public void eliminarMateria(int id) {
		try {
			mateJpaa.destroy(id);
		} catch (NonexistentEntityException ex) {
			Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void editarMateria(Materia mate) {
		try {
			mateJpaa.edit(mate);
		} catch (Exception ex) {
			Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	public LinkedList<Materia> traerListaMaterias() {
		List<Materia> lista = mateJpaa.findMateriaEntities();
		LinkedList<Materia> listaMaterias = new LinkedList<>(lista);
		return listaMaterias;
	}

	public Materia traerMateria(int id) {
		return mateJpaa.findMateria(id);
	}
	
}
