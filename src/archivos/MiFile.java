/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class MiFile {
    private File mifile = null;

    void setFile(String direccion) {
        mifile = new File(direccion);
    }
    
    void info(){
        if(mifile.exists()){
            System.out.println("\nNombre: "+mifile.getName());
            System.out.println("Path: "+mifile.getPath());
            System.out.println("Absoluta:"+mifile.getAbsolutePath());
            System.out.println("Bytes: "+mifile.length());
            System.out.println("Modificado en: "+new Date(mifile.lastModified()));
            System.out.println("Padre: "+mifile.getAbsoluteFile().getParentFile().getName());
            
            if(mifile.isFile()){
                System.out.println("ES FILE");
            }
            else if(mifile.isDirectory()){
                System.out.println("ES DIRECTORIO");
            }
            
            if(mifile.isHidden())
                System.out.println("OCULTO");
            
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        }
        else{
            System.out.println("No Existe");
        }
    }

    boolean crear()throws IOException {
        return mifile.createNewFile();
    } 

    boolean crearDir() {
        return mifile.mkdirs();
    }

    boolean borrar() {
        return mifile.delete();
    }

    void dir() {
        if(mifile.isDirectory()){
            //1- Imprimen el nombre
            
            //Muestren su contenido
            for(File child : mifile.listFiles()){
                //2-ultima mofif
                
                //3-Si es DIR
                
                //4-Si es File imprimo los bytes
                
                //5-Imprimo el nombre
            }
            
            //6-imprimo la cantidad de files y dirs que tiene
            //7-Imprimir la suma total de bytes
            //8-Bytes free miren que funcion en File les puede servir
        }
        else
            System.out.println("Accion no permitida");
    }
    
    
    
}
