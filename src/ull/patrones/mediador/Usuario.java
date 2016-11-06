package ull.patrones.mediador;

import ull.patrones.form.DChat;
/**
 * Clase que representa a un usuario.
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class Usuario implements ICliente
{// Atributos
	private String m_nombre;
	private IMediador m_mediador;
	private DChat m_display;
	//Constructor/es y Funciones
	/**
	 * Construcor por defecto al cual requiere saber a que "sala"quiere pertenecer.
	 * @param a_nombre, Nombre del usuario, este aparecerá en el mensaje cuando se envie
	 * @param a_mediador, la clase medidador representa la sala 
	 */
	public Usuario(String a_nombre, IMediador a_mediador)
	{
		m_nombre = a_nombre;
		m_mediador = a_mediador;
		m_mediador.registarUsuario(this);
		m_display = new DChat(this);
		
	}
	@Override
	public String getNombre()
	{
		return m_nombre;
	}
	@Override
	public void recibirMensajes(String a_mensajes)
	{
		display(a_mensajes);
	}
	@Override
	public void enviarMensaje(String a_mensaje)
	{
		m_mediador.enviarMensaje(a_mensaje, this);
	}
	/**
	 * método que permite mostrar la ventana con los distintos mensajes
	 * que se envien a la sala.
	 * @param a_mensajes, mensaje que se recogen de la sala de chat (clase mediador)
	 */
	private void display(String a_mensajes)
	{
		m_display.actualizaDisplay(a_mensajes);//se actualiza el display cuando se recibe un nuevo mensaje. 
	}
	@Override
	public String toString()
	{
		return "["+m_nombre+"]";
	}
}
