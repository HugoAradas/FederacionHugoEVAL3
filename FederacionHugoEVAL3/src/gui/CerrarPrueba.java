package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import DAO.AtletaDAO;
import DAO.MetalDAO;
import DAO.PatrocinadorDAO;
import DAO.PruebaDAO;
import comparadores.ComparadorAlfabetico;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entidades.Atleta;
import entidades.DatosPersona;
import entidades.Lugar;
import entidades.Metal;
import entidades.Oro;
import entidades.Patrocinador;
import entidades.Prueba;
import entidades.Tiempo;
import utils.ConexBD;
import utils.Datos;
import validaciones.Validaciones;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class CerrarPrueba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba frame = new CerrarPrueba(idprueba);
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
	public CerrarPrueba(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if(prueba!=null) {
			setTitle("Cerrar Prueba" + idprueba);
		}
		else
		setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		textField = new JTextField(""+prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");
	
		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if(prueba.isIndividual()) 
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(27, 251, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(27, 353, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(27, 463, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		String[] atletasStr = new String[81];
		for (int i = 0; i < 81; i++) {
			System.out.println(atletassList.get(i).getPersona().data());
			atletasStr[i] = atletassList.get(i).getPersona().data();
		}


		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));		
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(140, 247, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(140, 349, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(140, 459, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				/// Tomar cada campo y validarlo. Si alguno no es correcto, avisar al usuario
//				String nombre = textFieldNombre.getText();
//				valido = Validaciones.validarNombrePrueba(nombre);
//				if (!valido) {
//					errores += "El nombre de la prueba no es válido (5-150 caracteres).\n";
//					lblNombre.setForeground(Color.RED);
//				} else
//					nueva.setNombre(nombre);
//				valido = false;
//
//				java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
//				valido = Validaciones.validarFechaNuevaPrueba(fecha);
//				if (!valido) {
//					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
//					lblFecha.setForeground(Color.RED);
//				} else {
//					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
//					nueva.setFecha(fechaLD);
//				}
//				valido = false;
//				valido = (comboBoxLugar.getSelectedIndex() != -1);
//				if (!valido) {
//					errores += "Debe seleccionar el lugar de celebración de la nueva prueba.\n";
//					lblLugar.setForeground(Color.RED);
//				} else {
//					Lugar lugar = (Lugar) comboBoxLugar.getSelectedItem();
//					nueva.setLugar(lugar);
//				}
//				valido = false;
//				valido = !(!rbIndividual.isSelected() && !rbEquipos.isSelected())
//						|| (rbIndividual.isSelected() && rbEquipos.isSelected());
//				if (!valido) {
//					errores += "Debe seleccionar si la nueva prueba es individual O por equipos.\n";
//					rbIndividual.setForeground(Color.RED);
//					rbEquipos.setForeground(Color.RED);
//				} else {
//					nueva.setIndividual(rbIndividual.isSelected() ? true : false);
//				}
//				valido = false;
//				valido = (comboBoxPatrocinador.getSelectedIndex() != -1);
//				if (!valido) {
//					errores += "Debe seleccionar el Patrocinador de la nueva prueba.\n";
//					lblPatrocinador.setForeground(Color.RED);
//				} else {
//					PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
//					String seleccionado = (String) comboBoxPatrocinador.getSelectedItem();
//					String[] aux = seleccionado.split("\\.");
//					long idPat = Long.valueOf(aux[0]);
//					Patrocinador patrocinador = patDAO.buscarPorID(idPat);
//					ConexBD.cerrarConexion();
//					if (patrocinador == null)
//						valido = false;
//					else
//						nueva.setPatrocinador(patrocinador);
//				}
				
				
				
				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (!correcto) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba "+prueba.getId()+" cerrada en la BD";
					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					/// Aqui se redirigiría al usuario hacia la pantalla principal
					/// TODO
				}
			}
		});
		buttonAceptar.setBounds(239, 595, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		buttonCancelar.setBounds(338, 595, 89, 23);
		contentPane.add(buttonCancelar);
		
		JSpinner spinnerHHOro = new JSpinner();
		spinnerHHOro.setBounds(73, 276, 30, 20);
		contentPane.add(spinnerHHOro);
		
		JSpinner spinnermmOro = new JSpinner();
		spinnermmOro.setBounds(176, 276, 30, 20);
		contentPane.add(spinnermmOro);
		
		JSpinner spinnerssOro = new JSpinner();
		spinnerssOro.setBounds(289, 276, 30, 20);
		contentPane.add(spinnerssOro);
		
		JSpinner spinnerccOro = new JSpinner();
		spinnerccOro.setBounds(397, 276, 30, 20);
		contentPane.add(spinnerccOro);
		
		JLabel lblNewLabel = new JLabel("HH");
		lblNewLabel.setBounds(49, 279, 14, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("mm");
		lblNewLabel_1.setBounds(140, 279, 24, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ss");
		lblNewLabel_2.setBounds(265, 279, 14, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("cc");
		lblNewLabel_3.setBounds(373, 279, 14, 14);
		contentPane.add(lblNewLabel_3);
		
		JSpinner spinnerHHPlata = new JSpinner();
		spinnerHHPlata.setBounds(73, 378, 30, 20);
		contentPane.add(spinnerHHPlata);
		
		JSpinner spinnermmPlata = new JSpinner();
		spinnermmPlata.setBounds(176, 378, 30, 20);
		contentPane.add(spinnermmPlata);
		
		JSpinner spinnerssPlata = new JSpinner();
		spinnerssPlata.setBounds(289, 378, 30, 20);
		contentPane.add(spinnerssPlata);
		
		JSpinner spinnerccPlata = new JSpinner();
		spinnerccPlata.setBounds(397, 378, 30, 20);
		contentPane.add(spinnerccPlata);
		
		JLabel lblNewLabel_4 = new JLabel("HH");
		lblNewLabel_4.setBounds(49, 381, 14, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("mm");
		lblNewLabel_1_1.setBounds(140, 381, 24, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("ss");
		lblNewLabel_2_1.setBounds(265, 381, 14, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("cc");
		lblNewLabel_3_1.setBounds(373, 381, 14, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JSpinner spinnerHHBronce = new JSpinner();
		spinnerHHBronce.setBounds(73, 488, 30, 20);
		contentPane.add(spinnerHHBronce);
		
		JSpinner spinnermmBronce = new JSpinner();
		spinnermmBronce.setBounds(176, 488, 30, 20);
		contentPane.add(spinnermmBronce);
		
		JSpinner spinnerssBronce = new JSpinner();
		spinnerssBronce.setBounds(289, 488, 30, 20);
		contentPane.add(spinnerssBronce);
		
		JSpinner spinnerccBronce = new JSpinner();
		spinnerccBronce.setBounds(397, 488, 30, 20);
		contentPane.add(spinnerccBronce);
		
		JLabel lblNewLabel_5 = new JLabel("HH");
		lblNewLabel_5.setBounds(49, 491, 14, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("mm");
		lblNewLabel_1_2.setBounds(140, 491, 24, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("ss");
		lblNewLabel_2_2.setBounds(265, 491, 14, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("cc");
		lblNewLabel_3_2.setBounds(373, 491, 14, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_6 = new JLabel("Id Oro *:");
		lblNewLabel_6.setBounds(49, 311, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBoxOro = new JComboBox();
		comboBoxOro.setBounds(117, 307, 59, 22);
		contentPane.add(comboBoxOro);
		
		JLabel lblNewLabel_6_1 = new JLabel("Id Plata *:");
		lblNewLabel_6_1.setBounds(49, 413, 54, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JComboBox comboBoxPlata = new JComboBox();
		comboBoxPlata.setBounds(117, 409, 59, 22);
		contentPane.add(comboBoxPlata);
		
		JLabel lblNewLabel_6_2 = new JLabel("Id Bronce *:");
		lblNewLabel_6_2.setBounds(49, 523, 59, 14);
		contentPane.add(lblNewLabel_6_2);
		
		JComboBox comboBoxBronce = new JComboBox();
		comboBoxBronce.setBounds(117, 519, 59, 22);
		contentPane.add(comboBoxBronce);
		
		JLabel lblNewLabel_7 = new JLabel("Establecer como DEFINITIVO:");
		lblNewLabel_7.setBounds(28, 562, 148, 14);
		contentPane.add(lblNewLabel_7);
		
		JCheckBox CheckBoxDEF = new JCheckBox("");
		CheckBoxDEF.setBounds(182, 562, 24, 23);
		contentPane.add(CheckBoxDEF);
		String cad="";
        if (CheckBoxDEF.isSelected()==true) {
            cad = "Es definitivo";
        }
		
//        Tiempo HHOro = (Tiempo) spinnerHHOro.getValue();
//        Tiempo mmOro = (Tiempo) spinnermmOro.getValue();
//        Tiempo ssOro = (Tiempo) spinnerssOro.getValue();
//        Tiempo ccOro = (Tiempo) spinnerccOro.getValue();
//        
//        Tiempo HHPlata = (Tiempo) spinnerHHPlata.getValue();
//        Tiempo mmPlata = (Tiempo) spinnermmPlata.getValue();
//        Tiempo ssPlata = (Tiempo) spinnerssPlata.getValue();
//        Tiempo ccPlata = (Tiempo) spinnerccPlata.getValue();
//        
//        Tiempo HHBronce = (Tiempo) spinnerHHBronce.getValue();
//        Tiempo mmBronce = (Tiempo) spinnermmBronce.getValue();
//        Tiempo ssBronce = (Tiempo) spinnerssBronce.getValue();
//        Tiempo ccBronce = (Tiempo) spinnerccBronce.getValue();
        
        
	}
	
//	public static void exportarResultadoPrueba() {
//		File f = new File("resultado_prueba" +  + ".txt");
//		FileWriter fo = null;
//		/// Utilizamos una lista para tomar primeramente los datos desde la clase
//		/// Datos.java
//		List<DatosPersona> personas = new LinkedList<DatosPersona>();
//		for (DatosPersona dp : Datos.PERSONAS) {
//			personas.add(dp);
//		}
//		/// Se ordena la lista según el ComparadorAlfabetico
//		Collections.sort(personas, new ComparadorAlfabetico());
//		try {
//			fo = new FileWriter(f);
//			/// Se recorre cada elemento de la lista ya ordenada y se exporta hacia el
//			/// fichero de caracteres, una persona en cada línea y a través del método
//			/// DatosPersona.data
//			for (DatosPersona dp : personas) {
//				fo.write(dp.data() + "\n");
//				fo.flush();
//			}
//			fo.close();
//			System.out.println("Se han exportado correctamente los datos de las personas.");
//		} catch (FileNotFoundException e) {
//			System.out.println("Se ha producido una FileNotFoundException:" + e.getMessage());
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("Se ha producido una Exception:" + e.getMessage());
//			e.printStackTrace();
//		}
//	}
}
