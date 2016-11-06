package ull.patrones;

import ull.patrones.mediador.Usuario;
import ull.patrones.singleton.Mediador;

public class Practica6DAP
{

	public static void main(String[] args)
	{
		Mediador t_med = new Mediador("Patrones");
		new Usuario("Landy",t_med);
		new Usuario("Ariel",t_med);
		new Usuario("Ana", t_med);
	}
}
