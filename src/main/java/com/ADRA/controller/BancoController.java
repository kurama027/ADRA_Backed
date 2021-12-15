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

import com.ADRA.entity.banco;
import com.ADRA.service.BancoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController 
@RequestMapping("api/banco")
@Api(value = "Micorservicios de gestion de capacitacion", description ="Microservicio de Capacitacion")

public class BancoController {

	@Autowired 
	private BancoService bankService; 
	
	@ApiOperation(value = "Lista bancos") 
    @GetMapping 
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", bankService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@ApiOperation(value = "Crea Capacitacion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody banco bank, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        banco data = bankService.save(bank);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@ApiOperation(value = "Actualiza un Banco")
    @PutMapping(value = "/{idbanco}")
    public ResponseEntity<?> update(@RequestBody banco bank, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        banco data = bankService.findById(bank.getIdbanco());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe banco con Id: " + bank.getIdbanco());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            bankService.save(bank);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del banco.");
            result.put("data",bank);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
	
	@ApiOperation(value = "Obtiene Datos del banco")
    @GetMapping(value = "/{idbanco}")
    public ResponseEntity<?> findById(@PathVariable(value = "idbanco") Long idbanco, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        banco data = bankService.findById(idbanco);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe banco con el Id: " + idbanco);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@ApiOperation(value = "Elimina un ")
    @DeleteMapping(value = "/{idbanco}")
    public ResponseEntity<?> delete(@PathVariable(value = "idbanco") Long idbanco, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        banco data = bankService.findById(idbanco);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + idbanco);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            bankService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
