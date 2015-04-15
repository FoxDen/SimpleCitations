import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


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
	
	private String type;	
	JPanel bookBase;

	public JTextField URLText;
	public JTextField fName;
	public JTextField lName;
	public JTextField mInit;
	public JTextField title;
	public JTextField articleTitle;
	public JTextField publisherName;
	public JTextField publishCity;
	public JTextField publishYear;
	public JTextField editorTranslator;
	public JTextField pageNum;
	public JTextField journalV;
	public JTextField journalN;
	
	SpringLayout spring = new SpringLayout();

	
	public bookClass(String type) {
		type = this.type;
	}
	
	public void bookComponents(){
		
		bookBase = new JPanel();
		bookBase.setLayout(spring);		
		author = new JLabel("Author");
		fName = new JTextField("",FIELDLENGTH);
		lName = new JTextField("",FIELDLENGTH);
		mInit = new JTextField("",1);
		
		titleOfBook = new JLabel("Title");
		title = new JTextField("",FIELDLENGTH);
		
		publisher = new JLabel("Publisher");
		
		publishCity = new JTextField("",FIELDLENGTH);
		publisherName = new JTextField("",FIELDLENGTH);
		publishYear = new JTextField("",FIELDLENGTH);
		
		titleOfArticle = new JLabel("Article/Chapter Title");
		articleTitle = new JTextField("",FIELDLENGTH);
		URLText = new JTextField("",FIELDLENGTH);
		URL = new JLabel("URL");
		pageNum = new JTextField("", 5);
		
		
		bookBase.add(fName);
		bookBase.add(lName);
		bookBase.add(mInit);
		bookBase.add(publisherName);
		bookBase.add(publishCity);
		bookBase.add(publishYear);
		bookBase.add(title);
		
		bookBase.add(author);
		bookBase.add(publisher);
		bookBase.add(titleOfBook);
		bookBase.add(pageNum);
		
		if(type == "Online Journal" || type == "Offline Journal"){
			journalVolume = new JLabel("Vol.");
			journalNumber = new JLabel("Number");
			journalV = new JTextField("", 3);
			journalN = new JTextField("", 3);
			
			bookBase.add(titleOfArticle);
			bookBase.add(articleTitle);
			
			bookBase.add(URL);
			bookBase.add(URLText);

		} else if(type == "Chapter"){
			
			bookBase.add(titleOfArticle);

		} else if(type == "Editor"){
			editorOrTranslator = new JLabel("Editor Or Translator");
			editorTranslator = new JTextField("",FIELDLENGTH);
			
			bookBase.add(editorOrTranslator);
			bookBase.add(editorTranslator);
			
		} 
	}
	
	
	public void bookBaseSetUp(String s){
			
		spring.putConstraint(SpringLayout.SOUTH, fName, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, fName, 10, SpringLayout.WEST, author);

		spring.putConstraint(SpringLayout.SOUTH, lName, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, lName, 180, SpringLayout.WEST, fName);
		
		spring.putConstraint(SpringLayout.SOUTH, mInit, 20, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, mInit, 180, SpringLayout.WEST, lName);


		spring.putConstraint(SpringLayout.SOUTH, publisher, 50, SpringLayout.SOUTH, author);
		spring.putConstraint(SpringLayout.WEST, publisherName, 10, SpringLayout.WEST, publisher);
		spring.putConstraint(SpringLayout.SOUTH, publisherName, 20, SpringLayout.SOUTH, publisher);
		
		spring.putConstraint(SpringLayout.SOUTH, publishCity, 20, SpringLayout.SOUTH, publisher);
		spring.putConstraint(SpringLayout.WEST, publishCity, 190, SpringLayout.WEST, publisher);

		spring.putConstraint(SpringLayout.SOUTH, publishYear, 20, SpringLayout.SOUTH, publisher);
		spring.putConstraint(SpringLayout.WEST, publishYear, 370, SpringLayout.WEST, publisher);
		
		
		spring.putConstraint(SpringLayout.SOUTH, titleOfBook, 50, SpringLayout.SOUTH, publisher);
		spring.putConstraint(SpringLayout.SOUTH, title, 20, SpringLayout.SOUTH, titleOfBook);
		spring.putConstraint(SpringLayout.WEST, title, 10, SpringLayout.WEST, titleOfBook);

		spring.putConstraint(SpringLayout.SOUTH, pageNum, 60, SpringLayout.SOUTH, titleOfBook);
		spring.putConstraint(SpringLayout.WEST, pageNum, 10, SpringLayout.WEST, titleOfBook);
		
		if(s=="Chapter"){
			spring.putConstraint(SpringLayout.SOUTH, titleOfArticle, 120, SpringLayout.SOUTH, author);

		} else if(s== "Online Journal" || s == "Offline Journal"){
			spring.putConstraint(SpringLayout.SOUTH, c1, pad, e2, c2);
		}
	}
	
	
	public JPanel returnJPanel(){
		bookComponents();
		
		bookBaseSetUp(type);
		return bookBase;
		
	}
}
