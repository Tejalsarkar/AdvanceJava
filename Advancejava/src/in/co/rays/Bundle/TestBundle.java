package in.co.rays.Bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.Bundle.app",new Locale("hi"));
		System.out.println(rb.getString("greeting"));
		System.out.println(rb.getString("Driver"));
		System.out.println(rb.getString("Url"));
		System.out.println(rb.getString("User"));
		System.out.println(rb.getString("Password"));
		System.out.println(Integer.parseInt(rb.getString("Acquire")));
		System.out.println(Integer.parseInt(rb.getString("Initial")));
		System.out.println(Integer.parseInt(rb.getString("Maximum")));
	}

}
