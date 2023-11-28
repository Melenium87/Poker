package Modelo.PokerSinComodin;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private int cantidad;
    private ArrayList<Carta>cartas=new ArrayList<>();

    public  Baraja(){
        cantidad=52;
        ArrayList<Carta.Tipo> tipos=new ArrayList<>();
        tipos.add(Carta.Tipo.CORAZON);
        tipos.add(Carta.Tipo.DIAMANTE);
        tipos.add(Carta.Tipo.PICA);
        tipos.add(Carta.Tipo.TREBOL);

        for (int i=0;i<4;i++){
            for (int x=1;x<=13;x++){
                Carta c =new Carta(tipos.get(i),x);
                cartas.add(c);
            }
        }
        barajar();
    }
    public ArrayList<Carta> darCartas(int numero){
        ArrayList<Carta> cartasNuevas=new ArrayList<>();
        for (int i=0;i<numero;i++){
            cartasNuevas.add(cartas.get(0));
            cartas.remove(0);
        }
        return cartasNuevas;
    }
    public ArrayList<Carta> repartir(){
        ArrayList<Carta> cartasRepartidas=new ArrayList<>();
        for (int i=0;i<5;i++){
            cartasRepartidas.add(cartas.get(0));
            cartas.remove(0);
        }
        return cartasRepartidas;
    }

    public void recibirCartas(ArrayList<Carta> c){
        cartas.addAll(c);
        Collections.shuffle(cartas);
    }

    public void barajar(){
        Collections.shuffle(cartas);
    }
// Hecho unicamente para prueba de las mesclas
    @Override
    public String toString() {
        String s="";
        for (Carta c:cartas){
            s=s.concat(c.toString());
            s=s.concat("\n");
        }
        return s;
    }

}

