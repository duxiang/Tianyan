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
public class Liangdianhoufang1118 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liangdianhoufang1118);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_4b1(View v){
    	//Intent intent=new Intent(Liangdianhoufang1118.this,Menujiben.class);

	  //  startActivity(intent);
		
		finish();	
    }
    
    public void Click1_1_1_4b2(View v){
    
    	try{
    	double 
    	AX,AY,AH,BX,BY,BH,FCA,FCB,ECA,CX,CY,CH,DAC,lAC
    	;
    	et1=(EditText)findViewById(R.id.EditText101);
        et2=(EditText)findViewById(R.id.EditText102);
        et3=(EditText)findViewById(R.id.EditText103);
        et4=(EditText)findViewById(R.id.EditText104);
        et5=(EditText)findViewById(R.id.EditText105);
        et6=(EditText)findViewById(R.id.EditText106);
        et7=(EditText)findViewById(R.id.EditText107);
        et8=(EditText)findViewById(R.id.EditText108);
        et9=(EditText)findViewById(R.id.EditText109);
        et10=(EditText)findViewById(R.id.EditText110);
        et11=(EditText)findViewById(R.id.EditText111);
        et12=(EditText)findViewById(R.id.editText12);
        et13=(EditText)findViewById(R.id.editText13);
        et14=(EditText)findViewById(R.id.EditText112);

   
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
       AX=Double.parseDouble((et1.getText().toString()));
      AY=Double.parseDouble((et2.getText().toString()));
         AH=Double.parseDouble((et3.getText().toString()));
         BX=Double.parseDouble((et4.getText().toString()));
         BY=Double.parseDouble((et5.getText().toString()));
          BH=Double.parseDouble((et6.getText().toString()));
     
       FCA=Double.parseDouble((et7.getText().toString()));
          FCB=Double.parseDouble((et8.getText().toString()));
          ECA=Double.parseDouble((et9.getText().toString()));
         
          CX=ggg.ShuangGuanMuBiaoX(0, AX, AY, AH, BX, BY, BH, (0-FCA), (0-FCB), (0-ECA));
          CY=ggg.ShuangGuanMuBiaoY(0, AX, AY, AH, BX, BY, BH, (0-FCA), (0-FCB), (0-ECA));    
          CH=ggg.ShuangGuanMuBiaoH(0, AX, AY, AH, BX, BY, BH, (0-FCA), (0-FCB), (0-ECA));    
          DAC=ggg.ShuangGuanZhuMuPingMianJuLi(0, AX, AY, AH, BX, BY, BH, (0-FCA), (0-FCB), (0-ECA));    
         lAC=ggg.ShuangGuanZhuMuXieJuLi(0, AX, AY, AH, BX, BY, BH, (0-FCA), (0-FCB), (0-ECA));    
         
       et10.setText(""+CX);
       et11.setText(""+CY);
       et12.setText(""+CH);
       et13.setText(""+DAC);
       et14.setText(""+lAC);
 
       
       
        
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