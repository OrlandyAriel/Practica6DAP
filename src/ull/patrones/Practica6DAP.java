package ull.patrones;

import ull.patrones.mediador.Usuario;
import ull.patrones.singleton.Mediador;

public class Practica6DAP
{

	public static void main(String[] args)
	{
		Mediador t_med = new Mediador("Patrones");
		Usuario landy= new Usuario("landy",t_med);
		Usuario ariel = new Usuario("Ariel",t_med);
		t_med.registarUsuario(landy);
		t_med.registarUsuario(ariel);
		landy.enviarMensaje("hola");
		ariel.enviarMensaje("hola");
		t_med.difundirMensajes();
		
	}

}
