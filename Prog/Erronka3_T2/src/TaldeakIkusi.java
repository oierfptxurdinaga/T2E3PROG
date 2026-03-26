import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ErabiltzaileaDAO;
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

public class TaldeakIkusi extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnItzuli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Taldeak-Ikusi");
		
		JLabel lblNewLabel = new JLabel("Taldeak Ikusi");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 10, 246, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblMoraza = new JLabel("");
		lblMoraza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoraza.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\moraza-removebg-preview.png"));
		lblMoraza.setBounds(10, 97, 140, 113);
		contentPane.add(lblMoraza);
		
		JLabel lblMerced = new JLabel("");
		lblMerced.setHorizontalAlignment(SwingConstants.CENTER);
		lblMerced.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\merced (6).png"));
		lblMerced.setBounds(10, 278, 140, 113);
		contentPane.add(lblMerced);
		
		JLabel lblBaskonia = new JLabel("");
		lblBaskonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaskonia.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\basconia.png"));
		lblBaskonia.setBounds(236, 93, 155, 135);
		contentPane.add(lblBaskonia);
		
		JLabel lblSantutxu = new JLabel("");
		lblSantutxu.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\santutxu.png"));
		lblSantutxu.setBounds(266, 278, 140, 113);
		contentPane.add(lblSantutxu);
		
		JLabel lblUmore = new JLabel("");
		lblUmore.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\umore ona_resized (1) (1) (1).png"));
		lblUmore.setBounds(501, 93, 121, 135);
		contentPane.add(lblUmore);
		
		JLabel lblAriz = new JLabel("");
		lblAriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblAriz.setIcon(new ImageIcon("C:\\Users\\782874H\\Downloads\\iloveimg-resized\\ariz.png"));
		lblAriz.setBounds(494, 278, 140, 113);
		contentPane.add(lblAriz);
		
		btnItzuli = new JButton("Itzuli");
		btnItzuli.setForeground(new Color(255, 255, 255));
		btnItzuli.setBackground(new Color(255, 0, 0));
		btnItzuli.setFont(new Font("Arial", Font.BOLD, 34));
		btnItzuli.setBounds(266, 19, 140, 40);
		contentPane.add(btnItzuli);

		btnItzuli.addActionListener(this);
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

