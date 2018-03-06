
package services;

import domain.Director;
import domain.Llamada;
import domain.Operador;
import domain.Supervisor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import utils.Asignacion;


public class Dispatcher{
    
    private SimpleDateFormat formato;

    private Asignacion aleatorio;

    private boolean ejecucion;
    
    LinkedList<Operador> operadorLista;
    LinkedList<Supervisor> supervisorLista;
    LinkedList<Director> directorLista;


    public Dispatcher()
    {
        operadorLista = new LinkedList<Operador>();
        supervisorLista = new LinkedList<Supervisor>();
        directorLista = new LinkedList<Director>();
        
        aleatorio = new Asignacion();
        formato = new SimpleDateFormat( "HH:mm:ss" );
    }



    public void llamadaGenerar()
    {
        GenerarLlamada gl = new GenerarLlamada();
        gl.start();
    }

    
    
    public void generarEmpleado()
    {
        Asignacion asig = new Asignacion();
        for (int i = 0; i < 9; i++) {
            
            Operador operador = new Operador(i+1, asig.generarNombre(Asignacion.Cargos.OPERADOR, i),Asignacion.Cargos.OPERADOR);
            operadorLista.add(operador);
            
        }
        
        for (int i = 0; i < 4; i++) {
            
            Supervisor supervisor = new Supervisor(i+1, asig.generarNombre(Asignacion.Cargos.SUPERVISOR, i), Asignacion.Cargos.SUPERVISOR);
            supervisorLista.add(supervisor);
            
        }
        
        for (int i = 0; i < 3; i++) {
            
            Director director = new Director(i+1,asig.generarNombre(Asignacion.Cargos.DIRECTOR, i),Asignacion.Cargos.DIRECTOR);
            directorLista.add(director);
            
        }
        
    }
    
    public void generarEmpleadoOcupado()
    {
        Asignacion asig = new Asignacion();
        for (int i = 0; i < 9; i++) {
            
            Operador operador = new Operador(i+1, asig.generarNombre(Asignacion.Cargos.OPERADOR, i),Asignacion.EstadoEmpleado.OCUPADO,Asignacion.Cargos.OPERADOR);
            operadorLista.add(operador);
            
        }
        
        for (int i = 0; i < 4; i++) {
            
            Supervisor supervisor = new Supervisor(i+1, asig.generarNombre(Asignacion.Cargos.SUPERVISOR, i),Asignacion.EstadoEmpleado.OCUPADO, Asignacion.Cargos.SUPERVISOR);
            supervisorLista.add(supervisor);
            
        }
        
        for (int i = 0; i < 3; i++) {
            
            Director director = new Director(i+1,asig.generarNombre(Asignacion.Cargos.DIRECTOR, i),Asignacion.EstadoEmpleado.OCUPADO,Asignacion.Cargos.DIRECTOR);
            directorLista.add(director);
            
        }
        
    }
    
    
    public void dispatchCall()
    {
        //llamadaGenerar();
        generarEmpleado();
        
        ListIterator<Operador> lstOperador = operadorLista.listIterator();
        while(lstOperador.hasNext())
        {
            Operador oper = lstOperador.next();
            if (oper.getEstado() == Asignacion.EstadoEmpleado.LIBRE) {
                
                //oper.getLlamada();
                oper.start();
                return;
                
            }
        }
        
        ListIterator<Supervisor> lstSupervisor = supervisorLista.listIterator();
        while(lstSupervisor.hasNext())
        {
            Supervisor sup = lstSupervisor.next();
            if (sup.getEstado() == Asignacion.EstadoEmpleado.LIBRE) {
                
                sup.getLlamada();
                return;
                
            }
        }
        
        ListIterator<Director> lstDirector = directorLista.listIterator();
        while(lstDirector.hasNext())
        {
            Director dir = lstDirector.next();
            if (dir.getEstado() == Asignacion.EstadoEmpleado.LIBRE) {
                
                dir.getLlamada();
                return;
                
            }
        }
        
    }
    
}