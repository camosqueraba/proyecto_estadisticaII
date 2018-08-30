/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Error;
import modelo.fuente_variacion.Total;
import modelo.tablas_anova.TablaAnovaDCA;
import modelo.tablas_datos.TablaDatosDCA;

/**
 *
 * @author carlos
 */
public class ControladorDCA {
    
    private TablaAnovaDCA tabla_anova_dca;

    
    
    public ControladorDCA(byte numero_tratamientos, byte numero_replicas, double tabla_datos[][] ){
        
        TablaDatosDCA datos = new TablaDatosDCA(numero_tratamientos, numero_replicas, tabla_datos);
        tabla_anova_dca = new TablaAnovaDCA(datos);
        
        tabla_anova_dca.gradosLibertad();
        tabla_anova_dca.sumaCuadrados();
        tabla_anova_dca.cuadradoMedio();
        tabla_anova_dca.fCalculada();
    }
    //TablaDatosDCA tabla = new TablaDatosDCA(0, 0);
    //TablaAnovaDCA diseño = new TablaAnovaDCA(0, 0);
    public Tratamiento datosTratamiento(){
        
        return tabla_anova_dca.getTratamiento_dca();
    }
    
    public Total datosTotal(){
        
        return tabla_anova_dca.getTotal_dca();
    }
    
    public Error datosError(){
        return tabla_anova_dca.getError_dca();
    }
    
    public TablaAnovaDCA getTabla_anova_dca() {
        return tabla_anova_dca;
    }
}
