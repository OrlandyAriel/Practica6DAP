package ull.patrones.mediador;
/**
 * Interfaz que para reprentar los posibles clientes/usuarios
 * @author Orlandy Ariel S�nchez A.
 *
 */
public interface ICliente
{
	/**
	 * Permite al cliente ver los mensajes que hay en la sala
	 * @param a_mensajes
	 */
	public void recibirMensajes(String a_mensajes);
	/**
	 * M�todo que permite enviar un mensaje a la sala
	 * @param a_mensaje
	 */
	public void enviarMensaje(String a_mensaje);
	public String getNombre();
}
