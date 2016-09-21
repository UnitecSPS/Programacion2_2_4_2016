/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exa2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Aula
 */
public class Empresa {
    private RandomAccessFile re, rr;
    int cont=0;
    
    public Empresa(){
        try{
            re = new RandomAccessFile("empleados.bis", "rw");
            rr = new RandomAccessFile("recibos.bis", "rw");
        }
        catch(IOException e){
            
        }
    }
    
    public int nextCode(){
        return cont++;
    }
    
    public void contratar(String n, double sal, TasaComision t)throws IOException{
        re.seek(re.length());
        //codigo
        re.writeInt(nextCode());
        //nombre
        re.writeUTF(n);
        //tasa
        re.writeUTF(t.name());
        //salario
        re.writeDouble(sal);
        //ventas
        for(int x=0; x < 12; x++){
            re.writeDouble(0);
            re.writeBoolean(false);
        }
    }
    
    private int mesActual(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH);
    }
    
    public void agregarVenta(int cod, double vent)throws IOException{
        if(vent < 0)
            throw new IllegalArgumentException("Venta lps "+vent+ " invalida");
        re.seek(0);
        while(re.getFilePointer() < re.length()){
            int codi = re.readInt();
            re.readUTF();
            re.readUTF();
            re.readDouble();
            if(codi == cod){
                //venta
                int offset = mesActual() * 9;
                re.skipBytes(offset);
                double va = re.readDouble();
                if(!re.readBoolean()){
                    re.seek(re.getFilePointer()-9);
                    re.writeDouble(va+vent);
                    break;
                }
            }
            else{
                re.skipBytes(108);
            }
        }
    }
    
    public double pagarA(int codigo)throws IOException{
        re.seek(0);
        while(re.getFilePointer() < re.length()){
            int cod = re.readInt();
            re.readUTF();
            TasaComision t = TasaComision.valueOf(re.readUTF());
            double salario = re.readDouble();
            
            if(cod == codigo){
                //venta
                int offset = mesActual()*9;
                re.skipBytes(offset);
                double va = re.readDouble();
                if(!re.readBoolean()){
                    double pagar = salario+(va*t.tasa)-(salario*0.035);
                    //ya pague la venta
                    re.seek(re.getFilePointer()-1);
                    re.writeBoolean(true);
                    //generamos un recibo-------
                    rr.seek(rr.length());
                    rr.writeInt(cod);
                    rr.writeLong( new Date().getTime() );
                    rr.writeInt(mesActual());
                    rr.writeDouble(pagar);
                    return pagar;
                }
                else
                    return 0;
            }
            else
                re.skipBytes(108);
        }
        
        return 0;
    }
    
    public void empleados()throws IOException{
        re.seek(0);
        while(re.getFilePointer() < re.length()){
            int cod = re.readInt();
            String n = re.readUTF();
            String t = re.readUTF();
            double sal = re.readDouble();
            double ventas=0;
            for(int v=0; v < 12; v++){
                ventas += re.readDouble();
                re.skipBytes(1);
            }
            System.out.println(cod+n+t+sal+ventas);
        }
    }
    
    public void constancia(int cod, Date desde)throws IOException{
        re.seek(0);
        while(re.getFilePointer() < re.length()){
            int codigo = re.readInt();
            String n = re.readUTF();
            re.readUTF();
            double sal = re.readDouble();
            re.skipBytes(108);
            
            if(codigo == cod){
                //escribamos en el txt-------
                FileWriter fw = new FileWriter("constancia"+cod+".doc");
                fw.write(codigo+"-"+n+"- Lps."+sal);
                rr.seek(0);
                while(rr.getFilePointer() < rr.length()){
                    int ce = rr.readInt();
                    Date fech = new Date(rr.readLong());
                    int mes = rr.readInt();
                    double pagado = rr.readDouble();
                    if(cod==ce && fech.after(desde))
                        fw.write(mes+"-"+fech+"-"+pagado);
                }
                fw.close();
                //---------------------------
            }
        }
    }
    
    public void cambioPerido()throws IOException{
        re.seek(0);
        while(re.getFilePointer() < re.length()){
            re.readInt();
            re.readUTF();
            re.readUTF();
            re.readDouble();
            for(int v=0; v < 12; v++){
                re.writeDouble(0);
                re.writeBoolean(false);
            }
        }
    }
}
