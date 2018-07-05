/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas_datos;

import static java.lang.Math.pow;

/**
 *
 * @author carlos
 */
public class TablaDatosDCA {
    
    private final byte numero_tratamientos;
    private final byte numero_replicas;
    private final byte unidades_experimentales;
    private final float datos_tabla[][];
    
    public TablaDatosDCA(byte numero_tratamientos, byte numero_replicas, float tabladatos[][] ){
        
        this.numero_tratamientos = numero_tratamientos;
        this.numero_replicas = numero_replicas;
        this.unidades_experimentales = (byte) (numero_replicas*numero_tratamientos);
        
        //this.datos_tabla = new float[this.numero_tratamientos][this.numero_replicas];
        this.datos_tabla = tabladatos;
        
    }

    public byte getNumero_tratamientos() {
        return numero_tratamientos;
    }

    public byte getNumero_replicas() {
        return numero_replicas;
    }

    public byte getUnidades_experimentales() {
        return unidades_experimentales;
    }
    
    
    
    public float getDatoTabla(byte tratamiento, byte replica){
        
        return datos_tabla[tratamiento][replica];
        
    }
    
    public float sumaUnidadesExperimentales(){
        
        
        float y = 0;
        
        for(byte tratamiento=0; tratamiento<=numero_tratamientos; tratamiento++){
            for(byte replica=0; replica<=numero_replicas; replica++){
               
                y += datos_tabla[tratamiento][replica]; 
            }
        }
        return y;
    }
    
    
    public float sumaCuadradosUnidadesExperimentales(){
        
        float cuadrados = 0; 
        
        for(byte tratamiento=0; tratamiento<=numero_tratamientos; tratamiento++){
            for(byte replica=0; replica<=numero_replicas; replica++){
               
                
                cuadrados += datos_tabla[tratamiento][replica]*datos_tabla[tratamiento][replica]; 
                
            }
        }
        return cuadrados;
    }
    
    public float factorCorreccion(){
        
        float factor_correccion = 0;
        float suma_unidades = this.sumaCuadradosUnidadesExperimentales();
        
        factor_correccion =(float)( pow(suma_unidades,2)/this.unidades_experimentales);
        
        return factor_correccion;
    }
    
    
}
