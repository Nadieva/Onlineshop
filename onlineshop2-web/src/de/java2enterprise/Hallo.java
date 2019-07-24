package de.java2enterprise;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Hallo extends SimpleTagSupport{
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;	
	}
	
	@Override
	public void doTag() throws JspException,IOException {
		JspContext jspContext = getJspContext();
		JspWriter jspWriter= jspContext.getOut();
		jspWriter.println("<h1>Hallo" +name +"</h1>");
	}
}