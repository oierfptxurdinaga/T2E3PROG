
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import javax.swing.*;
// DAO karpeta inportatzen dugu.
import DAO.*;

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
        initComponents();
    }

    private void initComponents() {

        // Labels
        lblTitulo = new JLabel("INICIO DE SESIÓN");
        lblUsuario = new JLabel("Usuario:");
        lblContrasena = new JLabel("Contraseña:");

        // Txt-ak
        txtUsuario = new JTextField();
        txtContrasena = new JPasswordField();

        // Botoiak
        btnLogin = new JButton("Iniciar Sesión");
        btnSalir = new JButton("Salir");

        // JFrame konfigurazioa
        setTitle("Login");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout sinple
        setLayout(null);

        // Posizioak esartezn ditugu
        lblTitulo.setBounds(110, 20, 150, 25);

        lblUsuario.setBounds(40, 70, 80, 25);
        txtUsuario.setBounds(120, 70, 150, 25);

        lblContrasena.setBounds(40, 110, 80, 25);
        txtContrasena.setBounds(120, 110, 150, 25);

        btnLogin.setBounds(60, 160, 110, 30);
        btnSalir.setBounds(180, 160, 110, 30);

        // Aldagaiak sartzen ditugu
        add(lblTitulo);
        add(lblUsuario);
        add(txtUsuario);
        add(lblContrasena);
        add(txtContrasena);
        add(btnLogin);
        add(btnSalir);
        
        //Botoiei ActionEventak ipintzen diogu:
        btnLogin.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    public static void main(String[] args) {
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
		}
			Emandakoizen = edao.ErabitzaielIzenaAtera(EraIzena);
			EmandakoPasahitz = edao.ErabitzaielPasahitzaAtera(EraIzena);
			
			if(Emandakoizen.equals(EraIzena) && EmandakoPasahitz.equals(EraPasahitz)) {
				JOptionPane.showMessageDialog(this, "Saio hasi zara");
				
				
				if(Emandakoizen.contains("Administratzailea0.2")) {
					ErabiltzaileaDAO.Erabiltzailemota = "admin";
					new MenuAdmin().setVisible(true);
					dispose(); // Jframea ixten du.
					
				}else if(Emandakoizen.contains("Epailea26")) {
					ErabiltzaileaDAO.Erabiltzailemota = "epaile";
					new MenuEpailea().setVisible(true);
					dispose();
					
				}else {
					ErabiltzaileaDAO.Erabiltzailemota = "erabiltzaile";
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