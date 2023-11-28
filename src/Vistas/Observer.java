package Vistas;

import java.util.ArrayList;

public interface Observer {
    void update(String str);
    void updateApuestaMin(int i);
    void updateApuestaInicial(int i);
    void updateMontoBote(int i);
    void updateTurnoActual(String nombre);
    void updateJugadores(ArrayList<String> nombres);
    void updateEtapa(boolean etapaDescarte);

}
