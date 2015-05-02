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
	 * 
	 * @param container
	 */
	public void addComponent(Container container){
		JPanel citationBoxPane = new JPanel();
		JPanel bottomBit = new JPanel(new FlowLayout());
		JPanel bB = new JPanel();
		JPanel Bb = new JPanel(new BorderLayout());		

		String citationItems[] = {BOOK, CHAPTER, EDITOR, ONLINEJOURNAL, OFFLINEJOURNAL, WEBSITE, ENCYCLOPEDIA, NEWSPAPER};
		cb = new JComboBox<String>(citationItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		citationBoxPane.add(cb);
		
		isFootnote = new JCheckBox("Is this a footnote?");
		generate = new JButton("Generate");
		clear = new JButton("Clear");
		output = new JTextArea(2,30);
		
		bottomBit.add(isFootnote);
		bottomBit.add(generate);
		bottomBit.add(clear);
		bB.add(output);
		Bb.add(bB,BorderLayout.PAGE_START);
		Bb.add(bottomBit,BorderLayout.PAGE_END);
		
		/**
		 * 
		 */
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int i = 0;
				
				while(i<storage.length){
					storage[i].clear();
					i++;
				}
				System.out.println(currType);
			}

		});
		
		/**
		 * 
		 */
		isFootnote.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					int i = 0;
					
					while(i<storage.length){
						storage[i].setUppageNum();
						i++;
					}
				}
 
				if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					int i = 0;
					
					while(i<storage.length){
						storage[i].removepageNum();
						i++;
					}
				}
			}
		}
		);
		
		/**
		 * 
		 */
		generate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				output.setEditable(true);
				output.setText("Hello world");
				
				if(isFootnote.isSelected()){
				
					}
				
				output.setEditable(false);
				}	
		});

		bookPanel = book.returnJPanel(BOOK);
		booksWithEditorsPanel = editors.returnJPanel(CHAPTER);
		bookChaptersPanel = chapter.returnJPanel(EDITOR);
		onlineJournalPanel = onJournal.returnJPanel(ONLINEJOURNAL);
		offlineJournalPanel = offJournal.returnJPanel(OFFLINEJOURNAL);
		encyclopediaPanel = encyclopedia.returnJPanel(ENCYCLOPEDIA);
		websitePanel = website.returnJPanel(WEBSITE);
		newspaperPanel = newspaper.returnJPanel(NEWSPAPER);

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
	 * 
	 */
	public void itemStateChanged(ItemEvent event) {
		cl = (CardLayout) citationTypes.getLayout();
		cl.show(citationTypes, (String) event.getItem());
		currType = cb.getSelectedItem().toString();
		
	}
/**
 * 
 */
	   private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Bibliography Demo");
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
 * 
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
