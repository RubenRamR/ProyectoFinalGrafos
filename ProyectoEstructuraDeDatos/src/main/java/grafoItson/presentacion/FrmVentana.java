
package grafoItson.presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import negocios.dominioGrafo.Grafo;

/**
 *
 * @author Admin
 */
public class FrmVentana extends JFrame{
    
    private final CardLayout cardLayout;
    private final JPanel cardPanel;
    private final JPanel buttonPanel;
    private Grafo k = new Grafo();
    
    public FrmVentana() {
        setGrafoItson() ;
        setTitle("Grafo de Edificios ITSON");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1358, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setPreferredSize(new Dimension(1358, 672));
        
        // Se crean los paneles (ventanas) y se añaden los paneles al panel con CardLayout
        cardPanel.add(new PanelGrafoItson(k), "PanelGrafoITSON");

        // Añadir el panel con CardLayout
        getContentPane().add(cardPanel, BorderLayout.NORTH);
        
        
        // Panel para botones
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setPreferredSize(new Dimension(1358, 129));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        
        // Botones
        JButton btn_grafo = new JButton("Mostrar grafo");
        JButton btn_salir = new JButton("Salir");
        
        btn_grafo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentana("PanelGrafoOaxaca");
            }
        });
        
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVentana.this.dispose();
            }
        });
        
        // Añadir botones al panel con espacios en blanco entre ellos
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(btn_grafo);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(btn_salir);
        buttonPanel.add(Box.createHorizontalGlue());
        
        btn_grafo.setVisible(true);
        btn_salir.setVisible(true);
        
        // Añadir panel de botones a la ventana
        getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Se muestra en la parte inferior
        
    }
    
    /**
     * Método para mostrar un panel específico.
     * @param nombrePanel El nombre del panel que se mostrará.
     */
    public void mostrarVentana(String nombrePanel) {
        cardLayout.show(cardPanel, nombrePanel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrmVentana frmVentana = new FrmVentana();
                frmVentana.setVisible(true);
            }
        });
    }

    private void setGrafoItson() {
        k.agregarVertice("1");
        k.agregarVertice("2");
        k.agregarVertice("3");
        k.agregarVertice("4");
        k.agregarVertice("5");
        k.agregarVertice("6");
        k.agregarVertice("7");
        k.agregarVertice("8");
        k.agregarVertice("9");
        k.agregarVertice("10");
        k.agregarVertice("11");
        k.agregarVertice("12");
        k.agregarVertice("13");
        k.agregarVertice("14");
        k.agregarVertice("15");
        
        k.agregarArista("1", "5", 0.4);
        k.agregarArista("1", "3", 0.2);
        k.agregarArista("1", "4", 0.1);
        k.agregarArista("1", "15", 0.4);
        
        k.agregarArista("2", "3", 0.3);
        k.agregarArista("2", "6", 0.3);
        k.agregarArista("2", "7", 0.4);
        k.agregarArista("2", "8", 0.7);
        
        k.agregarArista("3", "6", 0.2);
        k.agregarArista("3", "4", 0.3);
        k.agregarArista("3", "11", 1.1);
        
        k.agregarArista("4", "6", 0.5);
        
        k.agregarArista("5", "15", 0.4);
        k.agregarArista("5", "9", 0.5);
        k.agregarArista("5", "10", 1);

        k.agregarArista("8", "11", 1.1);

        k.agregarArista("9", "10", 0.8);
        k.agregarArista("9", "13", 1);
        k.agregarArista("9", "14", 1.2);
        
        k.agregarArista("10", "13", 0.2);
        k.agregarArista("10", "11", 0.3);
        k.agregarArista("10", "14", 0.6);
        
        k.agregarArista("12", "4", 0.6);
        k.agregarArista("12", "15", 0.1);
        
        k.agregarArista("13", "14", 0.4);
    }
    
}
