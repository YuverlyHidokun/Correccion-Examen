import java.util.ArrayList;
import java.util.List;

class Videojuego {
    private String nombre;
    private int añoLanzamiento;

    public Videojuego(String nombre, int añoLanzamiento) {
        this.nombre = nombre;
        try {
            setAñoLanzamiento(añoLanzamiento);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public void jugar() {
        System.out.println("Jugando al videojuego: " + nombre);
    }
}

class RPG extends Videojuego {
    private String tipoRol;

    public RPG(String nombre, int añoLanzamiento, String tipoRol) {
        super(nombre, añoLanzamiento);
        this.tipoRol = tipoRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public void jugar() {
        System.out.println("Jugando al RPG: " + getNombre() + " - Tipo de Rol: " + tipoRol);
    }
}

class FPS extends Videojuego {
    private String modoMultijugador;

    public FPS(String nombre, int añoLanzamiento, String modoMultijugador) {
        super(nombre, añoLanzamiento);
        this.modoMultijugador = modoMultijugador;
    }

    public String getModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(String modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }

    @Override
    public void jugar() {
        System.out.println("Jugando al FPS: " + getNombre() + " - Modo Multijugador: " + modoMultijugador);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Videojuego> videojuegos = new ArrayList<>();

        try {
            RPG rpg1 = new RPG("Final Fantasy", 1990, "Fantasía");
            videojuegos.add(rpg1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear RPG: " + e.getMessage());
        }

        try {
            FPS fps1 = new FPS("Call of Duty", 2003, "Multijugador en línea");
            videojuegos.add(fps1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear FPS: " + e.getMessage());
        }

        for (Videojuego juego : videojuegos) {
            System.out.println("Nombre: " + juego.getNombre());
            System.out.println("Año de Lanzamiento: " + juego.getAñoLanzamiento());
            juego.jugar();
            System.out.println();
        }
    }
}
