package it.dv;

/*
 * https://www.html.it/articoli/swing-per-principianti-priceextractor-jpanel-layout-manager-event-listener/
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PriceExtractor {
	public static void main(String[] args) {
		
		JFrame mainWindow = new JFrame("Price Extractor");
		Container mainContainer = mainWindow.getContentPane();
		mainContainer.setLayout(new GridLayout(3,1));
		
		// TODO: ADD Container1
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(1,1));
		ImageIcon image = new ImageIcon("./img/soldi.jpg");
		JLabel banner = new JLabel();
		banner.setIcon(image);
		header.add(banner);
		mainWindow.add(header);
		
		// TODO: ADD Container2
		
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(6, 1));
		body.add(new JLabel("Prezzo in euro compreso di IVA (Gli eventuali decimali si separano con il punto)"));
		JTextField prezzoConIva= new JTextField();
		body.add(prezzoConIva);
		body.add(new JLabel("IVA %"));
		JTextField iva = new JTextField("21");
		body.add(iva);
		body.add(new JLabel("Prezzo in euro di listino calcolato"));
		JTextField prezzoListino = new JTextField("");
		prezzoListino.setOpaque(true);
		prezzoListino.setBackground(Color.CYAN);
		body.add(prezzoListino);
		mainWindow.add(body);
		
		// TODO: ADD Container3
		JPanel footer = new JPanel();
		footer.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
		JButton calcoloPrezzoBase = new JButton("Calcola");
		footer.add(calcoloPrezzoBase);
		JButton calcoloPrezzoIvato = new JButton("Inverso,da prezzo senza iva a prezzo con iva");
		footer.add(calcoloPrezzoIvato);
	    mainWindow.add(footer);
		
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainWindow.setSize(600, 350);
		mainWindow.setLocationRelativeTo(null);//nel mezzo dello schermo
		mainWindow.setVisible(true);
		
		calcoloPrezzoBase.addActionListener(
				new ListenerPrezzoListino(prezzoConIva, iva, prezzoListino)
			);
		
		calcoloPrezzoIvato.addActionListener(
				new ListenerPrezzoIvato(prezzoConIva, iva, prezzoListino)
			);
		
		
		
	}
	
	
	
	private static class ListenerPrezzoListino implements ActionListener{
		private JTextField prezzoConIva;
		private JTextField iva;
		private JTextField prezzoListino;
		
		public ListenerPrezzoListino(
			JTextField prezzoConIva,
			JTextField iva,
			JTextField prezzoListino)
		{
			this.prezzoConIva= prezzoConIva;
			this.iva=iva;
			this.prezzoListino=prezzoListino;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				System.out.println(prezzoConIva.getText());
				double prezzo = Double.valueOf(prezzoConIva.getText().trim());
				double ivaV = Double.valueOf(iva.getText().trim());
				double prezzoDiListino = prezzo/ (1 + (ivaV/100) );
				NumberFormat formatter=NumberFormat.getInstance(Locale.US);
				formatter.setMaximumFractionDigits(2);
				prezzoListino.setText(String.valueOf(formatter.format(prezzoDiListino)));
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null,
					"Errore nel calcolo, controlla i dati inseriti",
					"Error",
					JOptionPane.ERROR_MESSAGE
				);
			}
			
		}
	}
	private static class ListenerPrezzoIvato implements ActionListener{
		private JTextField prezzoConIva;
		private JTextField iva;
		private JTextField prezzoListino;
		public ListenerPrezzoIvato(
			JTextField prezzoConIva,
			JTextField iva,
			JTextField prezzoListino){
			this.prezzoConIva= prezzoConIva;
			this.iva=iva;
			this.prezzoListino=prezzoListino;
		}
		
		
		
		
		
		@Override
		public void actionPerformed(ActionEvent event) {
			try{
				double prezzo = Double.valueOf(prezzoListino.getText().trim());
				double ivaV = Double.valueOf(iva.getText().trim());
				double prezzoIva = prezzo + ((prezzo/100)*ivaV);
				NumberFormat formatter = NumberFormat.getInstance(Locale.US);
				formatter.setMaximumFractionDigits(2);
				prezzoConIva.setText(String.valueOf(formatter.format(prezzoIva)));
		    } catch(Exception e) {
		    	System.out.println(e);
		    	JOptionPane.showMessageDialog(null,
		    		"Errore nel calcolo, controlla i dati inseriti",
		    		"Error", JOptionPane.ERROR_MESSAGE);
		    	}
		    }
	}
}
