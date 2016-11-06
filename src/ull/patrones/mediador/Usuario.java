package ull.patrones.mediador;

import ull.patrones.form.DChat;
import ull.patrones.singleton.IMediador;

public class Usuario implements ICliente
{
	private String m_nombre;
	private IMediador m_mediador;
	public Usuario(String a_nombre, IMediador a_mediador)
	{
		m_nombre = a_nombre;
		m_mediador = a_mediador;
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
	public void display(String a_mensajes)
	{
		DChat a = new DChat(this);
		a.verMensajes(a_mensajes);
	}
}
