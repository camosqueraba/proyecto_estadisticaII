/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.tablas_anova.TablaAnovaDCA;
import modelo.tablas_datos.TablaDatosDCA;

/**
 *
 * @author carlos
 */
public class ControladorDCA {
    
    public ControladorDCA(byte numero_tratamientos, byte numero_replicas, float tabla_datos[][] ){
        
        TablaDatosDCA datos = new TablaDatosDCA(numero_tratamientos, numero_replicas, tabla_datos);
        
        datos.factorCorreccion();
        datos.
                
        TablaAnovaDCA tabla_anova_dca = new TablaAnovaDCA(datos);
    }
    //TablaDatosDCA tabla = new TablaDatosDCA(0, 0);
    //TablaAnovaDCA diseño = new TablaAnovaDCA(0, 0);
    
}
