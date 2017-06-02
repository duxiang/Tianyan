package com.example.artilleryandroid;







import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
	public String passw;
	public EditText edt1;
	private BluetoothAdapter mBluetoothAdapter = null,mBluetoothAdapter1 = null,mBluetoothAdapter2 = null,mBluetoothAdapter3 = null;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
		Toast.makeText(MainActivity.this, "欢迎使用天眼!\n单击地球图像开始使用!\n请允许开启蓝牙和定位权限(预留连接激光测距机用)，否则程序无法运行!", Toast.LENGTH_LONG).show();
    	SharedPreferences spf=getSharedPreferences("Art",Context.MODE_WORLD_WRITEABLE);  
     	//Cipianmiwei=(double)spf.getFloat("Cipianmiwei", 0);
		final BluetoothManager bluetoothManager =
				(BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
		mBluetoothAdapter = bluetoothManager.getAdapter();
		if (!mBluetoothAdapter.isEnabled()) mBluetoothAdapter.enable();
      	
    	((EditText)findViewById(R.id.EditText101)).setText(spf.getString("Keya","password"));
        ((Button)findViewById(R.id.Button301)).requestFocus();;


		android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	public void Clickjinru(View v){
		Intent intent=new Intent(MainActivity.this,Menuofmian.class);

		startActivity(intent);


	}
    public void Click1_1(View v){
    	edt1=(EditText)findViewById(R.id.EditText101);
   passw=edt1.getText().toString();
   ////
		SharedPreferences spf=getSharedPreferences("Art",Context.MODE_WORLD_WRITEABLE);  
 	   	
		   
    	SharedPreferences.Editor edit=spf.edit();
    
    	edit.putString("Keya", passw);

  	
  	
  	
    	edit.commit();

    //passw.equals("11110228")
	 WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);   
    if (!wifiManager.isWifiEnabled()) {   
    	wifiManager.setWifiEnabled(true);    
  }   
    WifiInfo wifiInfo = wifiManager.getConnectionInfo();       


	    String macAddress = null;
	 //   WifiInfo wifiInfo = getWifiinfo(getApplicationContext());
	
	    if (wifiInfo != null) {
	        macAddress = wifiInfo.getMacAddress();
	    }

	//((EditText)findViewById(R.id.MainTitleTextView)).setText(spf.getString("Key","password"));
	   String Sl =null,Psw=null;
	   Sl= macAddress.split(":")[0]+macAddress.split(":")[1]+macAddress.split(":")[2];
	long Psss=0;
	Psss=Integer.parseInt(Sl, 16);


	//if(spf.getString("Keya","password").equals(""+Psss))

	//	if(spf.getLong("Adnum",0 )>0)

	    { 
	    
		//Toast.makeText(MainActivity.this, "秘钥错误" , Toast.LENGTH_LONG).show();
	//	Toast.makeText(MainActivity.this, "进入程序，下次请点广告支持，谢谢！", Toast.LENGTH_LONG).show();
	//	Toast.makeText(MainActivity.this, (""+Psss), Toast.LENGTH_LONG).show();
	//		edit.putLong("Adnum", spf.getLong("Adnum",0 )-1);
	//		edit.commit();
		Intent intent=new Intent(MainActivity.this,Menuofmian.class);

	    startActivity(intent);
		
	    }
	
	//else
	{
	//	Toast.makeText(MainActivity.this, "权限数不足，请返回点击广告补充！", Toast.LENGTH_LONG).show();
		
	}
   
   
   ////

    }
    
    public void Click1_2(View v){

		Intent intent=new Intent(MainActivity.this,SplashActivity.class);

		startActivity(intent);
    finish();
 //finishActivity(0);
    //End;
    	//destory();
    }
    /*
    public void Click1_3(View v){
    	Intent intent=new Intent(MainActivity.this,Menuofmian.class);
    	//intent.setClass(MainActivity.this,Menuofmian.class);
	    startActivity(intent);
		
    	
    }
    */
    
}
