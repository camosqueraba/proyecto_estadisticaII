/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas_anova;

import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Error;
import modelo.fuente_variacion.Total;

/**
 *
 * @author carlos
 */
public class TablaAnovaDCA {
    
    private Tratamiento tratamiento_dca ;
    private Error error_dca;
    private Total total_dca;
    
    public TablaAnovaDCA(byte numero_tratamientos, byte numero_repeticiones){
        
        tratamiento_dca = new Tratamiento();
        error_dca = new Error();
        total_dca = new Total();
        
    }
    
    public void gradosLibertad(byte numero_tratamientos){
        
        tratamiento_dca.setGrados_libertad((byte)(numero_tratamientos-1));
        
    }
    
}
