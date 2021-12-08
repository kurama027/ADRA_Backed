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

import com.ADRA.entity.servicioespiritual;
import com.ADRA.service.ServesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController 
@RequestMapping("api/servico_espiritual")
@Api(value = "Micorservicios de gestion del Servicio Espiritual", description ="Microservicio de Servicio Espiritual")
public class ServesController { 
	@Autowired 
	private ServesService servesService; 
	
	@ApiOperation(value = "Lista de Oraciones") 
    @GetMapping 
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", servesService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@ApiOperation(value = "Crea Oracion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody servicioespiritual serves, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        servicioespiritual data = servesService.save(serves);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@ApiOperation(value = "Actualiza una Oracion")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody servicioespiritual serves, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        servicioespiritual data = servesService.findById(serves.getIdServicioEsp());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe oracion con Id: " + serves.getIdServicioEsp());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            servesService.save(serves);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de la oracion.");
            result.put("data", serves);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
	
	@ApiOperation(value = "Obtiene Datos de la oracion")
    @GetMapping(value = "/{idServicioEsp}")
    public ResponseEntity<?> findById(@PathVariable(value = "idServicioEsp") Long idServicioEsp, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        servicioespiritual data = servesService.findById(idServicioEsp);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe oracion con el Id: " + idServicioEsp);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@ApiOperation(value = "Elimina una Oracion")
    @DeleteMapping(value = "/{idServicioEsp}")
    public ResponseEntity<?> delete(@PathVariable(value = "idServicioEsp") Long idServicioEsp, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        servicioespiritual data = servesService.findById(idServicioEsp);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + idServicioEsp);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            servesService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
