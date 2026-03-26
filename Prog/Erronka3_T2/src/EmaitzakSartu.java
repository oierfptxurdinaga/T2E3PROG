import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.MenuAdmDAO;
import DAO.MenuEpaileaDAO;
import modelo.Jokalaria;
import modelo.Partidua;

public class EmaitzakSartu extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnItzuli;
	private JButton btnSartu;
	
	private JComboBox TaldeLocal;
	private JComboBox TaldeKanpoko;
	private JComboBox Denboraldiak;
	
	private JTextField textMinuL;
	private JTextField textMinuK;
	
	private JScrollPane scrollPaneKanpokoak;
	
	private Vector<String> zutabeak;
	private Vector<Vector<String>> taulaDatuak;
	
	private DefaultTableModel dtm;
	private JTable table;
	private DefaultTableModel dtme;
	private JTable tableE;
	private DefaultTableModel dtmk;
	private JTable tableK;
	
	MenuAdmDAO madao = new MenuAdmDAO();
	MenuEpaileaDAO mepdao = new MenuEpaileaDAO(); 

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
		setBounds(100, 100, 754, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emaitzak-Sartu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 23, 304, 40);
		contentPane.add(lblNewLabel);
		
		btnItzuli = new JButton("Irten");
		btnItzuli.setForeground(Color.WHITE);
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBackground(Color.RED);
		btnItzuli.setBounds(303, 23, 140, 40);
		contentPane.add(btnItzuli);
		
		TaldeLocal = new JComboBox();
		TaldeLocal.setModel(new DefaultComboBoxModel(new String[] {"▼ LOKALA", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		TaldeLocal.setBounds(46, 76, 140, 32);
		contentPane.add(TaldeLocal);
		
		TaldeKanpoko = new JComboBox();
		TaldeKanpoko.setModel(new DefaultComboBoxModel(new String[] {"▼ KANPOKOAK", "LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"}));
		TaldeKanpoko.setBounds(590, 76, 140, 32);
		contentPane.add(TaldeKanpoko);
		
		Denboraldiak = new JComboBox();
		Denboraldiak.setModel(new DefaultComboBoxModel(new String[] {"▼ DENBORALDIAK", "2024/2025", "2025/2026", "2026/2027"}));
		Denboraldiak.setBounds(282, 209, 161, 32);
		contentPane.add(Denboraldiak);
		
		btnSartu = new JButton("Sartu");
		btnSartu.setForeground(Color.WHITE);
		btnSartu.setFont(new Font("Arial", Font.BOLD, 24));
		btnSartu.setBackground(Color.RED);
		btnSartu.setBounds(453, 23, 140, 40);
		contentPane.add(btnSartu);
		
		textMinuL = new JTextField("0");
		textMinuL.setColumns(10);
		textMinuL.setBounds(231, 116, 120, 32);
		contentPane.add(textMinuL);
		
		textMinuK = new JTextField("0");
		textMinuK.setColumns(10);
		textMinuK.setBounds(440, 116, 120, 32);
		contentPane.add(textMinuK);
		
		JScrollPane scrollPaneEtxea = new JScrollPane();
		scrollPaneEtxea.setBounds(46, 118, 130, 110);
		contentPane.add(scrollPaneEtxea);
		
		zutabeak = new Vector<>(Arrays.asList(
				"Izena"
		));
		
		dtme = new DefaultTableModel(taulaDatuak, zutabeak);
		dtmk = new DefaultTableModel(taulaDatuak, zutabeak);
		
		tableE = new JTable(dtme);
		scrollPaneEtxea.setViewportView(tableE);
	
		scrollPaneKanpokoak = new JScrollPane();
		scrollPaneKanpokoak.setBounds(600, 118, 130, 110);
		contentPane.add(scrollPaneKanpokoak);
		
		tableK = new JTable(dtmk);
		scrollPaneKanpokoak.setViewportView(tableK);
		
		/*JComboBox Jardunaldiak = new JComboBox();
		Jardunaldiak.setModel(new DefaultComboBoxModel(new String[] {"▼ JARDUNALDIA"}));
		Jardunaldiak.setBounds(282, 255, 161, 32);
		contentPane.add(Jardunaldiak);*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 304, 720, 188);
		contentPane.add(scrollPane);
		
		dtm = new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			        "IdPartidua","Jardunaldia","Talde_L","Talde_K","Gol_L","Gol_K"
			    }
			);

			table = new JTable(dtm);
			scrollPane.setViewportView(table);

		btnItzuli.addActionListener(this);
		btnSartu.addActionListener(this);
		TaldeLocal.addActionListener(this);
		TaldeKanpoko.addActionListener(this);
		Denboraldiak.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		String Tizena_L = (String) TaldeLocal.getSelectedItem();
		String Tizena_K = (String) TaldeKanpoko.getSelectedItem(); 
		String DenboIzen = (String) Denboraldiak.getSelectedItem();
		
		if(o == TaldeLocal) {
			dtme.setRowCount(0);
			
			ArrayList<Jokalaria> Jokalaria = madao.JokalariakAtera(Tizena_L);
			for(Jokalaria j : Jokalaria) {
				dtme.addRow(new Object[] {j.getIzena()});
			}
		}
		
		if(o == TaldeKanpoko) {
			dtmk.setRowCount(0);
			
			ArrayList<Jokalaria> Jokalaria_K = madao.JokalariakAtera(Tizena_K);
			for(Jokalaria j : Jokalaria_K) {
				dtmk.addRow(new Object [] {j.getIzena()});
			}
		}
		
		if(o == Denboraldiak) {
			dtm.setRowCount(0);
			
			ArrayList<Partidua> PartiduakA = mepdao.PartiduakAtera(DenboIzen);
			for(Partidua p : PartiduakA) {
				dtm.addRow(new Object [] {p.getJardunaldia(),p.getPartiduaId(),p.getTaldeLokala(),p.getTaldeKanpokoa(),p.getGolLokala(),p.getGolKanpokoa()});
			}
		}
		
		if(o == btnSartu) {
			if(Tizena_L.equals(Tizena_K) || Tizena_L.equals("▼ LOKALA") || Tizena_K.equals("▼ KANPOKOAK")) {
				JOptionPane.showMessageDialog(this, "Taldeak berdinak dira edo baten bat ez da haukeratu", null, JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int zutabea_L = tableE.getSelectedRow();
			int zutabea_K = tableK.getSelectedRow();
			
			if(zutabea_L !=-1 && zutabea_K !=-1) {
				String Jokalari_L = dtme.getValueAt(zutabea_L, 0).toString();
				String Jokalari_K = dtmk.getValueAt(zutabea_K, 0).toString();
			}
			
			int ML = Integer.parseInt(textMinuL.getText());
			int MK = Integer.parseInt(textMinuK.getText());
			
			if(ML < 0 || MK < 0 || ML> 120 || MK > 120 || ML==MK) {
			JOptionPane.showMessageDialog(this, "Error : Minituak zenbaki dezegokia dira edo minutuak berdinak dira!! ", null, JOptionPane.ERROR_MESSAGE);
			return;
			}
			
			int idpartidua = table.getSelectedRow();
			if(idpartidua != -1) {
				String IdPartidua = dtm.getValueAt(idpartidua, 0).toString();
			}
		}
		
		if(o == btnItzuli) {
			new MenuEpailea().setVisible(true);
			dispose();
		}
		
	}
}
