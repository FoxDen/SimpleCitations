import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 ***************************TO DO***************************
	*FUTURE: Set up an output to a text file whenever the user "Clears" the data?
 ***********************************************************
 */

public class bookClass {

	public final int FIELDLENGTH = 15;
	
	private JLabel author;
	private JLabel publisher;
	private JLabel titleOfBook;
	private JLabel titleOfArticle; 
	private JLabel URL;
	private JLabel editorOrTranslator;
	private JLabel journalVolume;
	private JLabel journalNumber;
	private JLabel date;
	private JLabel year;
	private JLabel city;
	
	private final String type;	
	private String storage = "";
	JPanel bookBase = new JPanel();

	public JTextField URLText;
	public JTextField fName;
	public JTextField lName;
	public JTextField mInit;
	public JTextField title;
	public JTextField articleTitle;
	public JTextField publisherName;
	public JTextField publishCity;
	public JTextField publishYear;
	public JTextField publishDate;
	public JTextField editorTranslator;
	public JTextField journalV;
	public JTextField journalN;
	
	JLabel pageNumber = new JLabel("Pages");
	JTextField pageNum = new JTextField("", 5);
	boolean x = false;
	
	SpringLayout spring = new SpringLayout();

	public bookClass(String t) {
		type = t;
	}
/**
 * 	Will set up the different panels necessary for the different kinds of citations. Returns nothing.
 */
	public void bookComponents(){
		//The initial components of the panel.
		bookBase = new JPanel();
		bookBase.setLayout(spring);		
		
		author = new JLabel("Author");
		fName = new JTextField("",FIELDLENGTH);
		fName.setToolTipText("First Name of Author");
		lName = new JTextField("",FIELDLENGTH);
		lName.setToolTipText("Last Name of Author");
		mInit = new JTextField("",1);
		mInit.setToolTipText("Middle Inital of Author");
		titleOfBook = new JLabel("Title");
		year = new JLabel("Year of Publication");
		publishYear = new JTextField("", 4);
		
		title = new JTextField("",FIELDLENGTH);
		publisherName = new JTextField("",FIELDLENGTH);
		URLText = new JTextField("",FIELDLENGTH);
		URL = new JLabel("URL");
				
		bookBase.add(fName);
		bookBase.add(lName);
		bookBase.add(mInit);
		bookBase.add(author);
		bookBase.add(titleOfBook);
		bookBase.add(title);
		bookBase.add(publishYear);
		bookBase.add(year);
		
		titleOfArticle = new JLabel("Chapter");
		articleTitle = new JTextField("",FIELDLENGTH);
		
		//If the type here is either an online journal or an offline journal
		if(getType() == "Online Journal" || getType() == "Offline Journal"){
			journalVolume = new JLabel("Vol.");
			titleOfBook.setText("Journal");
			journalNumber = new JLabel("No.");
			journalV = new JTextField("", 3);
			journalN = new JTextField("", 3);
			date = new JLabel("Month/Season published");
			publishDate = new JTextField("",10);
			titleOfArticle.setText("Article");
		
			bookBase.add(titleOfArticle);
			bookBase.add(articleTitle);
			bookBase.add(journalVolume);
			bookBase.add(journalNumber);
			bookBase.add(journalV);
			bookBase.add(journalN);
			bookBase.add(date);
			bookBase.add(publishDate);
			bookBase.add(pageNum); 
			bookBase.add(pageNumber); 
			
			if(getType() == "Online Journal"){
				URL.setText("URL or DOI");
				bookBase.add(URL);
				bookBase.add(URLText);
				
				storage+="u ";
			}
			storage+="a v d p ";

		} 
		//If the type here is a book, a chapter in the book, or a book with an editor or translator instead.
		if(getType() == "Chapter In Book" || getType() == "Book" || getType() == "Book with Editor/Translator" || getType() == "Encyclopedia"){
			publisher = new JLabel("Publisher");
			city = new JLabel("City");
			publishCity = new JTextField("", FIELDLENGTH);
			publisherName = new JTextField("", FIELDLENGTH);
			bookBase.add(publisherName);
			bookBase.add(publishCity);
			bookBase.add(publisher);
			bookBase.add(city);
			storage+="b ";
			
			if(getType() == "Book with Editor/Translator"){
				editorOrTranslator = new JLabel("Editor/Translator");
				editorTranslator = new JTextField("",FIELDLENGTH);
				
				bookBase.add(editorOrTranslator);
				bookBase.add(editorTranslator);
				
				storage+="e ";
			} 
			
			if (getType() == "Chapter In Book"){
				articleTitle = new JTextField("",FIELDLENGTH);
				
				bookBase.add(titleOfArticle);
				bookBase.add(articleTitle);
				bookBase.add(pageNum); 
				bookBase.add(pageNumber);
				
				storage+="a ";
			}
			
			if (getType() == "Encyclopedia"){
				titleOfBook.setText("Encyclopedia");
				titleOfArticle.setText("Entry Name:");
				articleTitle = new JTextField("",FIELDLENGTH);
				
				bookBase.add(articleTitle);
				bookBase.add(titleOfArticle);
				
				storage+="a ";
			}

		} 
		//If the type here is a newspaper or a website.
		if (getType() == "Newspaper" || getType() == "Website"){
			titleOfArticle.setText("Article");
			articleTitle = new JTextField("",FIELDLENGTH);
			bookBase.add(articleTitle);
			date = new JLabel("Published on:");
			publishDate = new JTextField("",10);

			bookBase.add(date);
			bookBase.add(publishDate);
			bookBase.add(URL);
			bookBase.add(URLText);
			bookBase.add(titleOfArticle);

			titleOfBook.setText((getType()=="Newspaper")? "Newspaper":"Website");
			
			storage+="u d a ";
		}
	}
/**
 * 	Sets up the positioning of the different panels.
 */
	public void bookBaseSetUp(){
		//General setup
		spring.putConstraint(SpringLayout.SOUTH, fName, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, fName, 10, SpringLayout.WEST, author);

		spring.putConstraint(SpringLayout.SOUTH, lName, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, lName, 180, SpringLayout.WEST, fName);
		
		spring.putConstraint(SpringLayout.SOUTH, mInit, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, mInit, 180, SpringLayout.WEST, lName);

		spring.putConstraint(SpringLayout.SOUTH, titleOfBook, 60, SpringLayout.WEST, author);
		spring.putConstraint(SpringLayout.SOUTH, title, 65, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, title, 10, SpringLayout.WEST, author);
		
		spring.putConstraint(SpringLayout.SOUTH, year, 0, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, year, 400, SpringLayout.WEST, author);		
		spring.putConstraint(SpringLayout.SOUTH, publishYear, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, publishYear, 400, SpringLayout.WEST, author);
	


		if(storage.contains("b")){ //sets up book component
			spring.putConstraint(SpringLayout.SOUTH, publisher, 60, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, publisher, 190, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, publisherName, 65, SpringLayout.SOUTH, author);
			spring.putConstraint(SpringLayout.WEST, publisherName, 190, SpringLayout.WEST, author);

			spring.putConstraint(SpringLayout.SOUTH, city, 60, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, city, 370, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, publishCity, 65, SpringLayout.SOUTH, author);
			spring.putConstraint(SpringLayout.WEST, publishCity, 370, SpringLayout.WEST, author);

		}  

		if(storage.contains("v")){ //sets up volume and number component
		
			spring.putConstraint(SpringLayout.SOUTH, journalVolume, 60, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, journalVolume, 190, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, journalV, 65, SpringLayout.SOUTH, author);
			spring.putConstraint(SpringLayout.WEST, journalV, 190, SpringLayout.WEST, author);
			
			spring.putConstraint(SpringLayout.SOUTH, journalNumber, 50, SpringLayout.WEST, title);
			spring.putConstraint(SpringLayout.WEST, journalNumber, 240, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, journalN, 65, SpringLayout.SOUTH, author);
			spring.putConstraint(SpringLayout.WEST, journalN, 240, SpringLayout.WEST, author);
			
			
		} 
		
		if (storage.contains("a")){ //sets up article title component
			spring.putConstraint(SpringLayout.SOUTH, titleOfArticle, 105, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, articleTitle, 125, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, articleTitle, 10, SpringLayout.WEST, author);
			
			spring.putConstraint(SpringLayout.SOUTH, pageNumber, 105, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, pageNumber, 190, SpringLayout.WEST, author);
			
			spring.putConstraint(SpringLayout.SOUTH, pageNum, 125, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, pageNum, 190, SpringLayout.WEST, author);

		}
		
		if (storage.contains("d")){ //sets up date component
			spring.putConstraint(SpringLayout.SOUTH, date, 60, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, date, 300, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, publishDate, 65, SpringLayout.SOUTH, author);
			spring.putConstraint(SpringLayout.WEST, publishDate, 300, SpringLayout.WEST, author);
		}
		
		if (storage.contains("e")){ //sets up editor component

			spring.putConstraint(SpringLayout.SOUTH, editorOrTranslator, 105, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, editorTranslator, 125, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, editorTranslator, 10, SpringLayout.WEST, author);
		}
		
		if (storage.contains("u")){ //sets up URL component
			spring.putConstraint(SpringLayout.SOUTH, URL, 150, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.SOUTH, URLText, 170, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, URLText, 10, SpringLayout.WEST, author);
		}
		
	}
	
	/**
	 * Sets up the page number label and textfield for if the user wants to create a footnote.
	 * @param x
	 */
	public void setupFootnote(boolean x){
		if(x == true)
		{
			bookBase.add(pageNum); 
			bookBase.add(pageNumber); 
		
			spring.putConstraint(SpringLayout.SOUTH, pageNumber, 105, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, pageNumber, 190, SpringLayout.WEST, author);
		
			spring.putConstraint(SpringLayout.SOUTH, pageNum, 125, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, pageNum, 190, SpringLayout.WEST, author);
		} else {
			bookBase.remove(pageNum);
			bookBase.remove(pageNumber);
		}
	}
/**
 * 	Clears all of the data in the textfields.
 */
	public void clear(){
		fName.setText("");
		mInit.setText("");
		lName.setText("");
		title.setText("");
		publishYear.setText("");
		pageNum.setText("");
		
		if(storage.contains("b")){
			publisherName.setText("");
			publishCity.setText("");
		}
		
		if(storage.contains("v")){
			journalV.setText("");
			journalN.setText("");
		}
		
		if(storage.contains("a")){
			articleTitle.setText("");
		}
		
		if(storage.contains("d")){
			publishDate.setText("");
		}
		
		if(storage.contains("e")){
			editorTranslator.setText("");
		}
		
		if(storage.contains("u")){
			URLText.setText("");
		}
	}

/**
 * 	Returns a panel representation of the component in question.
 * @param s 
 * @return
 */
	public JPanel returnJPanel(String s){
		bookComponents();
		bookBaseSetUp();
		return bookBase;
	}
/**
 * Returns the string representing the type of citation being used.
 * Ex: "book", "newspaper".
 * @return
 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @param b determines if the generated citation is one for a footnote or not.
	 * @return
	 */
	public String generateCitation(boolean b){
		String cite ="";//the string to be returned.
		String s = ""; //stores the first name, last name and middle initial of the author.
		/*
		 * This sets up the initial data about the author name.
		 */
		if(b == false){ //if it is not a footnote
			
			if(!mInit.equals("")){
				s = lName.getText()+", "+fName.getText()+" "+mInit.getText()+". ";
				cite+=s;
			}else{
				s = lName.getText()+", "+fName.getText()+". ";
				cite+=s;
			}
		}else{ //if it is a footnote
			if(!mInit.equals("")){
				s = fName.getText()+" "+mInit.getText()+". "+lName.getText()+", ";
				cite+=s;
			}else{
				s = fName.getText()+" "+lName.getText()+", ";
				cite+=s;
			}
		}
		
		//The main setup for creating the citation string.
		if(getType() == "Chapter In Book"){ //if the type is a chapter in a book
			if(b == false){
				cite+="\""+articleTitle.getText()+".\" "+" In "+title.getText()+
						", "+pageNum.getText()+". "+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+". ";
				
			}else if(b==true){
				cite+="\""+articleTitle.getText()+",\" "+" in "+title.getText()+
						" ("+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+"), "+pageNum.getText()+".";
			}
		} else if(getType() == "Newspaper"){ //if the type is a newspaper
			if(b == false){
				cite+="\""+articleTitle.getText()+",\" "+title.getText()+", "+ 
						publishDate.getText()+", "+publishYear.getText()+". "+
						URLText.getText();
			}else{
				cite+="\""+articleTitle.getText()+",\" "+title.getText()+", "+ 
						publishDate.getText()+", "+publishYear.getText()+", "+
						URLText.getText()+"."+pageNum.getText()+". ";
			}
		} else if(getType() == "Website"){ //if the type is a website
			if(b == false){
				cite+="\""+articleTitle.getText()+".\" "+title.getText()+". Last modified "+ 
						publishDate.getText()+", "+publishYear.getText()+". "+
						URLText.getText()+".";

			}else{
				cite+="\""+articleTitle.getText()+",\" "+title.getText()+", last modified "+
						publishDate.getText()+", "+publishYear.getText()+". "+
						URLText.getText()+".";
			}
					
		} else if(getType() == "Book with Editor/Translator"){ //if the type has an editor/translator
			if(b == false){
				cite+=title.getText()+". Edited by "+editorTranslator.getText()+". "+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+". ";
			}else{
				cite+=title.getText()+". ed. "+editorTranslator.getText()+" ("+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+"), "+pageNum.getText()+". ";
			}
		} else if(getType() == "Encyclopedia"){	//if the type is an encyclopedia entry
			if(b == false){
				cite+="\""+articleTitle.getText()+".\" In "+title.getText()+
						". "+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+"), ";
			}else{
				cite+="\""+articleTitle.getText()+",\" In "+title.getText()+
						" ("+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+"), "+pageNum.getText()+". ";
			}
		} else if(getType() == "Online Journal"){ //if the type is an online journal
			String url = (URLText.getText().contains("http"))? URLText.getText():"doi "+URLText.getText();
			if(b == false){
				cite+="\""+articleTitle.getText()+".\" "+title.getText()+" "+journalV.getText()+", no."+journalN.getText()+
				" ("+publishDate.getText()+" "+publishYear.getText()+"): "+pageNum.getText()+". "+url;
			}else{
				cite+="\""+articleTitle.getText()+",\" "+title.getText()+" "+journalV.getText()+", no."+journalN.getText()+
						" ("+publishDate.getText()+" "+publishYear.getText()+"): "+pageNum.getText()+". "+url+".";
			}
		} else if(getType() == "Offline Journal"){ //if the type is an offline journal
			if(b == false){
				cite+="\""+articleTitle.getText()+".\" "+title.getText()+" "+journalV.getText()+", no."+journalN.getText()+
				" ("+publishYear.getText()+"): "+pageNum.getText()+". ";
			}else{
				cite+="\""+articleTitle.getText()+",\" in "+title.getText()+" "+journalV.getText()+", no."+journalN.getText()+
						" ("+publishYear.getText()+"): "+pageNum.getText()+". ";
			}
		} else if(getType() == "Book"){ //if the type is nothing other than a regular book
			if(b == false){
				cite+=title.getText()+". "+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+".";
			}else{
				cite+=title.getText()+" ("+publishCity.getText()+": "+publisherName.getText()+", "
						+publishYear.getText()+"), "+pageNum.getText()+".";
			}
		}
		else
			return "ERROR";
		
		return cite;
	}
	
}
