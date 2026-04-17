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

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;

import modelo.JokalariLista;
import modelo.Jokalaria;

import DAO.MenuAdmDAO;
import DAO.ErabiltzaileaDAO;
import DAO.LogDAO;

import java.io.File;

/**
 * Jokalariak taldearen arabera bistaratzeko eta informazio hori XML fitxategi 
 * batean esportatzeko interfaze grafikoa.
 * @author [HIIM/T2]
 * @version 1.0
 */
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
	 * Aplikazioa abiarazteko metodo nagusia (main).
	 * Log-a hasieratu eta JokalariakIkusi leihoa ikusgarri egiten du.
	 * @param args komando-lerroko argumentuak
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				LogDAO.inicializarLogger();
				JokalariakIkusi frame = new JokalariakIkusi();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * JokalariakIkusi klasearen eraikitzailea.
	 * Leihoaren elementu grafikoak (zerrenda, taula, botoiak...) sortu 
	 * eta hasieratzen ditu, dagozkien entzuleak (listeners) esleituz.
	 */
	public JokalariakIkusi() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Jokalariak-Ikusi");
		
		
		setBounds(100, 100, 808, 660);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		setLocationRelativeTo(null);
		
		btnItzuli = new JButton("Itzuli");
		btnItzuli.setBackground(new Color(0, 0, 255));
		btnItzuli.setForeground(new Color(255, 255, 255));
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBounds(512, 8, 140, 40);
		container.add(btnItzuli);
		
		cmbtaldenIzena = new JComboBox<>();
		cmbtaldenIzena.setForeground(new Color(0, 0, 0));
		cmbtaldenIzena.setFont(new Font("Arial", Font.BOLD, 20));
		cmbtaldenIzena.setBounds(10, 74, 195, 38);
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
		scrollPane.setBounds(54, 160, 700, 388);
		container.add(scrollPane);
		
		btnXmlsortu = new JButton("XML");
		btnXmlsortu.setForeground(Color.WHITE);
		btnXmlsortu.setFont(new Font("Arial", Font.BOLD, 24));
		btnXmlsortu.setBackground(new Color(0, 0, 255));
		btnXmlsortu.setBounds(318, 555, 140, 40);
		container.add(btnXmlsortu);
		
		JLabel lblNewLabel = new JLabel("JOKALARIAK IKUSI");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 8, 412, 38);
		container.add(lblNewLabel);
		
		lblLogo = new JLabel("LOGO");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblLogo.setBounds(688, 8, 100, 60);
		container.add(lblLogo);
		
		btnXmlsortu.addActionListener(this);
		btnItzuli.addActionListener(this);
		cmbtaldenIzena.addActionListener(this);
	}
	
	/**
	 * Interfazearen ekintzak kudeatzen ditu. Taldea aukeratzean jokalariak taulan
	 * kargatzen ditu. "XML" botoia sakatzean JAXB erabiliz XML fitxategia sortzen du,
	 * eta "Itzuli" botoiarekin aurreko menura bueltatzen da erabiltzaile motaren arabera.
	 * @param e Gertaeraren informazioa biltzen duen ActionEvent objektua.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		String Tizena = (String) cmbtaldenIzena.getSelectedItem();
		 if(o == cmbtaldenIzena) {
			 Tizena = (String) cmbtaldenIzena.getSelectedItem();
			  // Taula ezabatzen dugu
		        dtmTaula.setRowCount(0); 
		
		        ArrayList<Jokalaria> Jokatera = madao.GuztiaAtera(Tizena);
				for(Jokalaria j : Jokatera) {
					dtmTaula.addRow(new Object [] {j.getJokalariId(),j.getIzena(),j.getZbkJo(),j.getGolak()});
					}
				if(ErabiltzaileaDAO.Erabiltzailemota.equals("admin")) {
						LogDAO.getLogger().info("Administratzailea "+Tizena+" taldea ikusi du.");
					}else if(ErabiltzaileaDAO.Erabiltzailemota.equals("epaile")) {
						LogDAO.getLogger().info("Epailea "+Tizena+" taldea ikusi du.");
					}else {
						LogDAO.getLogger().info("Erabiltzaile arrunta "+Tizena+" taldea ikusi du.");
					}
		 }
		        
		 if(o == btnItzuli) {
			if(ErabiltzaileaDAO.Erabiltzailemota.equals("admin")) {
				LogDAO.getLogger().info("Administratzaria bere menura bueltatu da.");
				new MenuAdmin().setVisible(true);
				
			}else if(ErabiltzaileaDAO.Erabiltzailemota.equals("epaile")) {
				LogDAO.getLogger().info("Epailea bere menura bueltatu da.");
				new MenuEpailea().setVisible(true);
				
			}else {
				new MenuErabiltzailea().setVisible(true);
				LogDAO.getLogger().info("Erabiltzaile arrunta bere menura bueltatu da.");
			}
			dispose();
			 }
		 
		 if(o == btnXmlsortu) {
			 ArrayList<Jokalaria> lista = new ArrayList<Jokalaria>();
			 lista = madao.JokalariakAtera(Tizena);
			 
			 //Klase agrupatzaileari deitzen diogu:
			 JokalariLista taldea = new JokalariLista(lista);

			 try {
				 JAXBContext context = JAXBContext.newInstance(JokalariLista.class);
				 Marshaller marshaller = context.createMarshaller();
				 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				 marshaller.marshal(taldea, new File("Xml/"+Tizena+"_Jokalariak.xml"));
				 JOptionPane.showMessageDialog(this, "XML fitxategia sortua");
				 if(ErabiltzaileaDAO.Erabiltzailemota.equals("admin")) {
					 LogDAO.getLogger().info("Administratzaria "+Tizena+"_Jokalaria.xml sortu du.");
				 }else if(ErabiltzaileaDAO.Erabiltzailemota.equals("epaile")) {
					 LogDAO.getLogger().info("Epailea "+Tizena+"_Jokalaria.xml sortu du.");
				 }else {
					 LogDAO.getLogger().info("Erabiltzaile arrunta "+Tizena+"_Jokalaria.xml sortu du.");
				 }
						
			 }catch(PropertyException e1) {
				 e1.printStackTrace();
			 }catch(JAXBException e1) {
					e1.printStackTrace();
				}
		 }
			
}

	/**
	 * Leihoa irekitzean exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	/**
	 * Leihoa ixtear dagoenean exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Leihoa itxi ondoren exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Leihoa minimizatzean exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Leihoa bere jatorrizko tamainara itzultzean exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Leihoa aktibatzean exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Leihoa desaktibatzean exekutatzen da (ez da erabiltzen).
	 * @param e WindowEvent objektua
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}