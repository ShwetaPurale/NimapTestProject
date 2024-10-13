package com.example.NimapTest1SpringBoot.exception;

public class InvalidProduct extends Exception {
	
	public InvalidProduct(String errorMsg)
	{
		super(errorMsg);
	}

}
