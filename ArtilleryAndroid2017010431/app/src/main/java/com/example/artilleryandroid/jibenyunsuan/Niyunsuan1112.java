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
public class Niyunsuan1112 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niyunsuan2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_2b1(View v){
    //	Intent intent=new Intent(Niyunsuan1112.this,Menujiben.class);

	 //   startActivity(intent);
    	finish();
    	
    }
    
    public void Click1_1_1_2b2(View v){
    
    	try{
    	double Ax,Ay,Ah,Lab,Fab,Eab,Dab,Bx,By,Bh;
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
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
         Ax=Double.parseDouble((et1.getText().toString()));
         Ay=Double.parseDouble((et2.getText().toString()));
         Ah=Double.parseDouble((et3.getText().toString()));
        Bx=Double.parseDouble((et4.getText().toString()));
        By=Double.parseDouble((et5.getText().toString()));
        Bh=Double.parseDouble((et6.getText().toString()));
        Fab=ggg.NiyunsuanFAB( Ax, Ay, Ah, Bx, By, Bh);
        Dab=ggg.NiyunsuanDAB( Ax, Ay, Ah, Bx, By, Bh);
        Lab=ggg.NiyunsuanLAB( Ax, Ay, Ah, Bx, By, Bh);
        Eab=ggg.NiyunsuanEAB( Ax, Ay, Ah, Bx, By, Bh);
        
        // By=ZhengyunsuanBy(Ax, Ay, Ah, Lab, Fab, Eab);
       //  Bh=ZhengyunsuanBh(Ax, Ay, Ah, Lab, Fab, Eab);
        et7.setText(String.format("% .3f",Fab));
        et8.setText(String.format("% .3f",Dab));
        et9.setText(String.format("% .3f",Lab));
        et10.setText(String.format("% .3f",Eab));
            ((EditText)findViewById(R.id.EditTextZuobiaofangweijiaoniyunsuan))
                    .setText(String.format("% .7f",(Fab*360/6000)));
            ((EditText)findViewById(R.id.EditTextFuyangjiaodushuniyunsuan))
                    .setText(String.format("% .7f",(Eab*360/6000)));
         
         
        // et8.setText(""+By);
       //  et9.setText(""+Bh);
         
   
    	
    }
    catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
	
    }
    
    
    
}