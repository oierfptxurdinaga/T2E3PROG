import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class EmaitzakSartu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmaitzakSartu frame = new EmaitzakSartu();
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
	public EmaitzakSartu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emaitzak-Sartu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 23, 304, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnItzuli = new JButton("Irten");
		btnItzuli.setForeground(Color.WHITE);
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBackground(Color.RED);
		btnItzuli.setBounds(334, 23, 140, 40);
		contentPane.add(btnItzuli);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"▼ TALDEAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		comboBox.setBounds(27, 110, 140, 32);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"▼ TALDEAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		comboBox_1.setBounds(556, 110, 140, 32);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(208, 111, 120, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(401, 111, 120, 32);
		contentPane.add(textField_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"▼ DENBORALDIAK", "2024-2025", "2025-2026", "2026-2027"}));
		comboBox_2.setBounds(265, 201, 161, 32);
		contentPane.add(comboBox_2);
		
		JButton btnItzuli_1 = new JButton("Irten");
		btnItzuli_1.setForeground(Color.WHITE);
		btnItzuli_1.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli_1.setBackground(Color.RED);
		btnItzuli_1.setBounds(265, 282, 161, 40);
		contentPane.add(btnItzuli_1);

	}
}
