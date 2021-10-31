/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Controladores;

import ciclo3_reto3.reto3.Servicios.ServiciosMotorbike;
import ciclo3_reto3.reto3.Modelos.TablaMotorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControlMotorbike {
    
    @Autowired
    private ServiciosMotorbike servicioMoto;
    
    @GetMapping("/all")
    public List<TablaMotorbike> getMotorbikes(){
        return servicioMoto.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TablaMotorbike> getBiker(@PathVariable("id") int id) {
        return servicioMoto.getMotorbike(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaMotorbike save(@RequestBody TablaMotorbike motor) {
        return servicioMoto.save(motor);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaMotorbike update(@RequestBody TablaMotorbike motor) {
        return servicioMoto.update(motor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return servicioMoto.deleteBike(Id);
    } 
}
