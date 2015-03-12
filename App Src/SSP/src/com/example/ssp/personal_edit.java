package com.example.ssp;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toast;


public class personal_edit extends Activity {

	//File file = new File(this.getFilesDir(), "name.txt");
	TextView tpe2,tpe4,tpe6,tpe8,tpe10;
	Button be;
	private final static String STORENAME="name.txt";
	
	private static final String TAG = personal_edit.class.getName();
	//private static final String FILENAME = "myFile.txt";
	
	private final static String STOREAGE="age.txt";
	private final static String STOREDISEASE="disease.txt";
	private final static String STOREDOCTOR_NUMBER="doctor_number.txt";
	private final static String STOREFIRST_AID="first_aid.txt";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_edit_xml);
		
		tpe2 = (TextView) findViewById(R.id.textView_personal_edit_2);
		tpe4 = (TextView) findViewById(R.id.textView_personal_edit_4);
		tpe6 = (TextView) findViewById(R.id.textView_personal_edit_6);
		tpe8 = (TextView) findViewById(R.id.textView_personal_edit_8);
		tpe10 = (TextView) findViewById(R.id.textView_personal_edit_10);
		be = (Button) findViewById(R.id.button_personal_edit_1);
		
		
		be.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				writeToFile(tpe2.getText().toString(),STORENAME);
				writeToFile(tpe4.getText().toString(),STOREAGE);
				writeToFile(tpe6.getText().toString(),STOREDISEASE);
				writeToFile(tpe8.getText().toString(),STOREDOCTOR_NUMBER);
				writeToFile(tpe10.getText().toString(),STOREFIRST_AID);
				//saveClicked();
				startActivity(new Intent("com.example.ssp.PERSONAL"));
				
			}

			private void writeToFile(String data,String m) {
		        try {
		            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(m, Context.MODE_PRIVATE));
		            outputStreamWriter.write(data);
		            outputStreamWriter.close();
		        }
		        catch (IOException e) {
		            Log.e(TAG, "File write failed: " + e.toString());
		        } 
				
			}
			
			
			/*public void saveClicked() {

				try {

				OutputStreamWriter outname = new OutputStreamWriter(openFileOutput(STORENAME, 0));
				outname.write(tpe2.getText().toString());
				outname.close();
				OutputStreamWriter outage = new OutputStreamWriter(openFileOutput(STOREAGE, 0));
				outage.write(tpe4.getText().toString());
				outage.close();
				OutputStreamWriter outdisease = new OutputStreamWriter(openFileOutput(STOREDISEASE, 0));
				outdisease.write(tpe6.getText().toString());
				outdisease.close();
				OutputStreamWriter outdoctor_number = new OutputStreamWriter(openFileOutput(STOREDOCTOR_NUMBER, 0));
				outdoctor_number.write(tpe8.getText().toString());
				outdoctor_number.close();
				OutputStreamWriter outfirst_aid = new OutputStreamWriter(openFileOutput(STOREFIRST_AID, 0));
				outfirst_aid.write(tpe10.getText().toString());
				outfirst_aid.close();
				

				}

				catch (Throwable t) {
				
				}

			}

			
		});
	}
	*/
	




/*private void createFile(String Text){

	File file_name = new File(this.getFilesDir(), "name.txt");
	FileOutputStream fos=null;
	try {
		fos=openFileOutput("name.txt", MODE_PRIVATE);
		fos.write(Text.getBytes());
		Toast.makeText(getApplicationContext(), "File created succesfully", Toast.LENGTH_SHORT).show();
	} catch (FileNotFoundException e) {
		 Log.e("CreateFile", e.getLocalizedMessage());
	}
	catch (IOException e) {
		 Log.e("CreateFile", e.getLocalizedMessage());
	}

	finally{
		if(fos!=null){
			try {
				// drain the stream
				fos.flush();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

		});
	}
	
}