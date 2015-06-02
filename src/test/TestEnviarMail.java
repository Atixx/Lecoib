package test;

import negocio.EnvioCorreo;



public class TestEnviarMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EnvioCorreo pruebaEnvio = new EnvioCorreo();
		
		try {
			pruebaEnvio.EnviarCorreo(1, "Probando");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
