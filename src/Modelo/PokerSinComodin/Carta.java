package Modelo.PokerSinComodin;

public class Carta implements Comparable<Carta> {


    @Override
    public int compareTo(Carta o) {
        return (valor.compareTo(o.valor));
    }

    enum Tipo{
        CORAZON,
        PICA,
        TREBOL,
        DIAMANTE
    };

    private Tipo tipo;
    private Integer valor;
    Carta(Tipo tipo , int valor){
        this.tipo=tipo;
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }
    public boolean igualTipo(Carta carta2){
        if (tipo==carta2.tipo){
            return true;
        }
        return false;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "tipo=" + tipo +
                ", valor=" + valor +
                '}';
    }
}

