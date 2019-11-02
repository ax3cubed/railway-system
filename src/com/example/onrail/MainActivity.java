package com.example.onrail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;

import android.annotation.SuppressLint;
import android.app.Activity;
//import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import android.view.Display;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("serial")
@SuppressLint("NewApi")
public class MainActivity extends Activity implements Serializable{
	Button highlighter,cancel,book,alt,back,current;
	AutoCompleteTextView editText1,editText2;
    String str,sourcetag,desttag;
    String[] rday;
    String run,arrival;
    String source,destination,pune,nagpur;
    TextView info,time,date;
    int length=0,k=0,i,weekday,temp;
    int diff[]=new int[100];
    int runn,finalselected,infowidth,height,ij=0,ik=0,d;
    Cursor c,cj,c1,csingle;
    Location currentLocation,myLocation;
    double currentLatitude;
    String result;
    double currentLongitude;
    double pointlat,pointlng;
    String trnnm = null;
    int []colors={-65536,-16711936,-16777216,-256,-65281,-16776961,-7829368};
    String tno,token;
    SqlConnector con = new SqlConnector(MainActivity.this);
	ArrayList<String> in = new ArrayList<String>();
	ArrayList<String> strBuftrain = new ArrayList<String>();
	ArrayList<String> strBufalt = new ArrayList<String>();
	Intent intentbook;
	
	ArrayList<String> timebuffer = new ArrayList<String>();
	StringBuffer strBuf = new StringBuffer();
    static final LatLng PUNE = new LatLng(18.5203, 73.8567);
    static final LatLng MUMBAI = new LatLng(18.9750,72.8258);
    private GoogleMap map;
    String []par=null;
    String []cpar=null;
	ArrayList<String> par1 = new ArrayList<String>();
	ArrayList<String> altlinks = new ArrayList<String>();
	Cursor c2;
	String arr=null,depart=null;
	 int count=0,polycount=0,flag=0;
	selectedinfo []si=new selectedinfo[5];
	finalselectedclass fc=new finalselectedclass();
	finalselectedalt fca=new finalselectedalt();
	int sicount=0,betaltcount=0;
	
	  private int year,month,day,m,cyear,cmonth,cday;
		static final int DATE_DIALOG_ID = 100;
	

	// Create the adapter and set it to the AutoCompleteTextView 
@SuppressLint("NewApi")
@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    for(int z=0;z<5;z++)
	{
		si[z]=new selectedinfo();
	}
    Autocomplete();
   
    map=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap(); 
    
    /*For automatically completing source and destination fields*/
    
    map.setMyLocationEnabled(true);
    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    
    SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
	boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
	if (isFirstRun)
	{
	    // Code to run once
		 SqlConnector con = new SqlConnector(MainActivity.this);
		con.insertData();
	     con.close();
	    SharedPreferences.Editor editor = wmbPreference.edit();
	    editor.putBoolean("FIRSTRUN", false);
	    editor.commit();
	    Toast.makeText(this, "Application ready", Toast.LENGTH_SHORT).show();
	}
	/*
    // Move the camera instantly to pune with a zoom of 15.
    //updateLocation(map.getMyLocation());
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(PUNE, 10));
    // Zoom in, animating the camera.
    map.animateCamera(CameraUpdateFactory.zoomTo(5), 2000, null);
    */
    /*Getting Auto location to city/country*/
    GPSAutoloc();   
    
    map.setOnMapLongClickListener(new OnMapLongClickListener() {
		
		@Override
		public void onMapLongClick(LatLng point) {
			// TODO Auto-generated method stub
			map.animateCamera(CameraUpdateFactory.newLatLng(point));
			pointlat=point.latitude;
			pointlng=point.longitude;
			new CityAsyncTask().execute();
			csingle=con.searchtrainsingle(result);
			polycount=0;
			if(csingle != null  && csingle.getCount() > 0)
			{
				if(csingle.moveToFirst())
				{
					do{
						String str=csingle.getString(6);
						//Toast.makeText(getApplicationContext(), ""+str, Toast.LENGTH_LONG).show();
						String []temp;
						temp=str.split("/");
						for(i=0;i<temp.length-1;i++)
						{
							getAddress(temp[i],temp[i+1]);
						}
						polycount=(polycount+1)%colors.length;
					}while(csingle.moveToNext());
					
				}
			}
		}
	});
    map.setOnMapClickListener(new OnMapClickListener() {
		
		@Override
		public void onMapClick(LatLng arg0) {
			// TODO Auto-generated method stub
			map.clear();
		}
	});
    highlighter=(Button)findViewById(R.id.routes);
    book = (Button)findViewById(R.id.book);
    alt = (Button)findViewById(R.id.alt);
    cancel = (Button)findViewById(R.id.cncl);
    info=(TextView)findViewById(R.id.info);
    time=(TextView)findViewById(R.id.time);
    back=(Button) findViewById(R.id.back);
    current = (Button)findViewById(R.id.current);
    date=(TextView)findViewById(R.id.date);
    
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
    .permitAll().build();
    StrictMode.setThreadPolicy(policy); 
    
    DateT();/*DateValidation in Main Activity*/
    
  


   
    
    
    
    
    
    
    

 editText1.setOnTouchListener(new OnTouchListener() {

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			editText1.setText("");
			return false;
		}
	});
editText2.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			editText2.setText("");
			return false;
		}
	});
cancel.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent( MainActivity.this,CancelTicket.class);
        startActivity(i);
		
	}
});
alt.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		count=0;
		// TODO Auto-generated method stub
		map.clear();
		strBuftrain.clear();		
		sourcetag=editText1.getText().toString();
		desttag=editText2.getText().toString();
		int z=0;
		flag=0;
		cj= con.searchjunction(sourcetag,desttag);
		if(cj != null  && cj.getCount() > 0)
		{
		cj.moveToFirst();		
		String cjunction;
		cjunction=cj.getString(0);
		cpar=cjunction.split(",");
		polycount=0;
		sicount=0;
		betaltcount=0;
		
		for(z=0;z<cpar.length;z++)
		{
			c= con.search1(sourcetag,cpar[z]);
			if(c != null  && c.getCount() > 0)
			{
				if(c.moveToFirst())
				{
					do
					{
						try{
							
							info.setText("");
							info.setVisibility(View.VISIBLE);
							info.setTextColor(Color.BLUE);
							info.setBackgroundColor(Color.BLACK);
							info.setAlpha(0.8f);
							info.setTextSize(20f);
							time.setText("");
							time.setVisibility(View.VISIBLE);
							time.setTextColor(Color.WHITE);
							time.setBackgroundColor(Color.BLACK);
							time.setAlpha(0.8f);
							time.setTextSize(20f);
							editText1.setVisibility(View.INVISIBLE);
							editText2.setVisibility(View.INVISIBLE);
							highlighter.setVisibility(View.INVISIBLE);
							back.setVisibility(View.VISIBLE);
							current.setVisibility(View.INVISIBLE);
							
							
						par=null;
						length=0;
						par1.clear();
						in.clear();
						token=c.getString(6);
						run=c.getString(9);
						rday=run.split("/");
						trnnm=c.getString(1);
						tno=c.getString(0);
						arr=null;
						c2=con.searcharrival(tno,sourcetag);
						c2.moveToFirst();
						arr=c2.getString(2);
						
						//depart=c.getString(5);
						//arrival=c.getString(4);
						c2=con.searcharrival(tno,cpar[z]);
						c2.moveToFirst();
						depart=c2.getString(2);
						
						
						
						DateFormat format=new SimpleDateFormat("hh:mm");
						si[sicount].arr_time=format.parse(arr);
						si[sicount].depart_time=format.parse(depart);
						si[sicount].arrmin=(int)si[sicount].arr_time.getTime()/60000;
						si[sicount].departmin=(int)si[sicount].depart_time.getTime()/60000;						
						si[sicount].selname=trnnm;
						si[sicount].selno=tno;
						si[sicount].seljunc=cpar[z];
						si[sicount].availseat=c.getInt(8);
						si[sicount].selarr=arr;
						si[sicount].flag=flag;
						par=token.split("/");
						for(i=0;i<par.length;i++)
						{
							par1.add(par[i]);
						}
						i=0;
						while(!par1.get(i).equals(sourcetag))
						{
							i++;
						}
						while(!par1.get(i).equals(cpar[z]))
						{
							in.add(par1.get(i));
							i++;
						}
						in.add(par1.get(i));
						//editText1.setText(token);
						length=in.size();
						}
						catch(Exception e)
						{
							Toast.makeText(getApplicationContext(), "Sorry, No alternate trains available..", Toast.LENGTH_LONG).show();
						}
						for(i=0;i<length-1;i++)
						{
							getAddress(in.get(i),in.get(i+1));
						}
						count=0;
						//strBuftrain.add(trnnm);
						//timebuffer.add(arr);
						polycount++;
						sicount++;
					}while(c.moveToNext());
				}
			}
			flag++;
		}
		//displayinfo();
		betaltcount=flag;
		flag=0;
		
		for(z=0;z<cpar.length;z++)
		{
			c= con.search1(cpar[z],desttag);
			if(c != null  && c.getCount() > 0)
			{
				if(c.moveToFirst())
				{
					do
					{
						try{
							par=null;
							length=0;
							par1.clear();
							in.clear();
							String token=c.getString(6);
							trnnm=c.getString(1);
							
							tno=c.getString(0);
							arr=null;
							c2=con.searcharrival(tno,cpar[z]);
							c2.moveToFirst();
							arr=c2.getString(2);
							
							
							depart=c.getString(5);
							//arrival=c.getString(4);
							c2=con.searcharrival(tno,cpar[z]);
							c2.moveToFirst();
							arr=c2.getString(2);
							
							
							DateFormat format=new SimpleDateFormat("hh:mm");
							si[sicount].arr_time=format.parse(arr);
							si[sicount].depart_time=format.parse(depart);
							si[sicount].arrmin=(int)si[sicount].arr_time.getTime()/60000;
							si[sicount].departmin=(int)si[sicount].depart_time.getTime()/60000;
							si[sicount].selname=trnnm;
							si[sicount].selno=tno;
							si[sicount].seljunc=cpar[z];
							si[sicount].availseat=c.getInt(8);
							si[sicount].selarr=arr;
							si[sicount].flag=flag;
							runn=Integer.parseInt(rday[weekday-1]);
							if(runn==1)
							{	
							
							par=token.split("/");
							for(i=0;i<par.length;i++)
							{
								par1.add(par[i]);
							}
							i=0;
							while(!par1.get(i).equals(cpar[z]))
							{
								i++;
							}
							while(!par1.get(i).equals(desttag))
							{
								in.add(par1.get(i));
								i++;
							}
							in.add(par1.get(i));
							//editText1.setText(token);
							length=in.size();
							}
						}
							catch(Exception e)
							{
								editText2.setText("2"+e.getLocalizedMessage());
							}
							for(i=0;i<length-1;i++)
							{
								getAddress(in.get(i),in.get(i+1));
							}
							count=0;
							polycount++;
						//strBuftrain.add(trnnm);
						//timebuffer.add(arr);
						sicount++;
						
					}while(c.moveToNext());
				}
				flag++;
			}
			//info.append("/"+si[z1].flag+" "+si[z1].selno+" "+si[z1].selname+" "+si[z1].seljunc+" "+si[z1].selarr+" "+si[z1].availseat+"\n");	
			try{
				displayaltinfo();
				/*info.setText(betaltcount+" "+sicount+"\n");
				//for(int z1=0;z1<altlinks.size();z1++)
					//	info.append(altlinks.get(z1)+"\n\n");
				info.setVisibility(View.VISIBLE);
				info.setTextColor(Color.WHITE);
				info.setBackgroundColor(Color.BLACK);
				info.setAlpha(0.8f);
				info.setTextSize(20f);*/
				}
			catch(Exception e)
			{
				Toast.makeText(getApplicationContext(), "3"+e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}

	}
		else
		{
			Toast.makeText(getApplicationContext(), "Sorry, No alternate trains available..", Toast.LENGTH_LONG).show();
		}
	}
});
highlighter.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View arg0) {
		count=0;
		sicount=0;
		map.clear();
		strBuftrain.clear();		   
		sourcetag=editText1.getText().toString();
		desttag=editText2.getText().toString();

		
		c= con.search1(sourcetag,desttag);
		
		try{
			polycount=0;
		if(c != null  && c.getCount() > 0)
		{
			
			info.setText("");
			info.setVisibility(View.VISIBLE);
			info.setTextColor(Color.BLUE);
			info.setBackgroundColor(Color.BLACK);
			info.setAlpha(0.8f);
			info.setTextSize(20f);
			if(ij==0)
			infowidth = info.getWidth();
			
			ij++;
			time.setText("");
			time.setVisibility(View.VISIBLE);
			time.setTextColor(Color.WHITE);
			time.setBackgroundColor(Color.BLACK);
			time.setAlpha(0.8f);
			time.setTextSize(20f);
			
			editText1.setVisibility(View.INVISIBLE);
			editText2.setVisibility(View.INVISIBLE);
			highlighter.setVisibility(View.INVISIBLE);
			back.setVisibility(View.VISIBLE);
			current.setVisibility(View.INVISIBLE);
			
			if(c.moveToFirst())
			{
				do
				{
					
					par=null;
					length=0;
					par1.clear();
					in.clear();
					token=null;
					run=null;
					token=c.getString(6);
					trnnm=c.getString(1);
					run=c.getString(9);
					//alt.setText(""+run);
					rday=run.split("/");
					tno=c.getString(0);
					arr=null;
					c2=con.searcharrival(tno,sourcetag);
					c2.moveToFirst();
					arr=c2.getString(2);
					
					si[sicount].selno=tno;
					si[sicount].selname=trnnm;
					si[sicount].seljunc=c.getString(7);
					si[sicount].availseat=c.getInt(8);
					si[sicount].selarr=arr;
					
					//alt.setText(rday[weekday-1]);
					runn=Integer.parseInt(rday[weekday-1]);
					if(runn==1)
					{	
					par=token.split("/");
					for(i=0;i<par.length;i++)
					{
						par1.add(par[i]);
					}
					i=0;
					while(!par1.get(i).equals(sourcetag))
					{
						i++;
					}
					while(!par1.get(i).equals(desttag))
					{
						in.add(par1.get(i));
						i++;
					}
					in.add(par1.get(i));
					length=in.size();
					//editText1.setText(in.toString());
					for(i=0;i<length-1;i++)
					{
						getAddress(in.get(i),in.get(i+1));
					}
					count=0;
					sicount++;
					strBuftrain.add(trnnm);
					timebuffer.add(arr);
					polycount++;
					}
					
				}while(c.moveToNext());
				/*try
				{
				editText1.setText(" "+polycount);
				polycount=0;
				editText2.setText(" "+polycount);
				}
				catch(Exception e)
				{
				editText1.setText(e.getMessage());
				}*/
				polycount=0;
				displayinfo();
			}				
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Sorry, No trains available...", Toast.LENGTH_LONG).show();
		}
		}
		catch(Exception e){editText1.setText(e.getMessage());}
		c.close();
		con.close();        
    }
	

});



	book.setOnClickListener(new OnClickListener() {

	    @Override
	    public void onClick(View v) {
	    // TODO Auto-generated method stub
	    //Log.i("clicks","You Clicked B1");
	    info.setVisibility(View.INVISIBLE);
	    back.setVisibility(View.INVISIBLE);
	    time.setVisibility(View.INVISIBLE);
	    editText1.setVisibility(View.VISIBLE);
	    editText2.setVisibility(View.VISIBLE);
	    highlighter.setVisibility(View.VISIBLE);
	    back.setTextColor(Color.BLUE);
	    book.setVisibility(View.INVISIBLE);
	      
	      try{
	     
	      startActivity(intentbook);
	      }
	      catch(Exception e)
	      {
	    	  Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_LONG).show();
	      }
	    }
	});
back.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		info.setVisibility(View.INVISIBLE);
		back.setVisibility(View.INVISIBLE);
		time.setVisibility(View.INVISIBLE);
		book.setVisibility(View.INVISIBLE);
		editText1.setVisibility(View.VISIBLE);
		editText2.setVisibility(View.VISIBLE);
		highlighter.setVisibility(View.VISIBLE);
		current.setVisibility(View.VISIBLE);
	}
});
  }
private void GPSAutoloc() {
		// TODO Auto-generated method stub
	
	
	// Move the camera instantly to pune with a zoom of 15.
    //updateLocation(map.getMyLocation());
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(PUNE, 10));
    // Zoom in, animating the camera.
    map.animateCamera(CameraUpdateFactory.zoomTo(5), 2000, null);

	LocationManager locationManager = 
            (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
            }
            public void onStatusChanged(
                    String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        };

        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        
       // updateLocation(map.getMyLocation());
        
	}

@Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }


public void DateT()
{
	setCurrentDate();
 	addButtonListener();
    
}


  
 @SuppressLint("NewApi")
 
 void getAddress(String src,String dest){
	  double src_lat = 0.0,src_lng = 0.0,dest_lat = 0.0,dest_lng = 0.0;
    	 Cursor cl;
    	 cl=con.searchlatlng(src);
			cl.moveToFirst();
			float lat=cl.getFloat(1);
			float lng=cl.getFloat(2);
			src_lat=lat;
			src_lng=lng;
			if(count==0)
				map.addMarker(new MarkerOptions().position(new LatLng(src_lat,src_lng)).title(src).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))).showInfoWindow();
			else
                map.addMarker(new MarkerOptions().position(new LatLng(src_lat,src_lng)).title(src));
			     	
                   /*if(count==1){
                 	CameraPosition cm=new CameraPosition.Builder().target(new LatLng(src_lat,src_lng)).zoom(6).build();
                 	map.animateCamera(CameraUpdateFactory.newCameraPosition(cm));
                 	}
                 	*/
                 	cl=con.searchlatlng(dest);
        			cl.moveToFirst();
        			lat=cl.getFloat(1);
        			lng=cl.getFloat(2);
        			dest_lat=lat;
        			dest_lng=lng;
        			map.addMarker(new MarkerOptions().position(new LatLng(dest_lat,dest_lng)).title(dest)).showInfoWindow();
        			count++;
        					Polyline line = map.addPolyline(new PolylineOptions()
        					.add(new LatLng(src_lat,src_lng),
                           new LatLng(dest_lat,dest_lng))
                           .width(6).color(colors[polycount]).geodesic(true)); 
     }
 void displayaltinfo()
 {
	 
	 try{
		 
		 altlinks.clear();
		 d=0;
		 for(int h=0;h<betaltcount;h++)
		 {
			 for(int k=betaltcount;k<sicount;k++)
			 {
				 if(si[h].flag==si[k].flag)
				 {
					 diff[d]=si[k].arrmin-si[h].departmin;
					 String temp=si[h].selname.concat(":=:").concat(si[k].selname);
					 
					 altlinks.add(temp);
					 d++;
				 
				 }
			 }
		 }
		 
		 	
		 	info.setTextColor(Color.WHITE);
			time.setVisibility(View.INVISIBLE);
			Display display = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
		
			int width = size.x;
			height = info.getHeight();
			//textView1.setText("width"+width+"Height"+height);
			//textView1.setBackgroundColor(Color.BLACK);
			//textView1.setAlpha(0.8f);
			//textView1.setWidth(width);
			RelativeLayout.LayoutParams Params1=new RelativeLayout.LayoutParams(width+10,height);
			info.setLayoutParams(Params1);
			info.setMovementMethod(LinkMovementMethod.getInstance());
			final SpannableStringBuilder asd = new SpannableStringBuilder();
			
			for(k=0;k<altlinks.size();k++)
			{
				try{
						final SpannableStringBuilder builder = new SpannableStringBuilder(altlinks.get(k));
						//time.append((CharSequence) timebuffer.get(k)+"\n");
						
						builder.setSpan(new ClickableSpan() {
							String mText = altlinks.get(k);
							int h;
							@Override
							public void onClick(View arg0) {
								book.setVisibility(View.VISIBLE);
								book.setTextColor(Color.BLUE);
								info.setText(mText);
								for(h=0;h<altlinks.size();h++)
								{
									if(altlinks.get(h)==mText)
									{
										break;
									}
								}
								
								String[] temp=mText.split(":=:");
								try{
								for(int h=0;h<sicount;h++)
								{
									if(si[h].selname.equals(temp[0]))
									{
										fca.availseat1=si[h].availseat;
										fca.selarr1=si[h].selarr;
										fca.seljunc1=si[h].seljunc;
										fca.selname1=si[h].selname;
										fca.selno1=si[h].selno;
									}
									if(si[h].selname.equals(temp[1]))
									{
										fca.availseat2=si[h].availseat;
										fca.selarr2=si[h].selarr;
										fca.seljunc2=si[h].seljunc;
										fca.selname2=si[h].selname;
										fca.selno2=si[h].selno;
									}
								}
								intentbook=new Intent(
							             MainActivity.this,
							             BookActivity.class);
								intentbook.putExtra("asd1", fca);
								intentbook.putExtra("deter", 2);
								
								info.append("\n"+sourcetag+"->"+fca.seljunc1+"->"+desttag);
								info.append("\n\nAvailability of "+fca.selname1+": "+fca.availseat1);
								info.append("\nAvailability of "+fca.selname2+": "+fca.availseat2);
								
								info.append("\nDepart from "+sourcetag+":\t"+fca.selarr1);
								
								Cursor c3=con.searcharrival(fca.selno1, fca.seljunc1);
								c3.moveToFirst();
								arr=c3.getString(2);
								
								info.append("\nArrival at "+fca.seljunc1+":\t"+arr);
								info.append("\nDepart from "+fca.seljunc1+":\t"+fca.selarr2);
								
								c3=con.searcharrival(fca.selno2, desttag);
								c3.moveToFirst();
								arr=c3.getString(2);
								
								
								info.append("\nArrival at "+desttag+":\t"+arr);
								info.append("\nWaiting time: "+String.valueOf(diff[h])+" mins");
								
								}
								catch(Exception exc)
								{
									Toast.makeText(getApplicationContext(), exc.getMessage(), Toast.LENGTH_LONG).show();
								}
							}
						}, 0,altlinks.get(k).length(), 0);
						asd.append(builder);
						asd.append("\n\n");
						
					}
				
				catch(Exception ex)
				{
					Toast.makeText(getApplicationContext(), "1:"+ex.getMessage(), Toast.LENGTH_LONG).show();
				}
				info.setText(asd);
				
			}
			
			
			
	 }
	 catch(Exception e)
	 {
		 Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
	 }
 }

  void updateLocation(Location location){
      currentLocation = location;
      currentLatitude = currentLocation.getLatitude();
      currentLongitude = currentLocation.getLongitude();
  }
  
  void Autocomplete()
  {
	  String[] countries = getResources().getStringArray(R.array.countries_array);
	    editText1 = (AutoCompleteTextView) findViewById(R.id.pnr);
		// Create the adapter and set it to the AutoCompleteTextView 
		ArrayAdapter<String> adapter = 
		        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
		editText1.setAdapter(adapter);
		editText2 = (AutoCompleteTextView) findViewById(R.id.editText2);
	    	//String[] countries = getResources().getStringArray(R.array.countries_array);
	    	// Create the adapter and set it to the AutoCompleteTextView 
	    	ArrayAdapter<String> adapter1 = 
	    	        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
	    	editText2.setAdapter(adapter1);
	  
  }
  
 
	void displayinfo()
	{
		info.setTextColor(Color.WHITE);
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		height = info.getHeight();
		//textView1.setText("width"+width+"Height"+height);
		//textView1.setBackgroundColor(Color.BLACK);
		//textView1.setAlpha(0.8f);
		//textView1.setWidth(width);
		RelativeLayout.LayoutParams Params1=new RelativeLayout.LayoutParams(infowidth,height);
		info.setLayoutParams(Params1);
		
		
		info.setMovementMethod(LinkMovementMethod.getInstance());
		final SpannableStringBuilder asd = new SpannableStringBuilder();
    	final ArrayList<String> par1 = new ArrayList<String>();
    	time.setText("Departure\n");
		for(k=0;k<strBuftrain.size();k++)
		{
			try{
					final SpannableStringBuilder builder = new SpannableStringBuilder(strBuftrain.get(k));
					time.append((CharSequence) timebuffer.get(k)+"\n");
					
					builder.setSpan(new ClickableSpan() {
						String mText = strBuftrain.get(k);
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							book.setVisibility(View.VISIBLE);
							book.setTextColor(Color.BLUE);
							time.setText("\n\nArrival");
							asd.clear();
							for(int z=0;z<sicount;z++)
							{
								if(si[z].selname.equals(mText))
								{
									finalselected=z;
									break;
								}
							}
							fc.availseat=si[finalselected].availseat;
							fc.selarr=si[finalselected].selarr;
							fc.seljunc=si[finalselected].seljunc;
							fc.selname=si[finalselected].selname;
							fc.selno=si[finalselected].selno;
							intentbook=new Intent(
						             MainActivity.this,
						             BookActivity.class);
							intentbook.putExtra("asd", fc);
							intentbook.putExtra("deter", 1);
							
							info.setText(mText+"\nAvailability: "+si[finalselected].availseat+"\nStation Info:");
							
							length=0;
							String []par=null;
							strBuf.delete(0, strBuf.length());
							for(int z=0;z<sicount;z++)
							{
								if(si[z].selname.equals(mText))
								{
									finalselected=z;
									break;
								}
							}
							
							c= con.search(mText);
							builder.clear();
							c.moveToFirst();
							par=null;
							String token=c.getString(6);
							asd.clear();
							par=token.split("/");
							par1.clear();
							in.clear();
							int i=0;
							for(i=0;i<par.length;i++)
							{
								par1.add(par[i]);
							}
							i=0;
							while(!par1.get(i).equals(editText1.getText().toString()))
							{
								i++;
							}
							while(!par1.get(i).equals(editText2.getText().toString()))
							{
								in.add(par1.get(i));
								i++;
							}
							in.add(par1.get(i));
							try{
							Cursor c3;
							for(i=0;i<in.size();i++)
							{
								c3=con.searcharrival(si[finalselected].selno,in.get(i));
								c3.moveToFirst();
								arr=c3.getString(2);
								time.append("\n"+arr);
								info.append("\n"+in.get(i));
							}
							}
							catch(Exception ex)
							{
								Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
							}
						}
					}, 0,strBuftrain.get(k).length(), 0);
					asd.append(builder);
					asd.append("\n");
					
				}
			
			catch(Exception ex)
			{
				Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
			}
			info.setText("Trains Available\n");
			info.append(asd);
			
		}
		
	}
	
	
	public void setCurrentDate() {
		//date_picker = (DatePicker) findViewById(R.id.date_picker);
 
		final Calendar calendar = Calendar.getInstance();
		
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
 
		// set current date into textview
		date.setText(new StringBuilder()
			// Month is 0 based, so you have to add 1
			.append(day).append("/")
			.append(month+1).append("/")
			.append(year).append(" "));
		//currentdate=date.toString();
		// set current date into Date Picker
		//date_picker.init(year, month, day, null);
 
	}
	
	public void addButtonListener() {
		
		current.setOnClickListener(new OnClickListener() {
 
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
 
				showDialog(DATE_DIALOG_ID);
 
			}
 
		});
 
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		
		switch (id) {
		case DATE_DIALOG_ID:
		   // set date picker as current date
		   return new DatePickerDialog(this, datePickerListener, year, month,day);
		}	return null;
	}
	
	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		 
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {
			Calendar cal=Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	 
			
			SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
			 
			  
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
			m=selectedMonth+1;
			String d=day+"/"+m+"/"+year;
			cyear = cal.get(Calendar.YEAR);
			cmonth = cal.get(Calendar.MONTH);
			cday = cal.get(Calendar.DAY_OF_MONTH);
			//weekday=cal.get(Calendar.DAY_OF_WEEK);
			temp=1;
 
			// set selected date into Text View
			

			// set selected date into Date Picker
			//date_picker.init(year, month, day, null);
 
			if(year>cyear)
			{
				temp=1;
			}
			else if(year==cyear)
			{
				if(month>cmonth)
				{
					temp=1;
				}
				else if(month==cmonth)
				{
					if(day>=cday)
					{
						temp=1;
					}
					else
					{
						temp=0;
					}
				}
				else{temp=0;}
			}
			else{
				temp=0;
			}
			if(temp==1)
			
			{
				
				
				date.setText(new StringBuilder().append(day)
						   .append("/").append(month).append("/").append(year));	
				try {
					cal.setTime(format1.parse(d));
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				weekday=cal.get(cal.DAY_OF_WEEK);
			}
			else
			{
				date.setText("Invalid Date , Select again");

			}

					//	DateTime time=new DateTime()		
		}
	};	
	
	public class CityAsyncTask extends AsyncTask<String , Void,Integer>
	{

	    @Override
	    protected Integer doInBackground(String... arg0) {

	         Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
				try
	            {
	                List<Address> addresses = geocoder.getFromLocation(pointlat, pointlng, 1);
	                //Log.e("Addresses","-->"+addresses);
	                result = addresses.get(0).getLocality().toLowerCase().toString();
	                
	                runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							editText1.setText(result);	
						}
					});
	                
	            }
	            catch(final Exception e)
	            {
	            		runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();		
						}
					});
	            }
	        return 1;
	    }
	}
	
}
