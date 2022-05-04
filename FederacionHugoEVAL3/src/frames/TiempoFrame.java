package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class TiempoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiempoFrame frame = new TiempoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TiempoFrame() {
		setTitle("Introduzca el Tiempo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 109, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 23, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 152, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea txtrHora = new JTextArea();
		txtrHora.setText("Horas");
		txtrHora.setBounds(148, 21, 58, 22);
		contentPane.add(txtrHora);
		
		JTextArea txtrMinutos = new JTextArea();
		txtrMinutos.setText("Minutos");
		txtrMinutos.setBounds(148, 64, 86, 22);
		contentPane.add(txtrMinutos);
		
		JTextArea txtrSegundos = new JTextArea();
		txtrSegundos.setText("Segundos");
		txtrSegundos.setBounds(148, 107, 86, 22);
		contentPane.add(txtrSegundos);
		
		JTextArea txtrCentesimas = new JTextArea();
		txtrCentesimas.setText("Centesimas");
		txtrCentesimas.setBounds(148, 150, 86, 22);
		contentPane.add(txtrCentesimas);
	}
}
