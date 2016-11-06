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
/**
 * Clase que representa la ventana de cada usuario, donde este puede interactuar en la sala
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class DChat extends JDialog
{//Atributos
	private final JPanel m_panelArriba = new JPanel();
	private JTextField m_txtEnviar;
	private JButton m_btnEnviar;
	private ICliente m_cliente;
	private JPanel m_panelBajo;
	private TextArea m_txtMensajesChat;
	/**
	 *Construstor que recibe un cliente/usuario para crear una ventana para este.
	 * @param a_cliente, usuario para el cual se crea la ventana
	 */
	public DChat(ICliente a_cliente)
	{
		m_cliente = a_cliente;
		initComponent();
	}
	/**
	 * Método para iniizalizar los distintos componentes de la ventana
	 */
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
	/**
	 * Método que permite inicizliar el componente donde se visualiazarnan los mensajes.
	 */
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
	/**
	 * Método que permitne inicializar los componentes con los que el usuario
	 * interactuará con la sala
	 */
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
	/**
	 * Método para realizar una accion cuando se hace click en el botón enviar
	 */
	private void btnEnviarActionPerformed()
	{
		m_cliente.enviarMensaje(m_txtEnviar.getText());
		m_txtEnviar.setText("");
	}
	/**
	 * Actualiza los mensajes de la sala
	 * @param a_mensajes
	 */
	public void actualizaDisplay(String a_mensajes)
	{
		m_txtMensajesChat.setText(a_mensajes);
	}
}