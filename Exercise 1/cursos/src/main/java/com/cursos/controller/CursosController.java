package com.cursos.controller;

import com.cursos.model.Curso;
import com.cursos.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursosController {

	@Autowired
	CursosService service;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return service.cursos();
	}

	@GetMapping(value = "curso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}

	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> agregar(@RequestBody Curso curso) {
		return service.altaCurso(curso);
	}

	@PutMapping(value = "curso/{codCurso}/duracion/{duracion}")
	public void actualizarDuracion(@PathVariable("codCurso") String codCurso, @PathVariable("duracion") int duracion) {
		service.actualizarDuracion(codCurso, duracion);
	}

	@DeleteMapping(value = "curso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable("codCurso") String codCurso) {
		return service.eliminarCurso(codCurso);
	}

	@GetMapping(value = "curso/precio/{precioMinimo}/{precioMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPorPrecio(@PathVariable("precioMinimo") double precioMinimo, @PathVariable("precioMaximo") double precioMaximo) {
		return service.cursosPorPrecio(precioMinimo, precioMaximo);
	}

}
