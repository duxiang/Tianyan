package com.example.artilleryandroid.sdkDemo;//package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artilleryandroid.old.BluetoothService;
import com.example.artilleryandroid.old.BluetoothService1;
import com.example.artilleryandroid.old.BluetoothService2;
import com.example.artilleryandroid.old.BluetoothService3;
import com.example.artilleryandroid.old.DeviceListActivity;
import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.R;

import java.io.File;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

//public class DataMonitor extends FragmentActivity implements OnClickListener
public class DataMonitor222 extends Activity {

	boolean slideAction = false;
	private BluetoothAdapter mBluetoothAdapter = null,mBluetoothAdapter1 = null,mBluetoothAdapter2 = null,mBluetoothAdapter3 = null;
	private BluetoothService mBluetoothService = null;
	private BluetoothService1 mBluetoothService1 = null;
	private BluetoothService2 mBluetoothService2 = null;
	private BluetoothService3 mBluetoothService3 = null;
	private String mConnectedDeviceName = null,mConnectedDeviceAddress=null;

	private TextView mTitle;
	private boolean recordStartorStop=false;


	public Function ggg =new Function() ;
	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;

	public static final int MESSAGE_READShejiao = 12;
	public static final int MESSAGE_READFangxiang = 13;

	public static final int MESSAGE_Shuaxinxianshi = 144;
	public static final int MESSAGE_READGps1 = 145;
	public static final int MESSAGE_READGps2 = 146;
	public int Chuanganleixing=1;//0为无，1为射角，2为方向1，3为方向2，4为方向3，
	public float Shejiaoxiuzheng=0;
	public float Fangxiangxiuzheng=0,Fenhuaxiuzheng=0,Fangxiangxiuzhenggps=0,Fenhuaxiuzhenggps=0,Biaochiyuzhi=10,Fangxiangyuzhi=30,Fangxiangdanxiu=0,Gaodidanxiu=0;
	public float Shejiao,Fangxiang,Fenhua,Fangxianggps,Fenhuagps,Shejiaodanxiuhou,Fangxiangdanxiuhou,Fenhuadanxiuhou,Fangxianggpsdanxiuhou,Fenhuagpsdanxiuhou;
	public float Tempxianshi;
	public float Shangjibiaochi=0,Shangjifenhua=0;
	protected static final String TAG = null;
	Spinner spinner1,spinner2,spinner3;
    WifiManager Manager,Managerm;
    MulticastLock Lock,Lockm;
    Socket Socket1,Socket1m;
    MulticastSocket Ms1,Ms1mr;
    DatagramPacket Dp1,Dp1mr;
	public String Sendtemp,Sendtempm;
	public int Jianceying,Jiancelian,Jiancepao,Recying,Reclian,Recyingm,Reclianm,Recpaom;
    public Thread Bro,Rec,Refresh,Brom,Recm,Refreshm;
 public Message Msgtemp,Msgtempm;
	public boolean Exitbro,Exitrec,Exitrefresh;
	public String Daichaistring,Daichaistringm;
	public double Weidugps1,Weidugps2,Jingdugps1,Jingdugps2,Xgps1=0,Ygps1=0,Xgps2,Ygps2,Juligps;
public long Timek;
public String Stringall="",Stringrectem="";
public int Temi,Temj,Temk,Teml;
	public int Working,Workingm;//0 free 1 busy
	  public int Miaoshu,Zhuyuanzhuangtai,Lianjiezhuangtai,Yichangzhuangtai;
	////zhuyuanzhuangtai0为未知，1为正常，2为异常//Lianjiezhuangtai0为未连接，1为已连接
	////22222Yichangzhuangtai0为为正常，1为异常
		public String Lianjiezhuangtaizifu[]=new String[5];
		public String Zhuyuanzhuangtaizifu[]=new String[5];
		public String Xinxijilu[][][]=new String[10][10][10];
		public	String Strtempm;
		public	String Addr[]=new String[10];

		public MediaPlayer mPlayer;
	  /*

	   */
	public Handler mHandler,mHandler1;
	private static final int REQUEST_CONNECT_DEVICE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);


	//	setContentView(R.layout.main);
		setContentView(R.layout.frag1);
	getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		mTitle = (TextView) findViewById(R.id.title_right_text);
		Working=0;
		   Workingm=0;
	    	//Dituweidupiancha=spf.getFloat("Dituweidupiancha", 0);
	    	//Ditujingdupiancha=spf.getFloat("Ditujingdupiancha", 0);






     //   Spinner spinner1,spinner2,spinner3;
       // spinner1=(Spinner)findViewById(R.id.spinner1);
      //  spinner2=(Spinner)findViewById(R.id.spinner2);
      //  spinner3=(Spinner)findViewById(R.id.spinner3);


		try {
			Miaoshu=0;
			Lianjiezhuangtai=0;
              Zhuyuanzhuangtai=0;
Yichangzhuangtai=0;
Lianjiezhuangtaizifu[0]="已断开";
Lianjiezhuangtaizifu[1]="已连接";
Zhuyuanzhuangtaizifu[0]="未知";
Zhuyuanzhuangtaizifu[1]="正常";
Zhuyuanzhuangtaizifu[2]="异常";
Duqushuaxinchuangan();

for(Temi=0;Temi<=9;Temi++)
	for(Temj=0;Temj<=9;Temj++)
		for(Temk=0;Temk<=9;Temk++)

{  Xinxijilu[Temi][Temj][Temk]="无信息";

}

Sendtempm="初次连接";

		     SharedPreferences spf222=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		     Shejiaoxiuzheng   =spf222.getFloat("Shejiaoxiuzheng", 0);
		     Fangxiangxiuzheng   =spf222.getFloat("Fangxiangxiuzheng", 0);
		     Fenhuaxiuzheng   =spf222.getFloat("Fenhuaxiuzheng", 0);
		     Fangxiangxiuzhenggps   =spf222.getFloat("Fangxiangxiuzhenggps", 0);
		     Fenhuaxiuzhenggps   =spf222.getFloat("Fenhuaxiuzhenggps", 0);
				Gaodidanxiu=spf222.getFloat("Gaodidanxiu", 0);
				Fangxiangdanxiu=spf222.getFloat("Fangxiangdanxiu", 0);

				((EditText)findViewById(R.id.editText2)).setText(String.format("% 3.2f",Gaodidanxiu));
				((EditText)findViewById(R.id.editText3)).setText(String.format("% 3.2f",Fangxiangdanxiu));

					//	((TextView)findViewById(R.id.textView16)).setText(new String(dj.getData(),0,dj.getLength()));
					//	Udpbroadcast.sleep(10);
				((TextView)findViewById(R.id.textView39)).setText(String.format("% 3.2f",Gaodidanxiu));
				((TextView)findViewById(R.id.textView40)).setText(String.format("% 3.2f",Fangxiangdanxiu));


			mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
			mBluetoothAdapter1 = BluetoothAdapter.getDefaultAdapter();
			mBluetoothAdapter2 = BluetoothAdapter.getDefaultAdapter();
			mBluetoothAdapter3 = BluetoothAdapter.getDefaultAdapter();
			if (mBluetoothAdapter == null) {
				Toast.makeText(this, "蓝牙不可用", Toast.LENGTH_LONG).show();
				//finish();
				return;
			}

			if (!mBluetoothAdapter.isEnabled()) mBluetoothAdapter.enable();
			if (!mBluetoothAdapter1.isEnabled()) mBluetoothAdapter1.enable();
			if (!mBluetoothAdapter2.isEnabled()) mBluetoothAdapter2.enable();
			if (!mBluetoothAdapter3.isEnabled()) mBluetoothAdapter3.enable();

			///新加

			mHandler = new Handler() {
				// 匿名内部类写法，实现接口Handler的一些方法
				@Override
				public void handleMessage(Message msg) {
					switch (msg.what) {
					case MESSAGE_STATE_CHANGE:
						switch (msg.arg1) {
						case BluetoothService.STATE_CONNECTED:
							mTitle.setText(R.string.title_connected_to);
							mTitle.append(mConnectedDeviceName);
							break;
						case BluetoothService.STATE_CONNECTING:
							mTitle.setText(R.string.title_connecting);
							break;
						case BluetoothService.STATE_LISTEN:
						case BluetoothService.STATE_NONE:
							mTitle.setText(R.string.title_not_connected);
							break;
						}
						break;
					case MESSAGE_READShejiao:
						try {
							float [] fData=msg.getData().getFloatArray("Data");
							switch (RunMode){
								case 0:
									Shejiao= fData[6]/360*6000+Shejiaoxiuzheng;
									Shejiaodanxiuhou=Shejiao-Gaodidanxiu;
									((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiaodanxiuhou));

									switch (iCurrentGroup){

										case 3:

											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));

											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));

											break;

											}
									break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						break;
					//MESSAGE_READGps1
					case MESSAGE_READGps1:
						try {
							float [] fData=msg.getData().getFloatArray("Data");
							switch (RunMode){
								case 0:
							//	case 7://经纬度
							//		((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 14.6f°", fData[18]));
							//		((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 14.6f°", fData[19]));

									Jingdugps1=	msg.getData().getDouble("Jingdut");
									Weidugps1=	msg.getData().getDouble("Weidut");

										((TextView)findViewById(R.id.textView20)).setText("纬度"+Weidugps1+"经度"+Jingdugps1);
									Xgps1=( ggg.Geo2GausiXianX(((double)Jingdugps1),((double)Weidugps1), 3));
									Ygps1=( ggg.Geo2GausiXianY(((double)Jingdugps1),((double)Weidugps1), 3));
									((TextView)findViewById(R.id.textView21)).setText("X"+String.format("% 9.3f", Xgps1)+"Y"+String.format("% 9.3f", Ygps1));
								//

								//	((TextView)findViewById(R.id.textView36)).setText("位置信息\n"+"纬度"+Weidugps1+"经度"+Jingdugps1+"\n直角坐标（大地2000坐标系）:\n"+"X"+String.format("% 9.3f", Xgps1)+"Y"+String.format("% 9.3f", Ygps1));
									((TextView)findViewById(R.id.textView43)).setText("位置信息\n"+"纬度"+Weidugps1+"经度"+Jingdugps1+"\n直角坐标（大地2000坐标系）:\n"+"X"+String.format("% 9.3f", Xgps1)+"Y"+String.format("% 9.3f", Ygps1));

									Fenhuagps=((float)ggg.NiyunsuanFAB(Xgps1, Ygps1, 0, Xgps2, Ygps2, 0))+Fenhuaxiuzhenggps;
									if (Fenhuagps<0){Fenhuagps=Fenhuagps+6000;}
									if (Fenhuagps>=6000){Fenhuagps=Fenhuagps-6000;}
									if (Fenhuagps<0){Fenhuagps=Fenhuagps+6000;}
									if (Fenhuagps>=6000){Fenhuagps=Fenhuagps-6000;}


									Fangxianggps=((float)ggg.NiyunsuanFAB(Xgps1, Ygps1, 0, Xgps2, Ygps2, 0))+Fangxiangxiuzhenggps;

									if (Fangxianggps<0){Fangxianggps=Fangxianggps+6000;}
									if (Fangxianggps>=6000){Fangxianggps=Fangxianggps-6000;}
									if (Fangxianggps<0){Fangxianggps=Fangxianggps+6000;}
									if (Fangxianggps>=6000){Fangxianggps=Fangxianggps-6000;}
							//		((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiao));
									((TextView)findViewById(R.id.textView33)).setText(String.format("% 10.2f密位", Fenhuagps));

									((TextView)findViewById(R.id.textView35)).setText(String.format("% 10.2f密位", Fangxianggps));


									/*
									 *
									 *     	if(ZuoBiaoXi==0) {	et9.setText("北京54"); } ;
    	if(ZuoBiaoXi==1) {	et9.setText("西安80"); };
    	if(ZuoBiaoXi==2) {	et9.setText("WGS84"); };
    	if(ZuoBiaoXi==3) {	et9.setText("大地2000"); };

    	Xyuanshi=ggg.Geo2GausiXianX(JingDu,WeiDu,  ZuoBiaoXi);
    	Xzuizhong=Xyuanshi+XiuZhengX;
   ZhengX=(long) Xzuizhong;
    	et10.setText(""+ZhengX);
    	//////////////////////////////
    	Yyuanshi=ggg.Geo2GausiXianY(JingDu, WeiDu, ZuoBiaoXi);



										*/
										//	((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));

											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//	Shejiao= fData[6]/360*6000+Shejiaoxiuzheng;
											//				((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiao));



									break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						break;

						//MESSAGE_READGps2
						case MESSAGE_READGps2:
							try {
								float [] fData=msg.getData().getFloatArray("Data");
								switch (RunMode){
									case 0:
								//	case 7://经纬度
								//		((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 14.6f°", fData[18]));
								//		((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 14.6f°", fData[19]));

										Jingdugps2=	msg.getData().getDouble("Jingdut");
										Weidugps2=	msg.getData().getDouble("Weidut");
										Stringrectem=msg.getData().getString("String");
										((TextView)findViewById(R.id.textView45)).setText("BT"+Stringrectem);

										if (Stringrectem.charAt(0)=='$')
										{
											if (Stringall.charAt(1)=='P')
											{

												if(Float.parseFloat((Stringall.split(",")[3]))==0){
													((TextView)findViewById(R.id.textView44))
													.setText("未完成定向");}
												else
												{((TextView)findViewById(R.id.textView44))
													.setText("完成定向");

													//.setText(Stringall.split(",")[4]);
												}

											}
											if (Stringall.charAt(1)=='H')
											{
												Fenhuagps=Float.parseFloat(Stringall.split(",")[1])*6000/360+Fenhuaxiuzhenggps;
												if (Fenhuagps<0){Fenhuagps=Fenhuagps+6000;}
												if (Fenhuagps>=6000){Fenhuagps=Fenhuagps-6000;}
												if (Fenhuagps<0){Fenhuagps=Fenhuagps+6000;}
												if (Fenhuagps>=6000){Fenhuagps=Fenhuagps-6000;}


												Fangxianggps=Float.parseFloat(Stringall.split(",")[1])*6000/360+Fangxiangxiuzhenggps;

												if (Fangxianggps<0){Fangxianggps=Fangxianggps+6000;}
												if (Fangxianggps>=6000){Fangxianggps=Fangxianggps-6000;}
												if (Fangxianggps<0){Fangxianggps=Fangxianggps+6000;}
												if (Fangxianggps>=6000){Fangxianggps=Fangxianggps-6000;}
										//		((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiao));
												((TextView)findViewById(R.id.textView33)).setText(String.format("% 10.2f密位", Fenhuagps));

												((TextView)findViewById(R.id.textView35)).setText(String.format("% 10.2f密位", Fangxianggps));


											}
											Stringall=Stringrectem;
										}else{
											Stringall=Stringall+""+Stringrectem;
										}
									//	((TextView)findViewById(R.id.textView36)).setText(Stringall);
										;
									//		((TextView)findViewById(R.id.textView22)).setText("纬度"+Weidugps2+"经度"+Jingdugps2);
									//	Xgps2=( ggg.Geo2GausiXianX(((double)Jingdugps2),((double)Weidugps2), 3));
									//	Ygps2=( ggg.Geo2GausiXianY(((double)Jingdugps2),((double)Weidugps2), 3));
										//((TextView)findViewById(R.id.textView23)).setText("X"+Xgps2+"Y"+Ygps2);
									//	((TextView)findViewById(R.id.textView21)).setText("X"+String.format("% 9.3f°", Xgps1)+"Y"+String.format("% 9.3f°", Ygps1));
									//	((TextView)findViewById(R.id.textView23)).setText("X"+String.format("% 9.3f", Xgps2)+"Y"+String.format("% 9.3f", Ygps2));
									//	Fenhuagps=((float)ggg.NiyunsuanFAB(Xgps1, Ygps1, 0, Xgps2, Ygps2, 0))+Fenhuaxiuzhenggps;
									//新改协议
										/*
										Fenhuagps=Float.parseFloat(Stringall.split(",")[4])*6000/360+Fenhuaxiuzhenggps;
										if (Fenhuagps<0){Fenhuagps=Fenhuagps+6000;}
										if (Fenhuagps>=6000){Fenhuagps=Fenhuagps-6000;}
										if (Fenhuagps<0){Fenhuagps=Fenhuagps+6000;}
										if (Fenhuagps>=6000){Fenhuagps=Fenhuagps-6000;}


										Fangxianggps=Float.parseFloat(Stringall.split(",")[4])*6000/360+Fangxiangxiuzhenggps;

										if (Fangxianggps<0){Fangxianggps=Fangxianggps+6000;}
										if (Fangxianggps>=6000){Fangxianggps=Fangxianggps-6000;}
										if (Fangxianggps<0){Fangxianggps=Fangxianggps+6000;}
										if (Fangxianggps>=6000){Fangxianggps=Fangxianggps-6000;}
								//		((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiao));
										((TextView)findViewById(R.id.textView33)).setText(String.format("% 10.2f密位", Fenhuagps));

										((TextView)findViewById(R.id.textView35)).setText(String.format("% 10.2f密位", Fangxianggps));
										*/
										//新改协议
										/*
										 *
										 *     	if(ZuoBiaoXi==0) {	et9.setText("北京54"); } ;
	    	if(ZuoBiaoXi==1) {	et9.setText("西安80"); };
	    	if(ZuoBiaoXi==2) {	et9.setText("WGS84"); };
	    	if(ZuoBiaoXi==3) {	et9.setText("大地2000"); };

	    	Xyuanshi=ggg.Geo2GausiXianX(JingDu,WeiDu,  ZuoBiaoXi);
	    	Xzuizhong=Xyuanshi+XiuZhengX;
	   ZhengX=(long) Xzuizhong;
	    	et10.setText(""+ZhengX);
	    	//////////////////////////////
	    	Yyuanshi=ggg.Geo2GausiXianY(JingDu, WeiDu, ZuoBiaoXi);



											*/
											//	((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));

												//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
												//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
												//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
												//	Shejiao= fData[6]/360*6000+Shejiaoxiuzheng;
												//				((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiao));



										break;
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;



					case MESSAGE_READFangxiang:
						try {
							float [] fData=msg.getData().getFloatArray("Data");
							switch (RunMode){
								case 0:
									Fenhua=-fData[8]/360*6000+Fenhuaxiuzheng;
									if (Fenhua<0){Fenhuaxiuzheng=Fenhuaxiuzheng+6000;}
									if (Fenhua>=6000){Fenhuaxiuzheng=Fenhuaxiuzheng-6000;}
									//if (Fenhua<0){Fenhuaxiuzheng=Fenhuaxiuzheng+6000;}
									//if (Fenhua>=6000){Fenhuaxiuzheng=Fenhuaxiuzheng-6000;}
									Fenhuadanxiuhou=Fenhua-Fangxiangdanxiu;
									Fenhua=-fData[8]/360*6000+Fenhuaxiuzheng;
									Fenhuadanxiuhou=Fenhua-Fangxiangdanxiu;


									Fangxiang=-fData[8]/360*6000+Fangxiangxiuzheng;

									if (Fangxiang<0){Fangxiangxiuzheng=Fangxiangxiuzheng+6000;}
									if (Fangxiang>=6000){Fangxiangxiuzheng=Fangxiangxiuzheng-6000;}
								//	if (Fangxiang<0){Fangxiangxiuzheng=Fangxiangxiuzheng+6000;}
								//	if (Fangxiang>=6000){Fangxiangxiuzheng=Fangxiangxiuzheng-6000;}
									Fangxiang=-fData[8]/360*6000+Fangxiangxiuzheng;
							//		((TextView)findViewById(R.id.textView2)).setText(String.format("% 10.2f密位", Shejiao));
									((TextView)findViewById(R.id.textView4)).setText(String.format("% 10.2f密位", Fenhuadanxiuhou));

									((TextView)findViewById(R.id.textView6)).setText(String.format("% 10.2f密位", Fangxiang));


									switch (iCurrentGroup){
										case 0:
											((TextView)findViewById(R.id.tvNum1)).setText(msg.getData().getString("Date"));
											((TextView)findViewById(R.id.tvNum2)).setText(msg.getData().getString("Time"));
											break;
										case 1:
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2fg", fData[0]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2fg", fData[1]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.2fg", fData[2]));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 10.2f℃", fData[17]));
											break;
										case 2:
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f°/s", fData[3]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2f°/s", fData[4]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.2f°/s", fData[5]));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 10.2f℃", fData[17]));
											break;
										case 3:

									//		((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2f密位", fData[7]/360*6000));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.2f密位", -fData[8]/360*6000));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 10.2f℃", fData[17]));

											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f密位", fData[6]/360*6000));
									//			Shejiao= fData[6]/360*6000+Shejiaoxiuzheng;

											break;





											//((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f°", fData[6]));
										//	((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2f°", fData[7]));
											//((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.2f°", fData[8]));
										//	((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 10.2f℃", fData[17]));
										//	break;
										case 4://磁场
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.0f", fData[9]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.0f", fData[10]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.0f", fData[11]));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 10.2f℃", fData[17]));
											break;
										case 5://端口
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2f", fData[12]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2f", fData[13]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.2f", fData[14]));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 10.2f", fData[15]));
											break;
										case 6://气压
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2fPa", fData[16]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2fm", fData[17]));
											break;
										case 7://经纬度
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 14.6f°", fData[18]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 14.6f°", fData[19]));
											break;
										case 8://地速
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 10.2m", fData[20]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 10.2°", fData[21]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 10.2m/s", fData[22]));
											break;
										case 9://四元数
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 7.3f", fData[23]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 7.3f", fData[24]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 7.3f", fData[25]));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 7.3f", fData[26]));
											break;
										case 10:
											((TextView)findViewById(R.id.tvNum1)).setText(String.format("% 5.0f", fData[27]));
											((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 7.1f", fData[28]));
											((TextView)findViewById(R.id.tvNum3)).setText(String.format("% 7.1f", fData[29]));
											((TextView)findViewById(R.id.tvNum4)).setText(String.format("% 7.1f", fData[30]));
											break;
									}
									break;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						break;
					case MESSAGE_DEVICE_NAME:
						mConnectedDeviceName = msg.getData().getString("device_name");
						//bundle.putString("device_address", device.getAddress());
					//	bundle.putInt("Chuanganqihao", 1);
						mConnectedDeviceAddress=msg.getData().getString("device_address");
						if(msg.getData().getInt("Chuanganqihao")==1)
						{((TextView)findViewById(R.id.textView24)).setText("已连接设备号" + mConnectedDeviceName+"\n地址"+mConnectedDeviceAddress);

						}
						if(msg.getData().getInt("Chuanganqihao")==2)
						{((TextView)findViewById(R.id.textView25)).setText("已连接设备号" + mConnectedDeviceName+"\n地址"+mConnectedDeviceAddress);

						}
						if(msg.getData().getInt("Chuanganqihao")==3)
						{((TextView)findViewById(R.id.textView26)).setText("已连接设备号" + mConnectedDeviceName+"\n地址"+mConnectedDeviceAddress);

						}
						if(msg.getData().getInt("Chuanganqihao")==4)
						{((TextView)findViewById(R.id.textView27)).setText("已连接设备号" + mConnectedDeviceName+"\n地址"+mConnectedDeviceAddress);

						}
						Toast.makeText(getApplicationContext(),"已连接设备号" + mConnectedDeviceName+"地址"+mConnectedDeviceAddress,Toast.LENGTH_SHORT).show();


						break;
					case MESSAGE_TOAST:
						if(msg.getData().getInt("Chuanganqihao")==1)
						{((TextView)findViewById(R.id.textView24)).setText(msg.getData().getString("toast"));

						}
						if(msg.getData().getInt("Chuanganqihao")==2)
						{((TextView)findViewById(R.id.textView25)).setText(msg.getData().getString("toast"));

						}
						if(msg.getData().getInt("Chuanganqihao")==3)
						{((TextView)findViewById(R.id.textView26)).setText(msg.getData().getString("toast"));

						}
						if(msg.getData().getInt("Chuanganqihao")==4)
						{((TextView)findViewById(R.id.textView27)).setText(msg.getData().getString("toast"));

						}

						Toast.makeText(getApplicationContext(),msg.getData().getString("toast"), Toast.LENGTH_SHORT).show();
						break;
					case MESSAGE_Shuaxinxianshi:
					try{Shuaxin();
					Shuaxinm();

					} catch (Exception e) {
						// TODO: handle exception
					}
					break;




					}
				}
			};




			///




		//////////////////222222	2
		if (mBluetoothService == null)
				mBluetoothService = new BluetoothService(this, mHandler); // 用来管理蓝牙的连接
			if (mBluetoothService1 == null)
				mBluetoothService1 = new BluetoothService1(this, mHandler); // 用来管理蓝牙的连接

			if (mBluetoothService2 == null)
				mBluetoothService2 = new BluetoothService2(this, mHandler); // 用来管理蓝牙的连接
			if (mBluetoothService3 == null)
				mBluetoothService3 = new BluetoothService3(this, mHandler); // 用来管理蓝牙的连接


			//此处改动
			//
			//Intent serverIntent = new Intent(this, DeviceListActivity.class);
		//	startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);

			//

			//开启线程
			 try{
				 Sendtemp="未设定诸元";
			    Exitbro=false;
			    Exitrec=false;
			    Exitrefresh=false;
			    //refresh
			    Refresh=new Thread(new Runnable(){

			    	@Override
			    	public void run() {
			    		// TODO Auto-generated method stub


			        		while (!Exitrefresh){

			        		try{

			        			Miaoshu=Miaoshu+2;
			    				if(Miaoshu>60)
			    				{
			    						        	Lianjiezhuangtai=0;
			    						        	Zhuyuanzhuangtai=0;
			    				Miaoshu=0;
			    				}

			        			Msgtemp=mHandler.obtainMessage();
			        			Msgtemp.what=MESSAGE_Shuaxinxianshi;
			        			mHandler.sendMessage(Msgtemp);
			        			Shuaxin();
			        			Shuaxinm();
			        			Refresh.sleep(2000);
			        		//Udpbroadcast.sleep(10);
			        	//	Udpbroadcast.
			        	//	Thread.sleep(1000);
			        		}catch (Exception e)
			        		{

			        		}


			        	}
			    	}});


				//广播线程
			    Bro=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						MulticastSocket sender = null;
						DatagramPacket dj=null;
						InetAddress group=null;
						byte[]Data = new byte[1024];
						byte[]Datatemp = new byte[1024];

						while (!Exitbro){

							try{
								Sendtemp="fig"+"Y"+Jianceying+"L"+Jiancelian+"P"+Jiancepao
										+"Z"+(String.format("% .1f", Shejiaodanxiuhou))
										+"Z"+(String.format("% .1f", Fenhuadanxiuhou))
										+"Z"+(String.format("% .1f", Gaodidanxiu))
										+"Z"+(String.format("% .1f", Fangxiangdanxiu))
										+"Z"+(String.format("% .1f", Xgps1))
										+"Z"+(String.format("% .1f", Ygps1))
										+"Z";

								Data=Sendtemp.getBytes();
								sender=new MulticastSocket();
						//		Toast.makeText(Zhendizhihui.this, Sendtemp, Toast.LENGTH_LONG).show();
								group=InetAddress.getByName("224.0.0.1");
							dj=new DatagramPacket(Data,Data.length,group,6789);

								sender.send(dj);
							sender.close();
							((TextView)findViewById(R.id.textView16)).setText(new String(dj.getData(),0,dj.getLength()));
						//	Udpbroadcast.sleep(10);
						Bro.sleep(3000);

							}catch (Exception e){}

							}
						}
					});
				//广播线程m
			    Brom=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						MulticastSocket sendermb = null;
						DatagramPacket djmb=null;
						InetAddress groupmb=null;
						byte[]Datamb = new byte[1024];
						byte[]Datatempmb = new byte[1024];


						while (!Exitbro){

							try{
							//	Sendtemp="fig"+"Y"+Jianceying+"L"+Jiancelian+"P"+Jiancepao+"Z"+(String.format("% .1f", Shejiao))+"Z"+(String.format("% .1f", Fenhua)+"Z");

								Datamb=Sendtempm.getBytes();
								sendermb=new MulticastSocket();
						//		Toast.makeText(Zhendizhihui.this, Sendtemp, Toast.LENGTH_LONG).show();
								groupmb=InetAddress.getByName("224.0.0.1");
							djmb=new DatagramPacket(Datamb,Datamb.length,groupmb,6790);

								sendermb.send(djmb);
							sendermb.close();
					//		((TextView)findViewById(R.id.textView16)).setText(new String(dj.getData(),0,dj.getLength()));
						//	Udpbroadcast.sleep(10);
						Brom.sleep(3000);

							}catch (Exception e){}

							}
						}
					});
			    //接收线程
			    Rec=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						byte[]Data = new byte[1024];
			    		try{InetAddress Groupaddress=InetAddress.getByName("224.0.0.1");

			    			Ms1=new MulticastSocket(6789);
			    			Ms1.joinGroup(Groupaddress);
			    		}catch (Exception e){}
			    		while (!Exitrec){
			    			if(Working==0){
			    				Working=1;

			    			try{
			    				Dp1=new DatagramPacket(Data,Data.length);
			    			if(Ms1!=null)
			    				Ms1.receive(Dp1);
			    		//	((TextView)findViewById(R.id.textView14)).setText(new String(Datatemp,0,Dp1.getLength()));
			    			Daichaistring=(new String(Dp1.getData(),0,Dp1.getLength()));
			    			((TextView)findViewById(R.id.textView18)).setText(Daichaistring);
			    			if(Daichaistring.substring(0, 3).matches("com"))
			    			{

			    			Recying=Integer.parseInt((Daichaistring.split("Y"))[1].substring(0, 1));
			    			Reclian=Integer.parseInt((Daichaistring.split("L"))[1].substring(0, 1));
			    	if ((Recying==Jianceying)&&(Reclian==Jiancelian))
			    			{Shangjibiaochi=Float.parseFloat((Daichaistring.split("Z"))[1]);

			    			Shangjifenhua=Float.parseFloat((Daichaistring.split("Z"))[2]);//Recpao=Integer.parseInt(new String(Daichai,(OffsetP+1),1));
			    			Biaochiyuzhi=Float.parseFloat((Daichaistring.split("Z"))[3]);
			    			Fangxiangyuzhi=Float.parseFloat((Daichaistring.split("Z"))[4]);
			    			//	((TextView)findViewById(R.id.textView13)).setText(""+Recying+Reclian);
			    			//((TextView)findViewById(R.id.textView13)).setText(Daichaistring.substring(0, 3));
			    	    	//((TextView)findViewById(R.id.textView14)).setText(""+Shangjifenhua);

			    	    	//((TextView)findViewById(R.id.textView12)).setText(""+Shangjibiaochi);

			    			Lianjiezhuangtai=1;
			    				Shuaxin();
			    	    	}
			    			}
			    			}catch (Exception e)
			    			{
			        		}

			    			Working=0;}
			    		}
					}});



				    //接收线程
			    //接收线程m
			    Recm=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						byte[]Datamr = new byte[1024];
			    		try{InetAddress Groupaddressmr=InetAddress.getByName("224.0.0.1");

			    			Ms1mr=new MulticastSocket(6790);
			    			Ms1mr.joinGroup(Groupaddressmr);
			    		}catch (Exception e){}
			    		while (!Exitrec){
			    			if(Workingm==0){
			    				Workingm=1;

			    			try{
			    				Dp1mr=new DatagramPacket(Datamr,Datamr.length);
			    			if(Ms1mr!=null)
			    				Ms1mr.receive(Dp1mr);
			    		//	((TextView)findViewById(R.id.textView14)).setText(new String(Datatemp,0,Dp1.getLength()));
			    			Daichaistringm=(new String(Dp1mr.getData(),0,Dp1mr.getLength()));
			    		//	((TextView)findViewById(R.id.textView18)).setText(Daichaistring);
			    			if(Daichaistringm.substring(0, 3).matches("msg"))
			    			{

			    			Recyingm=Integer.parseInt((Daichaistringm.split("Y"))[1].substring(0, 1));

			    			Reclianm=Integer.parseInt((Daichaistringm.split("L"))[1].substring(0, 1));
			    			Recpaom=Integer.parseInt((Daichaistringm.split("P"))[1].substring(0, 1));


			    			if ((Recyingm==Jianceying)&&(Reclianm==Jiancelian))
			    			{Xinxijilu[Recyingm][Reclianm][Recpaom]=((Daichaistringm.split("Z"))[1]);

			    			//Recpao=Integer.parseInt(new String(Daichai,(OffsetP+1),1));


			    			//	((TextView)findViewById(R.id.textView13)).setText(""+Recying+Reclian);
			    			//((TextView)findViewById(R.id.textView13)).setText(Daichaistring.substring(0, 3));
			    	    	//((TextView)findViewById(R.id.textView14)).setText(""+Shangjifenhua);

			    	    	//((TextView)findViewById(R.id.textView12)).setText(""+Shangjibiaochi);

			    				Shuaxinm();
			    	    	}
			    			}
			    			}catch (Exception e)
			    			{
	}

			    			Workingm=0;}
			    		}
					}});



				    //接收线程m
			    Refresh.start();

			    Bro.start();
       Brom.start();
			    Rec.start();
			    Recm.start();
			}catch (Exception e){	Toast.makeText(DataMonitor222.this,"初始化错误，请检查设置后重启", Toast.LENGTH_LONG).show();
			}

			 try{mPlayer=MediaPlayer.create(DataMonitor222.this,R.raw.warning);
			 mPlayer.setVolume(1.0f, 1.0f);
			 mPlayer.setLooping(true);
			// mPlayer.start();
		}catch (Exception e){	Toast.makeText(DataMonitor222.this,"音乐播放失败", Toast.LENGTH_LONG).show();
		}
		}
		catch (Exception err){}
	}
	public void onClickedBTSet(View v){
		try {
			if (!mBluetoothAdapter.isEnabled()) mBluetoothAdapter.enable();
			if (!mBluetoothAdapter1.isEnabled()) mBluetoothAdapter1.enable();
			if (!mBluetoothAdapter2.isEnabled()) mBluetoothAdapter2.enable();
			if (!mBluetoothAdapter3.isEnabled()) mBluetoothAdapter3.enable();

			///22222


			if (mBluetoothService == null)
				mBluetoothService = new BluetoothService(this, mHandler); // 用来管理蓝牙的连接
			if (mBluetoothService1 == null)
				mBluetoothService1 = new BluetoothService1(this, mHandler); // 用来管理蓝牙的连接
			if (mBluetoothService2 == null)
				mBluetoothService2 = new BluetoothService2(this, mHandler); // 用来管理蓝牙的连接
			if (mBluetoothService3 == null)
				mBluetoothService3 = new BluetoothService3(this, mHandler); // 用来管理蓝牙的连接

			Intent serverIntent = new Intent(this, DeviceListActivity.class);
			startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
		}
		catch (Exception err){}
	}


	@Override
	public void onStart() {
		super.onStart();
		try{
			GetSelected();


		    //
		     spinner1=(Spinner)findViewById(R.id.spinner1);
		       spinner2=(Spinner)findViewById(R.id.spinner2);
		       spinner3=(Spinner)findViewById(R.id.spinner3);

			     SharedPreferences spfdanwei=getSharedPreferences("Danwei",Context.MODE_WORLD_WRITEABLE);

			     spinner1.setSelection(spfdanwei.getInt("Danweiying", 0));
			     spinner2.setSelection(spfdanwei.getInt("Danweilian", 0));
			     spinner3.setSelection(spfdanwei.getInt("Danweipao", 0));




			spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					SharedPreferences spf=getSharedPreferences("Danwei",Context.MODE_WORLD_WRITEABLE);

			    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

				  //  startActivity(intent);
			    	//ZuoBiaoXi=2;
			    	SharedPreferences.Editor edit=spf.edit();
			    Jianceying=spinner1.getSelectedItemPosition();
			    	edit.putInt("Danweiying",(spinner1.getSelectedItemPosition()));
					edit.commit();

			    	Toast.makeText(DataMonitor222.this,"当前单位为"+spinner1.getSelectedItemPosition()+"营"+spinner2.getSelectedItemPosition()+"连"+spinner3.getSelectedItemPosition()+"炮".toString(), Toast.LENGTH_LONG).show();

				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}});
			spinner2.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					SharedPreferences spf=getSharedPreferences("Danwei",Context.MODE_WORLD_WRITEABLE);

			    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

				  //  startActivity(intent);
			    	//ZuoBiaoXi=2;
			    	SharedPreferences.Editor edit=spf.edit();
				    Jiancelian=spinner2.getSelectedItemPosition();
			    	edit.putInt("Danweilian",spinner2.getSelectedItemPosition());
			    	edit.commit();


					Toast.makeText(DataMonitor222.this,"当前单位为"+spinner1.getSelectedItemPosition()+"营"+spinner2.getSelectedItemPosition()+"连"+spinner3.getSelectedItemPosition()+"炮".toString(), Toast.LENGTH_LONG).show();

				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}});
			spinner3.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub

					SharedPreferences spf=getSharedPreferences("Danwei",Context.MODE_WORLD_WRITEABLE);

			    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

				  //  startActivity(intent);
			    	//ZuoBiaoXi=2;
			    	SharedPreferences.Editor edit=spf.edit();
				    Jiancepao=spinner3.getSelectedItemPosition();
			    	edit.putInt("Danweipao",spinner3.getSelectedItemPosition());

			    	edit.commit();
			    	Toast.makeText(DataMonitor222.this,"当前单位为"+spinner1.getSelectedItemPosition()+"营"+spinner2.getSelectedItemPosition()+"连"+spinner3.getSelectedItemPosition()+"炮".toString(), Toast.LENGTH_LONG).show();

				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}});
		}
		catch (Exception err){ Toast.makeText(DataMonitor222.this, err.toString(), Toast.LENGTH_LONG).show();
		   }

	}

	public synchronized void onResume() {
		super.onResume();

		if (mBluetoothService != null) {
			if (mBluetoothService.getState() == BluetoothService.STATE_NONE) {
				mBluetoothService.start();
			}
		}

		if (mBluetoothService1 != null) {
			if (mBluetoothService1.getState() == BluetoothService.STATE_NONE) {
				mBluetoothService1.start();
			}
			}
		if (mBluetoothService2 != null) {
			if (mBluetoothService2.getState() == BluetoothService.STATE_NONE) {
				mBluetoothService2.start();
			}
			}
		if (mBluetoothService3 != null) {
			if (mBluetoothService3.getState() == BluetoothService.STATE_NONE) {
				mBluetoothService3.start();
			}
			}



    	try{
                 //      Bro.start();
                   //    Rec.start();


    }catch(Exception e){


	}
	}

	@Override
	public synchronized void onPause() {
		super.onPause();

	}

	@Override
	public void onStop() {
		super.onStop();

	}

	@Override
	public void onDestroy() {

		if (mBluetoothService != null) mBluetoothService.stop();
		if (mBluetoothService1 != null) mBluetoothService1.stop();
		if (mBluetoothService2 != null) mBluetoothService2.stop();
		if (mBluetoothService3 != null) mBluetoothService3.stop();

    	try{
    	//	Bro.interrupt();;;
    	//	Rec.interrupt();;
    		Exitbro=true;
    		Exitrec=true;
    		Exitrefresh=true;
   	Ms1.close();
   	Ms1mr.close();
   	mPlayer.release();
 super.onDestroy();
    }catch(Exception e){

	//Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}


	}
	public BluetoothDevice device,device1,device2,device3;
	// 利用startActivityForResult 和 onActivityResult在activity间传递数据
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//此处改动

		switch (requestCode) {
		case REQUEST_CONNECT_DEVICE:// When DeviceListActivity returns with a device to connect
			if (resultCode == Activity.RESULT_OK) {
				String address = data.getExtras().getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);// Get the device MAC address
		if(Chuanganleixing==1)	{	device = mBluetoothAdapter.getRemoteDevice(address);// Get the BLuetoothDevice object
				mBluetoothService.connect(device);
		Addr[1]=	address;
		}// Attempt to connect to the device

		if(Chuanganleixing==2)	{
			device1 = mBluetoothAdapter1.getRemoteDevice(address);// Get the BLuetoothDevice object
		mBluetoothService1.connect(device1);
		Addr[2]=	address;
		}// Attempt to connect to the device
		if(Chuanganleixing==3)	{
			device2 = mBluetoothAdapter2.getRemoteDevice(address);// Get the BLuetoothDevice object
		mBluetoothService2.connect(device2);
		Addr[3]=	address;
		}// Attempt to connect to the device
		if(Chuanganleixing==4)	{
			device3 = mBluetoothAdapter3.getRemoteDevice(address);// Get the BLuetoothDevice object
		mBluetoothService3.connect(device3);
		Addr[4]=	address;
		}// Attempt to connect to the device

    	}



			break;
		}
	}
	boolean[] selected = new boolean[]{false,true,true,true,false,false,false,false,false,false,false};
	String[] SelectItem = new String[]{"时间","加速度","角速度","角度","磁场","端口","气压","经纬度","地速","四元数","卫星数"};
	public void RefreshButtonStatus(){
		if (selected[0]) ((TextView)findViewById(R.id.button0)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button0)).setTextColor(Color.GRAY);
		if (selected[1]) ((TextView)findViewById(R.id.button1)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button1)).setTextColor(Color.GRAY);
		if (selected[2]) ((TextView)findViewById(R.id.button2)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button2)).setTextColor(Color.GRAY);
		if (selected[3]) ((TextView)findViewById(R.id.button3)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button3)).setTextColor(Color.GRAY);
		if (selected[4]) ((TextView)findViewById(R.id.button4)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button4)).setTextColor(Color.GRAY);
		if (selected[5]) ((TextView)findViewById(R.id.button5)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button5)).setTextColor(Color.GRAY);
		if (selected[6]) ((TextView)findViewById(R.id.button6)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button6)).setTextColor(Color.GRAY);
		if (selected[7]) ((TextView)findViewById(R.id.button7)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button7)).setTextColor(Color.GRAY);
		if (selected[8]) ((TextView)findViewById(R.id.button8)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button8)).setTextColor(Color.GRAY);
		if (selected[9]) ((TextView)findViewById(R.id.button9)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.button9)).setTextColor(Color.GRAY);
		if (selected[10]) ((TextView)findViewById(R.id.buttonA)).setTextColor(Color.BLACK); else ((TextView)findViewById(R.id.buttonA)).setTextColor(Color.GRAY);
	}
	public void GetSelected(){
		SharedPreferences mySharedPreferences= getSharedPreferences("Output", Activity.MODE_PRIVATE);
		try{
			int iOut = Integer.parseInt(mySharedPreferences.getString("Out", "15"));
			for (int i=0;i<selected.length;i++){
				selected[i]=((iOut>>i)&0x01)==0x01;
			}
			RefreshButtonStatus();
		}
		catch (Exception err){}
	}

	public void OnClickConfig(View v) {

		GetSelected();
		new AlertDialog.Builder(this)
				.setTitle("请选择输出内容：")
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setMultiChoiceItems(SelectItem, selected, new DialogInterface.OnMultiChoiceClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i, boolean b) {
						selected[i] = b;
					}
				})
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						byte[] buffer = new byte[5];
						buffer[0] = (byte) 0xff;
						buffer[1] = (byte) 0xaa;
						buffer[2] = (byte) 0x02;
						short sOut = 0;
						for (int i = 0; i < selected.length; i++) {
							if (selected[i]) sOut |= 0x01 << i;
						}
						buffer[3] = (byte) (sOut&0xff);
						buffer[4] = (byte) (sOut>>8);
						SharedPreferences mySharedPreferences= getSharedPreferences("Output",Activity.MODE_PRIVATE);
						SharedPreferences.Editor editor = mySharedPreferences.edit();
						editor.putString("Out",String.format("%d",sOut));
						editor.commit();
						RefreshButtonStatus();
						if(Chuanganleixing==1)		mBluetoothService.Send(buffer);
						if(Chuanganleixing==2)		mBluetoothService1.Send(buffer);
						if(Chuanganleixing==3)		mBluetoothService2.Send(buffer);
						if(Chuanganleixing==4)		mBluetoothService3.Send(buffer);

					}
				})
				.setNegativeButton("取消", null)
				.show();

	}

	int RunMode = 0;

	int iCurrentGroup=3;
	public void ControlClick(View v) {
		switch (v.getId()) {
			case R.id.button0:
				if (selected[0]==false) return;
				iCurrentGroup=0;
				((TextView)findViewById(R.id.tvDataName1)).setText("日期：");((TextView)findViewById(R.id.tvNum1)).setText("2015-1-1");
				((TextView)findViewById(R.id.tvDataName2)).setText("时间：");((TextView)findViewById(R.id.tvNum2)).setText("00:00:00.0");
				((TextView)findViewById(R.id.tvDataName3)).setText("");((TextView)findViewById(R.id.tvNum3)).setText("");
				((TextView)findViewById(R.id.tvDataName4)).setText("");((TextView)findViewById(R.id.tvNum4)).setText("");
				break;
			case R.id.button1:
				if (selected[1]==false) return;
				iCurrentGroup=1;
				((TextView)findViewById(R.id.tvDataName1)).setText("X轴：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("Y轴：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("Z轴：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("温度：");((TextView)findViewById(R.id.tvNum4)).setText("25℃");
				break;
			case R.id.button2:
				if (selected[2]==false) return;
				iCurrentGroup=2;
				((TextView)findViewById(R.id.tvDataName1)).setText("X轴：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("Y轴：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("Z轴：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("温度：");((TextView)findViewById(R.id.tvNum4)).setText("25℃");
				break;
			case R.id.button3:
				if (selected[3]==false) return;
				iCurrentGroup=3;
				((TextView)findViewById(R.id.tvDataName1)).setText("X轴：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("Y轴：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("Z轴：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("温度：");((TextView)findViewById(R.id.tvNum4)).setText("25℃");
				break;
			case R.id.button4:
				if (selected[4]==false) return;
				iCurrentGroup=4;
				((TextView)findViewById(R.id.tvDataName1)).setText("X轴：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("Y轴：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("Z轴：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("温度：");((TextView)findViewById(R.id.tvNum4)).setText("25℃");
				break;
			case R.id.button5:
				if (selected[5]==false) return;
				iCurrentGroup=5;
				((TextView)findViewById(R.id.tvDataName1)).setText("D0：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("D1：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("D2：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("D3：");((TextView)findViewById(R.id.tvNum4)).setText("0");
				break;
			case R.id.button6:
				if (selected[6]==false) return;
				iCurrentGroup=6;
				((TextView)findViewById(R.id.tvDataName1)).setText("气压：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("海拔：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("");((TextView)findViewById(R.id.tvNum3)).setText("");
				((TextView)findViewById(R.id.tvDataName4)).setText("");((TextView)findViewById(R.id.tvNum4)).setText("");
				break;
			case R.id.button7:
				if (selected[7]==false) return;
				iCurrentGroup=7;
				((TextView)findViewById(R.id.tvDataName1)).setText("经度：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("纬度：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("");((TextView)findViewById(R.id.tvNum3)).setText("");
				((TextView)findViewById(R.id.tvDataName4)).setText("");((TextView)findViewById(R.id.tvNum4)).setText("");
				break;
			case R.id.button8:
				if (selected[8]==false) return;
				iCurrentGroup=8;
				((TextView)findViewById(R.id.tvDataName1)).setText("地速：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("航向：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("");((TextView)findViewById(R.id.tvNum3)).setText("");
				((TextView)findViewById(R.id.tvDataName4)).setText("");((TextView)findViewById(R.id.tvNum4)).setText("");
				break;
			case R.id.button9:
				if (selected[9]==false) return;
				iCurrentGroup=9;
				((TextView)findViewById(R.id.tvDataName1)).setText("q0：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("q1：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("q2：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("q3：");((TextView)findViewById(R.id.tvNum4)).setText("0");
				break;
			case R.id.buttonA:
				if (selected[10]==false) return;
				iCurrentGroup=10;
				((TextView)findViewById(R.id.tvDataName1)).setText("卫星数：");((TextView)findViewById(R.id.tvNum1)).setText("0");
				((TextView)findViewById(R.id.tvDataName2)).setText("PDOP：");((TextView)findViewById(R.id.tvNum2)).setText("0");
				((TextView)findViewById(R.id.tvDataName3)).setText("HDOP：");((TextView)findViewById(R.id.tvNum3)).setText("0");
				((TextView)findViewById(R.id.tvDataName4)).setText("VDOP：");((TextView)findViewById(R.id.tvNum4)).setText("0");
				break;
		}
		((Button) findViewById(R.id.button0)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button1)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button2)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button3)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button4)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button5)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button6)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button7)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button8)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.button9)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.buttonA)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) findViewById(R.id.buttonB)).setBackgroundResource(R.drawable.ic_preference_single_normal);
		((Button) v).setBackgroundResource(R.drawable.ic_preference_single_pressed);
	}
	public void onRecordBtnClick(View v) {
		if (this.recordStartorStop == false)
		{
			this.recordStartorStop = true;
			mBluetoothService.setRecord(true);
			((Button)v).setText("停止");
			((Button)findViewById(R.id.BtnRecord)).setTextColor(Color.RED);
		}
		else{
			this.recordStartorStop = false;
			mBluetoothService.setRecord(false);
			((Button)findViewById(R.id.BtnRecord)).setText("记录");
			((Button)v).setTextColor(Color.WHITE);
			new AlertDialog.Builder(this)
					.setTitle("提示")
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setMessage("数据已经记录至手机根目录：/mnt/sdcard/Record.txt\n是否打开已保存的文件？")
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							File myFile=new File("/mnt/sdcard/Record.txt");
							Intent intent = new Intent(Intent.ACTION_VIEW);
							intent.setData(Uri.fromFile(myFile));
							startActivity(intent);
						}
					})
					.setNegativeButton("取消", null)
					.show();
		}
	}

	public void Clickbaocunzubie(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定保存当前传感器连接组别?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				SharedPreferences SpfAddr=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);


		    	SharedPreferences.Editor edits=SpfAddr.edit();
		   // device1.ge
		    if (device!=null)
			   	{edits.putString("Chuanganleixing1",device.getAddress());

			   	}
		    if (device1!=null)
		   	{edits.putString("Chuanganleixing2",device1.getAddress());

		   	}
		    if (device2!=null)
		   	{edits.putString("Chuanganleixing3",device2.getAddress());

		   	}
		    if (device3!=null)
		   	{edits.putString("Chuanganleixing4",device3.getAddress());

		   	}
		    	edits.commit();
		    	Duqushuaxinchuangan();
			}
		})
		.setNegativeButton("取消", null)
		.show();




	}

	public void Duqushuaxinchuangan()
	{
	try{	SharedPreferences SpfAddr=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		((TextView)findViewById(R.id.textView28)).setText("存档：\n"+SpfAddr.getString("Chuanganleixing1", ""));
		((TextView)findViewById(R.id.textView29)).setText("存档：\n"+SpfAddr.getString("Chuanganleixing2", ""));
		((TextView)findViewById(R.id.textView30)).setText("存档：\n"+SpfAddr.getString("Chuanganleixing3", ""));
		((TextView)findViewById(R.id.textView31)).setText("存档：\n"+SpfAddr.getString("Chuanganleixing4", ""));
	}catch(Exception e){

		//	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}

	}

	public void Clickchonglian(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定按预存组别重新连接?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

			try{	SharedPreferences SpfAddr=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);
				//   Fenhuaxiuzheng   =spf222.getFloat("Fenhuaxiuzheng", 0);


				device = mBluetoothAdapter.getRemoteDevice(SpfAddr.getString("Chuanganleixing1", ""));// Get the BLuetoothDevice object
				mBluetoothService.connect(device);
				device1 = mBluetoothAdapter1.getRemoteDevice(SpfAddr.getString("Chuanganleixing2", ""));// Get the BLuetoothDevice object
				mBluetoothService1.connect(device1);
				device2 = mBluetoothAdapter2.getRemoteDevice(SpfAddr.getString("Chuanganleixing3", ""));// Get the BLuetoothDevice object
				mBluetoothService2.connect(device2);
				device3 = mBluetoothAdapter3.getRemoteDevice(SpfAddr.getString("Chuanganleixing4", ""));// Get the BLuetoothDevice object
				mBluetoothService3.connect(device3);
			}catch(Exception e){

				//	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
				}
		      // device1.ge

			}
		})
		.setNegativeButton("取消", null)
		.show();




	}
	public void Clickshejiao(View v) {
		//((Spinner)findViewById(R.id.spinner1)).setSelection(4);;;

		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定射角归零?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Shejiaoxiuzheng=Shejiaoxiuzheng-Shejiao;

				SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

			  //  startActivity(intent);
		    	//ZuoBiaoXi=2;
		    	SharedPreferences.Editor edit=spf.edit();

		    	edit.putFloat("Shejiaoxiuzheng",((float) (Shejiaoxiuzheng)));

		    	edit.commit();


			}
		})
		.setNegativeButton("取消", null)
		.show();




	}


	public void Clickfenhua(View v) {

		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定方向分划归3000?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				Fenhuaxiuzheng=Fenhuaxiuzheng-Fenhua+3000;
				SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

			  //  startActivity(intent);
		    	//ZuoBiaoXi=2;
		    	SharedPreferences.Editor edit=spf.edit();

		    	edit.putFloat("Fenhuaxiuzheng",((float) (Fenhuaxiuzheng)));

		    	edit.commit();


			}
		})
		.setNegativeButton("取消", null)
		.show();





	}

	public void Clickfangwei(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定方向坐标方位角归零?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				Fangxiangxiuzheng=Fangxiangxiuzheng-Fangxiang;


				SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

			  //  startActivity(intent);
		    	//ZuoBiaoXi=2;
		    	SharedPreferences.Editor edit=spf.edit();

		    	edit.putFloat("Fangxiangxiuzheng",((float) (Fangxiangxiuzheng)));

		    	edit.commit();

			}
		})
		.setNegativeButton("取消", null)
		.show();




	}

	public void Clickgpsfenhua(View v) {

		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定方向分划归3000?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				Fenhuaxiuzhenggps=Fenhuaxiuzhenggps-Fenhuagps+3000;
				SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

			  //  startActivity(intent);
		    	//ZuoBiaoXi=2;
		    	SharedPreferences.Editor edit=spf.edit();

		    	edit.putFloat("Fenhuaxiuzhenggps",((float) (Fenhuaxiuzhenggps)));

		    	edit.commit();


			}
		})
		.setNegativeButton("取消", null)
		.show();





	}

	public void Clickgpsfangwei(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定方向坐标方位角归零?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

				Fangxiangxiuzhenggps=Fangxiangxiuzhenggps-Fangxianggps;


				SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

		    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

			  //  startActivity(intent);
		    	//ZuoBiaoXi=2;
		    	SharedPreferences.Editor edit=spf.edit();

		    	edit.putFloat("Fangxiangxiuzhenggps",((float) (Fangxiangxiuzhenggps)));

		    	edit.commit();

			}
		})
		.setNegativeButton("取消", null)
		.show();




	}



	public void ClickShechuan1(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("重新设定射角传感器1吗?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {


				 try{
					 Chuanganleixing=1;
						//
							SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

					    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

						  //  startActivity(intent);
					    	//ZuoBiaoXi=2;
					    	SharedPreferences.Editor edit=spf.edit();

					    	edit.putInt("Chuanganqileixing", Chuanganleixing);

					    	edit.commit();





						//
							Intent serverIntent = new Intent(DataMonitor222.this, DeviceListActivity.class);
								startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);

				       }
				        catch(Exception e){
				    Toast.makeText(DataMonitor222.this, e.toString(), Toast.LENGTH_LONG).show();
				        	}






			}
		})
		.setNegativeButton("取消", null)
		.show();




	}
	public void ClickFangchuan2(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("重新确定方向传感器2吗?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {



				 try{
						Chuanganleixing=2;

						SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

				    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

					  //  startActivity(intent);
				    	//ZuoBiaoXi=2;
				    	SharedPreferences.Editor edit=spf.edit();

				    	edit.putInt("Chuanganqileixing", Chuanganleixing);

				    	edit.commit();



						Intent serverIntent = new Intent(DataMonitor222.this, DeviceListActivity.class);
						startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);

				       }
				        catch(Exception e){
				       Toast.makeText(DataMonitor222.this, e.toString(), Toast.LENGTH_LONG).show();
				        	}





			}
		})
		.setNegativeButton("取消", null)
		.show();




	}

	public void ClickFangchuan3(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("重新确定方位传感器3吗?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {



				 try{
						Chuanganleixing=3;

						SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

				    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

					  //  startActivity(intent);
				    	//ZuoBiaoXi=2;
				    	SharedPreferences.Editor edit=spf.edit();

				    	edit.putInt("Chuanganqileixing", Chuanganleixing);

				    	edit.commit();



						Intent serverIntent = new Intent(DataMonitor222.this, DeviceListActivity.class);
						startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
								
				       }
				        catch(Exception e){
				       Toast.makeText(DataMonitor222.this, e.toString(), Toast.LENGTH_LONG).show();
				        	}
				    	
				
				
				

			}
		})
		.setNegativeButton("取消", null)
		.show();
		
		


	}
	public void ClickFangchuan4(View v) {
		new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("重新确定方位传感器4吗?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				

				
				 try{
						Chuanganleixing=4;
						
						SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);  
				    	
				    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

					  //  startActivity(intent);
				    	//ZuoBiaoXi=2;
				    	SharedPreferences.Editor edit=spf.edit();
				    
				    	edit.putInt("Chuanganqileixing", Chuanganleixing);
			
				    	edit.commit();
						
						
					
						Intent serverIntent = new Intent(DataMonitor222.this, DeviceListActivity.class);
						startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
								
				       }
				        catch(Exception e){
				       Toast.makeText(DataMonitor222.this, e.toString(), Toast.LENGTH_LONG).show();
				        	}
				    	
				
				
				

			}
		})
		.setNegativeButton("取消", null)
		.show();
		
		


	}

	   //返回时关闭套接字
	    @Override
	    public void onBackPressed(){
	    	
	  //  	Ms1.close();
	   // 	Ms1m.close();
	    	new AlertDialog.Builder(this)
			.setTitle("提示")

			.setMessage("确定退出吗?")
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					

					
					 try{
						 DataMonitor222.this.finish();;
					       }
					        catch(Exception e){
					       Toast.makeText(DataMonitor222.this, e.toString(), Toast.LENGTH_LONG).show();
					        	}
					    	
					
					
					

				}
			})
			.setNegativeButton("取消", null)
			.show();
			
			
	
	    	
	    	
	    }
	    public void Shuaxin()
	    {try{//(String.format("% 10.2f", fData[15]))
	    	
	    	//((TextView)findViewById(R.id.textView14)).setText(""+Shangjifenhua);
	    	   Yichangzhuangtai=0;
	    	((TextView)findViewById(R.id.textView12)).setText
	    	("上级下达表尺"+(String.format("% 4.2f", Shangjibiaochi))+"\n"
	    	+"上级下达分划"+(String.format("% 4.2f", Shangjifenhua))+"\n"
	    	+"表尺误差阈值"+(String.format("% 4.2f", Biaochiyuzhi))+"\n"
	    	+"方向误差阈值"+(String.format("% 4.2f", Fangxiangyuzhi))+"\n");
	    	
	    	if (
					(Lianjiezhuangtai==0)

			)
			{
				Zhuyuanzhuangtai=0;
				((TextView)findViewById(R.id.textView11)).setTextColor(Color.BLUE);
		    	
			}
			else{
			if (
					(((Shangjibiaochi-Shejiaodanxiuhou)*(Shangjibiaochi-Shejiaodanxiuhou))<Biaochiyuzhi*Biaochiyuzhi)
			&& (((Shangjifenhua-Fenhuadanxiuhou)*(Shangjifenhua-Fenhuadanxiuhou))<Fangxiangyuzhi*Fangxiangyuzhi)
			)
			{
				Zhuyuanzhuangtai=1;
				 ((TextView)findViewById(R.id.textView11)).setTextColor(Color.BLACK);
				 mPlayer.pause();
			}
			else
			{
				Zhuyuanzhuangtai=2;
			    Yichangzhuangtai=1;
			    ((TextView)findViewById(R.id.textView11)).setTextColor(Color.RED);
			    mPlayer.start();
			}
	    	
			}
	    	 ((TextView)findViewById(R.id.textView11)).setText("对上通信："
			+Lianjiezhuangtaizifu[Lianjiezhuangtai]
	    			 +"\n诸元状态："
			+Zhuyuanzhuangtaizifu[Zhuyuanzhuangtai]);
	    	 if(Yichangzhuangtai==0)
    		 {
    					 }
    		 else{
    				
    			 
    			 
    		 }    	
	  /*      Strtemp=Strtemp+(Jianceying+"营"+Jiancelian+"连"+tempkkk+"炮"
	        		+Lianjiezhuangtaizifu[(Lianjiezhuangtai[Jianceying][Jiancelian][tempkkk])]
	        		+"诸元 ：表尺"+(String.format("% 4.2f", Biaochi[Jianceying][Jiancelian][tempkkk]))
	        		+"方向"+(String.format("% 4.2f", Fangxiang[Jianceying][Jiancelian][tempkkk]))
	        		+"，诸元"+Zhuyuanzhuangtaizifu[(Lianjiezhuangtai[Jianceying][Jiancelian][tempkkk])]+"\n");
	                		
	             */   		
	    	
	   //	 ((TextView)findViewById(R.id.textView11)).setText("诸元状态：断开连接，未接收到上级诸元");
	    	 	
	    	
	    	
	    	
	    	
	    	
	    //	((TextView)findViewById(R.id.textView12)).getf;
	    //	((TextView)findViewById(R.id.textView14)).getContext();
		}catch(Exception e){
			
		//	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	    }
	    public void Shuaxinm()
	    {try{   	
	    
			Strtempm="";
			for(Temk=0;Temk<=8;Temk++)
			       Strtempm=Strtempm+(Jianceying+"营"+Jiancelian+"连"+Temk+"炮："
			    		  +Xinxijilu[Jianceying][Jiancelian][Temk]
			    				  +"\n");
				
			((TextView)findViewById(R.id.textView13)).setText(Strtempm);

	    	
	    }catch(Exception e){
			
		//	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	    }
	    
	    public void Clickdanxiu(View v){
	    	
	    	try{
				// TODO Auto-generated method stub
		
			Gaodidanxiu=
					Float.parseFloat(	((EditText)findViewById(R.id.editText2)).getText().toString());
			Fangxiangdanxiu=
					Float.parseFloat(	((EditText)findViewById(R.id.editText3)).getText().toString());

				//	((TextView)findViewById(R.id.textView16)).setText(new String(dj.getData(),0,dj.getLength()));
				//	Udpbroadcast.sleep(10);
			((TextView)findViewById(R.id.textView39)).setText(String.format("% 3.2f",Gaodidanxiu));
			((TextView)findViewById(R.id.textView40)).setText(String.format("% 3.2f",Fangxiangdanxiu));
			SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);  
	    	
	    	//Intent intent=new Intent(GpsLoc.this,Menuofmian.class);

		  //  startActivity(intent);
	    	//ZuoBiaoXi=2;
	    	SharedPreferences.Editor edit=spf.edit();
	    
	    	edit.putFloat("Gaodidanxiu", (Gaodidanxiu));
	    	edit.putFloat("Fangxiangdanxiu", (Fangxiangdanxiu));
	    	edit.commit();
			
			Toast.makeText(this, "单修量录入完毕", Toast.LENGTH_LONG).show();

					
				

					
	    	}catch(Exception e){
	    		
	    			    	}
	    	
	    	;
	    }
	    public void Clickfs(View v){
	    	
	    	try{
				// TODO Auto-generated method stub
		
			
						Sendtempm="msg"
						+"Y"+Jianceying
						+"L"+Jiancelian
						+"P"+Jiancepao
						+"Z"
						+((EditText)findViewById(R.id.editText1)).getText().toString()+"Z";

				//	((TextView)findViewById(R.id.textView16)).setText(new String(dj.getData(),0,dj.getLength()));
				//	Udpbroadcast.sleep(10);
		
					
				

					
	    	}catch(Exception e){
	    		
	    		Toast.makeText(this, e.toString()+"信息发送失败", Toast.LENGTH_LONG).show();
	    	}
	    	
	    	;
	    }
	    
	    public void Ceshibao(View v){
	    	
	    	try{//Double.parseDouble((ET128.getText().toString()));
	    	
	    Sendtemp="comY6L5Z212.3Z1243.6";
	    	
	    	}catch(Exception e){
	    		
	    		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	    	}
	    	
	    	;
	    }
	    
}
