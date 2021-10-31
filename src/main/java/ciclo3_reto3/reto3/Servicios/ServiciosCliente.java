/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Servicios;

import ciclo3_reto3.reto3.Repositorios.RepositorioCliente;
import ciclo3_reto3.reto3.Modelos.TablaCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosCliente {
       @Autowired
     private RepositorioCliente clienteCrud;
     
     public List<TablaCliente> getAll(){
        return clienteCrud.getAll();
    }
     
      public Optional<TablaCliente> getClient(int clientId) {
        return clienteCrud.getCliente(clientId);
    }

    public TablaCliente save(TablaCliente client){
        if(client.getIdClient()==null){
            return clienteCrud.save(client);
        }else{
            Optional<TablaCliente> e= clienteCrud.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return clienteCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public TablaCliente update(TablaCliente client){
        if(client.getIdClient()!=null){
            Optional<TablaCliente> e= clienteCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clienteCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clienteCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
