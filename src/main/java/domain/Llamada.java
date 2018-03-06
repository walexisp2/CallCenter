/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import services.LlamadaCola;
import utils.Asignacion;

/**
 *
 * @author Asus
 */
public class Llamada  {
     private long duracion;

    private int numero;
    
    


    public Llamada( int numero, long duracion )
    {
        this.numero = numero;
        this.duracion = duracion;
        
        
    }
    
    


    public long getDuracion()
    {
        return duracion;
    }

    public int getNumero()
    {
        return numero;
    }
}
