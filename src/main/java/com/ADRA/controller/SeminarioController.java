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

import com.ADRA.entity.seminario;
import com.ADRA.service.SeminarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController 
@RequestMapping("api/seminario")
@Api(value = "Micorservicios de gestion de seminarios", description ="Microservicio de Seminarios")
public class SeminarioController {

	@Autowired 
	private SeminarioService semiService; 
	
	 @ApiOperation(value = "Lista de Seminarios") 
	    @GetMapping 
	    public ResponseEntity<?> findAll(HttpServletRequest request) {
	        HashMap<String, Object> result = new HashMap<>();
	        result.put("success", true);
	        result.put("message", "Consulta correcta.");
	        result.put("data", semiService.findAll());
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    } 
	    
	    @ApiOperation(value = "Crea Seminario")
	    @PostMapping
	    public ResponseEntity<?> save(@RequestBody seminario semi, HttpServletRequest request) {
	        HashMap<String, Object> result = new HashMap<>();
	        seminario data = semiService.save(semi);

	        result.put("success", true);
	        result.put("message", "Registro creado correctamente.");
	        result.put("data", data);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    } 

	    @ApiOperation(value = "Actualiza un Seminario")
	    @PutMapping(value = "/{idSeminario}")
	    public ResponseEntity<?> update(@RequestBody seminario semi, HttpServletRequest request) {
	        HashMap<String, Object> result = new HashMap<>();
	        seminario data = semiService.findById(semi.getIdSeminario());
	        if (data == null) {
	            result.put("success", false);
	            result.put("message", "No existe seminario con Id: " + semi.getIdSeminario());
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        }
	        try {
	            semiService.save(semi);
	            result.put("success", true);
	            result.put("message", "Se ha actualizado los datos del seminario.");
	            result.put("data",semi);
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    } 
	
	    @ApiOperation(value = "Obtiene Datos de la Seminario")
	    @GetMapping(value = "/{idSeminario}")
	    public ResponseEntity<?> findById(@PathVariable(value = "idSeminario") Long idSeminario, HttpServletRequest request) {
	        HashMap<String, Object> result = new HashMap<>();
	        seminario data = semiService.findById(idSeminario);
	        if (data == null) {
	            result.put("success", false);
	            result.put("message", "No existe seminario con el Id: " + idSeminario);
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        }
	        result.put("success", true);
	        result.put("message", "Se ha encontrado el registro.");
	        result.put("data", data);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	    
	    @ApiOperation(value = "Elimina una Seminario")
	    @DeleteMapping(value = "/{idSeminario}")
	    public ResponseEntity<?> delete(@PathVariable(value = "idSeminario") Long idSeminario, HttpServletRequest request) {
	        HashMap<String, Object> result = new HashMap<>();
	        seminario data = semiService.findById(idSeminario);
	        if (data == null) {
	            result.put("success", false);
	            result.put("message", "No existe registro con id: " + idSeminario);
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        }
	        try {
	            semiService.delete(data);
	            result.put("success", true);
	            result.put("message", "Se ha eliminado los datos del registro.");
	            result.put("data", data);
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
}
