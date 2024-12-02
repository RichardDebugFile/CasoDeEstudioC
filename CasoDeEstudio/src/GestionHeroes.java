import java.util.LinkedList;

public class GestionHeroes {
    private LinkedList<Heroe> listaHeroes;

    public GestionHeroes() {
        listaHeroes = new LinkedList<>();
    }

    public boolean registrarHeroe(Heroe heroe) {
        for (Heroe h : listaHeroes) {
            if (h.getId() == heroe.getId()) {
                return false;
            }
        }
        listaHeroes.add(heroe);
        return true;
    }

    public boolean modificarHeroe(int id, Heroe nuevoHeroe) {
        for (Heroe h : listaHeroes) {
            if (h.getId() == id) {
                h.setNombre(nuevoHeroe.getNombre());
                h.setSuperpoder(nuevoHeroe.getSuperpoder());
                h.setMision(nuevoHeroe.getMision());
                h.setNivelDificultad(nuevoHeroe.getNivelDificultad());
                h.setPagoMensual(nuevoHeroe.getPagoMensual());
                return true;
            }
        }
        return false;
    }

    public LinkedList<Heroe> listarHeroes() {
        return listaHeroes;
    }

    public String generarInforme() {
        StringBuilder informe = new StringBuilder();
        for (Heroe h : listaHeroes) {
            informe.append("Nombre: ").append(h.getNombre()).append("\n")
                    .append("Superpoder: ").append(h.getSuperpoder()).append("\n")
                    .append("Pago Mensual: $").append(h.getPagoMensual()).append("\n")
                    .append("Aporte Fondo: $").append(h.calcularAporteFondo()).append("\n")
                    .append("Impuesto: $").append(h.calcularImpuestoGobierno()).append("\n")
                    .append("Pago Neto: $").append(h.calcularPagoNeto()).append("\n\n");
        }
        return informe.toString();
    } //Hola
}
