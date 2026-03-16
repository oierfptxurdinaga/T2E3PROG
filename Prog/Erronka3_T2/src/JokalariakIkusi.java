import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import DAO.MenuAdmDAO;
import modelo.Jokalaria;
import DAO.ErabiltzaileaDAO;

public class JokalariakIkusi extends JFrame implements ActionListener, WindowListener{

	private static final long serialVersionUID = 202405164L;

	private JPanel container;
	private JButton btnItzuli;
	private JButton btnXmlsortu;
	

	private DefaultTableModel dtmTaula;
	private JTable taula;

	private JScrollPane scrollPane;
	//private JComboBox<Saila> cmbSaila;

	private Vector<String> zutabeak;
	private Vector<Vector<String>> taulaDatuak;
	
	
	private JComboBox<String> cmbtaldenIzena;
	
	MenuAdmDAO madao = new MenuAdmDAO();
	private JLabel lblLogo;

	
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
		
		btnItzuli = new JButton("Itzuli");
		btnItzuli.setBackground(new Color(255, 0, 0));
		btnItzuli.setForeground(new Color(255, 255, 255));
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBounds(484, 72, 140, 40);
		container.add(btnItzuli);
		
		cmbtaldenIzena = new JComboBox<>();
		cmbtaldenIzena.setForeground(new Color(0, 0, 0));
		cmbtaldenIzena.setFont(new Font("Arial", Font.BOLD, 20));
		cmbtaldenIzena.setBounds(10, 74, 180, 38);
		container.add(cmbtaldenIzena);
		
		String [] taldeak= {"▼ TALDEAK","LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(taldeak);
		cmbtaldenIzena.setModel(dcbm);
		
		zutabeak = new Vector<>(Arrays.asList(
				"ID Jokalaria", "Izena", "Dorsala", "Golak"
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
		btnXmlsortu.setBounds(282, 72, 140, 40);
		container.add(btnXmlsortu);
		
		JLabel lblNewLabel = new JLabel("JOKALARIAK IKUSI");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 13, 412, 38);
		container.add(lblNewLabel);
		
		lblLogo = new JLabel("LOGO");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblLogo.setBounds(696, 13, 100, 60);
		container.add(lblLogo);
		
		btnXmlsortu.addActionListener(this);
		btnItzuli.addActionListener(this);
		cmbtaldenIzena.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		String Tizena = (String) cmbtaldenIzena.getSelectedItem();
		 if(o == cmbtaldenIzena) {
			 Tizena = (String) cmbtaldenIzena.getSelectedItem();
			  // Vaciamos la tabla solo al cambiar el combo
		        dtmTaula.setRowCount(0); 
		
		        ArrayList<Jokalaria> Jokatera = madao.GuztiaAtera(Tizena);
				for(Jokalaria j : Jokatera) {
					dtmTaula.addRow(new Object [] {j.getJokalariId(),j.getIzena(),j.getAdina(),j.getZbkJo()});
				}
		 }
		        
		 if(o == btnItzuli) {
			if(ErabiltzaileaDAO.Erabiltzailemota.equals("admin")) {
				new MenuAdmin().setVisible(true);
				
			}else if(ErabiltzaileaDAO.Erabiltzailemota.equals("epaile")) {
				new MenuEpailea().setVisible(true);
				
			}else {
				new MenuErabiltzailea().setVisible(true);
				
			}
			dispose();
			 }
		 
		 if(o == btnXmlsortu) {
			 
		 }
			
}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}