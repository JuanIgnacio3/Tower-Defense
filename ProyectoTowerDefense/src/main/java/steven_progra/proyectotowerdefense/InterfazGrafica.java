
package steven_progra.proyectotowerdefense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame {
    private Batalla batalla; // Controla la lógica del juego
    private JLabel puntosJugador;
    private JLabel puntosCPU;
    private JTextArea camino1Info;
    private JTextArea camino2Info;
    private JComboBox<String> tipoTropaSelector;
    private JComboBox<String> caminoSelector;
    private JButton enviarTropaBtn;
    private JButton avanzarTurnoBtn;
    private JTextArea logArea;

    public InterfazGrafica() {
        // Inicializar lógica del juego
        batalla = new Batalla();

        // Configuración básica de la ventana
        setTitle("Tower Defense - Invasión");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: Información de puntos de vida
        JPanel puntosPanel = new JPanel();
        puntosPanel.setLayout(new GridLayout(1, 2));
        puntosJugador = new JLabel("Castillo Jugador: 10 puntos");
        puntosCPU = new JLabel("Castillo CPU: 10 puntos");
        puntosPanel.add(puntosJugador);
        puntosPanel.add(puntosCPU);
        add(puntosPanel, BorderLayout.NORTH);

        // Panel central: Información de caminos
        JPanel caminosPanel = new JPanel();
        caminosPanel.setLayout(new GridLayout(1, 2));
        camino1Info = new JTextArea("Camino 1:\n");
        camino2Info = new JTextArea("Camino 2:\n");
        camino1Info.setEditable(false);
        camino2Info.setEditable(false);
        caminosPanel.add(new JScrollPane(camino1Info));
        caminosPanel.add(new JScrollPane(camino2Info));
        add(caminosPanel, BorderLayout.CENTER);

        // Panel inferior: Controles del jugador
        JPanel controlesPanel = new JPanel();
        controlesPanel.setLayout(new GridLayout(3, 2));
        tipoTropaSelector = new JComboBox<>(new String[]{"Arquero", "Mago", "Caballero"});
        caminoSelector = new JComboBox<>(new String[]{"1", "2"});
        enviarTropaBtn = new JButton("Enviar Tropa");
        avanzarTurnoBtn = new JButton("Avanzar Turno");
        logArea = new JTextArea("Log de la partida:\n");
        logArea.setEditable(false);

        controlesPanel.add(new JLabel("Selecciona tipo de tropa:"));
        controlesPanel.add(tipoTropaSelector);
        controlesPanel.add(new JLabel("Selecciona camino:"));
        controlesPanel.add(caminoSelector);
        controlesPanel.add(enviarTropaBtn);
        controlesPanel.add(avanzarTurnoBtn);
        add(controlesPanel, BorderLayout.SOUTH);

        add(new JScrollPane(logArea), BorderLayout.EAST);

        // Configuración de botones
        configurarBotones();

        // Mostrar ventana
        setVisible(true);
    }

    private void configurarBotones() {
        // Enviar tropa
        enviarTropaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoTropa = (String) tipoTropaSelector.getSelectedItem();
                int caminoElegido = Integer.parseInt((String) caminoSelector.getSelectedItem());
                Tropa tropa;

                // Crear la tropa seleccionada
                switch (tipoTropa) {
                    case "Arquero":
                        tropa = new Arquero();
                        break;
                    case "Mago":
                        tropa = new Mago();
                        break;
                    case "Caballero":
                        tropa = new Caballero();
                        break;
                    default:
                        return;
                }

                // Enviar la tropa al camino seleccionado
                batalla.enviarTropaJugador(tropa, caminoElegido);
                logArea.append("Tropa enviada: " + tipoTropa + " al camino " + caminoElegido + "\n");
                actualizarInformacionCaminos();
            }
        });

        // Avanzar turno
        avanzarTurnoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                batalla.ejecutarTurno();
                logArea.append("Turno ejecutado\n");

                if (batalla.verificarDerrotaJugador()) {
                    JOptionPane.showMessageDialog(null, "¡Perdiste! Tu castillo fue destruido.");
                    System.exit(0);
                }

                if (batalla.verificarVictoriaJugador()) {
                    JOptionPane.showMessageDialog(null, "¡Ganaste la batalla!");
                    batalla.siguienteRonda();
                    actualizarInformacionCaminos();
                }

                actualizarPuntosDeVida();
            }
        });
    }

    private void actualizarPuntosDeVida() {
        puntosJugador.setText("Castillo Jugador: " + batalla.getJuego().getCastilloJugador().getPuntosVida() + " puntos");
        puntosCPU.setText("Castillo CPU: " + batalla.getJuego().getCastilloCPU().getPuntosVida() + " puntos");
    }

    private void actualizarInformacionCaminos() {
        // Actualizar información de los caminos (esto requeriría mostrar las tropas de ambos caminos)
        camino1Info.setText("Camino 1:\n" + obtenerEstadoCamino(batalla.getJuego().getCamino1()));
        camino2Info.setText("Camino 2:\n" + obtenerEstadoCamino(batalla.getJuego().getCamino2()));
    }

    private String obtenerEstadoCamino(Camino camino) {
        // Mostrar la información de las tropas en el camino
        StringBuilder estado = new StringBuilder();
        NodoTropa actualJugador = camino.getCabezaJugador(); // Se debe crear un método `getCabezaJugador`
        NodoTropa actualCPU = camino.getCabezaCPU(); // Se debe crear un método `getCabezaCPU`

        estado.append("Jugador:\n");
        while (actualJugador != null) {
            estado.append(actualJugador.getTropa().getClass().getSimpleName()).append("\n");
            actualJugador = actualJugador.getSiguiente();
        }

        estado.append("CPU:\n");
        while (actualCPU != null) {
            estado.append(actualCPU.getTropa().getClass().getSimpleName()).append("\n");
            actualCPU = actualCPU.getSiguiente();
        }

        return estado.toString();
    }

    public static void main(String[] args) {
        new InterfazGrafica();
    }
}

