package com.example.artilleryandroid.jibenyunsuan;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.R;


//import SSS.h;
public class Dandiangaocheng1116 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dandiangaocheng1116);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_4b1(View v){
    //	Intent intent=new Intent(Dandiangaocheng1116.this,Menujiben.class);

	 //   startActivity(intent);
    	finish();
    	
    }
    
    public void Click1_1_1_4b2(View v){
    
    	try{
    	double GuanChaDianGaoCheng,QiCaiGao,BiaoGanGao,XieJuLi,FuYang,MuBiaoGaoCheng;
    	et1=(EditText)findViewById(R.id.EditText101);
        et2=(EditText)findViewById(R.id.EditText102);
        et3=(EditText)findViewById(R.id.EditText103);
        et4=(EditText)findViewById(R.id.EditText104);
        et5=(EditText)findViewById(R.id.EditText105);
        et6=(EditText)findViewById(R.id.EditText106);
        GuanChaDianGaoCheng=Double.parseDouble((et1.getText().toString()));
        QiCaiGao=Double.parseDouble((et2.getText().toString()));
        BiaoGanGao=Double.parseDouble((et3.getText().toString()));
        XieJuLi=Double.parseDouble((et4.getText().toString()));
        FuYang=Double.parseDouble((et5.getText().toString()));
        
        
   MuBiaoGaoCheng=ggg.DanDianGaoCheng(GuanChaDianGaoCheng, QiCaiGao, BiaoGanGao, XieJuLi, FuYang);
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
       
   et6.setText(""+MuBiaoGaoCheng);
         
         

        
        // By=ZhengyunsuanBy(Ax, Ay, Ah, Lab, Fab, Eab);
       //  Bh=ZhengyunsuanBh(Ax, Ay, Ah, Lab, Fab, Eab);


         
         
         
         
        // et8.setText(""+By);
       //  et9.setText(""+Bh);
         
   
    	
    }
    catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
	
    }
    
    
    
}