package ull.patrones.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ull.patrones.mediador.ICliente;

public class DChat extends JDialog
{
	private ICliente m_cliente;
	private JTextArea m_mensajes;
	private JTextField m_jt_mensaje;
	private JButton m_btnEnviar;
	private JPanel m_panelBajo;
	public DChat(ICliente a_cliente)
	{
		m_cliente = a_cliente;
		initComponent();
	}

	private void initComponent()
	{
		setLayout(new BorderLayout());
		setTitle(m_cliente.getNombre());
		setSize(400,400);
		setVisible(true);
		initArea();
		panelBajo();
		this.add(m_mensajes,BorderLayout.CENTER);
		this.add(m_panelBajo, BorderLayout.SOUTH);
	}
	private void initArea()
	{
		m_mensajes = new JTextArea();
		m_mensajes.setText("");
		m_mensajes.setVisible(true);
		m_mensajes.setEditable(false);
		m_mensajes.setBackground(SystemColor.desktop);
		m_mensajes.setForeground(SystemColor.text);
		m_mensajes.setFont(new Font("Consolas", Font.PLAIN, 12));
	}
	private void panelBajo()
	{
		m_panelBajo = new JPanel();
		m_panelBajo.setLayout(new FlowLayout());
		
		m_jt_mensaje = new JTextField();
		m_jt_mensaje.setVisible(true);
		m_jt_mensaje.setColumns(20);
		
		m_btnEnviar = new JButton("Enviar");
		m_btnEnviar.setVisible(true);
		m_btnEnviar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				btnActionPerformed();
			}
		});
		m_panelBajo.add(m_jt_mensaje);
		m_panelBajo.add(m_btnEnviar);
		
	}
	private void btnActionPerformed()
	{
		m_cliente.enviarMensaje(m_jt_mensaje.getText());
		m_jt_mensaje.setText("");
	}
	public void verMensajes(String a_mensaje)
	{
		m_mensajes.setText(a_mensaje);
	}
	
}
