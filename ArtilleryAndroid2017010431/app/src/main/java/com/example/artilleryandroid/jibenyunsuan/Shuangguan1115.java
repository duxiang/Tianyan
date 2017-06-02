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
public class Shuangguan1115 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shuangguan1115);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_4b1(View v){
    //	Intent intent=new Intent(Shuangguan1115.this,Menujiben.class);

	 //   startActivity(intent);
		
    	finish();
    }
    
    public void Click1_1_1_4b2(View v){
    
    	try{
    	double Jizhunshexiang,ZhuX,ZhuY,ZhuH,CeX,CeY,CeH,Zhuguanfenhua,Ceguanfenhua,Zhuguanfuyang,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,JiXianChang;
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
   
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
        Jizhunshexiang=Double.parseDouble((et1.getText().toString()));
        ZhuX=Double.parseDouble((et2.getText().toString()));
         ZhuY=Double.parseDouble((et3.getText().toString()));
         ZhuH=Double.parseDouble((et4.getText().toString()));
         CeX=Double.parseDouble((et5.getText().toString()));
          CeY=Double.parseDouble((et6.getText().toString()));
          CeH=0;
          Zhuguanfenhua=Double.parseDouble((et7.getText().toString()));
          Ceguanfenhua=Double.parseDouble((et8.getText().toString()));
          Zhuguanfuyang=Double.parseDouble((et9.getText().toString()));
         
           MubiaoX=ggg.ShuangGuanMuBiaoX(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           MubiaoY=ggg.ShuangGuanMuBiaoY(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           MubiaoH=ggg.ShuangGuanMuBiaoH(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           ZhuMuPingMianJuLi=ggg.ShuangGuanZhuMuPingMianJuLi(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           ZhuMuXieJuLi=ggg.ShuangGuanZhuMuXieJuLi(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           CeMuPingMianJuLi=ggg.ShuangGuanCeMuPingMianJuLi(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           JiXianChang=ggg.ShuangGuanJixianchang(Jizhunshexiang, ZhuX, ZhuY, ZhuH, CeX, CeY, CeH, Zhuguanfenhua, Ceguanfenhua, Zhuguanfuyang);
           
       
         
         
         

       et10.setText(""+MubiaoX);
       et11.setText(""+MubiaoY);
       et12.setText(""+MubiaoH);
       et13.setText(""+ZhuMuPingMianJuLi);
       et14.setText(""+ZhuMuXieJuLi);
       et15.setText(""+CeMuPingMianJuLi);
       et16.setText(""+JiXianChang);
       
       
        
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