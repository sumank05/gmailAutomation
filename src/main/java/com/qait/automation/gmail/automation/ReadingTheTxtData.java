package com.qait.automation.gmail.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class ReadingTheTxtData {


		//Reading data from the file
		   
		   public HashMap<String,String> readingDataFromTextFile() throws IOException
		   {
			   File file = new File("C:\\Users\\sumankumawat\\eclipse-workspace\\gmail.automation\\testdata\\Locators.txt"); 
			   
			   BufferedReader br = new BufferedReader(new FileReader(file)); 
			   HashMap<String,String> map = new HashMap<String,String>();
			   String st; 
			   while ((st = br.readLine()) != null) 
			   {
				   String[] aux = st.split("==");
				   
				   int length = aux.length;
				   System.out.println(length);
				   System.out.println(aux[0]);
	               System.out.println(aux[1]);
				   map.put(aux[0], aux[1]);
					   
				   }
			return map;
				   
				   
			   }
		   
		   public HashMap<String,String> readingDataFromYamlFile() throws IOException
		   {
			   File file1 = new File("C:\\Users\\sumankumawat\\eclipse-workspace\\gmail.automation\\testdata\\TestData.yml");
		       
			   // Yaml yaml = new Yaml();
			   BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
			   HashMap<String,String> map = new HashMap<String,String>();
			   String st1; 
			   while ((st1 = br1.readLine()) != null) 
			   {
				   String[] aux1 = st1.split("==");
				   
				   int length = aux1.length;
				   System.out.println(length);
				   System.out.println(aux1[0]);
	               System.out.println(aux1[1]);
				   map.put(aux1[0], aux1[1]);
					   
				   }
			return map;

			   
			  
			   
		   }
			  
			
			     
		// TODO Auto-generated method stub
		   
	}


