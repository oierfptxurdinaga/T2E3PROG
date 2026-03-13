import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import DAO.MenuAdmDAO;
import DAO.ErabiltzaileaDAO;

public class JokalariakIkusi extends JFrame implements ActionListener{

	private static final long serialVersionUID = 202405164L;

	private JPanel container;
	private JButton btnItzuli;
	private JButton btnXmlsortu;
	private JLabel lblInfo;

	private DefaultTableModel dtmTaula;
	private JTable taula;

	private JScrollPane scrollPane;
	//private JComboBox<Saila> cmbSaila;

	private Vector<String> zutabeak;
	private Vector<Vector<String>> taulaDatuak;
	
	
	private JComboBox<String> cmbtaldenIzena;

	private JLabel lblSoldataBatura;
	private JLabel lblSoldataBatazBesteBalioa;

	private JLabel lblSoldataBatazBeste;
	private JLabel lblZbtLangile;
	private JLabel lblZbtLangileBalioa;
	private JLabel lblSoldataBaturaBalioa;
	
	MenuAdmDAO madao = new MenuAdmDAO();
	ErabiltzaileaDAO eradao = new ErabiltzaileaDAO();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JokalariakIkusi frame = new JokalariakIkusi();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JokalariakIkusi() {

		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Jokalariak-Ikusi");
		
		setBounds(100, 100, 820, 520);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		
		btnItzuli = new JButton("Irten");
		btnItzuli.setBackground(new Color(255, 0, 0));
		btnItzuli.setForeground(new Color(255, 255, 255));
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBounds(547, 11, 140, 40);
		container.add(btnItzuli);
		
		cmbtaldenIzena = new JComboBox<>();
		cmbtaldenIzena.setForeground(new Color(0, 0, 0));
		cmbtaldenIzena.setFont(new Font("Arial", Font.BOLD, 20));
		cmbtaldenIzena.setBounds(10, 74, 299, 38);
		container.add(cmbtaldenIzena);
		
		String [] taldeak= {"▼ TALDEAK","LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(taldeak);
		cmbtaldenIzena.setModel(dcbm);
		
		zutabeak = new Vector<>(Arrays.asList(
				"ID Langilea", "Izena", "Abizenak", "Soldata"
		));

		taulaDatuak = new Vector<>();
		dtmTaula = new DefaultTableModel(taulaDatuak, zutabeak);

		taula = new JTable(dtmTaula);
		taula.setFont(new Font("Arial", Font.BOLD, 20));
		taula.setForeground(new Color(0, 0, 128));
		taula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taula.setRowHeight(30);

		scrollPane = new JScrollPane(taula);
		scrollPane.setBounds(168, 141, 628, 261);
		container.add(scrollPane);
		
		btnXmlsortu = new JButton("XML");
		btnXmlsortu.setForeground(Color.WHITE);
		btnXmlsortu.setFont(new Font("Arial", Font.BOLD, 24));
		btnXmlsortu.setBackground(Color.RED);
		btnXmlsortu.setBounds(365, 11, 140, 40);
		container.add(btnXmlsortu);
		
		JLabel lblNewLabel = new JLabel("JOKALARIAK IKUSI");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 12, 317, 38);
		container.add(lblNewLabel);
		
		btnXmlsortu.addActionListener(this);
		btnItzuli.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		 if(o == btnItzuli) {
			
			 }
		
		
	}
}