package com.cursos.dao;

import com.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursosDao extends JpaRepository<Curso, String> {

	List<Curso> findByPrecioBetween(double precioMinimo, double precioMaximo);

}
