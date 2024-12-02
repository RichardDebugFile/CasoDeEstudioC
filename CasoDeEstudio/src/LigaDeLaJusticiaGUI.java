import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LigaDeLaJusticiaGUI {
    private JPanel pGeneral;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtSuperpoder;
    private JTextField txtMision;
    private JTextField txtPago;
    private JComboBox<Integer> cbNivelDeDificultad;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JTable table1;
    private JTextArea txtInforme;
    private JButton btnInforme;

    private GestionHeroes gestion;

    public LigaDeLaJusticiaGUI() {
        gestion = new GestionHeroes(); // Gestionar héroes con la logica que teniamos

        // Configurar JTable para la cabecera
        DefaultTableModel model = new DefaultTableModel(new String[]{
                "ID", "Nombre", "Superpoder", "Misión", "Nivel", "Pago Mensual"
        }, 0);
        table1.setModel(model);

        // Llenar el JComboBox con lo que teniamos antes
        for (int i = 1; i <= 5; i++) {
            cbNivelDeDificultad.addItem(i);
        }


        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarHeroe();
            }
        });


        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarHeroe();
            }
        });

        btnInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarInforme();
            }
        });
    }

    private void registrarHeroe() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String superpoder = txtSuperpoder.getText();
            String mision = txtMision.getText();
            int nivelDificultad = (int) cbNivelDeDificultad.getSelectedItem();
            double pagoMensual = Double.parseDouble(txtPago.getText());

            Heroe heroe = new Heroe(id, nombre, superpoder, mision, nivelDificultad, pagoMensual);
            if (gestion.registrarHeroe(heroe)) {
                actualizarTabla();
                JOptionPane.showMessageDialog(null, "Héroe registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: ID duplicado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Datos inválidos. Por favor revisa los campos.");
        }
    }

    private void modificarHeroe() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String superpoder = txtSuperpoder.getText();
            String mision = txtMision.getText();
            int nivelDificultad = (int) cbNivelDeDificultad.getSelectedItem();
            double pagoMensual = Double.parseDouble(txtPago.getText());

            Heroe nuevoHeroe = new Heroe(id, nombre, superpoder, mision, nivelDificultad, pagoMensual);
            if (gestion.modificarHeroe(id, nuevoHeroe)) {
                actualizarTabla();
                JOptionPane.showMessageDialog(null, "Héroe modificado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Héroe no encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Datos inválidos. Por favor revisa los campos.");
        }
    }

    private void generarInforme() {
        txtInforme.setText(gestion.generarInforme());
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0); // Limpia la tabla antes de llenarla
        for (Heroe h : gestion.listarHeroes()) {
            model.addRow(new Object[]{
                    h.getId(),
                    h.getNombre(),
                    h.getSuperpoder(),
                    h.getMision(),
                    h.getNivelDificultad(),
                    h.getPagoMensual()
            });
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Liga de la Justicia");
        frame.setContentPane(new LigaDeLaJusticiaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
