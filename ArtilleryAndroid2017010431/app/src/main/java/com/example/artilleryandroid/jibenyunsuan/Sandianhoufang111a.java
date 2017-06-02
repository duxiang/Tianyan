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
public class Sandianhoufang111a extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sandianhoufang111a);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_4b1(View v){
    //	Intent intent=new Intent(Sandianhoufang111a.this,Menujiben.class);

	  //  startActivity(intent);
		finish();	
    	
    }
    
    public void Click1_1_1_4b2(View v){
    
    	try{
    	double AX ,AY,AH,
    	FenhuaOA,EOA,DOA,LOA,
    	BX,BY,FenhuaOB,JiajiaoAOB,FAB,DAB,JiajiaoAY1B,RY1,
    	CX,CY,FenhuaOC,JiajiaoBOC,FBC,DBC,JiajiaoBY2C,RY2,
    	OX,OY,OH,
    	Y1X,Y1Y,Y2X,Y2Y,FY1Y2,DY1Y2,YGX,YGY,FY1B,LBO,FBO;
    	
    	
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
         FenhuaOA=Double.parseDouble((et4.getText().toString()));
         EOA=Double.parseDouble((et5.getText().toString()));
          BX=Double.parseDouble((et6.getText().toString()));
          BY=Double.parseDouble((et7.getText().toString()));
          FenhuaOB=Double.parseDouble((et8.getText().toString()));
           CX=Double.parseDouble((et9.getText().toString()));
           CY=Double.parseDouble((et10.getText().toString()));
           FenhuaOC=Double.parseDouble((et11.getText().toString()));
         
           JiajiaoAOB=FenhuaOA-FenhuaOB;
           JiajiaoBOC=FenhuaOB-FenhuaOC;
          FAB=ggg.NiyunsuanFAB(AX, AY, 0, BX, BY, 0);
          JiajiaoAY1B=(3000-JiajiaoAOB)*2;
          DAB=ggg.NiyunsuanDAB(AX, AY, 0, BX, BY, 0);
          RY1=ggg.SanBianyunsuanLBC(1500, (1500-0.5*JiajiaoAY1B),(0.5*DAB));
          Y1X=ggg.ZhengyunsuanBx(AX, AY, 0, RY1, (FAB-(3000-JiajiaoAY1B)), 0);
          Y1Y=ggg.ZhengyunsuanBy(AX, AY, 0, RY1, (FAB-(3000-JiajiaoAY1B)), 0);
      
          FBC=ggg.NiyunsuanFAB(BX, BY, 0, CX, CY, 0);
          JiajiaoBY2C=(3000-JiajiaoBOC)*2;
          DBC=ggg.NiyunsuanDAB(BX, BY, 0, CX, CY, 0);
          RY2=ggg.SanBianyunsuanLBC(1500, (1500-0.5*JiajiaoBY2C),(0.5*DBC));
          Y2X=ggg.ZhengyunsuanBx(BX, BY, 0, RY2, (FBC-(3000-JiajiaoBY2C)), 0);
          Y2Y=ggg.ZhengyunsuanBy(BX, BY, 0, RY2, (FBC-(3000-JiajiaoBY2C)), 0);
          
      	Toast.makeText(this,"Y1X"+Y1X, Toast.LENGTH_LONG).show();
    	Toast.makeText(this, "Y1Y"+Y1Y, Toast.LENGTH_LONG).show();
    	Toast.makeText(this, "Y2X"+Y2X, Toast.LENGTH_LONG).show();
    	Toast.makeText(this, "+Y2Y"+Y2Y, Toast.LENGTH_LONG).show();
          
          FY1Y2=ggg.NiyunsuanFAB(Y1X, Y1Y, 0, Y2X, Y2Y, 0);
          FY1B=ggg.NiyunsuanFAB(Y1X, Y1Y,0, BX, BY, 0);
          FBO=FY1Y2+1500;
          LBO=ggg.SanBianyunsuanLBC((FY1Y2-FY1B),(FY1B+3000-FBO),RY1)*2;
          
          
    
          
          
          
          OX=ggg.ZhengyunsuanBx(BX, BY, 0, LBO, FBO, 0);
          OY=ggg.ZhengyunsuanBy(BX, BY, 0, LBO, FBO, 0);
          DOA=Math.sqrt((AX-OX)*(AX-OX)+(AY-OY)*(AY-OY));
        		  OH=AH-DOA*Math.tan(ggg.Mil2Hu(EOA));
         // MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
  
          et12.setText(""+OX);
       et13.setText(""+OY);
       et14.setText(""+OH);
      
       
       
        
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