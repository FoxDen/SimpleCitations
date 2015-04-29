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
import java.util.Scanner;

public class ChicagoCitationGUI implements ItemListener{
	public final static int FIELDLENGTH = 20;
	final static String BOOK = "Book";
	final static String CHAPTER = "Chapter In Book";
	final static String EDITOR = "Book with Editor/Translator";
	final static String NEWSPAPER =	"Newspaper"; 
	final static String OFFLINEJOURNAL = "Offline Journal";
	final static String ONLINEJOURNAL = "Online Journal";
	final static String ENCYCLOPEDIA = "Encyclopedia";
	final static String WEBSITE = "Website";
		
	private JPanel citationTypes;
	private JPanel bookPanel;
	private JPanel booksWithEditorsPanel;
	private JPanel bookChaptersPanel;
	
	private bookClass book = new bookClass(BOOK);
	private bookClass chapter = new bookClass(CHAPTER);
	private bookClass editors = new bookClass(EDITOR);
		
	private JPanel newspaperPanel;
	private JPanel onlineJournalPanel;
	private JPanel offlineJournalPanel;
	private JPanel encyclopediaPanel;
	private JPanel websitePanel;
	
	private bookClass onJournal = new bookClass(ONLINEJOURNAL);
	private bookClass offJournal = new bookClass(OFFLINEJOURNAL);
	private bookClass encyclopedia = new bookClass(ENCYCLOPEDIA);
	private bookClass website = new bookClass(WEBSITE);
	private bookClass newspaper = new bookClass(NEWSPAPER);
	
	private static String currType = "Test";
	CardLayout cl = new CardLayout();
	
	private JTextArea output;
	//private JLabel pageNumber;

	
	JCheckBox isFootnote;
	JButton generate;
	JButton clear;
	
	Scanner scanInput;
	
	final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
    
    
	public void addComponent(Container container){
		JPanel citationBoxPane = new JPanel();
		JPanel bottomBit = new JPanel(new FlowLayout());
		JPanel bB = new JPanel();
		JPanel Bb = new JPanel(new BorderLayout());
		
		String citationItems[] = {BOOK, CHAPTER, EDITOR, ONLINEJOURNAL, OFFLINEJOURNAL, WEBSITE, ENCYCLOPEDIA, NEWSPAPER};

		JComboBox<String> cb = new JComboBox<String>(citationItems);
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
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				book.clear();
				chapter.clear();
				editors.clear();
				onJournal.clear();
				offJournal.clear();
				encyclopedia.clear();
				website.clear();
				newspaper.clear();
			}

		});
		
		isFootnote.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					book.setUppageNum();
					chapter.setUppageNum();
					editors.setUppageNum();
					onJournal.setUppageNum();
					offJournal.setUppageNum();
					encyclopedia.setUppageNum();
					website.setUppageNum();
					newspaper.setUppageNum();
	
				} 
				if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					book.removepageNum();
					chapter.removepageNum();
					editors.removepageNum();
					onJournal.removepageNum();
					offJournal.removepageNum();
					encyclopedia.removepageNum();
					website.removepageNum();
					newspaper.removepageNum();

				}
				}
				

			
		});
		
		generate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// Need to figure out why the getItem isn't working correctly.
				
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
	public void itemStateChanged(ItemEvent event) {
		cl = (CardLayout) citationTypes.getLayout();
		cl.show(citationTypes, (String) event.getItem());
	}
	


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

	    public static void main(String[] args) {
	        /* Use an appropriate Look and Feel */
	        try {
	            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
