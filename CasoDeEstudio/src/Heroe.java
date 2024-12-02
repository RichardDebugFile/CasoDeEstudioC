public class Heroe {
    private int id;
    private String nombre;
    private String superpoder;
    private String mision;
    private int nivelDificultad; // Valor entre 1 y 5
    private double pagoMensual;

    public Heroe(int id, String nombre, String superpoder, String mision, int nivelDificultad, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.superpoder = superpoder;
        this.mision = mision;
        this.nivelDificultad = nivelDificultad;
        this.pagoMensual = pagoMensual;
    }

    // Getters y Setters obligatorios
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    // Métodos de cálculo para lo que nos pidieron
    public double calcularAporteFondo() {
        return pagoMensual * 0.1; // Esto es el 10% del pago mensual
    }

    public double calcularImpuestoGobierno() {
        double pagoAnual = pagoMensual * 12;
        if (pagoAnual <= 60000) {
            return 0;
        } else if (pagoAnual <= 120000) {
            return (pagoAnual - 60000) * 0.12;
        } else if (pagoAnual <= 240000) {
            return (60000 * 0.12) + (pagoAnual - 120000) * 0.25;
        } else {
            return (60000 * 0.12) + (120000 * 0.25) + (pagoAnual - 240000) * 0.35;
        }
    }

    public double calcularPagoNeto() {
        double pagoAnual = pagoMensual * 12;
        double impuesto = calcularImpuestoGobierno();
        return pagoAnual - impuesto - calcularAporteFondo();
    }
}
