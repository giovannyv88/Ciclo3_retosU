/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//Definiendo la clase como una entidad usando Springboot
@Entity
@Table(name = "motorbike") //Nombramiento de la tabla motorbike
public class TablaMotorbike implements Serializable{
    
    @Id//Llave primaria definida en el atributo id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincrementable
    private Integer id;//Atributos de la tabla Motorbike
    private String name;
    private String brand;
    private Integer year;
    private String description;
   
    
    @ManyToOne //Relacion Muchos a uno con la tabla Category
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("motorbikes")
    private TablaCategory category;
    //Relacion uno a muchos con la tabla Message
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})
    private List<TablaMessage> messages;
     //Relacion uno a muchos con la tabla Reservation
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})
    private List<TablaReservation> reservations;//Lista que me guarda los registros

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TablaCategory getCategory() {
        return category;
    }

    public void setCategory(TablaCategory category) {
        this.category = category;
    }

    public List<TablaMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<TablaMessage> messages) {
        this.messages = messages;
    }

    public List<TablaReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<TablaReservation> reservations) {
        this.reservations = reservations;
    }

   
        
}
