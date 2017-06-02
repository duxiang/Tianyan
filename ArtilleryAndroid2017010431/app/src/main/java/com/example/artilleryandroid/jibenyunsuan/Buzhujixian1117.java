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
public class Buzhujixian1117 extends Activity {
	
	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buzhujixian1117);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Click1_1_1_4b1(View v){
    //	Intent intent=new Intent(Buzhujixian1117.this,Menujiben.class);

	  //  startActivity(intent);
		finish();
    	
    }
    
    public void Click1_1_1_4b2(View v){
    
    	try{
    	double Jizhunshexiang,YizhidianX,YizhidianY,YizhidianH,Zhichanfenhua,Zhuyifenhua,Ceyifenhua,Zhuyifuyang,
    	Juanchichang,Zhubiaofenhua,Cebiaofenhua,Zhubiaofuyang,ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
    	Zhuyixiejuli,Zhuyipingmianjuli;;
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
        et01=(EditText)findViewById(R.id.EditText116);
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
        Jizhunshexiang=Double.parseDouble((et1.getText().toString()));
        YizhidianX=Double.parseDouble((et2.getText().toString()));
        YizhidianY=Double.parseDouble((et3.getText().toString()));
        YizhidianH=Double.parseDouble((et4.getText().toString()));
         Zhichanfenhua=Double.parseDouble((et18.getText().toString()));
        Zhuyifenhua=Double.parseDouble((et5.getText().toString()));
          Ceyifenhua=Double.parseDouble((et6.getText().toString()));
          Zhuyifuyang=Double.parseDouble((et7.getText().toString()));
          Juanchichang=Double.parseDouble((et8.getText().toString()));
           Zhubiaofenhua=Double.parseDouble((et9.getText().toString()));
           Cebiaofenhua=Double.parseDouble((et10.getText().toString()));
           Zhubiaofuyang=Double.parseDouble((et01.getText().toString()));
           
         ZhuguanX=ggg.BuzhujixianZhuguanX(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang);
         ZhuguanY=ggg.BuzhujixianZhuguanY(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang)  ;
         ZhuguanH=ggg.BuzhujixianZhuguanH(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang)  ;
          CeguanX=ggg.BuzhujixianCeguanX(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang) ;
         CeguanY=ggg.BuzhujixianCeguanY(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang)  ;
         Zhuyixiejuli=ggg.BuzhujixianZhuyixiejuli(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang)  ;
           Zhuyipingmianjuli=ggg.BuzhujixianZhuyipingmianjuli(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang);
           ;
           ;
           ;
           ;
           ;
           
           
         
         
         

       et11.setText(""+ZhuguanX);
       et12.setText(""+ZhuguanY);
       et13.setText(""+ZhuguanH);
       et14.setText(""+CeguanX);
       et15.setText(""+CeguanY);
       et16.setText(""+Zhuyixiejuli);
       et17.setText(""+Zhuyipingmianjuli);
       
 //    Toast.makeText(this, "主尺"+ggg.BuzhujixianZhuchipingmianjuli(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang) , Toast.LENGTH_LONG).show();
   //    Toast.makeText(this, "基线长"+ggg.BuzhujixianJixianchang(Jizhunshexiang, YizhidianX, YizhidianY, YizhidianH, Zhichanfenhua, Zhuyifenhua, Ceyifenhua, Zhuyifuyang, Juanchichang, Zhubiaofenhua, Cebiaofenhua, Zhubiaofuyang) , Toast.LENGTH_LONG).show();
       
       
      
       
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