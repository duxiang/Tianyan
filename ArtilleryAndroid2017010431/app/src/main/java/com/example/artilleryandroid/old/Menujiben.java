package com.example.artilleryandroid.old;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import com.example.artilleryandroid.R;
import com.example.artilleryandroid.jibenyunsuan.Buzhujixian1117;
import com.example.artilleryandroid.jibenyunsuan.Dandiangaocheng1116;
import com.example.artilleryandroid.jibenyunsuan.Daoxianfa1119;
import com.example.artilleryandroid.jibenyunsuan.Liangdianhoufang1118;
import com.example.artilleryandroid.jibenyunsuan.Niyunsuan1112;
import com.example.artilleryandroid.jibenyunsuan.Sanbian1113;
import com.example.artilleryandroid.jibenyunsuan.Sandianhoufang111a;
import com.example.artilleryandroid.jibenyunsuan.Shuangguan1115;
import com.example.artilleryandroid.jibenyunsuan.Zhengjiao1114;
import com.example.artilleryandroid.jibenyunsuan.Zhengyunsuan;


public class Menujiben extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menujibenyunsuan2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void Click3_1_1(View v){
    //	Intent intent=new Intent(Menujiben.this,Menuofmian.class);

	//    startActivity(intent);
		
    	finish();
    }
    //Click1-1-1b2
    public void Click1_1_1b2(View v){
    	Intent intent=new Intent(Menujiben.this,Zhengyunsuan.class);

	    startActivity(intent);
		
    	
    }
    public void Click1_1_1b3(View v){
    	Intent intent=new Intent(Menujiben.this,Niyunsuan1112.class);

	    startActivity(intent);
		
    	
    }
    
    public void Click1_1_1b4(View v){
    	Intent intent=new Intent(Menujiben.this,Sanbian1113.class);

	    startActivity(intent);
		
    	
    }
    
    public void Click1_1_1b5(View v){
    	Intent intent=new Intent(Menujiben.this,Zhengjiao1114.class);

	    startActivity(intent);
		
    	
    }
    
    public void Click1_1_1b6(View v){
    	Intent intent=new Intent(Menujiben.this,Shuangguan1115.class);

	    startActivity(intent);
		
    	
    }
    public void Click1_1_1b7(View v){
    	Intent intent=new Intent(Menujiben.this,Dandiangaocheng1116.class);

	    startActivity(intent);
		
    	
    }
    
    
    public void Click1_1_1b8(View v){
    	Intent intent=new Intent(Menujiben.this,Buzhujixian1117.class);

	    startActivity(intent);
		
    	
    }
    
    public void Click1_1_1b9(View v){
    	Intent intent=new Intent(Menujiben.this,Liangdianhoufang1118.class);

	    startActivity(intent);
		
    	
    }
    public void Click1_1_1b10(View v){
    	Intent intent=new Intent(Menujiben.this,Daoxianfa1119.class);

	    startActivity(intent);
		
    	
    }
      
    public void Click1_1_1b11(View v){
    	Intent intent=new Intent(Menujiben.this,Sandianhoufang111a.class);

	    startActivity(intent);
		
    	
    }
}
