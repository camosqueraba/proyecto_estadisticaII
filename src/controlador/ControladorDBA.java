/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.fuente_variacion.Bloque;
import modelo.fuente_variacion.Total;
import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Error;
import modelo.tablas_anova.TablaAnovaDBA;
import modelo.tablas_datos.TablaDatosDBA;


/**
 *
 * @author carlos
 */
public class ControladorDBA {
    
    private TablaAnovaDBA tabla_anova_dba;

    
    
    public ControladorDBA(byte numero_tratamientos, byte numero_bloques, float tabla_datos[][] ){
        
        TablaDatosDBA datos = new TablaDatosDBA(numero_tratamientos, numero_bloques, tabla_datos);
        tabla_anova_dba = new TablaAnovaDBA(datos);
        
        tabla_anova_dba.gradosLibertad();
        tabla_anova_dba.sumaCuadrados();
        tabla_anova_dba.cuadradoMedio();
        tabla_anova_dba.fCalculada();
    }
    //TablaDatosDCA tabla = new TablaDatosDCA(0, 0);
    //TablaAnovaDCA diseño = new TablaAnovaDCA(0, 0);
    public Bloque datosBloque(){
        
        return tabla_anova_dba.getBloque_dba();
    }
    
    public Tratamiento datosTratamiento(){
        
        return tabla_anova_dba.getTratamiento_dba();
    }
    
    public Total datosTotal(){
        
        return tabla_anova_dba.getTotal_dba();
    }
    
    public Error datosError(){
        return tabla_anova_dba.getError_dba();
    }
    
    public TablaAnovaDBA getTabla_anova_dba() {
        return tabla_anova_dba;
    }
    
}
