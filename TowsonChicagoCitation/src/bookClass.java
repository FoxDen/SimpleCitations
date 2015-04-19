import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 ***************************TO DO***************************
 *add tooltips
 *Create the worker class
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
	public JTextField pageNum;
	public JTextField journalV;
	public JTextField journalN;
	
	SpringLayout spring = new SpringLayout();

	public bookClass(String t) {
		type = t;
	}
	
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
		
		title = new JTextField(type,FIELDLENGTH);
		publisherName = new JTextField("e",FIELDLENGTH);
		URLText = new JTextField("h",FIELDLENGTH);
		URL = new JLabel("URL");
		pageNum = new JTextField("i", 5);

				
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
		
		if(type == "Online Journal" || type == "Offline Journal"){
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
			
			if(type == "Online Journal"){
				bookBase.add(URL);
				bookBase.add(URLText);
				
				storage+="u ";
			}
			storage+="a v d p ";

		} 
		
		if(type == "Chapter In Book" || type == "Book" || type == "Book with Editor/Translator" || type == "Encyclopedia"){
			publisher = new JLabel("Publisher");
			city = new JLabel("City");
			publishCity = new JTextField("City", FIELDLENGTH);
			publisherName = new JTextField("", FIELDLENGTH);
			bookBase.add(publisherName);
			bookBase.add(publishCity);
			bookBase.add(publisher);
			bookBase.add(city);
			storage+="b ";
			if(type == "Book with Editor/Translator"){
				editorOrTranslator = new JLabel("Editor/Translator");
				editorTranslator = new JTextField("",FIELDLENGTH);
				
				bookBase.add(editorOrTranslator);
				bookBase.add(editorTranslator);
				
				storage+="e ";
			} 
			
			if (type == "Chapter In Book"){
				bookBase.add(titleOfArticle);
				articleTitle = new JTextField("g",FIELDLENGTH);
				bookBase.add(articleTitle);
				
				storage+="a ";
			}
			
			if (type == "Encyclopedia"){
				titleOfBook.setText("Encyclopedia");
				
				storage+="a ";
			}
		} 
		
		if (type == "Newspaper" || type == "Website"){
			bookBase.add(URL);
			bookBase.add(URLText);
			bookBase.add(titleOfArticle);
			titleOfArticle.setText("Article");
			articleTitle = new JTextField("g",FIELDLENGTH);
			bookBase.add(articleTitle);
			
			titleOfBook.setText((type=="Newspaper")? "Newspaper":"Website");
			
			publishDate = new JTextField("",10);
			date = new JLabel("Published On");
			
			storage+="u d a ";
		}
	}
	
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
			
			//setUpPageNum();
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
		
	public void setUppageNum(){
		bookBase.add(pageNum);
		bookBase.add(new JLabel("Page Numbers"));
		spring.putConstraint(SpringLayout.SOUTH, pageNum, 155, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, pageNum, 300, SpringLayout.WEST, author);
	}
	
	public JPanel returnJPanel(String s){
		bookComponents();
		bookBaseSetUp();
		return bookBase;
	}
	
}
