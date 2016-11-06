package ull.patrones.singleton;

import java.util.LinkedList;

import ull.patrones.mediador.ICliente;

public class Mediador implements IMediador
{
	private String m_nombreSala;
	private String m_mensajesSala;
	private LinkedList<ICliente> m_listaClientes;
	public Mediador(String a_nombreSala)
	{
		m_nombreSala = a_nombreSala;
		m_mensajesSala = "--Bienvenido a la sala de chat "+m_nombreSala+"--";
		m_listaClientes = new LinkedList<>();
	}
	
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
		setMensaje("\n"+"["+a_usuario.getNombre()+"]:"+a_mensaje);
		difundirMensajes();
	}
	@Override
	public void registarUsuario(ICliente a_usuario)
	{
		m_listaClientes.add(a_usuario);
	}

}
