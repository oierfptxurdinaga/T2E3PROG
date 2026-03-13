import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.MenuAdmDAO;
import modelo.Jokalaria;

public class JokalariakKudeatu extends JFrame implements ActionListener,WindowListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	private JButton btnIrten;
	private JButton btnSartu;
	private JButton btnEzabatu;

	private JLabel lblIdLangilea;
	private JLabel lblIzena;
	private JLabel lblDorsala;
	private JTextField txtIDjokalaria;
	private JTextField txtIzena;
	private JTextField txtDorsala;
	private JLabel lblSailaInfo;

	private DefaultTableModel dtmTaula;
	private JTable taula;
	private JScrollPane scrollPane;
	private JComboBox<String> cmbtaldenIzena;

	private Vector<String> zutabeak;
	private Vector<Vector<String>> taulaDatuak;
	private JLabel lblSaila;

	private JTextField txtAdina;
	private JLabel lblAdina;
	
	MenuAdmDAO madao = new MenuAdmDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JokalariakKudeatu frame = new JokalariakKudeatu();
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
	public JokalariakKudeatu() {
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Jokalariak-Kudeatu");

		setBounds(100, 100, 820, 720);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);

		lblIdLangilea = new JLabel("ID Jokalaria");
		lblIdLangilea.setForeground(new Color(255, 0, 0));
		lblIdLangilea.setFont(new Font("Arial", Font.BOLD, 24));
		lblIdLangilea.setBounds(43, 112, 160, 40);
		container.add(lblIdLangilea);

		txtIDjokalaria = new JTextField();
		txtIDjokalaria.setForeground(new Color(0, 0, 128));
		txtIDjokalaria.setFont(new Font("Arial", Font.BOLD, 24));
		txtIDjokalaria.setBounds(210, 112, 360, 40);
		container.add(txtIDjokalaria);

		lblIzena = new JLabel("Izena");
		lblIzena.setForeground(new Color(255, 0, 0));
		lblIzena.setFont(new Font("Arial", Font.BOLD, 24));
		lblIzena.setBounds(43, 162, 115, 40);
		container.add(lblIzena);

		txtIzena = new JTextField();
		txtIzena.setForeground(new Color(0, 0, 128));
		txtIzena.setFont(new Font("Arial", Font.BOLD, 24));
		txtIzena.setBounds(210, 162, 360, 40);
		container.add(txtIzena);

		lblDorsala = new JLabel("Dorsala");
		lblDorsala.setForeground(new Color(255, 0, 0));
		lblDorsala.setFont(new Font("Arial", Font.BOLD, 24));
		lblDorsala.setBounds(43, 212, 115, 40);
		container.add(lblDorsala);

		txtDorsala = new JTextField();
		txtDorsala.setForeground(new Color(0, 0, 128));
		txtDorsala.setFont(new Font("Arial", Font.BOLD, 24));
		txtDorsala.setBounds(210, 212, 360, 40);
		container.add(txtDorsala);

		lblAdina = new JLabel("Adina");
		lblAdina.setForeground(new Color(255, 0, 0));
		lblAdina.setFont(new Font("Arial", Font.BOLD, 24));
		lblAdina.setBounds(43, 262, 115, 40);
		container.add(lblAdina);

		txtAdina = new JTextField();
		txtAdina.setForeground(new Color(0, 0, 128));
		txtAdina.setFont(new Font("Arial", Font.BOLD, 24));
		txtAdina.setBounds(210, 262, 360, 40);
		container.add(txtAdina);

		btnSartu = new JButton("Sartu");
		btnSartu.setBackground(new Color(255, 0, 0));
		btnSartu.setForeground(new Color(255, 255, 255));
		btnSartu.setFont(new Font("Arial", Font.BOLD, 24));
		btnSartu.setBounds(600, 112, 140, 40);
		container.add(btnSartu);

		btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBackground(new Color(255, 0, 0));
		btnEzabatu.setForeground(new Color(255, 255, 255));
		btnEzabatu.setFont(new Font("Arial", Font.BOLD, 24));
		btnEzabatu.setBounds(600, 162, 140, 40);
		container.add(btnEzabatu);

		btnIrten = new JButton("Itzuli");
		btnIrten.setBackground(new Color(255, 0, 0));
		btnIrten.setForeground(new Color(255, 255, 255));
		btnIrten.setFont(new Font("Arial", Font.BOLD, 24));
		btnIrten.setBounds(600, 262, 140, 40);
		container.add(btnIrten);

		lblSailaInfo = new JLabel("JOKALARIEN KUDEAKETA");
		lblSailaInfo.setForeground(new Color(0, 0, 0));
		lblSailaInfo.setFont(new Font("Arial", Font.BOLD, 24));
		lblSailaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSailaInfo.setBounds(43, 62, 700, 40);
		container.add(lblSailaInfo);

		lblSaila = new JLabel("Taldea:");
		lblSaila.setForeground(new Color(255, 0, 0));
		lblSaila.setFont(new Font("Arial", Font.BOLD, 24));
		lblSaila.setBounds(43, 10, 115, 40);
		container.add(lblSaila);

		cmbtaldenIzena = new JComboBox<>();
		cmbtaldenIzena.setForeground(new Color(0, 0, 0));
		cmbtaldenIzena.setFont(new Font("Arial", Font.BOLD, 20));
		cmbtaldenIzena.setBounds(210, 12, 360, 38);
		container.add(cmbtaldenIzena);
		
		String [] taldeak= {"▼ TALDEAK","LA MERCED", "MORAZA", "SANTUTXU FC", "CD BASKONIA", "CD ARIZ", "SD HUMORE ONA"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(taldeak);
		cmbtaldenIzena.setModel(dcbm);
		
		
		zutabeak = new Vector<>(Arrays.asList(
				"ID Jokalaria", "Izena", "Dorsala", "Adina"
		));

		taulaDatuak = new Vector<>();
		dtmTaula = new DefaultTableModel(taulaDatuak, zutabeak);

		taula = new JTable(dtmTaula);
		taula.setFont(new Font("Arial", Font.BOLD, 20));
		taula.setForeground(new Color(0, 0, 128));
		taula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taula.setRowHeight(30);

		scrollPane = new JScrollPane(taula);
		scrollPane.setBounds(43, 330, 700, 250);
		container.add(scrollPane);
	
		btnSartu.addActionListener(this);
		btnEzabatu.addActionListener(this);
		btnIrten.addActionListener(this);
		cmbtaldenIzena.addActionListener(this);
		
		taula.getSelectionModel().addListSelectionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 Object o = e.getSource();
		 String Tizena = (String) cmbtaldenIzena.getSelectedItem();
		 if(o == cmbtaldenIzena) {
			 Tizena = (String) cmbtaldenIzena.getSelectedItem();
			  // Vaciamos la tabla solo al cambiar el combo
		        dtmTaula.setRowCount(0); 
		        
		        ArrayList<Jokalaria> Jate = madao.Jokalariak_atera(Tizena);
		        for(Jokalaria j : Jate) {
		        dtmTaula.addRow(new Object[] {j.getJokalariId(),j.getIzena(),j.getZbkJo(),j.getAdina()});	
		        }
		        
		 }
		 
		 if(o == btnSartu) {
			 int JokalariId=Integer.parseInt(txtIDjokalaria.getText());
			 String Jizena=txtIzena.getText();
			 int Jdorsal=Integer.parseInt(txtDorsala.getText());
			 int Jadina=Integer.parseInt(txtAdina.getText());
			 
			 madao.btnSartu(Tizena, Jizena, JokalariId, Jdorsal, Jadina);
			 dtmTaula.addRow(new Object[] {JokalariId,Jizena,Jadina,Jdorsal});
			 
			 //Behin datuak sartzerakoan estekak esabatzen dira. 
			 txtIDjokalaria.setText("");
			 txtIzena.setText("");
			 txtAdina.setText("");
			 txtDorsala.setText("");
			 
		 }
		 
		 if(o == btnEzabatu) {
			 int fila = taula.getSelectedRow();
		        
		        if (fila == -1) {
		        JOptionPane.showMessageDialog(this, "Ez duzu taulatik ezer aukeratu");
		        }else {
		       
		        int JokalariId=Integer.parseInt(txtIDjokalaria.getText());
		        madao.btnEzabatu(JokalariId);
		        dtmTaula.removeRow(fila);
		        }

		 }
		 
		 if(o == btnIrten) {
		 new MenuAdmin().setVisible(true);
		 dispose();
		 }
		 
		 
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
if (!e.getValueIsAdjusting()) {
	        
	        int fila = taula.getSelectedRow();
	        
	        if (fila != -1) {
	        	
	        	String Jid = dtmTaula.getValueAt(fila, 0).toString();
	        	String Jizena = dtmTaula.getValueAt(fila, 1).toString();
	        	String Jdorsala = dtmTaula.getValueAt(fila, 2).toString();
	        	String Jadina = dtmTaula.getValueAt(fila, 3).toString();
	        	
	        	txtIDjokalaria.setText(Jid);
	        	txtIzena.setText(Jizena);
	        	txtDorsala.setText(Jdorsala);
	        	txtAdina.setText(Jadina);
	        	
	        }else {
	        	
	        	txtIDjokalaria.setText("");
	        	txtIzena.setText("");
	        	txtDorsala.setText("");
	        	txtAdina.setText("");
	        }
		
		}

	}
	
}
