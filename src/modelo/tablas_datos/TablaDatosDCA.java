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
    private final double datos_tabla[][];
    
    public TablaDatosDCA(byte numero_tratamientos, byte numero_replicas, double tabladatos[][] ){
        
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
    
    
    
    public double getDatoTabla(byte tratamiento, byte replica){
        
        return datos_tabla[tratamiento][replica];
        
    }
    
    public float sumaUnidadesExperimentales(){
        
        
        float y = 0;
        
        for(byte tratamiento=0; tratamiento<numero_tratamientos; tratamiento++){
            for(byte replica=0; replica<numero_replicas; replica++){
               
                y += datos_tabla[tratamiento][replica]; 
            }
        }
        return y;
    }
    
    
    public float sumaCuadradosUnidadesExperimentales(){
        
        float cuadrados = 0; 
        
        for(byte tratamiento=0; tratamiento<numero_tratamientos; tratamiento++){
            for(byte replica=0; replica<numero_replicas; replica++){
               
                
                cuadrados += pow(datos_tabla[tratamiento][replica],2); 
                
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
            for(byte replica=0; replica<numero_replicas; replica++){
               
                y += datos_tabla[tratamiento][replica]; 
            }
            suma_tratamiento = (float)pow(y,2);
            auxtratamiento += suma_tratamiento/numero_replicas;  
            y = 0;
        }
        return auxtratamiento;
    }
    
    
}
