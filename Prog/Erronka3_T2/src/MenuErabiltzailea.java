import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuErabiltzailea extends JFrame implements ActionListener {

    // Componentes
    private JLabel lblTitulo;

    private JButton btnTaldeakIkusi;
    private JButton btnJokalariakIkusi;
    private JButton btnSailkapenaIkusi;

    private JButton btnSaioaAmaitu;

    public MenuErabiltzailea() {
        initComponents();
    }

    private void initComponents() {

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        // Título
        lblTitulo = new JLabel("MENU PERTSONA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitulo.setBounds(60, 30, 350, 50);

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
        btnSaioaAmaitu.setBackground(Color.RED);
        btnSaioaAmaitu.setForeground(Color.WHITE);

        // Añadir componentes
        panel.add(lblTitulo);
        panel.add(btnTaldeakIkusi);
        panel.add(btnJokalariakIkusi);
        panel.add(btnSailkapenaIkusi);
        panel.add(btnSaioaAmaitu);

        // Configuración del JFrame
        add(panel);
        setTitle("Menu Pertsona");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnTaldeakIkusi.addActionListener(this);
        btnJokalariakIkusi.addActionListener(this);
        btnSailkapenaIkusi.addActionListener(this);
        btnSaioaAmaitu.addActionListener(this);
    }

    public static void main(String[] args) {
        new MenuErabiltzailea().setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==btnTaldeakIkusi) {
			
		}
		
		if(o==btnJokalariakIkusi) {
			new JokalariakIkusi().setVisible(true);
			dispose();
		}
		
		if(o==btnSailkapenaIkusi) {
			
		}
		
		if(o==btnSaioaAmaitu) {
			new Saioa_Hasi().setVisible(true);
			dispose();
		}
	}
}