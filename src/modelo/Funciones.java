package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Funciones
{
	public static int traerAnio(GregorianCalendar c)
	{
		return c.get(Calendar.YEAR);
	}
	
	public static int traerMes(GregorianCalendar c)
	{
		return c.get(Calendar.MONTH)+1;
	}
	
	public static int traerDia(GregorianCalendar c)
	{
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia)
	{
		GregorianCalendar c = new GregorianCalendar(anio, mes-1, dia);
		return c;
	}
	
	public static GregorianCalendar traerFecha(String fecha)
	{
		String[] j= fecha.split("/");
		int dia = Integer.parseInt(j[0]);
		int mes = Integer.parseInt(j[1]);
		int anio = Integer.parseInt(j[2]);
		GregorianCalendar c = new GregorianCalendar(anio, mes-1, dia);
		return c;
	}
	
	public static String traerFechaCorta(GregorianCalendar c)
	{
		String mostrar = "";
		if (traerDia(c) < 10)
		{
			mostrar += "0" + traerDia(c)+"/";
		}
		else
		{
			mostrar += traerDia(c)+"/";
		}
		if (traerMes(c) < 10)
		{
			mostrar += "0" + traerMes(c)+"/";
		}
		else
		{
			mostrar += traerMes(c)+"/";
		}
		mostrar += traerAnio(c);
		return mostrar;
	}
	
	public static String traerFechaHQL(GregorianCalendar c)
	{
		String mostrar = "";
		mostrar += traerAnio(c)+"/";
		if (traerMes(c) < 10)
		{
			mostrar += "0" + traerMes(c)+"/";
		}
		else
		{
			mostrar += traerMes(c)+"/";
		}
		if (traerDia(c) < 10)
		{
			mostrar += "0" + traerDia(c);
		}
		else
		{
			mostrar += traerDia(c);
		}
		return mostrar;
	}
	
	public static String traerFechaCorta()
	{
		return traerFechaCorta(new GregorianCalendar());
	}
	
	
	public static boolean esBisiesto(int anio)
	{
		return ( (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)) );
	}
	
	public static int traerCantDiasDeUnMes(int mes, int anio)
	{
		int a = -1;
		switch (mes)
		{
		case 1: case 3: case 5: 
		case 7: case 8: case 10:
		case 12:
			a = 31;
			break;
		case 2:
		    if (esBisiesto(anio))
		    {
		    	a = 29;
		    	break;
		    }
		    else
		    {
		    	a = 28;
		    	break;
		    }
		case 4: case 6:
		case 9: case 11:
			a = 30;
			break;
		}
	 return a;
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia)
	{
		boolean valido = true;
		if ( (anio < 1) || (mes < 1 || mes > 12) || (dia < 1 || dia > traerCantDiasDeUnMes(mes, anio)) )
		{
			valido = false;
		}
		
		return valido;
	}
	
	//Utiliza feriados.xml con el anio mes y dia del mismo
	public static boolean esFeriado(GregorianCalendar c)
	{     
	    boolean retval = false;
        try 
        {
            File dirBase = new File("src/modelo/feriados.xml");
         
            String ruta = dirBase.getAbsolutePath();
            
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            
            String entrada;
            String cadena = "";
            
            while ((entrada = br.readLine()) != null)
                cadena += entrada;
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            InputSource archivo = new InputSource();
            archivo.setCharacterStream(new StringReader(cadena));
            
            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();
     
            NodeList nodeLista = documento.getElementsByTagName("feriado");
            
            String[] tags = {"anio","mes","dia"};
            
            for (int s = 0; s < nodeLista.getLength(); s++) 
            {
            
                Node nodo = nodeLista.item(s);
                String[] valores = new String[tags.length];            
                if (nodo.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element elemento = (Element) nodo;
                    for (int i = 0; i < tags.length; i++) 
                    {
                        NodeList nombreElementoLista = elemento.getElementsByTagName(tags[i]);
                        Element nombreElemento = (Element) nombreElementoLista.item(0);
                        NodeList nombre = nombreElemento.getChildNodes();
                        valores[i] = ((Node) nombre.item(0)).getNodeValue().toString();
                    }
                    
                    int anio = Integer.parseInt(valores[0]);
                    int mes = Integer.parseInt(valores[1]);
                    int dia = Integer.parseInt(valores[2]);

                    GregorianCalendar f = traerFecha(anio, mes, dia);
                    
                    if (sonFechasIguales(c, f))
                    {
                        retval = true;
                    }
                }
            } 
            br.close();
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
	    return retval;
	}

	public static boolean esDiaHabil(GregorianCalendar c)
	{
	    if (esFeriado(c))
	        return false;
	    else
		return (c.get(Calendar.DAY_OF_WEEK)>1) && (c.get(Calendar.DAY_OF_WEEK)<7);	
	}
	
	
	public static String traerDiaDeLaSemana(GregorianCalendar c)
	{
		String dia = "";
		switch(c.get(Calendar.DAY_OF_WEEK))
		{
			case 1:
				dia="Domingo";
				break;
			case 2:
				dia="Lunes";
				break;
			case 3:
				dia="Martes";
				break;
			case 4:
				dia="Miercoles";
				break;
			case 5:
				dia="Jueves";
				break;
			case 6:
				dia="Viernes";
				break;
			case 7:
				dia="Sabado";
				break;
		}
		return dia;
	}
	
	public static String traerMesEnLetras(GregorianCalendar c)
	{
		String mes = "";
		switch(c.get(Calendar.MONTH))
		{
			case 0:
				mes="Enero";
				break;
			case 1:
				mes="Febrero";
				break;
			case 2:
				mes="Marzo";
				break;
			case 3:
				mes="Abril";
				break;
			case 4:
				mes="Mayo";
				break;
			case 5:
				mes="Junio";
				break;
			case 6:
				mes="Julio";
				break;
			case 7:
				mes="Agosto";
				break;
			case 8:
				mes="Septiembre";
				break;
			case 9:
				mes="Octubre";
				break;
			case 10:
				mes="Noviembre";
				break;
			case 11:
				mes="Diciembre";
				break;
		}
		return mes;
	}
	
	public static String traerFechaLarga(GregorianCalendar c)
	{
		String fecha = traerDiaDeLaSemana(c) + ", "+ traerDia(c) + " de " + traerMesEnLetras(c) + " de " + traerAnio(c);
		return fecha;
	}
	
	public static boolean sonFechasIguales(GregorianCalendar c, GregorianCalendar d)
	{
		return ( (traerDia(c) == traerDia(d)) && (traerMes(c) == traerMes(d)) && (traerAnio(c) == traerAnio(d)) );
	}
	
	public static boolean esFechaFutura(GregorianCalendar c)
	{
		GregorianCalendar hoy = new GregorianCalendar();
		//GregorianCalendar hoy = Funciones.traerFecha("30/05/2015");
		boolean es = true;
		if ( traerAnio(c)==traerAnio(hoy)){
			if(traerMes(c)==traerMes(hoy)){
				if(traerDia(c)==traerDia(hoy)){//si Anio, mes y dia son iguales
					es = false;
				}
				else if(traerDia(c)<traerDia(hoy)){//si Anio y mes son iguales, pero diacC < diaHoy
					es = false;
				}
				//sino diaC > diaHoy es futura
			}
			else if(traerMes(c)<traerMes(hoy)){
				es = false;
			}
			//sino mesC > mesHoy es futura
		}
		else if(traerAnio(c)<traerAnio(hoy)){
			es = false;
		}
		return es;
	}
	
	public static GregorianCalendar primerDiaHabil(GregorianCalendar input)
	{
	    while(!esDiaHabil(input))
	    {
	        int dia = traerDia(input);
	        int mes = traerMes(input);
	        int anio = traerAnio(input);
	        if (traerCantDiasDeUnMes(mes, anio) == dia)
	        {
	            dia = 1;
	            if (mes == 12)
	            {
	                mes = 1;
	                anio++;
	            }
	            else
	                mes++;
	        }
	        else
	        {
	            dia++;
	        }
	        input = traerFecha(anio,mes,dia);
	    }
	    return input;
	}
	
	public static GregorianCalendar sumarUnMes(GregorianCalendar input)
	{
	    int anio, mes, dia;
	    anio = traerAnio(input);
	    mes = traerMes(input);
	    dia = traerDia(input);
	    mes += 1;
	    if (traerCantDiasDeUnMes(mes, anio) < dia)
	    {
	        dia -= traerCantDiasDeUnMes(mes, anio);
	    }
	    if (mes > 12)
	    {
	        anio++;
	        mes = 1;
	    }
	    GregorianCalendar cal = traerFecha(anio, mes, dia);
        return cal;
	}
	
	//Aca terminan las fechas
	
	public static boolean esCaracter(char muestra)
	{
		boolean bandera = true;
		
		if ( !(((int)muestra >= 65 &&(int)muestra <= 90) || ((int)muestra >= 97 && (int)muestra<= 122)))
		{
			bandera = false;
		}
		
		return bandera;
	}
	
	public static boolean esCaracter(String muestra)
	{
		boolean bandera = true;
		int contador = 0;
		if (muestra.length() == 0)
		{
			bandera = false;
		}
		for (int i = 0; i < muestra.length(); i++)
		{
			if ( !esCaracter(muestra.charAt(i)))
			{
				contador++;
			}
		}
		if (contador > 0)
		{
			bandera = false;
		}
		
		return bandera;
	}
	
	public static boolean esNumero(char muestra)
	{
		boolean bandera = true;
		if ( !((int)muestra >= 48 && (int)muestra <= 57 ))
		{
			bandera = false;
		}
		return bandera;
	}
	
	public static boolean esNumero(String muestra)
	{
		boolean bandera = true;
		int contador = 0;
		if (muestra.length() == 0)
		{
			bandera = false;
		}
		for (int i = 0; i < muestra.length(); i++)
		{
			if ( !(esNumero(muestra.charAt(i))))
			{
				contador++;
			}

		}
		if (contador > 0)
		{
			bandera = false;
		}
		
		return bandera;
	}
	
	public static double convertirADouble (int n)
	{
		return Double.parseDouble(String.valueOf(n));
	}
	
	
	public static double aproximar2Decimal(double num)
	{
        num += 0.005;
        num *= 100;
        String[] partes = String.valueOf(num).split("\\.");
        num = Double.parseDouble(partes[0]);
        return num /100;
    }
	
	public static int obtenerUltimoDigito(int numero){
		while(numero>=10) numero -= 10;
		return numero;
	}
	
	public static String traerFechaHoraLarga(GregorianCalendar fechaHoraGC){
		String fechaEntera = fechaHoraGC.get(Calendar.DAY_OF_MONTH)+  "/" +fechaHoraGC.get(Calendar.MONTH)+ "/" +fechaHoraGC.get(Calendar.YEAR)+ " " +fechaHoraGC.get(Calendar.HOUR_OF_DAY)+ ":" +fechaHoraGC.get(Calendar.MINUTE);
		String[] fecha = fechaEntera.split("/");
		String[] auxDiaHoraMin = fecha[2].split(" ");
		fecha[2] = auxDiaHoraMin[0];
		String[] auxHoraMin = auxDiaHoraMin[1].split(":");
		String hora = auxHoraMin[0];
		if(hora.length()==1) hora = '0'+hora;
		String minutos = auxHoraMin[1];
		if(minutos.length()==1) minutos = '0'+minutos;
		return traerDiaSemana(fechaHoraGC)+ ", " +fecha[0]+ " de " +traerMesEnLetras(fechaHoraGC)+ " de " +fecha[2]+ " - " +hora+ ":" +minutos;
	}

	public static String traerDiaSemana(GregorianCalendar fecha){
		String diaS;
		switch(fecha.get(Calendar.DAY_OF_WEEK))
		{
			case 1:
				diaS = "Domingo";
				break;
			case 2:
				diaS = "Lunes";
				break;
			case 3:
				diaS = "Martes";
				break;
			case 4:
				diaS = "Miercoles";
				break;
			case 5:
				diaS = "Jueves";
				break;
			case 6:
				diaS = "Viernes";
				break;
			case 7:
				diaS = "Sabado";
				break;
			default:
				diaS = "Error";
				break;
		}
		return diaS;
	}
	
	public static GregorianCalendar traerFechaHora(String fechaS){
		String[] fecha = fechaS.split("/");
		String[] auxDiaHoraMin = fecha[2].split(" ");
		fecha[2] = auxDiaHoraMin[0];
		String[] auxHoraMin = auxDiaHoraMin[1].split(":");
		String hora = auxHoraMin[0];
		String minutos = auxHoraMin[1];
		GregorianCalendar fechaHoraGC = new GregorianCalendar (Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1])-1, Integer.parseInt(fecha[0]), Integer.parseInt(hora),Integer.parseInt(minutos));
		return fechaHoraGC;
	}


	public static String pasarBooleanAString(String bool)
	{
		String entradaSalida = "";
		if(bool=="0") entradaSalida = "Entrada";
		else entradaSalida = "Salida";
		return entradaSalida;
	}
	
}