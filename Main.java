import java.util.*;

// Product
class Personaje {
    private final String nombre, raza, clase, arma, armadura, mascota;
    private final int nivel;
    private final List<String> habilidades;

    private Personaje(Builder b) {
        this.nombre = b.nombre; this.raza = b.raza; this.clase = b.clase;
        this.arma = b.arma; this.armadura = b.armadura; this.mascota = b.mascota;
        this.nivel = b.nivel; this.habilidades = List.copyOf(b.habilidades);
    }

    public void ficha() {
        System.out.println("=== FICHA DE PERSONAJE ===");
        System.out.println("Nombre: " + nombre + " | Raza: " + raza + " | Clase: " + clase + " | Nivel: " + nivel);
        if (arma != null) System.out.println("Arma: " + arma);
        if (armadura != null) System.out.println("Armadura: " + armadura);
        if (mascota != null) System.out.println("Mascota: " + mascota);
        if (!habilidades.isEmpty()) System.out.println("Habilidades: " + habilidades);
        System.out.println();
    }

    public static class Builder {
        private final String nombre, raza, clase;
        private String arma, armadura, mascota;
        private int nivel = 1;
        private List<String> habilidades = new ArrayList<>();

        public Builder(String nombre, String raza, String clase) {
            this.nombre = nombre; this.raza = raza; this.clase = clase;
        }

        public Builder arma(String a) { this.arma = a; return this; }
        public Builder armadura(String a) { this.armadura = a; return this; }
        public Builder mascota(String m) { this.mascota = m; return this; }
        public Builder nivel(int n) { this.nivel = n; return this; }
        public Builder agregarHabilidad(String h) { this.habilidades.add(h); return this; }

        public Personaje build() { return new Personaje(this); }
    }
}

// Director (Plantillas prediseñadas)
class PersonajeDirector {
    public Personaje guerreroPorDefecto(String nombre) {
        return new Personaje.Builder(nombre, "Humano", "Guerrero")
                .arma("Espada Larga").armadura("Placas").nivel(5)
                .agregarHabilidad("Ataque Giratorio").build();
    }

    public Personaje magoPorDefecto(String nombre) {
        return new Personaje.Builder(nombre, "Elfo", "Mago")
                .arma("Báculo").agregarHabilidad("Bola de Fuego").build();
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        // 1. Personaje bien equipado
        Personaje p1 = new Personaje.Builder("Aragorn", "Humano", "Guerrero")
                .arma("Andúril").armadura("Cota de Malla").mascota("Caballo")
                .nivel(10).agregarHabilidad("Liderazgo").agregarHabilidad("Espadachín")
                .build();

        // 2. Personaje con atributos mínimos
        Personaje p2 = new Personaje.Builder("Gimli", "Enano", "Guerrero").build();

        // 3. Usando plantilla prediseñada
        PersonajeDirector director = new PersonajeDirector();
        Personaje p3 = director.magoPorDefecto("Gandalf");

        p1.ficha();
        p2.ficha();
        p3.ficha();
    }
}