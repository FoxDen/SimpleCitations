import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChicagoCitationGUI implements ItemListener{
	public final static int FIELDLENGTH = 20;
	public final static String BOOK = "Book";
	public final static String CHAPTER = "Chapter In Book";
	public final static String EDITOR = "Book with Editor/Translator";
	public final static String NEWSPAPER =	"Newspaper"; 
	public final static String OFFLINEJOURNAL = "Offline Journal";
	public final static String ONLINEJOURNAL = "Online Journal";
	public final static String ENCYCLOPEDIA = "Encyclopedia";
	public final static String WEBSITE = "Website";
		
	private JPanel citationTypes;
	private JPanel bookPanel;
	private JPanel booksWithEditorsPanel;
	private JPanel bookChaptersPanel;	
	private JPanel newspaperPanel;
	private JPanel onlineJournalPanel;
	private JPanel offlineJournalPanel;
	private JPanel encyclopediaPanel;
	private JPanel websitePanel;
	
	private bookClass book = new bookClass(BOOK);
	private bookClass chapter = new bookClass(CHAPTER);
	private bookClass editors = new bookClass(EDITOR);
	private bookClass onJournal = new bookClass(ONLINEJOURNAL);
	private bookClass offJournal = new bookClass(OFFLINEJOURNAL);
	private bookClass encyclopedia = new bookClass(ENCYCLOPEDIA);
	private bookClass website = new bookClass(WEBSITE);
	private bookClass newspaper = new bookClass(NEWSPAPER);
	private final bookClass[] storage = {book, chapter, editors, onJournal, offJournal, website, encyclopedia, newspaper}; //simply to act for the while loop.

	private static String currType = "";
	private CardLayout cl = new CardLayout();
	private JComboBox<String> cb; 
	
	private JTextArea output;	
	private JCheckBox isFootnote;
	private JButton generate;
	private JButton clear;
	    
	/**
	 * Sets up the components for the main window.
	 * @param container
	 */
	public void addComponent(Container container){
		JPanel citationBoxPane = new JPanel(); //The main panel to display the different components.
		JPanel bottomBit = new JPanel(new FlowLayout());
		JPanel bB = new JPanel();
		JPanel Bb = new JPanel(new BorderLayout());		
		
		//Stores the string representations of the different citation types.
		String citationItems[] = {BOOK, CHAPTER, EDITOR, ONLINEJOURNAL, OFFLINEJOURNAL, WEBSITE, ENCYCLOPEDIA, NEWSPAPER};
		cb = new JComboBox<String>(citationItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		citationBoxPane.add(cb);
		
		//sets up footnote, data clearing & data output components.
		isFootnote = new JCheckBox("Is this a footnote?");
			isFootnote.setSelected(false);
		generate = new JButton("Generate");
		clear = new JButton("Clear");
		output = new JTextArea(2,40);
			output.setLineWrap(true);
			output.setEditable(false);
		
		//bottomBit adds all of the interactable components together.
		bottomBit.add(isFootnote);
		bottomBit.add(generate);
		bottomBit.add(clear);
		bB.add(output);//This panel then takes in the output box for the citation to show up in.
		//These two panels are then added to the Bb panel, which will go into the main one.
		Bb.add(bB,BorderLayout.PAGE_START);
		Bb.add(bottomBit,BorderLayout.PAGE_END);
		/**
		 * Adds an action listener to run the "Clear" method for all objects of type bookClass.
		 */
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int i = 0;
				
				while(i<storage.length){
					storage[i].clear();
					i++;
				}
			}

		});
		
		/**
		 * Adds an item listener to the footnote checkbox. Selecting it means the entire citation should be in footnote format. Deselecting it means it will not be.
		 */
		isFootnote.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					storage[0].setupFootnote(true);
					storage[2].setupFootnote(true);
					storage[5].setupFootnote(true);
					storage[6].setupFootnote(true);
				} else if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					storage[0].setupFootnote(false);
					storage[2].setupFootnote(false);
					storage[5].setupFootnote(false);
					storage[6].setupFootnote(false);
				}
			}
		}
		);
		
		/**
		 * Adds an action listener to the generate button to run the generateCitation method in the bookClass. Depending on the panel, a different output will be produced.
		 */
		generate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				output.setEditable(true);//sets the output to be editable so the text may be set.
				//if the user wants it to be a footnote...
				if(isFootnote.isSelected()==true){
					if(currType.equals(BOOK)){
						output.setText(book.generateCitation(true));
					} else if(currType.equals(CHAPTER)){
						output.setText(chapter.generateCitation(true));
					} else if(currType.equals(EDITOR)){
						output.setText(editors.generateCitation(true));
					} else if(currType.equals(ENCYCLOPEDIA)){
						output.setText(encyclopedia.generateCitation(true));
					} else if(currType.equals(WEBSITE)){
						output.setText(website.generateCitation(true));
					} else if(currType.equals(NEWSPAPER)){
						output.setText(newspaper.generateCitation(true));
					} else if(currType.equals(OFFLINEJOURNAL)){
						output.setText(offJournal.generateCitation(true));
					} else if(currType.equals(ONLINEJOURNAL)){
						output.setText(onJournal.generateCitation(true));
					} else
						System.out.println("Error");
					}
				//if the user does not want it to be a footnote...
				else if(isFootnote.isSelected()==false){
					if(currType.equals(BOOK)){
						output.setText(book.generateCitation(false));
					} else if(currType.equals(CHAPTER)){
						output.setText(chapter.generateCitation(false));
					} else if(currType.equals(EDITOR)){
						output.setText(editors.generateCitation(false));
					} else if(currType.equals(ENCYCLOPEDIA)){
						output.setText(encyclopedia.generateCitation(false));
					} else if(currType.equals(WEBSITE)){
						output.setText(website.generateCitation(false));
					} else if(currType.equals(NEWSPAPER)){
						output.setText(newspaper.generateCitation(false));
					} else if(currType.equals(OFFLINEJOURNAL)){
						output.setText(offJournal.generateCitation(false));
					} else if(currType.equals(ONLINEJOURNAL)){
						output.setText(onJournal.generateCitation(false));
					} else
						System.out.println("Error");
				}
				output.setEditable(false);//the ability for the output being able to set text is turned off again.
				}	
		});
		//The info regarding the different panels is stored here. New panels are created using the info from bookClass.returnJPanel().
		bookPanel = book.returnJPanel(BOOK);
		booksWithEditorsPanel = editors.returnJPanel(CHAPTER);
		bookChaptersPanel = chapter.returnJPanel(EDITOR);
		onlineJournalPanel = onJournal.returnJPanel(ONLINEJOURNAL);
		offlineJournalPanel = offJournal.returnJPanel(OFFLINEJOURNAL);
		encyclopediaPanel = encyclopedia.returnJPanel(ENCYCLOPEDIA);
		websitePanel = website.returnJPanel(WEBSITE);
		newspaperPanel = newspaper.returnJPanel(NEWSPAPER);

		//Here, these panels are stored into the main panel to be displayed, citationTypes.
		citationTypes = new JPanel(cl);
		citationTypes.add(bookPanel, BOOK);
		citationTypes.add(bookChaptersPanel, CHAPTER);
		citationTypes.add(booksWithEditorsPanel, EDITOR);
		citationTypes.add(onlineJournalPanel, ONLINEJOURNAL);
		citationTypes.add(offlineJournalPanel, OFFLINEJOURNAL);
		citationTypes.add(websitePanel, WEBSITE);
		citationTypes.add(encyclopediaPanel, ENCYCLOPEDIA);
		citationTypes.add(newspaperPanel, NEWSPAPER);
		
		container.add(citationBoxPane, BorderLayout.PAGE_START);
		container.add(citationTypes, BorderLayout.CENTER);
		container.add(Bb, BorderLayout.PAGE_END);
	}

	@Override
	/**
	 * Notes whenever the combobox has been changed.
	 */
	public void itemStateChanged(ItemEvent event) {
		cl = (CardLayout) citationTypes.getLayout();
		cl.show(citationTypes, (String) event.getItem());
		currType = cb.getSelectedItem().toString();//sets the currType string to store the string representation of the type of media just selected.
		
	}
/**
 * Created and shows the GUI's frame, size and other attributes.
 */
	   private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Towson Chicago Bibliography for History Majors");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Dimension d = new Dimension(600,300);
	        frame.getContentPane().setPreferredSize(d);
	         
	        //Create and set up the content pane.
	        ChicagoCitationGUI demo = new ChicagoCitationGUI();
	        demo.addComponent(frame.getContentPane());
	         
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
/**
 * Main method, putting everything together.
 * @param args
 */
	    public static void main(String[] args) {
	        /* Use an appropriate Look and Feel */
	        try {
	            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");


	        } catch (UnsupportedLookAndFeelException ex) {
	            ex.printStackTrace();
	        } catch (IllegalAccessException ex) {
	            ex.printStackTrace();
	        } catch (InstantiationException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        /* Turn off metal's use of bold fonts */
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
	         
	        //Schedule a job for the event dispatch thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
}
