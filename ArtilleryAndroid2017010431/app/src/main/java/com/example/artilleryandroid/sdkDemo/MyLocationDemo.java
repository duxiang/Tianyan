package com.example.artilleryandroid.sdkDemo;

import com.example.artilleryandroid.old.Menujiben;
import com.example.artilleryandroid.Tiandituhelp;
import com.tianditu.android.maps.OnGetPoiResultListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.FunctionZuobiaojiesuan;
import com.example.artilleryandroid.R;
import com.tianditu.android.maps.GeoPoint;
import com.tianditu.android.maps.MapView;
import com.tianditu.android.maps.MapViewRender;
import com.tianditu.android.maps.MyLocationOverlay;
import com.tianditu.android.maps.Overlay;
import com.tianditu.android.maps.PoiInfo;
import com.tianditu.android.maps.PoiSearch;
import com.tianditu.android.maps.TErrorCode;
import com.tianditu.android.maps.TGeoAddress;
import com.tianditu.android.maps.TGeoDecode;
import com.tianditu.android.maps.TMapLayerManager;
import com.tianditu.android.maps.overlay.PolylineOverlay;
import com.tianditu.android.maps.overlay.TextOverlay;
import com.tianditu.android.maps.overlayutil.PoisOverlay;
import com.tianditu.android.maps.renderoption.DrawableOption;
import com.tianditu.android.maps.renderoption.FontOption;
import com.tianditu.android.maps.renderoption.LineOption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.microedition.khronos.opengles.GL10;

public class MyLocationDemo extends AppCompatActivity  implements TGeoDecode.OnGeoResultListener , OnGetPoiResultListener{
	//工具栏声明相关变量

   DrawerLayout mDrawerLayout;
	public void Clickzuozhe1(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);

		intent.setData(Uri.parse("http://weibo.com/p/1005056231444051"));

		startActivity(intent);


	}
	public void Clickzingto1(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);

		intent.setData(Uri.parse("http://www.zingto.net/"));

		startActivity(intent);


	}
	public void Clickliaowang1(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);

		intent.setData(Uri.parse("http://www.jiguangceju.com/"));

		startActivity(intent);


	}
	//工具栏声明相关变量结束

	TabHost mTabHost;
	Tab1 mTab1;
	Tab2 mTab2;
	Tab3 mTab3;
	Tab4 mTab4;
    Tab5 mTab5;
	Tab6 mTab6;
	MapView mMapView;
	MyLocationOverlay mMyLocation;

	MarkerOverlayfanglige Overlayfanglige;


	public GeoPoint mGeoPointzhongxin;//地图中心点
	PolylineOverlay Lineoverlay = new PolylineOverlay();//画直角坐标线图层

	private RadioGroup mRadioGroup;
	GeoPoint mGeoPointdiming = new GeoPoint(0, 0);
//	public GeoPoint mGeoPointdituzhongxin;//地图中心画方里格用
	public long Xweizhijiao[][]=new long [20][20], Yweizhijiao[][]=new long [20][20];//XY直角坐标方里格用
	public GeoPoint mGeoPointdingweizhijiao[][]=new GeoPoint[20][20];//
	public TextOverlay Hengtextoverlays[] = new TextOverlay[100];//横坐标标注
	public TextOverlay Zongtextoverlays[] = new TextOverlay[100];//
	public TextOverlay Testtextoverlays= new TextOverlay();//

	private CheckBox cb2;
	private TMapLayerManager mLayerMnger;
	private TextView mTextViewTips;
	public Function ggg = new Function();
    public FunctionZuobiaojiesuan gggSuanzuobiao=new FunctionZuobiaojiesuan();
	double XiuZhengX = 0, XiuZhengY = 0, XiuZhengH = 0,ZhanliX=0,ZhanliY=0,ZhanliH=0,Fangxiang=0,DituqudianX=0,DituqudianY=0;
	boolean Xianshishijian = true, Xianshijingdu = true, Xianshifangxiang = true, Xianshisudu = true;
	String Zuobiaoshuju;//坐标数据显示字符串
	Time Timexianshi = new Time(0);
	int ZuoBiaoXi = 3;////0为北京54，1为西安80，2为WGS84，坐标系3为大地2000
int Fendudaikuan=6;boolean Shi3du=false,Shoudongjingxian=false;

	double ShoudongZhongyangjingxianjingdu=0;
	int Dianleixing = 0;//点1为站立点，点2为点击目标点
	LineOption Hangjioption = new LineOption();
	LineOption Moduanoption = new LineOption();
	ArrayList<GeoPoint> ShouhuaHangjipoints = new ArrayList<GeoPoint>();
	ArrayList<GeoPoint> Luxianmoduanpoints = new ArrayList<GeoPoint>();
	PolylineOverlay ShouhuaHangjioverlay = new PolylineOverlay();//画手绘路线航迹
	PolylineOverlay Luxianmoduanoverlay = new PolylineOverlay();//画闭合路线航迹
	double Danxiangzhexianchang=0,Bihezhexianchang=0,Danxiangfangxiangmiwei=0,Zhixianjuli=0,Zhixianfangweimiwei=0;

	Resources resn;
	String folderName;

	File folder;
	File saveFile;

	//存储航迹用
	//求解地名
//画航迹
	int Hangjidianshu=0;
//	GeoPoint mGeoPointhangji[]=new GeoPoint[1000000];
	ArrayList<GeoPoint> Hangjipoints = new ArrayList<GeoPoint>();

	LineOption ZidongHangjioption = new LineOption();

	//PolylineOverlay[] Hangjioverlay= new PolylineOverlay();

	ArrayList<PolylineOverlay> Hangjioverlayqun = new ArrayList<PolylineOverlay>();
	GeoPoint Shangyidianshouhui=null;//手绘画航迹上一点
	GeoPoint Shangyidianzidong=null;//自动画航迹上一点

	//Thread		Refreshsave;//自动存储航迹线程
	//画方向线开始
	LineOption Fangxiangxianoption = new LineOption();
	ArrayList<GeoPoint> Fangxiangxianpoints = new ArrayList<GeoPoint>();
	PolylineOverlay Fangxiangxianoverlay = new PolylineOverlay();//画手绘路线航迹



	//画方向线结束

	//画目标点开始




	//画目标点结束
//画航迹结束
//BLE蓝牙
	public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
	public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";


	//连接状态
	private TextView mConnectionState;
	private EditText mDataField;
	private String mDeviceName;
	private String mDeviceAddress;

	private Button button_send_value ; // 发送按钮
	private EditText edittext_input_value ; // 数据在这里输入

	private BluetoothLeService mBluetoothLeService;
	private boolean mJieshu= false;
	private boolean mConnected = false;
	private boolean CejushujumConnected = false;
	private BluetoothGattCharacteristic mNotifyCharacteristic;
	byte[] Datacoped=new byte[100];
	int offset=0,tempi,tempj,tempk;
	float Xiejuli=0,Fuyangjiao=0,Fuyangmiwei=0;
	double Xmubiao,Ymubiao,Hmubiao,Weidumubiao,Jingdumubiao,Weiduzhanlidian,Jingduzhanlidian;
	//写数据
	private BluetoothGattCharacteristic characteristic;
	private BluetoothGattService mnotyGattService;;
	boolean Cejubiaodingfangxiang=false;
	//读数据
	private BluetoothGattCharacteristic readCharacteristic;
	private BluetoothGattService readMnotyGattService;
	byte[] WriteBytes = new byte[20];
	private static final int REQUEST_ENABLE_BT = 1924;
	// 管理服务的生命周期
	private final ServiceConnection mServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName componentName, IBinder service) {
			mBluetoothLeService = ((BluetoothLeService.LocalBinder) service).getService();
			if (!mBluetoothLeService.initialize()) {

				finish();
			}
			// Automatically connects to the device upon successful start-up initialization.
			mBluetoothLeService.connect(mDeviceAddress);
		}

		@Override
		public void onServiceDisconnected(ComponentName componentName) {
			mBluetoothLeService = null;
		}
	};

	// Handles various events fired by the Service.处理服务所激发的各种事件
	// ACTION_GATT_CONNECTED: connected to a GATT server.连接一个GATT服务
	// ACTION_GATT_DISCONNECTED: disconnected from a GATT server.从GATT服务中断开连接
	// ACTION_GATT_SERVICES_DISCOVERED: discovered GATT services.查找GATT服务
	// ACTION_DATA_AVAILABLE: received data from the device.  This can be a result of read
	//                        or notification operations.从服务中接受数据
	private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {

			try{
				final String action = intent.getAction();
				if (BluetoothLeService.ACTION_GATT_CONNECTED.equals(action)) {
					mConnected = true;
					updateConnectionState(R.string.connected);
					Lianjieble();//可用就连接吧
					invalidateOptionsMenu();
				} else if (BluetoothLeService.ACTION_GATT_DISCONNECTED.equals(action)) {
					mConnected = false;
					updateConnectionState(R.string.disconnected);
					invalidateOptionsMenu();
					clearUI();
				}
				//发现有可支持的服务
				else if (BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED.equals(action)) {
					//写数据的服务和characteristic
					mnotyGattService = mBluetoothLeService.getSupportedGattServices(UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb"));
					characteristic = mnotyGattService.getCharacteristic(UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb"));
					//读数据的服务和characteristic
					readMnotyGattService = mBluetoothLeService.getSupportedGattServices(UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb"));
					readCharacteristic = readMnotyGattService.getCharacteristic(UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb"));

            /*原始段
            	mnotyGattService = mBluetoothLeService.getSupportedGattServices(UUID.fromString("0000ffe5-0000-1000-8000-00805f9b34fb"));
                characteristic = mnotyGattService.getCharacteristic(UUID.fromString("0000ffe9-0000-1000-8000-00805f9b34fb"));
                //读数据的服务和characteristic
                readMnotyGattService = mBluetoothLeService.getSupportedGattServices(UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb"));
                readCharacteristic = readMnotyGattService.getCharacteristic(UUID.fromString("0000ffe4-0000-1000-8000-00805f9b34fb"));
          */



				}
				//显示数据
				else if (BluetoothLeService.ACTION_DATA_AVAILABLE.equals(action)) {
					//将数据显示在mDataField上
					//String data = intent.getStringExtra(BluetoothLeService.EXTRA_DATA);
					CejushujumConnected = true;
					((TextView)findViewById (R.id.textViewCejujilianjie)).setText("激光测距机数据已连接成功");
					byte[] data = intent.getByteArrayExtra(BluetoothLeService.EXTRA_DATA);

					offset= data.length;
					//	System.out.println("data----" + data);
					// displayData(""+offset+"\n");
					if((data[0]==(byte)0xae)&&(data[4]==(byte)0x85))
					{
						//fData[16] = ((((long) packBuffer[3]) << 24) |(((long) packBuffer[2]) << 16) |(((long) packBuffer[1]) << 8) | (((long) packBuffer[0])));
						//	fData[12] = ((((short) packBuffer[1]) << 8) | ((short) packBuffer[0] & 0xff));
						if (Cejubiaodingfangxiang)
						{
							float Miaozhundianfangweijiao = 0;

							//		((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 7.1f", fData[28]));
							//Double.parseDouble((et13.getText().toString()));

							Miaozhundianfangweijiao = Float.parseFloat(((EditText) findViewById(R.id.editTextyushefangweijiao)).getText().toString());
							Fangxiangxiuzheng = Fangxiangxiuzheng - (float) Fangxiang + Miaozhundianfangweijiao;
							SharedPreferences spf = getSharedPreferences("Chuangan", Context.MODE_WORLD_WRITEABLE);

							//Intent intent=new Intent(DeviceControlActivity.this,Menuofmian.class);

							//  startActivity(intent);
							//ZuoBiaoXi=2;
							SharedPreferences.Editor edit = spf.edit();

							edit.putFloat("Fangxiangxiuzheng", ((float) (Fangxiangxiuzheng)));

							edit.commit();
							Cejubiaodingfangxiang = false;

						}

						Xiejuli=0;
						Xiejuli=(float)(((((short) data[7]) << 8) & 0xff00)| ((short) data[8]& 0xff ));
						Xiejuli=(float) (Xiejuli*0.1);
						Fuyangjiao=0;
						Fuyangmiwei=0;
						Fuyangjiao=(float)(short)(((((short) data[5]) << 8)& 0xff00) | ((short) data[6]& 0xff ));
						Fuyangjiao= (float)( Fuyangjiao*0.1);
						Fuyangmiwei=Fuyangjiao*6000/360;




						Xmubiao=ggg.ZhengyunsuanBx(ZhanliX, ZhanliY, ZhanliH, Xiejuli, Fangxiang, Fuyangmiwei);
						Ymubiao=ggg.ZhengyunsuanBy(ZhanliX, ZhanliY, ZhanliH,  Xiejuli, Fangxiang, Fuyangmiwei);
						Hmubiao=ggg.ZhengyunsuanBh(ZhanliX, ZhanliY, ZhanliH,  Xiejuli, Fangxiang, Fuyangmiwei);
						gggSuanzuobiao.Zuobiaozhuanjingweiduweidu(ZuoBiaoXi, Xmubiao-XiuZhengX, Ymubiao-XiuZhengY,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);
						Weidumubiao=gggSuanzuobiao.Zhuanhuanweidu;
						Jingdumubiao=gggSuanzuobiao.Zhuanhuanjingdu;


						//Shuaxinuav();
						displayData("测距成功，距离"+ Xiejuli+"\n"
								+"坐标方位角"+(long)Fangxiang+"\n"
								+"高低密位"+(long)Fuyangmiwei+"\n"
								+"X"+(long)Xmubiao+"\n"
								+"Y"+(long)Ymubiao+"\n"
								+"H"+(long)Hmubiao
								+"\n"+"目标纬度"+(String.format("% .7f", Weidumubiao))
								+"\n"+"目标经度"+(String.format("% .7f", Jingdumubiao)));
/*
						LineOption Fangxiangxianoption = new LineOption();
						ArrayList<GeoPoint> Fangxiangxianpoints = new ArrayList<GeoPoint>();
						PolylineOverlay Fangxiangxianoverlay = new PolylineOverlay();//画手绘路线航迹*/

						mMarker.setPosition(new GeoPoint((int) (Weidumubiao * 1E6), (int) (Jingdumubiao * 1E6)));

						Fangxiangxianpoints.clear();
						Fangxiangxianpoints.add(new GeoPoint((int) (Weiduzhanlidian * 1E6), (int) (Jingduzhanlidian * 1E6)));
						Fangxiangxianpoints.add(new GeoPoint((int) (Weidumubiao * 1E6), (int) (Jingdumubiao * 1E6)));
						//			Hangjipoints.add(new GeoPoint((int) (dLat * 1E6), (int) (dLon * 1E6)));
						Fangxiangxianoption.setStrokeWidth(5);
						Fangxiangxianoption.setDottedLine(false);
						Fangxiangxianoption.setStrokeColor(Color.MAGENTA);
						// 		     Weidumubiao=ggg.Zuobiaozhuanjingweiduweidu(3, Xmubiao, Ymubiao);
						//    Jingdumubiao=ggg.Zuobiaozhuanjingweidujingdu(3, Xmubiao, Ymubiao);
						Fangxiangxianoverlay
								.setOption(Fangxiangxianoption);
						Fangxiangxianoverlay
								.setPoints(Fangxiangxianpoints);
								mMapView.addOverlay(	Fangxiangxianoverlay);

						//
						SharedPreferences spf=getSharedPreferences("Art",Context.MODE_WORLD_WRITEABLE);


						SharedPreferences.Editor edit=spf.edit();

						edit.putString("Weidumubiao", ""+Weidumubiao);
						edit.putString("Jingdumubiao", ""+Jingdumubiao);
						edit.putString("Xmubiao", ""+(long)Xmubiao);
						edit.putString("Ymubiao", ""+(long)Ymubiao);
						edit.putString("Hmubiao", ""+(long)Hmubiao);



						edit.commit();
						mMapView.getController().setCenter(new GeoPoint((int) (Weidumubiao * 1E6),(int) (Jingdumubiao * 1E6)));
					}
					else {

						// displayData("回执成功"+data[4]);

					}

					Answer();
				}

			}
			catch(Exception e){

				Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
			}


		}
	};
	private void clearUI() {
		//mGattServicesList.setAdapter((SimpleExpandableListAdapter) null);
		// mDataField.setText(R.string.no_data);
		//mDataField.setText(mDataField.getText().toString()+data);
		((EditText) findViewById(R.id.data_valuelaser)).setText(((EditText) findViewById(R.id.data_valuelaser)).getText().toString()+R.string.no_data);
	}





	private void read() {
		//mBluetoothLeService.readCharacteristic(readCharacteristic);
		//readCharacteristic的数据发生变化，发出通知

		try{
			mBluetoothLeService.setCharacteristicNotification(readCharacteristic, true);
			//Toast.makeText(this, "读成功", Toast.LENGTH_SHORT).show();
		}
		catch(Exception e){

			//Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
		}
	}
	//


	//回应
	public void Answer(){


		try{//Double.parseDouble((ET128.getText().toString()));

			// Sendtemp="figY5L4P7Z332.2Z222.4Z";
			read();

			final int charaProp = characteristic.getProperties();

			//如果该char可写
			if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
				// If there is an active notification on a characteristic, clear
				// it first so it doesn't update the data field on the user interface.
				if (mNotifyCharacteristic != null) {
					mBluetoothLeService.setCharacteristicNotification( mNotifyCharacteristic, false);
					mNotifyCharacteristic = null;
				}
				//读取数据，数据将在回调函数中
				//mBluetoothLeService.readCharacteristic(characteristic);
				byte[] value = new byte[20];
				value[0] = (byte) 0x00;
				//AE A7 04 00 88 8C BC B7
           /*   if(edittext_input_value.getText().toString().equals("")){
              	Toast.makeText(getApplicationContext(), "请输入！", Toast.LENGTH_SHORT).show();
              	return;
              }else
              */


				{
             /* 	WriteBytes = edittext_input_value.getText().toString().getBytes();


              	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
                  characteristic.setValue(WriteBytes);
                  mBluetoothLeService.writeCharacteristic(characteristic);
              */
					// WriteBytes = edittext_input_value.getText().toString().getBytes();

					WriteBytes[0]=(byte) 0xAE;
					WriteBytes[1]=(byte) 0xA7;
					WriteBytes[2]=(byte) 0x04;
					WriteBytes[3]=(byte) 0x00;
					WriteBytes[4]=(byte) 0x88;
					WriteBytes[5]=(byte) 0x8c;
					WriteBytes[6]=(byte) 0xbc;
					WriteBytes[7]=(byte) 0xb7;

					final StringBuilder stringBuilder = new StringBuilder(10);
					//    for(byte byteChar : data)
					//以十六进制的形式输出
					stringBuilder.append(String.format("%02X ", WriteBytes[0]));
					stringBuilder.append(String.format("%02X ", WriteBytes[1]));
					stringBuilder.append(String.format("%02X ", WriteBytes[2]));
					stringBuilder.append(String.format("%02X ", WriteBytes[3]));
					stringBuilder.append(String.format("%02X ", WriteBytes[4]));
					stringBuilder.append(String.format("%02X ", WriteBytes[5]));
					stringBuilder.append(String.format("%02X ", WriteBytes[6]));
					stringBuilder.append(String.format("%02X ", WriteBytes[7]));

					displaySent(""+stringBuilder.toString());

					//

					//	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
					characteristic.setValue(WriteBytes);

					mBluetoothLeService.writeCharacteristic(characteristic);

					//  Toast.makeText(getApplicationContext(), "写入成功！", Toast.LENGTH_SHORT).show();
				}
			}
			if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
				mNotifyCharacteristic = characteristic;
				mBluetoothLeService.setCharacteristicNotification(characteristic, true);
			}


		}catch(Exception e){

			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}

		;
	}

	//连接BLE

	public void Lianjieble(){

		try{

			read();

			final int charaProp = characteristic.getProperties();

			//如果该char可写
			if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
				// If there is an active notification on a characteristic, clear
				// it first so it doesn't update the data field on the user interface.
				if (mNotifyCharacteristic != null) {
					mBluetoothLeService.setCharacteristicNotification( mNotifyCharacteristic, false);
					mNotifyCharacteristic = null;
				}
				//读取数据，数据将在回调函数中
				//mBluetoothLeService.readCharacteristic(characteristic);
				byte[] value = new byte[20];
				value[0] = (byte) 0x00;
				//AE A7 04 00 06 0A BC B7

                    /*
                    if(edittext_input_value.getText().toString().equals("")){
                    	Toast.makeText(getApplicationContext(), "请输入！", Toast.LENGTH_SHORT).show();
                    	return;
                    }else
                    */

				{
                   /* 	WriteBytes = edittext_input_value.getText().toString().getBytes();


                    	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
                        characteristic.setValue(WriteBytes);
                        mBluetoothLeService.writeCharacteristic(characteristic);
                    */
					// WriteBytes = edittext_input_value.getText().toString().getBytes();

					WriteBytes[0]=(byte) 0xAE;
					WriteBytes[1]=(byte) 0xA7;
					WriteBytes[2]=(byte) 0x04;
					WriteBytes[3]=(byte) 0x00;
					WriteBytes[4]=(byte) 0x06;
					WriteBytes[5]=(byte) 0x0a;
					WriteBytes[6]=(byte) 0xbc;
					WriteBytes[7]=(byte) 0xb7;

					//	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
					characteristic.setValue(WriteBytes);

					mBluetoothLeService.writeCharacteristic(characteristic);
					final StringBuilder stringBuilder = new StringBuilder(10);
					//    for(byte byteChar : data)
					//以十六进制的形式输出
					stringBuilder.append(String.format("%02X ", WriteBytes[0]));
					stringBuilder.append(String.format("%02X ", WriteBytes[1]));
					stringBuilder.append(String.format("%02X ", WriteBytes[2]));
					stringBuilder.append(String.format("%02X ", WriteBytes[3]));
					stringBuilder.append(String.format("%02X ", WriteBytes[4]));
					stringBuilder.append(String.format("%02X ", WriteBytes[5]));
					stringBuilder.append(String.format("%02X ", WriteBytes[6]));
					stringBuilder.append(String.format("%02X ", WriteBytes[7]));

				//	displaySent(""+stringBuilder.toString());
				//	Toast.makeText(getApplicationContext(), "写入成功！", Toast.LENGTH_SHORT).show();
				}
			}
			if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
				mNotifyCharacteristic = characteristic;
				mBluetoothLeService.setCharacteristicNotification(characteristic, true);
			}
			//  edittext_input_value.setText("");
		}
		catch(Exception e){

		//	Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
		}



	}

	//应答

	public void Clickanswer(View v){

		try{//Double.parseDouble((ET128.getText().toString()));

			// Sendtemp="figY5L4P7Z332.2Z222.4Z";
			Answer();
		}catch(Exception e){

			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}

		;
	}

	//测距
	public void Clickceju(View v){

		try{//Double.parseDouble((ET128.getText().toString()));

			// Sendtemp="figY5L4P7Z332.2Z222.4Z";
			read();

			final int charaProp = characteristic.getProperties();

			//如果该char可写
			if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
				// If there is an active notification on a characteristic, clear
				// it first so it doesn't update the data field on the user interface.
				if (mNotifyCharacteristic != null) {
					mBluetoothLeService.setCharacteristicNotification( mNotifyCharacteristic, false);
					mNotifyCharacteristic = null;
				}
				//读取数据，数据将在回调函数中
				//mBluetoothLeService.readCharacteristic(characteristic);
				byte[] value = new byte[20];
				value[0] = (byte) 0x00;
				//AE A7 04 00 05 09 BC B7
             /*   if(edittext_input_value.getText().toString().equals("")){
                	Toast.makeText(getApplicationContext(), "请输入！", Toast.LENGTH_SHORT).show();
                	return;
                }else
                */


				{
               /* 	WriteBytes = edittext_input_value.getText().toString().getBytes();


                	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
                    characteristic.setValue(WriteBytes);
                    mBluetoothLeService.writeCharacteristic(characteristic);
                */
					// WriteBytes = edittext_input_value.getText().toString().getBytes();

					WriteBytes[0]=(byte) 0xAE;
					WriteBytes[1]=(byte) 0xA7;
					WriteBytes[2]=(byte) 0x04;
					WriteBytes[3]=(byte) 0x00;
					WriteBytes[4]=(byte) 0x05;
					WriteBytes[5]=(byte) 0x09;
					WriteBytes[6]=(byte) 0xbc;
					WriteBytes[7]=(byte) 0xb7;

					final StringBuilder stringBuilder = new StringBuilder(10);
					//    for(byte byteChar : data)
					//以十六进制的形式输出
					stringBuilder.append(String.format("%02X ", WriteBytes[0]));
					stringBuilder.append(String.format("%02X ", WriteBytes[1]));
					stringBuilder.append(String.format("%02X ", WriteBytes[2]));
					stringBuilder.append(String.format("%02X ", WriteBytes[3]));
					stringBuilder.append(String.format("%02X ", WriteBytes[4]));
					stringBuilder.append(String.format("%02X ", WriteBytes[5]));
					stringBuilder.append(String.format("%02X ", WriteBytes[6]));
					stringBuilder.append(String.format("%02X ", WriteBytes[7]));

					displaySent(""+stringBuilder.toString());



					//	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
					characteristic.setValue(WriteBytes);

					mBluetoothLeService.writeCharacteristic(characteristic);

					Toast.makeText(getApplicationContext(), "写入成功！", Toast.LENGTH_SHORT).show();
				}
			}
			if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
				mNotifyCharacteristic = characteristic;
				mBluetoothLeService.setCharacteristicNotification(characteristic, true);
			}
		}catch(Exception e){

			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}

		;
	}



	private void updateConnectionState(final int resourceId) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				((TextView)findViewById (R.id.textViewCejujilianjiezhuangtai)).setText(resourceId);
				((TextView)findViewById (R.id.textViewCejujilianjie)).setText("激光测距机数据连接断开");

			}
		});
	}

	private void displayData(String data) {
		if (data != null) {
			try{

				((TextView) findViewById(R.id.textViewCejuxinxi)).setText(data);
				//	edittext_input_value
			}
			catch(Exception e){


			}

		}
	}
	//发送
	private void displaySent(String data) {
		if (data != null) {
			try{

				((EditText) findViewById(R.id.edittext_input_valuelaser)).setText(data);
				//	edittext_input_value
			}
			catch(Exception e){


			}

		}
	}
	private static IntentFilter makeGattUpdateIntentFilter() {
		final IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(BluetoothLeService.ACTION_GATT_CONNECTED);
		intentFilter.addAction(BluetoothLeService.ACTION_GATT_DISCONNECTED);
		intentFilter.addAction(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED);
		intentFilter.addAction(BluetoothLeService.ACTION_DATA_AVAILABLE);
		return intentFilter;
	}



//BLE蓝牙结束
	//蓝牙传感器开始

	private String mConnectedDeviceName = null,mConnectedDeviceAddress=null;

	private BluetoothAdapter mBluetoothAdapter = null,mBluetoothAdapter1 = null,mBluetoothAdapter2 = null,mBluetoothAdapter3 = null;
	private BluetoothService mBluetoothService = null;
	private BluetoothService1 mBluetoothService1 = null;
	private BluetoothService2 mBluetoothService2 = null;
	private BluetoothService3 mBluetoothService3 = null;

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
	public float Shejiao,Fenhua,Fangxianggps,Fenhuagps,Shejiaodanxiuhou,Fangxiangdanxiuhou,Fenhuadanxiuhou,Fangxianggpsdanxiuhou,Fenhuagpsdanxiuhou;
	public	String Addr[]=new String[10];
	public Handler mHandler,mHandler1;
	private static final int REQUEST_CONNECT_DEVICE = 1;
	private static final int REQUESTlaserDEVICE = 253;
	public BluetoothDevice device,device1,device2,device3;

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//此处改动

		switch (requestCode) {
			case REQUEST_ENABLE_BT:	if (requestCode == REQUEST_ENABLE_BT && resultCode == Activity.RESULT_CANCELED) {
				finish();
				return;
			}
				break;
			case REQUESTlaserDEVICE:

				if (resultCode == Activity.RESULT_OK)

				{

					mDeviceName = data.getExtras().getString(EXTRAS_DEVICE_NAME);
					mDeviceAddress = data.getExtras().getString(EXTRAS_DEVICE_ADDRESS);
					Intent gattServiceIntent = new Intent(MyLocationDemo.this, BluetoothLeService.class);
					bindService(gattServiceIntent, mServiceConnection, BIND_AUTO_CREATE);


					((TextView)findViewById(R.id.textViewCejujixuanze)).setText("已选择主机:"+mDeviceName);//+"\n地址:"+mDeviceAddress);





				}
				break;



			case REQUEST_CONNECT_DEVICE:// When DeviceListActivity returns with a device to connect
			try{	if (resultCode == Activity.RESULT_OK) {
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
		} catch (Exception e) {
			Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
		}

	break;
		}
	}

	public void initchuangan()
	{
		try {	     SharedPreferences spf222=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

			Fangxiangxiuzheng   =spf222.getFloat("Fangxiangxiuzheng", 0);


						mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
			mBluetoothAdapter1 = BluetoothAdapter.getDefaultAdapter();
			mBluetoothAdapter2 = BluetoothAdapter.getDefaultAdapter();
			mBluetoothAdapter3 = BluetoothAdapter.getDefaultAdapter();
	/*		if (mBluetoothAdapter == null) {
				Toast.makeText(this, "蓝牙不可用", Toast.LENGTH_LONG).show();
				//finish();
				return;
			}*/

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

									((TextView)findViewById(R.id.textViewFangxiangtuoluoyilianjiezhuangtai))
											.setText((R.string.title_connected_to));
									((TextView)findViewById(R.id.textViewFangxiangtuoluoyilianjiezhuangtai)).append(mConnectedDeviceName);
									break;
								case BluetoothService.STATE_CONNECTING:

									((TextView)findViewById(R.id.textViewFangxiangtuoluoyilianjiezhuangtai))
											.setText(R.string.title_connecting);


									break;
								case BluetoothService.STATE_LISTEN:
								case BluetoothService.STATE_NONE:


									((TextView)findViewById(R.id.textViewFangxiangtuoluoyilianjiezhuangtai))
											.setText(R.string.title_not_connected);
									break;
							}
							break;
						case MESSAGE_READShejiao:
							try {
								float [] fData=msg.getData().getFloatArray("Data");


								Shejiao= fData[6]/360*6000+Shejiaoxiuzheng;
								Shejiaodanxiuhou=Shejiao-Gaodidanxiu;
								break;

							} catch (Exception e) {
								// TODO: handle exception
							}
							break;


						case MESSAGE_READFangxiang:
							try {
								float [] fData=msg.getData().getFloatArray("Data");



								//if (Fenhua<0){Fenhuaxiuzheng=Fenhuaxiuzheng+6000;}
								//if (Fenhua>=6000){Fenhuaxiuzheng=Fenhuaxiuzheng-6000;}



								Fangxiang=-fData[8]/360*6000+Fangxiangxiuzheng;

								if (Fangxiang<0){Fangxiangxiuzheng=Fangxiangxiuzheng+6000;}
								if (Fangxiang>=6000){Fangxiangxiuzheng=Fangxiangxiuzheng-6000;}

								Fangxiang=-fData[8]/360*6000+Fangxiangxiuzheng;

								((TextView)findViewById(R.id.textViewDangqiznzuobiaofangweijiao))
										.setText("陀螺仪当前坐标方位角（密位）："+(long)Fangxiang);




							} catch (Exception e) {
								// TODO: handle exception
							}
							break;
						case MESSAGE_DEVICE_NAME:
							mConnectedDeviceName = msg.getData().getString("device_name");
							//bundle.putString("device_address", device.getAddress());
							//	bundle.putInt("Chuanganqihao", 1);
							mConnectedDeviceAddress=msg.getData().getString("device_address");

							if(msg.getData().getInt("Chuanganqihao")==2)
							{	((TextView)findViewById(R.id.textViewFangxiangtuoluoyilianjiezhuangtai)).setText("已连接设备号" + mConnectedDeviceName+"\n地址"+mConnectedDeviceAddress);

							}

							Toast.makeText(getApplicationContext(),"已连接设备号" + mConnectedDeviceName+"地址"+mConnectedDeviceAddress,Toast.LENGTH_SHORT).show();


							break;
						case MESSAGE_TOAST:

							if(msg.getData().getInt("Chuanganqihao")==2)
							{
								//((TextView)findViewById(R.id.textView25)).setText(msg.getData().getString("toast"));
								Toast.makeText(getApplicationContext(),(msg.getData().getString("toast")),Toast.LENGTH_SHORT).show();

							}


							Toast.makeText(getApplicationContext(),msg.getData().getString("toast"), Toast.LENGTH_SHORT).show();
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


		}
		catch (Exception err){}



	};


	//蓝牙传感器结束
//

	private TGeoDecode mGeoDecode;
	String Dizhijiesuanxinxi = "", Shangcidizhizhengquexinxi = "", Mubiaodizhijiesuanxinxi = "";

	//地址查找位置开始
	private static final int DIALOG_TYPE_LIST = 1;
	private static final int DIALOG_POI_LIST = 2;
	private static final int DIALOG_CITY_LIST = 3;

	private final static String TYPE_NAME[] = { "普通搜索", "视野内搜索", "周边搜索", "在北京搜索" };



	private Button mBtnType;
	private EditText mEditKey;
	private Button mBtnSearch;

	private Button mBtnList;
	private Button mBtnPre;
	private Button mBtnNext;

	private TextView mTextTips;

	// 搜索条件
	private String mKeyword;
	private int mSearchType = 0;
	// 搜索类
	private PoiSearch mPoiSearch;
	// 搜索结果
	private ArrayList<PoiInfo> mPoiList;
	private ArrayList<PoiSearch.ProvinceInfo> mCityList;


	// 覆盖物
	private PoisOverlay mPoisOverlay;
//点击瞄准图层
	private MarkerOverlaytry mMarker;

	//地址查找位置结束
	@Override
	protected void onResume() {
		super.onResume();
		try{

			//      Bro.start();
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
			}     //
		}catch(Exception e){


		}

		registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());
		if (mBluetoothLeService != null) {
			final boolean result = mBluetoothLeService.connect(mDeviceAddress);
		//	Log.d(TAG, "Connect request result=" + result);
		}
	}



	@Override
	protected void onPause() {
		super.onPause();
	//	unregisterReceiver(mGattUpdateReceiver);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fuzhugongneng, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {



			case R.id.Menu_fuzhujisuan:
				intent=new Intent(this,Menujiben.class);

				startActivity(intent);

				break;
			case android.R.id.home:

				mDrawerLayout.openDrawer(GravityCompat.START);//打开侧滑菜单


			break;
		}

		return true;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			setContentView(com.example.artilleryandroid.R.layout.mylocationdemo);

//工具栏开始
			android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbartianditu);
			setSupportActionBar(toolbar);
			mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layouttianditu);
			ActionBar actionbar=getSupportActionBar();
			if(actionbar!=null)
			{
				actionbar.setDisplayHomeAsUpEnabled(true);

			}
			NavigationView navView =(NavigationView)findViewById(R.id.nav_view);


			navView .setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
				@Override public boolean onNavigationItemSelected(MenuItem menuItem) {
					mDrawerLayout.closeDrawers();;
					Intent	intent;
					switch (menuItem.getItemId())
					{case R.id.nav_Tiandituhelp:
							intent=new Intent(MyLocationDemo.this,Tiandituhelp.class);


						startActivity(intent);


						break;
						case R.id.nav_Fuzhujisuan:

							intent=new Intent(MyLocationDemo.this,Menujiben.class);

							startActivity(intent);
							break;


					}
								return true;
				}
			});


//工具栏结束


			//图层
		//	gongjulanchushihua();
			//图层显示信息
			mTextViewTips = (TextView) findViewById(com.example.artilleryandroid.R.id.textViewTips);

			// 地图视图
			mMapView = (MapView) findViewById(com.example.artilleryandroid.R.id.mapview);
			mMapView.setLogoPos(MapView.LOGO_LEFT_TOP);
			mMapView.setBuiltInZoomControls(true);


			mMapView.enableRotate(true);
			mMyLocation = new MyOverlay(this, mMapView);
			mMapView.addOverlay(mMyLocation);
			mLayerMnger = new TMapLayerManager(mMapView);
			// Tab视图
			mTabHost = (TabHost) findViewById(android.R.id.tabhost);
			mTabHost.setup();




			FrameLayout contentView = mTabHost.getTabContentView();
			LayoutInflater inflater = LayoutInflater.from(this);
			inflater.inflate(com.example.artilleryandroid.R.layout.mylocationdemotab1, contentView);
			inflater.inflate(com.example.artilleryandroid.R.layout.mylocationdemotab2, contentView);
			inflater.inflate(com.example.artilleryandroid.R.layout.mylocationdemotab3, contentView);
			inflater.inflate(com.example.artilleryandroid.R.layout.mylocationdemotab4, contentView);
			inflater.inflate(com.example.artilleryandroid.R.layout.mylocationdemotab5, contentView);
			inflater.inflate(com.example.artilleryandroid.R.layout.mylocationdemotab6, contentView);
			TabSpec tab = mTabHost.newTabSpec("tab1");
			tab.setIndicator("定位信息");
			tab.setContent(com.example.artilleryandroid.R.id.LinearLayout01);
			mTabHost.addTab(tab);

			tab = mTabHost.newTabSpec("tab2");
			tab.setIndicator("坐标设置");
			tab.setContent(com.example.artilleryandroid.R.id.LinearLayout02);
			mTabHost.addTab(tab);

			tab = mTabHost.newTabSpec("tab6");
			tab.setIndicator("修正计算");
			tab.setContent(R.id.LinearZuobiaoxiuzheng);
			mTabHost.addTab(tab);

			tab = mTabHost.newTabSpec("tab3");
			tab.setIndicator("图上量算");
			tab.setContent(com.example.artilleryandroid.R.id.LinearLayout03);
			mTabHost.addTab(tab);

			tab = mTabHost.newTabSpec("tab4");
			tab.setIndicator("航迹设置");
			tab.setContent(com.example.artilleryandroid.R.id.LinearLayout04);
			mTabHost.addTab(tab);
			tab = mTabHost.newTabSpec("tab5");
			tab.setIndicator("激光测距");
			tab.setContent(com.example.artilleryandroid.R.id.LinearLayout05);
			mTabHost.addTab(tab);



			TabWidget tabWidget = mTabHost.getTabWidget();
			int tabHeight = getResources().getDimensionPixelSize(com.example.artilleryandroid.R.dimen.tabtitleheight);
			for (int i = 0; i < tabWidget.getChildCount(); i++) {
				tabWidget.getChildAt(i).getLayoutParams().height = tabHeight;
			}

			mTab1 = new Tab1(this, contentView.getChildAt(0));
			mTab2 = new Tab2(this, contentView.getChildAt(1));
			mTab3 = new Tab3(this, contentView.getChildAt(2));
			mTab4 = new Tab4(this, contentView.getChildAt(3));
			mTab5 = new Tab5(this, contentView.getChildAt(4));
			mTab6 = new Tab6(this, contentView.getChildAt(5));
//选择地图类型
			mRadioGroup = (RadioGroup) findViewById(com.example.artilleryandroid.R.id.radioGroup1);
			int mapType = mMapView.getMapType();
			if (mapType == MapView.TMapType.MAP_TYPE_VEC)
				mRadioGroup.check(com.example.artilleryandroid.R.id.radio0);
			else if (mapType == MapView.TMapType.MAP_TYPE_IMG)
				mRadioGroup.check(com.example.artilleryandroid.R.id.radio1);
			else if (mapType == MapView.TMapType.MAP_TYPE_TERRAIN)
				mRadioGroup.check(com.example.artilleryandroid.R.id.radio2);

			mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					if (checkedId == com.example.artilleryandroid.R.id.radio0)
						mMapView.setMapType(MapView.TMapType.MAP_TYPE_VEC);
					else if (checkedId == com.example.artilleryandroid.R.id.radio1)
						mMapView.setMapType(MapView.TMapType.MAP_TYPE_IMG);
					else if (checkedId == com.example.artilleryandroid.R.id.radio2)
						mMapView.setMapType(MapView.TMapType.MAP_TYPE_TERRAIN);

					updateTips();
				}
			});
			SharedPreferences spf = getSharedPreferences("XiuZheng", Context.MODE_WORLD_WRITEABLE);

			ZuoBiaoXi = spf.getInt("ZuoBiaoXi", 3);
			XiuZhengX = spf.getFloat("XiuZhengX", 0);
			XiuZhengY = spf.getFloat("XiuZhengY", 0);
			XiuZhengH = spf.getFloat("XiuZhengH", 0);
	/*		edit.putBoolean("Daikuan3du",((RadioButton)findViewById(R.id.radioButton3du)).isChecked());
			edit.putBoolean("Shoudongzhongyangjingxian",((RadioButton)findViewById(R.id.radioButtonShoudongzhongyangjingdu)).isChecked());
			edit.putFloat("Zhongyangjingdu",
								(float)Double.parseDouble(((EditText)findViewById(R.id.editTextZhongyangjingdu)).getText().toString()));
*/
			ShoudongZhongyangjingxianjingdu=spf.getFloat("Zhongyangjingdu", 0);

			Shoudongjingxian= spf.getBoolean("Shoudongzhongyangjingxian", false);
			Shi3du=spf.getBoolean("Daikuan3du", false);
			if(Shoudongjingxian)
			{((RadioGroup) findViewById(R.id.radioGroupShoudongjingdu)).check(R.id.radioButtonShoudongzhongyangjingdu);
			}
			if(Shi3du)
			{((RadioGroup) findViewById(R.id.radioGroupFendudai)).check(R.id.radioButton3du);
				Fendudaikuan=3;
			}

			if (ZuoBiaoXi == 0) {
				((RadioGroup) findViewById(R.id.radioGroupzuobiaoxi)).check(R.id.radioButtonbeijing54);
			}

			if (ZuoBiaoXi == 1) {
				((RadioGroup) findViewById(R.id.radioGroupzuobiaoxi)).check(R.id.radioButtonxian80);
			}

			if (ZuoBiaoXi == 2) {
				((RadioGroup) findViewById(R.id.radioGroupzuobiaoxi)).check(R.id.radioButtonwgs84);
			}

			if (ZuoBiaoXi == 3) {
				((RadioGroup) findViewById(R.id.radioGroupzuobiaoxi)).check(R.id.radioButtondadi2000);
			}
			((EditText) findViewById(R.id.editTextXiuZhengX)).setText(String.format("% .2f", XiuZhengX));
			((EditText) findViewById(R.id.editTextXiuZhengY)).setText(String.format("% .2f", XiuZhengY));
			((EditText) findViewById(R.id.editTextXiuZhengH)).setText(String.format("% .2f", XiuZhengH));
			((EditText) findViewById(R.id.editTextZhongyangjingdu)).setText(String.format("% .7f", ShoudongZhongyangjingxianjingdu));
			//	Dituweidupiancha=spf.getFloat("Dituweidupiancha", 0);
			//	Ditujingdupiancha=spf.getFloat("Ditujingdupiancha", 0);


			cb2 = (CheckBox) this.findViewById(com.example.artilleryandroid.R.id.isWebMercator);
			cb2.setChecked(mMapView.isWebMercatorCRS());
			cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
											 boolean isChecked) {
					mMapView.toggleCoordinateSys();
				}
			});

			Button buttonLayer = (Button) findViewById(com.example.artilleryandroid.R.id.buttonLayer);
			buttonLayer.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					showMapLayerList();
				}

			});

			updateTips();
			//开启定位、指南针以及跟随模式
			getOverlay().enableMyLocation();
			getOverlay().enableCompass();

			getOverlay().setGpsFollow(true);
			//getOverlay().setGpsFollow(true)
			//(CheckBox) view.findViewById(com.example.artilleryandroid.R.id.checkFollow)
			//地址查找位置相关内容开始

			// type
			mBtnType = (Button) findViewById(R.id.buttonType);
			View.OnClickListener listener = new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					removeDialog(DIALOG_TYPE_LIST);
					showDialog(DIALOG_TYPE_LIST);
				}

			};
			mBtnType.setOnClickListener(listener);

			// edit
			mEditKey = (EditText) findViewById(R.id.editKey);
			mEditKey.setText("");

			// search
			mBtnSearch = (Button) findViewById(R.id.buttonSearch);
			listener = new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try{
					String key = mEditKey.getText().toString();
					searchKey(key, mSearchType);

				} catch (Exception e) {
					Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
				}

				}

			};
			mBtnSearch.setOnClickListener(listener);

			// list
			mBtnList = (Button) findViewById(R.id.buttonList);
			listener = new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					try{
					if (mPoiList != null && mPoiList.size() != 0) {
						removeDialog(DIALOG_POI_LIST);
						showDialog(DIALOG_POI_LIST);
					} else if (mCityList != null && mCityList.size() != 0) {
						removeDialog(DIALOG_CITY_LIST);
						showDialog(DIALOG_CITY_LIST);
					}



				} catch (Exception e) {
					Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
				}
				}

			};
			mBtnList.setOnClickListener(listener);

			// pre
			mBtnPre = (Button) findViewById(R.id.buttonPre);
			listener = new View.OnClickListener() {

				@Override
				public void onClick(View v) {
				}

			};
			mBtnPre.setOnClickListener(listener);

			// next
			mBtnNext = (Button) findViewById(R.id.buttonNext);
			listener = new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (mPoiList != null) {
						removeDialog(DIALOG_POI_LIST);
						showDialog(DIALOG_POI_LIST);
					} else if (mCityList != null) {
						removeDialog(DIALOG_CITY_LIST);
						showDialog(DIALOG_CITY_LIST);

					}
				}

			};
			mBtnNext.setOnClickListener(listener);

			// tips
			mTextTips = (TextView) findViewById(R.id.textViewTipsdizhixinxi);
			mTextTips.setText("");

			mSearchType = 0;
			mBtnType.setText(TYPE_NAME[mSearchType]);
			mBtnList.setEnabled(false);




		} catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	}

	//地址查找位置有关开始

	private void searchKey(String key, int type) {
		mKeyword = key;
		mTextTips.setText("开始搜索 key = " + key + ", type = " + type);
		mBtnList.setEnabled(false);
		mBtnPre.setEnabled(false);
		mBtnNext.setEnabled(false);

		if (mPoisOverlay != null) {
			mMapView.removeOverlay(mPoisOverlay);
			mPoisOverlay = null;
		}

		switch (type) {
			case 0: // 普通
				mPoiSearch = new PoiSearch(this, this, mMapView);
				mPoiSearch.search(key, null, null);
				break;
			case 1: // 视图范围内
				GeoPoint p1 = mMapView.getProjection().fromPixels(0, 0);
				GeoPoint p2 = mMapView.getProjection().fromPixels(mMapView.getWidth(),
						mMapView.getHeight());
				mPoiSearch = new PoiSearch(this, this, mMapView);
				mPoiSearch.search(key, p1, p2);
				break;
			case 2: // 周边
				mPoiSearch = new PoiSearch(this, this, mMapView);
				GeoPoint center = mMapView.getMapCenter();
				mPoiSearch.search(key, center, 20000);
				break;
			case 3: // 行政区
				mPoiSearch = new PoiSearch(this, this, mMapView);
				mPoiSearch.search("156110000", key);
				break;
		}

	}

	@Override
	public void OnGetPoiResult(ArrayList<PoiInfo> poiInfo, ArrayList<PoiSearch.ProvinceInfo> cityInfo,
							   String keyword, int error) {
		mPoiList = poiInfo;
		mCityList = cityInfo;

		int poiSize = poiInfo != null ? poiInfo.size() : 0;
		int citySize = cityInfo != null ? cityInfo.size() : 0;
try{
		if (error != TErrorCode.OK) {
			mTextTips.setText("搜索失败" + ", error = " + error);
			return;
		}
		if (poiSize == 0 && citySize == 0) {
			mTextTips.setText("没有找到结果 ");
			return;
		}

		String tips = String.format(Locale.getDefault(),
				"共计%s个搜索结果",
				poiSize);
		mTextTips.setText(tips);
		mBtnList.setEnabled(true);
		if (poiSize > 0) {
			mBtnPre.setEnabled(true);
			mBtnNext.setEnabled(true);
			Drawable marker = getResources().getDrawable(R.drawable.poi_xml);
			mPoisOverlay = new PoisOverlay(marker);
			mPoisOverlay.setData(poiInfo);
			mPoisOverlay.setDrawFocusedItem(true);
			mPoisOverlay.showFocusAlways(true);
			mPoisOverlay.populate();
			mMapView.addOverlay(mPoisOverlay);

			GeoPoint point = poiInfo.get(0).mPoint;
			mMapView.getController().animateTo(point);
		}

		// 添加覆盖物


	} catch (Exception e) {
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}

	}


	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
			case DIALOG_TYPE_LIST:
				return showTypeList();
			case DIALOG_POI_LIST:
				return showPoiList();
			case DIALOG_CITY_LIST:
				return showCityList();
			default:
				break;
		}
		return null;
	}

	private Dialog showTypeList() {
		DialogInterface.OnClickListener listenerList = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				mSearchType = which;
			}
		};

		DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				mBtnType.setText(TYPE_NAME[mSearchType]);
			}
		};
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("选择搜索方式");
		builder.setSingleChoiceItems(TYPE_NAME, mSearchType, listenerList);
		builder.setPositiveButton("确定", listener);
		return builder.create();
	}

	private Dialog showPoiList() {
		int size = mPoiList.size();
		String items[] = new String[size];
		for (int i = 0; i < size; ++i) {
			items[i] = "地名:" + mPoiList.get(i).mStrName + "\n";
			items[i] += "地址:" + mPoiList.get(i).mStrAdd + "\n";
			items[i] += "电话:" + mPoiList.get(i).mStrTel;
		}
		DialogInterface.OnClickListener listenerList = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				GeoPoint geoPoint = mPoisOverlay.getItem(which).getPoint();
				mPoisOverlay.setFocusID(which);
				mMapView.getController().setCenter(geoPoint);

				dialog.dismiss();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("地名搜索结果");
		builder.setItems(items, listenerList);
		return builder.create();
	}

	String mDlgCityTitle = "";
	List<PoiSearch.CityInfo> mDlgCityList = null;

	private Dialog showCityList() {
		int size = mDlgCityList != null ? mDlgCityList.size() : 0;
		String items[] = new String[size];
		for (int i = 0; i < size; ++i) {
			items[i] = mDlgCityList.get(i).mStrName;
		}
		DialogInterface.OnClickListener listenerList = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(mDlgCityTitle);
		builder.setItems(items, listenerList);
		return builder.create();

	}



	//地址查找位置控件结束

	@Override
	protected void onDestroy() {
		try{super.onDestroy();
		mJieshu=true;
		if (mMyLocation.isCompassEnabled())
			mMyLocation.disableCompass();
		if (mMyLocation.isMyLocationEnabled())
			mMyLocation.disableMyLocation();
		if(mBluetoothLeService != null)
			{
				unbindService(mServiceConnection);
				mBluetoothLeService = null;
			}
			if (mBluetoothService != null) mBluetoothService.stop();
			if (mBluetoothService1 != null) mBluetoothService1.stop();
			if (mBluetoothService2 != null) mBluetoothService2.stop();
			if (mBluetoothService3 != null) mBluetoothService3.stop();


		}catch(Exception e){

			//Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	}

	MyLocationOverlay getOverlay()
	{
		return mMyLocation;
	}
	/**
	 * Tab6
	 * 辅助坐标修正
	 */


	class Tab6 {

			double  BujiaxiuX=0,BujiaxiuY=0,BujiaxiuH=0,XinxiuzhengX=0,XinxiuzhengY=0,XinxiuzhengH=0;


		public Tab6(Activity activity, View view) {
			;
			((Button)findViewById(R.id.buttonduquweizhi)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					try {
				/*		resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
								+ "修正量X：" + (String.format("% .2f", XiuZhengX))
								+ "Y：" + (String.format("% .2f", XiuZhengY))
								+ "H：" + (String.format("% .2f", XiuZhengH))
								+"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
								+"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
								+"强行指定中央经线："+Shoudongjingxian)+*/

						((TextView)findViewById(R.id.textViewJibenzuobiaoxi)).setText(resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
								+ "修正量X：" + (String.format("% .2f", XiuZhengX))
								+ "Y：" + (String.format("% .2f", XiuZhengY))
								+ "H：" + (String.format("% .2f", XiuZhengH))
								+"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
								+"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
								+"强行指定中央经线："+Shoudongjingxian);

						((EditText)findViewById(R.id.editTextYuanX)).setText(String.format("% .2f",ZhanliX));
						((EditText)findViewById(R.id.editTextYuanY)).setText(String.format("% .2f",ZhanliY));
						((EditText)findViewById(R.id.editTextYuanH)).setText(String.format("% .2f",ZhanliH));

					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
				}


			});


			((Button)findViewById(R.id.buttonduqutushang)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					try {
						((TextView)findViewById(R.id.textViewJibenzuobiaoxi)).setText(resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
								+ "修正量X：" + (String.format("% .2f", XiuZhengX))
								+ "Y：" + (String.format("% .2f", XiuZhengY))
								+ "H：" + (String.format("% .2f", XiuZhengH))
								+"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
								+"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
								+"强行指定中央经线："+Shoudongjingxian);

						((EditText)findViewById(R.id.editTextYuanX)).setText(String.format("% .2f",DituqudianX));
						((EditText)findViewById(R.id.editTextYuanY)).setText(String.format("% .2f",DituqudianY));
						((EditText)findViewById(R.id.editTextYuanH)).setText(String.format("% .2f",0.0));


					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
				}


			});
			((Button)findViewById(R.id.buttonjisuanbuxiaxiuzheng)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					try {
						((TextView)findViewById(R.id.textViewJibenzuobiaoxi)).setText(resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
								+ "修正量X：" + (String.format("% .2f", XiuZhengX))
								+ "Y：" + (String.format("% .2f", XiuZhengY))
								+ "H：" + (String.format("% .2f", XiuZhengH))
								+"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
								+"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
								+"强行指定中央经线："+Shoudongjingxian);
							BujiaxiuX=Double.parseDouble(((EditText)findViewById(R.id.editTextXianX)).getText().toString())
							-Double.parseDouble(((EditText)findViewById(R.id.editTextYuanX)).getText().toString());
							;		BujiaxiuY=Double.parseDouble(((EditText)findViewById(R.id.editTextXianY)).getText().toString())
								-Double.parseDouble(((EditText)findViewById(R.id.editTextYuanY)).getText().toString());
						BujiaxiuH=Double.parseDouble(((EditText)findViewById(R.id.editTextXianH)).getText().toString())
								-Double.parseDouble(((EditText)findViewById(R.id.editTextYuanH)).getText().toString());
				XinxiuzhengX=XiuZhengX+BujiaxiuX;
						XinxiuzhengY=XiuZhengY+BujiaxiuY;
						XinxiuzhengH=XiuZhengH+BujiaxiuH;
						((TextView)findViewById(R.id.textViewbujiaxinxi)).setText(

										"偏差X：" + (String.format("% .2f", BujiaxiuX))
								+ "Y：" + (String.format("% .2f", BujiaxiuY))
								+ "H：" + (String.format("% .2f", BujiaxiuH))
								+"\n新修正量X：" + (String.format("% .2f", XinxiuzhengX))
								+ "Y：" + (String.format("% .2f", XinxiuzhengY))
								+ "H：" + (String.format("% .2f", XinxiuzhengH)));


						Toast.makeText(MyLocationDemo.this, "新坐标偏移量计算完毕", Toast.LENGTH_LONG).show();


					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
				}


			});


			((Button)findViewById(R.id.buttonXinxiuzheng)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					try {
					XiuZhengX=XinxiuzhengX;
						XiuZhengY=XinxiuzhengY;
						XiuZhengH=XinxiuzhengH;
						SharedPreferences spf = getSharedPreferences("XiuZheng", Context.MODE_WORLD_WRITEABLE);

						SharedPreferences.Editor edit = spf.edit();

						edit.putFloat("XiuZhengX", (float) XiuZhengX);
						edit.putFloat("XiuZhengY", (float) XiuZhengY);
						edit.putFloat("XiuZhengH", (float) XiuZhengH);

						edit.commit();
						Toast.makeText(MyLocationDemo.this, "新坐标偏移量设置保存完毕", Toast.LENGTH_LONG).show();


					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
				}


			});


		}
	}

	/**
	 * Tab1
	 * 定位&指南针
	 */
	class Tab1 {
		CheckBox mCheckCompass;
		CheckBox mCheckLocation;
		CheckBox mCheckFollow;
		CheckBox mCheckFanglige;
		TextView mTextTips;

		public Tab1(Activity activity, View view) {
			mCheckCompass = (CheckBox) view.findViewById(com.example.artilleryandroid.R.id.checkCompass);
			mCheckCompass.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked)
						getOverlay().enableCompass();
					else
						getOverlay().disableCompass();
					//地图归北
					mMapView.setMapRotation(0);
				}
			});

			mCheckLocation = (CheckBox) view.findViewById(com.example.artilleryandroid.R.id.checkLocation);
			mCheckLocation.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked)
						getOverlay().enableMyLocation();
					else
						getOverlay().disableMyLocation();
				}
			});

			mCheckFollow = (CheckBox) view.findViewById(com.example.artilleryandroid.R.id.checkFollow);
			mCheckFollow.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					getOverlay().setGpsFollow(isChecked);
				}
			});
			mCheckFollow = (CheckBox) view.findViewById(R.id.checkBoxfanglige);
			mCheckFollow.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//	getOverlay().setGpsFollow(isChecked);
					Lineoverlay.setVisible(isChecked);
					Xianshifanglige();

				}
			});
			mTextTips = (TextView) view.findViewById(com.example.artilleryandroid.R.id.textViewTips);
		}
	}

	/**
	 * Tab2
	 * 隐显信息
	 */
	class Tab2 {
		//Button mBtnLocation;
		TextView mTextTips;
		CheckBox mCheckshijian;
		CheckBox mCheckjingdu;
		CheckBox mCheckfangxiang;
		CheckBox mChecksudu;
		RadioGroup mRadioGroupzuobiaoxi;
		EditText Xiuzhengx, Xiuzhengy, Xiuzhengh;
		Button mBtnshezhipianyi;
		Button mBtnlixianditu;

		public Tab2(Activity activity, View view) {
			mCheckshijian = (CheckBox) view.findViewById(R.id.checkShijian);
			mCheckshijian.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Xianshishijian = isChecked;
				}
			});
			mCheckjingdu = (CheckBox) view.findViewById(R.id.checkJingdu);
			mCheckjingdu.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Xianshijingdu = isChecked;
				}
			});
			mCheckfangxiang = (CheckBox) view.findViewById(R.id.checkFangxiang);
			mCheckfangxiang.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Xianshifangxiang = isChecked;
				}
			});
			mChecksudu = (CheckBox) view.findViewById(R.id.checkSudu);
			mChecksudu.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Xianshisudu = isChecked;
				}
			});
			mRadioGroupzuobiaoxi = (RadioGroup) view.findViewById(R.id.radioGroupzuobiaoxi);
			mRadioGroupzuobiaoxi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					if (checkedId == R.id.radioButtonbeijing54)
						ZuoBiaoXi = 0;
					else if (checkedId == R.id.radioButtonxian80)
						ZuoBiaoXi = 1;
					else if (checkedId == R.id.radioButtonwgs84)
						ZuoBiaoXi = 2;
					else if (checkedId == R.id.radioButtondadi2000)
						ZuoBiaoXi = 3;
					//保存坐标系
					SharedPreferences spf = getSharedPreferences("XiuZheng", Context.MODE_WORLD_WRITEABLE);
					SharedPreferences.Editor edit = spf.edit();
					edit.putInt("ZuoBiaoXi", ZuoBiaoXi);
					edit.commit();
					Toast.makeText(MyLocationDemo.this, "坐标系设置完毕", Toast.LENGTH_LONG).show();
				}
			});

			((RadioGroup) view.findViewById(R.id.radioGroupFendudai)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					if (checkedId == R.id.radioButton6du)
						Fendudaikuan=6;
					else if (checkedId == R.id.radioButton3du)
						Fendudaikuan=3;

					//保存坐标系
					SharedPreferences spf = getSharedPreferences("XiuZheng", Context.MODE_WORLD_WRITEABLE);
					SharedPreferences.Editor edit = spf.edit();
					edit.putBoolean("Daikuan3du",((RadioButton)findViewById(R.id.radioButton3du)).isChecked());
					edit.commit();
					Toast.makeText(MyLocationDemo.this, "分度带宽设置完毕", Toast.LENGTH_LONG).show();
				}
			});
			((RadioGroup) view.findViewById(R.id.radioGroupShoudongjingdu)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					if (checkedId == R.id.radioButtonZidongzhongyangjingdu)
						Shoudongjingxian=false;
					else if (checkedId == R.id.radioButtonShoudongzhongyangjingdu)
					Shoudongjingxian=true	;

					//保存坐标系
					SharedPreferences spf = getSharedPreferences("XiuZheng", Context.MODE_WORLD_WRITEABLE);
					SharedPreferences.Editor edit = spf.edit();
					edit.putBoolean("Shoudongzhongyangjingxian",((RadioButton)findViewById(R.id.radioButtonShoudongzhongyangjingdu)).isChecked());
					edit.commit();
					Toast.makeText(MyLocationDemo.this, "中央经度确定方式设置完毕", Toast.LENGTH_LONG).show();
				}
			});
			Xiuzhengx = (EditText) view.findViewById(R.id.editTextXiuZhengX);
			Xiuzhengy = (EditText) view.findViewById(R.id.editTextXiuZhengY);
			Xiuzhengh = (EditText) view.findViewById(R.id.editTextXiuZhengH);
			mBtnshezhipianyi = (Button) view.findViewById(R.id.button22shezhizuobiaoxi);
			mBtnshezhipianyi.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					try {
						XiuZhengX = Double.parseDouble((Xiuzhengx.getText().toString()));
						XiuZhengY = Double.parseDouble((Xiuzhengy.getText().toString()));
						XiuZhengH = Double.parseDouble((Xiuzhengh.getText().toString()));
						ShoudongZhongyangjingxianjingdu=Double.parseDouble(((EditText)findViewById(R.id.editTextZhongyangjingdu)).getText().toString());
						SharedPreferences spf = getSharedPreferences("XiuZheng", Context.MODE_WORLD_WRITEABLE);

						SharedPreferences.Editor edit = spf.edit();

						edit.putFloat("XiuZhengX", (float) XiuZhengX);
						edit.putFloat("XiuZhengY", (float) XiuZhengY);
						edit.putFloat("XiuZhengH", (float) XiuZhengH);
					//	edit.putBoolean("Shoudongzhongyangjingxian",((RadioButton)findViewById(R.id.radioButtonShoudongzhongyangjingdu)).isChecked());
						edit.putFloat("Zhongyangjingdu",
								(float)Double.parseDouble(((EditText)findViewById(R.id.editTextZhongyangjingdu)).getText().toString()));
						edit.commit();
						Toast.makeText(MyLocationDemo.this, "中央经线及坐标偏移量设置完毕", Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
				}


			});
			Button mBtnlixianditu = (Button) view.findViewById(R.id.button25lixianditu);
			;
			mBtnlixianditu.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					try {
						Intent intent = new Intent(MyLocationDemo.this, OfflineMapDemoList.class);

						startActivity(intent);

					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
				}


			});
			mTextTips = (TextView) view.findViewById(com.example.artilleryandroid.R.id.textViewTips);
		}

	}
///


	/**
	 * Tab3
	 * 操作
	 */

	class Tab3 {
		TextView mTextTips;

		private EditText mEditLon, mEditzuobiaoX;
		private EditText mEditLat, mEditzuobiaoY;
		private Button mBtnjingweidingdian, mBtnzuobiaodingdian;
		TextView textViewzuobiaoxixianshi;

		CheckBox mCheckshouhuahangji;
		/*	private MarkerOverlay mMarker;*/
//



		public Tab3(Activity activity, View view) {

			textViewzuobiaoxixianshi = (TextView) view.findViewById(R.id.TextViewzuobiaoleixing);
			mEditLon = (EditText) view.findViewById(com.example.artilleryandroid.R.id.editTextLon);
			mEditLat = (EditText) view.findViewById(com.example.artilleryandroid.R.id.editTextLat);
			mEditzuobiaoX = (EditText) view.findViewById(R.id.editTextdingdianX);
			mEditzuobiaoY = (EditText) view.findViewById(R.id.editTextdingdianY);
			//经纬度定点
			mBtnjingweidingdian = (Button) view.findViewById(R.id.buttonJingweidingdian);
			mBtnjingweidingdian.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						mMapView.setMapRotation(0);
						//暂停跟随模式
						getOverlay().setGpsFollow(false);
						((CheckBox) findViewById(com.example.artilleryandroid.R.id.checkFollow)).setChecked(false);
						resn = getResources();

						double dLon = MapControllDemo.getDouble(mEditLon.getText().toString());
						double dLat = MapControllDemo.getDouble(mEditLat.getText().toString());
						//+"\nX："+String.format("% .2f",XiuZhengX+ ggg.Geo2GausiXianX(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi))
						//		+"\nY："+String.format("% .2f", XiuZhengY+ggg.Geo2GausiXianY(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi))
	/*					mEditzuobiaoX.setText(String.format("% .2f", XiuZhengX + ggg.Geo2GausiXianX(dLon, dLat, ZuoBiaoXi)));
						mEditzuobiaoY.setText(String.format("% .2f", XiuZhengY + ggg.Geo2GausiXianY(dLon, dLat, ZuoBiaoXi)));
                        */
                        gggSuanzuobiao.Jingweizhuanzuobiao(dLon, dLat, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);
                        mEditzuobiaoX.setText(String.format("% .2f", XiuZhengX +  gggSuanzuobiao.ShuchuX));
                        mEditzuobiaoY.setText(String.format("% .2f", XiuZhengY + gggSuanzuobiao.ShuchuY));

                        textViewzuobiaoxixianshi.setText(resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
                                + "修正量X：" + (String.format("% .2f", XiuZhengX))
                                + "Y：" + (String.format("% .2f", XiuZhengY))
                                + "H：" + (String.format("% .2f", XiuZhengH))
                                +"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
                                +"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
                                +"强行指定中央经线："+Shoudongjingxian);
						GeoPoint geoPoint = new GeoPoint((int) (dLat * 1E6), (int) (dLon * 1E6));
						mMarker.setPosition(geoPoint);
						mMapView.getController().setCenter(geoPoint);
						updateTipsdingwei();



					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});
			//坐标定点
			mBtnzuobiaodingdian = (Button) view.findViewById(R.id.buttonZuobiaodingdian);
			mBtnzuobiaodingdian.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						mMapView.setMapRotation(0);
						//暂停跟随模式
						getOverlay().setGpsFollow(false);
						((CheckBox) findViewById(com.example.artilleryandroid.R.id.checkFollow)).setChecked(false);
						resn = getResources();
						textViewzuobiaoxixianshi.setText(resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
                                + "修正量X：" + (String.format("% .2f", XiuZhengX))
                                + "Y：" + (String.format("% .2f", XiuZhengY))
                                + "H：" + (String.format("% .2f", XiuZhengH))
                                +"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
                                +"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
                                +"强行指定中央经线："+Shoudongjingxian);

						double ShuruX = MapControllDemo.getDouble(mEditzuobiaoX.getText().toString());
						double ShuruY = MapControllDemo.getDouble(mEditzuobiaoY.getText().toString());
						//+"\nX："+String.format("% .2f",XiuZhengX+ ggg.Geo2GausiXianX(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi))
						//		+"\nY："+String.format("% .2f", XiuZhengY+ggg.Geo2GausiXianY(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi))
						//Weidulinshi1= ggg.Zuobiaozhuanjingweiduweidu(ZuoBiaoXi, (DituX-XiuZhengX), (DituY-XiuZhengY));
//	Jingdulinshi1= ggg.Zuobiaozhuanjingweidujingdu(ZuoBiaoXi, (DituX-XiuZhengX), (DituY-XiuZhengY));
						gggSuanzuobiao.Zuobiaozhuanjingweiduweidu(ZuoBiaoXi,(ShuruX - XiuZhengX), (ShuruY - XiuZhengY),Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);




						double dLat = gggSuanzuobiao.Zhuanhuanweidu;
						double dLon = gggSuanzuobiao.Zhuanhuanjingdu;
						mEditLat.setText(String.format("% .7f", dLat));
						mEditLon.setText(String.format("% .7f", dLon));

						GeoPoint geoPoint = new GeoPoint((int) (dLat * 1E6), (int) (dLon * 1E6));
						mMarker.setPosition(geoPoint);
						mMapView.getController().setCenter(geoPoint);


						updateTipsdingwei();
					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});


			mTextTips = (TextView) view.findViewById(R.id.textViewTipsdizhixinxi);

			//	mEditLon.setText(String.format(Locale.getDefault(), "%.6f", 116.4));
			//		mEditLat.setText(String.format(Locale.getDefault(), "%.6f", 39.9));

			DrawableOption option = new DrawableOption();
			option.setAnchor(0.5f, 0.5f);
			option.setRotate(0);
	/*		mMarker = new MarkerOverlay() ;
			mMarker.setOption(option);
			mMarker.setIcon(activity.getResources().getDrawable(R.drawable.redaimer));
			mMapView.addOverlay(mMarker);*/

			mMarker = new MarkerOverlaytry();
			//	mMarker.setOption(option);
			//	mMarker.setIcon(activity.getResources().getDrawable(R.drawable.redaimer));
			mMapView.addOverlay(mMarker);
			//以上为点哪瞄准哪
			Goujianshouhuahangji();
			mCheckshouhuahangji = (CheckBox) view.findViewById(R.id.checkHuahangji);

			mCheckshouhuahangji.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Xianshifangxiang = isChecked;
					if(isChecked) {
						((CheckBox) findViewById(R.id.checkXianshiluxian)).setChecked(isChecked);
						Toast.makeText(MyLocationDemo.this,"长距离量算时，建议开启手动指定中央经线，防止跨经度带计算错误", Toast.LENGTH_LONG).show();

					}
/*					if(isChecked)
						Goujianshouhuahangji();
					else
						mMapView.removeOverlay(ShouhuaHangjioverlay);*/
				}
			});


			//显示路线？
			((CheckBox) view.findViewById(R.id.checkXianshiluxian)).setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Xianshifangxiang = isChecked;
					ShouhuaHangjioverlay.setVisible(isChecked);

		Luxianmoduanoverlay.setVisible(isChecked);


					if(!isChecked)
						((CheckBox) findViewById(R.id.checkHuahangji)).setChecked(isChecked);
/*					if(isChecked)
						Goujianshouhuahangji();
					else
						mMapView.removeOverlay(ShouhuaHangjioverlay);*/
				}
			});

			//退一步
			( (Button)view.findViewById(R.id.buttontuiyibu)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						ShouhuaHangjipoints.remove(ShouhuaHangjipoints.size()-1);
						Luxianmoduanpoints.clear();
						Luxianmoduanpoints.add(ShouhuaHangjipoints.get(0));
						Luxianmoduanpoints.add(ShouhuaHangjipoints.get(ShouhuaHangjipoints.size()-1));
						Luxianmoduanoverlay.setPoints(Luxianmoduanpoints);
						ShouhuaHangjioverlay.setPoints(ShouhuaHangjipoints);
						Liangsuan();

				//				+"\nX："+String.format("% .2f",XiuZhengX+ ggg.Geo2GausiXianX(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi))
				//						+"\nY："+String.format("% .2f", XiuZhengY+ggg.Geo2GausiXianY(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi))

					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});
			//存储路线
			( (Button)view.findViewById(R.id.buttonCunchuluxian)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						Cunchuluxian();

					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});

			//读取路线
			( (Button)view.findViewById(R.id.buttonDuquluxian)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						Duquluxian();
						//mMapView.setfoc
					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});

		}
/*		public Tab3(Activity activity, View view) {



			mTextTips = (TextView) view.findViewById(com.example.artilleryandroid.R.id.textViewTips);
		}*/



		//读取路线
public void Duquluxian()
{
	try{
		OutputStream out =null;
		InputStream in =null;
		BufferedWriter bw=null;
		BufferedReader br=null;


             int TempIII;
		String TempWD,TempJD;
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))

		{
			folderName=Environment.getExternalStorageDirectory().getPath()+"/Luxian".toString();
			folder=new File(folderName);
			if(folder==null||!folder.exists())//如果文件夹不存在
			{
				Toast.makeText(MyLocationDemo.this, folderName+"文件夹不存在", Toast.LENGTH_LONG).show();
				return;
			}

			saveFile=new File(folderName,((Spinner)findViewById(R.id.spinnerhuizhiluxian))
					.getItemAtPosition(((Spinner)findViewById(R.id.spinnerhuizhiluxian)).getSelectedItemPosition())+".txt".toString());
			if(!saveFile.exists())//如果文件不存在
			{
				Toast.makeText(MyLocationDemo.this, folderName+"/"+((Spinner)findViewById(R.id.spinnerhuizhiluxian))
						.getItemAtPosition(((Spinner)findViewById(R.id.spinnerhuizhiluxian))
								.getSelectedItemPosition()).toString()+"路线不存在", Toast.LENGTH_LONG).show();
				return;
			}
			in=new FileInputStream(saveFile);
			br=new BufferedReader(new InputStreamReader(in,"UTF-8"));


			ShouhuaHangjipoints.clear();
			while(((TempWD=br.readLine())!=null)&&((TempJD=br.readLine())!=null))

			{

				ShouhuaHangjipoints.add(new GeoPoint(Integer.parseInt(TempWD),Integer.parseInt(TempJD)));



			}
			ShouhuaHangjioverlay.setPoints(ShouhuaHangjipoints);
			Luxianmoduanpoints.clear();
			Luxianmoduanpoints.add(ShouhuaHangjipoints.get(0));
			Luxianmoduanpoints.add(ShouhuaHangjipoints.get(ShouhuaHangjipoints.size()-1));
			Luxianmoduanoverlay.setPoints(Luxianmoduanpoints);

			Liangsuan();
			br.close();
			in.close();
			((CheckBox) findViewById(R.id.checkXianshiluxian)).setChecked(true);
			Toast.makeText(MyLocationDemo.this, "路线读取完毕", Toast.LENGTH_LONG).show();

		}}
	catch(Exception e){
		//Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}

}
		//存储路线
public void Cunchuluxian()
{
	try{
		OutputStream out =null;
		InputStream in =null;
		BufferedWriter bw=null;
		BufferedReader br=null;


		int Tempdi;
		//mMapView.
		//	SharedPreferences spf=getSharedPreferences("Hangji"+SP1.getItemAtPosition(SP1.getSelectedItemPosition()).toString(),Context.MODE_WORLD_WRITEABLE);
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))

		{
			folderName=Environment.getExternalStorageDirectory().getPath()+"/Luxian".toString();
			folder=new File(folderName);
			if(folder==null||!folder.exists())//如果文件夹不存在
			{
				folder.mkdir();
			}

			saveFile=new File(folderName,((Spinner)findViewById(R.id.spinnerhuizhiluxian))
					.getItemAtPosition(((Spinner)findViewById(R.id.spinnerhuizhiluxian))
							.getSelectedItemPosition()).toString()+".txt");
			if(!saveFile.exists())//如果文件不存在
			{
				saveFile.createNewFile();
			}


			out=new FileOutputStream(saveFile);
			bw=new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
			for(Tempdi=0;Tempdi<ShouhuaHangjipoints.size();Tempdi++)
			{
				bw.append(""+ShouhuaHangjipoints.get(Tempdi).getLatitudeE6()+"\n");

				//  Toast.makeText(this, ""+mPoint.latitude, Toast.LENGTH_LONG).show();
				bw.append(""+ShouhuaHangjipoints.get(Tempdi).getLongitudeE6()+"\n");
			}
			//  Toast.makeText(this, ""+mPoint.longitude, Toast.LENGTH_LONG).show();
			bw.close();
			out.close();
			Toast.makeText(MyLocationDemo.this,"路线存储完毕", Toast.LENGTH_LONG).show();
		}



	}
	catch(Exception e){
		Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
	}

}


		/**
		 * 更新提示信息
		 */
		void updateTipsdingwei() {
/*			GeoPoint center = mMapView.getMapCenter();
			String tips = String.format(Locale.getDefault(), "%s\n%s", //
					MapControllDemo.getGeoPoint(center), // 经纬度坐标
					MapControllDemo.getZoomLevel(mMapView)); // 比例尺
			mTextTips.setText(tips);*/
		}

	}


	//自动·航迹
	void Zidonghuahangji(GeoPoint point1,GeoPoint point2) {
		try {
			//	ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
/*//画航迹
			int Hangjidianshu=0;
//	GeoPoint mGeoPointhangji[]=new GeoPoint[1000000];
			ArrayList<GeoPoint> Hangjipoints = new ArrayList<GeoPoint>();
			ArrayList<GeoPoint> Hangjihuaxianpoints = new ArrayList<GeoPoint>();


			//PolylineOverlay[] Hangjioverlay= new PolylineOverlay();

			ArrayList<PolylineOverlay> Hangjioverlay = new ArrayList<PolylineOverlay>();
			GeoPoint Shangyidian=null;//画航迹上一点

//画航迹结束*/
			ArrayList<GeoPoint> Hangjihuaxianpoints = new ArrayList<GeoPoint>();
			Hangjihuaxianpoints.clear();
			Hangjihuaxianpoints.add(point1);
			Hangjihuaxianpoints.add(point2);
			//			Hangjipoints.add(new GeoPoint((int) (dLat * 1E6), (int) (dLon * 1E6)));
			ZidongHangjioption.setStrokeWidth(5);
			ZidongHangjioption.setDottedLine(false);
			ZidongHangjioption.setStrokeColor(Color.BLUE);
		//	PolylineOverlay Templine=new PolylineOverlay();
            Hangjioverlayqun.add(new PolylineOverlay());
			//PolylineOverlay overlay = new PolylineOverlay();
			Hangjioverlayqun.get(Hangjioverlayqun.size()-1)
			.setOption(ZidongHangjioption);
			Hangjioverlayqun.get(Hangjioverlayqun.size()-1)
					.setPoints(Hangjihuaxianpoints);
			Hangjioverlayqun.get(Hangjioverlayqun.size()-1).setVisible(((CheckBox) findViewById(R.id.checkXianshihangji)).isChecked());
			mMapView.addOverlay(	Hangjioverlayqun.get(Hangjioverlayqun.size()-1));
			//Toast.makeText(MyLocationDemo.this, ""+Hangjioverlayqun.size(), Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
		}
	}

	public void Liangsuan()//显示长度及面积量算信息
	{				double Xatemp=0,Yatemp=0,Xbtemp=0,Ybtemp=0,Lattemp=0,Lontemp=0,Zongmianji=0,Linshimianji=0,Xori=0,Yori=0;
		int Tempdian=0;
		try{	Danxiangzhexianchang=0;

			Lattemp=(double)(ShouhuaHangjipoints.get(0).getLatitudeE6())/1000000;
			Lontemp=(double)(ShouhuaHangjipoints.get(0).getLongitudeE6())/1000000;
            gggSuanzuobiao.Jingweizhuanzuobiao(Lontemp,Lattemp, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

			Xori=XiuZhengX+ gggSuanzuobiao.ShuchuX;

			Yori=XiuZhengY+ gggSuanzuobiao.ShuchuY;
			for(Tempdian=1;Tempdian<ShouhuaHangjipoints.size();Tempdian++)
			{                        Lattemp=(double)(ShouhuaHangjipoints.get(Tempdian-1).getLatitudeE6())/1000000;
				Lontemp=(double)(ShouhuaHangjipoints.get(Tempdian-1).getLongitudeE6())/1000000;
                gggSuanzuobiao.Jingweizhuanzuobiao(Lontemp,Lattemp, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

                Xatemp=XiuZhengX+ gggSuanzuobiao.ShuchuX;
				Yatemp=XiuZhengY+ gggSuanzuobiao.ShuchuY;
				Lattemp=(double)(ShouhuaHangjipoints.get(Tempdian).getLatitudeE6())/1000000;
				Lontemp=(double)(ShouhuaHangjipoints.get(Tempdian).getLongitudeE6())/1000000;
                gggSuanzuobiao.Jingweizhuanzuobiao(Lontemp,Lattemp, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

                Xbtemp=XiuZhengX+ gggSuanzuobiao.ShuchuX;;
				Ybtemp=XiuZhengY+ gggSuanzuobiao.ShuchuY;
				Danxiangzhexianchang=Danxiangzhexianchang+ggg.NiyunsuanDAB(Xatemp,Yatemp,0,Xbtemp,Ybtemp,0);
				Linshimianji=ggg.Sanjiaomianji(Xori,Yori,Xatemp,Yatemp,Xbtemp,Ybtemp);
				Zongmianji=Zongmianji+Linshimianji;
			}
			if(Zongmianji<0){Zongmianji=0-Zongmianji;}
			Lattemp=(double)(ShouhuaHangjipoints.get(0).getLatitudeE6())/1000000;
			Lontemp=(double)(ShouhuaHangjipoints.get(0).getLongitudeE6())/1000000;
            gggSuanzuobiao.Jingweizhuanzuobiao(Lontemp,Lattemp, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);
            Xatemp=XiuZhengX+ gggSuanzuobiao.ShuchuX;
            Yatemp=XiuZhengY+ gggSuanzuobiao.ShuchuY;

			Lattemp=(double)(ShouhuaHangjipoints.get(ShouhuaHangjipoints.size()-1).getLatitudeE6())/1000000;
			Lontemp=(double)(ShouhuaHangjipoints.get(ShouhuaHangjipoints.size()-1).getLongitudeE6())/1000000;
            gggSuanzuobiao.Jingweizhuanzuobiao(Lontemp,Lattemp, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

            Xbtemp=XiuZhengX+ gggSuanzuobiao.ShuchuX;;
            Ybtemp=XiuZhengY+ gggSuanzuobiao.ShuchuY;
			Zhixianfangweimiwei=ggg.NiyunsuanFAB(Xatemp,Yatemp,0,Xbtemp,Ybtemp,0);
			Zhixianjuli=ggg.NiyunsuanDAB(Xatemp,Yatemp,0,Xbtemp,Ybtemp,0);
			Bihezhexianchang=Danxiangzhexianchang+Zhixianjuli;
			((TextView) findViewById(R.id.textViewDituliangsuanxinxi)).setText("地图量算信息："
					+"\n起点至终点直线距离："+String.format("% .2f",Zhixianjuli)+"米"
					+"起点至终点方位："+String.format("% .2f",Zhixianfangweimiwei)+"密位，即"
					+String.format("% .2f",Zhixianfangweimiwei*360/6000)+"度"
					+"\n单向路程长："+String.format("% .2f",Danxiangzhexianchang)+"米"
					+"闭合路程长："+String.format("% .2f",Bihezhexianchang)+"米"
					+"总面积："+String.format("% .2f",Zongmianji)+"平方米"
			);

		}
		catch(Exception e){
			//Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}

	}

	//构建路线航迹
	void Goujianshouhuahangji() {
		try {
		//	ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();

               ShouhuaHangjipoints.clear();
			Luxianmoduanpoints.clear();
	//			Hangjipoints.add(new GeoPoint((int) (dLat * 1E6), (int) (dLon * 1E6)));
				Hangjioption.setStrokeWidth(5);
			Hangjioption.setDottedLine(false);
			Hangjioption.setStrokeColor(Color.RED);


			//PolylineOverlay overlay = new PolylineOverlay();
			ShouhuaHangjioverlay.setOption(Hangjioption);
			Moduanoption.setStrokeWidth(5);
			Moduanoption.setDottedLine(false);
			Moduanoption.setStrokeColor(Color.GRAY);


			Luxianmoduanoverlay.setOption(Moduanoption);


			ShouhuaHangjioverlay.setPoints(ShouhuaHangjipoints);

			Luxianmoduanoverlay.setPoints(Luxianmoduanpoints);

			mMapView.addOverlay(ShouhuaHangjioverlay);
			mMapView.addOverlay(Luxianmoduanoverlay);
        		} catch (Exception e) {
		Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
	}
	}


//自定义方里格图层

	public class MarkerOverlayfanglige extends Overlay {
		public Drawable mDrawable;


		public DrawableOption mOption;


		public MarkerOverlayfanglige() {
			try {
				mDrawable = MyLocationDemo.this.getResources().getDrawable(R.drawable.redaimer);
				mOption = new DrawableOption();
				mOption.setAnchor(0.5f, 0.5f);
//读取地图中心

			} catch (Exception e) {
				Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
			}
		}

		@Override
		public void setVisible(boolean b) {
			super.setVisible(b);
		}


	}
public void Xianshifanglige()
{

	new Thread(new Runnable() {
		@Override
		public void run() {
			Quedingdianwei();
			Huafanglige();
		}
	}).start();
	if(mMapView.getZoomLevel()<12)
	Lineoverlay.setVisible(false);
	mMapView.addOverlay(Lineoverlay);
	//Huabiaozhu();
}

/*	class Xianshifanglige extends AsyncTask<Void,Integer,Boolean>{

		//public  void Xianshifanglige(){};

		@Override
		protected boolean doInBackground(){
			public  void Xianshifanglige()
			{


			};

		}

	}*/

	public void Huafanglige(){
		int Tempdianheng, Tempdianshu,Jioushu=0;
		ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
		//画出所有竖线
		for (Tempdianheng = 1; Tempdianheng < 17; Tempdianheng++) {
			Jioushu=Tempdianheng%2;
			for (Tempdianshu = 1; Tempdianshu < 17; Tempdianshu++) {
				if(Jioushu==1)	points.add(mGeoPointdingweizhijiao[Tempdianheng][Tempdianshu]);
				if(Jioushu==0)	points.add(mGeoPointdingweizhijiao[Tempdianheng][17-Tempdianshu]);
			}
/*			points.add(mGeoPointdingweizhijiao[Tempdianheng][1]);
			points.add(mGeoPointdingweizhijiao[Tempdianheng][16]);
			points.add(mGeoPointdingweizhijiao[Tempdianheng][1]);*/
		}
		//画出所有竖线和拐弯
		for (Tempdianshu = 1; Tempdianshu < 17; Tempdianshu++)  {
			Jioushu=Tempdianshu%2;
			for (Tempdianheng = 1; Tempdianheng < 17; Tempdianheng++)	{
				if(Jioushu==1) {points.add(mGeoPointdingweizhijiao[Tempdianheng][Tempdianshu]);
				}if(Jioushu==0)	points.add(mGeoPointdingweizhijiao[17-Tempdianheng][Tempdianshu]);
				}
/*			points.add(mGeoPointdingweizhijiao[1][Tempdianshu]);
			points.add(mGeoPointdingweizhijiao[16][Tempdianshu]);
			points.add(mGeoPointdingweizhijiao[1][Tempdianshu]);*/
		}
		LineOption Lineoption = new LineOption();
		Lineoption.setStrokeWidth(4);

		Lineoption.setDottedLine(false);
		Lineoption.setStrokeColor(0xAA000000);

		Lineoverlay.setOption(Lineoption);
		Lineoverlay.setPoints(points);



	}
//画坐标标注
	public void Huabiaozhu(){
		int Tempdianheng, Tempdianshu,Jioushu=0;
		FontOption Zitioption = new FontOption();

		Zitioption.setAlign(FontOption.ALIGN_CENTER_HORIZONTAL,
				FontOption.ALIGN_CENTER_VERTICAL);
	//	Zitioption.setFillColor(0xFFFFFF00);
		Zitioption.setFontColor(0xFFFFF000);
		Zitioption.setFontSize((int) (18 * getResources().getDisplayMetrics().density));
		Zitioption.setStrokeWidth((int) (3 * getResources().getDisplayMetrics().density));
		Zitioption.setStrokeColor(0xFFFFFFFF);
		Testtextoverlays.setOption(Zitioption);
		Testtextoverlays.setGeoPoint(mGeoPointdingweizhijiao[1][1]);
		Testtextoverlays.setText("adasa");
		mMapView.addOverlay(Testtextoverlays);
		Testtextoverlays.setVisible(true);
/*		//画出所有竖线
		for (Tempdianheng = 1; Tempdianheng < 17; Tempdianheng++) {
			*//*Jioushu=Tempdianheng%2;
			for (Tempdianshu = 1; Tempdianshu < 17; Tempdianshu++) {
				if(Jioushu==1)	points.add(mGeoPointdingweizhijiao[Tempdianheng][Tempdianshu]);
				if(Jioushu==0)	points.add(mGeoPointdingweizhijiao[Tempdianheng][17-Tempdianshu]);
			}*//*
			Hengtextoverlays[Tempdianheng].setOption(Zitioption);
			Hengtextoverlays[Tempdianheng].setGeoPoint(mGeoPointdingweizhijiao[Tempdianheng][8]);
			Hengtextoverlays[Tempdianheng].setText("" + Yweizhijiao[Tempdianheng][8]/1000);
		//	mMapView.addOverlay(Hengtextoverlays[Tempdianheng]);
*//*			overlays[i] = new TextOverlay();
			overlays[i].setOption(option[i]);
			overlays[i].setGeoPoint(geoPoint);
			overlays[i].setText("文本TextOverlay" + (i + 1));
			mMapView.addOverlay(overlays[i]);*//*
*//*			points.add(mGeoPointdingweizhijiao[Tempdianheng][1]);
			points.add(mGeoPointdingweizhijiao[Tempdianheng][16]);
			points.add(mGeoPointdingweizhijiao[Tempdianheng][1]);*//*
		}
		//画出所有竖线和拐弯
		for (Tempdianshu = 1; Tempdianshu < 17; Tempdianshu++)  {
			Zongtextoverlays[Tempdianshu].setOption(Zitioption);
			Zongtextoverlays[Tempdianshu].setGeoPoint(mGeoPointdingweizhijiao[8][Tempdianshu]);
		//	Zongtextoverlays[Tempdianshu].setText("" + Yweizhijiao[8][Tempdianshu]/1000);
			Zongtextoverlays[Tempdianshu].setText("hello" );
		//	mMapView.addOverlay(Hengtextoverlays[Tempdianshu]);
		}

	*/
	}
	public void Quedingdianwei() {
		int Tempdianheng, Tempdianshu;
		double dLat,dLon;
		mGeoPointzhongxin = mMapView.getMapCenter();
		//mGeoPointzhongxin=new GeoPoint(36000000,114000000);
		for (Tempdianheng = 1; Tempdianheng < 17; Tempdianheng++) {
			for (Tempdianshu = 1; Tempdianshu < 17; Tempdianshu++) {
/*				   public GeoPoint  mGeoPointdituzhongxin;//地图中心画方里格用
				   public int Xweizhijiao[][], Yweizhijiao[][];//XY直角坐标方里格用
				   public GeoPoint mGeoPointdingweizhijiao[][];//*/
                gggSuanzuobiao.Jingweizhuanzuobiao(((double) mGeoPointzhongxin.getLongitudeE6()) / 1000000,
                        ((double) mGeoPointzhongxin.getLatitudeE6()) / 1000000, ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

				Xweizhijiao[Tempdianheng][Tempdianshu] = ((long) (XiuZhengX +gggSuanzuobiao.ShuchuX)) / 1000 * 1000 - 9000 + 1000 * Tempdianshu;
				Yweizhijiao[Tempdianheng][Tempdianshu] = ((long) (XiuZhengY + gggSuanzuobiao.ShuchuY)) / 1000 * 1000 - 9000 + 1000 * Tempdianheng;
				gggSuanzuobiao.Zuobiaozhuanjingweiduweidu
						(ZuoBiaoXi,  (Xweizhijiao[Tempdianheng][Tempdianshu] - XiuZhengX), (Yweizhijiao[Tempdianheng][Tempdianshu] - XiuZhengY),
								Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);



				dLat = gggSuanzuobiao.Zhuanhuanweidu;
				dLon = gggSuanzuobiao.Zhuanhuanjingdu;
				mGeoPointdingweizhijiao[Tempdianheng][Tempdianshu]= new GeoPoint((int) (dLat * 1E6), (int) (dLon * 1E6));

			}


		}
	}


//自定义画图图层，让图标跟着手指跑



	public class MarkerOverlaytry extends Overlay {
		public Drawable mDrawable;
		public GeoPoint mGeoPoint;
		public DrawableOption mOption;
/*		mEditLon = (EditText) view.findViewById(com.example.artilleryandroid.R.id.editTextLon);
		mEditLat = (EditText) view.findViewById(com.example.artilleryandroid.R.id.editTextLat);
		mEditzuobiaoX= (EditText) view.findViewById(R.id.editTextdingdianX);
		mEditzuobiaoY= (EditText) view.findViewById(R.id.editTextdingdianY);*/


		public MarkerOverlaytry() {
			mDrawable = MyLocationDemo.this.getResources().getDrawable(R.drawable.redaimer);
			mOption = new DrawableOption();
			mOption.setAnchor(0.5f, 0.5f);
		}
		//显示修正量及坐标经纬数据
		public void Refreshdata() {

			resn=getResources();

			((TextView) findViewById(R.id.TextViewzuobiaoleixing)).setText(resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
                    + "修正量X：" + (String.format("% .2f", XiuZhengX))
                    + "Y：" + (String.format("% .2f", XiuZhengY))
                    + "H：" + (String.format("% .2f", XiuZhengH))
                    +"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
                    +"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
                    +"强行指定中央经线："+Shoudongjingxian);
			((EditText) findViewById(com.example.artilleryandroid.R.id.editTextLon))
					.setText(String.format("% .7f",((double) mGeoPoint.getLongitudeE6())/1000000));
			((EditText) findViewById(com.example.artilleryandroid.R.id.editTextLat))
					.setText(String.format("% .7f",((double) mGeoPoint.getLatitudeE6())/1000000));
            gggSuanzuobiao.Jingweizhuanzuobiao(((double) mGeoPoint.getLongitudeE6())/1000000,((double) mGeoPoint.getLatitudeE6())/1000000,
                    ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

            ((EditText) findViewById(R.id.editTextdingdianX))
					.setText(String.format("% .2f",XiuZhengX+  gggSuanzuobiao.ShuchuX));
			((EditText) findViewById(R.id.editTextdingdianY))
					.setText(String.format("% .2f",XiuZhengY+  gggSuanzuobiao.ShuchuY));
		double TempX,TempY;
            gggSuanzuobiao.Jingweizhuanzuobiao(((double) mGeoPoint.getLongitudeE6())/1000000,((double) mGeoPoint.getLatitudeE6())/1000000,
                    ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);

			TempX=XiuZhengX+  gggSuanzuobiao.ShuchuX;
			DituqudianX=TempX;
			TempY=XiuZhengY+  gggSuanzuobiao.ShuchuY;
			DituqudianY=TempY;
			//		((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 7.1f", fData[28]));
			//Double.parseDouble((et13.getText().toString()));

		//	Miaozhundianfangweijiao=Float.parseFloat(((EditText)findViewById(R.id.editTextyushefangweijiao)).getText().toString());
			((EditText)findViewById(R.id.editTextyushefangweijiao)).setText(String.format("% 7.2f", ggg.NiyunsuanFAB(ZhanliX,ZhanliY,ZhanliH,TempX,TempY,0)));

		}
		public void setPosition(GeoPoint point) {
			mGeoPoint = point;
		}
		public void setGeoPoint(GeoPoint point) {
			mGeoPoint = point;
		}

		@Override
		public boolean onTap(GeoPoint point, MapView mapView) {
		try{
			Dianleixing=2;//设为点击目标点
			mGeoPoint = point;
/*			mEditTextLon.setText("" + point.getLongitudeE6());
			mEditTextLat.setText("" + point.getLatitudeE6());
			mCbShowView.setChecked(true);*/
			Refreshdata();
		//显示点击位置开始
				GeoPoint geoPoint = new GeoPoint( (point.getLatitudeE6()),  (point.getLongitudeE6()));
			searchGeoDecode(geoPoint);
			ggg.Zhuanqianweidu=((double) mGeoPoint.getLatitudeE6())/1000000;
			ggg.Zhuanqianjingdu=((double) mGeoPoint.getLongitudeE6())/1000000;
			ggg.Duzhuandufenmiao();
			((TextView) findViewById(com.example.artilleryandroid.R.id.textViewTipsdizhixinxi)).setText(Mubiaodizhijiesuanxinxi
			+				"\n"
							+ggg.Nanbei
							+String.format("% .1f", ggg.Zhuanhouweidu)+"度"
							+String.format("% .1f", ggg.Zhuanhouweifen)+"分"
							+String.format("% .3f", ggg.Zhuanhouweimiao)+"秒"
							+"\n"
							+ggg.Dongxi
							+String.format("% .1f", ggg.Zhuanhoujingdu)+"度"
							+String.format("% .1f", ggg.Zhuanhoujingfen)+"分"
							+String.format("% .3f", ggg.Zhuanhoujingmiao)+"秒"
			);
/*new Thread(new Runnable() {
	@Override
	public void run() {


	}
}).start();*///手画航迹路线

               if (((CheckBox)findViewById(R.id.checkHuahangji)).isChecked())
				if(geoPoint!=null)
				{ShouhuaHangjipoints.add(geoPoint);


					Luxianmoduanpoints.clear();
					Luxianmoduanpoints.add(ShouhuaHangjipoints.get(0));
					Luxianmoduanpoints.add(ShouhuaHangjipoints.get(ShouhuaHangjipoints.size()-1));
					Luxianmoduanoverlay.setPoints(Luxianmoduanpoints);
					ShouhuaHangjioverlay.setPoints(ShouhuaHangjipoints);

						Liangsuan();
				}
			//显示点击位置完毕
			//模拟定位航迹
              if(((CheckBox)findViewById(R.id.checkShouhuihangji)).isChecked())
			{
				if ((Shangyidianshouhui != null) && (geoPoint != null)) {
					Zidonghuahangji(Shangyidianshouhui, geoPoint);

				}
				Shangyidianshouhui = geoPoint;
			}
			else Shangyidianshouhui = null;//中断航迹
			//模拟航迹结束
			super.onTap(point, mapView);
				}catch(Exception e){
			Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
		}
			return true;
		}

		@Override
		public boolean onKeyUp(int keyCode, KeyEvent event, MapView mapView) {
	/*		mTvTips.setText("onKeyUp:" + keyCode);*/
			return super.onKeyUp(keyCode, event, mapView);
		}

		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event, MapView mapView) {
/*			mTvTips.setText("onKeyDown:" + keyCode);*/
			return super.onKeyDown(keyCode, event, mapView);
		}

		@Override
		public boolean onTouchEvent(MotionEvent event, MapView mapView) {
			switch (event.getActionMasked()) {
				case MotionEvent.ACTION_DOWN:
/*					mTvTips.setText("ACTION_DOWN" + event.getX() + ","
							+ event.getY());*/
/*					try{

						mGeoPoint = new GeoPoint((int) (mMapView.getMapCenter().getLatitudeE6()), (int) (mMapView.getMapCenter().getLongitudeE6()));

						Refreshdata();
					}catch(Exception e){
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}*/
					break;
				case MotionEvent.ACTION_MOVE:
/*					mTvTips.setText("ACTION_MOVE" + event.getX() + ","
							+ event.getY());*/
			//	mMarker.setPosition(geoPoint);
				//	mMapView.getController().setCenter(geoPoint);
				//	GeoPoint point
					;
					break;
				case MotionEvent.ACTION_UP:
/*					mTvTips.setText("ACTION_UP" + event.getX() + "," + event.getY());*/

					break;

				default:
					break;
			}
			return super.onTouchEvent(event, mapView);
		}

		@Override
		public boolean onLongPress(GeoPoint p, MapView mapView) {
/*			mTvTips.setText("onLongPress:" + p.getLatitudeE6() + ","
					+ p.getLongitudeE6());*/
			return super.onLongPress(p, mapView);
		}

		@Override
		public boolean isVisible() {
			return super.isVisible();
		}

		@Override
		public void setVisible(boolean b) {
			super.setVisible(b);
		}

		@Override
		public void draw(GL10 gl, MapView mapView, boolean shadow) {
			if (shadow)
				return;

			MapViewRender render = mapView.getMapViewRender();
			render.drawDrawable(gl, mOption, mDrawable, mGeoPoint);
		}
	}





	/**
	 * Tab4
	 * 自定义
	 */
	class Tab4 {

		CheckBox mCheckshishicunhangji;
		TextView mTextTips;

		public Tab4(Activity activity, View view) {
			//mCheckshishicunhangji = (CheckBox) view.findViewById(R.id.checkShishicunhuangji);
			//显示路线？

			//如果自动，那么显示
			((CheckBox) view.findViewById(R.id.checkzidongjiluhangji)).setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Xianshifangxiang = isChecked;
					if(isChecked)
						((CheckBox) findViewById(R.id.checkXianshihangji)).setChecked(true);
					/*if(!isChecked)
						((CheckBox) findViewById(R.id.checkHuahangji)).setChecked(isChecked);*/
/*					if(isChecked)
						Goujianshouhuahangji();
					else
						mMapView.removeOverlay(ShouhuaHangjioverlay);*/
				}
			});
			//如果手画，那么显示
			((CheckBox) view.findViewById(R.id.checkShouhuihangji)).setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Xianshifangxiang = isChecked;
					if(isChecked)
					((CheckBox) findViewById(R.id.checkXianshihangji)).setChecked(true);
					/*if(!isChecked)
						((CheckBox) findViewById(R.id.checkHuahangji)).setChecked(isChecked);*/
/*					if(isChecked)
						Goujianshouhuahangji();
					else
						mMapView.removeOverlay(ShouhuaHangjioverlay);*/
				}
			});
			//显示航迹？
			((CheckBox) view.findViewById(R.id.checkXianshihangji)).setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Xianshifangxiang = isChecked;
			try{
				final boolean Xianshi=isChecked;
				new Thread(new Runnable() {

					@Override
					public void run() {
						int Tempuuu,Overlayhangjinum=Hangjioverlayqun.size();

						for(Tempuuu=0;Tempuuu<Overlayhangjinum;Tempuuu++)
						{
							Hangjioverlayqun.get(Tempuuu).setVisible(Xianshi);
						}
					}
				}).start();

				}
				catch(Exception e){
					Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
				}
					/*if(!isChecked)
						((CheckBox) findViewById(R.id.checkHuahangji)).setChecked(isChecked);*/
/*					if(isChecked)
						Goujianshouhuahangji();
					else
						mMapView.removeOverlay(ShouhuaHangjioverlay);*/
				}
			});

			//定时存储？
			((CheckBox) view.findViewById(R.id.checkShishicunhuangji)).setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
					//Xianshifangxiang = isChecked;

					try{
						if(isChecked)
						{	((Chronometer)findViewById(R.id.chronometercunchuhangji)).setBase(SystemClock.elapsedRealtime());
						((Chronometer)findViewById(R.id.chronometercunchuhangji)).start();}
			else ((Chronometer)findViewById(R.id.chronometercunchuhangji)).stop();
						((Chronometer)findViewById(R.id.chronometercunchuhangji)).setBase(SystemClock.elapsedRealtime());

					}
					catch(Exception e){
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}
					/*if(!isChecked)
						((CheckBox) findViewById(R.id.checkHuahangji)).setChecked(isChecked);*/
/*					if(isChecked)
						Goujianshouhuahangji();
					else
						mMapView.removeOverlay(ShouhuaHangjioverlay);*/
				}
			});

//闹表定时存储
			((Chronometer)findViewById(R.id.chronometercunchuhangji)).setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
				@Override
				public void onChronometerTick(Chronometer chronometer) {
			if(((CheckBox)findViewById(R.id.checkShishicunhuangji)).isChecked())
					if(	((Chronometer)findViewById(R.id.chronometercunchuhangji))
							.getText().toString().split(":")[1].contains("00")) {

					/*((Chronometer)findViewById(R.id.chronometercunchuhangji)).stop();
					((Chronometer)findViewById(R.id.chronometercunchuhangji)).setBase(SystemClock.elapsedRealtime());
					((Chronometer)findViewById(R.id.chronometercunchuhangji)).start();*/
					Cunchuhangji();
				}
				}
			});

			//存储航迹
			( (Button)view.findViewById(R.id.buttonCunchuhangji)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						Cunchuhangji();

					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});

			//读取航迹
			( (Button)view.findViewById(R.id.buttonDuquhangji)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {            //归北
						Duquhangji();
						//mMapView.setfoc
					} catch (Exception e) {
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}

				}
			});
			//清除航迹
			( (Button)view.findViewById(R.id.buttonQingchuhangji)).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					new AlertDialog.Builder(MyLocationDemo.this)
							.setTitle("确认")

							.setMessage("确定清除当前航迹吗?")
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface arg0, int arg1) {



									try{	int Tempuuu,Overlayhangjinum=Hangjioverlayqun.size();
										try{		for(Tempuuu=0;Tempuuu<Overlayhangjinum;Tempuuu++)
										{
											//	Hangjioverlayqun.get(Tempuuu).setVisible(Xianshi);

										//	bw.append(""+Hangjioverlayqun.get(Tempuuu).getPoints().get(0).getLatitudeE6()+"\n");
										mMapView.removeOverlay(Hangjioverlayqun.get(0));
											Hangjioverlayqun.remove(0);

											//  Toast.makeText(this, ""+mPoint.latitude, Toast.LENGTH_LONG).show();
											//	bw.append(""+Hangjioverlayqun.get(Tempdi).getLongitudeE6()+"\n");

										}

										}
										catch(Exception e){
											Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
										}

									}
									catch(Exception e){
										Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
									}





								}
							})
							.setNegativeButton("取消", null)
							.show();

				}
			});
	/*

*/




			mTextTips = (TextView) view.findViewById(com.example.artilleryandroid.R.id.textViewTips);
		}

		//读取航迹
		public void Duquhangji()
		{
			try{
				int TempIII;
				String TempWD,TempJD,TempWD2,TempJD2;
			/*	ArrayList<GeoPoint> Hangjihuaxianpoints = new ArrayList<GeoPoint>();
				Hangjihuaxianpoints.clear();*/
			//	Hangjihuaxianpoints.add(point1);
			//	Hangjihuaxianpoints.add(point2);

				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))

				{
					folderName=Environment.getExternalStorageDirectory().getPath()+"/Hangji".toString();
					folder=new File(folderName);
					if(folder==null||!folder.exists())//如果文件夹不存在
					{
						Toast.makeText(MyLocationDemo.this, folderName+"文件夹不存在", Toast.LENGTH_LONG).show();
						return;
					}

					saveFile=new File(folderName,((Spinner)findViewById(R.id.spinnerhangjibianhao))
							.getItemAtPosition(((Spinner)findViewById(R.id.spinnerhangjibianhao)).getSelectedItemPosition())+".txt".toString());
					if(!saveFile.exists())//如果文件不存在
					{
						Toast.makeText(MyLocationDemo.this, folderName+"/"+((Spinner)findViewById(R.id.spinnerhangjibianhao))
								.getItemAtPosition(((Spinner)findViewById(R.id.spinnerhangjibianhao))
										.getSelectedItemPosition()).toString()+"航迹不存在", Toast.LENGTH_LONG).show();
						return;
					}
					InputStream	in=new FileInputStream(saveFile);
					BufferedReader	br=new BufferedReader(new InputStreamReader(in,"UTF-8"));


			//		ShouhuaHangjipoints.clear();
					while(((TempWD=br.readLine())!=null)&&((TempJD=br.readLine())!=null)&&((TempWD2=br.readLine())!=null)&&((TempJD2=br.readLine())!=null))

					{
					/*	Hangjihuaxianpoints = new ArrayList<GeoPoint>();
						Hangjihuaxianpoints.clear();*/
					//	Hangjihuaxianpoints.add(new GeoPoint(Integer.parseInt(TempWD),Integer.parseInt(TempJD)));

					//	Hangjihuaxianpoints.add(new GeoPoint(Integer.parseInt(TempWD2),Integer.parseInt(TempJD2)));
						Zidonghuahangji(new GeoPoint(Integer.parseInt(TempWD),Integer.parseInt(TempJD))
								,new GeoPoint(Integer.parseInt(TempWD2),Integer.parseInt(TempJD2)));
					}

					br.close();
					in.close();
					((CheckBox) findViewById(R.id.checkXianshihangji)).setChecked(true);
					Toast.makeText(MyLocationDemo.this, "航迹读取完毕", Toast.LENGTH_LONG).show();

				}}
			catch(Exception e){
				//Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			}

		}
		//存储航迹
		public void Cunchuhangji()
		{
			try{

		//		OutputStream out =null;
		//		InputStream in =null;
		//		BufferedWriter bw=null;
		//		BufferedReader br=null;

				int Tempdi;
				//mMapView.
				//	SharedPreferences spf=getSharedPreferences("Hangji"+SP1.getItemAtPosition(SP1.getSelectedItemPosition()).toString(),Context.MODE_WORLD_WRITEABLE);
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))

				{
					folderName=Environment.getExternalStorageDirectory().getPath()+"/Hangji".toString();
					folder=new File(folderName);
					if(folder==null||!folder.exists())//如果文件夹不存在
					{
						folder.mkdir();
					}

					saveFile=new File(folderName,((Spinner)findViewById(R.id.spinnerhangjibianhao))
							.getItemAtPosition(((Spinner)findViewById(R.id.spinnerhangjibianhao))
									.getSelectedItemPosition()).toString()+".txt");
					if(!saveFile.exists())//如果文件不存在
					{
						saveFile.createNewFile();
					}


					OutputStream	out=new FileOutputStream(saveFile);
					BufferedWriter	 bw=new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));



	/*				new Thread(new Runnable() {

						@Override
						public void run() {

                       //    int Tempshu;


					}
					}).start();*/
					int Tempuuu,Overlayhangjinum=Hangjioverlayqun.size();
					try{		for(Tempuuu=0;Tempuuu<Overlayhangjinum;Tempuuu++)
					{
						//	Hangjioverlayqun.get(Tempuuu).setVisible(Xianshi);

						bw.append(""+Hangjioverlayqun.get(Tempuuu).getPoints().get(0).getLatitudeE6()+"\n");
						bw.append(""+Hangjioverlayqun.get(Tempuuu).getPoints().get(0).getLongitudeE6()+"\n");
						bw.append(""+Hangjioverlayqun.get(Tempuuu).getPoints().get(1).getLatitudeE6()+"\n");
						bw.append(""+Hangjioverlayqun.get(Tempuuu).getPoints().get(1).getLongitudeE6()+"\n");
						//  Toast.makeText(this, ""+mPoint.latitude, Toast.LENGTH_LONG).show();
						//	bw.append(""+Hangjioverlayqun.get(Tempdi).getLongitudeE6()+"\n");

					}

					}
					catch(Exception e){
						Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
					}



					//  Toast.makeText(this, ""+mPoint.longitude, Toast.LENGTH_LONG).show();
					bw.close();
					out.close();
					Toast.makeText(MyLocationDemo.this,"航迹存储完毕", Toast.LENGTH_LONG).show();
				}



			}
			catch(Exception e){
				Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
			}

		}




	}
//Tab5
class Tab5 {
	//Button mBtnLocation;


	public Tab5(Activity activity, View view) {


		mConnectionState=(TextView)findViewById (R.id.textViewCejujilianjiezhuangtai);




		//地址查找位置结束

		((Button) findViewById(R.id.buttonlaserlianjie)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try{

					read();

					final int charaProp = characteristic.getProperties();

					//如果该char可写
					if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
						// If there is an active notification on a characteristic, clear
						// it first so it doesn't update the data field on the user interface.
						if (mNotifyCharacteristic != null) {
							mBluetoothLeService.setCharacteristicNotification( mNotifyCharacteristic, false);
							mNotifyCharacteristic = null;
						}
						//读取数据，数据将在回调函数中
						//mBluetoothLeService.readCharacteristic(characteristic);
						byte[] value = new byte[20];
						value[0] = (byte) 0x00;
						//AE A7 04 00 06 0A BC B7

                    /*
                    if(edittext_input_value.getText().toString().equals("")){
                    	Toast.makeText(getApplicationContext(), "请输入！", Toast.LENGTH_SHORT).show();
                    	return;
                    }else
                    */

						{
                   /* 	WriteBytes = edittext_input_value.getText().toString().getBytes();


                    	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
                        characteristic.setValue(WriteBytes);
                        mBluetoothLeService.writeCharacteristic(characteristic);
                    */
							// WriteBytes = edittext_input_value.getText().toString().getBytes();

							WriteBytes[0]=(byte) 0xAE;
							WriteBytes[1]=(byte) 0xA7;
							WriteBytes[2]=(byte) 0x04;
							WriteBytes[3]=(byte) 0x00;
							WriteBytes[4]=(byte) 0x06;
							WriteBytes[5]=(byte) 0x0a;
							WriteBytes[6]=(byte) 0xbc;
							WriteBytes[7]=(byte) 0xb7;

							//	characteristic.setValue(value[0],BluetoothGattCharacteristic.FORMAT_UINT8, 0);
							characteristic.setValue(WriteBytes);

							mBluetoothLeService.writeCharacteristic(characteristic);
							final StringBuilder stringBuilder = new StringBuilder(10);
							//    for(byte byteChar : data)
							//以十六进制的形式输出
							stringBuilder.append(String.format("%02X ", WriteBytes[0]));
							stringBuilder.append(String.format("%02X ", WriteBytes[1]));
							stringBuilder.append(String.format("%02X ", WriteBytes[2]));
							stringBuilder.append(String.format("%02X ", WriteBytes[3]));
							stringBuilder.append(String.format("%02X ", WriteBytes[4]));
							stringBuilder.append(String.format("%02X ", WriteBytes[5]));
							stringBuilder.append(String.format("%02X ", WriteBytes[6]));
							stringBuilder.append(String.format("%02X ", WriteBytes[7]));

							displaySent(""+stringBuilder.toString());
							//Toast.makeText(getApplicationContext(), "写入成功！", Toast.LENGTH_SHORT).show();
						}
					}
					if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
						mNotifyCharacteristic = characteristic;
						mBluetoothLeService.setCharacteristicNotification(characteristic, true);
					}
					//  edittext_input_value.setText("");
					new Thread(new Runnable() {
					@Override
					public void run() {
					while(!mJieshu)
						{
							Lianjieble();
						}
					}
				}).start();
				}
				catch(Exception e){

					Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
				}

			}
		});




		((Button) view.findViewById(R.id.buttonJiguang)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Intent intent=new Intent(MyLocationDemo.this,DeviceScanActivity.class);
					initchuangan();//启动陀螺仪及蓝牙相关内容
					//	Intent intent=new Intent(Menuofmian.this,DeviceControlActivity.class);

					startActivityForResult(intent,REQUESTlaserDEVICE);//归北

         //   finish();
				} catch (Exception e) {
					Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
				}

			}
		});


				((Button) view.findViewById(R.id.buttonTuoluoyi)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(MyLocationDemo.this)
						.setTitle("提示")

						.setMessage("重新确定方向传感器2吗?")
						.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								try{
									Chuanganleixing=2;

									SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

									//Intent intent=new Intent(DeviceControlActivity.this,Menuofmian.class);

									//  startActivity(intent);
									//ZuoBiaoXi=2;
									SharedPreferences.Editor edit=spf.edit();

									edit.putInt("Chuanganqileixing", Chuanganleixing);

									edit.commit();
									Intent serverIntent = new Intent(MyLocationDemo.this, DeviceListActivity.class);
									startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);

								}
								catch(Exception e){
									Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
								}
							}
						})
						.setNegativeButton("取消", null)
						.show();

			}
		});
//立即标定

		((Button) view.findViewById(R.id.buttonlijibiaoding)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					new AlertDialog.Builder(MyLocationDemo.this)
							.setTitle("提示")

							.setMessage("确定立即方向坐标方位角按瞄准点标定?")
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface arg0, int arg1) {



									float Miaozhundianfangweijiao=0;

									//		((TextView)findViewById(R.id.tvNum2)).setText(String.format("% 7.1f", fData[28]));
									//Double.parseDouble((et13.getText().toString()));

									Miaozhundianfangweijiao=Float.parseFloat(((EditText)findViewById(R.id.editTextyushefangweijiao)).getText().toString());
									Fangxiangxiuzheng=Fangxiangxiuzheng-(float)Fangxiang+Miaozhundianfangweijiao;
									SharedPreferences spf=getSharedPreferences("Chuangan",Context.MODE_WORLD_WRITEABLE);

									//Intent intent=new Intent(DeviceControlActivity.this,Menuofmian.class);

									//  startActivity(intent);
									//ZuoBiaoXi=2;
									SharedPreferences.Editor edit=spf.edit();

									edit.putFloat("Fangxiangxiuzheng",((float) (Fangxiangxiuzheng)));

									edit.commit();

								}
							})
							.setNegativeButton("取消", null)
							.show();



					//   finish();
				} catch (Exception e) {
					Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
				}

			}
		});

//瞄准标定

		((Button) view.findViewById(R.id.buttoncejubiaoding)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					new AlertDialog.Builder(MyLocationDemo.this)
							.setTitle("提示")

							.setMessage("确定下次测距时按瞄准点标定?")
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									Cejubiaodingfangxiang = true;


								}
							})
							.setNegativeButton("取消", null)
							.show();



					//   finish();
				} catch (Exception e) {
					Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
				}

			}
		});


	}

}
///



	//定位模块图层
	class MyOverlay extends MyLocationOverlay {
		public MyOverlay(Context context, MapView mapView) {
			super(context, mapView);
		}

		/*
		 * 处理在"我的位置"上的点击事件
		 */
		protected boolean dispatchTap() {
			return true;
		}

		@Override
		//		(String.format("% .2f", XiuZhengX));
	//	((EditText)findViewById(R.id.editTextXiuZhengY)).setText(String.format("% .2f", XiuZhengY));
	//	((EditText)findViewById(R.id.editTextXiuZhengH)).setText(String.format("% .2f", XiuZhengH));
		public void onLocationChanged(Location location) {
			super.onLocationChanged(location);
			if(location!=null){
		try{
			resn=getResources();
            gggSuanzuobiao.Jingweizhuanzuobiao(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);
				ggg.Zhuanqianweidu=location.getLatitude();
			ggg.Zhuanqianjingdu=location.getLongitude();
			ggg.Duzhuandufenmiao();
            Zuobiaoshuju=((resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
                    + "修正量X：" + (String.format("% .2f", XiuZhengX))
                    + "Y：" + (String.format("% .2f", XiuZhengY))
                    + "H：" + (String.format("% .2f", XiuZhengH))
                    +"分度带宽："+ (String.format("% .0f", (float)Fendudaikuan)+"度 ")
                    +"中央经度："+ (String.format("% .7f", gggSuanzuobiao.Zhongyangjingdu))
                    +"强行指定中央经线："+Shoudongjingxian)+
							"\n纬度："+String.format("% .6f", location.getLatitude())
					+ggg.Nanbei
					+String.format("% .1f", ggg.Zhuanhouweidu)+"度"
					+String.format("% .1f", ggg.Zhuanhouweifen)+"分"
					+String.format("% .3f", ggg.Zhuanhouweimiao)+"秒"
							+"\n经度："+String.format("% .6f", location.getLongitude())
					+ggg.Dongxi
					+String.format("% .1f", ggg.Zhuanhoujingdu)+"度"
					+String.format("% .1f", ggg.Zhuanhoujingfen)+"分"
					+String.format("% .3f", ggg.Zhuanhoujingmiao)+"秒"
							+"\nX："+String.format("% .2f",XiuZhengX+ gggSuanzuobiao.ShuchuX)
							+"\nY："+String.format("% .2f", XiuZhengY+gggSuanzuobiao.ShuchuY)
							+"\nH："+String.format("% .2f", XiuZhengH+location.getAltitude()	)
					);
			Weiduzhanlidian=location.getLatitude();
			Jingduzhanlidian=location.getLongitude();
			ZhanliX=XiuZhengX+ gggSuanzuobiao.ShuchuX;
			ZhanliY=XiuZhengY+gggSuanzuobiao.ShuchuY;
			ZhanliH=XiuZhengH+location.getAltitude();
			Timexianshi.setTime(location.getTime());

			if(Xianshishijian)Zuobiaoshuju=Zuobiaoshuju
					+"\n定位时间："+Timexianshi.toLocaleString();
			if(Xianshijingdu)Zuobiaoshuju=Zuobiaoshuju
					+"\n定位精度："+String.format("% .2f",location.getAccuracy())+"定位方式"+location.getProvider()	;;
			if(Xianshifangxiang)Zuobiaoshuju=Zuobiaoshuju
					+"\n运动方向："+String.format("% .2f",location.getBearing())+"度即"+String.format("% .2f",location.getBearing()*6000/360)+"密位";;
			if(Xianshisudu)Zuobiaoshuju=Zuobiaoshuju
					+"\n运动速度："+String.format("% .2f",location.getSpeed())+"m/s即"+String.format("% .2f",location.getSpeed()*3.6)+"km/h";
			//地址信息开始
			GeoPoint geoPoint = new GeoPoint((int) (location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6));
			Dianleixing=1;//设为站立点
			searchGeoDecode(geoPoint);
			Zuobiaoshuju=Zuobiaoshuju+"\n"+Dizhijiesuanxinxi;;
			//地址信息
					((TextView)findViewById(com.example.artilleryandroid.R.id.textViewTips))
					.setText(Zuobiaoshuju);


			if(location.getProvider().contains("gps"))
			{//自动画航迹
				if (((CheckBox) findViewById(R.id.checkzidongjiluhangji)).isChecked()) {
					if ((Shangyidianzidong != null) && (geoPoint != null)) {
						Zidonghuahangji(Shangyidianzidong, geoPoint);

					}
					Shangyidianzidong = geoPoint;
				} else Shangyidianzidong = null;//中断航迹

			}

		}
		catch(Exception e){
			Toast.makeText(MyLocationDemo.this, e.toString(), Toast.LENGTH_LONG).show();
		}
		}

		}
	}
//根据位置读地名模块


	private void searchGeoDecode(GeoPoint geoPoint) {
		//点类型1为站立点，2为点击目标点
		mGeoPointdiming = geoPoint;
	//	mTextTips.setText("开始获取地址 point =  " + mGeoPoint.toString());
		//暂时不显示
/*		Dizhijiesuanxinxi="开始获取地址 point =  " + mGeoPointdiming.toString();*/
	//	mOverlay.setPosition(mGeoPoint);
	//	mMapView.getController().setMapBound(mGeoPoint, 11);

		// 开始搜索
		if (mGeoDecode == null)
			mGeoDecode = new TGeoDecode(this);
		mGeoDecode.search(geoPoint);
	}

	@Override
	public void onGeoDecodeResult(TGeoAddress addr, int errCode) {
		if (errCode != TErrorCode.OK) {
//	//暂时不显示
/*			Dizhijiesuanxinxi="最近一次解析地名：" +Shangcidizhizhengquexinxi+
					"\n"+("实时解析地名错误，位置" + mGeoPointdiming.toString() + ",错误代号 " + errCode);*/
			if(Dianleixing==2)
			{
				Mubiaodizhijiesuanxinxi =("实时解析地名发生错误,错误代号 " + errCode) ;

			}
			return;
		}
		if (addr == null) {
			//暂时不显示
/*			Dizhijiesuanxinxi="最近一次解析地名：" +Shangcidizhizhengquexinxi+
					"\n"+"实时获取地名失败，位置" + mGeoPointdiming.toString();*/
			if(Dianleixing==2)
			{
				Mubiaodizhijiesuanxinxi = "解析地址失败，可能附近没有好的参考位置" ;

			}
			return;
		}
	/*	mOverlay.setPosition(mGeoPoint);
		mMapView.getController().setMapBound(mGeoPoint, 11);*/

		// 提示
/*		String str="";
		str += "point =  " + mGeoPoint.toString() + "\n";
		str += "最近的poi名称:" + addr.getPoiName() + "\n";
		str += "最近poi的方位:" + addr.getPoiDirection() + "\n";
		str += "最近poi的距离:" + addr.getPoiDistance() + "\n";
		str += "城市名称:" + addr.getCity() + "\n";
		str += "全称:" + addr.getFullName() + "\n";
		str += "最近的地址:" + addr.getAddress() + "\n";
		str += "最近地址的方位:" + addr.getAddrDirection() + "\n";
		str += "最近地址的距离:" + addr.getAddrDistance() + "\n";
		str += "最近的道路名称:" + addr.getRoadName() + "\n";
		str += "最近道路的距离:" + addr.getRoadDistance();*/
/*		mTextTips.setText(str);*/
		//点类型1为站立点，2为点击目标点
		if(Dianleixing==1)
		{
			Dizhijiesuanxinxi = "详细地名:" + addr.getFullName();
			Shangcidizhizhengquexinxi = Dizhijiesuanxinxi;
		}
		if(Dianleixing==2)
		{
			Mubiaodizhijiesuanxinxi = "详细地名:" + addr.getFullName();

		}
	}
	/**
	 * 显示图层列表
	 */
	void showMapLayerList() {
		int mapType = mMapView.getMapType();
		String title = mLayerMnger.getMapName(mapType);
		final String[] allLayers = mLayerMnger.getLayers(mapType);
		final String[] showLayers = mLayerMnger.getLayersShow();
		final int size = allLayers.length;

		// 开关状态
		final boolean[] checkedItems = new boolean[size];
		List<String> list = Arrays.asList(showLayers);
		for (int i = 0; i < size; ++ i) {
			if (list.contains(allLayers[i]))
				checkedItems[i] = true;
			else
				checkedItems[i] = false;
		}

		DialogInterface.OnMultiChoiceClickListener choiceListener = new DialogInterface.OnMultiChoiceClickListener() {
			public void onClick(DialogInterface dialog, int whichButton,
								boolean isChecked) {
				// 设置开关状态
				checkedItems[whichButton] = isChecked;
			}
		};

		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// 设置可见图层
				List<String> list = Arrays.asList(showLayers);
				ArrayList<String> showList = new ArrayList<String>(list);
				for (int i = size - 1; i >= 0; --i) {
					String item = allLayers[i];
					if (checkedItems[i] && !showList.contains(item))
						showList.add(item);
					else if (!checkedItems[i] && showList.contains(item))
						showList.remove(item);
				}
				String[] showLayers = showList.toArray(new String[showList.size()]);
				mLayerMnger.setLayersShow(showLayers);
				updateTips();
			}
		};

		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		};

		// 创建对话框
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title);
		builder.setMultiChoiceItems(allLayers, checkedItems, choiceListener);
		builder.setPositiveButton("确定", okListener);
		builder.setNegativeButton("取消", cancelListener);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	/**
	 * 更新提示信息
	 */
	void updateTips() {
		String[] allLayers = mLayerMnger.getLayers(mMapView.getMapType());
		String tips = "包含图层：";
		for (String layer : allLayers)
			tips += layer + " ";

		String[] showLayers = mLayerMnger.getLayersShow();
		tips += "\n可见图层：";
		for (String layer : showLayers)
			tips += layer + " ";

		//mTextViewTips.setText(tips);


		Toast.makeText(this, tips, Toast.LENGTH_LONG).show();
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
						//	GpsLoc.this.finish();;
							((CheckBox) findViewById(R.id.checkShishicunhuangji)).setChecked(false);
							MyLocationDemo.this.finish();
						}
						catch(Exception e){
						//	Toast.makeText(GpsLoc.this, e.toString(), Toast.LENGTH_LONG).show();
						}





					}
				})
				.setNegativeButton("取消", null)
				.show();





	}

}
