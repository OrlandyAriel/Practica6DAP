package ull.patrones.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ull.patrones.mediador.IMediador;
import ull.patrones.mediador.Mediador;
import ull.patrones.mediador.Usuario;

/**
 * Ventana principal de la aplicación
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class VentanaPrincipal extends JFrame
{
	private JPanel m_Panel;
	private JTextField m_tfNombre;
	private JLabel m_jlNombre;
	private JButton m_btnRegistrarUsuario;
	private IMediador mediador;
	/**
	 * constructro por defecto.
	 */
	public VentanaPrincipal()
	{
		configFrame();
	}
	/**
	 * Metodo que configura la ventana
	 */
	private void configFrame()
	{
		mediador = new Mediador("Patrones");
		initPanelComponent();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		setVisible(true);
		setTitle("Sala de Chat");
		this.add(m_Panel);
	}
	/**
	 * Crea los componentes del panel
	 */
	private void initPanelComponent()
	{
		m_Panel = new JPanel();
		m_Panel.setVisible(true);

		m_tfNombre = new JTextField();
		m_tfNombre.setVisible(true);
		m_tfNombre.setColumns(10);
		
		m_jlNombre = new JLabel("Nombre de usuario:");
		m_jlNombre.setVisible(true);
		
		m_btnRegistrarUsuario = new JButton("Registar usuario");
		m_btnRegistrarUsuario.setVisible(true);
		m_btnRegistrarUsuario.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				anadirUsuario();
			}
		});
		m_Panel.add(m_jlNombre);
		m_Panel.add(m_tfNombre);
		m_Panel.add(m_btnRegistrarUsuario);
	}
	/**
	 * Método que recoge el nombre del usuario para crearlo
	 */
	private void anadirUsuario()
	{
		if(!m_tfNombre.getText().isEmpty())// evita que si no se introduce un nombre no se cree el usuario dado que "" se considera string
		{
			new Usuario(m_tfNombre.getText(), mediador);
			m_tfNombre.setText("");
			m_tfNombre.setFocusable(true);
		}
	}
}
