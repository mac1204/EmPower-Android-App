package com.example.ssp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;




import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;

public class MainActivity extends Activity {

	double clat,clon,clat1,clon1;
	String message1,message2;
	private static final String TAG = personal.class.getName();
	private final static String STOREDOCTOR_NUMBER="doctor_number.txt";
	private final static String STORENAME="name.txt";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//final TextView t;
		//t = (TextView) findViewById(R.id.textviewmac);
		final MainActivity cont = this;
		Button b0;
		b0 = (Button) findViewById(R.id.button0);
		
		b0.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendsms();
				sendsms();
				
			}

			public void sendsms() {
				// TODO Auto-generated method stub
				String cord;
				String phoneNumber = readFromFile(STOREDOCTOR_NUMBER);
				if(Loadcord() == null){
					//cord = Loadcord_net();
					clat1 = 26.935423;
					clon1 = 75.924216;
					cord = "Latitude : "  + Double.toString(clat1) + " Longitude : " + Double.toString(clon1);
				}
				else
					cord = Loadcord();
			    String message = "Emergency: " + readFromFile(STORENAME) + " " + cord;

			    SmsManager smsManager = SmsManager.getDefault();
			    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
			    
			    ContentValues values = new ContentValues(); 
	              
			    values.put("address", phoneNumber); 
			              
			    values.put("body", message); 
			              
			    getContentResolver().insert(Uri.parse("content://sms/sent"), values);
		        
		        
			    //t.setText(message);
				
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
			
		
			private String Loadcord_net() {
				
				
				final LocationManager locationmanager = (LocationManager) cont.getSystemService(Context.LOCATION_SERVICE);
				LocationListener listener = new LocationListener(){

					@Override
					public void onLocationChanged(Location location) {
						// TODO Auto-generated method stub
						
						clat1 =  locationmanager.getLastKnownLocation("network").getLatitude();
						clon1 =  locationmanager.getLastKnownLocation("network").getLongitude();
						
						message2 = "Latitude : "  + Double.toString(clat1) + " Longitude : " + Double.toString(clon1);
						
							
						
					}

					@Override
					public void onProviderDisabled(String provider) {
						// TODO Auto-generated method stub
						/*clat1 =  locationmanager.getLastKnownLocation("network").getLatitude();
						clon1 =  locationmanager.getLastKnownLocation("network").getLongitude();
						
						message2 = "Latitude : "  + Double.toString(clat1) + " Longitude : " + Double.toString(clon1);
						*/
						
					}

					@Override
					public void onProviderEnabled(String provider) {
						// TODO Auto-generated method stub
						/*
						clat1 =  locationmanager.getLastKnownLocation("network").getLatitude();
						clon1 =  locationmanager.getLastKnownLocation("network").getLongitude();
						
						message2 = "Latitude : "  + Double.toString(clat1) + " Longitude : " + Double.toString(clon1);*/
					}

					@Override
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
						// TODO Auto-generated method stub
						
					}
					
					
					
					
				};
				 locationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0/*(2*60*1000)*/,0,listener);
				 return message2;
			
			}
			
			
			
			private String Loadcord() {
				// TODO Auto-generated method stub
				
				
				final LocationManager locationmanager = (LocationManager) cont.getSystemService(Context.LOCATION_SERVICE);
				LocationListener listener = new LocationListener(){

					@Override
					public void onLocationChanged(Location location) {
						// TODO Auto-generated method stub
						
						clat =  locationmanager.getLastKnownLocation("gps").getLatitude();
						clon =  locationmanager.getLastKnownLocation("gps").getLongitude();
						
						message1 = "Latitude : "  + Double.toString(clat) + " Longitude : " + Double.toString(clon);
						
							
						
					}

					@Override
					public void onProviderDisabled(String provider) {
						// TODO Auto-generated method stub
					/*	clat =  locationmanager.getLastKnownLocation("gps").getLatitude();
						clon =  locationmanager.getLastKnownLocation("gps").getLongitude();
						
						message1 = "Latitude : "  + Double.toString(clat) + " Longitude : " + Double.toString(clon);
					*/	
						
					}

					@Override
					public void onProviderEnabled(String provider) {
						// TODO Auto-generated method stub
						/*
						clat =  locationmanager.getLastKnownLocation("gps").getLatitude();
						clon =  locationmanager.getLastKnownLocation("gps").getLongitude();
						
						message1 = "Latitude : "  + Double.toString(clat) + " Longitude : " + Double.toString(clon);*/
					}

					@Override
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
						// TODO Auto-generated method stub
						
					}
					
					
					
					
				};
				 locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0/*(2*60*1000)*/,0,listener);
				 return message1;
			
			}
			
			
			
		});
		

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.personal:
	            personal_java();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void personal_java() {
		// TODO Auto-generated method stub
		startActivity(new Intent("com.example.ssp.PERSONAL"));
	}

}
