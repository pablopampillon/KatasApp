package BerlinClock;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.time.LocalDateTime;    
public class BerlinClockKata {
static double date;
static String horaActual;
static String  contarSecs(int sec) {
	if(sec%2==0) {
		return "Y";
	}else {
		return "O";
	}
	
}
static String  contarHoras(int horas) {
	int nLights = 0;
	nLights = horas%5;
	String str ="";
	for(int i = 1; i<=4; i++) {
		if(i<=nLights) {
			str+= "Y";
		}else {
			str+= "O";
		}
		
	}
	return str;
	
}
static String []  contarMinsB(int min) {
	int nAc=min/5;
	int nMin=min%5;
	String str ="";
	String strM ="";
	String[] mins=new String[2];
	for(int i=1;i<=4;i++) {
		if(i<=nMin) {
		str+="Y";}else {
			str+="O";
		}
	}
	for(int i=1;i<=11;i++) {
		if(i<=nAc) {
			if(i!=0 && i%3==0) {
				strM+="R";
			}else {
				strM+="Y";
			}
		}else {
			strM+="O";
		}
	}
	mins[0]=str;
	mins[1]=strM;
	
	
	return mins;
	
}
static String []  contarHorasB(int horas) {
	int nAc=horas/5;
	int nMin=horas%5;
	String str ="";
	String strH ="";
	String[] mins=new String[2];
	for(int i=1;i<=4;i++) {
		if(i<=nMin) {
		str+="R";}else {
			str+="O";
		}
	}
	for(int i=1;i<=4;i++) {
		if(i<=nAc) {
//		System.out.println(nAc);
			strH+="R";
			
		}else {
			strH+="O";
		}
	}
	mins[0]=str;
	mins[1]=strH;
	
	
	return mins;
	
}
//#######################################################INVERSA############################

static int  inversaMins(String min, String minAc) {
	int contadorMin=0;
	int contadorMa=0;
	int contadorMaT=0;
	for(int i=0;i<min.length();i++) {
		if(min.charAt(i)=='Y') {
		contadorMin++;
		}
	}
	for(int i=0;i<minAc.length();i++) {
		if(minAc.charAt(i)=='Y' || minAc.charAt(i)=='R') {
		contadorMa++;
		}
	}
	contadorMaT=(contadorMa*5)+contadorMin;
	
	return contadorMaT;
	
}
static int  inversaHoras(String hor, String horAc) {
	int contadorMin=0;
	int contadorMa=0;
	int contadorMaT=0;
	for(int i=0;i<hor.length();i++) {
		if(hor.charAt(i)=='R') {
		contadorMin++;
		}
	}
	for(int i=0;i<horAc.length();i++) {
		if(horAc.charAt(i)=='R') {
		contadorMa++;
		}
	}
//	System.out.println(contadorMin);
	contadorMaT=(contadorMa*5)+contadorMin;
	
	return contadorMaT;
	
}






	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		while (true) {
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			horaActual = dtf.format(now);
			String[] parts = horaActual.split(":");
			int[] iParts = new int[parts.length];
			for (int i = 0; i < parts.length; i++) {
				iParts[i] = Integer.parseInt(parts[i]);
			}
//		   for(int i=0;i<parts.length;i++) {
//			   System.out.println(iParts[i]);
//		   }
			//##################### grafico#################################
			System.out.print(contarSecs(iParts[2])+" ");
			System.out.print(contarMinsB(iParts[1])[0]+" ");
			System.out.print(contarMinsB(iParts[1])[1]+" ");
			System.out.print(contarHorasB(iParts[0])[0]+" ");
			System.out.print(contarHorasB(iParts[0])[1]+" ");
//			System.out.print(contarHoras(iParts[0])+" ");
			System.out.println();
			
			
//##################### inversa#################################
			
			System.out.print(inversaHoras(contarHorasB(iParts[0])[0], contarHorasB(iParts[0])[1])+":");
			System.out.print(inversaMins(contarMinsB(iParts[1])[0], contarMinsB(iParts[1])[1])+":");
			//COMO LOS SEGUNDOS EL RELOJ DE BERLIN CUENTA COMO ACTIVO O APAGADO SE ANIDAN DE LA LIBRERIA METIDOS EN EL ARRAY PARTS
			
			System.out.println(iParts[2]);
			
			
			Thread.sleep(1000);
			
		}
	}
}
