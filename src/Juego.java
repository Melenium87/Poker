import Controlador.ControladorApuesta;
import Controlador.ControladorDescarte;
import Modelo.PokerSinComodin.Jugador;
import Modelo.PokerSinComodin.Ronda;

import java.util.ArrayList;

public class Juego {



    public static void main(String[] args) {
         int nroRonda=0;
         int apuestaMin=200;
         Ronda rondaActual;
         ArrayList<Ronda>rondas=new ArrayList<>();
         ArrayList<Jugador> jugadores=new ArrayList<>();

        Jugador jugador1=new Jugador("Bartolito el gallo",2000);
        Jugador jugador2=new Jugador("spider-man",2000);
        Jugador jugador3=new Jugador("messi",2000);
        Jugador jugador4=new Jugador("chayanne",2000);
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        ControladorApuesta controladorApuestaJugador1=new ControladorApuesta(jugador1);
        ControladorApuesta controladorApuestaJugador2=new ControladorApuesta(jugador2);
        ControladorApuesta controladorApuestaJugador3=new ControladorApuesta(jugador3);
        ControladorApuesta controladorApuestaJugador4=new ControladorApuesta(jugador4);

        ControladorDescarte controladorDescarteJugador1=new ControladorDescarte(jugador1);
        ControladorDescarte controladorDescarteJugador2=new ControladorDescarte(jugador2);
        ControladorDescarte controladorDescarteJugador3=new ControladorDescarte(jugador3);
        ControladorDescarte controladorDescarteJugador4=new ControladorDescarte(jugador4);



            nroRonda++;
            rondaActual=new Ronda(jugadores,(nroRonda-1 % jugadores.size()),apuestaMin);
            controladorApuestaJugador1.setModelo(rondaActual);
            controladorApuestaJugador2.setModelo(rondaActual);
            controladorApuestaJugador3.setModelo(rondaActual);
            controladorApuestaJugador4.setModelo(rondaActual);

            controladorDescarteJugador1.setModelo(rondaActual);
            controladorDescarteJugador2.setModelo(rondaActual);
            controladorDescarteJugador3.setModelo(rondaActual);
            controladorDescarteJugador4.setModelo(rondaActual);
            rondaActual.iniciar();
            }




    }



