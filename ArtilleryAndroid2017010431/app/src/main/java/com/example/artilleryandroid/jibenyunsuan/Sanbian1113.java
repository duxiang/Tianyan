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
public class Sanbian1113 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanbian1113);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_3b1(View v){
    //	Intent intent=new Intent(Sanbian1113.this,Menujiben.class);

	 //   startActivity(intent);
		
    	finish();
    }
    
    public void Click1_1_1_3b2(View v){
    
    	try{
    	double JiaoA,JiaoB,LAB,JiaoC,LBC,LAC;
    	et1=(EditText)findViewById(R.id.EditText101);
        et2=(EditText)findViewById(R.id.EditText102);
        et3=(EditText)findViewById(R.id.EditText103);
        et4=(EditText)findViewById(R.id.EditText104);
        et5=(EditText)findViewById(R.id.EditText105);
        et6=(EditText)findViewById(R.id.EditText106);
   
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
        JiaoA=Double.parseDouble((et1.getText().toString()));
        JiaoB=Double.parseDouble((et2.getText().toString()));
         LAB=Double.parseDouble((et3.getText().toString()));
       JiaoC=ggg.SanBianyunsuanJiaoC(JiaoA, JiaoB, LAB);
       LBC=ggg.SanBianyunsuanLBC(JiaoA, JiaoB, LAB);
       LAC=ggg.SanBianyunsuanLAC(JiaoA, JiaoB, LAB);
       et4.setText(""+JiaoC);
       et5.setText(""+LBC);
       et6.setText(""+LAC);
       
       
        
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