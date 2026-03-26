import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ErabiltzaileaDAO;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JokalariakAldatu frame = new JokalariakAldatu();
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
	public JokalariakAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Jokalariak-Aldatu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 23, 304, 40);
		contentPane.add(lblNewLabel);
		
		btnItzuli = new JButton("Irten");
		btnItzuli.setForeground(Color.WHITE);
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBackground(Color.RED);
		btnItzuli.setBounds(334, 23, 140, 40);
		contentPane.add(btnItzuli);
		
		comboBox_Etxeko_T = new JComboBox();
		comboBox_Etxeko_T.setModel(new DefaultComboBoxModel(new String[] {"▼ ETXEKOAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		comboBox_Etxeko_T.setBounds(246, 112, 140, 32);
		contentPane.add(comboBox_Etxeko_T);
		
		comboBox_Kanpoko_T = new JComboBox();
		comboBox_Kanpoko_T.setModel(new DefaultComboBoxModel(new String[] {"▼ KANPOKOAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		comboBox_Kanpoko_T.setBounds(556, 112, 140, 32);
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
		scrollPane.setBounds(10, 115, 220, 238);
		contentPane.add(scrollPane);
		
		btnAldatu = new JButton("Aldatu");
		btnAldatu.setForeground(Color.WHITE);
		btnAldatu.setFont(new Font("Arial", Font.BOLD, 24));
		btnAldatu.setBackground(Color.RED);
		btnAldatu.setBounds(313, 223, 161, 40);
		contentPane.add(btnAldatu);
		
		comboBox_Etxeko_T.addActionListener(this);
		comboBox_Kanpoko_T.addActionListener(this);
		btnItzuli.addActionListener(this);
		btnAldatu.addActionListener(this);
		
	}

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
				 return;
			 }
			
			 if(fila != -1) {
				 String Jizena_E = dtmTaula.getValueAt(fila, 0).toString();
				 JOptionPane.showMessageDialog(this, "Jokalaria: "+Jizena_E+" taldez aldatu da.");
				 dtmTaula.removeRow(fila);
				 madao.JokalariakAldatu(Jizena_E, kanpoko_fila);
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
			}
		 }

