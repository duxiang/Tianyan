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
public class Daoxianfa1119 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20,et21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daoxianfa1119);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_4b1(View v){
    	//Intent intent=new Intent(Daoxianfa1119.this,Menujiben.class);

	   // startActivity(intent);
		finish();
    	
    }
    
    public void Click1_1_1_4b2(View v){
    
    	try{
    	double AX,AY,AH,LAB,FAB,EAB,
    		   BX,BY,BH,LBC,FABC,EBC,
    		   CX,CY,CH,LCD,FBCD,ECD,
    		   DX,DY,DH
    	
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
        et15=(EditText)findViewById(R.id.EditText113);
        et16=(EditText)findViewById(R.id.EditText114);
        et17=(EditText)findViewById(R.id.EditText115);
        et18=(EditText)findViewById(R.id.editText18);
        et19=(EditText)findViewById(R.id.editText19);
        et20=(EditText)findViewById(R.id.editText20);
        et21=(EditText)findViewById(R.id.editText21);
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
       AX=Double.parseDouble((et1.getText().toString()));
        AY=Double.parseDouble((et2.getText().toString()));
         AH=Double.parseDouble((et3.getText().toString()));
         LAB=Double.parseDouble((et4.getText().toString()));
         FAB=Double.parseDouble((et5.getText().toString()));
         EAB=Double.parseDouble((et6.getText().toString()));
         
         BX=ggg.ZhengyunsuanBx(AX, AY, AH, LAB, FAB, EAB);
         BY=ggg.ZhengyunsuanBy(AX, AY, AH, LAB, FAB, EAB);
         BH=ggg.ZhengyunsuanBh(AX, AY, AH, LAB, FAB, EAB);
         et7.setText(""+BX);
         et8.setText(""+BY);
         et9.setText(""+BH);
         LBC=Double.parseDouble((et10.getText().toString()));
         FABC=Double.parseDouble((et11.getText().toString()));
         EBC=Double.parseDouble((et12.getText().toString()));
    
         CX=ggg.ZhengyunsuanBx(BX, BY, BH, LBC, (FAB+3000+FABC), EBC);
         CY=ggg.ZhengyunsuanBy(BX, BY, BH, LBC, (FAB+3000+FABC), EBC);
         CH=ggg.ZhengyunsuanBh(BX, BY, BH, LBC, (FAB+3000+FABC), EBC);
         et13.setText(""+BX);
         et14.setText(""+BY);
         et15.setText(""+BH); 
         LCD=Double.parseDouble((et16.getText().toString()));
         FBCD=Double.parseDouble((et17.getText().toString()));
         ECD=Double.parseDouble((et18.getText().toString()));
         DX=ggg.ZhengyunsuanBx(CX, CY, CH, LCD, (FAB+3000+FABC+3000+FBCD), ECD);
         DY=ggg.ZhengyunsuanBy(CX, CY, CH, LCD, (FAB+3000+FABC+3000+FBCD), ECD);
         DH=ggg.ZhengyunsuanBh(CX, CY, CH, LCD, (FAB+3000+FABC+3000+FBCD), ECD);
         et19.setText(""+BX);
         et20.setText(""+BY);
         et21.setText(""+BH);  
         
         
      
    	
    }
    catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
	
    }
    
    
    
}