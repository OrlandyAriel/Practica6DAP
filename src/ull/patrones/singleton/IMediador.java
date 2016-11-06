package ull.patrones.singleton;

import ull.patrones.mediador.ICliente;

public interface IMediador
{
	public void difundirMensajes();
	public void enviarMensaje(String a_mensaje, ICliente a_usuario);
	public void registarUsuario(ICliente a_usuario);
}
