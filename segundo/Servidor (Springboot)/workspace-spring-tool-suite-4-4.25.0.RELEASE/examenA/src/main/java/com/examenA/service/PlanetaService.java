package com.examenA.service;

import java.util.List;

import com.examenA.model.Luna;
import com.examenA.model.Planeta;

public interface PlanetaService {
	
	/**
	 * Crea un planeta
	 * @param planeta
	 * @return planeta insertado
	 */
	Planeta crearPlaneta(Planeta planeta);
	/**
	 * Listar todos los planetas
	 * @return la lista de los planetas
	 */
    List<Planeta> listarTodos();
    /**
     * Eliminar un planeta junto con sus lunas.
     * @param id del planeta
     */
    void eliminarPlaneta(Long id);
    /**
     * Buscar planetas de un tipo
     * @param tipo del planeta a buscar
     * @return la lista de planetas cuyo tipo sea el tipo a buscar
     */
    List<Planeta> buscarPorTipo(String tipo);
    /**
     * Crear una luna asociada a un planeta existente
     * @param luna a insertar en el planeta cuyo ide es planetaId
     * @param planetaId id del planeta
     * @return la luna insertada
     */
    Luna crearLuna(Luna luna, Long planetaId);
   
    /**
     * Buscar si el planeta Júpiter esta en la base de datos.
     * @return true si el planeta Júpiter existe y false en caso contrario
     */
    boolean existeJupiter();
    
    
    Planeta getPlanetaId(Long id);
}
