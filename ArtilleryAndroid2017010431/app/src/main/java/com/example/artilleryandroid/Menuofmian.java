package com.example.artilleryandroid;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.net.Uri;
import com.baidu.appx.BDBannerAd;

import com.example.artilleryandroid.jibenyunsuan.Zhuyuanjisuan;
import com.example.artilleryandroid.old.Menujiben;
import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;


public class Menuofmian extends Activity {
    private BluetoothAdapter mBluetoothAdapter = null,mBluetoothAdapter1 = null,mBluetoothAdapter2 = null,mBluetoothAdapter3 = null;
    private static final int REQUEST_ENABLE_BT = 1924;
    ViewGroup bannerContainer;
    BannerView bv;
    public  static final String BaiduSDK_APP_KEY 		= "ionNYIgowpmXXmGlPfXlqZLXxCZzUHXj";
    private String BaiduSDK_BANNER_AD_ID = "B1Od0AzaRKT2MoUUGbWXgZa4";

   private BDBannerAd Baidubannerview=null;


    //百度广告


    public void showBanner() {
        if (null == Baidubannerview) {
Toast.makeText(this,"百度广告",Toast.LENGTH_LONG);
            Baidubannerview = new BDBannerAd(this, BaiduSDK_APP_KEY, BaiduSDK_BANNER_AD_ID);
            Baidubannerview.setAdSize(BDBannerAd.SIZE_FLEXIBLE);

         Baidubannerview.setAdListener(new BDBannerAd.BannerAdListener() {
             @Override
             public void onAdvertisementDataDidLoadSuccess() {

             }

             @Override
             public void onAdvertisementDataDidLoadFailure() {

             }

             @Override
             public void onAdvertisementViewDidShow() {

             }

             @Override
             public void onAdvertisementViewDidClick() {

             }

             @Override
             public void onAdvertisementViewWillStartNewIntent() {

             }
         });

                 //AdListener("Banner"));
            ViewGroup  container = (ViewGroup)findViewById(R.id.Baiduadview_container);
            container.addView(Baidubannerview);
        }
        else {

        }
    }

    public void hideBanner() {
        if (Baidubannerview != null) {
            ViewGroup  container = (ViewGroup)findViewById(R.id.Baiduadview_container);
            container.removeAllViews();
            Baidubannerview.destroy();
            Baidubannerview = null;

        }
        else {

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menumain2);

        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
    try{    mBluetoothAdapter = bluetoothManager.getAdapter();
        if (!mBluetoothAdapter.isEnabled()) mBluetoothAdapter.enable();

        bannerContainer = (ViewGroup) this.findViewById(R.id.bannerContainer);
        this.initBanner();
        this.bv.loadAD();
 /*       if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }*/

     showBanner();
    }
    catch(Exception e){

        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    }

    }

    @Override
    public void onStart() {
     try{   super.onStart();
        bannerContainer = (ViewGroup) this.findViewById(R.id.bannerContainer);
        this.initBanner();
         this.bv.setShowClose(false);
        this.bv.loadAD();

    showBanner();
    }
    catch(Exception e){

        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    }
    }

    @Override
    public void onPause() {
        try{   super.onPause();
            bannerContainer = (ViewGroup) this.findViewById(R.id.bannerContainer);
         //   this.initBanner();
            this.bv.setShowClose(true);
       hideBanner();
        }
        catch(Exception e){

        //    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }


    private void initBanner() {
        this.bv = new BannerView(this, ADSize.BANNER, Constants.APPID, Constants.BannerPosID);
        // 注意：如果开发者的banner不是始终展示在屏幕中的话，请关闭自动刷新，否则将导致曝光率过低。
        // 并且应该自行处理：当banner广告区域出现在屏幕后，再手动loadAD。
        bv.setRefresh(30);
        bv.setADListener(new AbstractBannerADListener() {

            @Override
            public void onNoAD(int arg0) {

            }

            @Override
            public void onADReceiv() {

            }
        });
        bannerContainer.addView(bv);
    }



    private void doRefreshBanner() {
        if (bv == null) {
            initBanner();
        }
        bv.loadAD();
    }

    private void doCloseBanner() {
        bannerContainer.removeAllViews();
        if (bv != null) {
            bv.destroy();
            bv = null;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//此处改动

        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (requestCode == REQUEST_ENABLE_BT && resultCode == Activity.RESULT_CANCELED) {
                    finish();
                    return;
                }
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    protected void onDestroy() {


        hideBanner();
        super.onDestroy();
    }


    //laser
    public void Clicklaser(View v){
    //	Intent intent=new Intent(Menuofmian.this,MainActivity.class);
//intent.setClass(Menuofmian.this,MainActivity.class);
	 //  startActivity(intent);
    /*	Intent intent=new Intent(Menuofmian.this,DeviceScanActivity.class);

    //	Intent intent=new Intent(Menuofmian.this,DeviceControlActivity.class);
    	
	    startActivity(intent);*/
		
    	
    	
    	//finish();
    	
    }




    public void Click2_2(View v){
    	Intent intent=new Intent(Menuofmian.this,Menujiben.class);
     
	    startActivity(intent);
		
    	
    }
    
    
    public void Click2_3(View v){
/*    	Intent intent=new Intent(Menuofmian.this,GpsLoc.class);

	    startActivity(intent);*/


    }
    
    public void Click2_4(View v){
    	Intent intent=new Intent(Menuofmian.this,Zhuyuanjisuan.class);

	    startActivity(intent);
		
    	
    }

    public void Click2_8(View v){
      Intent intent=new Intent(Menuofmian.this,com.example.artilleryandroid.sdkDemo.MyLocationDemo.class);
       // Intent intent=new Intent(Menuofmian.this,com.example.artilleryandroid.sdkDemo.MapViewDemo.class);
        startActivity(intent);


    }
    public void Clickosmmap(View v){
        Intent intent=new Intent(Menuofmian.this,com.example.artilleryandroid.osmmap.OSMActivity.class);

        startActivity(intent);


    }
    public void Clickzingto(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("http://www.zingto.net/"));

        startActivity(intent);


    }
    public void Clickliaowang(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("http://www.jiguangceju.com/"));

        startActivity(intent);


    }
    
    
}
