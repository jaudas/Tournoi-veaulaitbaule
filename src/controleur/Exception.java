package controleur;

import java.util.Scanner;

public class Exception {
	 static Scanner sc = new Scanner(System.in);
	
	  public static int mauvaisNumero(String str){
		  
		  int num=0;
			try{
		        	num=Integer.parseInt(str);
		    	}catch(NumberFormatException ex){
		        	System.out.println("Ce n'est pas un numero!  ");
		        	System.out.println("Veuillez saisir un nombre :");
		        	str=sc.nextLine();
		        	mauvaisNumero(str);
		    	}
			num=Integer.parseInt(str);
			return  num; 
	  } 
	  
	  

}