/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ciclo3_reto3.reto3.Interfaces;

import ciclo3_reto3.reto3.Modelos.TablaCliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface InterClient extends CrudRepository<TablaCliente,Integer> {
    
}
