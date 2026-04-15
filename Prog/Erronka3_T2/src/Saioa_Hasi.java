
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;

import javax.swing.JFrame;


import javax.swing.*;
// DAO karpeta inportatzen dugu.
import DAO.*;
import java.awt.Color;
import java.awt.Font;

public class Saioa_Hasi extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Componentes
    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    
    private JButton btnLogin;
    private JButton btnSalir;
    
   //ErabiltzaileaDAO klasea intatziatzen dugu bere metodoei deitzeko.
    ErabiltzaileaDAO edao = new ErabiltzaileaDAO();
    
    public Saioa_Hasi() {
    	setResizable(false);
        initComponents();
    }

    private void initComponents() {

        // Labels
        lblTitulo = new JLabel("SAHIOA HASI");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsuario = new JLabel("Erabilrzailea:");
        lblUsuario.setForeground(new Color(0, 0, 255));
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 15));
        lblContrasena = new JLabel("Pasahitza:");
        lblContrasena.setFont(new Font("Arial", Font.BOLD, 15));
        lblContrasena.setForeground(new Color(0, 0, 255));

        // Txt-ak
        txtUsuario = new JTextField();
        txtContrasena = new JPasswordField();

        // Botoiak
        btnLogin = new JButton("Sahioa Hasi");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
        btnLogin.setBackground(new Color(0, 0, 255));
        btnSalir = new JButton("Irten");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 15));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setBackground(new Color(0, 0, 255));

        // JFrame konfigurazioa
        setTitle("Login");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Layout sinple
        getContentPane().setLayout(null);

        // Posizioak esartezn ditugu
        lblTitulo.setBounds(101, 20, 169, 25);

        lblUsuario.setBounds(24, 70, 96, 25);
        txtUsuario.setBounds(120, 70, 150, 25);

        lblContrasena.setBounds(24, 110, 96, 25);
        txtContrasena.setBounds(120, 110, 150, 25);

        btnLogin.setBounds(24, 157, 125, 30);
        btnSalir.setBounds(184, 157, 125, 30);

        // Aldagaiak sartzen ditugu
        getContentPane().add(lblTitulo);
        getContentPane().add(lblUsuario);
        getContentPane().add(txtUsuario);
        getContentPane().add(lblContrasena);
        getContentPane().add(txtContrasena);
        getContentPane().add(btnLogin);
        getContentPane().add(btnSalir);
        
        //Botoiei ActionEventak ipintzen diogu:
        btnLogin.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public static void main(String[] args) {
    	LogDAO.inicializarLogger();
    	new Saioa_Hasi().setVisible(true);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		String EraIzena = txtUsuario.getText();
		String EraPasahitz = txtContrasena.getText();
		String Emandakoizen = "";
		String EmandakoPasahitz = "";
		
		if(o==btnLogin) {
			// Erabiltzailea ez badu ezer idatzi errore mezua emango du.
			
			if(EraIzena.isEmpty() || EraPasahitz.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ez duzu erabiltzailearen-izena edo pasahitza bat jarri!!");
				LogDAO.getLogger().warning("Huts egindako login-saiakera: eremu hutsak edo pasahitza edo erabiltzaile okerrak.");
	            return;
		}
			Emandakoizen = edao.ErabitzaielIzenaAtera(EraIzena);
			EmandakoPasahitz = edao.ErabitzaielPasahitzaAtera(EraIzena);
			
			if(Emandakoizen.equals(EraIzena) && EmandakoPasahitz.equals(EraPasahitz)) {
				JOptionPane.showMessageDialog(this, "Saio hasi zara");
				
				
				if(Emandakoizen.contains("Administratzailea0.2")) {
					ErabiltzaileaDAO.Erabiltzailemota = "admin";
					LogDAO.getLogger().info("LOGIN: Administratzailea saioa hasi du: " + EraIzena);
					new MenuAdmin().setVisible(true);
					dispose(); // Jframea ixten du.
					
					
				}else if(Emandakoizen.contains("Epailea26")) {
					ErabiltzaileaDAO.Erabiltzailemota = "epaile";
					LogDAO.getLogger().info("LOGIN: Epailea saioa hasi du: " + EraIzena);
					new MenuEpailea().setVisible(true);
					dispose();
					
				}else {
					ErabiltzaileaDAO.Erabiltzailemota = "erabiltzaile";
					LogDAO.getLogger().info("LOGIN: Erabiltzaile arrunta saioa hasi du: " + EraIzena);
					new MenuErabiltzailea().setVisible(true);
					dispose();
				}
				
			}else {
				JOptionPane.showMessageDialog(this, "Erabiltzailearen-izena edo pasahitza okerrak dira");
				txtUsuario.setText("");
				txtContrasena.setText("");
			}
		}
		
		if(o==btnSalir) {
			JOptionPane.showMessageDialog(this, "Programatik ateratzen, Agur!!!");
			System.exit(0);
		}
	}
}