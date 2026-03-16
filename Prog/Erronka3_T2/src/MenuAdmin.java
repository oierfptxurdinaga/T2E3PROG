import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Componentes
    private JLabel lblTitulo;

    private JButton btnTaldesIkusi;
    private JButton btnJokalariakIkusi;
    private JButton btnJokalariakKudeatu;
    private JButton btnJokalariakAldatu;
    private JButton btnSailkapenaIkusi;

    private JButton btnSaioaAmaitu;

    public MenuAdmin() {
        initComponents();
    }

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
        btnSaioaAmaitu.setBackground(Color.RED);
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
        add(panel);
        setTitle("Menu Admin");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Botoiei ActionEventak ipintzen diogu:
        btnTaldesIkusi.addActionListener(this);
        btnJokalariakIkusi.addActionListener(this);
        btnJokalariakKudeatu.addActionListener(this);
        btnJokalariakAldatu.addActionListener(this);
        btnSailkapenaIkusi.addActionListener(this);
        btnSaioaAmaitu.addActionListener(this);
    }

    public static void main(String[] args) {
        new MenuAdmin().setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==btnTaldesIkusi) {
			
		}
		
		if(o==btnJokalariakIkusi) {
			new JokalariakIkusi().setVisible(true);
			dispose();
		}
		
		if(o==btnJokalariakKudeatu) {
			new JokalariakKudeatu().setVisible(true);
			dispose();
		}
		
		if(o==btnJokalariakAldatu) {
			
		}
		
		if(o==btnSailkapenaIkusi) {
			new SailkapenaIkusi().setVisible(true);
			dispose();
		}

		if(o==btnSaioaAmaitu) {
			new Saioa_Hasi().setVisible(true);
			dispose();
		}		
	}
}