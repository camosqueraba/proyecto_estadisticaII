/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas_anova;

import modelo.fuente_variacion.Bloque;
import modelo.fuente_variacion.Tratamiento;
import modelo.fuente_variacion.Error;
import modelo.fuente_variacion.Total;

import modelo.tablas_datos.TablaDatosDBA;

/**
 *
 * @author carlos
 */
public class TablaAnovaDBA {
    
    private Tratamiento tratamiento_dba ;
    private Bloque bloque_dba;
    private Error error_dba;
    private Total total_dba;
    private TablaDatosDBA tabla_datos_dba;
    private byte numero_tratamientos;
    private byte numero_bloques;
    
    public TablaAnovaDBA(TablaDatosDBA tabla_dba){
        
        this.tabla_datos_dba = tabla_dba;
        bloque_dba = new Bloque();
        tratamiento_dba = new Tratamiento();
        error_dba = new Error();
        total_dba = new Total();
        numero_tratamientos = tabla_dba.getNumero_tratamientos();
        numero_bloques = tabla_dba.getNumero_bloques();
        
    }
    
    public void gradosLibertad(){
        
        //byte grados_libertad_error;
        
        tratamiento_dba.setGrados_libertad((byte)(numero_tratamientos-1));
        bloque_dba.setGrados_libertad((byte)(numero_bloques-1));
        total_dba.setGrados_libertad((byte)((tabla_datos_dba.getUnidades_experimentales())-1));
        error_dba.setGrados_libertad((byte)(total_dba.getGrados_libertad() - (tratamiento_dba.getGrados_libertad()+bloque_dba.getGrados_libertad())));
        //grados_libertad_error = (byte)(total_dba.getGrados_libertad() - tratamiento_dba.getGrados_libertad());
        
        //error_dba.setGrados_libertad(grados_libertad_error);
        
    }
    
    public void sumaCuadrados(){
        
        float factor_correccion = tabla_datos_dba.factorCorreccion();
        float suma_cuadrados_unidades_experimentales = tabla_datos_dba.sumaCuadradosUnidadesExperimentales();
        float suma_tratamientos_cuadrado = tabla_datos_dba.sumatoriaTratamientosCuadrado();
        float suma_bloques_cuadrado = tabla_datos_dba.sumatoriaBloquesCuadrado();
        
        total_dba.setSuma_cuadrados(suma_cuadrados_unidades_experimentales-factor_correccion);
        bloque_dba.setSuma_cuadrados(suma_bloques_cuadrado - factor_correccion);
        tratamiento_dba.setSuma_cuadrados(suma_tratamientos_cuadrado-factor_correccion);
        error_dba.setSuma_cuadrados(total_dba.getSuma_cuadrados()-(tratamiento_dba.getSuma_cuadrados()+bloque_dba.getSuma_cuadrados()));
        
    }
    
    public void cuadradoMedio(){
        
        bloque_dba.setCuadrado_medio(bloque_dba.getSuma_cuadrados()/bloque_dba.getGrados_libertad());
        tratamiento_dba.setCuadrado_medio(tratamiento_dba.getSuma_cuadrados()/tratamiento_dba.getGrados_libertad());
        error_dba.setCuadrado_medio(error_dba.getSuma_cuadrados()/error_dba.getGrados_libertad());
        
    }
    
    public void fCalculada(){
        
        bloque_dba.setF_calculada(bloque_dba.getCuadrado_medio()/error_dba.getCuadrado_medio());
        tratamiento_dba.setF_calculada(tratamiento_dba.getCuadrado_medio()/error_dba.getCuadrado_medio());
    }
    
    public Bloque getBloque_dba(){
        
        return bloque_dba;
    }
    
    public Tratamiento getTratamiento_dba() {
        return tratamiento_dba;
    }

    public Error getError_dba() {
        return error_dba;
    }

    public Total getTotal_dba() {
        return total_dba;
    }
    
     public TablaDatosDBA getTabla_datos_dba() {
        return tabla_datos_dba;
    }
    
}
