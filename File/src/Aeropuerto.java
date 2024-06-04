import java.util.ArrayList;

public class Aeropuerto {
    private String nombre;
    private String ubicacion;
    private ArrayList<Vuelo> vuelosPartida;
    private ArrayList<Vuelo> vuelosLlegada;

    public Aeropuerto(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.vuelosPartida = new ArrayList<>();
        this.vuelosLlegada = new ArrayList<>();
    }

    public void registrarVueloPartida(Vuelo vuelo) {
        vuelosPartida.add(vuelo);
    }

    public void registrarVueloLlegada(Vuelo vuelo) {
        vuelosLlegada.add(vuelo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public ArrayList<Vuelo> getVuelosPartida() {
        return vuelosPartida;
    }

    public ArrayList<Vuelo> getVuelosLlegada() {
        return vuelosLlegada;
    }


    
}
