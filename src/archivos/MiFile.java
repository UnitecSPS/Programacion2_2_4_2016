/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
            System.out.println("Folder: "+mifile.getName());
            int dirs=0, files=0, bytes=0;
            //Muestren su contenido
            for(File child : mifile.listFiles()){
                //2-ultima mofif
                System.out.print(new Date(child.lastModified()));
                //3-Si es DIR
                if(child.isDirectory()){
                    System.out.print("\t<DIR>\t ");
                    dirs++;
                }
                //4-Si es File imprimo los bytes
                if(child.isFile()){
                    System.out.print("\t     \t ");
                    System.out.print(child.length());
                    files++;
                    bytes += child.length();
                }
                
                //5-Imprimo el nombre
                System.out.println("\t"+child.getName());
            }
            
            //6-imprimo la cantidad de files y dirs que tiene
            System.out.println("("+files+") files y ("+dirs+") dirs");
            //7-Imprimir la suma total de bytes
            System.out.println(bytes+ " bytes.");
            //8-Bytes free miren que funcion en File les puede servir
            System.out.println(mifile.getFreeSpace()+" bytes free");
        }
        else
            System.out.println("Accion no permitida");
    }

    void tree() {
        tree(mifile,"");
    }

    private void tree(File dir, String tab) {
        if(dir.isDirectory() && !dir.isHidden()){
            System.out.println(tab+dir.getName());
            for(File child : dir.listFiles()){
                tree(child,tab+"--");
            }
        }
    }

    void writeText(boolean append)throws IOException {
        try(FileWriter fw = new FileWriter(mifile, append)){
            do{
                String txt = FileTest.lea.nextLine();

                if(!txt.equals(":q")){
                    fw.write(txt+"\n");
                    //fw.flush();
                }
                else
                    break;

            }while(true);
        }
    }
    
    void biggerFile(){
        File f = fileMaxFor();
        if(f!=null)
            System.out.println(f.getName()+"-"+f.length()+" bytes.");
        else
            System.out.println("No se encontro ninguno.");
    }
    
    /**
     * PRUEBA 4 pauta
     * @return 
     */
    File fileMaxFor(/*String path*/){
        //File mifile = new File(path);
        
        File mayor = null;
        long bmax = 0;
        
        if(mifile.isDirectory()){
            for(File child : mifile.listFiles()){
                if(child.isFile() && !child.isHidden()){
                    if(child.length() > bmax){
                        mayor = child;
                        bmax = child.length();
                    }
                }
            }
        }
        
        return mayor;
    }

    void readText() throws IOException{
        try(FileReader fr = new FileReader(mifile)){
            
            char buffer[] = new char[(int)mifile.length()];
            int bytes = fr.read(buffer);
            
            System.out.println("\nCONTENIDO:\n-------------");
            System.out.println(buffer);
            System.out.println("Bytes leidos: "+bytes);
        
        }
    }
    
}
