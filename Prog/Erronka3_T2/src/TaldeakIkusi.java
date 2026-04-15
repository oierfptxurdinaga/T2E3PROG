import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ErabiltzaileaDAO;
import DAO.LogDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;

public class TaldeakIkusi extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnItzuli;
	private JTextField txtElMoraza;
	private JTextField txtIakiSantiago;
	private JTextField txtArtxandakoZelaia;
	private JTextField txtLaMerced;
	private JTextField txtLuisJuan;
	private JTextField txtArtxandazelaia;
	private JTextField txtPachecoGervasio;
	private JTextField txtSantutxuFc;
	private JTextField txtMainomazelaia;
	private JTextField txtBaskonia;
	private JTextField txtIgnacioJuan;
	private JTextField txtArtunduagazelaia;
	private JTextField txtCdBaskonia;
	private JTextField txtFernandezAlfonso;
	private JTextField txtMeatzetazelaia;
	private JTextField txtCdAriz;
	private JTextField txtMartelPablo;
	private JTextField txtSoloartezelaia;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogDAO.inicializarLogger();
					TaldeakIkusi frame = new TaldeakIkusi();
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
	public TaldeakIkusi() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 808, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Taldeak-Ikusi");
		
		JLabel lblNewLabel = new JLabel("Taldeak Ikusi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 8, 492, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblMoraza = new JLabel("");
		lblMoraza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoraza.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\moraza-removebg-preview.png"));
		lblMoraza.setBounds(72, 66, 140, 113);
		contentPane.add(lblMoraza);
		
		JLabel lblMerced = new JLabel("");
		lblMerced.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMerced.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerced.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\merced (6).png"));
		lblMerced.setBounds(72, 319, 140, 113);
		contentPane.add(lblMerced);
		
		JLabel lblBaskonia = new JLabel("");
		lblBaskonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaskonia.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\basconia.png"));
		lblBaskonia.setBounds(289, 66, 140, 113);
		contentPane.add(lblBaskonia);
		
		JLabel lblSantutxu = new JLabel("");
		lblSantutxu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSantutxu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSantutxu.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\santutxu.png"));
		lblSantutxu.setBounds(289, 319, 140, 113);
		contentPane.add(lblSantutxu);
		
		JLabel lblUmore = new JLabel("");
		lblUmore.setHorizontalAlignment(SwingConstants.CENTER);
		lblUmore.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\umore ona_resized (1) (1) (1).png"));
		lblUmore.setBounds(543, 66, 140, 113);
		contentPane.add(lblUmore);
		
		JLabel lblAriz = new JLabel("");
		lblAriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblAriz.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\ariz.png"));
		lblAriz.setBounds(543, 319, 140, 113);
		contentPane.add(lblAriz);
		
		btnItzuli = new JButton("Itzuli");
		btnItzuli.setForeground(new Color(255, 255, 255));
		btnItzuli.setBackground(new Color(0, 0, 255));
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 24));
		btnItzuli.setBounds(512, 8, 140, 40);
		contentPane.add(btnItzuli);
		
		txtElMoraza = new JTextField();
		txtElMoraza.setFont(new Font("Arial", Font.BOLD, 10));
		txtElMoraza.setText("EL MORAZA");
		txtElMoraza.setBounds(88, 184, 115, 20);
		contentPane.add(txtElMoraza);
		txtElMoraza.setColumns(10);
		
		txtIakiSantiago = new JTextField();
		txtIakiSantiago.setFont(new Font("Arial", Font.BOLD, 10));
		txtIakiSantiago.setText("IÑAKI-SANTIAGO");
		txtIakiSantiago.setBounds(88, 225, 115, 20);
		contentPane.add(txtIakiSantiago);
		txtIakiSantiago.setColumns(10);
		
		txtArtxandakoZelaia = new JTextField();
		txtArtxandakoZelaia.setFont(new Font("Arial", Font.BOLD, 10));
		txtArtxandakoZelaia.setText("ARTXANDA-ZELAIA");
		txtArtxandakoZelaia.setBounds(88, 268, 115, 20);
		contentPane.add(txtArtxandakoZelaia);
		txtArtxandakoZelaia.setColumns(10);
		
		txtLaMerced = new JTextField();
		txtLaMerced.setFont(new Font("Arial", Font.BOLD, 10));
		txtLaMerced.setText("LA MERCED");
		txtLaMerced.setBounds(100, 505, 115, 20);
		contentPane.add(txtLaMerced);
		txtLaMerced.setColumns(10);
		
		txtLuisJuan = new JTextField();
		txtLuisJuan.setFont(new Font("Arial", Font.BOLD, 10));
		txtLuisJuan.setText("LUIS JUAN");
		txtLuisJuan.setBounds(100, 474, 115, 20);
		contentPane.add(txtLuisJuan);
		txtLuisJuan.setColumns(10);
		
		txtArtxandazelaia = new JTextField();
		txtArtxandazelaia.setText("ARTXANDA-ZELAIA");
		txtArtxandazelaia.setFont(new Font("Arial", Font.BOLD, 10));
		txtArtxandazelaia.setColumns(10);
		txtArtxandazelaia.setBounds(100, 443, 115, 20);
		contentPane.add(txtArtxandazelaia);
		
		txtPachecoGervasio = new JTextField();
		txtPachecoGervasio.setFont(new Font("Arial", Font.BOLD, 10));
		txtPachecoGervasio.setText("PACHECO-GERVA");
		txtPachecoGervasio.setColumns(10);
		txtPachecoGervasio.setBounds(310, 506, 115, 20);
		contentPane.add(txtPachecoGervasio);
		
		txtSantutxuFc = new JTextField();
		txtSantutxuFc.setFont(new Font("Arial", Font.BOLD, 10));
		txtSantutxuFc.setText("SANTUTXU FC");
		txtSantutxuFc.setColumns(10);
		txtSantutxuFc.setBounds(310, 443, 115, 20);
		contentPane.add(txtSantutxuFc);
		
		txtMainomazelaia = new JTextField();
		txtMainomazelaia.setText("MAINOMA-ZELAIA");
		txtMainomazelaia.setFont(new Font("Arial", Font.BOLD, 10));
		txtMainomazelaia.setColumns(10);
		txtMainomazelaia.setBounds(310, 475, 115, 20);
		contentPane.add(txtMainomazelaia);
		
		txtBaskonia = new JTextField();
		txtBaskonia.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtBaskonia.setText("CD BASKONIA");
		txtBaskonia.setColumns(10);
		txtBaskonia.setBounds(310, 183, 115, 20);
		contentPane.add(txtBaskonia);
		
		txtIgnacioJuan = new JTextField();
		txtIgnacioJuan.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtIgnacioJuan.setText("IGNACIO JUAN");
		txtIgnacioJuan.setColumns(10);
		txtIgnacioJuan.setBounds(310, 224, 115, 20);
		contentPane.add(txtIgnacioJuan);
		
		txtArtunduagazelaia = new JTextField();
		txtArtunduagazelaia.setText("ARTUNDUAGA");
		txtArtunduagazelaia.setFont(new Font("Arial", Font.BOLD, 10));
		txtArtunduagazelaia.setColumns(10);
		txtArtunduagazelaia.setBounds(310, 268, 115, 20);
		contentPane.add(txtArtunduagazelaia);
		
		txtCdBaskonia = new JTextField();
		txtCdBaskonia.setFont(new Font("Arial", Font.BOLD, 10));
		txtCdBaskonia.setText("SD UMORE ONA\r\n");
		txtCdBaskonia.setColumns(10);
		txtCdBaskonia.setBounds(543, 183, 115, 20);
		contentPane.add(txtCdBaskonia);
		
		txtFernandezAlfonso = new JTextField();
		txtFernandezAlfonso.setFont(new Font("Arial", Font.BOLD, 10));
		txtFernandezAlfonso.setText("HERNANDEZ-ALFONSO");
		txtFernandezAlfonso.setColumns(10);
		txtFernandezAlfonso.setBounds(544, 225, 115, 20);
		contentPane.add(txtFernandezAlfonso);
		
		txtMeatzetazelaia = new JTextField();
		txtMeatzetazelaia.setFont(new Font("Arial", Font.BOLD, 10));
		txtMeatzetazelaia.setText("MEATZETA-ZELAIA");
		txtMeatzetazelaia.setColumns(10);
		txtMeatzetazelaia.setBounds(544, 268, 115, 20);
		contentPane.add(txtMeatzetazelaia);
		
		txtCdAriz = new JTextField();
		txtCdAriz.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCdAriz.setText("CD ARIZ");
		txtCdAriz.setColumns(10);
		txtCdAriz.setBounds(544, 443, 115, 20);
		contentPane.add(txtCdAriz);
		
		txtMartelPablo = new JTextField();
		txtMartelPablo.setFont(new Font("Arial", Font.BOLD, 10));
		txtMartelPablo.setText("MARTEL PABLO");
		txtMartelPablo.setColumns(10);
		txtMartelPablo.setBounds(544, 505, 115, 20);
		contentPane.add(txtMartelPablo);
		
		txtSoloartezelaia = new JTextField();
		txtSoloartezelaia.setFont(new Font("Arial", Font.BOLD, 10));
		txtSoloartezelaia.setText("SOLOARTE-ZELAIA");
		txtSoloartezelaia.setColumns(10);
		txtSoloartezelaia.setBounds(544, 475, 115, 20);
		contentPane.add(txtSoloartezelaia);
		
		lblLogo = new JLabel("LOGO");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblLogo.setBounds(688, 8, 100, 60);
		contentPane.add(lblLogo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 1, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(781, 90, 0, 2);
		contentPane.add(separator);

		btnItzuli.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==btnItzuli) {
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
	}

