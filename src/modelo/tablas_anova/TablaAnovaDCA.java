/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas_anova;

import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Error;
import modelo.fuente_variacion.Total;
import modelo.tablas_datos.TablaDatosDCA;

/**
 *
 * @author carlos
 */
public class TablaAnovaDCA {
    
    private Tratamiento tratamiento_dca ;
    private Error error_dca;
    private Total total_dca;
    TablaDatosDCA tabla_dca; 
    
    public TablaAnovaDCA(TablaDatos){
        
        this.tabla_dca = tabla_dca;
        tratamiento_dca = new Tratamiento();
        error_dca = new Error();
        total_dca = new Total();
        
    }
    
    public void gradosLibertad(byte numero_tratamientos, byte numero_repeticiones){
        
        byte grados_libertad_error;
        
        tratamiento_dca.setGrados_libertad((byte)(numero_tratamientos-1));
        total_dca.setGrados_libertad((byte)((numero_tratamientos * numero_repeticiones)-1));
        
        grados_libertad_error = (byte)(total_dca.getGrados_libertad() - tratamiento_dca.getGrados_libertad());
        
        error_dca.setGrados_libertad(grados_libertad_error);
        
    }
    
    public void sumaCuadrados(){
        
        
        total_dca.setSuma_cuadrados(0);
        tratamiento_dca.setSuma_cuadrados(0);
        
    }
    
    
    
}
