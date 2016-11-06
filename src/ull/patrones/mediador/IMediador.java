package ull.patrones.mediador;
/**
 * Interfaz mediador
 * @author Orlandy Ariel S�nchez A.
 *
 */
public interface IMediador
{
	/**
	 * M�todo que permite difuncir los mensajes nuevos que hayan en la sala
	 */
	public void difundirMensajes();
	/**
	 * M�todo que permite a los distintos participantes enviar mensajes
	 * @param a_mensaje, mensaje que se desea enviar
	 * @param a_usuario, usuario que envia en mensaje
	 */
	public void enviarMensaje(String a_mensaje, ICliente a_usuario);
	/**
	 * M�todo que registra a los usuarios en la sala de chat
	 * @param a_usuario, usuario que se desea registrar
	 */
	public void registarUsuario(ICliente a_usuario);
}
