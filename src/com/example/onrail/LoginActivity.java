package com.example.onrail;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.example.onrail.RegisterActivity.load;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class LoginActivity extends Activity {
    
    Connection conn=null;
	java.sql.Statement stmt;
	ResultSet rs;
	TextView tv1;
	EditText ledmail,ledpass;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.login);
        Button login;
        login=(Button)findViewById(R.id.btnLogin);
        ledmail=(EditText) findViewById(R.id.edtText1);
        tv1 = (TextView) findViewById(R.id.textv);
        ledpass=(EditText) findViewById(R.id.loginpassword);
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
 
        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
        	 
            public void onClick(View v) {
                // Switching to main screen
            	Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            	//new load().execute();
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
	      String passw;

	      @SuppressLint("NewApi")
			protected void onPreExecute() {
	          // TODO Auto-generated method stub
	          super.onPreExecute();
	          pd = new ProgressDialog(LoginActivity.this);
	          pd.setTitle("Logging in...");
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
					 String loginmail=ledmail.getText().toString();
					 final String loginpass=ledpass.getText().toString();
					 String sql = "SELECT password FROM login" +
			                   " WHERE mailid = '"+loginmail+"'";
					 rs = stmt.executeQuery(sql);
					 rs.first();
					 //while(rs.next()){
					 passw = rs.getString("password");
					 /*runOnUiThread(new Runnable() {
					     @Override
					     public void run() {
					    	 //stuff that updates ui
					    	 tv1.setText(""+passw);
					    	 ledmail.setText(""+loginpass);
					    }
					});*/
					 //}
			         if(passw.equals(loginpass))
			        	 return 1;
			         else
			        	 return 2;
					 }
				 catch(final Exception ex)
				 {
					 
					 runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 tv1.setText("2: "+ex.getMessage());
					    }
					});
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
	              Toast.makeText(LoginActivity.this,
	                  "Login successfull.", Toast.LENGTH_LONG)
	                  .show();
	              runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 Intent i = new Intent(getApplicationContext(), MainActivity.class);
				                startActivity(i);
					    }
					});
	          } else if(result==2) {
	              Toast.makeText(LoginActivity.this,
	                      "Email or password incorrect", Toast.LENGTH_LONG).show();
	          } else if(result==3) {
	              Toast.makeText(LoginActivity.this,
	                      "There was a problem login.",
	                      Toast.LENGTH_LONG).show();
	          }
	          
	      }
    
	}
}