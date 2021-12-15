package com.ADRA.service;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import com.ADRA.entity.capacitacion;


public interface CapacitacionService {

	public List<capacitacion> findAll();

    public capacitacion findById(Long id);

    public capacitacion save(capacitacion capa);

    public void delete(capacitacion capa);
    
    /*
    Metodo para crear la carpeta donde vamos a guardar los archivos
     */
    public void init();

    /*
    Metodo para guardar los archivos
     */
    public void save(MultipartFile file);

    /*
    Metodo para cargar un archivo
     */
    public Resource load(String filename);

    
    //Metodo para borrar todos los archivos cada vez que se inicie el servidor
    public void deleteAll();

    /*
    Metodo para Cargar todos los archivos
     */
    public Stream<Path> loadAll();

    /*
    Metodo para Borrar un archivo
     */
    public String deleteFile(String filename);
	
}
