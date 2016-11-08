package ull.patrones;

import ull.patrones.form.VentanaPrincipal;
import ull.patrones.mediador.Mediador;
import ull.patrones.mediador.Usuario;
/**
 * Clase main de donde se permite lanzar la aplicación
 * @author Orlandy Ariel Sánchez A.
 */
public class Practica6DAP
{
	public static void main(String[] args)
	{
		new VentanaPrincipal();
		/*Mediador t_med = new Mediador("Patrones");
		new Usuario("Landy",t_med);
		new Usuario("Ariel",t_med);
		new Usuario("Ana", t_med);
		Mediador t_med1 = new Mediador("Patrones");
		new Usuario("LL",t_med1);
		new Usuario("AA",t_med1);*/
	}
}