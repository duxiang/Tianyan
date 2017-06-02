package com.example.artilleryandroid.jibenyunsuan;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.R;


//import SSS.h;
public class Zhengyunsuan extends Activity {

	Function ggg =new Function() ;
	public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhengyunsuan2);


        ((EditText)findViewById(R.id.editTextABfangweimiwei)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if(((EditText) findViewById(R.id.editTextABfangweimiwei)).isFocused())
                            {    double Fab;
                                Fab = Double.parseDouble((((EditText) findViewById(R.id.editTextABfangweimiwei)).
                                    getText().toString()));
                            ((EditText) findViewById(R.id.editTextABfangweijiaodushu)).setText(String.format("% .7f", Fab * 360 / 6000));
                        } }catch(Exception e){
                            //       Toast.makeText(Zhengyunsuan.this, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                   }
                });



        ((EditText)findViewById(R.id.editTextABfangweijiaodushu)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.editTextABfangweijiaodushu)).isFocused())
                            {     double Fabjiaodu;
                            Fabjiaodu = Double.parseDouble((((EditText) findViewById(R.id.editTextABfangweijiaodushu)).
                                    getText().toString()));
                            ((EditText) findViewById(R.id.editTextABfangweimiwei)).setText(String.format("% .3f", Fabjiaodu * 6000 / 360));
                        }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });

        ((EditText)findViewById(R.id.editTextABfuyangmiwei)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.editTextABfuyangmiwei)).isFocused())
                            {     double Fabfuyangmiwei;
                                Fabfuyangmiwei = Double.parseDouble((((EditText) findViewById(R.id.editTextABfuyangmiwei)).
                                        getText().toString()));
                                ((EditText) findViewById(R.id.editTextABfuyangmjiaodushu)).setText(String.format("% .7f", Fabfuyangmiwei * 360/6000 ));
                            }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });
        ((EditText)findViewById(R.id.editTextABfuyangmjiaodushu)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.editTextABfuyangmjiaodushu)).isFocused())
                            {     double Fabjiaodu;
                                Fabjiaodu = Double.parseDouble((((EditText) findViewById(R.id.editTextABfuyangmjiaodushu)).
                                        getText().toString()));
                                ((EditText) findViewById(R.id.editTextABfuyangmiwei)).setText(String.format("% .3f", Fabjiaodu * 6000 / 360));
                            }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });


        ((EditText)findViewById(R.id.EditText105)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.EditText105)).isFocused())
                            {     double Fabfuyangmiwei;
                                Fabfuyangmiwei = Double.parseDouble((((EditText) findViewById(R.id.EditText105)).
                                        getText().toString()));
                                ((EditText) findViewById(R.id.EditTextpingmianjiaodushu)).setText(String.format("% .7f", Fabfuyangmiwei * 360/6000 ));
                            }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });

        ((EditText)findViewById(R.id.EditTextpingmianjiaodushu)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.EditTextpingmianjiaodushu)).isFocused())
                            {     double Fabjiaodu;
                                Fabjiaodu = Double.parseDouble((((EditText) findViewById(R.id.EditTextpingmianjiaodushu)).
                                        getText().toString()));
                                ((EditText) findViewById(R.id.EditText105)).setText(String.format("% .3f", Fabjiaodu * 6000 / 360));
                            }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });




        ((EditText)findViewById(R.id.EditText106)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.EditText106)).isFocused())
                            {     double Fabfuyangmiwei;
                                Fabfuyangmiwei = Double.parseDouble((((EditText) findViewById(R.id.EditText106)).
                                        getText().toString()));
                                ((EditText) findViewById(R.id.EditTextpingmianfuyangjiaodushu)).setText(String.format("% .7f", Fabfuyangmiwei * 360/6000 ));
                            }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });

        ((EditText)findViewById(R.id.EditTextpingmianfuyangjiaodushu)).
                addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        try {
                            if (((EditText) findViewById(R.id.EditTextpingmianfuyangjiaodushu)).isFocused())
                            {     double Fabjiaodu;
                                Fabjiaodu = Double.parseDouble((((EditText) findViewById(R.id.EditTextpingmianfuyangjiaodushu)).
                                        getText().toString()));
                                ((EditText) findViewById(R.id.EditText106)).setText(String.format("% .3f", Fabjiaodu * 6000 / 360));
                            }  }catch(Exception e){  }
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {                    }
                });

     //   ((EditText)findViewById(R.id.editTextABfangweimiwei)).setOnClickListener();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void Click1_1_1_1b1(View v){
    	//Intent intent=new Intent(Zhengyunsuan.this,Menujiben.class);

	  //  startActivity(intent);

    	finish();
    }


	public void Click1_1_1_1b2(View v){

    	try{
    	double Ax,Ay,Ah,Lab,Fab,Eab,Bx,By,Bh;
    	et1=(EditText)findViewById(R.id.EditText101);
        et2=(EditText)findViewById(R.id.EditText102);
        et3=(EditText)findViewById(R.id.EditText103);
        et4=(EditText)findViewById(R.id.EditText104);
        et5=(EditText)findViewById(R.id.EditText105);
        et6=(EditText)findViewById(R.id.EditText106);
        et7=(EditText)findViewById(R.id.EditText107);
        et8=(EditText)findViewById(R.id.EditText108);
        et9=(EditText)findViewById(R.id.EditText109);
        // Ax=double(et1.getText().toString());
        // NumberFormat format=new DecimalFormat();
         Ax=Double.parseDouble((et1.getText().toString()));
         Ay=Double.parseDouble((et2.getText().toString()));
         Ah=Double.parseDouble((et3.getText().toString()));
         Lab=Double.parseDouble((et4.getText().toString()));
         Fab=Double.parseDouble((et5.getText().toString()));
         Eab=Double.parseDouble((et6.getText().toString()));
         Bx=ggg.ZhengyunsuanBx(Ax, Ay, Ah, Lab, Fab, Eab);

         By=ggg.ZhengyunsuanBy(Ax, Ay, Ah, Lab, Fab, Eab);
         Bh=ggg.ZhengyunsuanBh(Ax, Ay, Ah, Lab, Fab, Eab);
         et7.setText(""+(String.format("% .3f",Bx)));
         et8.setText(""+(String.format("% .3f",By)));
         et9.setText(""+(String.format("% .3f",Bh)));

    	}catch(Exception e){

    		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    	}

    	;
    }




    public void Clickqiumianzhengyunsuan(View v){

        try{
       /*  double Ax,Ay,Ah,Lab,Fab,Eab,Bx,By,Bh;*/
            et1=(EditText)findViewById(R.id.EditText101);
            et2=(EditText)findViewById(R.id.EditText102);
            et3=(EditText)findViewById(R.id.EditText103);
            et4=(EditText)findViewById(R.id.EditText104);
            et5=(EditText)findViewById(R.id.EditText105);
            et6=(EditText)findViewById(R.id.EditText106);
            et7=(EditText)findViewById(R.id.EditText107);
            et8=(EditText)findViewById(R.id.EditText108);
            et9=(EditText)findViewById(R.id.EditText109);
            // Ax=double(et1.getText().toString());
  /*          // NumberFormat format=new DecimalFormat();
            Ax=Double.parseDouble((et1.getText().toString()));
            Ay=Double.parseDouble((et2.getText().toString()));
            Ah=Double.parseDouble((et3.getText().toString()));
            Lab=Double.parseDouble((et4.getText().toString()));
            Fab=Double.parseDouble((et5.getText().toString()));
            Eab=Double.parseDouble((et6.getText().toString()));
            Bx=ZhengyunsuanBx(Ax, Ay, Ah, Lab, Fab, Eab);

            By=ZhengyunsuanBy(Ax, Ay, Ah, Lab, Fab, Eab);
            Bh=ZhengyunsuanBh(Ax, Ay, Ah, Lab, Fab, Eab);
            et7.setText(""+Bx);
            et8.setText(""+By);
            et9.setText(""+Bh);*/
            double Weidua,Jingdua,Haibaa,Lab,Fab,Eab,Weidub,Jingdub,Haibab;
            Weidua=Double.parseDouble((((EditText)findViewById(R.id.editTextAweidu)).
                    getText().toString()));
            Jingdua=Double.parseDouble((((EditText)findViewById(R.id.editTextAjingdu)).
                    getText().toString()));
            Haibaa=Double.parseDouble((((EditText)findViewById(R.id.editTextAhaiba)).
                    getText().toString()));
            Lab=Double.parseDouble((((EditText)findViewById(R.id.editTextABzhixianjuli)).
                    getText().toString()));
            Fab=Double.parseDouble((((EditText)findViewById(R.id.editTextABfangweimiwei)).
                    getText().toString()));

            Eab   =Double.parseDouble((((EditText)findViewById(R.id.editTextABfuyangmiwei)).
                    getText().toString()));
            ggg.ZuizhongQiumianzhengyunsuan(Weidua,Jingdua,Haibaa,Lab,Fab,Eab);
            Weidub=ggg.DixinWeiduB;
            Jingdub=ggg.JingduB;
            Haibab=ggg.HaibaB;
//String.format("% .2f",Xi
            ((EditText)findViewById(R.id.editTextBweidu)).setText(String.format("% .7f",Weidub));
            ((EditText)findViewById(R.id.editTextBjingdu)).setText(String.format("% .7f",Jingdub));
            ((EditText)findViewById(R.id.editTextABzhenfangweijiaodushu)).setText(String.format("% .7f",ggg.Zhenbeifangweijiaodushu));
            ((EditText)findViewById(R.id.editTextBhaiba)).setText(String.format("% .3f",Haibab));

//显示平面部分

            et1.setText(String.format("% .3f",ggg.XA));
            et2.setText(String.format("% .3f",ggg.YA));
            et3.setText(String.format("% .3f",ggg.HaibaA));
            et4.setText(String.format("% .3f",ggg.XiejuliAB));
            et5.setText(String.format("% .3f",ggg.Yuanshipingmianmiwei));
            et6.setText(String.format("% .3f",ggg.PingmianfuyangmiweiAB));
            et7.setText(String.format("% .3f",ggg.XB));
            et8.setText(String.format("% .3f",ggg.YB));
            et9.setText(String.format("% .3f",ggg.HaibaB));

            Toast.makeText(this,"Xqiu1"+ggg.Xqiu1
                    +"\nYqiu1"+ggg.Yqiu1
                     +"\nZqiu1"+ggg.Zqiu1
                            +"\nXqiu2"+ggg.Xqiu2
                            +"\nYqiu2"+ggg.Yqiu2
                            +"\nZqiu2"+ggg.Zqiu2
                            +"\nA点球半径"+ggg.Rqiu
                            +"\nB点球半径"+ggg.Rqiu2
                            +"\n归化纬度A"+ggg.GuihuaWeiduA
                            +"\n大地纬度A"+ggg.DadiWeiduA
                            +"\n坐标纵线偏角"+ggg.Zuobiaozongxianpianjiao
                    , Toast.LENGTH_LONG).show();

        }catch(Exception e){

            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

        ;
    }

    public double Deg2Mil(double Deg)
    {
    	double Mil;
    	Mil=0;
    	Mil=Deg/360*6000;

    	return Mil;
    }
    public double Mil2Hu(double Mil)
    {
    	double Hu;
    	//Deg=0;
    	Hu=Mil/6000*(2*Math.PI);

    	return Hu;
    }


    public double ZhengyunsuanBx(double Ax,double Ay,double Ah,double Lab,double Fab,double Eab)
    { double Bx;
    Bx=0;
    Bx=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

    	return Bx;

    };
    public double ZhengyunsuanBy(double Ax,double Ay,double Ah,double Lab,double Fab,double Eab)
    { double By;
    By=0;
    By=Ay+Lab*Math.cos(Mil2Hu(Eab))*Math.sin(Mil2Hu(Fab));

    	return By;

    };
    public double ZhengyunsuanBh(double Ax,double Ay,double Ah,double Lab,double Fab,double Eab)
    { double Bh;
    Bh=0;
    Bh=Ah+Lab*Math.sin(Mil2Hu(Eab));

    	return Bh;

    };


}
