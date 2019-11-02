package com.example.onrail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import com.example.onrail.RegisterActivity.load;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class BookActivity extends Activity{
	finalselectedclass fc=new finalselectedclass();
	finalselectedalt fca=new finalselectedalt();
	EditText mobile,name,age,email;
	String name1,age1;
	Connection conn=null;
	java.sql.Statement stmt;
	ResultSet rs;
	int seatno;
	TextView tv1;
	int deter;
	Intent i;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book);
		Button confirm;
		 tv1=(TextView) findViewById(R.id.booktv);
		email=(EditText) findViewById(R.id.editText3);
		mobile=(EditText) findViewById(R.id.editText4);
		name=(EditText) findViewById(R.id.edtText1);
		age=(EditText) findViewById(R.id.editText2);
		email.setText("null");
		
		confirm=(Button) findViewById(R.id.confirm);
		try{
		i=getIntent();
		deter=(Integer) i.getSerializableExtra("deter");
		//email.setText(""+fc.selname);
		  
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "1:"+e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		confirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//sms();
				new load().execute();
				new SendMail().execute();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	void sms()
	 {
		  String phoneNumber = mobile.getText().toString();
		    String message = "Your ticket for "+fc.selno+" "+fc.selname+" arriving on "+fc.selarr+" on seat number "+fc.availseat+" has been confirmed. Happy Journey ";

		    SmsManager smsManager = SmsManager.getDefault();
		    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
	 }
	  
	
	
	
	public class load extends AsyncTask<String, Void, Integer>
	{
    	ProgressDialog pd = null;
	      String error = null;
	      @SuppressWarnings("unused")
	      int result;

	      @SuppressLint("NewApi")
			protected void onPreExecute() {
	          // TODO Auto-generated method stub
	          super.onPreExecute();
	          pd = new ProgressDialog(BookActivity.this);
	          pd.setTitle("Booking ticket...");
	          pd.setMessage("Please wait...");
	          pd.setCancelable(false);
	          pd.show();
	      }
		protected Integer doInBackground(String... arg0) 
		{
			String username="sql434762";
			String pass="bA3*uR3%";
			try
			{
				Class.forName("com.mysql.jdbc.Driver");			
				conn = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql434762",username,pass);
				if(deter==1)
				{
					try{
						fc=(finalselectedclass) i.getSerializableExtra("asd");
						stmt = conn.createStatement();
						name1=name.getText().toString();
						age1=age.getText().toString();
						final String trainno=fc.selno.toString();
						final String trainname=fc.selname.toString();
						seatno=fc.availseat;
						int flag=0;
						String sql = "SELECT pnr FROM Bookedtickets";
						rs = stmt.executeQuery(sql);
						int rdm;
						do{
							rdm=random();
							while(rs.next()){
								if(rs.getInt("pnr")==rdm)
								{
									flag=0;
									break;
								}
								else
								{
									flag=1;
								}
							}
							rs.beforeFirst();
						}while(flag!=1);
						
						 sql = "INSERT INTO Bookedtickets " +
						           "VALUES ('"+rdm+"','"+name1+"', '"+age1+"', '"+trainno+"','"+trainname+"','"+seatno+"')";
						 
						stmt.executeUpdate(sql);
						SqlConnector con = new SqlConnector(BookActivity.this);
						seatno=seatno-1;
						final String hj=con.updatedb(trainno, seatno);
			
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								tv1.setText("TB.."+seatno+" "+hj);
								}
						});
						return 1;
					 }
					catch(final Exception ex)
					{
					 
					 runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 tv1.setText("2: "+ex.getMessage());
					    }
					});
					}
					
					 return 2;
				 }
				else
				{
					try{
						fca=(finalselectedalt) i.getSerializableExtra("asd1");
						stmt = conn.createStatement();
						name1=name.getText().toString();
						age1=age.getText().toString();
						final String trainno1=fca.selno1.toString();
						final String trainname1=fca.selname1.toString();
						final int seatno1=fca.availseat1;
						final String trainno2=fca.selno2.toString();
						final String trainname2=fca.selname2.toString();
						final int seatno2=fca.availseat2;
						int flag=0;
						String sql = "SELECT pnr FROM Bookedtickets";
						rs = stmt.executeQuery(sql);
						int rdm;
						do{
							rdm=random();
							while(rs.next()){
								if(rs.getInt("pnr")==rdm)
								{
									flag=0;
									break;
								}
								else
								{
									flag=1;
								}
							}
							rs.beforeFirst();
						}while(flag!=1);
						
						
						
			     
						 sql = "INSERT INTO Bookedtickets " +
						           "VALUES ('"+rdm+"','"+name1+"', '"+age1+"', '"+trainno1+"','"+trainname1+"','"+seatno1+"')";
					 
						stmt.executeUpdate(sql);
						
						sql = "SELECT pnr FROM Bookedtickets";
						rs = stmt.executeQuery(sql);
						
						do{
							rdm=random();
							while(rs.next()){
								if(rs.getInt("pnr")==rdm)
								{
									flag=0;
									break;
								}
								else
								{
									flag=1;
								}
							}
							rs.beforeFirst();
						}while(flag!=1);
						
						sql = "INSERT INTO Bookedtickets " +
						           "VALUES ('"+rdm+"','"+name1+"', '"+age1+"', '"+trainno2+"','"+trainname2+"','"+seatno2+"')";
						stmt.executeUpdate(sql);
				 
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								tv1.setText("alt Ticket Booked..."+trainname1);
								}
						});
						return 1;
					}
					catch(final Exception ex)
					{
				 
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
				    	 tv1.setText("2: "+ex.getMessage());
				    }
				});
				}
				
				 return 2;
				}
				//conn.close();
			}
			catch(Exception x)
			{
				x.printStackTrace();
				tv1.setText(x.getMessage()+"1");
			}
			return 3;
		}
		
		protected void onPostExecute(Integer result) {
	          pd.dismiss();
	          if(result==1) {
	              Toast.makeText(BookActivity.this,
	                  "Booking successfull.", Toast.LENGTH_LONG)
	                  .show();
	              runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 //finish();
					    	 Intent i = new Intent(BookActivity.this, MainActivity.class);
				                startActivity(i);
					    }
					});
	          } else if(result==2) {
	              Toast.makeText(BookActivity.this,
	                      "Booking failed", Toast.LENGTH_LONG).show();
	          } else if(result==3) {
	              Toast.makeText(BookActivity.this,
	                      "There was a problem booking your ticket.",
	                      Toast.LENGTH_LONG).show();
	          }
	          
	      }
		
	}
	
    
    
	int random()
	{
		Random rand=new Random();
		int i=(1 + rand.nextInt(9)) * 10000 + rand.nextInt(10000);
		return i;
	}
	
	
	
	
	
	  private class SendMail extends AsyncTask<String, Void, Integer> 
	  { 
	      ProgressDialog pd = null;
	      String error = null;
	      @SuppressWarnings("unused")
			Integer result;

	      @SuppressLint("NewApi")
			protected void onPreExecute() {
	          // TODO Auto-generated method stub
	          super.onPreExecute();
	          pd = new ProgressDialog(BookActivity.this);
	          pd.setTitle("Sending Mail");
	          pd.setMessage("Please wait...");
	          pd.setCancelable(false);
	          pd.show();
	      }

	      protected Integer doInBackground(String... params) { 
	          // TODO Auto-generated method stub 
	    	  EditText email=(EditText) findViewById(R.id.editText3);
	          MailSender sender = new MailSender("aswani.ketan@gmail.com", "ket10Ani"); 

	          sender.setTo(new String[]{email.getText().toString()});
	          sender.setFrom("aswani.ketan@gmail.com");
	          sender.setSubject("Ticket Confirmed");
	          if(deter==1)
	        	  sender.setBody("Your ticket for "+fc.selno+" "+fc.selname+" arriving on "+fc.selarr+" on seat number "+fc.availseat+" has been confirmed. Happy Journey ");
	          else
	        	  sender.setBody("Your ticket alternate has been confirmed. Happy Journey ");
	          try {
	              if(sender.send()) {
	                  System.out.println("Message sent");
	                  return 1;
	              } else {
	                  return 2;
	              }
	          } catch (Exception e) {   
	              error = e.getMessage();
	              Log.e("SendMail", e.getMessage(), e);    
	          }

	          return 3; 
	      } 

	      protected void onPostExecute(Integer result) {
	          pd.dismiss();
	          if(error!=null) {
	              //textView1.setText(error);
	          }
	          if(result==1) {
	              Toast.makeText(BookActivity.this,
	                  "Email was sent successfully.", Toast.LENGTH_LONG)
	                  .show();
	          } else if(result==2) {
	              Toast.makeText(BookActivity.this,
	                      "Email was not sent.", Toast.LENGTH_LONG).show();
	          } else if(result==3) {
	              Toast.makeText(BookActivity.this,
	                      "There was a problem sending the email.",
	                      Toast.LENGTH_LONG).show();
	          }
	      }
	  }   
	  

	
}
