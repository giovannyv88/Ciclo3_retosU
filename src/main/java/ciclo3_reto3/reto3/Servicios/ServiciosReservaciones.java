/*
 * 
 */
package ciclo3_reto3.reto3.Servicios;

import ciclo3_reto3.reto3.Repositorios.RepositorioReservaciones;
import ciclo3_reto3.reto3.Modelos.TablaReservation;
import ciclo3_reto3.reto3.Reportes.NumeroClientes;
import ciclo3_reto3.reto3.Reportes.ReservaStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovanny Vanegas
 */
//Se coloca la anotacion service
@Service
public class ServiciosReservaciones { 
     @Autowired
    private RepositorioReservaciones reservaCrud;//

    public List<TablaReservation> getAll(){
        return reservaCrud.getAll();
    }

    public Optional<TablaReservation> getReservation(int reservationId) {
        return reservaCrud.getReservation(reservationId);
    }

    public TablaReservation save(TablaReservation reservation){
        if(reservation.getIdReservation()==null){
            return reservaCrud.save(reservation);
        }else{
            Optional<TablaReservation> e= reservaCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return reservaCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public TablaReservation update(TablaReservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<TablaReservation> e= reservaCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservaCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservaCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public ReservaStatus reporteStatus (){
        List<TablaReservation> completed = reservaCrud.ReservaStatus("completed");
        List<TablaReservation> cancelled = reservaCrud.ReservaStatus("cancelled");
        return new ReservaStatus(completed.size(), cancelled.size());
    }
    
    public List <TablaReservation> reporteTiempo (String datoA, String datoB){
        SimpleDateFormat parseo = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            
            datoUno = parseo.parse(datoA);
            datoDos = parseo.parse(datoB);
        
        }
        catch(ParseException fecha){
            fecha.printStackTrace();
        }
            if(datoUno.before(datoDos)){
                return reservaCrud.TiempoReservacion(datoUno, datoDos);
            }
            else{
                return new ArrayList<>();
            }
    }
    
    public List <NumeroClientes> reporteClientes(){
        return reservaCrud.getRepositorioClientes();
    }
    
 
    
}
