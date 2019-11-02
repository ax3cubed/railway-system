package com.example.onrail;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
//import android.widget.Toast;

public class SqlConnector {

	
	private static final String DB_NAME="beprojtry";
	public static final String TABLE_NAME="train";
	public static int DATABASE_VERSION=10;
	
	private SQLiteDatabase database;
	private DatabaseHelper dbOpenHelper;
	
	public SqlConnector(Context context){
		dbOpenHelper=new DatabaseHelper(context,DB_NAME,null,DATABASE_VERSION);
	}
	public void open(){
		database=dbOpenHelper.getWritableDatabase();
	}
	
	public void close(){
		if(database!=null)
			database.close();
	}
	
	// Akola Latlng
@SuppressLint("NewApi")
public boolean insertData(){
		
		try{
			int num=12135;
			String trainname="Pune-Nagpur Exp";
			String source="pune";
			String dest="nagpur";
			String arrival="9:25";
			String depart="17:40";
			String junction="mumbai,latur";
			int avail=10;
			String inter="pune/daund/manmad/bhusaval/wardha/nagpur";
			String day="0/1/1/0/0/1/0";
					ContentValues content=new ContentValues();
					
					content.put("trainnum",num);
					content.put("trainname",trainname);
					content.put("source",source);
					content.put("dest",dest);
					content.put("arrival",arrival);
					content.put("depart",depart);
					content.put("inter",inter);
					content.put("avail", avail);
					content.put("junction", junction);
					content.put("day", day);
					open();
					database.insert("train",null,content);
					
					Log.i("inserted","inserted1");
			junction=null;
			num=12105;
			trainname="Vidarbha Exp";
			source="mumbai";
			dest="nagpur";
			arrival="19:10";
			depart="09:20";
			avail=10;
			inter="mumbai/nashik/jalgaon/bhusaval/wardha/nagpur";
			day="0/1/1/0/0/1/0";

			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted2");
			
			num=12833;
			trainname="Howrah Exp";
			source="ahmedabad";
			dest="howrah";
			arrival="23:55";
			depart="17:30";
			avail=10;
			inter="ahmedabad/vadodara/surat/jalgaon/bhusaval/nagpur/howrah";
			day="0/1/1/0/0/1/0";


			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
			
			num=10000;
			trainname="pune-mumbai Exp";
			source="pune";
			dest="mumbai";
			arrival="11:45";
			depart="18:00";
			avail=10;
			inter="pune/lonavala/karjat/panvel/thane/mumbai";
			day="0/1/1/0/0/1/0";


			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
		
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted3");
		
			
			num=11111;
			trainname="Garibrath Exp";
			source="pune";
			dest="nagpur";
			arrival="8:30";
			depart="18:30";
			avail=10;
			inter="pune/nashik/akola/pulgaon/nagpur";
			day="0/0/1/0/0/0/1";

			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
								

			Log.i("inserted","inserted4");
			
			num=17013;
			trainname="Pune-Hyd Expr";
			source="pune";
			dest="hyderabad";
			arrival="14:15";
			depart="20:55";
			avail=10;
			inter="pune/daund/kurduwadi/barsi/usmanabad/latur/udgir/bidar/vikarabad/hyderabad";
			day="0/1/1/0/0/1/0";

			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);


								
			Log.i("inserted","inserted5");
			
			num=11404;
			trainname="Kolhapur-Ngp Expr";
			source="kolhapur";
			dest="nagpur";
			arrival="12:50";
			depart="12:35";
			avail=10;
			inter="kolhapur/miraj/barsi/usmanabad/latur/parbhani/purna/akola/badnera/dhamangaon/nagpur";
			day="0/1/1/0/0/1/0";


			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
					
			Log.i("inserted","inserted6");
			
			num=15602;
			trainname="Pune-Delhi Exp";
			source="pune";
			dest="delhi";
			arrival="06:56";
			depart="11:10";
			avail=10;
			junction="raipur,ahmedabad";
			inter="pune/lonavala/khandala/vasai/vadodara/ratlam/kota/delhi";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			junction=null;
			
			num=15406;
			trainname="Jhelum Exp";
			source="pune";
			dest="delhi";
			arrival="20:45";
			depart="17:20";
			avail=10;
			inter="pune/daund/manmad/khandva/itarsi/bhopal/bina/jhansi/gwalior/agra/delhi";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction",junction);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted8");
			junction=null;
			
			num=14901;
			trainname="A'bad-Howrah Exp";
			source="ahmedabad";
			dest="howrah";
			arrival="13:30";
			depart="23:55";
			avail=10;
			inter="ahmedabad/vadodara/surat/nandurbar/bhusaval/akola/badnera/nagpur/durg/raipur/bilaspur/raigarh/rourkela/chakaradharpur/tatanagar/kharagpur/howrah";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted");
			
			
			num=16574;
			trainname="Ashram Exp";
			source="ahmedabad";
			dest="delhi";
			arrival="10:10";
			depart="18:30";
			avail=10;
			inter="ahmedabad/sabarmati/palanpur/ajmer/jaipur/alwar/gurgaon/delhi";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted");

			
			
			num=18965;
			trainname="Pune-Hatia Exp";
			source="pune";
			dest="hatia";
			arrival="17:10";
			depart="10:45";
			avail=10;
			inter="pune/daund/manmad/raipur/bilaspur/rourkela/hatia";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			
			num=10450;
			trainname="Raipur-Delhi Exp";
			source="raipur";
			dest="delhi";
			arrival="07:25";
			depart="07:45";
			avail=10;
			inter="raipur/durg/tumsar/nagpur/itarsi/bhopal/bina/jhansi/delhi";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
							
			Log.i("inserted","inserted7");
			
			/*num=12549;
			trainname="Raipur-Jammu Exp";
			source="raipur";
			dest="jammu";
			arrival="09.30";
			depart="12.40";
			avail=10;
			inter="raipur/bilaspur/anuppur/jhansi/delhi";
			day="1/0/0/1/0/0/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			*/
			num=16534;
			trainname="Vadodara-Delhi Exp";
			source="vadodara";
			dest="delhi";
			arrival="23:50";
			depart="06:30";
			avail=10; 	
			inter="vadodara/ratlam/kota/gangapur/mathura/delhi";
			day="1/0/0/1/0/0/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=11098;
			trainname="Dehradun Exp";
			source="vadodara";
			dest="delhi";
			arrival="05:25";
			depart="06:50";
			avail=10; 	
			inter="vadodara/godhra/dahod/ratlam/nagda/shamgarh/kota/gangapur/mathura/delhi";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=11096;
			trainname="Ahimsa Exp";
			source="pune";
			dest="ahmedabad";
			arrival="07:45";
			depart="19:50";
			avail=10; 	
			inter="pune/kalyan/vasai/surat/vadodara/ahmedabad";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			/*num=16539;
			trainname="Gahib Exp";
			source="pune";
			dest="ahmedabad";
			arrival="06.45";
			depart="15.50";
			avail=10; 	
			inter="pune/kalyan/vasai/surat/vadodara/ahmedabad";
			day="1/0/0/1/0/0/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			*/
		/*	num=19105;
			trainname="Ahmedabad-Hari Exp";
			source="ahmedabad";
			dest="delhi";
			arrival="04.18";
			depart="10.05";
			avail=10; 	
			inter="ahmedabad/abu/ajmer/jaipur/banikui/alwar/rewari/delhi";
			day="1/0/0/1/0/0/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			*/
			num=10148;
			trainname="Lal-Quila Exp";
			source="delhi";
			dest="kolkata";
			arrival="18:00";
			depart="05:00";
			avail=10; 	
			inter="delhi/ghaziabad/aligarh/kanpur/fatehpur/allahabad/mughal sarai/asansol/kolkata";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=10149;
			trainname="Chennai-Express";
			source="chennai";
			dest="patna";
			arrival="20:00";
			depart="09:30";
			avail=10; 	
			junction="hyderabad,bhubaneshwar";
			inter="chennai/gudur/nellore/vizianagaram/titlagarh/rourkela/gaya/patna";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("junction", junction);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			junction=null;
			
			num=10150;
			trainname="Hyderabad Exp";
			source="chennai";
			dest="hyderabad";
			arrival="07:00";
			depart="18:00";
			avail=10; 	
			inter="chennai/gudur/nellore/chirala/secunderabad/hyderabad";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=10151;
			trainname="Charminar Exp";
			source="hyderabad";
			dest="patna";
			arrival="19:25";
			depart="02:05";
			avail=10; 	
			inter="hyderabad/gondia/durg/raipur/rourkela/gaya/patna";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=10152;
			trainname="Guwahati Exp";
			source="bangalore";
			dest="bhubaneshwar";
			arrival="13:00";
			depart="22:00";
			avail=10; 	
			inter="bangalore/chennai/vijayawada/visakhapatnum/durg/bhubaneshwar";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
		
			num=10153;
			trainname="Patna Exp";
			source="bhubaneshwar";
			dest="patna";
			arrival="23:45";
			depart="04:15";
			avail=10; 	
			inter="bhubaneshwar/cuttack/kharagpur/gaya/patna";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=22905;
			trainname="Okha Howrah Exp";
			source="ahmedabad";
			dest="howrah";
			arrival="03:35";
			depart="16:15";
			avail=10; 	
			inter="ahmedabad/vadodara/surat/nandurbar/bhusaval/nagpur/durg/raipur/bilaspur/rourkela/chakaradharpur/tatanagar/kharagpur/howrah";
			day="1/0/0/1/0/0/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			
			num=12937;
			trainname="Garbha Exp";
			source="ahmedabad";
			dest="kolkata";
			arrival="13:05";
			depart="23:25";
			avail=10; 	
			junction="delhi";
			inter="ahmedabad/vadodara/ratlam/kota/agra/tundla/kanpur/allahabad/mughal sarai/gaya/dhanbad/asansol/kolkata";
			day="1/1/1/1/1/1/1";
			
			content.put("trainnum",num);
			content.put("trainname",trainname);
			content.put("source",source);
			content.put("dest",dest);
			content.put("arrival",arrival);
			content.put("depart",depart);
			content.put("inter",inter);
			content.put("avail", avail);
			content.put("junction", junction);
			content.put("day", day);
			database.insert("train",null,content);
								
			Log.i("inserted","inserted7");
			junction=null;
			
			
			
			
			ContentValues content1=new ContentValues();
			
			
			num=15602;
			source="pune";
			arrival="11:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			
	
			num=15602;
			source="lonavala";
			arrival="11:59";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15602;
			source="khandala";
			arrival="12:04";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15602;
			source="vasai";
			arrival="14:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15602;
			source="vadodara";
			arrival="18:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=15602;
			source="ratlam";
			arrival="22:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=10149;
			source="chennai";
			arrival="20:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10149;
			source="gudur";
			arrival="22:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10149;
			source="nellore";
			arrival="23:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10149;
			source="vizianagaram";
			arrival="00:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10149;
			source="titlagarh";
			arrival="03:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10149;
			source="rourkela";
			arrival="05:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			
			num=10149;
			source="gaya";
			arrival="07:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10149;
			source="patna";
			arrival="09:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10150;
			source="chennai";
			arrival="07:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10150;
			source="gudur";
			arrival="08:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10150;
			source="nellore";
			arrival="11:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10150;
			source="chirala";
			arrival="14:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10150;
			source="secunderabad";
			arrival="16:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10150;
			source="hyderabad";
			arrival="18:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="hyderabad";
			arrival="19:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="gondia";
			arrival="20:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="durg";
			arrival="20:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="raipur";
			arrival="22:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="rourkela";
			arrival="23:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="gaya";
			arrival="01:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10151;
			source="patna";
			arrival="02:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10152;
			source="bangalore";
			arrival="13:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10152;
			source="chennai";
			arrival="15:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10152;
			source="vijayawada";
			arrival="17:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10152;
			source="visakhapatnum";
			arrival="19:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10152;
			source="durg";
			arrival="21:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10152;
			source="bhubaneshwar";
			arrival="22:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10153;
			source="bhubaneshwar";
			arrival="23:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10153;
			source="cuttack";
			arrival="01:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10153;
			source="kharagpur";
			arrival="02:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
						
			num=10153;
			source="gaya";
			arrival="03:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10153;
			source="patna";
			arrival="04:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=15406;
			source="pune";
			arrival="17:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			
			num=15406;
			source="daund";
			arrival="18:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15406;
			source="manmad";
			arrival="23:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");



			num=15406;
			source="bhusaval";
			arrival="02:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15406;
			source="khandva";
			arrival="04:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=15406;
			source="itarsi";
			arrival="07:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15406;
			source="bhopal";
			arrival="09:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15406;
			source="bina";
			arrival="11:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=15406;
			source="jhansi";
			arrival="13:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");



			num=15406;
			source="gwalior";
			arrival="15:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15406;
			source="agra";
			arrival="17:07";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=11098;
			source="vadodara";
			arrival="06:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="godhra";
			arrival="08:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="dahod";
			arrival="09:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="ratlam";
			arrival="12:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="nagda";
			arrival="14:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="shamgarh";
			arrival="16:03";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="kota";
			arrival="19:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="gangapur";
			arrival="22:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="mathura";
			arrival="02:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11098;
			source="delhi";
			arrival="05:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=14901;
			source="ahmedabad";
			arrival="23:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			
			num=14901;
			source="vadodara";
			arrival="01:48";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="surat";
			arrival="03:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="nandurbar";
			arrival="07:07";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="bhusaval";
			arrival="11:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="akola";
			arrival="13:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="badnera";
			arrival="16:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="nagpur";
			arrival="17:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="durg";
			arrival="22:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="raipur";
			arrival="22:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="bilaspur";
			arrival="00:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="raigarh";
			arrival="03:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="rourkela";
			arrival="06:37";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="chakaradharpur";
			arrival="08:08";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="tatanagar";
			arrival="09:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=14901;
			source="kharagpur";
			arrival="11:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16574;
			source="ahmedabad";
			arrival="18:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16574;
			source="sabarmati";
			arrival="18:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16574;
			source="palanpur";
			arrival="21:07";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16574;
			source="ajmer";
			arrival="22:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16574;
			source="jaipur";
			arrival="04:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=16574;
			source="alwar";
			arrival="06:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16574;
			source="gurgaon";
			arrival="09:06";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=18965;
			source="pune";
			arrival="10:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=18965;
			source="daund";
			arrival="12:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=18965;
			source="manmad";
			arrival="17:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=18965;
			source="raipur";
			arrival="06:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=18965;
			source="bilaspur";
			arrival="08:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=18965;
			source="rourkela";
			arrival="13:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=18965;
			source="hatia";
			arrival="17:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=10450;
			source="raipur";
			arrival="07:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=10450;
			source="durg";
			arrival="08:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=10450;
			source="tumsar";
			arrival="11:13";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=10450;
			source="nagpur";
			arrival="12:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=10450;
			source="itarsi";
			arrival="17:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=10450;
			source="bhopal";
			arrival="19:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");



			num=10450;
			source="bina";
			arrival="22:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=10450;
			source="jhansi";
			arrival="00:43";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=12549;
			source="raipur";
			arrival="12:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=12549;
			source="bilaspur";
			arrival="14:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=12549;
			source="anuppur";
			arrival="17:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=12549;
			source="jhansi";
			arrival="02:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=16534;
			source="vadodara";
			arrival="06:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");



			num=16534;
			source="ratlam";
			arrival="10:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");



			num=16534;
			source="kota";
			arrival="16:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");



			num=16534;
			source="gangapur";
			arrival="19:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=16534;
			source="mathura";
			arrival="21:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			
			num=16534;
			source="delhi";
			arrival="23:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			num=10148;
			source="delhi";
			arrival="18:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="ghaziabad";
			arrival="18:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="aligarh";
			arrival="20:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="kanpur";
			arrival="23:50:";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");	
			
			num=10148;
			source="fatehpur";
			arrival="01:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="allahabad";
			arrival="02:05";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="mughal sarai";
			arrival="03:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="asansol";
			arrival="04:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=10148;
			source="kolkata";
			arrival="05:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			num=11908;
					source="vadodara";
					arrival="06:50";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");


					num=11908;
					source="godhra";
					arrival="08:20";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");


					num=11908;
					source="dahod";
					arrival="09:50";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");

					num=11908;
					source="ratlam";
					arrival="12:20";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");

					num=11908;
					source="nagda";
					arrival="14:15";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");

					num=11908;
					source="shamgarh";
					arrival="16:03";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");


					num=11908;
					source="kota";
					arrival="19:00";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");


					num=11908;
					source="gangapur";
					arrival="22:35";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");


					num=11908;
					source="mathura";
					arrival="02:20";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");


					num=11908;
					source="delhi";
					arrival="05:25";
					content1.put("trainno",num);
					content1.put("source",source);
					content1.put("arrival",arrival);
					database.insert("inode",null,content1);					
					Log.i("inserted","inserted49");
			
					num=11096;
							source="pune";
							arrival="19:50";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");



							num=11096;
							source="kalyan";
							arrival="22:20";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");



							num=11096;
							source="vasai";
							arrival="23:45";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");



							num=11096;
							source="surat";
							arrival="02:50";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");



							num=11096;
							source="vadodara";
							arrival="05:45";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");


							num=16539;
							source="pune";
							arrival="18:50";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");


							num=16539;
							source="kalyan";
							arrival="21:40";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");


							num=16539;
							source="vasai";
							arrival="22:50";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");

							num=16539;
							source="surat";
							arrival="02:45";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");

							num=19105;
									source="ahmedabad";
									arrival="10:05";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");

									num=12937;
											source="ahmedabad";
											arrival="23:25";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="vadodara";
											arrival="01:10";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="ratlam";
											arrival="05:55";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="kota";
											arrival="09:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="agra";
											arrival="15:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="tundla";
											arrival="16:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=12937;
											source="kanpur";
											arrival="19:55";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="allahabad";
											arrival="22:30";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="mughal sarai";
											arrival="02:45";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="gaya";
											arrival="05:45";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="dhanbad";
											arrival="09:05";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="asansol";
											arrival="10:05";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=12937;
											source="kolkata";
											arrival="13:05";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


									
									num=22905;
											source="ahmedabad";
											arrival="16:15";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="vadodara";
											arrival="18:00";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="surat";
											arrival="19:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="nandurbar";
											arrival="22:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="nandurbar";
											arrival="22:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="bhusaval";
											arrival="03:10";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="nagpur";
											arrival="10:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="durg";
											arrival="01:38";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="raipur";
											arrival="14:20";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="bilaspur";
											arrival="16:10";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="rourkela";
											arrival="20:24";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="nandurbar";
											arrival="22:50";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="chakaradharpur";
											arrival="22:15";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="tatanagar";
											arrival="23:28";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


											num=22905;
											source="kharagpur";
											arrival="01:25";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");

											num=22905;
											source="howrah";
											arrival="03:35";
											content1.put("trainno",num);
											content1.put("source",source);
											content1.put("arrival",arrival);
											database.insert("inode",null,content1);					
											Log.i("inserted","inserted49");


									
									num=19105;
									source="abu";
									arrival="14:40";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");


									num=19105;
									source="ajmer";
									arrival="20:25";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");


									num=19105;
									source="jaipur";
									arrival="23:00";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");


									num=19105;
									source="banikui";
									arrival="00:30";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");


									num=19105;
									source="alwar";
									arrival="01:36";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");


									num=19105;
									source="rewari";
									arrival="03:10";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");

									num=19105;
									source="delhi";
									arrival="04:18";
									content1.put("trainno",num);
									content1.put("source",source);
									content1.put("arrival",arrival);
									database.insert("inode",null,content1);					
									Log.i("inserted","inserted49");


							
							num=16539;
							source="vadodara";
							arrival="04:40";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");

							num=16539;
							source="ahmedabad";
							arrival="06:45";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");



							num=11096;
							source="ahmedabad";
							arrival="07:45";
							content1.put("trainno",num);
							content1.put("source",source);
							content1.put("arrival",arrival);
							database.insert("inode",null,content1);					
							Log.i("inserted","inserted49");


					
			num=12549;
			source="delhi";
			arrival="09:29";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=10450;
			source="delhi";
			arrival="07:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			
			num=16574;
			source="delhi";
			arrival="10:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			
			num=14901;
			source="howrah";
			arrival="13:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15406;
			source="delhi";
			arrival="20:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");


			num=15602;
			source="kota";
			arrival="00:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			
			num=15602;
			source="delhi";
			arrival="06:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");

			

			num=11404;
			source="kolhapur";
			arrival="12:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted28");

			num=11404;
			source="miraj";
			arrival="13:50";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted29");
			
			
			num=11404;
			source="barsi";
			arrival="18:53";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted30");
			
			
			num=11404;
			source="usmanabad";
			arrival="19:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted31");
			
			num=11404;
			source="latur";
			arrival="21:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted32");
			
			
			num=11404;
			source="parbhani";
			arrival="02:28";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted33");
			
			num=11404;
			source="purna";
			arrival="03:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted34");
			
			num=11404;
			source="akola";
			arrival="07:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted35");
			
			num=11404;
			source="badnera";
			arrival="09:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted36");
			
			num=11404;
			source="dhamangaon";
			arrival="09:51";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted37");
			
			num=11404;
			source="nagpur";
			arrival="12:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted38");
			
			num=17013;
			source="pune";
			arrival="14:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted39");
			
			num=17013;
			source="daund";
			arrival="15:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted40");
			
			num=17013;
			source="kurduwadi";
			arrival="17:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted41");
			
			num=17013;
			source="barsi";
			arrival="18:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted42");
			
			
			num=17013;
			source="usmanabad";
			arrival="19:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted43");
			
			num=17013;
			source="latur";
			arrival="20:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted44");
			
			
			num=17013;
			source="usmanabad";
			arrival="19:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted45");
			
			num=17013;
			source="udgir";
			arrival="22:33";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted46");
			
			num=17013;
			source="bidar";
			arrival="00:15";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted47");
			
			num=17013;
			source="vikarabad";
			arrival="02:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted48");
			
			num=17013;
			source="hyderabad";
			arrival="04:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted49");
			
			
			num=12135;
			source="pune";
			arrival="9:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);
								
			Log.i("inserted","inserted4");
			num=12135;
			source="daund";
			arrival="10:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted5");
			
			
			num=10000;
			source="pune";
			arrival="11:45";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted5");
			
			num=10000;
			source="lonavala";
			arrival="13:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted5");
			
			num=10000;
			source="karjat";
			arrival="14:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);		
			Log.i("inserted","inserted5");
			
			num=10000;
			source="panvel";
			arrival="15:35";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);
								
			Log.i("inserted","inserted5");
			
			num=10000;
			source="thane";
			arrival="16:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);
								
			Log.i("inserted","inserted5");
			
			num=10000;
			source="mumbai";
			arrival="18:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);
								
			Log.i("inserted","inserted5");
			
			
			num=12135;
			source="manmad";
			arrival="11:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);
			
Log.i("inserted","inserted6");
			
			num=12135;
			source="bhusaval";
			arrival="12:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);
								
			Log.i("inserted","inserted7");
			
			num=12135;
			source="wardha";
			arrival="15:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted8");
			
			num=12135;
			source="nagpur";
			arrival="17:04";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted8");
			
			num=12105;
			source="mumbai";
			arrival="19:10";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted9");
			
			num=12105;
			source="nashik";
			arrival="22:40";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted10");
			
			num=12105;
			source="jalgaon";
			arrival="01:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted11");
			
			num=12105;
			source="bhusaval";
			arrival="02:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted12");
			
			num=12105;
			source="wardha";
			arrival="07:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted13");
			
			num=12105;
			source="nagpur";
			arrival="09:20";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted14");
			
			num=12833;
			source="ahmedabad";
			arrival="23:55";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted15");
			
			num=12833;
			source="vadodara";
			arrival="00:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted16");
			
			num=12833;
			source="surat";
			arrival="04:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted17");
			
			num=12833;
			source="jalgaon";
			arrival="09:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted18");
			
			num=12833;
			source="bhusaval";
			arrival="12:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted19");
			
			num=12833;
			source="nagpur";
			arrival="15:25";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted20");
			
			num=12833;
			source="howrah";
			arrival="17:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted21");
			
			
			num=11111;
			source="pune";
			arrival="08:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted22");
			
			
			num=11111;
			source="mumbai";
			arrival="10:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted23");
			
			num=11111;
			source="nashik";
			arrival="12:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted24");
			
		
			num=11111;
			source="akola";
			arrival="14:00";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted25");
			
		
			num=11111;
			source="pulgaon";
			arrival="16:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted26");
			
			
			num=11111;
			source="nagpur";
			arrival="18:30";
			content1.put("trainno",num);
			content1.put("source",source);
			content1.put("arrival",arrival);
			database.insert("inode",null,content1);					
			Log.i("inserted","inserted27");
			
			
			
			String city="pune";
			double latitude=18.520430;
			double longitude=73.856744;
			ContentValues content2=new ContentValues();
			
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted28");
		
			city="jalgaon";
    		latitude=21.016700;
			longitude=75.566700;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);					
			Log.i("inserted","inserted29");
	
			city="mumbai";
			latitude=19.075984;
			longitude=72.877656;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
	
			city="lonavala";
			latitude=18.747490;
			longitude=73.403442;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="khandala";
			latitude=20.014009;
			longitude=74.791122;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="vasai";
			latitude=19.392674;
			longitude=72.861643;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="akola";
			latitude=20.703880;
			longitude=76.997093;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
				
			city="bangalore";
			latitude=12.971599;
			longitude=77.594563;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="cuttack";
			latitude=20.462521;
			longitude=85.882990;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="bhubaneshwar";
			latitude=20.296059;
			longitude=85.824540;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="visakhapatnum";
			latitude=17.686816;
			longitude=83.218482;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="vijayawada";
			latitude=16.506174;
			longitude=80.648015;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="gondia";
			latitude=21.450000;
			longitude=80.200000;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="secunderabad";
			latitude=17.439930;
			longitude=78.498274;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="chirala";
			latitude=15.816700;
			longitude=80.350000;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="patna";
			latitude=25.612500;
			longitude=85.128333;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="titlagarh";
			latitude=20.300000;
			longitude=83.150000;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="vizianagaram";
			latitude=18.106658;
			longitude=83.395551;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="nellore";
			latitude=14.442599;
			longitude=79.986456;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="gudur";
			latitude=14.146319;
			longitude=79.850389;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			
			city="chennai";
			latitude=13.052414;
			longitude=80.250825;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="fatehpur";
			latitude=25.933300;
			longitude=80.800000;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kanpur";
			latitude=26.449923;
			longitude=80.331874;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
	
			city="aligarh";
			latitude=27.893810;
			longitude=78.068138;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="ghaziabad";
			latitude=28.669157;
			longitude=77.453758;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="dhamangaon";
			latitude=20.786088;
			longitude=78.140765;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="purna";
			latitude=19.180531;
			longitude=77.020973;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="parbhani";
			latitude=19.257790;
			longitude=76.773743;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="miraj";
			latitude=16.816502;
			longitude=74.642473;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kolhapur";
			latitude=16.691308;
			longitude=74.244866;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="hyderabad";
			latitude=17.385044;
			longitude=78.486671;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="vikarabad";
			latitude=17.336430;
			longitude=77.904848;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="bidar";
			latitude=17.920000;
			longitude=77.519722;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="udgir";
			latitude=18.394288;
			longitude=77.112601;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="latur";
			latitude=18.397680;
			longitude=76.580971;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="usmanabad";
			latitude=18.186066;
			longitude=76.041941;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="barsi";
			latitude=18.233386;
			longitude=75.694148;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kurduwadi";
			latitude=18.088676;
			longitude=75.425632;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="thane";
			latitude=19.218331;
			longitude=72.978090;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="panvel";
			latitude=18.989401;
			longitude=73.117516;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="karjat";
			latitude=18.919225;
			longitude=73.327722;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kolkata";
			latitude=22.572646;
			longitude=88.363895;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="asansol";
			latitude=23.687210;
			longitude=86.973343;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="dhanbad";
			latitude=23.795653;
			longitude=86.430386;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="gaya";
			latitude=24.780011;
			longitude=84.981823;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="mughal sarai";
			latitude=25.281495;
			longitude=83.119820;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="allahabad";
			latitude=25.435801;
			longitude=81.846311;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
					
			city="tundla";
			latitude=27.210246;
			longitude=78.232970;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="agra";
			latitude=27.176670;
			longitude=78.008075;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kharagpur";
			latitude=22.330400;
			longitude=87.318108;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="tatanagar";
			latitude=22.804566;
			longitude=86.202875;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="chakaradharpur";
			latitude=22.671810;
			longitude=85.626221;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="rewari";
			latitude=28.188110;
			longitude=76.611542;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="banikui";
			latitude=27.050000;
			longitude=76.566700;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="abu";
			latitude=24.592500;
			longitude=72.715556;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kalyan";
			latitude=19.241201;
			longitude=73.129060;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="gangapur";
			latitude=19.698754;
			longitude=75.008540;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
	
			city="shamgarh";
			latitude=24.183300;
			longitude=75.633300;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="nagda";
			latitude=23.450000;
			longitude=75.416700;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="dahod";
			latitude=22.832300;
			longitude=74.253464;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="godhra";
			latitude=22.765150;
			longitude=73.609383;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="mathura";
			latitude=27.492413;
			longitude=77.673673;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="anuppur";
			latitude=23.101645;
			longitude=81.697937;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="tumsar";
			latitude=21.385522;
			longitude=79.754468;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="hatia";
			latitude=22.749659;
			longitude=85.917677;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="gurgaon";
			latitude=28.459497;
			longitude=77.026638;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="alwar";
			latitude=27.560932;
			longitude=76.625017;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="jaipur";
			latitude=26.912416;
			longitude=75.787288;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="ajmer";
			latitude=26.450000;
			longitude=74.640000;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="palanpur";
			latitude=24.171408;
			longitude=72.432593;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="sabarmati";
			latitude=22.400909;
			longitude=72.372549;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="rourkela";
			latitude=22.260423;
			longitude=84.853584;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="raigarh";
			latitude=21.895667;
			longitude=83.395245;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="bilaspur";
			latitude=22.079625;
			longitude=82.139141;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
	
			city="raipur";
			latitude=21.251384;
			longitude=81.629641;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
	
			city="durg";
			latitude=21.189367;
			longitude=81.283039;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="badnera";
			latitude=20.853991;
			longitude=77.727592;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="nandurbar";
			latitude=21.375551;
			longitude=74.242764;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="gwalior";
			latitude=26.218287;
			longitude=78.182831;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="jhansi";
			latitude=25.444121;
			longitude=78.567604;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="bina";
			latitude=24.169331;
			longitude=78.187897;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="bhopal";
			latitude=23.259933;
			longitude=77.412615;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="itarsi";
			latitude=22.605486;
			longitude=77.753544;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="khandva";
			latitude=21.825733;
			longitude=76.352571;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="delhi";
			latitude=28.635308;
			longitude=77.224960;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="kota";
			latitude=25.213816;
			longitude=75.864753;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="ratlam";
			latitude=23.334170;
			longitude=75.037632;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted30");
			
			city="nashik";
    		latitude=20.02;
			longitude=73.50;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted31");
	
			city="nagpur";
			latitude=21.145800;
			longitude=79.088155;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted32");
					
			city="wardha";
			latitude=20.45;
			longitude=78.39;				
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);
			Log.i("inserted","inserted33");
					
			city="bhusaval";
			latitude=21.047371;
			longitude=75.787659;												
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);		
			Log.i("inserted","inserted34");
							
			city="daund";
			latitude=18.463056;
			longitude=74.578889;						 										
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);								
			Log.i("inserted","inserted35");	
											
			city="manmad";
			latitude=20.249901;
			longitude=74.435860;			
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);									
			Log.i("inserted","inserted36");	
													

			city="ahmedabad";
			latitude=23.022505;
			longitude=72.571362;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);									
			Log.i("inserted","inserted37");
		
			city="vadodara";
			latitude=22.307309;
			longitude=73.181098;
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);									
			Log.i("inserted","inserted38");
			
			city="surat";
			latitude=21.195000;
			longitude=72.819444;	
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);								
			Log.i("inserted","inserted39");
	
			city="howrah";
			latitude=22.595769;
			longitude=88.263639;				
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);									
			Log.i("inserted","inserted40");
		

			city="pulgaon";
			latitude=20.72;
			longitude=78.31;						
			content2.put("city",city);
			content2.put("latitude",latitude);
			content2.put("longitude",longitude);
			database.insert("latlng",null,content2);									
			Log.i("inserted","inserted41");
							
			return(true);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally{
			close();
		}
		return(true);
	}
	public Cursor search1(String s,String d)
	{
		open();
		String sql="Select * from train where inter like '%"+s+"%"+d+"%'";
		Log.i("Found","Found train");
		return( database.rawQuery(sql, null));
	}
	public Cursor searcharrival(String trainum,String s)
	{
		open();
		String sql="Select * from inode where source='"+s+"' and trainno='"+trainum+"'";
		Log.i("Found","intermdte");
		return( database.rawQuery(sql, null));
	}
	public Cursor search(String s)
	{
		open();
		String sql="Select * from train where trainname='"+s+"'";
		Log.i("Found","Foundstations");
		return( database.rawQuery(sql, null));
	}
	public Cursor searchjunction(String s,String d)
	{
		open();
		String sql="Select junction from train where source='"+s+"' and dest='"+d+"'";
		Log.i("Found","Foundjunc");
		return(database.rawQuery(sql, null));
	}
	public Cursor searchlatlng(String s)
	{
		open();
		String sql="Select * from latlng where city='"+s+"'";
		Log.i("Found","Foundlatlng");
		return(database.rawQuery(sql, null));
	}
	/*public void updatedb(String s,int ava)
	{
		open();
		String sql ="update train set avail='ava' where trainnum='"+s+"'";
		database.execSQL(sql);
	}*/
	
	public String updatedb(String s,int avail)
	{
		try{
		open();
		ContentValues content4=new ContentValues();
		content4.put("avail", avail);
		//String sql="UPDATE train set avail='avail' where trainnum='"+s+"'";
		//database.execSQL(sql);
		int v=database.update("train", content4, "trainnum="+s+"", null);
		return "ok";}
		catch(Exception e)
			{return e.getMessage();}
	}
	public Cursor searchtrainsingle(String s)
	{
		open();
		String sql="Select * from train where inter like '%"+s+"%'";
		Log.i("Found","Foundlatlng");
		return(database.rawQuery(sql, null));
	}

	
	
}
	