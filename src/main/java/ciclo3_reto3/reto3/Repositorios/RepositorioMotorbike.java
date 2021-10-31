/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Repositorios;

import ciclo3_reto3.reto3.Interfaces.InterMotorbike;
import ciclo3_reto3.reto3.Modelos.TablaMotorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovanny Vanegas
 */
@Repository
public class RepositorioMotorbike {
    
    @Autowired
    private InterMotorbike crud;

    public List<TablaMotorbike> getAll(){
        return (List<TablaMotorbike>) crud.findAll();
    }

    public Optional<TablaMotorbike> getMoto(int id){
        return crud.findById(id);
    }

    public TablaMotorbike save(TablaMotorbike moto){
        return crud.save(moto);
    }
    public void delete(TablaMotorbike moto){
        crud.delete(moto);
    }
    
}
