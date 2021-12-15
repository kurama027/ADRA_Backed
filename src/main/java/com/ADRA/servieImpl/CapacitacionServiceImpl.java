package com.ADRA.servieImpl;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ADRA.entity.capacitacion;
import com.ADRA.repository.CapacitacionRepository;
import com.ADRA.service.CapacitacionService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class CapacitacionServiceImpl implements CapacitacionService{

	@Autowired 
	CapacitacionRepository capaRepository;
	
	@Override
	public List<capacitacion> findAll() {
		// TODO Auto-generated method stub
		return (List<capacitacion>) capaRepository.findAll();
	}

	@Override
	public capacitacion findById(Long id) {
		// TODO Auto-generated method stub
		return capaRepository.findById(id).orElse(null);
	}

	@Override
	public capacitacion save(capacitacion capa) {
		// TODO Auto-generated method stub
		return capaRepository.save(capa);
	}

	@Override
	public void delete(capacitacion capa) {
		capaRepository.delete(capa);

		
	}
	
	//Nombre de la carpeta donde vamos a almacenar los archivos
    //Se crea a nivel de raiz la carpeta
    private final Path root = Paths.get("uploads");
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede inicializar la carpeta uploads");
        }
	}

	@Override
	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
            //copy (que queremos copiar, a donde queremos copiar)
            Files.copy(file.getInputStream(), 
                       this.root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
        }
	}

	@Override
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("No se puede leer el archivo ");
            }

        }catch (MalformedURLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		 //Files.walk recorre nuestras carpetas (uploads) buscando los archivos
        // el 1 es la profundidad o nivel que queremos recorrer
        // :: Referencias a metodos
        // Relativize sirve para crear una ruta relativa entre la ruta dada y esta ruta
        try{
            return Files.walk(this.root,1).filter(path -> !path.equals(this.root))
                    .map(this.root::relativize);
        }catch (RuntimeException | IOException e){
            throw new RuntimeException("No se pueden cargar los archivos ");
        }
	}

	@Override
	public String deleteFile(String filename) {
		// TODO Auto-generated method stub
		try {
            Boolean delete = Files.deleteIfExists(this.root.resolve(filename));
                return "Borrado";
        }catch (IOException e){
            e.printStackTrace();
            return "Error Borrando ";
        }
	}

}
