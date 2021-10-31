/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Repositorios;

import ciclo3_reto3.reto3.Interfaces.InterClient;
import ciclo3_reto3.reto3.Modelos.TablaCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioCliente {
      @Autowired
    private InterClient crud1;

    public List<TablaCliente> getAll(){
        return (List<TablaCliente>) crud1.findAll();
    }
    public Optional<TablaCliente> getCliente(int idCliente){
        return crud1.findById(idCliente);
    }

    public TablaCliente save(TablaCliente cliente){
        return crud1.save(cliente);
    }
    public void delete(TablaCliente cliente){
        crud1.delete(cliente);
    }
}
