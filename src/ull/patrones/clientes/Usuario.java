package ull.patrones.clientes;

import ull.patrones.singleton.Mediador;

public class Usuario
{
	private String m_nombre;
	
	public Usuario(String a_nombre)
	{
		m_nombre = a_nombre;
	}
	public void enviarMensaje(String a_mensaje, Usuario a_usuario)
	{
		Mediador.enviar(a_mensaje,a_usuario);
	}
	public void recibir(String a_mensaje, Usuario de_usuario)
	{
		System.out.println(de_usuario.getM_nombre()+" dice:"+a_mensaje);
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
