package ull.patrones.clientes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ull.patrones.singleton.Sujeto;

import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogUsuario extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_mensaje;
	private Usuario m_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		DialogUsuario dialog = new DialogUsuario(new Usuario("Landy"));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		DialogUsuario dods = new DialogUsuario(new Usuario("Pepita"));
		dods.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dods.setVisible(true);
		Sujeto.suscribir(dods);
		Sujeto.suscribir(dialog);
	}

	private TextArea txtMensajes;

	/**
	 * Create the dialog.
	 */
	public DialogUsuario(Usuario a_usuario)
	{
		m_usuario = a_usuario;
		setTitle(m_usuario.getM_nombre());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtMensajes = new TextArea();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{

			txtMensajes.setBackground(SystemColor.desktop);
			txtMensajes.setText("--Bienvenido al chat--");
			txtMensajes.setForeground(SystemColor.text);
			txtMensajes.setFont(new Font("Consolas", Font.PLAIN, 12));
			txtMensajes.setEditable(false);
			contentPanel.add(txtMensajes);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				txt_mensaje = new JTextField();
				buttonPane.add(txt_mensaje);
				txt_mensaje.setColumns(30);
			}
			{
				JButton btn_envair = new JButton("Enviar");
				btn_envair.addActionListener(
						new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								m_usuario.enviarMensaje(txt_mensaje.getText(), a_usuario);
								Sujeto a = Sujeto.getInstancia();
								setearPantalla(a.sala());
								txt_mensaje.setText("");
							}
						}
				);
				btn_envair.setActionCommand("Cancel");
				buttonPane.add(btn_envair);
			}
		}
	}

	public void setearPantalla(String a_mensajes)
	{
		txtMensajes.setText(a_mensajes);
	}

}
