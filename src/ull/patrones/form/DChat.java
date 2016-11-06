package ull.patrones.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ull.patrones.mediador.ICliente;

public class DChat extends JDialog
{

	private final JPanel m_panelArriba = new JPanel();
	private JTextField m_txtEnviar;
	private JButton m_btnEnviar;
	private ICliente m_cliente;
	private JPanel m_panelBajo;
	private TextArea m_txtMensajesChat;

	public DChat(ICliente a_cliente)
	{
		m_cliente = a_cliente;
		initComponent();
	}

	private void initComponent()
	{

		setTitle(m_cliente.getNombre());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		
		initPanelArriba();
		initPanelBajo();
		getContentPane().add(m_panelBajo, BorderLayout.SOUTH);
		getContentPane().add(m_panelArriba, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	private void initPanelArriba()
	{
		m_panelArriba.setLayout(new FlowLayout());
		m_panelArriba.setBorder(new EmptyBorder(5, 5, 5, 5));
		m_txtMensajesChat = new TextArea();

		m_txtMensajesChat.setBackground(SystemColor.desktop);
		m_txtMensajesChat.setForeground(SystemColor.text);
		m_txtMensajesChat.setFont(new Font("Consolas", Font.PLAIN, 12));
		m_txtMensajesChat.setEditable(false);
		m_panelArriba.add(m_txtMensajesChat);
	}
	private void initPanelBajo()
	{
		m_panelBajo = new JPanel();
		m_panelBajo.setLayout(new FlowLayout());
		
		m_txtEnviar = new JTextField();
		m_txtEnviar.setColumns(31);

		m_btnEnviar = new JButton("Enviar");
		m_btnEnviar.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					btnEnviarActionPerformed();
				}
			}
		);
		m_panelBajo.add(m_txtEnviar);
		m_panelBajo.add(m_btnEnviar);
		
	}
	private void btnEnviarActionPerformed()
	{
		m_cliente.enviarMensaje(m_txtEnviar.getText());
		m_txtEnviar.setText("");
	}

	public void verMensajes(String a_mensajes)
	{
		m_txtMensajesChat.setText(a_mensajes);
	}
}