/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Servicios;

import ciclo3_reto3.reto3.Repositorios.RepositorioMensaje;
import ciclo3_reto3.reto3.Modelos.TablaMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje mensajeCrud;

    public List<TablaMessage> getAll(){
        return mensajeCrud.getAll();
    }

    public Optional<TablaMessage> getMessage(int messageId) {
        return mensajeCrud.getMessage(messageId);
    }

    public TablaMessage save(TablaMessage message){
        if(message.getIdMessage()==null){
            return mensajeCrud.save(message);
        }else{
            Optional<TablaMessage> e= mensajeCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return mensajeCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public TablaMessage update(TablaMessage message){
        if(message.getIdMessage()!=null){
            Optional<TablaMessage> e= mensajeCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                mensajeCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            mensajeCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
