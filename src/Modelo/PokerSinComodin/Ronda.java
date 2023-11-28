package Modelo.PokerSinComodin;

import Vistas.Observer;

import java.util.ArrayList;


public class Ronda {

    private Integer apuestas=0;
    private Integer apuestaMin;
    private Integer apuestaActual;

    private int contador=0;
    private Integer inicio;

    private boolean terminado=false;
    private boolean etapaDeDescarte=false;
    private  boolean etapaDeApuestas=true;
    private  boolean hayApuesta=false;
    private boolean segundasApuestas=false;
    private int contadorDescartes=0;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Jugador> jugando;
    private Jugador jugadorAEliminar=null;
    private Jugador jugadorActual;
    private Baraja baraja=new Baraja();
    Notificador notificador=new Notificador();

    public boolean getHayApuestas() {
        return hayApuesta;
    }


    public Integer getApuestas() {
        return apuestas;
    }


    public boolean termino(){
        return terminado;
    }
    public Ronda(ArrayList<Jugador> jugadores, Integer inicio, Integer apuestaMin){
        this.jugadores=jugadores;
        this.inicio=inicio;
        this.apuestaMin=apuestaMin;
        apuestaActual=apuestaMin;
        for (Jugador j:jugadores){
            j.setRondaActual(this);
        }

        jugadorActual=jugadores.get(inicio);

    }

    public void agregarAlNotificador(Observer o){
        notificador.agregarMiron(o);
    }

    public Integer getApuestaMin() {
        return apuestaMin;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    public boolean getEtapaDeApuestas(){
        return etapaDeApuestas;
    }
    public boolean getEtapaDeDescartes(){
        return etapaDeDescarte;
    }

    public void iniciar(){
        jugando = new ArrayList<>(jugadores);
        ArrayList<Jugador> jugadoresDescartados=new ArrayList<>();
        ArrayList<String>nombres=new ArrayList<>();
        for (Jugador j:jugando){
            j.setNotificador(notificador);
            if (j.apuestaMinima(apuestaMin)){
                apuestas+=apuestaMin;
                j.recibirCartas(baraja.repartir());
                nombres.add(j.getNombre());
            }
            else{
                jugadoresDescartados.add(j);
            }
        }
        jugando.removeAll(jugadoresDescartados);
        notificador.notificarTotalBote(apuestas);
        notificador.notificarApuestaMinimaActual(apuestaActual);
        notificador.notificarApuestaInicial(apuestaMin);
        notificador.notificarTurnoActual(jugadorActual.getNombre());
        notificador.notificarJugadores(nombres);
        notificador.notificarEtapa(etapaDeDescarte);
    }


    public void recepcionDeApuseta(int apuestaJugador ) {

        if (!(contador>= jugando.size())&& !etapaDeDescarte){

            if (apuestaJugador == -1) {
                jugadorAEliminar = jugadorActual;
                jugadorAEliminar.recibirFichas(-jugadorAEliminar.getTotalApostado());
                notificador.notificarApuestaMinimaActual(apuestaActual);
                if (contador+1>jugando.size()-1){
                    siguienteTurno();

                    if (jugando.size()==1){
                        ganador();
                        return;
                    }
                    if(segundasApuestas){
                        buscarGanador();
                        notificador.notificarApuestaMinimaActual(apuestaActual);
                        return;
                    }
                    contador=1;
                    etapaDeDescarte=true;
                    etapaDeApuestas=false;
                    notificador.notificarEtapa(etapaDeDescarte);
                    notificador.notificarApuestaMinimaActual(apuestaActual);
                    notificador.notificar("---------------------------\nComienza la etapa de descartes\n---------------------------\n\n");
                    notificador.notificar("Turno de: "+jugadorActual.getNombre()+"\n");
                    return;
                }
            }
            else {
                contador++;
               int  contadorDeApuestas=0;
                for (Jugador j:jugadores){
                    contadorDeApuestas+=j.getTotalApostado();
                }
                apuestas=contadorDeApuestas;
                notificador.notificarTotalBote(apuestas);
                if (apuestaJugador > apuestaActual) {
                    apuestaActual = apuestaJugador;
                    hayApuesta = true;
                    contador = 1;
                }

            }
            notificador.notificarApuestaMinimaActual(apuestaActual);
            if (contador+1>jugando.size()){
                if(segundasApuestas){
                    buscarGanador();
                    notificador.notificarApuestaMinimaActual(apuestaActual);
                    return;
                }
                siguienteTurno();
                contador=1;
                etapaDeDescarte=true;
                etapaDeApuestas=false;
                hayApuesta=false;
                notificador.notificarEtapa(etapaDeDescarte);
                notificador.notificarApuestaMinimaActual(apuestaActual);
                notificador.notificar("------------------------------------------------------\nComienza la etapa de descartes\n------------------------------------------------------\n\n");
                notificador.notificar("Turno de: "+jugadorActual.getNombre()+"\n");
                return;
            }

            siguienteTurno();
            if (jugando.size()==1){
                ganador();
            }
        }


    }


    public void recepcionDescarte(int caratasDescartadas){
        if (contadorDescartes<jugando.size()){
            jugadorActual.recibirCartas(baraja.darCartas(caratasDescartadas) );
            siguienteTurno();
            if (contadorDescartes+1==jugando.size()){
                segundasApuestas=true;
                etapaDeApuestas=true;
                etapaDeDescarte=false;
                notificador.notificarEtapa(etapaDeDescarte);
                notificador.notificar("-------------------------------------\nSegunda etapa de apuestas\n-------------------------------------\n");
                notificador.notificarApuestaMinimaActual(apuestaActual);
                contador=0;
                return;
            }
            contadorDescartes++;

        }

    }


    private void ganador(){
        Jugador ganador=jugando.get(0);
        if (ganador.getTotalApostado()==apuestaActual){
            ganador.recibirFichas(apuestas);
            ganador.mostrarGanador(ganador);
            terminado=true;
        }
        else{
            Jugador jugandorMasAposto=null;
            for(Jugador j:jugadores){
                if (jugandorMasAposto==null){
                    jugandorMasAposto=j;
                }
                if (jugandorMasAposto.getTotalApostado()<j.getTotalApostado()){
                    jugandorMasAposto=j;
                }

            }
            ganador.mostrarGanador(ganador);
            ganador.recibirFichas(ganador.getMontoGanable());
            jugandorMasAposto.recibirFichas(apuestas-ganador.getMontoGanable());
            terminado=true;
        }
        for(Jugador j:jugadores){
            j.limpiar();
        }
    }
    private void empate(ArrayList<Jugador> jugas) {
        jugadorActual.mostrarGanador(jugas);
        for (Jugador j:jugando){

            j.recibirFichas(apuestas/ jugando.size());
        }
        terminado=true;
        for(Jugador j:jugadores){
            j.limpiar();
        }
    }

    private void buscarGanador(){
        Jugador actual;
        for (int i=0; i<jugando.size();i++){
            actual=jugando.get(i);
            if(i+1!=jugando.size()){
                int mejor=actual.mejorQue(jugando.get(i+1));
                if (mejor==0){
                    continue;
                }
                if (mejor>=1){
                    jugando.remove(i+1);
                    i--;
                    continue;
                }
                if (mejor<=-1){
                    jugando.remove(i);
                    i--;

                }
            }
        }
        if(jugando.size()==1){
            ganador();
        }
        else {
            empate(jugando);
        }
    }



    private void siguienteTurno(){
        int posicionActual=jugando.indexOf(jugadorActual);
        if(posicionActual==jugando.size()-1){
            jugadorActual=jugando.get(0);
        }
        else{
            jugadorActual= jugando.get(posicionActual+1);
        }
        if (jugadorAEliminar!=null){
            jugando.remove(jugadorAEliminar);
            jugadorAEliminar=null;
        }
        notificador.notificarTurnoActual(jugadorActual.getNombre());
        ArrayList<String> nombres=new ArrayList<>();
        for (Jugador j:jugando){
            nombres.add(j.getNombre());
        }
        notificador.notificarJugadores(nombres);
    }
    public Jugador turno(){

        return jugadorActual;
    }






}


