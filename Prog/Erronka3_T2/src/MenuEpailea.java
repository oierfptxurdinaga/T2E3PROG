import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEpailea extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Componentes
    private JLabel lblTitulo;

    private JButton btnTaldeakIkusi;
    private JButton btnJokalariakIkusi;
    private JButton btnSailkapena;
    private JButton btnEmaitzakSartu;

    private JButton btnSaioaAmaitu;

    public MenuEpailea() {
        initComponents();
    }

    private void initComponents() {

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        // Título
        lblTitulo = new JLabel("MENU ARBITROA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitulo.setBounds(70, 30, 350, 50);

        // Botones
        btnTaldeakIkusi = new JButton("1. Taldeak ikusi");
        btnTaldeakIkusi.setBounds(100, 120, 250, 40);

        btnJokalariakIkusi = new JButton("2. Jokalariak ikusi");
        btnJokalariakIkusi.setBounds(100, 180, 250, 40);

        btnSailkapena = new JButton("3. Sailkapena");
        btnSailkapena.setBounds(100, 240, 250, 40);

        btnEmaitzakSartu = new JButton("4. Emaitzak sartu");
        btnEmaitzakSartu.setBounds(100, 300, 250, 40);

        // Botón salir
        btnSaioaAmaitu = new JButton("Saioa amaitu");
        btnSaioaAmaitu.setBounds(160, 370, 140, 40);
        btnSaioaAmaitu.setBackground(Color.RED);
        btnSaioaAmaitu.setForeground(Color.WHITE);

        // Añadir componentes
        panel.add(lblTitulo);
        panel.add(btnTaldeakIkusi);
        panel.add(btnJokalariakIkusi);
        panel.add(btnSailkapena);
        panel.add(btnEmaitzakSartu);
        panel.add(btnSaioaAmaitu);

        // Configuración del JFrame
        add(panel);
        setTitle("Menu Arbitroa");
        setSize(450, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Botoiei ActionEventak ipintzen diogu:
        btnTaldeakIkusi.addActionListener(this);
        btnJokalariakIkusi.addActionListener(this);
        btnSailkapena.addActionListener(this);
        btnEmaitzakSartu.addActionListener(this);
        btnSaioaAmaitu.addActionListener(this);
    }

    public static void main(String[] args) {
        new MenuEpailea().setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==btnTaldeakIkusi) {
			new TaldeakIkusi().setVisible(true);
			dispose();
		}
		
		if(o==btnJokalariakIkusi) {
			new JokalariakIkusi().setVisible(true);
			dispose();
		}
				
		if(o==btnSailkapena) {
			new SailkapenaIkusi().setVisible(true);
			dispose();
		}

		if(o==btnEmaitzakSartu) {
			new EmaitzakSartu().setVisible(true);
			dispose();
		}
		
		if(o==btnSaioaAmaitu) {
			new Saioa_Hasi().setVisible(true);
			dispose();
		}		
		
	}
}