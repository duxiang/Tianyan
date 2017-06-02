package com.example.artilleryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

public class Tiandituhelp extends Activity {
int num=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiandituhelplayout);
        ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help1));
    }
    public void Clickhuantu(View v){
       switch (num)
       { case 1:
           ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help2));
           num++;
           break;
           case 2:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help3));
               num++;
               break;
           case 3:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help4));
               num++;
               break;
           case 4:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help5));
               num++;
               break;
           case 5:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help6));
               num++;
               break;
           case 6:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help7));
               num++;
               break;
           case 7:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help8));
               num++;
               break;
           case 8:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help9));
               num++;
               break;
           case 9:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help10));
               num++;
               break;
           case 10:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help11));
               num++;
               break;
           case 11:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help12));
               num++;
               break;
           case 12:
               ((LinearLayout) findViewById(R.id.huantull)).setBackground(getResources().getDrawable(R.drawable.help1));
               num=1;
               break;



       }

    }
}
