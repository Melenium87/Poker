package Modelo.PokerSinComodin;

import Vistas.Observer;
import Vistas.VerCartas;

import java.util.ArrayList;

public interface DejarVerCartas {

    void agregarMiron(VerCartas o);
    void notificarCartas(ArrayList<String> mensaje);
    void notificarJugada();
    String getState();
}
