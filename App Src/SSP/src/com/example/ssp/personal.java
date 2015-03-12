package com.example.ssp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class personal extends Activity {

	TextView tp2,tp4,tp6,tp8,tp10;
	Button b;
	
	private static final String TAG = personal.class.getName();
	private final static String STORENAME="name.txt";
	private final static String STOREAGE="age.txt";
	private final static String STOREDISEASE="disease.txt";
	private final static String STOREDOCTOR_NUMBER="doctor_number.txt";
	private final static String STOREFIRST_AID="first_aid.txt";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_xml);
		///readFileInEditor();
		
		String textFromFileStringName =  readFromFile(STORENAME);
		String textFromFileStringAge =  readFromFile(STOREAGE);
		String textFromFileStringDiesease =  readFromFile(STOREDISEASE);
		String textFromFileStringDoctorNumber =  readFromFile(STOREDOCTOR_NUMBER);
		String textFromFileStringFirstAid =  readFromFile(STOREFIRST_AID);
		tp2 = (TextView) findViewById(R.id.textView_personal_2);
		tp4 = (TextView) findViewById(R.id.textView_personal_4);
		tp6 = (TextView) findViewById(R.id.textView_personal_6);
		tp8 = (TextView) findViewById(R.id.textView_personal_8);
		tp10 = (TextView) findViewById(R.id.textView_personal_10);
		b = (Button) findViewById(R.id.button_personal_1);
		
		tp2.setText(textFromFileStringName);
		tp4.setText(textFromFileStringAge);
		tp6.setText(textFromFileStringDiesease);
		tp8.setText(textFromFileStringDoctorNumber);
		tp10.setText(textFromFileStringFirstAid);
		
		
		
		b.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.ssp.PERSONAL_EDIT"));
				
			}
			
			
		});
		
		
	}

	
private String readFromFile(String n) {
		
        String ret = "";
        
        try {
            InputStream inputStream = openFileInput(n);
            
            if ( inputStream != null ) {
            	InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            	String receiveString = "";
            	StringBuilder stringBuilder = new StringBuilder();
            	
            	while ( (receiveString = bufferedReader.readLine()) != null ) {
            		stringBuilder.append(receiveString);
            	}
            	
            	inputStream.close();
            	ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
        	Log.e(TAG, "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e(TAG, "Can not read file: " + e.toString());
		}

        return ret;
	}
	
	
	
	/*public void readFileInEditor() {
		// TODO Auto-generated method stub
		
		
		try {
		 
		FileInputStream fin = openFileInput(STORENAME);
		//if (fin != null) {
		//InputStreamReader tmp=new InputStreamReader(fin);
		//BufferedReader reader=new BufferedReader(tmp);
		//String str;
		//StringBuilder buf=new StringBuilder();
		 
		//while ((str = reader.readLine()) != null) {
		 
		///buf.append(str+"n");
		 
		//}
		
		byte[] reader=new byte[fin.available()];
		while (fin.read(reader)!=-1) {

		}
	    tp2.setText(new String(reader));
		 
		fin.close();
		//tp2.setText(buf.toString());
		 
		
		 
		}
		 
		catch (java.io.FileNotFoundException e) {
		 
		}
		 
		catch (Throwable t) {
		 
		
		 
		}
		 
		
		
		
	}*/
	
	
	
	

}
