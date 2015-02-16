package model;

public enum EnumSexe {
	  Homme ("Homme"),
	  Femme ("Femme"),
	  NA ("N/A");
	  
	  private String name = "";
	   
	  //Constructeur
	  EnumSexe(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
}
