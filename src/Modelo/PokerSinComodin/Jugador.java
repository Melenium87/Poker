package Modelo.PokerSinComodin;

import Controlador.ControladorApuesta;
import Controlador.ControladorDescarte;
import Vistas.Observer;
import Vistas.VerCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jugador implements DejarVerCartas{
    public void mostrarGanador(Jugador jugas) {
        notificador.notificar("El Ganador es: "+jugas.nombre+"\nCon: "+jugada.name()+" y "+puntosJugada+" puntos\nEl jugador gano: ");
        notificador.notificar(""+rondaActual.getApuestas());
    }
    public void agregarMiron(Observer o){
        notificador.agregarMiron(o);
    }

    public void mostrarGanador(ArrayList<Jugador> jugas) {
        StringBuilder texto=new StringBuilder();
        texto.append("-------------------------------\n\n");
        texto.append("Los Ganadores son: ");
        for (Jugador j:jugas){
            texto.append("\t"+j.nombre);
        }
        texto.append("-------------------------------\n\n");
        notificador.notificar(texto.toString());

    }


    private Notificador notificador;
    private ArrayList<VerCartas> mironDeCartas=new ArrayList<>();
    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }


    @Override
    public void agregarMiron(VerCartas o) {
        mironDeCartas.add(o);
    }

    @Override
    public void notificarCartas(ArrayList<String> mensaje) {
        for (VerCartas miron:mironDeCartas){
            miron.actualizarCartas(mensaje);
        }

    }

    @Override
    public void notificarJugada() {
        for (VerCartas miron:mironDeCartas){
            miron.actualizarJugada(jugada.name());
        }
    }

    @Override
    public String getState() {
        return null;
    }

    enum Juegos{
        CARTAMAYOR,
        PAREJA,
        DOBLEPAREJA,
        TRIO,
        ESCALERA,
        COLOR,
        FULLHOUSE,
        POKER,
        ESCALERACOLOR,
        REPOKER

    };
    private String nombre;



    private int puntosJugada;
    private Juegos jugada;
    private ArrayList<Carta> cartas=new ArrayList<>();
    private int fichas;
    private int fichasInicioRonda;

    private int totalApostado=0;

    private int montoGanable=0;
    private Ronda rondaActual;

    public int getMontoGanable() {
        return montoGanable;
    }
    public String getNombre() {
        return nombre;
    }

    public void setRondaActual(Ronda rondaActual) {
        this.rondaActual = rondaActual;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public Jugador(String nombre, Integer fichas){
        this.nombre=nombre;
        this.fichas=fichas;
        fichasInicioRonda=fichas;

    }

    public ArrayList<Carta> mostrarCartas(){
        return cartas;
    }
    public ArrayList<String> mostrarImagenesDeCartas(){
        ArrayList<String> direcciones=new ArrayList<String>();
        String direcicionBase="D:/Uni/Poker/Poker/Images/";
        String formato=".png";
        StringBuilder dir=new StringBuilder();
        String direccionFinal;
        dir.append(direcicionBase);
        for (Carta carta:cartas) {
            dir.append("" + carta.getTipo() + "-" + carta.getValor() + formato);
            direccionFinal = dir.toString();
            direcciones.add(direccionFinal);
            direccionFinal = null;
            dir = new StringBuilder();
            dir.append(direcicionBase);
        }
        return direcciones;
    }
    public void verCartas(){
        int car=1;
        for (Carta c:cartas){
            System.out.println("------------------ "+car+" ------------------");
            System.out.println(c);
            System.out.println("-------------------------");
        }
    }
    public void recibirCartas(ArrayList<Carta> c){
        cartas.addAll(c);
        Collections.sort(cartas);
        System.out.println("\n\n");
        notificarCartas(mostrarImagenesDeCartas());
        buscarJugada();
    }

    public void descartar(ArrayList<Integer> x){
        ArrayList<Carta> cartasDescartadas=new ArrayList<>();
        for (int i=0;i<x.size();i++){
            if (x.get(i)==1){
                cartasDescartadas.add(cartas.get(i));
            }
        }
        cartas.removeAll(cartasDescartadas);
        notificador.notificar(nombre+" Descarto: "+cartasDescartadas.size()+" cartas");
        rondaActual.recepcionDescarte(cartasDescartadas.size());
    }

    public void apostar(int apuesta){


            if (apuesta==-1){
                notificador.notificar(nombre+" se retiro.");
                rondaActual.recepcionDeApuseta(-1);
                return;
            }
            if (apuesta==0&& ! rondaActual.getHayApuestas()){
                notificador.notificar(nombre+" Paso.");
                rondaActual.recepcionDeApuseta(0);
                return;
            }
            if (apuesta>rondaActual.getApuestaMin()){
                totalApostado=apuesta;
                notificador.notificar(nombre+" Tiene apostado: "+totalApostado);
                rondaActual.recepcionDeApuseta(apuesta);
                return;
            }
            if(apuesta==fichasInicioRonda){
                fichas=0;
                notificador.notificar(nombre+" Ya aposto todo: "+fichasInicioRonda);
                rondaActual.recepcionDeApuseta(fichasInicioRonda);

            }
    }

    public Notificador getNotificador() {
        return notificador;
    }

    public Boolean apuestaMinima(int apuesta){
        if (fichas>=apuesta){
            fichas-=apuesta;
            totalApostado=apuesta;
            return true;
        }
        else {
            System.out.println("No tenes fichas capo");
            return false;
        }

    }

    public int verFichas(){
        return fichas;
    }
    public void recibirFichas(int fichas){
        this.fichas+=fichas;
    }

    public int mejorQue(Jugador j2){
        if(jugada.compareTo(j2.jugada)==0){
            return Integer.compare(puntosJugada, j2.puntosJugada);
        }
         return jugada.compareTo(j2.jugada);

    }

    private void buscarJugada(){
        boolean color=color();
        int puntos=escalera();
        if (puntos!=0){
            puntosJugada=puntos;
            if(color){
                jugada=Juegos.ESCALERACOLOR;
            }
            else {
                jugada=Juegos.ESCALERA;
            }
        }
        else if (color){
            buscarIguales();
                if (jugada.compareTo(Juegos.COLOR)<0){
                    jugada=Juegos.COLOR;
                    puntosJugada=cartas.get(4).getValor();
                }

            }
        else buscarIguales();

        notificarJugada();
    }





    private void buscarIguales(){
        Carta carta= cartas.get(0);
        int ant;
        int actual;
        int valor1=-1;
        boolean recienCambiadov1=false;
        int valor2=-1;
        int contador1=0;
        int contador2=0;
        ArrayList<Integer> valores=new ArrayList<>();
        valores.add(carta.getValor());
        for(int i=1;i<cartas.size();i++){
            carta=cartas.get(i);
            valores.add(carta.getValor());
        }
        valores.sort(Integer::compareTo);
        ant=valores.get(0);
        for(int i=1;i<valores.size();i++){
            actual= valores.get(i);
            if (actual==valor1){
                contador1++;
            }
            if (actual==valor2){
                contador2++;
            }
            if(valor1==-1&&actual==ant){
                contador1=2;
                valor1=actual;
                recienCambiadov1=true;
            }
            if(valor2==-1&&actual==ant&& !recienCambiadov1&&actual!=valor1){
                contador2=2;
                valor2=actual;

            }
            recienCambiadov1=false;
            ant=actual;
        }

        if (contador1==4){
            jugada=Juegos.POKER;
            puntosJugada=valor1;
        }
        if ((contador1==2&&contador2==3)||(contador1==3&&contador2==2)){
            jugada=Juegos.FULLHOUSE;
            if (contador1==3){
                puntosJugada=valor1;
            }
            else {
                puntosJugada=valor2;
            }
        }

        if ((contador1==3&&contador2==0)||(contador1==0&&contador2==3)){
            jugada=Juegos.TRIO;
            if (contador1==3){
                puntosJugada=valor1;
            }
            else {
                puntosJugada=valor2;
            }
        }
        if (contador1==2&&contador2==2){
            jugada=Juegos.DOBLEPAREJA;
            if (valor1>=valor2){

                puntosJugada=valor1;
            }
            if (valor2>valor1){
                puntosJugada=valor2;
            }
        }
        if ((contador1==2&&contador2==0)||(contador1==0&&contador2==2)){
            jugada=Juegos.PAREJA;
            if (contador1==2){
                puntosJugada=valor1;
            }
            else {
                puntosJugada=valor2;
            }
        }

        if (contador1==0&&contador2==0){
            jugada=Juegos.CARTAMAYOR;
            puntosJugada=valores.get(valores.size()-1);
        }

    }

    private boolean color(){
        Carta cartaAnterior= cartas.get(0);


        for(int i=1;i<cartas.size();i++){
            if (!(cartaAnterior.igualTipo(cartas.get(i)))){
                return false;
            }
            cartaAnterior=cartas.get(i);
        }
    return true;
    }

    private Integer escalera(){
        Carta carta= cartas.get(0);

        Carta.Tipo tipo=carta.getTipo();
        ArrayList<Integer> valores=new ArrayList<>();
        valores.add(carta.getValor());
        for(int i=1;i<cartas.size();i++){
            carta=cartas.get(i);
            valores.add(carta.getValor());
        }
        valores.sort(Integer::compareTo);
        int comparar= valores.get(0);
        int total=comparar;
        boolean as = false;
        if(comparar==1&&valores.get(4)==13){
            as=true;
            total=14;
        }
        else {
            total=valores.get(4);
        }
        for(int i=1;i<valores.size();i++) {
            if (as &&valores.get(1)==10){
                comparar=10;
                as=false;
                continue;
            }
            if (!(comparar+1==valores.get(i))){
                return 0;
            }
            comparar=valores.get(i);

        }
        
        return total;
    }





    public void limpiar(){
        puntosJugada=0;
        jugada=null;
        cartas.clear();
        montoGanable=0;
        totalApostado=0;
        notificador=null;
    }
}
