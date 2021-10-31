/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Repositorios;

import ciclo3_reto3.reto3.Interfaces.InterReserva;
import ciclo3_reto3.reto3.Modelos.TablaCliente;
import ciclo3_reto3.reto3.Modelos.TablaReservation;
import ciclo3_reto3.reto3.Reportes.NumeroClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterReserva crud4;

    public List<TablaReservation> getAll(){
        return (List<TablaReservation>) crud4.findAll();
    }
    public Optional<TablaReservation> getReservation(int idReservation){
        return crud4.findById(idReservation);
    }
    public TablaReservation save(TablaReservation reservation){
        return crud4.save(reservation);
    }
    public void delete(TablaReservation reserva){
        crud4.delete(reserva);
    }
    
    public List <TablaReservation> ReservaStatus (String status){
        return crud4.findAllByStatus(status);
    }
    
    public List <TablaReservation> TiempoReservacion (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a,b);           
    }
    
    public List<NumeroClientes> getRepositorioClientes(){
        List <NumeroClientes> contar = new ArrayList<>();
        List <Object[]> reporte = crud4.countTotalReservationsByClient();
        for (int i = 0; i <reporte.size(); i++) {
            contar.add(new NumeroClientes((Long) reporte.get(i)[1],(TablaCliente)reporte.get(i)[0]));
            
        }return contar;
        
    }
      
}
