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

import com.ADRA.entity.socias;
import com.ADRA.service.SociaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController 
@RequestMapping("api/socia")
@Api(value = "Micorservicios de gestion de socias", description ="Microservicio de Socias")
public class SociaController { 
	@Autowired 
	private SociaService sociaService;
	
    @ApiOperation(value = "Lista de Socias") 
    @GetMapping 
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", sociaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
    
    @ApiOperation(value = "Crea Socia")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody socias socia, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        socias data = sociaService.save(socia);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
    
    @ApiOperation(value = "Actualiza un Socia")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody socias socia, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        socias data = sociaService.findById(socia.getIdSocias());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe socia con Id: " + socia.getIdSocias());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            sociaService.save(socia);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de la socia.");
            result.put("data", socia);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
    
    @ApiOperation(value = "Obtiene Datos de la Socia")
    @GetMapping(value = "/{IdSocias}")
    public ResponseEntity<?> findById(@PathVariable(value = "IdSocias") Long IdSocias, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        socias data = sociaService.findById(IdSocias);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe socia con el Id: " + IdSocias);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Elimina una Socia")
    @DeleteMapping(value = "/{IdSocias}")
    public ResponseEntity<?> delete(@PathVariable(value = "IdSocias") Long IdSocias, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        socias data = sociaService.findById(IdSocias);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + IdSocias);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            sociaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
}
