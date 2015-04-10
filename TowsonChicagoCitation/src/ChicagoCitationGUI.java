import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

public class ChicagoCitationGUI implements ItemListener{
	public final static int fieldLength = 20;
		
	JPanel citationTypes;
	JPanel books;
	JPanel booksWithEditors;
	JPanel bookChapters;
	
	JPanel newspaper;
	JPanel onlineJournal;
	JPanel offlineJournal;
	JPanel interviews;
	JPanel encyclopedia;
	JPanel website;
	
	JLabel author;
	JLabel publishingCompany;
	JLabel publishingCity;
	JLabel pageNumber;
	JLabel titleOfBook;
	JLabel titleOfArticle; 
	JLabel publicationYear;
	JLabel URL;
	
	JCheckBox isFootnote;
	Scanner scanInput;
	
	public void addComponent(Container container){
		JPanel citationTypes = new JPanel();
		String citationItems[] = {"Book", "Chapter In Book",
								  "Book with Editor/Translator", "Newspaper",
								  "Online Journal", "Offline Journal",
								  "Interview", "Encyclopedia",
								  "Website"};
		JComboBox<String> cb = new JComboBox<String>(citationItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		citationTypes.add(cb);
		
		bookComponents();
		journalComponents();
		otherComponents();
		
		citationTypes.add(onlineJournal, "Online Journal");
		citationTypes.add(offlineJournal, "Offline Journal");
		citationTypes.add(interviews, "Interviews");
		citationTypes.add(encyclopedia, "Encyclopedia Entry");
		citationTypes.add(website, "Website");
		
		citationTypes.add(books, "Book");
		citationTypes.add(bookChapters, "Chapter In Book");
		citationTypes.add(booksWithEditors, "Books with Editors");
		
		container.add(citationTypes, BorderLayout.PAGE_START);
		container.add(citationTypes, BorderLayout.CENTER);

	}
	
	public void bookComponents(){
		SpringLayout spring = new SpringLayout();
		
	}
	
	public void journalComponents(){
		SpringLayout spring = new SpringLayout();
		
	}
	
	public void otherComponents(){
		SpringLayout spring = new SpringLayout();
		
	}
	
	public void changeItemState(ItemEvent event){
		CardLayout cl = (CardLayout)(citationTypes.getLayout());
		//cl.show(citationTypes, (String).event.getItem());
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
