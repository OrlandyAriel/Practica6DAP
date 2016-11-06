package ull.patrones.mediador;

import java.util.LinkedList;
/**
 * Clase mediadora entre los, posiblemente distintos, usuarios 
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class Mediador implements IMediador
{//Atributos
	private String m_nombreSala;
	private String m_mensajesSala;
	private LinkedList<ICliente> m_listaClientes;
	/**
	 * Constructor que da nombre de la sala
	 * @param a_nombreSala, nombre que se le asinará a la sala
	 */
	public Mediador(String a_nombreSala)
	{
		m_nombreSala = a_nombreSala;
		m_mensajesSala = "--Bienvenido a la sala de chat  "+m_nombreSala+"--";
		m_listaClientes = new LinkedList<>();
	}
	/**
	 * Este método cambia el valor del mensaje, no nos interesa que se pueda
	 * acceder desde fuera a no ser que sea con el método enviarMensaje
	 * @param a_mensaje
	 */
	private void setMensaje(String a_mensaje)
	{
		m_mensajesSala += a_mensaje;
	}
	public String getMensajes()
	{
		return m_mensajesSala;
	}
	@Override
	public void difundirMensajes()
	{
		for (ICliente iCliente : m_listaClientes)
		{
			iCliente.recibirMensajes(m_mensajesSala);
		}
	}
	@Override
	public void enviarMensaje(String a_mensaje, ICliente a_usuario)
	{
		setMensaje("\n"+a_usuario+":"+a_mensaje);
		difundirMensajes();
	}
	@Override
	public void registarUsuario(ICliente a_usuario)
	{
		m_listaClientes.add(a_usuario);
	}

}
