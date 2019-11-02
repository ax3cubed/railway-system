package com.example.onrail;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class CancelTicket extends Activity {
  
    Connection conn=null;
	java.sql.Statement stmt;
	ResultSet rs;
    Button cancel;
    EditText pnr;
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.cancel_ticket);
 
        cancel=(Button) findViewById(R.id.Cancel);
        pnr=(EditText) findViewById(R.id.pnr);
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new load().execute();
				//finish();
			}
		});
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
    
    
    @SuppressLint("NewApi")
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
	          pd = new ProgressDialog(CancelTicket.this);
	          pd.setTitle("Cancelling...");
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
				 try{
					 stmt = conn.createStatement();
				     String pnr1=pnr.getText().toString();
		
					 String sql = "DELETE FROM Bookedtickets " +
			                   "WHERE pnr = '"+pnr1+"'";
						 
					 stmt.executeUpdate(sql);
					 
			         runOnUiThread(new Runnable() {
					     @Override
					     public void run() {
					    	 Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_LONG).show();
					    }
					});
			      return 1;
					 }
				 catch(final Exception ex)
				 {
					 
					 runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
					    }
					});
					 return 2;
				 }
				//conn.close();
			}
			catch(Exception x)
			{
				x.printStackTrace();
				Toast.makeText(getApplicationContext(), x.getMessage(), Toast.LENGTH_LONG).show();
			}
			return 3;
		}
		
		protected void onPostExecute(Integer result) {
	          pd.dismiss();
	          if(result==1) {
	              Toast.makeText(CancelTicket.this,
	                  "Cancellation successfull.", Toast.LENGTH_LONG)
	                  .show();
	              runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 finish();
					    }
					});
	          } else if(result==2) {
	              Toast.makeText(CancelTicket.this,
	                      "Cancellation failed", Toast.LENGTH_LONG).show();
	          } else if(result==3) {
	              Toast.makeText(CancelTicket.this,
	                      "There was a problem Cancellation.",
	                      Toast.LENGTH_LONG).show();
	          }
	          
	      }
		
	}
	
    
    
    
    
}