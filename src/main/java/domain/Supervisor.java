/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import services.LlamadaCola;
import utils.Asignacion;

/**
 *
 * @author Asus
 */
public class Supervisor extends Empleado{
    
    public Supervisor(int codigo,String nombre,Asignacion.EstadoEmpleado estado,Asignacion.Cargos cargo)
    {
        super(codigo,nombre,estado,cargo);
    }
    
    public Supervisor(int codigo,String nombre,Asignacion.Cargos cargo)
    {
        super(codigo,nombre,cargo);
    }
    
    @Override 
    public Llamada getLlamada()
    {
        return LlamadaCola.recuperarLlamada();
    }
    
    
    
    
    
}
