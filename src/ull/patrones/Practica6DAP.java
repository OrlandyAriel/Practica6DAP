package ull.patrones;

import ull.patrones.clientes.Usuario;

public class Practica6DAP
{

	public static void main(String[] args)
	{
		Usuario a= new Usuario("landy");
		Usuario c = new Usuario("laura");
		a.enviarMensaje("hola y tu", c);
		c.enviarMensaje("bien y tu", a);
	}

}
