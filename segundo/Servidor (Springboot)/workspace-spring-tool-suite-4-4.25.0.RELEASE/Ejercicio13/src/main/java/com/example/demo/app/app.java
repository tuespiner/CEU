package com.example.demo.app;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tarea;

@RestController
@RequestMapping("/Tareas")
public class app {
	public app() {
		Tarea tarea1 = new Tarea(1, "tarea1", "programar", LocalDate.now(), )
	}
}
