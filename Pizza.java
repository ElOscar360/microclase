public class Pizza {
    private final String masa, tamano, salsa;
    private final boolean queso, pepperoni, champinones, pina;

    private Pizza(Builder b) {
        this.masa = b.masa; this.tamano = b.tamano; this.salsa = b.salsa;
        this.queso = b.queso; this.pepperoni = b.pepperoni;
        this.champinones = b.champinones; this.pina = b.pina;
    }

    public static class Builder {
        private String masa, tamano, salsa;
        private boolean queso, pepperoni, champinones, pina;

        public Builder masa(String m) { this.masa = m; return this; }
        public Builder tamano(String t) { this.tamano = t; return this; }
        public Builder salsa(String s) { this.salsa = s; return this; }
        public Builder queso(boolean q) { this.queso = q; return this; }
        public Builder pepperoni(boolean p) { this.pepperoni = p; return this; }
        public Builder champinones(boolean c) { this.champinones = c; return this; }
        public Builder pina(boolean p) { this.pina = p; return this; }

        public Pizza build() { return new Pizza(this); }
    }
}
