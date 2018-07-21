/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas_datos;

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
    private final float datos_tabla[][];
    
    
    public TablaDatosDCL(byte numero_tratamientos, byte numero_hileras, byte numero_columnas, byte unidades_experimentales, float[] valor_tratamientos, float[][] datos_tabla) {
        
        this.numero_tratamientos = numero_tratamientos;
        this.numero_hileras = numero_hileras;
        this.numero_columnas = numero_columnas;
        this.unidades_experimentales = unidades_experimentales;
        this.valor_tratamientos = valor_tratamientos;
        this.datos_tabla = datos_tabla;
    }
    
}
