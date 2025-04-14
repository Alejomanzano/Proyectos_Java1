import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JButton btnInsertar;
    private JButton btnExtraer;
    private JTextArea txtListado;
    private JLabel lblEtiqueta;
    private JTextField txtDato;
    private Pila coleccion = new Pila();

    public Ventana(){

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coleccion.insertar(txtDato.getText());
                txtListado.setText(coleccion.toString());
            }
        });
        btnExtraer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eliminado = coleccion.extraer();
                JOptionPane.showMessageDialog(null,"Se elimino:  " +eliminado);
                txtListado.setText(coleccion.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
