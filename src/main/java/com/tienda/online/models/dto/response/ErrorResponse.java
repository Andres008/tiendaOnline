package com.tienda.online.models.dto.response;

public class ErrorResponse {

	private String mensaje;
	private Integer codigo;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String mensaje, Integer codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
