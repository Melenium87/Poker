package Controlador;


import Modelo.PokerSinComodin.Jugador;


import Modelo.PokerSinComodin.Ronda;
import Vistas.Observer;
import Vistas.VerCartas;
import Vistas.VistaDescarte;

import java.util.ArrayList;

public class ControladorDescarte {
    private VistaDescarte vista=new VistaDescarte();
    private Ronda modelo;
    private Jugador jugador;

    public ControladorDescarte(Jugador jugador){
        this.jugador=jugador;

        vista.setControlador(this);
        vista.setVisible(true);


    }

    public void setModelo(Ronda modelo) {
        this.modelo = modelo;
        vista.agregarseAMironesEventos();
    }

    public void agregarVerCartas(VerCartas miron){
        jugador.agregarMiron(miron);
    }

    public void recibirDescartes(ArrayList<Integer> i){
        if (modelo.getEtapaDeDescartes()&&modelo.getJugadorActual()==jugador){
            jugador.descartar(i);
        }

    }
    public void agregarMironEventos(Observer miron){
        modelo.agregarAlNotificador(miron);
    }
    public String nombreJugador() {
        return jugador.getNombre();
    }



}
