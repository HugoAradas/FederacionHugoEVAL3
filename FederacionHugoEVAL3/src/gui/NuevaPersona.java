package gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JRadioButton;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;

public class NuevaPersona extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldNIFNIE;
	private JTextField textFieldTelefono;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaPersona frame = new NuevaPersona();
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
	public NuevaPersona() {
		setTitle("Datos Personales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelNombre = new JLabel("Nombre *:");
		lblNewLabelNombre.setBounds(21, 11, 63, 34);
		contentPane.add(lblNewLabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(83, 18, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JRadioButton rdbtnNewRadioButtonNIF = new JRadioButton("NIF");
		buttonGroup.add(rdbtnNewRadioButtonNIF);
		rdbtnNewRadioButtonNIF.setBounds(134, 62, 52, 23);
		contentPane.add(rdbtnNewRadioButtonNIF);
		
		JRadioButton rdbtnNewRadioButtonNIE = new JRadioButton("NIE");
		buttonGroup.add(rdbtnNewRadioButtonNIE);
		rdbtnNewRadioButtonNIE.setBounds(188, 62, 63, 23);
		contentPane.add(rdbtnNewRadioButtonNIE);
		
		JLabel lblNewLabelNIFNIE = new JLabel("Seleccione la opcion e introduzca el valor\r\n\r\n");
		lblNewLabelNIFNIE.setBounds(38, 104, 306, 34);
		lblNewLabelNIFNIE.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabelNIFNIE);
		
		textFieldNIFNIE = new JTextField();
		textFieldNIFNIE.setBounds(114, 133, 145, 20);
		contentPane.add(textFieldNIFNIE);
		textFieldNIFNIE.setColumns(10);
		
		JLabel lblNewLabelTelefono = new JLabel("Telefono:");
		lblNewLabelTelefono.setBounds(21, 210, 63, 14);
		contentPane.add(lblNewLabelTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(83, 207, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabelFechaNac = new JLabel("Fecha Nacimiento *:");
		lblNewLabelFechaNac.setBounds(196, 210, 104, 14);
		contentPane.add(lblNewLabelFechaNac);
		
		JSpinner spinnerFechaNac = new JSpinner();
		LocalDate fechaPorDefecto = LocalDate.parse("1/1/1960", DateTimeFormatter.ofPattern("dd/MM/yyyy") );;
		java.util.Date fecha = new Date(fechaPorDefecto.getYear(), fechaPorDefecto.getMonthValue(),
				fechaPorDefecto.getDayOfMonth());
		spinnerFechaNac.setModel(new SpinnerDateModel(fecha, fecha, null, Calendar.DAY_OF_YEAR));
		spinnerFechaNac.setBounds(310, 207, 114, 20);
		contentPane.add(spinnerFechaNac);
		
		JLabel lblNewLabel = new JLabel("Documentacion *:");
		lblNewLabel.setBounds(21, 56, 86, 14);
		contentPane.add(lblNewLabel);
	}
}
