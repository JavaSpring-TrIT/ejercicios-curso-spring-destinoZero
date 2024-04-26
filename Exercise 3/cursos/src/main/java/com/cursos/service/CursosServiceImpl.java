package com.cursos.service;

import com.cursos.dao.CursosDao;
import com.cursos.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		return cursos();
	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public Curso buscarCurso(String codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
	public void actualizarDuracion(String codCurso, int duracion) {
		Curso curso = dao.findById(codCurso).orElse(null);
		if (curso != null) {
			curso.setDuracion(duracion);
			dao.save(curso);
		}
	}

	@Override
	public List<Curso> cursosPorPrecio(double precioMinimo, double precioMaximo) {
		return dao.findByPrecioBetween(precioMinimo, precioMaximo);
	}
}
