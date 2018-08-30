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
public class TablaDatosDBA {
    
    private final byte numero_bloques;
    private final byte numero_tratamientos;
    private final byte unidades_experimentales;
    private final float datos_tabla[][];
    
    public TablaDatosDBA( byte numero_tratamientos,byte numero_bloques, float tabladatos[][] ){
        
        this.numero_bloques = numero_bloques;
        this.numero_tratamientos = numero_tratamientos;
        
        this.unidades_experimentales = (byte) (numero_bloques*numero_tratamientos);
        
        //this.datos_tabla = new float[this.numero_tratamientos][this.numero_replicas];
        this.datos_tabla = tabladatos;
        
    }

    public byte getNumero_tratamientos() {
        return numero_tratamientos;
    }

    public byte getNumero_bloques() {
        return numero_bloques;
    }

    public byte getUnidades_experimentales() {
        return unidades_experimentales;
    }
    
    
    
    public double getDatoTabla(byte tratamiento, byte replica){
        
        return datos_tabla[tratamiento][replica];
        
    }
    
    public float sumaUnidadesExperimentales(){
        
        
        float y = 0;
        
        for(byte tratamiento=0; tratamiento<numero_tratamientos; tratamiento++){
            for(byte bloque=0; bloque<numero_bloques; bloque++){
               
                y += datos_tabla[tratamiento][bloque]; 
            }
        }
        return y;
    }
    
    
    public float sumaCuadradosUnidadesExperimentales(){
        
        float cuadrados = 0; 
        
        for(byte tratamiento=0; tratamiento<numero_tratamientos; tratamiento++){
            for(byte bloque=0; bloque<numero_bloques; bloque++){
               
                
                cuadrados += pow(datos_tabla[tratamiento][bloque],2); 
                
            }
        }
        return cuadrados;
    }
    
    public float factorCorreccion(){
        
        float factor_correccion = 0;
        float suma_unidades = this.sumaUnidadesExperimentales();
        
        factor_correccion =(float)( pow(suma_unidades,2)/this.unidades_experimentales);
        
        return factor_correccion;
    }
    
    public float sumatoriaTratamientosCuadrado(){
        
        float y = 0;
        float auxtratamiento = 0;
        float suma_tratamiento = 0;
        
        for(byte tratamiento=0; tratamiento<numero_tratamientos; tratamiento++){
            for(byte bloque=0; bloque<numero_bloques; bloque++){
               
                y += datos_tabla[tratamiento][bloque]; 
            }
            suma_tratamiento = (float)pow(y,2);
            auxtratamiento += suma_tratamiento/numero_bloques;  
            y = 0;
        }
        return auxtratamiento;
    }
    
    
    public float sumatoriaBloquesCuadrado(){
        
        float y = 0;
        float auxbloque = 0;
        float suma_bloque = 0;
        
        
            for(byte bloque=0; bloque<numero_bloques; bloque++){
                for(byte tratamiento=0; tratamiento<numero_tratamientos; tratamiento++){
               
                y += datos_tabla[tratamiento][bloque]; 
            }
            suma_bloque = (float)pow(y,2);
            auxbloque += suma_bloque/numero_tratamientos;  
            y = 0;
        }
        return auxbloque;
    }
    
}
