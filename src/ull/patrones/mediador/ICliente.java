package ull.patrones.mediador;

public interface ICliente
{
	public void recibirMensajes(String a_mensajes);
	public void enviarMensaje(String a_mensaje);
	public String getNombre();
}
