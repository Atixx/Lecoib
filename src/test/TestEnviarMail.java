package test;

import negocio.EnvioCorreo;



public class TestEnviarMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EnvioCorreo pruebaEnvio = new EnvioCorreo();
		
		try {
			pruebaEnvio.EnviarCorreo(1, "Probando Correo, asunto pred");
			pruebaEnvio.EnviarCorreo(1,"Hola!!", "Probando Correo c/asunto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
