/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.fuente_variacion.Hilera;
import modelo.fuente_variacion.Columna;
import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Total;
import modelo.fuente_variacion.Error;
import modelo.tablas_anova.TablaAnovaDCL;
import modelo.tablas_datos.TablaDatosDCL;

/**
 *
 * @author carlos
 */
public class ControladorDCL {
    
    private TablaAnovaDCL tabla_anova_dcl;
    
    public ControladorDCL(byte numero_tratamientos, float valor_tratamientos[], float tabla_datos[][]){
        
        TablaDatosDCL datos = new TablaDatosDCL(numero_tratamientos, valor_tratamientos, tabla_datos);
        
        tabla_anova_dcl = new TablaAnovaDCL(datos);
        
        tabla_anova_dcl.gradosLibertad();
        tabla_anova_dcl.sumaCuadrados();
        tabla_anova_dcl.cuadradoMedio();
        tabla_anova_dcl.fCalculada();
        
    }
    
    public Hilera datosHilera(){
        
        return tabla_anova_dcl.getHilera_dcl();
    }
    
    public Columna datosColumna(){
        
        return tabla_anova_dcl.getColumna_dcl();
    }
    
    public Tratamiento datosTratamiento(){
        
        return tabla_anova_dcl.getTratamiento_dcl();
    }
    
    public Total datosTotal(){
        
        return tabla_anova_dcl.getTotal_dcl();
    }
    
    public Error datosError(){
        
        return tabla_anova_dcl.getError_dcl();
    }
    
}
