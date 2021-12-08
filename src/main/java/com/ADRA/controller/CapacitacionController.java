package com.ADRA.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ADRA.entity.capacitacion;
import com.ADRA.service.CapacitacionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController 
@RequestMapping("api/capacitacion")
@Api(value = "Micorservicios de gestion de capacitacion", description ="Microservicio de Capacitacion")

public class CapacitacionController {

	@Autowired 
	private CapacitacionService capaService; 
	
	@ApiOperation(value = "Lista de capacitaciones") 
    @GetMapping 
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", capaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@ApiOperation(value = "Crea Capacitacion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody capacitacion capa, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        capacitacion data = capaService.save(capa);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@ApiOperation(value = "Actualiza un Capacitacion")
    @PutMapping(value = "/{idCapacitacion}")
    public ResponseEntity<?> update(@RequestBody capacitacion capa, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        capacitacion data = capaService.findById(capa.getIdCapacitacion());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe capacitacion con Id: " + capa.getIdCapacitacion());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            capaService.save(capa);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de la capacitacion.");
            result.put("data", capa);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
	
	@ApiOperation(value = "Obtiene Datos de la capacitacion")
    @GetMapping(value = "/{idCapacitacion}")
    public ResponseEntity<?> findById(@PathVariable(value = "idCapacitacion") Long idCapacitacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        capacitacion data = capaService.findById(idCapacitacion);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe capacitacion con el Id: " + idCapacitacion);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@ApiOperation(value = "Elimina una Capacitacion")
    @DeleteMapping(value = "/{idCapacitacion}")
    public ResponseEntity<?> delete(@PathVariable(value = "idCapacitacion") Long idCapacitacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        capacitacion data = capaService.findById(idCapacitacion);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + idCapacitacion);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            capaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
