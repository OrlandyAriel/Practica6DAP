package ull.patrones.singleton;

import java.util.HashMap;
import java.util.LinkedList;
import ull.patrones.clientes.DialogUsuario;

public class Mediador
{	
	private static Mediador m_mediador = new Mediador();
	private String m_sala;
	private static LinkedList<DialogUsuario> m_listaclientes;
	private static LinkedList<HashMap<String, String>> m_listaMensaje;
	private Mediador()
	{
		m_sala = "--Bienvenido al chat--";
		m_listaclientes = new LinkedList<>();
		m_listaMensaje =new LinkedList<>();
	}
	public static void suscribir(DialogUsuario a_user)
	{
		m_listaclientes.add(a_user);
	}
	public static Mediador getInstancia()
	{
		return m_mediador;
	}
	public void enviar(String mensaje, String usuario)
	{
		HashMap<String, String> a= new HashMap<>();
		a.put("nomUser", usuario);
		a.put("mensajaDe"+usuario, mensaje);
		m_listaMensaje.add(a);
		construirSala();
		notificar();
	}
	public void notificar()
	{
		for (int i = 0; i < m_listaclientes.size(); i++)
		{
			m_listaclientes.get(i).setearPantalla(m_sala);
		}
	}
	public String sala()
	{
		return m_sala;
	}
	private void construirSala()
	{
		m_sala="--Bienvenido al chat--";
		for (int i = 0; i < m_listaMensaje.size(); i++)
		{
			HashMap<String, String> aux = m_listaMensaje.get(i);
			String nomb = aux.get("nomUser");
			m_sala +="\n"+nomb+":"+aux.get("mensajaDe"+nomb);
		}
		System.err.println(m_sala);
	}
}
