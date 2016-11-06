package ull.patrones.singleton;

import ull.patrones.clientes.Usuario;

public class Mediador
{	
	private static Mediador m_mediador = new Mediador();
	private Mediador()
	{
		
	}
	public static Mediador getInstancia()
	{
		return m_mediador;
	}
	public static void enviar(String mensaje, Usuario usuario)
	{
		usuario.recibir(mensaje, usuario);
	}
}
