package SwingView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuestionsDialogues{
	
		
	  public static int introNumero(String text){
		  int num=0;
			try{num = Integer.parseInt( JOptionPane.showInputDialog(
			        null, text,
			        "Question",
			        JOptionPane.QUESTION_MESSAGE) );
				if (num <= 0){JOptionPane.showMessageDialog(new JFrame(), "Mauvais numero!", "Question",
			    		JOptionPane.QUESTION_MESSAGE);	
			    		introNumero(text);}
		    	}catch(NumberFormatException ex){
		    		JOptionPane.showMessageDialog(new JFrame(), "Mauvais numero!", "Error",
		    		JOptionPane.QUESTION_MESSAGE);	
		    		introNumero(text);
		    	}
			
			return  num; 
	  }
	  
	  public static int mauvaisNumero(String str, String text){
		  
		  int num;
			try{
		        	num=Integer.parseInt(str);
		        	if (num <= 0){JOptionPane.showMessageDialog(new JFrame(), text, "Question",
				    		JOptionPane.QUESTION_MESSAGE);	
				    		introNumero(text);}
		    	}catch(NumberFormatException ex){
		    		JOptionPane.showMessageDialog(new JFrame(), text,"Error",
				    JOptionPane.QUESTION_MESSAGE);	
				    String text2= "Introduir le numero un autre fois";
		        	num=introNumero(text2);
		    	}
			
			return  num; 
	  }
	  

}
