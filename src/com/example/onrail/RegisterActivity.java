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
 
public class RegisterActivity extends Activity {
  
    Connection conn=null;
	java.sql.Statement stmt;
	ResultSet rs;
	Button btn;
	TextView tv;
    EditText edname,edmail,edpass;
   
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);
        btn=(Button) findViewById(R.id.btnRegister);
        tv=(TextView) findViewById(R.id.regerr);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
        edname=(EditText) findViewById(R.id.reg_fullname);
        edmail=(EditText) findViewById(R.id.email);
        edpass=(EditText) findViewById(R.id.reg_password);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new load().execute();
				//finish();
			}
		});
        
        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                // Switching to Login Screen/closing register screen
                finish();
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
	          pd = new ProgressDialog(RegisterActivity.this);
	          pd.setTitle("Registering...");
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
				     String name=edname.getText().toString();
				     String mail=edmail.getText().toString();
				     String rpass=edpass.getText().toString();
					 String sql = "INSERT INTO login " +
			                   "VALUES ('"+mail+"', '"+name+"', '"+rpass+"')";
						 
					 stmt.executeUpdate(sql);
					 
			         runOnUiThread(new Runnable() {
					     @Override
					     public void run() {
					    	 tv.setText("Registered...");
					    }
					});
			      return 1;
					 }
				 catch(final Exception ex)
				 {
					 
					 runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 tv.setText("2: "+ex.getMessage());
					    }
					});
					 return 2;
				 }
				//conn.close();
			}
			catch(Exception x)
			{
				x.printStackTrace();
				tv.setText(x.getMessage()+"1");
			}
			return 3;
		}
		
		protected void onPostExecute(Integer result) {
	          pd.dismiss();
	          if(result==1) {
	              Toast.makeText(RegisterActivity.this,
	                  "Registration successfull.", Toast.LENGTH_LONG)
	                  .show();
	              runOnUiThread(new Runnable() {
					     @Override
					     public void run() {

					    	 finish();
					    }
					});
	          } else if(result==2) {
	              Toast.makeText(RegisterActivity.this,
	                      "Registration failed", Toast.LENGTH_LONG).show();
	          } else if(result==3) {
	              Toast.makeText(RegisterActivity.this,
	                      "There was a problem registering.",
	                      Toast.LENGTH_LONG).show();
	          }
	          
	      }
		
	}
	
    
    
    
    
}