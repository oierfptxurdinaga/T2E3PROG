import javax.swing.*;

import DAO.LogDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Erabiltzaile arruntaren (ikuslearen/behatzailearen) menu nagusia bistaratzen duen interfaze grafikoa.
 * Hemendik aplikazioaren irakurketa-funtzionalitateetara soilik nabigatu daiteke 
 * (taldeak ikusi, jokalariak ikusi eta sailkapena ikusi).
 * @author [HIIM/T2]
 * @version 1.0
 */
public class MenuErabiltzailea extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    // Componentes
    private JLabel lblTitulo;

    private JButton btnTaldeakIkusi;
    private JButton btnJokalariakIkusi;
    private JButton btnSailkapenaIkusi;

    private JButton btnSaioaAmaitu;

    /**
     * MenuErabiltzailea klasearen eraikitzailea.
     * Interfaze grafikoaren osagaiak hasieratzen ditu.
     */
    public MenuErabiltzailea() {
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
        lblTitulo = new JLabel("MENU ERABILTZAILEA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitulo.setBounds(10, 30, 400, 50);

        // Botones
        btnTaldeakIkusi = new JButton("1. Taldeak ikusi");
        btnTaldeakIkusi.setBounds(100, 130, 250, 40);

        btnJokalariakIkusi = new JButton("2. Jokalariak ikusi");
        btnJokalariakIkusi.setBounds(100, 200, 250, 40);

        btnSailkapenaIkusi = new JButton("3. Sailkapena ikusi");
        btnSailkapenaIkusi.setBounds(100, 270, 250, 40);

        // Botón salir
        btnSaioaAmaitu = new JButton("Saioa amaitu");
        btnSaioaAmaitu.setBounds(160, 350, 140, 40);
        btnSaioaAmaitu.setBackground(new Color(0, 0, 255));
        btnSaioaAmaitu.setForeground(Color.WHITE);

        // Añadir componentes
        panel.add(lblTitulo);
        panel.add(btnTaldeakIkusi);
        panel.add(btnJokalariakIkusi);
        panel.add(btnSailkapenaIkusi);
        panel.add(btnSaioaAmaitu);

        // Configuración del JFrame
        getContentPane().add(panel);
        setTitle("Menu Pertsona");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        btnTaldeakIkusi.addActionListener(this);
        btnJokalariakIkusi.addActionListener(this);
        btnSailkapenaIkusi.addActionListener(this);
        btnSaioaAmaitu.addActionListener(this);
    }

    /**
     * Aplikazioa abiarazteko metodo nagusia.
     * MenuErabiltzailea leihoa ikusgarri egiten du.
     * @param args komando-lerroko argumentuak
     */
    public static void main(String[] args) {
        new MenuErabiltzailea().setVisible(true);
    }

    /**
     * Menuko botoietako bat sakatzean exekutatzen da.
     * Hautatutako botoiaren arabera, dagokion informazio-leihoa irekitzen du, 
     * ekintza log-ean erregistratzen du eta uneko menua ixten du.
     * @param e Gertaeraren informazioa biltzen duen ActionEvent objektua.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o==btnTaldeakIkusi) {
            new TaldeakIkusi().setVisible(true);
            LogDAO.getLogger().info("Erabiltzaile arrunta TaldeakIkusi altalera sartu da.");
            dispose();
        }
        
        if(o==btnJokalariakIkusi) {
            new JokalariakIkusi().setVisible(true);
            LogDAO.getLogger().info("Erabiltzaile arrunta JokalariakIkusi atalera sartu da.");
            dispose();
        }
        
        if(o==btnSailkapenaIkusi) {
            new SailkapenaIkusi().setVisible(true);
            LogDAO.getLogger().info("Erabiltzaile arrunta Sailkapena altalera sartu da.");
            dispose();
        }
        
        if(o==btnSaioaAmaitu) {
            new Saioa_Hasi().setVisible(true);
            LogDAO.getLogger().info("Erabiltzaile arrunta sahioa amitu du.");
            dispose();
        }
    }
}