package Modelo.PokerSinComodin;

import Vistas.Observer;

import java.util.ArrayList;

public interface Observado {

    void notificar(String mensaje);
    void notificarApuestaMinimaActual(int apuesta);
    void notificarApuestaInicial(int apuesta);
    void notificarTotalBote(int apuesta);
    void notificarTurnoActual(String nombre);
    void notificarEtapa(boolean descarte);
    void notificarJugadores(ArrayList<String> nombres);
    void agregarMiron(Observer o);
    void eliminarMiron(Observer o);
    String getState();

}
