
package steven_progra.proyectotowerdefense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame {
    
    private JLabel lblCastilloJugador;
    private JLabel lblCastilloCPU;
    private JTextArea txtCamino1;
    private JTextArea txtCamino2;
    private JComboBox<String> seleccionTropa;
    private JButton btnEnviarTropa;
    private JTextArea txtResultados;
    private Juego juego;

    public InterfazGrafica() {
        juego = new Juego();
        setTitle("Juego de Invasión - Tower Defense");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        // Panel superior para mostrar el estado de los castillos
        JPanel panelEstado = new JPanel(new GridLayout(1, 2));
        lblCastilloJugador = new JLabel("Castillo Jugador: 10 PV");
        lblCastilloCPU = new JLabel("Castillo CPU: 10 PV");
        panelEstado.add(lblCastilloJugador);
        panelEstado.add(lblCastilloCPU);
        add(panelEstado, BorderLayout.NORTH);

        // Panel central para mostrar los caminos de tropas
        JPanel panelCaminos = new JPanel(new GridLayout(2, 1));
        txtCamino1 = new JTextArea("Camino 1");
        txtCamino2 = new JTextArea("Camino 2");
        txtCamino1.setEditable(false);
        txtCamino2.setEditable(false);
        panelCaminos.add(new JScrollPane(txtCamino1));
        panelCaminos.add(new JScrollPane(txtCamino2));
        add(panelCaminos, BorderLayout.CENTER);

        // Panel inferior para acciones del jugador
        JPanel panelAcciones = new JPanel(new GridLayout(2, 1));
        
        // Selección de tropas
        JPanel panelSeleccionTropas = new JPanel(new FlowLayout());
        seleccionTropa = new JComboBox<>(new String[]{"Arquero", "Mago", "Caballero"});
        btnEnviarTropa = new JButton("Enviar Tropa");
        panelSeleccionTropas.add(new JLabel("Selecciona Tropa:"));
        panelSeleccionTropas.add(seleccionTropa);
        panelSeleccionTropas.add(btnEnviarTropa);
        panelAcciones.add(panelSeleccionTropas);

        // Resultado de la batalla
        txtResultados = new JTextArea(5, 20);
        txtResultados.setEditable(false);
        panelAcciones.add(new JScrollPane(txtResultados));
        add(panelAcciones, BorderLayout.SOUTH);

        // Acción de enviar tropa
        btnEnviarTropa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarTropa();
            }
        });
    }

    private void enviarTropa() {
        String tipoTropa = (String) seleccionTropa.getSelectedItem();
        Tropa tropa = crearTropa(tipoTropa);

        // Lógica para agregar la tropa al camino (simplificada)
        txtResultados.append("Has enviado un " + tipoTropa + "\n");
        actualizarCaminos(tipoTropa, tropa);
        iniciarRonda();
    }

    private Tropa crearTropa(String tipoTropa) {
        switch (tipoTropa) {
            case "Arquero":
                return new Arquero();
            case "Mago":
                return new Mago();
            case "Caballero":
                return new Caballero();
            default:
                return null;
        }
    }

    private void actualizarCaminos(String tipoTropa, Tropa tropa) {
        // Agrega visualmente la tropa al camino seleccionado
        if (Math.random() < 0.5) {
            txtCamino1.append("\n" + tipoTropa);
        } else {
            txtCamino2.append("\n" + tipoTropa);
        }
    }

    private void iniciarRonda() {
        // Realiza una ronda de la batalla
        juego.iniciarJuego();

        // Actualiza el estado de los castillos
        lblCastilloJugador.setText("Castillo Jugador: " + juego.getCastilloJugador().getPuntosDeVida() + " PV");
        lblCastilloCPU.setText("Castillo CPU: " + juego.getCastilloCPU().getPuntosDeVida() + " PV");

        // Verifica el estado del juego
        if (juego.getCastilloCPU().estaDestruido()) {
            txtResultados.append("¡Has ganado la batalla!\n");
        } else if (juego.getCastilloJugador().estaDestruido()) {
            txtResultados.append("Has sido derrotado. Fin del juego.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazGrafica());
    }
}
