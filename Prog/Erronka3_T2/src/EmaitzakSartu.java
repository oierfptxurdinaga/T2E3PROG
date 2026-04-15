import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import DAO.LogDAO;
import DAO.MenuAdmDAO;
import DAO.MenuEpaileaDAO;
import modelo.Jokalaria;
import modelo.Partidua;
import javax.swing.BorderFactory;

public class EmaitzakSartu extends JFrame  implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnItzuli;
	private JButton btnSartu;
	private JButton btnEzabatu;
	
	private JComboBox Denboraldiak;
	
	private JTextField textMinutu;

	private JScrollPane scrollPaneKanpokoak;
	
	private Vector<String> zutabeak;
	private Vector<Vector<String>> taulaDatuak;
	
	private DefaultTableModel dtm;
	private JTable table;
	private DefaultTableModel dtme;
	private JTable tableE;
	private DefaultTableModel dtmk;
	private JTable tableK;
	
	private ArrayList<Partidua> listaPartiduak = new ArrayList<>();
	private ArrayList<Jokalaria> listaJokL = new ArrayList<>();
	private ArrayList<Jokalaria> listaJokK = new ArrayList<>();
	
	MenuAdmDAO madao = new MenuAdmDAO();
	MenuEpaileaDAO mepdao = new MenuEpaileaDAO(); 
	private JLabel lblLokalak;
	private JLabel lblKanpokoak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogDAO.inicializarLogger();
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 808, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Emaitzak-Sartu");
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
		
		Denboraldiak = new JComboBox();
		Denboraldiak.setFont(new Font("Arial", Font.BOLD, 20));
		Denboraldiak.setModel(new DefaultComboBoxModel(new String[] {"▼ DENBORALDIAK", "2024/2025", "2025/2026", "2026/2027"}));
		Denboraldiak.setBounds(279, 192, 218, 38);
		contentPane.add(Denboraldiak);
		
		btnSartu = new JButton("Sartu");
		btnSartu.setForeground(Color.WHITE);
		btnSartu.setFont(new Font("Arial", Font.BOLD, 24));
		btnSartu.setBackground(new Color(0, 0, 255));
		btnSartu.setBounds(211, 555, 140, 40);
		contentPane.add(btnSartu);
		
		textMinutu = new JTextField("0");
		textMinutu.setHorizontalAlignment(SwingConstants.CENTER);
		textMinutu.setColumns(10);
		textMinutu.setBounds(321, 137, 130, 32);
		contentPane.add(textMinutu);
		
		
		
		JScrollPane scrollPaneEtxea = new JScrollPane();
		scrollPaneEtxea.setBounds(46, 118, 152, 157);
		contentPane.add(scrollPaneEtxea);
		
		zutabeak = new Vector<>(Arrays.asList(
				"Izena"
		));
		
		dtme = new DefaultTableModel(taulaDatuak, zutabeak);
		dtmk = new DefaultTableModel(taulaDatuak, zutabeak);
		
		tableE = new JTable(dtme);
		tableE.setForeground(new Color(0, 0, 255));
		tableE.setFont(new Font("Arial", Font.BOLD, 15));
		scrollPaneEtxea.setViewportView(tableE);
	
		scrollPaneKanpokoak = new JScrollPane();
		scrollPaneKanpokoak.setBounds(600, 118, 152, 157);
		contentPane.add(scrollPaneKanpokoak);
		
		tableK = new JTable(dtmk);
		tableK.setForeground(new Color(0, 0, 255));
		tableK.setFont(new Font("Arial", Font.BOLD, 15));
		scrollPaneKanpokoak.setViewportView(tableK);
		
		/*JComboBox Jardunaldiak = new JComboBox();
		Jardunaldiak.setModel(new DefaultComboBoxModel(new String[] {"▼ JARDUNALDIA"}));
		Jardunaldiak.setBounds(282, 255, 161, 32);
		contentPane.add(Jardunaldiak);*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 294, 720, 250);
		contentPane.add(scrollPane);
		
		dtm = new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			        "IdPartidua","Jardunaldia","Talde_L","Talde_K","Gol_L","Gol_K"
			    }
			);

			table = new JTable(dtm);
			table.setForeground(new Color(0, 0, 255));
			table.setFont(new Font("Arial", Font.BOLD, 15));
			scrollPane.setViewportView(table);
			
			btnEzabatu = new JButton("Ezabatu");
			btnEzabatu.setForeground(Color.WHITE);
			btnEzabatu.setFont(new Font("Arial", Font.BOLD, 24));
			btnEzabatu.setBackground(new Color(0, 0, 255));
			btnEzabatu.setBounds(440, 555, 140, 40);
			contentPane.add(btnEzabatu);
			
			JLabel lblLogo = new JLabel("LOGO");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			lblLogo.setBounds(688, 8, 100, 60);
			contentPane.add(lblLogo);
			
			lblLokalak = new JLabel("Lokalak");
			lblLokalak.setHorizontalAlignment(SwingConstants.CENTER);
			lblLokalak.setForeground(Color.BLUE);
			lblLokalak.setFont(new Font("Arial", Font.BOLD, 24));
			lblLokalak.setBackground(Color.WHITE);
			lblLokalak.setBounds(46, 69, 152, 40);
			contentPane.add(lblLokalak);
			
			lblKanpokoak = new JLabel("Kanpokoak\r\n");
			lblKanpokoak.setHorizontalAlignment(SwingConstants.CENTER);
			lblKanpokoak.setForeground(Color.BLUE);
			lblKanpokoak.setFont(new Font("Arial", Font.BOLD, 24));
			lblKanpokoak.setBackground(Color.WHITE);
			lblKanpokoak.setBounds(600, 69, 152, 40);
			contentPane.add(lblKanpokoak);

		btnItzuli.addActionListener(this);
		btnSartu.addActionListener(this);
		Denboraldiak.addActionListener(this);
		table.addMouseListener(this);
		btnEzabatu.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		String DenboIzen = (String) Denboraldiak.getSelectedItem();
	    int filaTaula = table.getSelectedRow();
		
	    if(o == Denboraldiak) {
			dtm.setRowCount(0);
			
			listaPartiduak = mepdao.PartiduakAtera(DenboIzen);
			for(Partidua p : listaPartiduak) {
				dtm.addRow(new Object[] {p.getPartiduaId(),p.getJardunaldia(),p.getTaldeLokala(),p.getTaldeKanpokoa(),p.getGolLokala(),p.getGolKanpokoa()});
			}
		}
		
		if(o == btnSartu) {
			
			 if(DenboIzen.equals("2024/2025")|| DenboIzen.equals("2025/2026")) {
	            	JOptionPane.showMessageDialog(this, DenboIzen + " denboraldia amaitu da, ezin dira emaitzak sartu.");
	            	LogDAO.getLogger().warning("Errorea datuak sartzerakoan: Ezin da "+DenboIzen+" denboraldi honetan aldaketak egin, ze jada denboraldia amaitu da.");
	            	return;
	            }
			
			
			int filaL = tableE.getSelectedRow();
		    int filaK = tableK.getSelectedRow();
		    
			if(filaTaula == -1) {
				JOptionPane.showMessageDialog(this, "Taulatik ez duzu partidurik aukeratu");
				LogDAO.getLogger().warning("Errorea datuak sartzerakoan: Taulatik ez dira partidurik aukeratu");
				return;
			}
			
			Partidua p = listaPartiduak.get(filaTaula);
	        int jokalariaId = -1;
	        int minutua = 0;
	        boolean esLocal = false;
	        
	        int jardunalID = (int) dtm.getValueAt(filaTaula, 1);
	       
		    try {
		    if(filaL != -1) { //Gol Lokalak sartzeko
		    	jokalariaId = listaJokL.get(filaL).getJokalariId();
		    	 minutua = Integer.parseInt(textMinutu.getText());
		    	 esLocal = true;
		    	
		    }else if(filaK != -1) {
		    		jokalariaId = listaJokK.get(filaK).getJokalariId();
		    	 	minutua = Integer.parseInt(textMinutu.getText());
		    }else {
		        JOptionPane.showMessageDialog(this, "Hautatu jokalari bat!");
		        LogDAO.getLogger().warning("Errorea datuak sartzerakoan: Ez duzu jokalaririk aukeratu.");
		        return;
		    }
		
            if(minutua <= 0 || minutua > 120) {
                JOptionPane.showMessageDialog(this, "Minutu okerra!");
                LogDAO.getLogger().warning("Errorea datuak sartzerakoan: Minutuak dezegokiak dira.");
                return;   
            }
            
            boolean ok = mepdao.registrarGol(p.getPartiduaId(), jokalariaId, minutua, p.getJardunaldia(), esLocal);
            
            if(ok) {
                JOptionPane.showMessageDialog(this, "Gola ondo gorde da!");
                Denboraldiak.setSelectedIndex(Denboraldiak.getSelectedIndex()); 
                textMinutu.setText("0");
                LogDAO.getLogger().info("Epailea emaitza berri bat sartu du : "+DenboIzen+" denboraldian");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idatzi minutu baliodun bat!");
        }
		
	}
		if(o == btnEzabatu) {
			boolean ezabatu = false;
			int partiduId = (int) dtm.getValueAt(filaTaula, 0);
			
			if(DenboIzen.equals("2024/2025")|| DenboIzen.equals("2025/2026")) {
            	JOptionPane.showMessageDialog(this, DenboIzen + " denboraldia amaitu da, ezin dira emaitzak ezabatu.");
            	return;
            }
			
			if(filaTaula == -1) {
				JOptionPane.showMessageDialog(this, "Taulatik ez duzu partidurik aukeratu");
				return;
			}else {
			int option = JOptionPane.showConfirmDialog(this, "Partidu honen emaitzak ezabatzea ?", null, JOptionPane.YES_NO_OPTION);
				
			if(option == JOptionPane.YES_OPTION) {
				mepdao.EmaitzakEzabatu(partiduId);
				Denboraldiak.setSelectedIndex(Denboraldiak.getSelectedIndex());
				LogDAO.getLogger().info("Epailea: "+DenboIzen+" denboraldiko "+partiduId+"garren partiduaren emaitzak ezabatu ditu.");
			}else if(option == JOptionPane.NO_OPTION) {
				
			}
		}
	}
		if(o == btnItzuli) {
			new MenuEpailea().setVisible(true);
			LogDAO.getLogger().info("Epailea bere menura bueltatu da.");
			dispose();
		}
}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int fila = table.getSelectedRow();
        if (fila != -1) {
            
        	String tLocal = (String) dtm.getValueAt(fila, 2);
            String tKanpo = (String) dtm.getValueAt(fila, 3);
            
            dtme.setRowCount(0);
            listaJokL = madao.JokalariakAtera(tLocal);
            for(Jokalaria j : listaJokL) dtme.addRow(new Object[]{j.getIzena()});
            
            dtmk.setRowCount(0);
            listaJokK = madao.JokalariakAtera(tKanpo);
            for(Jokalaria j : listaJokK) dtmk.addRow(new Object[]{j.getIzena()});
            LogDAO.getLogger().info(fila+" partiduan "+tLocal+" VS "+tKanpo+" taldeak jokatuko dute.");
            }
        
      }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
