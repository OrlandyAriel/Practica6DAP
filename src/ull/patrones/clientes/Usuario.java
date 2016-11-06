package ull.patrones.clientes;

import ull.patrones.singleton.Sujeto;

public class Usuario
{
	private String m_nombre;
	private Sujeto m_medi;
	public Usuario(String a_nombre)
	{
		m_nombre = a_nombre;
		m_medi = Sujeto.getInstancia();
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
