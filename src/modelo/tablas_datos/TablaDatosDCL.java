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
public class TablaDatosDCL {
    
    private final byte numero_tratamientos;
    private final byte numero_hileras;
    private final byte numero_columnas;
    private final byte unidades_experimentales;
    private final float valor_tratamientos[];
    private final double datos_tabla[][][];
    
    
    public TablaDatosDCL(byte numero_tratamientos, float[] valor_tratamientos, double[][][] datos_tabla) {
        
        this.numero_tratamientos = numero_tratamientos;
        this.numero_hileras = numero_tratamientos;
        this.numero_columnas = numero_tratamientos;
        this.unidades_experimentales =(byte)( numero_tratamientos*numero_tratamientos);
        this.valor_tratamientos = valor_tratamientos;
        this.datos_tabla = datos_tabla;
    }

    public byte getNumero_tratamientos() {
        return numero_tratamientos;
    }

    public byte getNumero_hileras() {
        return numero_hileras;
    }

    public byte getNumero_columnas() {
        return numero_columnas;
    }

    public byte getUnidades_experimentales() {
        return unidades_experimentales;
    }

    public float getValor_tratamiento(byte n) {
        return valor_tratamientos[n-1];
    }
    
    public float sumaUnidadesExperimentales(){
        
        byte tratamiento = 0;
        float y = 0;
        
        for(byte hilera=0; hilera<numero_hileras; hilera++){
            for(byte columna=0; columna<numero_columnas; columna++){
               
                y += datos_tabla[hilera][columna][tratamiento]; 
            }
        }
        return y;
    }
    
    
    public float factorCorreccion(){
        
        float factor_correccion = 0;
        float suma_unidades = this.sumaUnidadesExperimentales();
        
        factor_correccion =(float)( pow(suma_unidades,2)/this.unidades_experimentales);
        
        return factor_correccion;
    }
    
    public float sumaCuadradosUnidadesExperimentales(){
        
        float cuadrados = 0; 
        byte valor = 0;
        for(byte hilera=0; hilera<numero_hileras; hilera++){
            for(byte columna=0; columna<numero_columnas; columna++){
               
                
                cuadrados += pow(datos_tabla[hilera][columna][valor],2); 
                
            }
        }
        return cuadrados;
    }
    
    public float sumatoriaTratamientosCuadrado(){
        
        float sumatoria_cuadrados = 0;
        byte valor = 0;
         
        for(byte tratamiento = 0; tratamiento<numero_tratamientos; tratamiento++){
            for(byte hilera=0; hilera<numero_hileras; hilera++){
                for(byte columna=0; columna<numero_columnas; columna++){
                    if (tratamiento == (byte)(datos_tabla[hilera][columna][1])) {
               
                        sumatoria_cuadrados = (float) pow((datos_tabla[hilera][columna][valor]),2);
                    }
                }
           }
        }
           return sumatoria_cuadrados/numero_tratamientos; 
    }
    
    public float sumatoriaHilerasCuadrado(){
        
        float y = 0;
        float auxhilera = 0;
        float suma_hilera = 0;
        byte valor = 0;
        
        for(byte hilera=0; hilera<numero_hileras; hilera++){
            for(byte columna=0; columna<numero_columnas; columna++){
               
                y += datos_tabla[hilera][columna][valor]; 
            }
            suma_hilera = (float)pow(y,2);
            auxhilera += suma_hilera/numero_hileras;  
            y = 0;
        }
        return auxhilera;
    }
    
    
    public float sumatoriaColumnasCuadrado(){
        
        float y = 0;
        float auxcolumna = 0;
        float suma_columna = 0;
        byte valor = 0;
        
            for(byte columna=0; columna<numero_columnas; columna++){
                for(byte hilera=0; hilera<numero_hileras; hilera++){
               
                y += datos_tabla[hilera][columna][valor]; 
            }
            suma_columna = (float)pow(y,2);
            auxcolumna += suma_columna/numero_columnas;  
            y = 0;
        }
        return auxcolumna;
    }
}
