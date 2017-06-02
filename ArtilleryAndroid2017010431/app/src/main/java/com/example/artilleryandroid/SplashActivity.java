package com.example.artilleryandroid;

import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SplashActivity extends Activity implements SplashADListener {

  private SplashAD splashAD;
  private ViewGroup container;
  private TextView skipView;
  private ImageView splashHolder;
  private static final String SKIP_TEXT = "点击跳过 %d";
  
  public boolean canJump = false;

  long Addticked=0;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    container = (ViewGroup) this.findViewById(R.id.splash_container);
    skipView = (TextView) findViewById(R.id.skip_view);
    splashHolder = (ImageView) findViewById(R.id.splash_holder); 
    fetchSplashAD(this, container, skipView, Constants.APPID, Constants.SplashPosID, this,0);

    //SharedPreferences spf=getSharedPreferences("Art", Context.MODE_WORLD_WRITEABLE);
    //Cipianmiwei=(double)spf.getFloat("Cipianmiwei", 0);

    //Addticked=spf.getLong("Adnum",0 );
   // ((EditText)findViewById(R.id.EditText101)).setText(spf.getString("Keya","password"));
    //    SharedPreferences spf=getSharedPreferences("Art", Context.MODE_WORLD_WRITEABLE);

 // SharedPreferences.Editor edit=spf.edit();
  //    Addticked=spf.getLong("Adnum",0 );
    Toast.makeText(this, "请允许打开蓝牙以连接外接激光测距机，否则地图无法使用！\n请点击广告，为作者开发免费软件提供支持，谢谢！", Toast.LENGTH_LONG).show();

    //onADClicked();
   // this.onADClicked();
  }

  /**
   * 拉取开屏广告，开屏广告的构造方法有3种，详细说明请参考开发者文档。
   *
   * @param activity        展示广告的activity
   * @param adContainer     展示广告的大容器
   * @param skipContainer   自定义的跳过按钮：传入该view给SDK后，SDK会自动给它绑定点击跳过事件。SkipView的样式可以由开发者自由定制，其尺寸限制请参考activity_splash.xml或者接入文档中的说明。
   * @param appId           应用ID
   * @param posId           广告位ID
   * @param adListener      广告状态监听器
   * @param fetchDelay      拉取广告的超时时长：取值范围[3000, 5000]，设为0表示使用广点通SDK默认的超时时长。
   */
  private void fetchSplashAD(Activity activity, ViewGroup adContainer, View skipContainer,
      String appId, String posId, SplashADListener adListener, int fetchDelay) {
   splashAD = new SplashAD(activity, adContainer, skipContainer, appId, posId, adListener, fetchDelay);

    //splashAD = new SplashAD(activity, adContainer, skipContainer, appId, posId, adListener, 4500);
  }

  @Override
  public void onADPresent() {
    Log.i("AD_DEMO", "SplashADPresent");
    splashHolder.setVisibility(View.INVISIBLE); // 广告展示后一定要把预设的开屏图片隐藏起来
  }

  @Override
  public void onADClicked() {
    Log.i("AD_DEMO", "SplashADClicked");

   // SharedPreferences spf=getSharedPreferences("Art", Context.MODE_WORLD_WRITEABLE);

   // SharedPreferences.Editor edit=spf.edit();
   // edit.putLong("Adnum", Addticked+1);
  //  edit.commit();
    Toast.makeText(this, "谢谢点击广告！", Toast.LENGTH_LONG).show();
  }

  /**
   * 倒计时回调，返回广告还将被展示的剩余时间。
   * 通过这个接口，开发者可以自行决定是否显示倒计时提示，或者还剩几秒的时候显示倒计时
   *
   * @param millisUntilFinished 剩余毫秒数
   */
  @Override
  public void onADTick(long millisUntilFinished) {
    Log.i("AD_DEMO", "SplashADTick " + millisUntilFinished + "ms");
    skipView.setText(String.format(SKIP_TEXT, Math.round(millisUntilFinished / 1000f)));
  }

  @Override
  public void onADDismissed() {
    Log.i("AD_DEMO", "SplashADDismissed");
    next();
  }

  @Override
  public void onNoAD(int errorCode) {
    Log.i("AD_DEMO", "LoadSplashADFail, eCode=" + errorCode);
    /** 如果加载广告失败，则直接跳转 new Intent(MainActivity.this,Menuofmian.class);*/
   // Toast.makeText(this, "广告加载失败，可能是系统防止刷屏所致，请稍后再试！", Toast.LENGTH_LONG).show();
  this.startActivity(new Intent(this,MainActivity.class));
   this.finish();
  }

  /**
   * 设置一个变量来控制当前开屏页面是否可以跳转，当开屏广告为普链类广告时，点击会打开一个广告落地页，此时开发者还不能打开自己的App主页。当从广告落地页返回以后，
   * 才可以跳转到开发者自己的App主页；当开屏广告是App类广告时只会下载App。
   */
  private void next() {
    if (canJump) {
      this.startActivity(new Intent(this, MainActivity.class));
      this.finish();
    } else {
      canJump = true;
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
    canJump = false;
  }

  @Override
  protected void onResume() {
    super.onResume();
    if (canJump) {
      next();
    }
    canJump = true;
  }

  /** 开屏页一定要禁止用户对返回按钮的控制，否则将可能导致用户手动退出了App而广告无法正常曝光和计费 */
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

}
