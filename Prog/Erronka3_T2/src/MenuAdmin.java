import javax.swing.*;

import DAO.LogDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Administratzailearen menu nagusia bistaratzen duen interfaze grafikoa.
 * Hemendik aplikazioaren funtzionalitate ezberdinetara (taldeak ikusi, 
 * jokalariak kudeatu, sailkapena...) nabigatu daiteke.
 * @author [HIIM/T2]
 * @version 1.0
 */
public class MenuAdmin extends JFrame implements ActionListener {

    /**
	 * */
	private static final long serialVersionUID = 1L;

	// Componentes
    private JLabel lblTitulo;

    private JButton btnTaldesIkusi;
    private JButton btnJokalariakIkusi;
    private JButton btnJokalariakKudeatu;
    private JButton btnJokalariakAldatu;
    private JButton btnSailkapenaIkusi;

    private JButton btnSaioaAmaitu;

    /**
     * MenuAdmin klasearen eraikitzailea.
     * Interfaze grafikoaren osagaiak hasieratzen ditu.
     */
    public MenuAdmin() {
        initComponents();
    }

    /**
     * Leihoaren elementu grafiko guztiak (etiketak, botoiak eta panelak) 
     * sortu, kokatu eta konfiguratzen ditu. Baita ere gertaeren entzuleak esleitzen ditu.
     */
    private void initComponents() {

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        // Título
        lblTitulo = new JLabel("MENU ADMIN");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitulo.setBounds(90, 30, 300, 40);

        // Botones del menú
        btnTaldesIkusi = new JButton("1. Taldeak ikusi");
        btnTaldesIkusi.setBounds(100, 120, 250, 40);

        btnJokalariakIkusi = new JButton("2. Jokalariak ikusi");
        btnJokalariakIkusi.setBounds(100, 170, 250, 40);

        btnJokalariakKudeatu = new JButton("3. Jokalariak kudeatu");
        btnJokalariakKudeatu.setBounds(100, 220, 250, 40);

        btnJokalariakAldatu = new JButton("4. Jokalariak aldatu");
        btnJokalariakAldatu.setBounds(100, 270, 250, 40);

        btnSailkapenaIkusi = new JButton("5. Sailkapena ikusi");
        btnSailkapenaIkusi.setBounds(100, 320, 250, 40);

        // Botón salir
        btnSaioaAmaitu = new JButton("Saioa amaitu");
        btnSaioaAmaitu.setBounds(160, 380, 140, 40);
        btnSaioaAmaitu.setBackground(new Color(0, 0, 255));
        btnSaioaAmaitu.setForeground(Color.WHITE);

        // Añadir componentes
        panel.add(lblTitulo);
        panel.add(btnTaldesIkusi);
        panel.add(btnJokalariakIkusi);
        panel.add(btnJokalariakKudeatu);
        panel.add(btnJokalariakAldatu);
        panel.add(btnSailkapenaIkusi);
        panel.add(btnSaioaAmaitu);

        // Configuración del JFrame
        getContentPane().add(panel);
        setTitle("Menu Admin");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Botoiei ActionEventak ipintzen diogu:
        btnTaldesIkusi.addActionListener(this);
        btnJokalariakIkusi.addActionListener(this);
        btnJokalariakKudeatu.addActionListener(this);
        btnJokalariakAldatu.addActionListener(this);
        btnSailkapenaIkusi.addActionListener(this);
        btnSaioaAmaitu.addActionListener(this);
    }

    /**
     * Aplikazioa abiarazteko metodo nagusia.
     * Log-a hasieratu eta MenuAdmin leihoa ikusgarri egiten du.
     * @param args komando-lerroko argumentuak
     */
    public static void main(String[] args) {
    	LogDAO.inicializarLogger();
        new MenuAdmin().setVisible(true);
    }

    /**
     * Menuko botoietako bat sakatzean exekutatzen da.
     * Hautatutako botoiaren arabera, dagokion leihoa irekitzen du, 
     * ekintza log-ean erregistratzen du eta uneko menua ixten du.
     * @param e Gertaeraren informazioa biltzen duen ActionEvent objektua.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==btnTaldesIkusi) {
			new TaldeakIkusi().setVisible(true);
			LogDAO.getLogger().info("Administratzailea TaldeakIkusi altalera sartu da.");
			dispose();
		}
		
		if(o==btnJokalariakIkusi) {
			new JokalariakIkusi().setVisible(true);
			LogDAO.getLogger().info("Administratzailea JokalariakIkusi atalera sartu da.");
			dispose();
		}
		
		if(o==btnJokalariakKudeatu) {
			new JokalariakKudeatu().setVisible(true);
			LogDAO.getLogger().info("Administratzailea JokalariakKudeatu atalera sartu da.");
			dispose();
		}
		
		if(o==btnJokalariakAldatu) {
			new JokalariakAldatu().setVisible(true);
			LogDAO.getLogger().info("Administratzailea JokalariakAldatu atalera sartu da.");
			dispose();
		}
		
		if(o==btnSailkapenaIkusi) {
			new SailkapenaIkusi().setVisible(true);
			LogDAO.getLogger().info("Administratzailea Sailkapena altalera sartu da.");
			dispose();
		}

		if(o==btnSaioaAmaitu) {
			new Saioa_Hasi().setVisible(true);
			LogDAO.getLogger().info("Administratzailea sahioa amaitu du.");
			dispose();
		}		
	}
}