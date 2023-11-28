package Modelo.PokerSinComodin;

import Vistas.Observer;

import java.util.ArrayList;

public class Notificador implements Observado{
    private ArrayList<Observer> mirones=new ArrayList<>();
    private StringBuilder mensaje=new StringBuilder();
    @Override
    public void notificar(String str) {
        mensaje.append("\n");
        mensaje.append(str);
        for (Observer miron:mirones){
            miron.update(str+"\n");
        }
    }

    @Override
    public void notificarApuestaMinimaActual(int apuestaMin) {
        for (Observer miron:mirones){
            miron.updateApuestaMin(apuestaMin);
        }
    }

    @Override
    public void notificarApuestaInicial(int apuestaInicial) {
        for (Observer miron:mirones){
            miron.updateApuestaInicial(apuestaInicial);
        }
    }

    @Override
    public void notificarTotalBote(int bote) {
        for (Observer miron:mirones){
            miron.updateMontoBote(bote);
        }
    }

    @Override
    public void notificarTurnoActual(String nombre) {
        for (Observer miron:mirones){
            miron.updateTurnoActual(nombre);
        }
    }

    @Override
    public void notificarEtapa(boolean descarte) {
        for (Observer miron:mirones){
            miron.updateEtapa(descarte);
        }
    }

    @Override
    public void notificarJugadores(ArrayList<String> nombres) {
        for (Observer miron:mirones){
            miron.updateJugadores(nombres);
        }
    }

    @Override
    public void agregarMiron(Observer o) {
        mirones.add(o);
    }

    @Override
    public void eliminarMiron(Observer o) {
        mirones.remove(o);
    }

    @Override
    public String getState() {
        return mensaje.toString();
    }
}
