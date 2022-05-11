package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import DAO.PatrocinadorDAO;
import DAO.PruebaDAO;
import entidades.Atleta;
import entidades.DatosPersona;
import entidades.Equipo;
import entidades.Lugar;
import entidades.Patrocinador;
import entidades.Prueba;
import utils.ConexBD;
import validaciones.Validaciones;

import java.awt.Window.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldNIFNIE;
	private JTextField textFieldTelefono;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoAtleta frame = new NuevoAtleta();
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
	public NuevoAtleta() {
		setTitle("Nuevo Atleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelNombre = new JLabel("Nombre *:");
		lblNewLabelNombre.setBounds(44, 25, 63, 34);
		contentPane.add(lblNewLabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(100, 32, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JRadioButton rdbtnNewRadioButtonNIF = new JRadioButton("NIF");
		buttonGroup.add(rdbtnNewRadioButtonNIF);
		rdbtnNewRadioButtonNIF.setBounds(148, 62, 52, 23);
		contentPane.add(rdbtnNewRadioButtonNIF);
		
		JRadioButton rdbtnNewRadioButtonNIE = new JRadioButton("NIE");
		buttonGroup.add(rdbtnNewRadioButtonNIE);
		rdbtnNewRadioButtonNIE.setBounds(209, 62, 63, 23);
		contentPane.add(rdbtnNewRadioButtonNIE);
		
		JLabel lblNewLabelNIFNIE = new JLabel("Seleccione la opcion e introduzca el valor\r\n\r\n");
		lblNewLabelNIFNIE.setBounds(64, 92, 306, 34);
		lblNewLabelNIFNIE.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabelNIFNIE);
		
		textFieldNIFNIE = new JTextField();
		textFieldNIFNIE.setBounds(148, 124, 145, 20);
		contentPane.add(textFieldNIFNIE);
		textFieldNIFNIE.setColumns(10);
		
		JLabel lblNewLabelTelefono = new JLabel("Telefono:");
		lblNewLabelTelefono.setBounds(44, 171, 63, 14);
		contentPane.add(lblNewLabelTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(100, 168, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabelFechaNac = new JLabel("Fecha Nacimiento *:");
		lblNewLabelFechaNac.setBounds(196, 171, 104, 14);
		contentPane.add(lblNewLabelFechaNac);
		
		JSpinner spinnerFechaNac = new JSpinner();
		LocalDate fechaPorDefecto = LocalDate.parse("1/1/1960", DateTimeFormatter.ofPattern("dd/MM/yyyy") );;
		java.util.Date hoyMas1Mes = new Date(fechaPorDefecto.getYear(), fechaPorDefecto.getMonthValue(),
				fechaPorDefecto.getDayOfMonth());
		spinnerFechaNac.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));
		spinnerFechaNac.setBounds(296, 168, 114, 20);
		contentPane.add(spinnerFechaNac);
		
		JLabel lblNewLabel = new JLabel("Documentacion *:");
		lblNewLabel.setBounds(42, 66, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Personales");
		lblNewLabel_1.setBounds(10, 11, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Altura *:");
		lblNewLabel_2.setBounds(44, 267, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Datos Fisicos");
		lblNewLabel_3.setBounds(10, 242, 71, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Peso *:");
		lblNewLabel_4.setBounds(44, 292, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(117, 264, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 289, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("m. (en formato xx,xx)");
		lblNewLabel_5.setBounds(247, 267, 152, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Kg. (en formato xx,xx)");
		lblNewLabel_6.setBounds(247, 292, 116, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabelEquipo = new JLabel("Equipo:");
		lblNewLabelEquipo.setBounds(10, 353, 46, 14);
		contentPane.add(lblNewLabelEquipo);
		
		JComboBox comboBoxEquipo = new JComboBox();
		comboBoxEquipo.setBounds(117, 349, 253, 22);
		contentPane.add(comboBoxEquipo);
		
		JButton btnNewButtonAceptar = new JButton("Aceptar");
		btnNewButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosPersona persona = new DatosPersona();
				Atleta atleta = new Atleta();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";

				String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombrePrueba(nombre);
				if (!valido) {
					errores += "El nombre de la prueba no es válido (5-150 caracteres).\n";
					lblNewLabelNombre.setForeground(Color.RED);
				} else
					persona.setNombre(nombre);
				valido = false;

				java.util.Date fecha = (java.util.Date) spinnerFechaNac.getValue();
				valido = Validaciones.validarFechaNuevoAtleta(fecha);
				if (!valido) {
					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
					lblNewLabelFechaNac.setForeground(Color.RED);
				} else {
					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
					persona.setFechaNac(fechaLD);
				}
				
				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos de Nueva Prueba NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		btnNewButtonAceptar.setBounds(236, 410, 89, 23);
		contentPane.add(btnNewButtonAceptar);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(335, 410, 89, 23);
		contentPane.add(btnNewButtonCancelar);
		
	}
}
