/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Repositorios;

import ciclo3_reto3.reto3.Interfaces.InterCategory;
import ciclo3_reto3.reto3.Modelos.TablaCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioCategoria {
    @Autowired
    private InterCategory crudCategory;
    public List<TablaCategory> getAll(){
        return (List<TablaCategory>) crudCategory.findAll();
    }
    public Optional<TablaCategory> getCategoria(int id){
        return crudCategory.findById(id);
    }

    public TablaCategory save(TablaCategory Categoria){
        return crudCategory.save(Categoria);
    }
    public void delete(TablaCategory Categoria){
       crudCategory.delete(Categoria);
    }
}
