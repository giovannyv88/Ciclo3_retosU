/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto3.reto3.Servicios;

import ciclo3_reto3.reto3.Repositorios.RepositorioCategoria;
import ciclo3_reto3.reto3.Modelos.TablaCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosCategoria {
     @Autowired
    private RepositorioCategoria categoriaCrud;

    public List<TablaCategory> getAll() {
        return categoriaCrud.getAll();
    }

    public Optional<TablaCategory> getCategoria(int CategoriaId) {
        return categoriaCrud.getCategoria(CategoriaId);
    }

    public TablaCategory save(TablaCategory categoria) {
        if (categoria.getId()== null) {
            return categoriaCrud.save(categoria);
        } else {
            Optional<TablaCategory> categoria1 = categoriaCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return categoriaCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public TablaCategory update(TablaCategory categoria){
        if(categoria.getId()!=null){
            Optional<TablaCategory>g=categoriaCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return categoriaCrud.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            categoriaCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
