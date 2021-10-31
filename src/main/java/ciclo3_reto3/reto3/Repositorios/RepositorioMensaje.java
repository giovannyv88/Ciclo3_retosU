/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Repositorios;

import ciclo3_reto3.reto3.Interfaces.InterMessage;
import ciclo3_reto3.reto3.Modelos.TablaMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioMensaje {
      @Autowired
    private InterMessage crud3;
    public List<TablaMessage> getAll(){
        return (List<TablaMessage>) crud3.findAll();
    }
    public Optional<TablaMessage> getMessage(int idMessage){
        return crud3.findById(idMessage);
    }

    public TablaMessage save(TablaMessage mensaje){
        return crud3.save(mensaje);
    }
    public void delete(TablaMessage mensaje1){
        crud3.delete(mensaje1);
    }
}
