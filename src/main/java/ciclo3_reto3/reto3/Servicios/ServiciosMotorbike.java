/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Servicios;

import ciclo3_reto3.reto3.Repositorios.RepositorioMotorbike;
import ciclo3_reto3.reto3.Modelos.TablaMotorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosMotorbike {
     @Autowired
    private RepositorioMotorbike motoCrud;

    public List<TablaMotorbike> getAll(){
        return motoCrud.getAll();
    }

    public Optional<TablaMotorbike> getMotorbike(int Id) {
        return motoCrud.getMoto(Id);
    }

    public TablaMotorbike save(TablaMotorbike motorbike){
        if(motorbike.getId()==null){
            return motoCrud.save(motorbike);
        }else{
            Optional<TablaMotorbike> e=motoCrud.getMoto(motorbike.getId());
            if(e.isEmpty()){
                return motoCrud.save(motorbike);
            }else{
                return motorbike;
            }
        }
    }

    public TablaMotorbike update(TablaMotorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<TablaMotorbike> e=motoCrud.getMoto(motorbike.getId());
            if(!e.isEmpty()){
                
                if(motorbike.getName()!=null){
                    e.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    e.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    e.get().setYear(motorbike.getYear());
                }
                
                if(motorbike.getDescription()!=null){
                    e.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    e.get().setCategory(motorbike.getCategory());
                }
                
                motoCrud.save(e.get());
                return e.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }


    public boolean deleteBike(int Id) {
        Boolean aBoolean = getMotorbike(Id).map(bike -> {
            motoCrud.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
