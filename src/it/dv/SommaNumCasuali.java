package it.dv;



/*	Esempio preso da internet!!!!!!!!!!!!!!!!
 * Semplice Calcolatrice Java Swing con le operazioni di base di addizione, sottrazione, 
 * moltiplicazione, divisione, elevamento a potenza  e percentuale.
 * Per semplicità è possibile effettuare un'operazione per volta. Inoltre,  se si gestiscono  
 * numeri molto grandi che superano i limiti dei dati primitivi long e int, il risultato non è corretto 
 * Per eseguire calcoli con numeri molto grandi si possono usare le classi BigInteger 
 * e BigDecimal della libreria java.math; con queste classi i numeri non hanno limiti di 
 * dimensione. Per i calcoli però non si possono usare i normali operatori aritmetici ma si devono
 * usare i metodi  add(), subtract(), multiply() e divide()).
 * Prof. Mauro De Berardis 2022 
 */
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
public class SommaNumCasuali extends JFrame implements ActionListener{
	public static final Font BF = new Font(Font.SANS_SERIF, Font.BOLD, 22); // Font del display e dei bottoni
	public static final Color SF= new Color(230,230,230);//Sfondo tasti operazioni
	boolean calcolato;
    JTextField display = new JTextField(24);// crea il campo testo  sul display
    JButton b0=new JButton("calcola Somma"); // crea i bottoni
    JButton b1=new JButton("genera numero");
    int somma;
    String sommaPar="";
    
  
    
    // costruttore---------------------------------------------------
    public  SommaNumCasuali(){
    	
    String cas;
     Container c=this.getContentPane();
     
   	 // crea pannello del display pDisplay
   	 JPanel pDisplay=new JPanel();
   	 pDisplay.add(display); 
   	 pDisplay.setBackground(SF);
   	 // crea pannello dei bottoni
   	 JPanel pB=new JPanel(new GridLayout(2,1));
   	 pB.add(b1); pB.add(b0);
   	 // cambia il Font per tutti i bottoni  
   	 display.setFont(BF); display.setForeground(new Color(220,20,60));// Colore Rosso Crimson----
   	 b0.setFont(BF);b1.setFont(BF);
   	 // add ActionListener
   	 b0.addActionListener(this);b1.addActionListener(this);
   	 c.add(pDisplay, BorderLayout.NORTH);
     c.add(pB, BorderLayout.SOUTH);
     this.setTitle("Calcolatrice Java Swing");
	 this.setResizable(false);
	 this.pack();
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setVisible(true);

    } // end public  Calcolatrice()--------------------------------------------- 
    
	public static void main(String[] args) {
		new SommaNumCasuali();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 String s = e.getActionCommand();
		 String ch=s.substring(0,1);
		 System.out.println(s + " " + ch);
		 switch(ch) {
		 	
		 	case "g": numSet(); break;
		 	case "c" : printNum();break;
		 	/*case "2" : ifnumero(ch);break;
		 	case "3" : ifnumero(ch);break;	 
		 	case "4" : ifnumero(ch);break;
		 	case "5": ifnumero(ch);break;
		 	case "6" : ifnumero(ch);break;
		 	case "7" : ifnumero(ch);break;
		 	case "8" : ifnumero(ch);break;
		 	case "9" : ifnumero(ch);break; 
		 	case "."  : ifnumero(ch);break;*/
		 
		 	/*case "C": 	
		 		op1="";op2="";operazione="";   
		 		display.setText("");break; */
		 	
		 	/*case "0":	
		  		if((operazione.equals("") && op1.equals("") && op2.equals(""))) break;
		  		double risultato=0;
		 			switch(operazione){
		 				case "+":
		 					risultato = Double.parseDouble(op1) + Double.parseDouble(op2); break;
		 				case "-":
		 					risultato = Double.parseDouble(op1) - Double.parseDouble(op2); break;
		 				case "*":
		 					risultato = Double.parseDouble(op1) * Double.parseDouble(op2); break;	
		 				case "/":
		 					risultato = Double.parseDouble(op1) / Double.parseDouble(op2); break;
		 				case "^":
		 					risultato = Math.pow(Double.parseDouble(op1),Double.parseDouble(op2)); break;
		  				case "%":
		 					risultato = (Double.parseDouble(op1) /100.0)* Double.parseDouble(op2); break;
		 			}
		 			risultato=((long)(risultato*100000))/100000.0;
		 			display.setText(op1 + operazione + op2 + "=" + risultato);
		            op1 = Double.toString(risultato);
		            operazione=""; op2="";
		            calcolato=true;
		            break;*/
		 	
		
		 	}// end switch case--------------------------------------------------------------
	     
	} // end  void actionPerformed(ActionEvent e)-------------------------------------- 
		
	// se inserisco un numero o un punto	 
	/*void ifnumero(String c) {
			if(calcolato && operazione.equals("")){
				calcolato=false;
				op1="";
				display.setText(op1 +operazione+ op2);
			}
		    if (operazione.equals("")){
		    	if(c.equals(".") && op1.contains(".")) {
		    	}
		    	else{
		    		 op1 = op1 + c;
		    	}
		 		     
		    }
	          else{
	        	  if(c.equals(".") && op2.contains(".")) {
			    	}
			    	else{
			    		 op2 = op2 + c;
			    	}
	         }
	          display.setText(op1 +operazione+ op2);
		}
		 
	void ifoperazione(String c) {
			if(!operazione.equals("") && !op2.equals(""))return;
				
			 if (op1.equals("") ) {
				 operazione= "";
			 }
			 else
	    	 {
				operazione=""+c;
				 display.setText(op1 + operazione);
			 }
	 }*/
	int casu () 
	{
		Random random = new Random();
		return (int) (Math.random()*100);
		
	}
	void numSet ()
	{ 
		int numGen=casu();
		if (sommaPar.equals(""))
		{
			sommaPar=sommaPar + Integer.toString(numGen);
		}else 
		{
			sommaPar=sommaPar + "+" + Integer.toString(numGen);
		}
		
		display.setText(sommaPar);
		somma= somma+numGen;
		//display.setText(Integer.toString(numGen));
		System.out.println("numGen= " + numGen);
	}
	void printNum()
	{
		display.setText(Integer.toString(somma));
		
	}
	
		 
} // end Class----------------------------------------------------------------------------------
