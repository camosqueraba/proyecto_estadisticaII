/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas_anova;

import modelo.fuente_variacion.Hilera;
import modelo.fuente_variacion.Columna;
import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Total;
import modelo.fuente_variacion.Error;
import modelo.tablas_datos.TablaDatosDCL;

/**
 *
 * @author carlos
 */
public class TablaAnovaDCL {
    
    private Tratamiento tratamiento_dcl ;
    private Hilera hilera_dcl;
    private Columna columna_dcl;
    private Error error_dcl;
    private Total total_dcl;
    private TablaDatosDCL tabla_datos_dcl;
    private byte numero_tratamientos;
    private byte numero_hileras;
    private byte numero_columnas;
    
    public TablaAnovaDCL (TablaDatosDCL tabla_dcl){
        
        this.tabla_datos_dcl = tabla_dcl;
        hilera_dcl = new Hilera();
        columna_dcl = new Columna();
        tratamiento_dcl = new Tratamiento();
        error_dcl = new Error();
        total_dcl = new Total();
        numero_tratamientos = tabla_dcl.getNumero_tratamientos();
        numero_hileras = tabla_dcl.getNumero_hileras();
        numero_columnas = tabla_dcl.getNumero_columnas();
    
    }
    
    public void gradosLibertad(){
        
        columna_dcl.setGrados_libertad((byte)(numero_columnas - 1));
        hilera_dcl.setGrados_libertad((byte)(numero_hileras - 1));
        tratamiento_dcl.setGrados_libertad((byte)(numero_tratamientos - 1));
        
        total_dcl.setGrados_libertad((byte)((tabla_datos_dcl.getUnidades_experimentales())-1));
        error_dcl.setGrados_libertad((byte)(total_dcl.getGrados_libertad() - (tratamiento_dcl.getGrados_libertad() + hilera_dcl.getGrados_libertad() + columna_dcl.getGrados_libertad())));
    }
    
    public void sumaCuadrados(){
        
        float factor_correcion = tabla_datos_dcl.factorCorreccion();
        
        hilera_dcl.setSuma_cuadrados(tabla_datos_dcl.sumatoriaHilerasCuadrado() - factor_correcion);
        columna_dcl.setSuma_cuadrados(tabla_datos_dcl.sumatoriaColumnasCuadrado() - factor_correcion);
        tratamiento_dcl.setSuma_cuadrados(tabla_datos_dcl.sumatoriaTratamientosCuadrado() - factor_correcion);
        total_dcl.setSuma_cuadrados(tabla_datos_dcl.sumaCuadradosUnidadesExperimentales() - factor_correcion);
        error_dcl.setSuma_cuadrados(total_dcl.getSuma_cuadrados() - (hilera_dcl.getSuma_cuadrados() + columna_dcl.getSuma_cuadrados() + tratamiento_dcl.getSuma_cuadrados() ));
    }
    
    public void cuadradoMedio(){
        
        byte grados_libertad = tratamiento_dcl.getGrados_libertad();
        
        hilera_dcl.setCuadrado_medio(hilera_dcl.getSuma_cuadrados()/grados_libertad);
        columna_dcl.setCuadrado_medio(columna_dcl.getSuma_cuadrados()/grados_libertad);
        tratamiento_dcl.setCuadrado_medio(tratamiento_dcl.getSuma_cuadrados()/grados_libertad);
        error_dcl.setCuadrado_medio(error_dcl.getSuma_cuadrados()/error_dcl.getGrados_libertad());
        
    }
    
    public void fCalculada(){
        
        float cuadrado_medio_error = error_dcl.getCuadrado_medio();
        
        hilera_dcl.setF_calculada(hilera_dcl.getCuadrado_medio()/cuadrado_medio_error);
        columna_dcl.setF_calculada(columna_dcl.getCuadrado_medio()/cuadrado_medio_error);
        tratamiento_dcl.setF_calculada(tratamiento_dcl.getCuadrado_medio()/cuadrado_medio_error);
    }

    public Tratamiento getTratamiento_dcl() {
        return tratamiento_dcl;
    }

    public Hilera getHilera_dcl() {
        return hilera_dcl;
    }

    public Columna getColumna_dcl() {
        return columna_dcl;
    }

    public Error getError_dcl() {
        return error_dcl;
    }

    public Total getTotal_dcl() {
        return total_dcl;
    }
    
    public TablaDatosDCL getTabla_datos_dcl() {
        return tabla_datos_dcl;
    }
    
    
}
