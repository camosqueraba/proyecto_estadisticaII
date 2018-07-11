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
    private TablaDatosDCA tabla_datos_dca;
    private byte numero_tratamientos;
    private byte numero_repeticiones;
    
    public TablaAnovaDCA(TablaDatosDCA tabla_dca){
        
        this.tabla_datos_dca = tabla_dca;
        tratamiento_dca = new Tratamiento();
        error_dca = new Error();
        total_dca = new Total();
        numero_tratamientos = tabla_dca.getNumero_tratamientos();
        numero_repeticiones = tabla_dca.getNumero_replicas();
        
    }
    
    public void gradosLibertad(){
        
        byte grados_libertad_error;
        
        tratamiento_dca.setGrados_libertad((byte)(numero_tratamientos-1));
        total_dca.setGrados_libertad((byte)((tabla_datos_dca.getUnidades_experimentales())-1));
        
        grados_libertad_error = (byte)(total_dca.getGrados_libertad() - tratamiento_dca.getGrados_libertad());
        
        error_dca.setGrados_libertad(grados_libertad_error);
        
    }
    
    public void sumaCuadrados(){
        
        float factor_correccion = tabla_datos_dca.factorCorreccion();
        float suma_cuadrados_unidades_experimentales = tabla_datos_dca.sumaCuadradosUnidadesExperimentales();
        float suma_tratamientos_cuadrado = tabla_datos_dca.sumatoriaTratamientosCuadrado();
        
        total_dca.setSuma_cuadrados(suma_cuadrados_unidades_experimentales-factor_correccion);
        tratamiento_dca.setSuma_cuadrados(suma_tratamientos_cuadrado-factor_correccion);
        error_dca.setSuma_cuadrados(total_dca.getSuma_cuadrados()-tratamiento_dca.getSuma_cuadrados());
        
    }
    
    public void cuadradoMedio(){
        
        tratamiento_dca.setCuadrado_medio(tratamiento_dca.getSuma_cuadrados()/tratamiento_dca.getGrados_libertad());
        error_dca.setCuadrado_medio(error_dca.getSuma_cuadrados()/error_dca.getGrados_libertad());
    }
    
    public void fCalculada(){
        
        tratamiento_dca.setF_calculada(tratamiento_dca.getCuadrado_medio()/error_dca.getCuadrado_medio());
    }
    public Tratamiento getTratamiento_dca() {
        return tratamiento_dca;
    }

    public Error getError_dca() {
        return error_dca;
    }

    public Total getTotal_dca() {
        return total_dca;
    }
    
    
    
}
