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
import java.awt.event.*;
import javax.swing.*;
public class Calcolatrice extends JFrame implements ActionListener{
	public static final Font BF = new Font(Font.SANS_SERIF, Font.BOLD, 22); // Font del display e dei bottoni
	public static final Color SF= new Color(230,230,230);//Sfondo tasti operazioni
	String op1, op2,operazione; // operando1, operando2 e operazione
	boolean calcolato;
    JTextField display = new JTextField(24);// crea il campo testo  sul display
    JButton b0=new JButton("0"); // crea i bottoni
    JButton b1=new JButton("1");
    JButton b2=new JButton("2");
    JButton b3=new JButton("3");
    JButton b4=new JButton("4");
    JButton b5=new JButton("5");
    JButton b6=new JButton("6");
    JButton b7=new JButton("7");
    JButton b8=new JButton("8");
    JButton b9=new JButton("9"); 
    JButton bpunto=new JButton(".");
    JButton bpiu=new JButton("+");
    JButton bmeno=new JButton("-");
    JButton bper=new JButton("*");
    JButton bdiv=new JButton("/");
    JButton bperc=new JButton("%");
    JButton bnulla=new JButton("");
    JButton bpot=new JButton("^");
    JButton bclear=new JButton("Clear");
    JButton buguale=new JButton("=");
  
    
    // costruttore---------------------------------------------------
    public  Calcolatrice(){
     op1="";op2="";operazione="";
     calcolato=false;
   	 
     Container c=this.getContentPane();
     
   	 // crea pannello del display pDisplay
   	 JPanel pDisplay=new JPanel();
   	 pDisplay.add(display); 
   	 pDisplay.setBackground(SF);
   	 // crea pannello dei bottoni
   	 JPanel pB=new JPanel(new GridLayout(5,4));
   	 pB.add(b1); pB.add(b2); pB.add(b3); pB.add(bpiu);
   	 pB.add(b4); pB.add(b5);pB.add(b6);pB.add(bmeno);
   	 pB.add(b7); pB.add(b8); pB.add(b9); pB.add(bper);
   	 pB.add(b0); pB.add(bpunto);pB.add(bclear);pB.add(bdiv);
   	 pB.add(bnulla); pB.add(bpot);  pB.add(bperc);pB.add(buguale); 	 
   	 // cambia il Font per tutti i bottoni  
   	 display.setFont(BF); display.setForeground(new Color(220,20,60));// Colore Rosso Crimson----
   	 b0.setFont(BF);b1.setFont(BF);b2.setFont(BF);b3.setFont(BF);b4.setFont(BF);
   	 b5.setFont(BF);b6.setFont(BF);b7.setFont(BF);b8.setFont(BF);b9.setFont(BF);bpunto.setFont(BF);
   	 bpiu.setFont(BF);bmeno.setFont(BF);bper.setFont(BF);bdiv.setFont(BF);bpot.setFont(BF);
   	 bperc.setFont(BF);bclear.setFont(BF);buguale.setFont(BF);
   	 // cambia lo sfondo per gli operatori
   	 buguale.setBackground(new Color(255,255,240));
   	 bpiu.setBackground(SF);bmeno.setBackground(SF); bper.setBackground(SF);
   	 bdiv.setBackground(SF);bpot.setBackground(SF);bperc.setBackground(SF);
   	 // add ActionListener
   	 b0.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
   	 b4.addActionListener(this);b5.addActionListener(this);b6.addActionListener(this);b7.addActionListener(this);
   	 b8.addActionListener(this);b9.addActionListener(this);bpunto.addActionListener(this);bpiu.addActionListener(this);
   	 bmeno.addActionListener(this);bper.addActionListener(this);bdiv.addActionListener(this);
   	 bpot.addActionListener(this); bperc.addActionListener(this);
   	 bclear.addActionListener(this);buguale.addActionListener(this);
   	 //
   	 c.add(pDisplay, BorderLayout.NORTH);
     c.add(pB, BorderLayout.SOUTH);
     this.setTitle("Calcolatrice Java Swing");
	 this.setResizable(false);
	 this.pack();
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setVisible(true);

    } // end public  Calcolatrice()--------------------------------------------- 
    
	public static void main(String[] args) {
		new Calcolatrice();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 String s = e.getActionCommand();
		 String ch=s.substring(0,1);
		 switch(ch) {
		 	
		 	case "0": ifnumero(ch);break;
		 	case "1" : ifnumero(ch);break;
		 	case "2" : ifnumero(ch);break;
		 	case "3" : ifnumero(ch);break;	 
		 	case "4" : ifnumero(ch);break;
		 	case "5": ifnumero(ch);break;
		 	case "6" : ifnumero(ch);break;
		 	case "7" : ifnumero(ch);break;
		 	case "8" : ifnumero(ch);break;
		 	case "9" : ifnumero(ch);break;
		 	case "."  : ifnumero(ch);break;
		 
		 	case "C": 	
		 		op1="";op2="";operazione="";   
		 		display.setText("");break;
		 	
		 	case "=":	
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
		            break;
		 	
		 	case "+":	ifoperazione(ch);break;   
	        case "-":	ifoperazione(ch);break;  
	        case "*":	ifoperazione(ch);break; 
	        case "/":	ifoperazione(ch);break;
	        case "^":	ifoperazione(ch);break;
	        case "%":	ifoperazione(ch);break;
		 	}// end switch case--------------------------------------------------------------
	     
	} // end  void actionPerformed(ActionEvent e)-------------------------------------- 
		
	// se inserisco un numero o un punto	 
	void ifnumero(String c) {
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
	 }
		 
} // end Class----------------------------------------------------------------------------------
