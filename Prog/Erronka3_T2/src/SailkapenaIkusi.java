import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ErabiltzaileaDAO;
import DAO.LogDAO;
import DAO.MenuAdmDAO;
import DAO.MenuEpaileaDAO;
import modelo.Sailkapena;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Denboraldiaren arabera taldeen sailkapena bistaratzen duen interfaze grafikoa.
 * Erabiltzaileak denboraldi bat aukeratzean, datu-basetik informazioa eskuratu 
 * eta taula batean erakusten du (Puntuak, Golak, Irabazitako partidak, etab.).
 * @author [HIIM/T2]
 * @version 1.0
 */
public class SailkapenaIkusi extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JPanel container;
    private JButton btnItzuli;
    private DefaultTableModel dtm;
    private JScrollPane scrollPane;
    private JComboBox<String> comboBox;

    String[] denboraldiak= {"▼ DENBORALDIAK", "2024/2025", "2025/2026", "2026/2027"};
    private JTable table;
    
    MenuAdmDAO madao = new MenuAdmDAO();
    
    /**
     * SailkapenaIkusi klasearen eraikitzailea.
     * Leihoaren elementu grafikoak (zerrenda, taula, botoiak...) sortu 
     * eta hasieratzen ditu, dagozkien entzuleak (listeners) esleituz.
     */
    public SailkapenaIkusi() {

        setTitle("Sailkapena Ikusi");
        setSize(808, 660);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        container = new JPanel();
        container.setBackground(new Color(220,220,220));
        container.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(container);
        container.setLayout(null);

        // TITULO
        JLabel lblTitulo = new JLabel("SAILKAPENA IKUSI");
        lblTitulo.setBounds(10, 8, 492, 40);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));
        container.add(lblTitulo);

        // BOTON ITZULI
        btnItzuli = new JButton("Itzuli");
        btnItzuli.setBounds(512, 8, 140, 40);
        btnItzuli.setBackground(new Color(0, 0, 255));
        btnItzuli.setForeground(Color.WHITE);
        btnItzuli.setFont(new Font("Arial", Font.BOLD, 18));
        container.add(btnItzuli);     

        scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 186, 726, 397);
        container.add(scrollPane);
        
        table = new JTable();
        table.setRowSelectionAllowed(false);
        table.setFont(new Font("Arial", Font.BOLD, 20));
        table.setForeground(new Color(0, 0, 128));
        table.setRowHeight(55);
        table.setModel(dtm =new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Taldeak","TPG","TPP","TPE", "TGOL", "TPTS", 
            }
        ));
        scrollPane.setViewportView(table);
        
        
        comboBox = new JComboBox();
        comboBox.setBounds(10, 107, 229, 41);
        comboBox.setFont(new Font("Arial", Font.BOLD, 20));
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(denboraldiak);
        comboBox.setModel(dcbm);
        container.add(comboBox);
        
        btnItzuli.addActionListener(this);
        comboBox.addActionListener(this);
    }

    /**
     * Aplikazioa abiarazteko metodo nagusia.
     * Log-a hasieratu eta SailkapenaIkusi leihoa ikusgarri egiten du.
     * @param args komando-lerroko argumentuak
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                LogDAO.inicializarLogger();
                SailkapenaIkusi frame = new SailkapenaIkusi();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * Interfazearen ekintzak kudeatzen ditu. Denboraldia aukeratzean 
     * sailkapena kargatzen du taulan. Era berean, "Itzuli" botoia kontrolatzen du 
     * erabiltzailearen rolaren arabera aurreko menura itzultzeko.
     * @param e Gertaeraren informazioa biltzen duen ActionEvent objektua.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
            
        if(o == comboBox) {
            int Denb_Zenbakia = comboBox.getSelectedIndex();
            dtm.setRowCount(0);
            ArrayList<Sailkapena> SI = madao.SailkapenAtera(Denb_Zenbakia);
            for(Sailkapena s : SI) {
                dtm.addRow(new Object [] {s.getIzenat(),s.getTPG(),s.getTPE(),s.getTPP(),s.getTPTS(),s.getTGOL()});
            }
            if(ErabiltzaileaDAO.Erabiltzailemota.equals("admin")) {
                LogDAO.getLogger().info("Administratzailea "+Denb_Zenbakia+" denboraldia ikusi du.");
            }else if(ErabiltzaileaDAO.Erabiltzailemota.equals("epaile")) {
                LogDAO.getLogger().info("Epailea "+Denb_Zenbakia+" denboraldia ikusi du.");
            }else {
                LogDAO.getLogger().info("Erabiltzaile arrunta "+Denb_Zenbakia+" denboraldia ikusi du.");
            }
                
        }
        
        if(o == btnItzuli) {
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
}