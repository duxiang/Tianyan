package com.example.artilleryandroid.osmmap;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.bonuspack.overlays.Polyline;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.TileSystem;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;
import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.Gps;
import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.FunctionZuobiaojiesuan;
import  com.example.artilleryandroid.PositionUtil;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

import com.example.artilleryandroid.R;
import com.example.artilleryandroid.old.DataMonitor;

@SuppressWarnings("deprecation")
public class OSMActivity extends Activity {

	public MapView mapView;
	private MapController mapController;
	private ArrayList<GeoPoint> pointsUser = new ArrayList<GeoPoint>();
	private ArrayList<Marker> markers = new ArrayList<Marker>();
	private Polyline roadOverlay;
	private ImageButton locate,caculate,clear,compass_needle,map,zoom_in,zoom_out,search;
    PositionUtil   Utilg=new    PositionUtil();
	PositionUtil   Utilgp=new    PositionUtil();
	boolean Shifoupianyiditu=false;
   //初始化地图
	private void initMap() {
    mapView = (MapView) findViewById(com.example.artilleryandroid.R.id.osmmapview);
    //指南针
    CompassOverlay mCompassOverlay = new CompassOverlay(getBaseContext(), new InternalCompassOrientationProvider(getBaseContext()), mapView);
    mCompassOverlay.enableCompass();  
    mapView.getOverlays().add(mCompassOverlay);


    //google地图
    mapView.setTileSource(new GoogleChinaTileSource());
		Shifoupianyiditu=true;
    mapView.setBuiltInZoomControls(true);
  	mapView.setMultiTouchControls(true);

  	//旋转
//  	RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(getBaseContext(), mapView);
//  	mRotationGestureOverlay.setEnabled(true);
//	mapView.getOverlays().add(mRotationGestureOverlay);
  	mapView.setMultiTouchControls(true);
  
  	mapController = (MapController) mapView.getController();
    mapController.setZoom(16);

    }
    double XiuZhengX=0,XiuZhengY=0,XiuZhengH=0,ShoudongZhongyangjingxianjingdu=117
			,Weiduzhanlidian=0,Jingduzhanlidian=0
			,ZhanliX=0,ZhanliY=0,ZhanliH=0;
	int ZuoBiaoXi=3,Fendudaikuan=6;
	boolean Shoudongjingxian=false,Shi3du=false
			,Xianshishijian=true,Xianshijingdu=true,Xianshifangxiang=true,Xianshisudu=true;
    //初始化坐标系
	public void inicoor(){



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
	/*	if(Shoudongjingxian)
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
		//	Ditujingdupiancha=spf.getFloat("Ditujingdupiancha", 0);*/


	}
public void Xianshizuobiaoxinxi(Location location){
	Resources resn=getResources();
	FunctionZuobiaojiesuan gggSuanzuobiao=new FunctionZuobiaojiesuan();
	gggSuanzuobiao.Jingweizhuanzuobiao(location.getLongitude(),location.getLatitude(),  ZuoBiaoXi,Fendudaikuan,Shoudongjingxian,ShoudongZhongyangjingxianjingdu);
	Function ggg = new Function();
	ggg.Zhuanqianweidu=location.getLatitude();
	ggg.Zhuanqianjingdu=location.getLongitude();
	ggg.Duzhuandufenmiao();
	String Zuobiaoshuju=((resn.getStringArray(R.array.Zuobiaoximingcheng)[ZuoBiaoXi]
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
	Time Timexianshi=new Time(0);
	Timexianshi.setTime(location.getTime());

	if(Xianshishijian)Zuobiaoshuju=Zuobiaoshuju
			+"\n定位时间："+Timexianshi.toLocaleString();
	if(Xianshijingdu)Zuobiaoshuju=Zuobiaoshuju
			+"\n定位精度："+String.format("% .2f",location.getAccuracy())+"定位方式"+location.getProvider()	;;
	if(Xianshifangxiang)Zuobiaoshuju=Zuobiaoshuju
			+"\n运动方向："+String.format("% .2f",location.getBearing())+"度即"+String.format("% .2f",location.getBearing()*6000/360)+"密位";;
	if(Xianshisudu)Zuobiaoshuju=Zuobiaoshuju
			+"\n运动速度："+String.format("% .2f",location.getSpeed())+"m/s即"+String.format("% .2f",location.getSpeed()*3.6)+"km/h";
	((TextView)findViewById(R.id.textViewOSMxinxi))
			.setText(Zuobiaoshuju);
}

        @SuppressWarnings("deprecation")
   protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.osmmap);
        
        ImageButton locate=(ImageButton)findViewById(com.example.artilleryandroid.R.id.locate);
        ImageButton caculate=(ImageButton)findViewById(com.example.artilleryandroid.R.id.caculate);
        ImageButton compassneedle=(ImageButton)findViewById(com.example.artilleryandroid.R.id.compass_needle);
        ImageButton map=(ImageButton)findViewById(R.id.map);
        ImageButton zoomin=(ImageButton)findViewById(R.id.zoom_in);
        ImageButton zoomout=(ImageButton)findViewById(R.id.zoom_out);
        ImageButton search=(ImageButton)findViewById(R.id.search);
        ImageButton clear=(ImageButton)findViewById(R.id.clear);
        ImageButton corrections=(ImageButton)findViewById(R.id.corrections);
    //    Spinner Spinnermaptype=(Spinner) findViewById(R.id.spinnerosmmaotype);
        //自定义point响应图片
        Drawable marker=this.getResources().getDrawable(R.drawable.marker);
  	    initMap();
  	  //底图选择
		((Spinner)findViewById(R.id.spinnerosmmaotype)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
			{
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
										   int arg2, long arg3) {
					// TODO Auto-generated method stub
					switch (arg2){

						case 0:
							mapView.setTileSource(new GoogleChinaTileSource());
							Shifoupianyiditu=true;
							break;//卫星影像图
						case 1:
							mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
							Shifoupianyiditu=false;
							break;//二维矢量图
						case 2:
							mapView.setTileSource(TileSourceFactory.CYCLEMAP);
							Shifoupianyiditu=false;
							break;//等高线地形图
				/*		case 1:		mapView.setTileSource(TileSourceFactory.HILLS);	break;*/
					/*	case 2:			mapView.setTileSource(TileSourceFactory.TOPO);	break;*/
				/*		case 3:		mapView.setTileSource(TileSourceFactory.PUBLIC_TRANSPORT);break;*/
					//	case 4:		mapView.setTileSource(TileSourceFactory.BASE);break;
					/*	case 5:		mapView.setTileSource(TileSourceFactory.BASE_OVERLAY_NL);break;*/
				/*		case 6:		mapView.setTileSource(TileSourceFactory.CLOUDMADESMALLTILES);break;
						case 7:		mapView.setTileSource(TileSourceFactory.CLOUDMADESTANDARDTILES);break;*/

				/*		case 9:		mapView.setTileSource(TileSourceFactory.FIETS_OVERLAY_NL);break;*/
				/*		case 10:		mapView.setTileSource(TileSourceFactory.MAPNIK);break;
						case 11:		mapView.setTileSource(TileSourceFactory.MAPQUESTAERIAL);break;
						case 12:		mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);break;
						case 13:		mapView.setTileSource(TileSourceFactory.ROADS_OVERLAY_NL);;break;*/



					}














					toast(((Spinner)findViewById(R.id.spinnerosmmaotype)).getSelectedItem().toString());
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}

		});


  	    map.setOnClickListener(new OnClickListener() {
  			@Override
  			public void onClick(View v) {
  				toast("请选择地图种类");
				((Spinner)findViewById(R.id.spinnerosmmaotype)).performClick();
  			    //开源地图
/*
		    mapView.setTileSource(TileSourceFactory.MAPNIK);
  			    mapView.setTileSource(TileSourceFactory.CYCLEMAP);
  			    mapView.setTileSource(TileSourceFactory.PUBLIC_TRANSPORT);
  			    mapView.setTileSource(TileSourceFactory.TOPO);
  			    mapView.setTileSource(TileSourceFactory.HILLS);
  			    mapView.setTileSource(TileSourceFactory.MAPQUESTAERIAL);

                mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);

                mapView.setTileSource(TileSourceFactory.HILLS);
                mapView.setTileSource(TileSourceFactory.TOPO);
                mapView.setTileSource(TileSourceFactory.PUBLIC_TRANSPORT);
                mapView.setTileSource(TileSourceFactory.BASE);
                mapView.setTileSource(TileSourceFactory.BASE_OVERLAY_NL);
                mapView.setTileSource(TileSourceFactory.CLOUDMADESMALLTILES);
                mapView.setTileSource(TileSourceFactory.CLOUDMADESTANDARDTILES);
                mapView.setTileSource(TileSourceFactory.CYCLEMAP);
                mapView.setTileSource(TileSourceFactory.FIETS_OVERLAY_NL);
                mapView.setTileSource(TileSourceFactory.MAPNIK);
                mapView.setTileSource(TileSourceFactory.MAPQUESTAERIAL);
                mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
                mapView.setTileSource(TileSourceFactory.ROADS_OVERLAY_NL);
*/

  			}
  	    });

  	    
        //定位 	    
  		final MyLocationNewOverlay mylocationOverlay=new MyLocationNewOverlay(getApplicationContext(), mapView){
			@Override
			public void onLocationChanged(Location location, IMyLocationProvider source) {
                try{
					Xianshizuobiaoxinxi(location);
                            Location Jiaozhenghoulocation=new Location(location);
                            double Yuanshiweidu=Jiaozhenghoulocation.getLatitude();
                double Yuanshijingdu=Jiaozhenghoulocation.getLongitude();
                     double PianhouWeidu=Utilgp.gps84_To_Gcj02( Yuanshiweidu,Yuanshijingdu).getWgLat();

                    double PianhouJingdu=Utilgp.gps84_To_Gcj02( Yuanshiweidu,Yuanshijingdu).getWgLon();
					if(Shifoupianyiditu)
					{
						Jiaozhenghoulocation.setLatitude(PianhouWeidu);
						Jiaozhenghoulocation.setLongitude(PianhouJingdu);
					}
								super.onLocationChanged( Jiaozhenghoulocation, source);
            }catch(Exception e){

                Toast.makeText(OSMActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }



			}
		};
        mapView.getOverlays().add(mylocationOverlay);






        GeoPoint startPoint=new GeoPoint(38.058843,114.345360); //我的位置
        OverlayItem mylocationOverlayItem=new OverlayItem("提示", "P",startPoint);
        Drawable myLocationMarker=this.getResources().getDrawable(R.drawable.point);
        mylocationOverlayItem.setMarker(myLocationMarker);
        mapController.setCenter(startPoint);
  	    locate.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
				// TODO Auto-generated method stub
try{
			//严湜修改开始
			//	mylocationOverlay.enableFollowLocation();
				mylocationOverlay.enableMyLocation();
	mylocationOverlay.enableFollowLocation();




    }catch(Exception e){

			Toast.makeText(OSMActivity.this, e.toString(), Toast.LENGTH_LONG).show();
		}

						}});
        //自定义缩放控件，获取缩放级别mapview.getController().getZoomLever();获取最高级别.getMaxZoomLever()
        mapView.setBuiltInZoomControls(false);
        zoomin.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) {
			mapView.getController().zoomIn();	
			}
		});
        zoomout.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v) {
			mapView.getController().zoomOut();	
			}
		});
     
        //长按从屏幕得到地图经纬
		  Overlay touchOverlay = new Overlay(this){
	         public boolean onLongPress(final MotionEvent e, final MapView mapView) {
/*	         Projection projection = mapView.getProjection();
	         //从屏幕点击点获取坐标
	         GeoPoint tapLocation = (GeoPoint) projection.fromPixels((int)e.getX(), (int)e.getY());
	         pointsUser.add(tapLocation);
	         //点击点加标签 	         
	         Marker marker = new Marker(mapView);
	         marker.setPosition(tapLocation);
	         marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
		     double[] arrayOfDouble = new convert().WGS842BJ54(tapLocation.getLongitude(), tapLocation.getLatitude());		
		     int X = (int) arrayOfDouble[1];// X
			 int A = (int) arrayOfDouble[2];// 分度带
			 int Y = (int) arrayOfDouble[0];// Y			
	         marker.setTitle("X: " +X + "\nY: " + A+Y);
	         if (markers.size() != 2){
		        markers.add(marker);
		        mapView.getOverlays().add(marker);
	         }
             else{	        	
	            Marker tempMarker = markers.get(0);
	            mapView.getOverlays().removeAll(markers);
	            for(Marker m : markers)
	            	m.hideInfoWindow();
	            markers.clear();
	            markers.add(tempMarker);
	            markers.add(marker);
		        mapView.getOverlays().addAll(markers);
		        }
	            mapView.invalidate();*/
	            return true;
	        }       
	         protected void draw(Canvas arg0, MapView arg1, boolean arg2) {
	       }
		};
		

	    
	//清除
        clear.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
/*            	mapView.getOverlays().remove(roadOverlay);//清除直线
            	mapView.getOverlays().removeAll(markers); //清除标记          	
            	for(Marker m : markers) m.hideInfoWindow();
            	markers.clear();
            	pointsUser.clear();
            	mapView.invalidate();*/
            }           
        });       
		mapView.getOverlays().add(touchOverlay);

 }    
    //消息toast方法
    public void toast(String paramString) {
		Toast.makeText(getApplicationContext(), paramString, Toast.LENGTH_LONG).show();
	 }

	 //标签marker方法
	 public Marker addMarker(double lat, double lon) {
		    Marker m = new Marker(mapView);
		    m.setPosition(new GeoPoint(lat, lon));
		    m.setIcon(getResources().getDrawable(R.drawable.marker));
		    mapView.getOverlays().add(m);
		    mapView.invalidate();
		    return m;
		}

	   //画线	    
	   public void drawRoadPath(double lat1, double lon1, double lat2, double lon2) {
		 RoadManager roadManager = new OSRMRoadManager();
	     ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();
	     //waypoints.clear();
	     waypoints.add(new GeoPoint(lat1,lon1));
	     waypoints.add(new GeoPoint(lat2,lon2));
	     Road road = roadManager.getRoad(waypoints);
	     this.roadOverlay= RoadManager.buildRoadOverlay(road,this);
	     roadOverlay.setWidth(10);
	     roadOverlay.setColor(Color.RED);
	     mapView.getOverlays().remove(roadOverlay);
	     mapView.getOverlays().add(roadOverlay);
	     mapView.invalidate();
	     }
}
