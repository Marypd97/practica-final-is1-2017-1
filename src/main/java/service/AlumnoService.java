package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Alumno;
import repository.AlumnoRepository;

@Service
public class AlumnoService {
//	@Autowired
	AlumnoRepository alumnoRepository;
	

	public Alumno showAlumnoId(long id){
		return alumnoRepository.findOneById(id);
	}
	public Alumno showAlumnoApPat(String ApellidoPaterno){
		return alumnoRepository.findOneByApPat(ApellidoPaterno);
	}
	public Collection<Alumno> showAlumnos(){
		return alumnoRepository.findAll();
	}

	
	
}
