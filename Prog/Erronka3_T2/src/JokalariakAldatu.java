import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ErabiltzaileaDAO;
import DAO.LogDAO;
import DAO.MenuAdmDAO;
import modelo.Jokalaria;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;

/**
 * Jokalariak talde batetik bestera aldatzeko (fitxaketak) interfaze grafikoa.
 * Erabiltzaileari jatorrizko taldea eta helburuko taldea aukeratzeko aukera ematen dio,
 * eta hautatutako jokalaria taldez aldatzen du datu-basean.
 * * @author [HIIM/T2]
 * @version 1.0
 */
public class JokalariakAldatu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnItzuli;
	private JButton btnAldatu;
	
	private DefaultTableModel dtmTaula;
	
	private JTable taulaEtxe_T;
	private JComboBox comboBox_Etxeko_T;
	private JComboBox comboBox_Kanpoko_T;
	
	private Vector<String> zutabeak;
	private Vector<Vector<String>> taulaDatuak;
	
	private JScrollPane scrollPane;
	
	MenuAdmDAO madao = new MenuAdmDAO();
	/**
	 * Aplikazioa abiarazteko metodo nagusia (main).
	 * Log-a hasieratu eta JokalariakAldatu leihoa ikusgarri egiten du.
	 * * @param args komando-lerroko argumentuak
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogDAO.inicializarLogger();
					JokalariakAldatu frame = new JokalariakAldatu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * JokalariakAldatu klasearen eraikitzailea.
	 * Leihoaren elementu grafikoak (zerrendak, taulak, botoiak...) sortu 
	 * eta hasieratzen ditu, dagozkien entzuleak (listeners) esleituz.
	 */
	public JokalariakAldatu() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 808, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Jokalariak-Aldatu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 8, 492, 40);
		contentPane.add(lblNewLabel);
		
		btnItzuli = new JButton("Itzuli");
		btnItzuli.setForeground(Color.WHITE);
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBackground(new Color(0, 0, 255));
		btnItzuli.setBounds(512, 8, 140, 40);
		contentPane.add(btnItzuli);
		
		comboBox_Etxeko_T = new JComboBox();
		comboBox_Etxeko_T.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox_Etxeko_T.setModel(new DefaultComboBoxModel(new String[] {"▼ ETXEKOAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		comboBox_Etxeko_T.setBounds(57, 95, 180, 49);
		contentPane.add(comboBox_Etxeko_T);
		
		comboBox_Kanpoko_T = new JComboBox();
		comboBox_Kanpoko_T.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox_Kanpoko_T.setModel(new DefaultComboBoxModel(new String[] {"▼ KANPOKOAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		comboBox_Kanpoko_T.setBounds(492, 95, 180, 49);
		contentPane.add(comboBox_Kanpoko_T);
		
		zutabeak = new Vector<>(Arrays.asList(
				"Izena"
		));

		taulaDatuak = new Vector<>();
		dtmTaula = new DefaultTableModel(taulaDatuak, zutabeak);
		

		taulaEtxe_T = new JTable(dtmTaula);
		taulaEtxe_T.setFont(new Font("Arial", Font.BOLD, 20));
		taulaEtxe_T.setForeground(new Color(0, 0, 128));
		taulaEtxe_T.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taulaEtxe_T.setRowHeight(30);

		scrollPane = new JScrollPane(taulaEtxe_T);
		scrollPane.setBounds(140, 182, 467, 361);
		contentPane.add(scrollPane);
		
		btnAldatu = new JButton("Aldatu");
		btnAldatu.setForeground(Color.WHITE);
		btnAldatu.setFont(new Font("Arial", Font.BOLD, 24));
		btnAldatu.setBackground(new Color(0, 0, 255));
		btnAldatu.setBounds(318, 555, 140, 40);
		contentPane.add(btnAldatu);
		
		comboBox_Etxeko_T.addActionListener(this);
		comboBox_Kanpoko_T.addActionListener(this);
		btnItzuli.addActionListener(this);
		btnAldatu.addActionListener(this);
		
	}

	/**
	 * Interfazearen ekintzak kudeatzen ditu. Jatorrizko taldea aukeratzean 
	 * jokalariak kargatzen ditu, eta "Aldatu" botoia sakatzean jokalari baten
	 * talde aldaketa prozesatzen du baldintzak betetzen badira.
	 * Baita ere atzera egiteko botoia kontrolatzen du erabiltzailearen rolaren arabera.
	 * * @param e Gertaeraren informazioa biltzen duen ActionEvent objektua.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object o = e.getSource();
		 String Tizena = (String) comboBox_Etxeko_T.getSelectedItem();
		 String Tizena_K = (String) comboBox_Kanpoko_T.getSelectedItem();
		 if(o == comboBox_Etxeko_T) {
			 dtmTaula.setRowCount(0);
			 
			 ArrayList<Jokalaria> Jokalari = madao.GuztiaAtera(Tizena);
			 for(Jokalaria j: Jokalari ) {
				 dtmTaula.addRow(new Object [] {j.getIzena()});
			 }
				}
		 
		 if(o == btnAldatu) {
			 int fila = taulaEtxe_T.getSelectedRow();
			 int kanpoko_fila = comboBox_Kanpoko_T.getSelectedIndex();
			 
			 if(Tizena.equals(Tizena_K) || Tizena.contains("▼ ETXEKOAK") || Tizena_K.contains("▼ KANPOKOAK")) {
				 JOptionPane.showMessageDialog(this, "Taldeak berdinak dira edo talderen bat ez duzu aukeratu", null, JOptionPane.ERROR_MESSAGE);
				 LogDAO.getLogger().warning("Error aldaketan: Taldeak berdinak dira edo talderen bat ez duzu aukeratu");
				 return;
			 }
			
			 if(fila != -1) {
				 String Jizena_E = dtmTaula.getValueAt(fila, 0).toString();
				 JOptionPane.showMessageDialog(this, "Jokalaria: "+Jizena_E+" taldez aldatu da.");
				 dtmTaula.removeRow(fila);
				 madao.JokalariakAldatu(Jizena_E, kanpoko_fila);
				 LogDAO.getLogger().info("Administratzailea Jokalaria: "+Jizena_E+" "+Tizena+" taldetik "+Tizena_K+" taldera aldatu du");
			 }
			 
		 }
		 
		 if(o == btnItzuli) {
				if(ErabiltzaileaDAO.Erabiltzailemota.equals("admin")) {
					new MenuAdmin().setVisible(true);
					LogDAO.getLogger().info("Administratzaria bere menura bueltatu da.");
				}else if(ErabiltzaileaDAO.Erabiltzailemota.equals("epaile")) {
					new MenuEpailea().setVisible(true);
					LogDAO.getLogger().info("Epailea bere menura bueltatu da.");
				}else {
					new MenuErabiltzailea().setVisible(true);
					LogDAO.getLogger().info("Erabiltzaile arrunta bere menura bueltatu da.");
				}
				dispose();
				 }
			}
		 }