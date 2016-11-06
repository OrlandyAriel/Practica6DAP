package ull.patrones.mediador;
/**
 * Interfaz mediador
 * @author Orlandy Ariel Sánchez A.
 *
 */
public interface IMediador
{
	/**
	 * Método que permite difuncir los mensajes nuevos que hayan en la sala
	 */
	public void difundirMensajes();
	/**
	 * Método que permite a los distintos participantes enviar mensajes
	 * @param a_mensaje, mensaje que se desea enviar
	 * @param a_usuario, usuario que envia en mensaje
	 */
	public void enviarMensaje(String a_mensaje, ICliente a_usuario);
	/**
	 * Método que registra a los usuarios en la sala de chat
	 * @param a_usuario, usuario que se desea registrar
	 */
	public void registarUsuario(ICliente a_usuario);
}
