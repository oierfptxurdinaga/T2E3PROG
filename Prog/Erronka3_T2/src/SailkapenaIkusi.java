import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ErabiltzaileaDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SailkapenaIkusi extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
    private JButton btnItzuli;
    private JTable taula;
    private DefaultTableModel dtm;
    private JScrollPane scrollPane;
    private JComboBox comboBox;

    public SailkapenaIkusi() {

        setTitle("Sailkapena Ikusi");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        container = new JPanel();
        container.setLayout(null);
        container.setBackground(new Color(220,220,220));
        container.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(container);

        // TITULO
        JLabel lblTitulo = new JLabel("SAILKAPENA IKUSI");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));
        lblTitulo.setBounds(10, 10, 450, 40);
        container.add(lblTitulo);

        // BOTON ITZULI
        btnItzuli = new JButton("Itzuli");
        btnItzuli.setBackground(Color.RED);
        btnItzuli.setForeground(Color.WHITE);
        btnItzuli.setFont(new Font("Arial", Font.BOLD, 18));
        btnItzuli.setBounds(313, 60, 125, 40);
        container.add(btnItzuli);

        // COLUMNAS TABLA
        Vector<String> zutabeak = new Vector<>();
        zutabeak.add("TALDEAK");
        zutabeak.add("IRABAZITA +3");
        zutabeak.add("BERDINKETA +1");
        zutabeak.add("GALDUTA +0");
        zutabeak.add("TGOL");
        zutabeak.add("TOTALA");

        // DATOS TABLA
        Vector<Vector<Object>> datuak = new Vector<>();

        String[] taldeak = {
                "MORAZA",
                "LA MERCED",
                "CD BASKONIA",
                "SD ARIZ",
                "SANTUTXU FC"
        };

        for(String t : taldeak){
            Vector<Object> row = new Vector<>();
            row.add(t);
            row.add(0);
            row.add(0);
            row.add(0);
            row.add(0);
            row.add(0);
            datuak.add(row);
        }

        dtm = new DefaultTableModel(datuak, zutabeak);

        taula = new JTable(dtm);
        taula.setRowHeight(35);
        taula.setFont(new Font("Arial", Font.BOLD, 14));

        scrollPane = new JScrollPane(taula);
        scrollPane.setBounds(24, 153, 840, 200);
        container.add(scrollPane);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"▼ DENBORALDIAK", "2024/2025", "2025/2026", "2026/2027"}));
        comboBox.setBounds(66, 59, 161, 41);
        container.add(comboBox);
        
        btnItzuli.addActionListener(this);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                SailkapenaIkusi frame = new SailkapenaIkusi();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==btnItzuli) {
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