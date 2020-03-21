package controller;

public class ResourceNotFoundException extends Exception {

	ResourceNotFoundException(String string)
	{
		System.out.println(string);
	}
}
