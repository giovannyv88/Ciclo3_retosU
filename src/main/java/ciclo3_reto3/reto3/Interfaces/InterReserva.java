/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ciclo3_reto3.reto3.Interfaces;

import ciclo3_reto3.reto3.Modelos.TablaReservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Giovanny Vanegas
 */
public interface InterReserva extends CrudRepository<TablaReservation,Integer>{
    
    public List <TablaReservation> findAllByStatus (String status);
    
    public List <TablaReservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    
    @Query("SELECT c.client, COUNT(c.client) from TablaReservation AS c group by c.client order by COUNT(c.client)DESC")
    public List <Object []> countTotalReservationsByClient();
}
