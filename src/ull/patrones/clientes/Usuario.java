package ull.patrones.clientes;

import ull.patrones.singleton.Mediador;

public class Usuario
{
	private String m_nombre;
	private Mediador m_medi;
	public Usuario(String a_nombre)
	{
		m_nombre = a_nombre;
		m_medi = Mediador.getInstancia();
	}
	public void enviarMensaje(String a_mensaje, Usuario a_usuario)
	{
		m_medi.enviar(a_mensaje,a_usuario.getM_nombre());
	}
	public String getM_nombre()
	{
		return m_nombre;
	}
	public void setM_nombre(String m_nombre)
	{
		this.m_nombre = m_nombre;
	}
}
