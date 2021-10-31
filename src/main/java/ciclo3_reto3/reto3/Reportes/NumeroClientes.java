/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclo3_reto3.reto3.Reportes;

import ciclo3_reto3.reto3.Modelos.TablaCliente;

/**
 *
 * @author giolo
 */
public class NumeroClientes {
    
    private Long total;
    private TablaCliente client;

    public NumeroClientes(Long total, TablaCliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public TablaCliente getClient() {
        return client;
    }

    public void setClient(TablaCliente client) {
        this.client = client;
    }
    
   
}
