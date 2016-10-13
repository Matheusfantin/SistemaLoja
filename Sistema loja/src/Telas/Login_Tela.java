package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco.Validar_Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_Tela extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtsenha;
	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	private String adm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Tela frame = new Login_Tela();
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
	public Login_Tela() {
		setTitle("DMM Sistemas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(41, 99, 343, 128);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio :");
		lblUsuario.setBounds(65, 25, 69, 28);
		panel.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(65, 64, 72, 28);
		panel.add(lblSenha);

		txtusuario = new JTextField();
		txtusuario.setBounds(128, 27, 194, 24);
		panel.add(txtusuario);
		txtusuario.setColumns(10);

		txtsenha = new JPasswordField();
		
		
		txtsenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()== KeyEvent.VK_ENTER){
					
					try {

						Validar_Usuario user = new Validar_Usuario();

						if(txtusuario.getText().equals("")||txtsenha.getText().equals("") ){

							JOptionPane.showMessageDialog(null, "digite um usuario e uma senha válida ");
							txtusuario.requestFocus();				
						}

						else if (user.validar(txtusuario.getText(),txtsenha.getText())){
							
							JOptionPane.showMessageDialog(null, "logado om sucesso  ");
							txtusuario.requestFocus();	
							
							fechar();
	                     
	                      
						}
						
						else {
							JOptionPane.showMessageDialog(null, "digite um usuario e uma senha válida ");
							txtusuario.requestFocus();	
							txtusuario.setText("");
							txtsenha.setText("");
							txtusuario.requestFocus();
						}
					} catch (Exception  e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
		});
		txtsenha.setBounds(128, 66, 194, 24);
		panel.add(txtsenha);

		JButton btnentrar = new JButton("Entrar");
		btnentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Validar_Usuario user = new Validar_Usuario();

					if(txtusuario.getText().equals("")||txtsenha.getText().equals("") ){

						JOptionPane.showMessageDialog(null, "digite um usuario e uma senha válida ");
						txtusuario.requestFocus();		
							
					}

					else if (user.validar(txtusuario.getText(),txtsenha.getText())){
						
						JOptionPane.showMessageDialog(null, "logado om sucesso  ");
						txtusuario.requestFocus();	
						fechar();
						
						Principal frame = new Principal();
						frame.setVisible(true);
                      
					}
					
					else {
						JOptionPane.showMessageDialog(null, "digite um usuario e uma senha válida ");
						txtusuario.requestFocus();	
						txtusuario.setText("");
						txtsenha.setText("");
						txtusuario.requestFocus();
					}
				} catch (Exception  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
		btnentrar.setBounds(168, 238, 89, 23);
		contentPane.add(btnentrar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		btnFechar.setBounds(278, 238, 89, 23);
		contentPane.add(btnFechar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login_Tela.class.getResource("/img/chave1.png")));
		lblNewLabel.setBounds(156, -14, 143, 109);
		contentPane.add(lblNewLabel);
		
		
	}
	public void fechar (){
		this.setVisible(false);
		
	}
}
