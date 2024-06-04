import java.util.ArrayList;
import java.util.Scanner;

public class Vuelo implements IReservable {
    private int numeroVuelo;
    private String aerolinea;
    private String horaSalida;
    private String destino;
    private int capacidadMaxima;
    private Aeropuerto aeropuertoPartida;
    private Aeropuerto aeropuertoLlegada;
    private ArrayList<Pasajero> pasajeros;

    public Vuelo(int numeroVuelo, String aerolinea, String horaSalida, String destino, int capacidadMaxima, Aeropuerto aeropuertoPartida, Aeropuerto aeropuertoLlegada) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.horaSalida = horaSalida;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        this.aeropuertoPartida = aeropuertoPartida;
        this.aeropuertoLlegada = aeropuertoLlegada;
        this.pasajeros = new ArrayList<>();
    }

    public boolean reservarAsiento(int numeroAsiento) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ingrese su nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.equalsIgnoreCase("x")) {
            return false;
        }
        System.out.print("ingrese su numero de pasaporte: ");
        String numeroPasaporte = scanner.nextLine();
        if (numeroPasaporte.equalsIgnoreCase("x")) {
            return false;
        }
        System.out.print("ingrese la cantidad de equipaje: ");
        String cantidadEquipaje = scanner.nextLine();
        if (cantidadEquipaje.equalsIgnoreCase("x")) {
            return false;
        }
        if (numeroAsiento <= (capacidadMaxima - pasajeros.size())) {
            double precio = 0;
            for (int i = 1; i <= numeroAsiento; i++) {
                if (i == 1) {
                    Pasajero pasajero = new Pasajero(nombre, numeroPasaporte, Integer.parseInt(cantidadEquipaje));
                    precio = (100 * (numeroAsiento-1)) + pasajero.calcularPrecioReserva();
                    System.out.println("Precio de la reserva: " + precio);
                    System.out.print("confirme la reserva . Ingrese (si) para confirmar: ");
                    String confirmar = scanner.nextLine();
                    if (!confirmar.equalsIgnoreCase("si")) {
                        System.out.println("Reserva Cancelada");
                        break;
                    }
                    agregarPasajero(pasajero);
                } else {
                    Pasajero pasajero = new Pasajero(nombre, numeroPasaporte, 0);
                    agregarPasajero(pasajero);
                }
                
            }
            
            return true;
        }

        return false;
    }

    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Aeropuerto getAeropuertoPartida() {
        return aeropuertoPartida;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    
}

