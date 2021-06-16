package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dominio.Combustible;
import dominio.EstacionDeServicio;

public class CargaDeVentas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLitros;
	private EstacionDeServicio estacionDeServicio;

	public CargaDeVentas(EstacionDeServicio estacionDeServicio) {
		this.estacionDeServicio = estacionDeServicio;
		setTitle("Carga de venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setVisible(true);

		textFieldLitros = new JTextField();
		textFieldLitros.setBounds(213, 26, 86, 20);
		contentPane.add(textFieldLitros);
		textFieldLitros.setColumns(10);

		JLabel lblLitros = new JLabel("Litros");
		lblLitros.setBounds(34, 29, 87, 14);
		contentPane.add(lblLitros);

		JButton btnCargar = new JButton("Cargar venta");
		btnCargar.setBounds(86, 191, 143, 23);
		contentPane.add(btnCargar);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(213, 70, 86, 22);
		contentPane.add(comboBox);

		Iterator<Combustible> iterador = estacionDeServicio.tiposDeCombustibles().iterator();
		comboBox.addItem(null);

		JButton btnConsultarMonto = new JButton("Monto total");
		btnConsultarMonto.setBounds(86, 139, 143, 23);
		contentPane.add(btnConsultarMonto);

		btnConsultarMonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == null)
					JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de combustible");
				if (textFieldLitros.getText() == null)
					JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad de litros");
				else {
					float montoTotalventa = estacionDeServicio.montoTotalVenta(LocalDateTime.now(),
							Integer.parseInt(textFieldLitros.getText()), (Combustible) comboBox.getSelectedItem());
					JOptionPane.showMessageDialog(null, "El monto total de la venta es: " + montoTotalventa);
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Tipo de combustible");
		lblNewLabel.setBounds(31, 74, 172, 14);
		contentPane.add(lblNewLabel);
		while (iterador.hasNext()) {
			Combustible c = iterador.next();
			comboBox.addItem(c);
		}

		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == null)
					JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de combustible");
				else {
					estacionDeServicio.generarVenta(LocalDateTime.now(), Integer.parseInt(textFieldLitros.getText()),
							(Combustible) comboBox.getSelectedItem());
					JOptionPane.showMessageDialog(null, "La venta se ha registrado exitosamente");
				}
			}
		});

	}
}
