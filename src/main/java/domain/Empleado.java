/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import utils.Asignacion;


public abstract class Empleado {
    
    private String nombre;
    private Asignacion.EstadoEmpleado estado;
    private Asignacion.Cargos cargo;
    private int id;

    
    
    public Empleado(int id,String nombre,Asignacion.EstadoEmpleado estado, Asignacion.Cargos cargo)
    {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.cargo = cargo;
        
    }
    
    public Empleado(int id,String nombre,Asignacion.Cargos cargo)
    {
        this.id = id;
        this.nombre = nombre;
        this.estado = Asignacion.EstadoEmpleado.LIBRE;
        this.cargo = cargo;
        
    }
    
    public Empleado(String nombre)
    {
        this.nombre = nombre;
    }
    
    public Empleado(int id)
    {
        this.id = id;
    }
    
    
    public abstract Llamada getLlamada();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignacion.Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Asignacion.Cargos cargo) {
        this.cargo = cargo;
    }

    public Asignacion.EstadoEmpleado getEstado() {
        return estado;
    }

    public void setEstado(Asignacion.EstadoEmpleado estado) {
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
