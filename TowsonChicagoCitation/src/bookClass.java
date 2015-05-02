import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 ***************************TO DO***************************
 *add tooltips
 *add comments
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
	JTextField pageNum = new JTextField("i", 5);
	
	SpringLayout spring = new SpringLayout();

	public bookClass(String t) {
		type = t;
	}
/**
 * 	
 */
	public void bookComponents(){
		
		bookBase = new JPanel();
		bookBase.setLayout(spring);		
		
		author = new JLabel("Author");
		fName = new JTextField("a",FIELDLENGTH);
		lName = new JTextField("b",FIELDLENGTH);
		mInit = new JTextField("c",1);
		titleOfBook = new JLabel("Title");
		year = new JLabel("Year");
		publishYear = new JTextField("1999", 4);
		
		title = new JTextField(getType(),FIELDLENGTH);
		publisherName = new JTextField("e",FIELDLENGTH);
		URLText = new JTextField("h",FIELDLENGTH);
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
		articleTitle = new JTextField("Article",FIELDLENGTH);
		
		if(getType() == "Online Journal" || getType() == "Offline Journal"){
			journalVolume = new JLabel("Vol.");
			titleOfBook.setText("Journal");
			journalNumber = new JLabel("Number");
			journalV = new JTextField("Vol", 3);
			journalN = new JTextField("Num", 3);
			date = new JLabel("Month/Season published");
			publishDate = new JTextField("Summer",10);
			titleOfArticle.setText("Article");
		
			bookBase.add(titleOfArticle);
			bookBase.add(articleTitle);
			bookBase.add(journalVolume);
			bookBase.add(journalNumber);
			bookBase.add(journalV);
			bookBase.add(journalN);
			bookBase.add(date);
			bookBase.add(publishDate);
			
			if(getType() == "Online Journal"){
				bookBase.add(URL);
				bookBase.add(URLText);
				
				storage+="u ";
			}
			storage+="a v d p ";

		} 
		
		if(getType() == "Chapter In Book" || getType() == "Book" || getType() == "Book with Editor/Translator" || getType() == "Encyclopedia"){
			publisher = new JLabel("Publisher");
			city = new JLabel("City");
			publishCity = new JTextField("City", FIELDLENGTH);
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
				bookBase.add(titleOfArticle);
				articleTitle = new JTextField("g",FIELDLENGTH);
				bookBase.add(articleTitle);
				
				storage+="a ";
			}
			
			if (getType() == "Encyclopedia"){
				titleOfBook.setText("Encyclopedia");
				
				storage+="a ";
			}

		} 
		
		if (getType() == "Newspaper" || getType() == "Website"){
			bookBase.add(URL);
			bookBase.add(URLText);
			bookBase.add(titleOfArticle);
			titleOfArticle.setText("Article");
			articleTitle = new JTextField("g",FIELDLENGTH);
			bookBase.add(articleTitle);
			
			titleOfBook.setText((getType()=="Newspaper")? "Newspaper":"Website");
			
			publishDate = new JTextField("",10);
			date = new JLabel("Published On");
			
			storage+="u d a ";
		}
	}
/**
 * 	
 */
	public void bookBaseSetUp(){
		//sets up things in general
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
 * 		
 */
	public void clear(){
		fName.setText("");
		mInit.setText("");
		lName.setText("");
		title.setText("");
		publishYear.setText("");
		
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
			editorOrTranslator.setText("");
		}
		
		if(storage.contains("u")){
			URLText.setText("");
		}
	}
/**
 * 
 */
	public void setUppageNum(){
			bookBase.add(pageNum); //textfield
			bookBase.add(pageNumber); //label
		
			spring.putConstraint(SpringLayout.SOUTH, pageNumber, 105, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, pageNumber, 190, SpringLayout.WEST, author);
			
			spring.putConstraint(SpringLayout.SOUTH, pageNum, 125, SpringLayout.WEST, author);
			spring.putConstraint(SpringLayout.WEST, pageNum, 190, SpringLayout.WEST, author);

		}
/**
 * 
 */
	public void removepageNum(){

			bookBase.remove(pageNum);
			bookBase.remove(pageNumber);
	}
/**
 * 	
 * @param s
 * @return
 */
	public JPanel returnJPanel(String s){
		bookComponents();
		bookBaseSetUp();
		return bookBase;
	}
/**
 * 
 * @return
 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public String generateFootCitation(boolean b){
		String cite = "";
		if(mInit.getText()==""){		
			cite+=fName.getText()+" "+lName.getText()+", ";
		}else
			cite+=fName.getText()+" "+mInit.getText()+". "+lName.getText()+", ";

		if(getType() == "Chapter In Book"){ //if the type is a chapter in a book
			if(b == false){
				
			}else{
				cite+="\""+articleTitle.getText()+",\" in "+title.getText()+
						" ("+publishCity.getText()+":"+publisher.getText()+", "
						+publishYear.getText()+"), ";
			}
		} else if(getType() == "Newspaper"){ //if the type is a newspaper
			if(b == false){
				
			}else{
				cite+="\""+articleTitle.getText()+",\" "+title.getText()+", "+ 
						publishDate.getText()+", "+publishYear.getText()+". "+
						URLText.getText()+"."+pageNumber.getText()+". ";
			}
		} else if(getType() == "Website"){ //if the type is a website
			if(b == false){
				
			}else{
				cite+="\""+articleTitle.getText()+",\" "+title.getText()+", last modified "+
						publishDate.getText()+", "+publishYear.getText()+". "+
						URLText.getText()+"."+pageNumber.getText()+". ";
			}
					
		} else if(getType() == "Book with Editor/Translator"){ //if the type has an editor/translator
			if(b == false){
				
			}else{
			cite+="ed.,"+title.getText()+" ("+publishCity.getText()+":"+publisher.getText()+", "
					+publishYear.getText()+"), "+pageNumber.getText()+". ";
			}
		} else if(getType() == "Encyclopedia"){	//if the type is an encyclopedia entry
			if(b == false){
				
			}else{
			cite+="\""+articleTitle.getText()+",\" In "+title.getText()+
					" ("+publishCity.getText()+":"+publisher.getText()+", "
					+publishYear.getText()+"), "+pageNumber.getText()+". ";
			}
		}else if(getType() == "Online Journal"){ //if the type is an online journal
			if(b == false){
				
			}else{
			cite+="\""+articleTitle.getText()+",\" in "+title.getText()+" "+journalV.getText()+", no."+journalN.getText()+
					"("+publishYear.getText()+"): "+pageNumber.getText()+". ";
			}
		}else if(getType() == "Offline Journal"){ //if the type is an offline journal
			if(b == false){
				
			}else{
			cite+="\""+articleTitle.getText()+",\" in "+title.getText()+" "+journalV.getText()+", no."+journalN.getText()+
					"("+publishYear.getText()+"): "+pageNumber.getText()+". "+URLText.getText();
			}
		}else { //if the type is nothing other than a regular book
			if(b == false){
				
			}else{
			cite+=title.getText()+" ("+publishCity.getText()+":"+publisher.getText()+", "
				+publishYear.getText()+"), ";
			}
		}
		return cite;
	}
	
}
