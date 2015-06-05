package test;

import java.util.ArrayList;

import datos.Ficha;
import negocio.FichaABM;
import negocio.EmpleadoABM;
import java.util.List;
public class TestFichar {

	public static void main(String[] args) {
		try{
			Ficha f = new Ficha();
			long dni = 33333331;
			int codigoVerificador = 4;
			if(f.esCodigoValido(dni,codigoVerificador)){
				FichaABM fABM = new FichaABM();
				int idFicha = fABM.agregarFicha(dni, codigoVerificador);
				System.out.println(idFicha);
			}
			else{
				System.out.println("Error: El codigo verificador no coincide");
			}
			/*EmpleadoABM eABM = new EmpleadoABM();
			FichaABM fABM = new FichaABM();
			//System.out.println(fABM.traerFicha(1));
			long dni = 33333332;
			List<Ficha> lstF = new ArrayList<Ficha>();
			lstF=fABM.traerFichaEmpleado(dni);
			for(Ficha f : lstF){
				System.out.println(f);
			}*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
