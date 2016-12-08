import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	private int index;
	private Book book;
	private List<Book> bookList = new ArrayList<>();
	private String value;
	
	public List<Book> getBookList() {
		return bookList;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("=============开始解析文档==================");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("=============结束解析文档==================");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("book")) {
		    book = new Book();
			index++;
			System.out.println("=============开始解析第" + (index) + "本书==================");
			int id = Integer.valueOf(attributes.getValue("id"));
			book.setId(id);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName.equals("name")) {
			book.setName(value);
		} else if(qName.equals("author")) {
			book.setAuthor(value);
		} else if(qName.equals("year")) {
			book.setYear(value);
		} else if(qName.equals("price")) {
			book.setPrice(value);
		} else if(qName.equals("language")) {
			book.setLanguage(value);
		}  else if(qName.equals("book")) {
			bookList.add(book);
			book = null;
			System.out.println("=============结束解析第" + (index) + "本书==================");
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		value = new String(ch, start, length);
	}
}
