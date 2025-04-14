import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblCodigo;
    private JTextArea txtArea;

    public Ventana() {
        txtCodigo.setLineWrap(true);
        txtCodigo.setWrapStyleWord(true);
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pila pilas = new Pila();
                    String codigo = txtCodigo.getText();
                    txtArea.setText(""); 

                    for (int i = 0; i <= codigo.length() - 1; i++) {
                        char c = codigo.charAt(i);
                        if (c == '(' || c == '{' || c == '[') {
                            pilas.insertar(String.valueOf(c));
                            JOptionPane.showMessageDialog(null, "Insertado: " + c);
                            txtArea.setText(pilas.toString());
                        } else if (c == ')' || c == ']' || c == '}') {
                            String extraido = pilas.extraer();
                            JOptionPane.showMessageDialog(null, "Extraído: " + extraido);
                            txtArea.setText(pilas.toString());

                            char salida = extraido.charAt(0);
                            if ((c == ')' && salida != '(') ||
                                    (c == ']' && salida != '[') ||
                                    (c == '}' && salida != '{')) {
                                JOptionPane.showMessageDialog(null, "Código no balanceado");
                                return;
                            }
                        }
                    }

                    if (pilas.esVacia())
                        JOptionPane.showMessageDialog(null, "Código balanceado");
                    else
                        JOptionPane.showMessageDialog(null, "Código no balanceado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }


}
