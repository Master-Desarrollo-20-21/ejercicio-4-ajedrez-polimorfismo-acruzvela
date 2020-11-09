package cruz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.sql.Date;
import java.util.GregorianCalendar;

public class Console {
        	///////////////////////////////////////////////// Metodos publicos
	
	public String inString ()
	{
		String entrada = null;
	try 
	{
		entrada = b.readLine();
	}
	catch (Exception e) 
	{		
		this.salir();		
	}
		return entrada;
	}	
	
	public String inString (String message)
	{
		String entrada = null;
		try 
		{
			System.out.print(message+" ");
			entrada = b.readLine();
		}
		catch (Exception e) 
		{		
			this.salir();		
		}
		return entrada;
	}	
	
	
	
	public int inInt ()
	{
		int entrada = 0;
		try
		{
			entrada = Integer.parseInt(this.inString());
		}
		catch (Exception e)
		{	
			this.salir();
		}
		return entrada;		
	}
	
	public int inInt(String message) {
		boolean correcto;
		int entrada = 0;
		do{
			correcto=true;
			try{
				System.out.print(message+" ");
				entrada = Integer.parseInt(this.inString());
			}
			catch (NumberFormatException e){
				correcto=false;
			}
		}while (!correcto);
		return entrada;
	
	}
	
	public float inFloat ()
	{
		float entrada = 0;
		try
		{
			entrada = Float.parseFloat(this.inString());
		}
		catch (Exception e)
		{	
			this.salir();
		}
		return entrada;		
	}	
	
	public float inFloat (String message) {
		boolean correcto;
		float entrada=0f;
		do{
			correcto=true;
			try{
				System.out.print(message+" ");
				entrada = Float.parseFloat(this.inString());
				if (entrada==Float.NEGATIVE_INFINITY || entrada==Float.POSITIVE_INFINITY)
					correcto=false;
			}
			catch (NumberFormatException e){
				correcto=false;
			}
		}while (!correcto);
		return entrada;
	
	}
	
	public double inDouble ()
	{
		double entrada = 0.0;
		try
		{
			entrada = Double.parseDouble(this.inString());
		}
		catch (Exception e)
		{	
			this.salir();
		}
		return entrada;		
	}
	
	public double inDouble (String message) {
		boolean correcto;
		double entrada=0d;
		do{
			correcto=true;
			try{
				System.out.print(message+" ");
				entrada = Double.parseDouble(this.inString());
				if (entrada==Double.NEGATIVE_INFINITY || entrada==Double.POSITIVE_INFINITY)
					correcto=false;
			}
			catch (NumberFormatException e){
				correcto=false;
			}
		}while (!correcto);
		return entrada;
	}
	
	public long inLong ()
	{
		long entrada = 0;
		try
		{
			entrada = Long.parseLong(this.inString());
		}
		catch (Exception e)
		{	
			this.salir();
		}
		return entrada;		
	}
	
	public long inLong (String message) {
		boolean correcto;
		long entrada=0;
		do{
			correcto=true;
			try{
				System.out.print(message+" ");
				entrada = Long.parseLong(this.inString());
			}
			catch (NumberFormatException e){
				correcto=false;
			}
		}while (!correcto);
		return entrada;
	
	}
	
	public byte inByte ()
	{
		byte entrada = 0;
		try
		{
			entrada = Byte.parseByte(this.inString());
		}
		catch (Exception e)
		{	
			this.salir();
		}
		return entrada;		
	}
	
	public byte inByte (String message) {
		boolean correcto;
		byte entrada=0;
		do{
			correcto=true;
			try{
				System.out.print(message+" ");
				entrada = Byte.parseByte(this.inString());
			}
			catch (NumberFormatException e){
				correcto=false;
			}
		}while (!correcto);
		return entrada;
	}
	
	public short inShort ()
	{
		short entrada = 0;
		try
		{
			entrada = Short.parseShort(this.inString());
		}
		catch (Exception e)
		{
			this.salir();
		}
		return entrada;		
	}	
	
	public short inShort (String message) {
		boolean correcto;
		short entrada=0;
		do{
			correcto=true;
			try{
				System.out.print(message+" ");
				entrada = Short.parseShort(this.inString());
			}
			catch (NumberFormatException e){
				correcto=false;
			}
		}while (!correcto);
		return entrada;
	}
	
	public char inChar ()
	{
		char caracter = ' ';
		String entrada = this.inString();
		if (entrada.length() > 1)
		{
			this.salir();
		}
		else		
			caracter = entrada.charAt(0);
		return caracter;		
	}
	
	public char inChar (String message)
	{
		char caracter = ' ';
		System.out.print(message+" ");
		String entrada = this.inString();
		if (entrada.length() > 1)
		{
			this.salir();
		}
		else		
			caracter = entrada.charAt(0);
		return caracter;		
	}
	
	public boolean inBoolean ()
	{
		boolean entradaLogica = true;
		String entrada = this.inString();
		if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false"))
			entradaLogica = Boolean.valueOf(entrada).booleanValue();		
		else
		{	
			this.salir();
		}
		return entradaLogica;		
	}
	
	public boolean inBoolean (String message)
	{
		boolean entradaLogica = true;
		boolean correcto;
        do{
            correcto=true;
            try{
                String entrada = inString(message);;
        		if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
        			entradaLogica = Boolean.valueOf(entrada).booleanValue();	
        		}
        		else {
        			correcto=false;
        		}

            }
            catch (Exception e){
                correcto=false;
            }
        }while (!correcto);
		return entradaLogica;		
	}

	
	public Date inDate(String message){
		boolean correcto;
		Date fecha_date=null;
		do{
			correcto=true;
			try{
				String fecha=inString(message);
				int anno=Integer.parseInt(fecha.substring(6));
				int mes=Integer.parseInt(fecha.substring(3,5))-1;
				int dia=Integer.parseInt(fecha.substring(0,2));
				GregorianCalendar cal=new GregorianCalendar(anno,mes,dia);
				fecha_date=new Date(cal.getTimeInMillis());
			}
			catch (InputMismatchException e){
				correcto=false;
			}
			catch (NumberFormatException e){
				correcto=false;
			}
			catch (Exception e){
				correcto=false;
			}
		}while (!correcto);
	
		return fecha_date;
	}
	
	
	public void out (String salida)
	{
		System.out.print(salida);
	}	
	
	public void out (int salida)
	{
		System.out.print(salida);
	}	
	
	public void out (float salida)
	{
		System.out.print(salida);
	}	
	
	public void out (double salida)
	{
		System.out.print(salida);
	}	
	
	public void out (long salida)
	{
		System.out.print(salida);
	}	
	
	public void out (byte salida)
	{
		System.out.print(salida);
	}	
	
	public void out (Short salida)
	{
		System.out.print(salida);
	}	
	
	public void out (char salida)
	{
		System.out.print(salida);
	}	
	
	public void out (boolean salida)
	{
		System.out.print(salida);
	}		
	
	public void outln (String salida)
	{
		System.out.println(salida);
	}	
	
	public void outln(int salida)
	{
		System.out.println(salida);
	}	
	
	public void outln (float salida)
	{
		System.out.println(salida);
	}	
	
	public void outln(double salida)
	{
		System.out.println(salida);
	}	
	
	public void outln(long salida)
	{
		System.out.println(salida);
	}	
	
	public void outln (byte salida)
	{
		System.out.println(salida);
	}	
	
	public void outln(Short salida)
	{
		System.out.println(salida);
	}	
	
	public void outln(char salida)
	{
		System.out.println(salida);
	}	
	
	public void outln(boolean salida)
	{
		System.out.println(salida);
	}		
	
	public void outln()
	{
		System.out.println();
	}		
	
	
	///////////////////////////////////////////////// Implementación
	
	private void salir ()
	{
		System.out.println("ERROR de entrada/salida");
		System.exit(0);
	}
	
	private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

}
