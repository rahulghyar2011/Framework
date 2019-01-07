package com.keyword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		  Class c= Keywords.class;
         Method[] allMethods=c.getDeclaredMethods();
       
         for (Method method : allMethods)
         {
        	 System.out.println(method.getName());
			 if(method.getName().equals("openBrowser"))
			 {
				method.invoke(new Keywords(),"Chrome"); 
			 }
		}
	}

}
