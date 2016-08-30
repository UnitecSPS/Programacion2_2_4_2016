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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
