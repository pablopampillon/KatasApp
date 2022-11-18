package RomanNumeralsKata;

import java.util.HashMap;
import java.util.Scanner;

public class RomanNumerals {
	  public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      int N;
	      do {
	             System.out.print("Introduce un número entre 1 y 3999: ");
	             N = sc.nextInt();
	      } while (N < 1 || N > 3999);
	      System.out.println(N + " en numeros romanos -> " + convertirANumerosRomanos(N));                            
	  }

	  //método para pasar a números romanos
	  public static String convertirANumerosRomanos(int numero) {
		  
		  String romanNum = "";		  
		  int unidades,decenas,centenas,millar;
		  double uni,dec,cen,mill;
		  
//		  uni = numero%10;
//		  dec= numero/10 %10;
//		  cen= numero/100%10;
//		  mill = numero/1000;
		  
		  unidades = numero%10;
		  decenas= numero/10 %10;
		  centenas= numero/100%10;
		  millar = numero/1000;
		  if(millar>0) {
			  romanNum+=getNumMil(millar);
			  romanNum+=getNumCen(centenas);
			  romanNum+=getNumDec(decenas);
			  romanNum+=getNumUni(unidades);
			  
		  }else if(centenas>0) {
			  romanNum+=getNumCen(centenas);
			  romanNum+=getNumDec(decenas);
			  romanNum+=getNumUni(unidades);
		  }else if(decenas>0) {
//			  double unidad=dec-decenas*10;

			  romanNum+=getNumDec(decenas);
			  romanNum+=getNumUni(unidades);
			  
		  }else if(unidades>0) {
			romanNum=getNumUni(unidades);
			
		  }else {
			  System.out.println("INTRODUCE UN NÚMERO CORRECTO");
		  }
		  
		  
		  return romanNum;
		  
		  
		  
	      
	      
	  }
	  public static String getNumUni(int unidades) {
		 
		  int useFive = unidades%5;
		  String romanNum="";
		if(unidades==9) {
			  romanNum+="IX";
		  }else if(unidades>=5) {
			  romanNum+="V";
			  useFive = unidades%5;
			  for(int i=0;i<useFive;i++) {
				  romanNum+="I";
			  }
		  }else {
			  if(unidades==4) {
				  romanNum+="IV";
			  }else {for(int i=0;i<useFive;i++) {
				  romanNum+="I";
			  }}
		  }
		  return romanNum;
	  }
	  public static String getNumDec(int dec) {
			 
		  int useFive = dec%5;
		  String romanNum="";
		if(dec==9) {
			  romanNum+="XC";
		  }else if(dec>=5) {
			  romanNum+="L";
			  useFive = dec%5;
			  for(int i=0;i<useFive;i++) {
				  romanNum+="X";
			  }
		  }else {
			  if(dec==4) {
				  romanNum+="XL";
			  }else {for(int i=0;i<useFive;i++) {
				  romanNum+="X";
			  }}
		  }
		  return romanNum;
	  }
	  public static String getNumCen(int centena) {
			 
		  int useFive = centena%5;
		  String romanNum="";
		if(centena==9) {
			  romanNum+="CM";
		  }else if(centena>=5) {
			  romanNum+="D";
			  useFive = centena%5;
			  for(int i=0;i<useFive;i++) {
				  romanNum+="C";
			  }
		  }else {
			  if(centena==4) {
				  romanNum+="CD";
			  }else {for(int i=0;i<useFive;i++) {
				  romanNum+="C";
			  }}
		  }
		  return romanNum;
	  }
	  public static String getNumMil(int millar) {
			 
		
		  String romanNum="";
		  for(int i=0;i<millar;i++) {
			  romanNum+="M";
		  }
		  return romanNum;
	  }



}
