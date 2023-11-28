package Controlador;

import Modelo.PokerSinComodin.Jugador;
import Modelo.PokerSinComodin.Ronda;
import Vistas.Observer;
import Vistas.VerCartas;
import Vistas.VistaApuesta;

import java.util.ArrayList;

public class ControladorApuesta {
    private VistaApuesta vista=new VistaApuesta();

    private Jugador jugador;
    private Ronda modelo;
    private int apuesta=-1000;
    public ControladorApuesta(Jugador jugador){

        this.jugador=jugador;
        vista.setControlador(this);

        vista.setApuestas(jugador.getTotalApostado());
        vista.setCantidadeFichas(jugador.verFichas());
        vista.setNombre(jugador.getNombre());
        jugador.agregarMiron((VerCartas) vista);
        vista.setVisible(true);
    }

    public void setModelo(Ronda modelo) {
        this.modelo = modelo;
        vista.setApuestaMin(modelo.getApuestaMin());

    }
    public void agregarVerCartas(VerCartas miron){
        jugador.agregarMiron(miron);
    }
    public void agregarMironEventos(Observer miron){
        modelo.agregarAlNotificador(miron);
    }



    public void recibirApuesta(int apuesta){
        if (modelo.getJugadorActual()==jugador&&modelo.getEtapaDeApuestas()) {
            jugador.apostar(apuesta);
        }
    }

    public String nombreJugador() {
        return jugador.getNombre();
    }
}

