package com.cursos.service;

import com.cursos.model.Curso;

import java.util.List;

public interface CursosService {
	List<Curso> cursos();
	List<Curso> altaCurso(Curso curso);
	List<Curso> eliminarCurso(String codCurso);
	Curso buscarCurso(String codCurso);
	void actualizarDuracion(String codCurso, int duracion);
	List<Curso> cursosPorPrecio(double precioMinimo, double precioMaximo);
}
