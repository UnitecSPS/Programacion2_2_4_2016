/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.exalab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Sky {
    private ArrayList<Servicio> services;
    private Scanner x = new Scanner(System.in);

    public Sky() {
        services = new ArrayList<>();
    }
    
    private Servicio search(int cod){
        for(Servicio serv : services){
            if(serv.getCodigo() == cod)
                return serv;
        }
        return null;
    }
    
    public void agregarServicio(int codigo,String nombre, TipoServicio tipo){
        if(search(codigo) == null){
            switch(tipo){
                case INTERNET:
                    services.add(new InternetService(nombre, codigo, AnchoBanda.valueOf(x.next())));
                    break;
                case TV:
                    services.add(new TVService(nombre,codigo,x.next().equalsIgnoreCase("DIGITAL")));
                    break;

            }
        }
    }
    
    public void imprimirServicios(){
        int tv = 0, i = 0;
        for(Servicio u : services){
            System.out.println(u);
            if(u instanceof TVService){
                tv++;
                ((TVService) u).imprimir(0);
            }
            else
                i++;
        }
        System.out.println("Servicio de intenet: "+i+" Servicio de cable: "+tv);
    }
    
    public void agregarCanalAServicioTV(int codigo,String canal){
        Servicio serv = search(codigo);
        if(serv instanceof TVService)
            ((TVService)serv).agregarCanal(canal);
    }
    
    public void cobrar(int codigo){
        Servicio serv = search(codigo);
        System.out.println("Pago: "+serv.getMontoMensual());
    }
    
}
