package com.example.artilleryandroid.jibenyunsuan;
import java.sql.Time;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.artilleryandroid.Function;
import com.example.artilleryandroid.R;


//import SSS.h;
public class Zhuyuanjisuan extends Activity {
	
	Function ggg =new Function() ;
	 EditText ET101,ET102,ET103,ET104,ET105,ET106,ET107,ET108,ET109,ET110,ET111,ET112,ET113,ET114,ET115
	,ET116,ET117,ET118,ET119,ET120,ET121,ET122,ET123,ET124,ET125,ET126,ET127,ET128,ET129,ET130
	,ET131,ET138,ET139,ET140
	,ET141,ET142,ET143,ET144,ET145,ET146,ET147,ET148,ET149,ET150,ET151,ET152,ET153,ET154,ET155,ET156
	,ET201,ET202,ET203,ET204,ET205,ET206,ET207,ET208,ET209,ET210
	,ET211,ET212,ET213,ET214,ET215,ET216,ET217,ET218,ET219,ET220
	,ET221,ET222,ET223,ET224,ET225,ET226,ET227,ET228,ET229,ET230
	,ET231,ET232,ET233,ET234,ET235,ET236,ET237,ET238,ET239,ET240
	,ET241,ET242,ET243,ET244,ET245,ET246,ET247,ET248,ET249,ET250
	,ET251,ET252,ET253,ET254
	,ET401,ET402,ET403,ET404,ET405,ET406,ET407
	,ET501,ET502,ET503,ET504,ET505,ET506,ET507,ET508,ET509,ET510
	,ET511,ET512,ET513,ET514,ET515,ET516,ET517,ET518,ET5182,ET519,ET520
	,ET521,ET522,ET523,ET524,ET525,ET526,ET527,ET528,ET529,ET530
	,ET531,ET532,ET533,ET534,ET535,ET536,ET537 ,ET538,ET539
	,ETtemp;
	 CheckBox Ch01,Ch02,Ch03,Ch04,Ch05,Ch06,Ch07,Ch08,Ch09,Ch10;
	
	 Function Use=new Function();
 Spinner spinner101,spinner102,spinner103,spinner104;	
	
	 Juedingzhuyuan Jdzy=new Juedingzhuyuan();

	
 double Jizhunshexiang,Weidu,ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,CeguanH,ZhendiX,ZhendiY,ZhendiH,
	Qiya,Qiwen,Fengxiang,Fengsu
	,Qiyapiancha,Qiwenpiancha,Yaowenpiancha
	,Chusu,Yaowen,Julijingyanxiuzhengliang,Fangxiangjingyanxiuzhengliang
	,MubiaoX,MubiaoY,MubiaoH
	,Guanmufenhua,Guanmuxiejuli,Guanmugaodijiao
	,Zhuguanfenhua,Ceguanfenhua,Zhuguangaodi
	,Biaochi,Fangxiang,Guanfangfenhua
	,Fanchajuli,Fanchabiaochi
	
	,Yundongsudupingmian,Yundongfangxiang
	,Cesuweiyi
	//,JingzhimubiaoX,JingzhimubiaoY,JingzhimubiaoH
	//,ShiyouzujidianX,ShiyouzujidianY,ShiyouzujidianH
	//,CesuqidianX,CesuqidianY,CesuqidianH
	//,CesuzhongdianX,CesuzhongdianY,CesuzhongdianH	
	//,YundongqidianX,YundongqidianY,YundongqidianH	
	//,FangdeweizhiX,FangdeweizhiY,FangdeweizhiH
	//,LuodanweizhiX,LuodanweizhiY,LuodanweizhiH	
	//,Zhadian1X,Zhadian1Y,Zhadian1H	
	//,Zhadian2X,Zhadian2Y,Zhadian2H	
	//,Zhadian3X,Zhadian3Y,Zhadian3H	
	//,Zhadian4X,Zhadian4Y,Zhadian4H	
	//,Zhadian5X,Zhadian5Y,Zhadian5H	
	//,Zhadian6X,Zhadian6Y,Zhadian6H	
	//,Zhadian7X,Zhadian7Y,Zhadian7H	
	//,Zhadian8X,Zhadian8Y,Zhadian8H	
	//,Zhadian9X,Zhadian9Y,Zhadian9H	
	//,Zhadian10X,Zhadian10Y,Zhadian10H
	
	/*
	 
	  
	  
	   <item>静止目标</item>  0
        <item>实有阻击点</item>1  
    <item>测速起点</item>  2
    <item>测速终点</item>  3
    <item>运动起点</item>  4
    <item>炸点1</item>  5
    <item>炸点2</item>  6
    <item>炸点3</item>  7
    <item>炸点4</item>  8
    <item>炸点5</item>  9
    <item>炸点6</item>  10
    <item>炸点7</item>  11
    <item>炸点8</item>  12
    <item>炸点9</item>  13
    <item>炸点10</item> 14
	  放的位置                           	15
	  落弹位置			16
	  
	  
	 
	
	*/
	
	
	
	


	
	,Cedijuli,Cedifangxiang,Pianliuxiuzhengliang,Julibujiaxiuzhengliang,Fangxiangbujiaxiuzhengliang
	,Julixiuzhengliang,Fangxiangxiuzhengliang
	,Kaishijuli,Kaishifangxiang,Kaishishejiao,Gaojiaoxiuzhengliang,Gaobian,Baibian,Shimigaoxiu
	,Juligongsuanpiancha,Fangxianggongsuanpiancha,Gaodigongsuanpiancha
	,Guanmufangxiang,Guanpaojiajiao,Guanmupingmianjuli,Shedanfeixingshijian,Luojiao,Luosu,Dandaogao,Fangxiangbi
	,Xiuzhenglv,Qiyajulixiuzhengliang,Qiwenjulixiuzhengliang,Yaowenjulixiuzhengliang,Chusujulixiuzhengliang
	,Haibajulixiuzhengliang,Zongfengjulixiuzhengliang,Weidujulixiuzhengliang,Hengfengfangxiangxiuzhengliang
	,Weidufangxiangxiuzhengliang,Pianliufangxiangxiuzhengliang
	,Qixiangzhangaocheng,Qiwenpianchadimian,Qiyapianchadimian
	,Wenpian200,Fengxiang200,Fengsu200
	,Wenpian400,Fengxiang400,Fengsu400
	,Wenpian800,Fengxiang800,Fengsu800
	,Wenpian1200,Fengxiang1200,Fengsu1200
	,Wenpian1600,Fengxiang1600,Fengsu1600
	,Wenpian2000,Fengxiang2000,Fengsu2000
	,Wenpian2400,Fengxiang2400,Fengsu2400
	,Wenpian3000,Fengxiang3000,Fengsu3000
	,Fengjiao
	,Paomugaocha
	
	,Zhengchengcedijuli[] =new double[20],Zhengchengpianliufangxiangxiuzhengliang[] =new double[20]
	,Zhengchengjulibujiaxiuzhengliang[] =new double[20],Zhengchengfangxiangbujiaxiuzhengliang[] =new double[20]
	,Zhengchengjulixiuzhengliang[] =new double[20],Zhengchengfangxiangxiuzhengliang[] =new double[20]
	,Zhengchengcedifangxiang
			;
double WeizhiX[]=new double[23] ;
	 double WeizhiY[]=new double[23] ;
	 double WeizhiH[]=new double[23] ;
	
	 Time Shijian[]=new Time[23];
	 long Haomiao[]=new long[23];
	long Tiqianmiaoshu;
 long Fangdehaomiaoshu;
	 double Fangdemiaoshu;
 double Jingmi1canshu[][]=new double[40][5] ;
 double Dandaoyinshu[][][]=new double[10][50][20] ;
 double PingjunzhadianX,PingjunzhadianY,PingjunzhadianH;
String Fangdeshijian;
Time Timetemp;

	////////////////  弹种[]
   // <item>152增程弹</item>0  
   // <item>122增程弹</item> 1 
   // <item>122照明弹</item>  2
    //<item>152电磁悬浮侦察弹</item>3  
	////////////////因数组数[]
	//气压距离修正1
	//气温距离修正2
	//药温距离修正3
	//初速距离修正4
	//海拔距离修正5
	//纵风距离修正6
	//纬度距离修正7
	//横风方向修正8
	//纬度方向修正9
	//偏流方向修正10
	//10米高修11
	//距离公算偏差12
	//方向公算偏差13
	//高低公算偏差14
	//射弹飞行时间15
	//落角 		 16
	//落速 		 17
	//弹道高		 18
	//高变  		19
	//射角		31
	
	
	
	
	/////////////////组内因数
	//0阶0
	//1阶1
	//2阶2
	//3阶3
	//4阶4
	//5阶5
	//6阶6
	//7阶7
	//
	//
	//
	//
	//
	
	
	/////////////////
	
	
	
	
	
	//Dandaoyinshu[1][1][1]=1;
	
	
	
	
	
	
	
	
	
 String Jingmi1shijian,Jingmi1gaocheng,Jingmi1dimian,Jingmi1_02,Jingmi1_04,Jingmi1_08,Jingmi1_12
	,Jingmi1_16,Jingmi1_20,Jingmi1_24,Jingmi1_30,Dangqianfangfa,Mubiaoleixing,Zhenglishijian[]=new String[20];
	int Chengguobianhao
	,Fangfashuzi////1简易法  2精密1111法  3成果法
	,Shiyongchengguobianhao
	,Zhenglichengguobianhao
	
	
	;
	
	
	 Qixiang1111xianshiyong Qixiangtemp=new Qixiang1111xianshiyong();
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuyuanjisuan);
        
        
        ////////////////初始化各类
        
    	////////////////  弹种[]
        // <item>152增程弹</item>0  
        // <item>122增程弹</item> 1 
        // <item>122照明弹</item>  2
         //<item>152电磁悬浮侦察弹</item>3  
     	////////////////因数组数[]
     	//气压距离修正1
     	//气温距离修正2
     	//药温距离修正3
     	//初速距离修正4
     	//海拔距离修正5
     	//纵风距离修正6
     	//纬度距离修正7
     	//横风方向修正8
     	//纬度方向修正9
     	//偏流方向修正10
     	//10米高修11
     	//距离公算偏差12
     	//方向公算偏差13
     	//高低公算偏差14
     	//射弹飞行时间15
     	//落角 		 16
     	//落速 		 17
     	//弹道高		 18
     	//射角		31
        
      //////////////////////  
        
        //0.0000010977, -0.000062957, 0.0014247, -0.016214, 0.095995, -0.22609, 0.33255, -0.0004677
        //122增程弹气压距离修正量//
        Dandaoyinshu[1][1][11]=750;//11为标准值row
        Dandaoyinshu[1][1][7]=0.0000010977;
        Dandaoyinshu[1][1][6]=-0.000062957;
        Dandaoyinshu[1][1][5]=0.0014247;
        Dandaoyinshu[1][1][4]=-0.016214;
        Dandaoyinshu[1][1][3]=0.095995;
        Dandaoyinshu[1][1][2]=-0.22609;
        Dandaoyinshu[1][1][1]=0.33255;
        Dandaoyinshu[1][1][0]=-0.0004677;
        
        
        
        ////152  -9.21421E-07	9.15606E-05	-0.003782938	0.084053688	-1.086701629	8.237211026	-33.45877981	56.98106056
        Dandaoyinshu[0][1][11]=666;//666为标准值
        Dandaoyinshu[0][1][7]=-0.0000009214212;
        Dandaoyinshu[0][1][6]=0.000091560600839;
        Dandaoyinshu[0][1][5]=-0.003782937736095;
        Dandaoyinshu[0][1][4]=0.084053687817718;
        Dandaoyinshu[0][1][3]=-1.08670162857153;
        Dandaoyinshu[0][1][2]=8.23721102590706;
        Dandaoyinshu[0][1][1]=-33.4587798092686;
        Dandaoyinshu[0][1][0]=56.9810605625654;
        
        
        
        
        
        //-0.00000065883, 0.000043788, -0.0011196, 0.013786, -0.091737, 0.47121, -0.35017, 0.00032836
        //122增程弹气温距离修正量
        Dandaoyinshu[1][2][11]=15;
        Dandaoyinshu[1][2][7]=-0.00000065883;
        Dandaoyinshu[1][2][6]=0.000043788;
        Dandaoyinshu[1][2][5]=-0.0011196;
        Dandaoyinshu[1][2][4]=0.013786;
        Dandaoyinshu[1][2][3]=-0.091737;
        Dandaoyinshu[1][2][2]=0.47121;
        Dandaoyinshu[1][2][1]=-0.35017;
        Dandaoyinshu[1][2][0]=0.00032836;
        //152增程弹气温距离修正量
        Dandaoyinshu[0][2][11]=9;
        Dandaoyinshu[0][2][7]=-0.00000012285616;
        Dandaoyinshu[0][2][6]=0.000000057332876;
        Dandaoyinshu[0][2][5]=0.000546697626374;
        Dandaoyinshu[0][2][4]=-0.02530839573693;
        Dandaoyinshu[0][2][3]=0.503698201938862;
        Dandaoyinshu[0][2][2]=-5.06136110658946;
        Dandaoyinshu[0][2][1]=25.79992407252;
        Dandaoyinshu[0][2][0]=-51.4865150423875;
        
        
        
        //0.00000071744, -0.000046669, 0.0012094, -0.01595
        //0.11351, -0.43982, 1.9026, 0.0006517, 
        //122增程弹药温距离修正量
        Dandaoyinshu[1][3][11]=15;
        Dandaoyinshu[1][3][7]=0.00000071744;
        Dandaoyinshu[1][3][6]=-0.000046669;
        Dandaoyinshu[1][3][5]=0.0012094;
        Dandaoyinshu[1][3][4]=-0.01595;
        Dandaoyinshu[1][3][3]=0.11351;
        Dandaoyinshu[1][3][2]=-0.43982;
        Dandaoyinshu[1][3][1]=1.9026;
        Dandaoyinshu[1][3][0]=0.0006517;
        //152增程弹药温距离修正量
        Dandaoyinshu[0][3][11]=15;
        Dandaoyinshu[0][3][7]=0.000003839255;
        Dandaoyinshu[0][3][6]=-0.000319000114643;
        Dandaoyinshu[0][3][5]=0.010789473683249;
        Dandaoyinshu[0][3][4]=-0.190646902238743;
        Dandaoyinshu[0][3][3]=1.87269523468223;
        Dandaoyinshu[0][3][2]=-9.99806719842389;
        Dandaoyinshu[0][3][1]=28.0482523328292;
        Dandaoyinshu[0][3][0]=-18.7753552254629; 
        
        
        
        //0.0000012911, -0.000073926, 0.0016654,-0.018705,
        //  0.11156, -0.40282, 2.3525, 0.00038944,
        //122增程弹初速距离修正量
        Dandaoyinshu[1][4][7]=0.0000012911;
        Dandaoyinshu[1][4][6]=-0.000073926;
        Dandaoyinshu[1][4][5]=0.0016654;
        Dandaoyinshu[1][4][4]=-0.018705;
        Dandaoyinshu[1][4][3]=0.11156;
        Dandaoyinshu[1][4][2]=-0.40282;
        Dandaoyinshu[1][4][1]=2.3525;
        Dandaoyinshu[1][4][0]=0.00038944;
      //152增程弹初速距离修正量
        Dandaoyinshu[0][4][7]=0.0000027642636;
        Dandaoyinshu[0][4][6]=-0.000265967205578;
        Dandaoyinshu[0][4][5]=0.01070863433017;
        Dandaoyinshu[0][4][4]=-0.233505541425478;
        Dandaoyinshu[0][4][3]=2.97452908737847;
        Dandaoyinshu[0][4][2]=-22.1428002922925;
        Dandaoyinshu[0][4][1]=90.8557704606943;
        Dandaoyinshu[0][4][0]=-148.680515187369;
        
        /////////////
        //0.000032033, -0.0019941, 0.049674, -0.63149,
        //  4.2977, -14.463, 20.226, 0.0050266
        //122增程弹海拔距离修正量
       
        Dandaoyinshu[1][5][11]=0;
        Dandaoyinshu[1][5][7]=0.000032033;
        Dandaoyinshu[1][5][6]=-0.0019941;
        Dandaoyinshu[1][5][5]=0.049674;
        Dandaoyinshu[1][5][4]=-0.63149;
        Dandaoyinshu[1][5][3]=4.2977;
        Dandaoyinshu[1][5][2]=-14.463;
        Dandaoyinshu[1][5][1]=20.226;
        Dandaoyinshu[1][5][0]=0.0050266;
        //152增程弹海拔距离修正量
        
        Dandaoyinshu[0][5][11]=1000;
        Dandaoyinshu[0][5][7]=-0.00000955206644;
        Dandaoyinshu[0][5][6]=0.000949375071581;
        Dandaoyinshu[0][5][5]=-0.039296697622852;
        Dandaoyinshu[0][5][4]=0.875929575302378;
        Dandaoyinshu[0][5][3]=-11.3611560777323;
        Dandaoyinshu[0][5][2]=86.1472041559156;
        Dandaoyinshu[0][5][1]=-349.869269713388;
        Dandaoyinshu[0][5][0]=592.77280933226;
        
        

        
        /////////////
        
        
        /////////////
        //-0.00000040884, 0.000020796, -0.0004037, 0.003858
        // , -0.019442, 0.16914, -0.054589, -0.000067775
        //122增程弹纵风距离修正量
        Dandaoyinshu[1][6][7]=-0.00000040884;
        Dandaoyinshu[1][6][6]=0.000020796;
        Dandaoyinshu[1][6][5]=-0.0004037;
        Dandaoyinshu[1][6][4]=0.003858;
        Dandaoyinshu[1][6][3]=-0.019442;
        Dandaoyinshu[1][6][2]=0.16914;
        Dandaoyinshu[1][6][1]=-0.054589;
        Dandaoyinshu[1][6][0]=-0.000067775;
        //152增程弹纵风距离修正量
        Dandaoyinshu[0][6][7]=-0.00000165855816;
        Dandaoyinshu[0][6][6]=0.000163685357177;
        Dandaoyinshu[0][6][5]=-0.006711386308611;
        Dandaoyinshu[0][6][4]=0.148222515494959;
        Dandaoyinshu[0][6][3]=-1.89970287228118;
        Dandaoyinshu[0][6][2]=14.1909088686195;
        Dandaoyinshu[0][6][1]=-56.8527529290585;
        Dandaoyinshu[0][6][0]=94.8342621195699;
        /////////////
        
        /////////////
        //0.000012212, -0.00063354, 0.011972, -0.090353, 
        //0.058408, 2.1412, -0.6982, 0.012223,
        //122增程弹纬度距离修正量
        Dandaoyinshu[1][7][7]=0.000012212;
        Dandaoyinshu[1][7][6]=-0.00063354;
        Dandaoyinshu[1][7][5]= 0.011972;
        Dandaoyinshu[1][7][4]=-0.090353;
        Dandaoyinshu[1][7][3]=0.058408;
        Dandaoyinshu[1][7][2]=2.1412;
        Dandaoyinshu[1][7][1]=-0.6982;
        Dandaoyinshu[1][7][0]=0.012223;
        //152增程弹纬度距离修正量
        Dandaoyinshu[0][7][7]=-0.000003839255;
        Dandaoyinshu[0][7][6]=0.000363347093201;
        Dandaoyinshu[0][7][5]= -0.014329635361989;
        Dandaoyinshu[0][7][4]=0.304945291185549;
        Dandaoyinshu[0][7][3]=-3.78209056029388;
        Dandaoyinshu[0][7][2]=27.3555629954976;
        Dandaoyinshu[0][7][1]=-106.443097269398;
        Dandaoyinshu[0][7][0]=232.015063092088;
       
        
        /////////////
        /////////////
        //-0.000000064062, 0.0000045472, -0.00012966, 0.001887
        // -0.014749, 0.060085, -0.045974, 0.000034174
        //122增程弹横风方向修正量
        Dandaoyinshu[1][8][7]=-0.000000064062;
        Dandaoyinshu[1][8][6]=0.0000045472;
        Dandaoyinshu[1][8][5]= -0.00012966;
        Dandaoyinshu[1][8][4]=0.001887;
        Dandaoyinshu[1][8][3]=-0.014749;
        Dandaoyinshu[1][8][2]=0.060085;
        Dandaoyinshu[1][8][1]=-0.045974;
        Dandaoyinshu[1][8][0]=0.000034174;
        //152增程弹横风方向修正量
        Dandaoyinshu[0][8][7]=-0.000000156641604;
        Dandaoyinshu[0][8][6]=0.000013745556701;
        Dandaoyinshu[0][8][5]= -0.000491933264468;
        Dandaoyinshu[0][8][4]=0.009187871008363;
        Dandaoyinshu[0][8][3]=-0.094715281065613;
        Dandaoyinshu[0][8][2]=0.518723484493027;
        Dandaoyinshu[0][8][1]=-1.21848934185392;
        Dandaoyinshu[0][8][0]=0.549925616042325;
        /////////////
        
        //0.00000044312, -0.000025226, 0.00055054, -0.0056384,
        //  0.02812, -0.036628, 0.3691, 0.00003284
        //122增程弹偏流方向修正量
        Dandaoyinshu[1][10][7]=0.00000044312;
        Dandaoyinshu[1][10][6]=-0.000025226;
        Dandaoyinshu[1][10][5]= 0.00055054;
        Dandaoyinshu[1][10][4]=-0.0056384;
        Dandaoyinshu[1][10][3]=0.02812;
        Dandaoyinshu[1][10][2]=-0.036628;
        Dandaoyinshu[1][10][1]=0.3691;
        Dandaoyinshu[1][10][0]=0.00003284;
        //152增程弹偏流方向修正量
        Dandaoyinshu[0][10][7]=0.00000018428424;
        Dandaoyinshu[0][10][6]=-0.000004643962853;
        Dandaoyinshu[0][10][5]= -0.000279411764527;
        Dandaoyinshu[0][10][4]=0.015493470663608;
        Dandaoyinshu[0][10][3]=-0.307598436082734;
        Dandaoyinshu[0][10][2]=3.05913012978171;
        Dandaoyinshu[0][10][1]=-14.8978629872135;
        Dandaoyinshu[0][10][0]=29.9903119760609;
        /////////////

        //122增程弹10米高修密位公式直接算
           Dandaoyinshu[1][11][7]=-0.000000542717087;
        Dandaoyinshu[1][11][6]=0.000044452614371;
        Dandaoyinshu[1][11][5]=-0.00154747548993;
        Dandaoyinshu[1][11][4]=0.029725285942743;
        Dandaoyinshu[1][11][3]=-0.341430410955348;
        Dandaoyinshu[1][11][2]=2.363975530509448;
        Dandaoyinshu[1][11][1]=-9.346004601127902;
        Dandaoyinshu[1][11][0]=17.91702097696644;
        //152增程弹10米高修密位公式直接算
     Dandaoyinshu[0][11][7]=-2.39221292974592E-17;
     Dandaoyinshu[0][11][6]=0.000001662653368;
     Dandaoyinshu[0][11][5]=-0.000139662882794;
     Dandaoyinshu[0][11][4]=0.00484085717274;
     Dandaoyinshu[0][11][3]=-0.088595168190039;
     Dandaoyinshu[0][11][2]=0.907553288918746;
     Dandaoyinshu[0][11][1]=-5.03962430298123;
     Dandaoyinshu[0][11][0]=13.1206684146676;
        /////////////
        
        //0.0000035903, -0.00026664, 0.008377, -0.1434
        // , 1.4138, -7.5367, 19.812, -0.00056031
        //122增程弹BD
        Dandaoyinshu[1][12][7]=0.0000035903;
        Dandaoyinshu[1][12][6]=-0.00026664;
        Dandaoyinshu[1][12][5]=0.008377;
        Dandaoyinshu[1][12][4]=-0.1434;
        Dandaoyinshu[1][12][3]=1.4138;
        Dandaoyinshu[1][12][2]=-7.5367;
        Dandaoyinshu[1][12][1]= 19.812;
        Dandaoyinshu[1][12][0]=-0.00056031;
        //152增程弹BD
        Dandaoyinshu[0][12][7]=-0.0000218069684;
        Dandaoyinshu[0][12][6]=0.002314098153739;
        Dandaoyinshu[0][12][5]=-0.10316176469984;
        Dandaoyinshu[0][12][4]=2.50190593204863;
        Dandaoyinshu[0][12][3]=-35.594948200047;
        Dandaoyinshu[0][12][2]=296.291921892927;
        Dandaoyinshu[0][12][1]=-1328.2984149565;
        Dandaoyinshu[0][12][0]=2493.27979665492;
        /////////////
        //-0.00000048396, 0.00003238, -0.00086573, 0.011783, 
        // -0.083389, 0.2955, -0.15917, 0.000033336,
        //122增程弹BF
        Dandaoyinshu[1][13][7]=-0.00000048396;
        Dandaoyinshu[1][13][6]=0.00003238;
        Dandaoyinshu[1][13][5]=-0.00086573;
        Dandaoyinshu[1][13][4]=0.011783;
        Dandaoyinshu[1][13][3]= -0.083389;
        Dandaoyinshu[1][13][2]=0.2955;
        Dandaoyinshu[1][13][1]= -0.15917;
        Dandaoyinshu[1][13][0]=0.000033336;
         //////////////
        /////////////
        //-0.0000043015, 0.00025997, -0.0063378, 0.079404, 
        // , -0.51866, 1.6898, -1.817, 0.0027197
        //122增程弹BH
        Dandaoyinshu[1][14][7]=-0.0000043015;
        Dandaoyinshu[1][14][6]=0.00025997;
        Dandaoyinshu[1][14][5]=-0.0063378;
        Dandaoyinshu[1][14][4]=0.079404;
        Dandaoyinshu[1][14][3]= -0.51866;
        Dandaoyinshu[1][14][2]=1.6898;
        Dandaoyinshu[1][14][1]= -1.817;
        Dandaoyinshu[1][14][0]=0.0027197;
         //////////////
        /////////////
        //0.0000012592, -0.000071547, 0.0016137, -0.018368, 
        // 0.11267, -0.28812, 1.9319, -0.000048933
        //122增程弹射弹飞行时间
        Dandaoyinshu[1][15][7]=0.0000012592;
        Dandaoyinshu[1][15][6]=-0.000071547;
        Dandaoyinshu[1][15][5]=0.0016137;
        Dandaoyinshu[1][15][4]=-0.018368;
        Dandaoyinshu[1][15][3]= 0.11267;
        Dandaoyinshu[1][15][2]=-0.28812;
        Dandaoyinshu[1][15][1]= 1.9319;
        Dandaoyinshu[1][15][0]=-0.000048933;
        //152增程弹射弹飞行时间
        Dandaoyinshu[0][15][7]=0.00000024571232;
        Dandaoyinshu[0][15][6]=-0.000010477582843;
        Dandaoyinshu[0][15][5]=-0.000026960784438;
        Dandaoyinshu[0][15][4]=0.008685594235981;
        Dandaoyinshu[0][15][3]= -0.189752470862878;
        Dandaoyinshu[0][15][2]=1.88101885838522;
        Dandaoyinshu[0][15][1]= -7.00544467808632;
        Dandaoyinshu[0][15][0]=14.9767238251409;
         //////////////
        /////////////
        //0.00012443, -0.0055584, 0.082893, 
        //-0.30411, 1.0995, -0.37125
        //122增程弹落角
        Dandaoyinshu[1][16][7]=0;
        Dandaoyinshu[1][16][6]=0;
        Dandaoyinshu[1][16][5]=0.00012443;
        Dandaoyinshu[1][16][4]=-0.0055584;
        Dandaoyinshu[1][16][3]= 0.082893;
        Dandaoyinshu[1][16][2]=-0.30411;
        Dandaoyinshu[1][16][1]=1.0995;
        Dandaoyinshu[1][16][0]=-0.37125;
        //152增程弹落角
        Dandaoyinshu[0][16][7]=-0.0000027642636;
        Dandaoyinshu[0][16][6]=0.000277777777757;
        Dandaoyinshu[0][16][5]=-0.01158539731596;
        Dandaoyinshu[0][16][4]=0.259155784426259;
        Dandaoyinshu[0][16][3]= -3.35086528511827;
        Dandaoyinshu[0][16][2]=25.1585409533965;
        Dandaoyinshu[0][16][1]=-100.463844471946;
        Dandaoyinshu[0][16][0]=168.806156211083;
         //////////////
        /////////////
        //-0.00050905, 0.050228, -1.8313
        // , 32.516, -284.55, 1282.2
        //122增程弹落速
        Dandaoyinshu[1][17][7]=0;
        Dandaoyinshu[1][17][6]=0;
        Dandaoyinshu[1][17][5]=-0.00050905;
        Dandaoyinshu[1][17][4]=0.050228;
        Dandaoyinshu[1][17][3]= -1.8313;
        Dandaoyinshu[1][17][2]=32.516;
        Dandaoyinshu[1][17][1]= -284.55;
        Dandaoyinshu[1][17][0]=1282.2;

         //////////////
        /////////////
        //0.000020635, -0.001163, 0.026621, -0.28718
        //, 1.9044, -1.9573, 4.9696, -0.0034295
        //122增程弹弹道高
        Dandaoyinshu[1][18][7]=0.000020635;
        Dandaoyinshu[1][18][6]=-0.001163;
        Dandaoyinshu[1][18][5]=0.026621;
        Dandaoyinshu[1][18][4]=-0.28718;
        Dandaoyinshu[1][18][3]= 1.9044;
        Dandaoyinshu[1][18][2]=-1.9573;
        Dandaoyinshu[1][18][1]=4.9696;
        Dandaoyinshu[1][18][0]=-0.0034295;
        //152增程弹弹道高
        Dandaoyinshu[0][18][7]=0.000220526807202;
        Dandaoyinshu[0][18][6]=-0.019825851391942;
        Dandaoyinshu[0][18][5]=0.753258083882831;
        Dandaoyinshu[0][18][4]=-15.6141169512426;
        Dandaoyinshu[0][18][3]= 190.948017534157;
        Dandaoyinshu[0][18][2]=-1369.72917923831;
        Dandaoyinshu[0][18][1]=5375.93176119582;
        Dandaoyinshu[0][18][0]=-8840.82812472609;
         //////////////
        //-0.0000031264, 0.00017256, -0.0039916, 0.051749, 
        //-0.4258, 2.4864, -14.759,100,
        //122增程弹高变
        Dandaoyinshu[1][19][7]=-0.0000031264;
        Dandaoyinshu[1][19][6]=0.00017256;
        Dandaoyinshu[1][19][5]=-0.0039916;
        Dandaoyinshu[1][19][4]=0.051749;
        Dandaoyinshu[1][19][3]=-0.4258;
        Dandaoyinshu[1][19][2]=2.4864;
        Dandaoyinshu[1][19][1]=-14.759;
        Dandaoyinshu[1][19][0]=100;
        //152增程弹高变
        Dandaoyinshu[0][19][7]=-0.000009214212;
        Dandaoyinshu[0][19][6]=0.000834336658619;
        Dandaoyinshu[0][19][5]=-0.031292999655103;
        Dandaoyinshu[0][19][4]=0.626863483788646;
        Dandaoyinshu[0][19][3]=-7.19782669785426;
        Dandaoyinshu[0][19][2]=47.0971176092782;
        Dandaoyinshu[0][19][1]=-165.824645784951;
        Dandaoyinshu[0][19][0]=312.133563525486;
         //////////////
        /////////////
        
        /////////////
        //0.0000051299, -0.00030282, 0.0071519, -0.085014, 
        //0.56813, -1.37, 13.758, -0.00096922
        //122增程弹射角
        Dandaoyinshu[1][31][7]=0.0000051299;
        Dandaoyinshu[1][31][6]= -0.00030282;
        Dandaoyinshu[1][31][5]=0.0071519;
        Dandaoyinshu[1][31][4]=-0.085014;
        Dandaoyinshu[1][31][3]= 0.56813;
        Dandaoyinshu[1][31][2]=-1.37;
        Dandaoyinshu[1][31][1]=13.758;
        Dandaoyinshu[1][31][0]=-0.00096922;
        //152增程弹射角
        Dandaoyinshu[0][31][7]=0.0000082927908;
        Dandaoyinshu[0][31][6]= -0.000792483660096;
        Dandaoyinshu[0][31][5]=0.032083333331846;
        Dandaoyinshu[0][31][4]=-0.710254260238923;
        Dandaoyinshu[0][31][3]= 9.29610720758854;
        Dandaoyinshu[0][31][2]=-71.3724255075047;
        Dandaoyinshu[0][31][1]=312.16839557604;
        Dandaoyinshu[0][31][0]=-533.976946860669;
        
         //////////////
         
        
        
        
        
        
        
        spinner101=(Spinner)findViewById(R.id.Spinner101);
        spinner102=(Spinner)findViewById(R.id.Spinner102);
        spinner103=(Spinner)findViewById(R.id.Spinner103);
        spinner104=(Spinner)findViewById(R.id.Spinner104);
               
        Ch01=(CheckBox)findViewById(R.id.CheckBox01);
        Ch02=(CheckBox)findViewById(R.id.CheckBox02);
        Ch03=(CheckBox)findViewById(R.id.CheckBox03);
        Ch04=(CheckBox)findViewById(R.id.CheckBox04);
        Ch05=(CheckBox)findViewById(R.id.CheckBox05);
        Ch06=(CheckBox)findViewById(R.id.CheckBox06);
        Ch07=(CheckBox)findViewById(R.id.CheckBox07);
        Ch08=(CheckBox)findViewById(R.id.CheckBox08);
        Ch09=(CheckBox)findViewById(R.id.CheckBox09);
        Ch10=(CheckBox)findViewById(R.id.CheckBox10);
        
        
       Xianshishuaxin();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //返回时关闭套接字
    @Override
    public void onBackPressed(){
    	
  //  	Ms1.close();
   // 	Ms1m.close();
    	new AlertDialog.Builder(this)
		.setTitle("提示")

		.setMessage("确定退出吗?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				

				
				 try{
					 Zhuyuanjisuan.this.finish();;					
				       }
				        catch(Exception e){
				       Toast.makeText(Zhuyuanjisuan.this, e.toString(), Toast.LENGTH_LONG).show();
				        	}
				    	
				
				
				

			}
		})
		.setNegativeButton("取消", null)
		.show();
		
		

    	
    	
    }
    /*
   
    
    */
    ////////////////////////刷新显示
    public void Xianshishuaxin(){
        
    	try{
    
    		ET101=(EditText)findViewById(R.id.EditText101);
            ET101.setText(""+Jizhunshexiang);
            ET102=(EditText)findViewById(R.id.EditText102);
            ET102.setText(""+Weidu);
            ET103=(EditText)findViewById(R.id.EditText103);
            ET103.setText(""+ZhuguanX);
            ET104=(EditText)findViewById(R.id.EditText104);
            ET104.setText(""+ZhuguanY);
            ET105=(EditText)findViewById(R.id.EditText105);
            ET105.setText(""+ZhuguanH);
            ET106=(EditText)findViewById(R.id.EditText106);
            ET106.setText(""+CeguanX);
            ET107=(EditText)findViewById(R.id.EditText107);
            ET107.setText(""+CeguanY);
            ET108=(EditText)findViewById(R.id.EditText108);
            ET108.setText(""+CeguanH);           
            ET109=(EditText)findViewById(R.id.EditText109);
            ET109.setText(""+ZhendiX);
            ET110=(EditText)findViewById(R.id.EditText110);
            ET110.setText(""+ZhendiY);
            ET111=(EditText)findViewById(R.id.EditText111);
            ET111.setText(""+ZhendiH);                  ;
            ET112=(EditText)findViewById(R.id.EditText112);
            ET112.setText(""+Qiya);          
            ET113=(EditText)findViewById(R.id.EditText113);
            ET113.setText(""+Qiwen);              
            ET114=(EditText)findViewById(R.id.EditText114);
            ET114.setText(""+Fengxiang);          
            ET115=(EditText)findViewById(R.id.EditText115);
            ET115.setText(""+Fengsu); 
            
            
           /* Jingmi1shijian,Jingmi1gaocheng,Jingmi1dimian,Jingmi1_02,Jingmi1_04,Jingmi1_08,Jingmi1_12
        	,Jingmi1_16,Jingmi1_20,Jingmi1_24,Jingmi1_30,Dangqianfangfa,Mubiaoleixing,Zhenglishijian
            */
            
            ET116=(EditText)findViewById(R.id.EditText116);
            ET116.setText(""+Jingmi1shijian);  
            ET117=(EditText)findViewById(R.id.EditText117);
            ET117.setText(""+Jingmi1gaocheng); 
            ET118=(EditText)findViewById(R.id.EditText118);
            ET118.setText(""+Jingmi1dimian); 
            ET119=(EditText)findViewById(R.id.EditText119);
            ET119.setText(""+Jingmi1_02); 
            ET120=(EditText)findViewById(R.id.EditText120);
            ET120.setText(""+Jingmi1_04); 
            ET121=(EditText)findViewById(R.id.EditText121);
            ET121.setText(""+Jingmi1_08); 
            ET122=(EditText)findViewById(R.id.EditText122);
            ET122.setText(""+Jingmi1_12); 
            ET123=(EditText)findViewById(R.id.EditText123);
            ET123.setText(""+Jingmi1_16); 
            ET124=(EditText)findViewById(R.id.EditText124);
            ET124.setText(""+Jingmi1_20); 
            ET125=(EditText)findViewById(R.id.EditText125);
            ET125.setText(""+Jingmi1_24); 
            ET126=(EditText)findViewById(R.id.EditText126);
            ET126.setText(""+Jingmi1_30); 
            
            ET127=(EditText)findViewById(R.id.EditText127);
            ET127.setText(""+Dangqianfangfa);
            ET128=(EditText)findViewById(R.id.EditText128);
            ET128.setText(""+Chusu);       
            ET129=(EditText)findViewById(R.id.EditText129);
            ET129.setText(""+Yaowen);             
            ET130=(EditText)findViewById(R.id.EditText130);
            ET130.setText(""+Julijingyanxiuzhengliang);             
            ET131=(EditText)findViewById(R.id.EditText131);
            ET131.setText(""+Fangxiangjingyanxiuzhengliang);             

            
            
            
            ET140=(EditText)findViewById(R.id.EditText140);
            ET140.setText(""+Haomiao[spinner103.getSelectedItemPosition()]); 
          
            Timetemp=new Time(Haomiao[spinner103.getSelectedItemPosition()]);

            ET139=(EditText)findViewById(R.id.EditText139);
            ET139.setText(""+Timetemp.toLocaleString()); 
          
            
            ET138=(EditText)findViewById(R.id.EditText138);
            ET138.setText(""+Tiqianmiaoshu); 
            
            
            ET141=(EditText)findViewById(R.id.EditText141);
            ET141.setText(""+WeizhiX[spinner103.getSelectedItemPosition()]);        
            ET142=(EditText)findViewById(R.id.EditText142);
            ET142.setText(""+WeizhiY[spinner103.getSelectedItemPosition()]);        
            ET143=(EditText)findViewById(R.id.EditText143);
            ET143.setText(""+WeizhiH[spinner103.getSelectedItemPosition()]);        
            
            ET144=(EditText)findViewById(R.id.EditText144);
            ET144.setText(""+Guanmufenhua);        
            ET145=(EditText)findViewById(R.id.EditText145);
            ET145.setText(""+Guanmuxiejuli);        
            ET146=(EditText)findViewById(R.id.EditText146);
            ET146.setText(""+Guanmugaodijiao);     
            
            ET147=(EditText)findViewById(R.id.EditText147);
            ET147.setText(""+Zhuguanfenhua);        
            ET148=(EditText)findViewById(R.id.EditText148);
            ET148.setText(""+Ceguanfenhua);        
            ET149=(EditText)findViewById(R.id.EditText149);
            ET149.setText(""+Zhuguangaodi);       
            
            ET150=(EditText)findViewById(R.id.EditText150);
            ET150.setText(""+Biaochi);        
            ET151=(EditText)findViewById(R.id.EditText151);
            ET151.setText(""+Fangxiang);  

            
            ET152=(EditText)findViewById(R.id.EditText152);
            ET152.setText(""+Guanfangfenhua);  
            ET153=(EditText)findViewById(R.id.EditText153);
            ET153.setText(""+Fangdeshijian);            
            
            
            ET201=(EditText)findViewById(R.id.EditText201);
            ET201.setText(""+WeizhiX[0]);            
            ET202=(EditText)findViewById(R.id.EditText202);
            ET202.setText(""+WeizhiY[0]);            
            ET203=(EditText)findViewById(R.id.EditText203);
            ET203.setText(""+WeizhiH[0]);            
            
            ET204=(EditText)findViewById(R.id.EditText204);
            ET204.setText(""+WeizhiX[1]);            
            ET205=(EditText)findViewById(R.id.EditText205);
            ET205.setText(""+WeizhiY[1]);            
            ET206=(EditText)findViewById(R.id.EditText206);
            ET206.setText(""+WeizhiH[1]);            
            
            ET207=(EditText)findViewById(R.id.EditText207);
            ET207.setText(""+WeizhiX[2]);            
            ET208=(EditText)findViewById(R.id.EditText208);
            ET208.setText(""+WeizhiY[2]);            
            ET209=(EditText)findViewById(R.id.EditText209);
            ET209.setText(""+WeizhiH[2]);            
            
            ET210=(EditText)findViewById(R.id.EditText210);
            ET210.setText(""+WeizhiX[3]);            
            ET211=(EditText)findViewById(R.id.EditText211);
            ET211.setText(""+WeizhiY[3]);            
            ET212=(EditText)findViewById(R.id.EditText212);
            ET212.setText(""+WeizhiH[3]);            

            ET213=(EditText)findViewById(R.id.EditText213);
            ET213.setText(""+WeizhiX[4]);            
            ET214=(EditText)findViewById(R.id.EditText214);
            ET214.setText(""+WeizhiY[4]);            
            ET215=(EditText)findViewById(R.id.EditText215);
            ET215.setText(""+WeizhiH[4]);           

            ET216=(EditText)findViewById(R.id.EditText216);
            ET216.setText(""+WeizhiX[15]);            
            ET217=(EditText)findViewById(R.id.EditText217);
            ET217.setText(""+WeizhiY[15]);            
            ET218=(EditText)findViewById(R.id.EditText218);
            ET218.setText(""+WeizhiH[15]);              
            

            ET219=(EditText)findViewById(R.id.EditText219);
            ET219.setText(""+WeizhiX[16]);            
            ET220=(EditText)findViewById(R.id.EditText220);
            ET220.setText(""+WeizhiY[16]);            
            ET221=(EditText)findViewById(R.id.EditText221);
            ET221.setText(""+WeizhiH[16]);     
     ////////炸点

            ET222=(EditText)findViewById(R.id.EditText222);
            ET222.setText(""+WeizhiX[5]);            
            ET223=(EditText)findViewById(R.id.EditText223);
            ET223.setText(""+WeizhiY[5]);            
            ET224=(EditText)findViewById(R.id.EditText224);
            ET224.setText(""+WeizhiH[5]);    

            ET225=(EditText)findViewById(R.id.EditText225);
            ET225.setText(""+WeizhiX[6]);            
            ET226=(EditText)findViewById(R.id.EditText226);
            ET226.setText(""+WeizhiY[6]);            
            ET227=(EditText)findViewById(R.id.EditText227);
            ET227.setText(""+WeizhiH[6]);    

            ET228=(EditText)findViewById(R.id.EditText228);
            ET228.setText(""+WeizhiX[7]);            
            ET229=(EditText)findViewById(R.id.EditText229);
            ET229.setText(""+WeizhiY[7]);            
            ET230=(EditText)findViewById(R.id.EditText230);
            ET230.setText(""+WeizhiH[7]);    

            ET231=(EditText)findViewById(R.id.EditText231);
            ET231.setText(""+WeizhiX[8]);            
            ET232=(EditText)findViewById(R.id.EditText232);
            ET232.setText(""+WeizhiY[8]);            
            ET233=(EditText)findViewById(R.id.EditText233);
            ET233.setText(""+WeizhiH[8]);    

            ET234=(EditText)findViewById(R.id.EditText234);
            ET234.setText(""+WeizhiX[9]);            
            ET235=(EditText)findViewById(R.id.EditText235);
            ET235.setText(""+WeizhiY[9]);            
            ET236=(EditText)findViewById(R.id.EditText236);
            ET236.setText(""+WeizhiH[9]);    

            ET237=(EditText)findViewById(R.id.EditText237);
            ET237.setText(""+WeizhiX[10]);            
            ET238=(EditText)findViewById(R.id.EditText238);
            ET238.setText(""+WeizhiY[10]);            
            ET239=(EditText)findViewById(R.id.EditText239);
            ET239.setText(""+WeizhiH[10]);    

            ET240=(EditText)findViewById(R.id.EditText240);
            ET240.setText(""+WeizhiX[11]);            
            ET241=(EditText)findViewById(R.id.EditText241);
            ET241.setText(""+WeizhiY[11]);            
            ET242=(EditText)findViewById(R.id.EditText242);
            ET242.setText(""+WeizhiH[11]);    

            ET243=(EditText)findViewById(R.id.EditText243);
            ET243.setText(""+WeizhiX[12]);            
            ET244=(EditText)findViewById(R.id.EditText244);
            ET244.setText(""+WeizhiY[12]);            
            ET245=(EditText)findViewById(R.id.EditText245);
            ET245.setText(""+WeizhiH[12]);    

            ET246=(EditText)findViewById(R.id.EditText246);
            ET246.setText(""+WeizhiX[13]);            
            ET247=(EditText)findViewById(R.id.EditText247);
            ET247.setText(""+WeizhiY[13]);            
            ET248=(EditText)findViewById(R.id.EditText248);
            ET248.setText(""+WeizhiH[13]);

            ET249=(EditText)findViewById(R.id.EditText249);
            ET249.setText(""+WeizhiX[14]);            
            ET250=(EditText)findViewById(R.id.EditText250);
            ET250.setText(""+WeizhiY[14]);            
            ET251=(EditText)findViewById(R.id.EditText251);
            ET251.setText(""+WeizhiH[14]);    
            ET252=(EditText)findViewById(R.id.EditText252);
            ET252.setText(""+PingjunzhadianX); 
            ET253=(EditText)findViewById(R.id.EditText253);
            ET253.setText(""+PingjunzhadianY); 
            ET254=(EditText)findViewById(R.id.EditText254);
            ET254.setText(""+PingjunzhadianH); 
            
            
            spinner104=(Spinner)findViewById(R.id.Spinner104);
            
            ET401=(EditText)findViewById(R.id.EditText401);
            
            //	  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][2],
            
              ET401.setText(""+Zhenglishijian[spinner104.getSelectedItemPosition()]);                
          
            ET402=(EditText)findViewById(R.id.EditText402);
         //   spinner104=(Spinner)findViewById(R.id.Spinner104);
            ET402.setText(""+Zhengchengcedijuli[spinner104.getSelectedItemPosition()]);  
            
           // ET402.setText(""+Cedijuli);                
            ET403=(EditText)findViewById(R.id.EditText403);
           // spinner104=(Spinner)findViewById(R.id.Spinner104);
            ET403.setText(""+Zhengchengpianliufangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]);  
            
                
            ET404=(EditText)findViewById(R.id.EditText404);
            ET404.setText(""+Zhengchengjulibujiaxiuzhengliang[spinner104.getSelectedItemPosition()]);                
            ET405=(EditText)findViewById(R.id.EditText405);
            ET405.setText(""+Zhengchengfangxiangbujiaxiuzhengliang[spinner104.getSelectedItemPosition()]);                
            ET406=(EditText)findViewById(R.id.EditText406);
            ET406.setText(""+Zhengchengjulixiuzhengliang[spinner104.getSelectedItemPosition()]);                
            ET407=(EditText)findViewById(R.id.EditText407);
            ET407.setText(""+Zhengchengfangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]);    
            
            ////////////////////////
            
            ET501=(EditText)findViewById(R.id.EditText501);
            ET501.setText(""+Biaochi);          
            ET502=(EditText)findViewById(R.id.EditText502);
            ET502.setText(""+Fangxiang);          
            ET503=(EditText)findViewById(R.id.EditText503);
            ET503.setText(""+Cedijuli);          
            ET504=(EditText)findViewById(R.id.EditText504);
            ET504.setText(""+Cedifangxiang);          
            ET505=(EditText)findViewById(R.id.EditText505);
            ET505.setText(""+Julixiuzhengliang);          
            ET506=(EditText)findViewById(R.id.EditText506);
            ET506.setText(""+Fangxiangxiuzhengliang);          
            ET507=(EditText)findViewById(R.id.EditText507);
            ET507.setText(""+Kaishijuli);          
            ET508=(EditText)findViewById(R.id.EditText508);
            ET508.setText(""+Kaishifangxiang);          
            ET509=(EditText)findViewById(R.id.EditText509);
            ET509.setText(""+Kaishishejiao);          
            ET510=(EditText)findViewById(R.id.EditText510);
            ET510.setText(""+Gaojiaoxiuzhengliang);          
            ET511=(EditText)findViewById(R.id.EditText511);
            ET511.setText(""+Gaobian);          
            ET512=(EditText)findViewById(R.id.EditText512);
            ET512.setText(""+Baibian);          
            ET513=(EditText)findViewById(R.id.EditText513);
            ET513.setText(""+Shimigaoxiu);          
            ET514=(EditText)findViewById(R.id.EditText514);
            ET514.setText(""+Juligongsuanpiancha);          
            ET515=(EditText)findViewById(R.id.EditText515);
            ET515.setText(""+Fangxianggongsuanpiancha);          
            ET516=(EditText)findViewById(R.id.EditText516);
            ET516.setText(""+Gaodigongsuanpiancha);          
            ET517=(EditText)findViewById(R.id.EditText517);
            ET517.setText(""+Guanmufangxiang);          
            ET518=(EditText)findViewById(R.id.EditText518);
            ET518.setText(""+Guanmuxiejuli);        
            ET5182=(EditText)findViewById(R.id.EditText5182);
            ET5182.setText(""+Guanmupingmianjuli);  
            
            ET519=(EditText)findViewById(R.id.EditText519);
            ET519.setText(""+Guanpaojiajiao);          
            ET520=(EditText)findViewById(R.id.EditText520);
            ET520.setText(""+Shedanfeixingshijian);          
            ET521=(EditText)findViewById(R.id.EditText521);
            ET521.setText(""+Luojiao);          
            ET522=(EditText)findViewById(R.id.EditText522);
            ET522.setText(""+Luosu);          
            ET523=(EditText)findViewById(R.id.EditText523);
            ET523.setText(""+Dandaogao);          
            ET524=(EditText)findViewById(R.id.EditText524);
            ET524.setText(""+Fangxiangbi);          
            ET525=(EditText)findViewById(R.id.EditText525);
            ET525.setText(""+Xiuzhenglv);          
            ET526=(EditText)findViewById(R.id.EditText526);
            ET526.setText(""+Qiyajulixiuzhengliang);          
            ET527=(EditText)findViewById(R.id.EditText527);
            ET527.setText(""+Qiwenjulixiuzhengliang);          
            ET528=(EditText)findViewById(R.id.EditText528);
            ET528.setText(""+Yaowenjulixiuzhengliang);          
            ET529=(EditText)findViewById(R.id.EditText529);
            ET529.setText(""+Chusujulixiuzhengliang);          
            ET530=(EditText)findViewById(R.id.EditText530);
            ET530.setText(""+Haibajulixiuzhengliang);          
            ET531=(EditText)findViewById(R.id.EditText531);
            ET531.setText(""+Zongfengjulixiuzhengliang);          
            ET532=(EditText)findViewById(R.id.EditText532);
            ET532.setText(""+Weidujulixiuzhengliang);          
            ET533=(EditText)findViewById(R.id.EditText533);
            ET533.setText(""+Hengfengfangxiangxiuzhengliang);          
            ET534=(EditText)findViewById(R.id.EditText534);
            ET534.setText(""+Weidufangxiangxiuzhengliang);          
            ET535=(EditText)findViewById(R.id.EditText535);
            ET535.setText(""+Pianliufangxiangxiuzhengliang);          
            ET536=(EditText)findViewById(R.id.EditText536);
            ET536.setText(""+Julijingyanxiuzhengliang);          

            ET537=(EditText)findViewById(R.id.EditText537);
            ET537.setText(""+Fangxiangjingyanxiuzhengliang);  

            ET538=(EditText)findViewById(R.id.EditText538);
            ET538.setText(""+Yundongfangxiang);  

            ET539=(EditText)findViewById(R.id.EditText539);
            ET539.setText(""+Yundongsudupingmian);  
            
            
            
            
            
            
            
            
            
       
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
    ///////////////
    
	public void Click001(View v){
    	
    	try{
    		Jizhunshexiang=Double.parseDouble((ET101.getText().toString()));
    		Weidu=Double.parseDouble((ET102.getText().toString()));
    		ZhuguanX=Double.parseDouble((ET103.getText().toString()));
    		ZhuguanY=Double.parseDouble((ET104.getText().toString()));
    		ZhuguanH=Double.parseDouble((ET105.getText().toString()));
    		CeguanX=Double.parseDouble((ET106.getText().toString()));
    		CeguanY=Double.parseDouble((ET107.getText().toString()));
    		CeguanH=Double.parseDouble((ET108.getText().toString()));
    		ZhendiX=Double.parseDouble((ET109.getText().toString()));
    		ZhendiY=Double.parseDouble((ET110.getText().toString()));
    		ZhendiH=Double.parseDouble((ET111.getText().toString()));
    	
    	
    	
    	
    	
    	
    		Xianshishuaxin();
    	//	Timetemp.setTime(java.lang.System.nanoTime());
    		
    	//	Timetemp=new Time(java.lang.System.currentTimeMillis());
    		//Zhenglishijian[spinner104.getSelectedItemPosition()]= Timetemp.toLocaleString();
    	
    		
    		//Toast.makeText(this, ""+Timetemp.toLocaleString(), Toast.LENGTH_LONG).show();
    			
    		
    		Toast.makeText(this, "战斗队形更新录入完毕", Toast.LENGTH_LONG).show();
    	
    	
    	
    	
    	
    	
    	}catch(Exception e){
    		
    		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    	}
    	
	}
    
    
   /////////////////
	public void Click101(View v){
    	
    	try{
    		Dangqianfangfa="简易法";
    		Fangfashuzi=1;
    		Qiya=Double.parseDouble((ET112.getText().toString()));
    		Qiwen=Double.parseDouble((ET113.getText().toString()));
    		Fengxiang=Double.parseDouble((ET114.getText().toString()));
    		Fengsu=Double.parseDouble((ET115.getText().toString()));
    		
    		
    		
    		Xianshishuaxin();
    		
    		Toast.makeText(this, "当前为简易法", Toast.LENGTH_LONG).show();
    		
    	
    	}catch(Exception e){
    		
    		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    	}
    	
	}
   /////////////////////////
	/*
	
	
	
	Jingmi1shijian,Jingmi1gaocheng,Jingmi1dimian,Jingmi1_02,Jingmi1_04,Jingmi1_08,Jingmi1_12
	,Jingmi1_16,Jingmi1_20,Jingmi1_24,Jingmi1_30,Dangqianfangfa,Mubiaoleixing,Zhenglishijian
	
		,Qixiangzhangaocheng,Dimianwenpian
	,Wenpian200,Fengxiang200,Fengsu200
	,Wenpian400,Fengxiang400,Fengsu400
	,Wenpian800,Fengxiang800,Fengsu800
	,Wenpian1200,Fengxiang1200,Fengsu1200
	,Wenpian1600,Fengxiang1600,Fengsu1600
	,Wenpian2000,Fengxiang2000,Fengsu2000
	,Wenpian2400,Fengxiang2400,Fengsu2400
	,Wenpian3000,Fengxiang3000,Fengsu3000
	
	
	*/
	
	
public void Click102(View v){
    	
    	try{
    		
    		long Temp1,Temp2,Temp3,Temp4,Temp5;
    		Dangqianfangfa="精密法";
    		Fangfashuzi=2;
    		Jingmi1shijian=(ET116.getText().toString());
    		Jingmi1gaocheng=(ET117.getText().toString());
    		Jingmi1dimian=(ET118.getText().toString());
    		Jingmi1_02=(ET119.getText().toString());
    		Jingmi1_04=(ET120.getText().toString());
    		Jingmi1_08=(ET121.getText().toString());
    		Jingmi1_12=(ET122.getText().toString());
    		Jingmi1_16=(ET123.getText().toString());
    		Jingmi1_20=(ET124.getText().toString());
    		Jingmi1_24=(ET125.getText().toString());
    		Jingmi1_30=(ET126.getText().toString());
    		
    		Qixiangzhangaocheng=Double.parseDouble(Jingmi1gaocheng);
    		
    		////地面字符串处理
    		Temp1=Long.parseLong(Jingmi1dimian);
    		 Temp2 = Temp1 / 100;
		        if (Temp1<(Temp2 * 100))
		        {
	            Temp2 = Temp2 - 1;
		        }
    		
		        Temp3 = Temp1 - Temp2 * 100;
		        
		        
		        if (Temp2 >= 500) {
	            Temp2 = Temp2 - 500;
	            Temp2 = 0 - Temp2;
		        }
		        Qiyapianchadimian=Temp2;
		     Qiyapiancha=Qiyapianchadimian;
		      //  Toast.makeText(this, ""+Double.toString( Qiyapianchadimian), Toast.LENGTH_LONG).show();
		     /////////////200m   
	/*	        
		        Temp1=Long.parseLong(Jingmi1_02);
	    	
			        
			        Temp2 = Temp1 / 10000;
			                if (Temp1 < Temp2 * 10000){
			                    Temp2 = Temp2 - 1;
			                }
			                Temp3 = (Temp1 - Temp2 * 10000) / 100;


			                if ((Temp1 - Temp2 * 10000) < Temp3 * 100){
			                    Temp3 = Temp3 - 1;
			                }



			                Temp4 = Temp1 - Temp2 * 10000 - Temp3 * 100;


			                if (Temp2 >= 50) {
			                    Temp2 = Temp2 - 50;
			                    Temp2 = 0 - Temp2;
			                }


			                if (Temp2 == -49){

			                    Temp2 = 0;
			                }

			                if ((Temp3 == 99) || (Temp4 == 99)){
			                    Temp3 = 0;
			                    Temp4 = 0;
			                }
*/
		      //public double Jingmi1Canshu[][][]=new double[40][5][5] ;
		     Qixiangtemp.Chuli(Jingmi1_02);
		        
			              Wenpian200 = Qixiangtemp.Ddwenpian;
			               Fengxiang200 = Qixiangtemp.Ddfengxiang;
			              Fengsu200 = Qixiangtemp.Ddfengsu;
			              
			              Jingmi1canshu[2][1]=Wenpian200 ;
			              Jingmi1canshu[2][2]=Fengxiang200 ;
			              Jingmi1canshu[2][3]=Fengsu200 ;
				              
			              
			              
	//////////////////////		                
			 //       	Toast.makeText(this, ""+Double.toString(Wenpian200), Toast.LENGTH_LONG).show();
			//         	Toast.makeText(this, ""+Double.toString(Fengxiang200), Toast.LENGTH_LONG).show();
			 //          	Toast.makeText(this, ""+Double.toString(Fengsu200), Toast.LENGTH_LONG).show();
			       
			        
			 		     Qixiangtemp.Chuli(Jingmi1_04);
					        
			              Wenpian400 = Qixiangtemp.Ddwenpian;
			               Fengxiang400 = Qixiangtemp.Ddfengxiang;
			              Fengsu400 = Qixiangtemp.Ddfengsu; 
			              Jingmi1canshu[4][1]=Wenpian400 ;
			              Jingmi1canshu[4][2]=Fengxiang400 ;
			              Jingmi1canshu[4][3]=Fengsu400 ;
				              
			   ////////////////////////////////
				 		     Qixiangtemp.Chuli(Jingmi1_08);     
				              Wenpian800 = Qixiangtemp.Ddwenpian;
				               Fengxiang800 = Qixiangtemp.Ddfengxiang;
				              Fengsu800 = Qixiangtemp.Ddfengsu;   
				              Jingmi1canshu[8][1]=Wenpian800 ;
				              Jingmi1canshu[8][2]=Fengxiang800 ;
				              Jingmi1canshu[8][3]=Fengsu800 ;
					              
				              
				              
			  //////////////////////////////            				 		 
				              Qixiangtemp.Chuli(Jingmi1_12);     
				              Wenpian1200 = Qixiangtemp.Ddwenpian;
				               Fengxiang1200 = Qixiangtemp.Ddfengxiang;
				              Fengsu1200 = Qixiangtemp.Ddfengsu;      
				              Jingmi1canshu[12][1]=Wenpian1200 ;
				              Jingmi1canshu[12][2]=Fengxiang1200 ;
				              Jingmi1canshu[12][3]=Fengsu1200 ;
					              
				              
				              
				              
				              
			  /////////////////////////////            				 		 
				              Qixiangtemp.Chuli(Jingmi1_16);     
				              Wenpian1600 = Qixiangtemp.Ddwenpian;
				               Fengxiang1600 = Qixiangtemp.Ddfengxiang;
				              Fengsu1600 = Qixiangtemp.Ddfengsu;   
				              Jingmi1canshu[16][1]=Wenpian1600 ;
				              Jingmi1canshu[16][2]=Fengxiang1600 ;
				              Jingmi1canshu[16][3]=Fengsu1600 ;
					              
				              
				              
			  /////////////////////////////            				 		 
				              Qixiangtemp.Chuli(Jingmi1_20);     
				              Wenpian2000 = Qixiangtemp.Ddwenpian;
				               Fengxiang2000 = Qixiangtemp.Ddfengxiang;
				              Fengsu2000 = Qixiangtemp.Ddfengsu;      
				              Jingmi1canshu[20][1]=Wenpian2000 ;
				              Jingmi1canshu[20][2]=Fengxiang2000 ;
				              Jingmi1canshu[20][3]=Fengsu2000 ;
					              
				              
				              /////////////////////////////            				 		 
				              Qixiangtemp.Chuli(Jingmi1_24);     
				              Wenpian2400 = Qixiangtemp.Ddwenpian;
				               Fengxiang2400 = Qixiangtemp.Ddfengxiang;
				              Fengsu2400 = Qixiangtemp.Ddfengsu;     
				              Jingmi1canshu[24][1]=Wenpian2400 ;
				              Jingmi1canshu[24][2]=Fengxiang2400 ;
				              Jingmi1canshu[24][3]=Fengsu2400 ;
			  /////////////////////////////            				 		 
				              Qixiangtemp.Chuli(Jingmi1_30);     
				              Wenpian3000 = Qixiangtemp.Ddwenpian;
				               Fengxiang3000 = Qixiangtemp.Ddfengxiang;
				              Fengsu3000 = Qixiangtemp.Ddfengsu;       
				              Jingmi1canshu[30][1]=Wenpian3000 ;
				              Jingmi1canshu[30][2]=Fengxiang3000 ;
				              Jingmi1canshu[30][3]=Fengsu3000 ;
			              
			              
			              
			              
			              
			        
			        
    		/*
    		 temp = TextBox3.Text

    			        temp2 = temp / 100
    			        If (temp < temp2 * 100) Then
    			            temp2 = temp2 - 1
    			        End If
    			        temp3 = temp - temp2 * 100

    			        If (temp2 >= 500) Then
    			            temp2 = temp2 - 500
    			            temp2 = 0 - temp2
    			        End If

    			        DiMianQiYaPianCha = temp2

    			        If (temp3 >= 50) Then
    			            temp3 = temp3 - 50
    			            temp3 = 0 - temp3
    			        End If

    			        DiMianQiWenPianCha = temp
    		
    		*/
    		
				          	Xianshishuaxin();
    		
    		
				              Toast.makeText(this, "当前为1111气象精密法", Toast.LENGTH_LONG).show();
    		
    		
    	
    	}catch(Exception e){
    		
    		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    	}
    
	}

public class Qixiang1111xianshiyong

{   public long Temo1,Temo2,Temo3,Temo4,Temo5;
    public double Ddwenpian,Ddfengxiang,Ddfengsu;

   
/////////////200m   
  public void Chuli(String Shuru){
   Temo1=Long.parseLong(Shuru);

       
       Temo2 = Temo1 / 10000;
               if (Temo1 < Temo2 * 10000){
                   Temo2 = Temo2 - 1;
               }
               Temo3 = (Temo1 - Temo2 * 10000) / 100;


               if ((Temo1 - Temo2 * 10000) < Temo3 * 100){
                   Temo3 = Temo1 - 1;
               }



               Temo4 = Temo1 - Temo2 * 10000 - Temo3 * 100;


               if (Temo2 >= 50) {
                   Temo2 = Temo2 - 50;
                   Temo2 = 0 - Temo2;
               }


               if (Temo2 == -49){

                   Temo2 = 0;
               }

               if ((Temo3 == 99) || (Temo4 == 99)){
                   Temo3 = 0;
                   Temo4 = 0;
               }

               Ddwenpian = Temo2;
               Ddfengxiang = Temo3 * 100;
               Ddfengsu = Temo4;
             //  Toast.makeText(Zhuyuanjisuan.this, ""+Double.toString(333.000), Toast.LENGTH_LONG).show();
   }

};;
public void Click103(View v){
	
	try{
		Dangqianfangfa="成果法";
		Fangfashuzi=3;
		
      //  spinner102=(Spinner)findViewById(R.id.Spinner102);
	//	Shiyongchengguobianhao=Integer.parseInt(spinner102.getItemAtPosition(spinner102.getSelectedItemPosition()).toString());
		
		
			
		Xianshishuaxin();
		
		Toast.makeText(this, "当前为成果法,使用成果"+spinner102.getItemAtPosition(spinner102.getSelectedItemPosition()).toString(), Toast.LENGTH_LONG).show();
		
		
	}catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
	
}
////////////////录入战斗队形

public void Click104(View v){
	
	try{
	
		Chusu=Double.parseDouble((ET128.getText().toString()));
		Yaowen=Double.parseDouble((ET129.getText().toString()));
		Julijingyanxiuzhengliang=Double.parseDouble((ET130.getText().toString()));
		Fangxiangjingyanxiuzhengliang=Double.parseDouble((ET131.getText().toString()));
    	
			
		Xianshishuaxin();
		
		Toast.makeText(this, "弹道条件更新录入完毕", Toast.LENGTH_LONG).show();
	    
		
	}catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
	
}

//////卡时

public void Click199(View v){

try{

	
	 spinner103=(Spinner)findViewById(R.id.Spinner103);

		Haomiao[spinner103.getSelectedItemPosition()]=java.lang.System.currentTimeMillis();
		//java.lang.System.currentTimeMillis()
	
		Xianshishuaxin();
	
	Toast.makeText(this, spinner103.getItemAtPosition(spinner103.getSelectedItemPosition()).toString()+"时间录入完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}
}


public void Click198(View v){

try{

	
        Tiqianmiaoshu=Long.parseLong((ET138.getText().toString()));
	
		Xianshishuaxin();
	
	Toast.makeText(this, "提前秒数录入完毕，注意提前秒数须大于射弹飞行时间", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}
}

//////录时

public void Click200(View v){
	
	try{
	
		
		 spinner103=(Spinner)findViewById(R.id.Spinner103);
	
			Haomiao[spinner103.getSelectedItemPosition()]=Long.parseLong((ET140.getText().toString()));
				
		
			Xianshishuaxin();
		
		Toast.makeText(this, spinner103.getItemAtPosition(spinner103.getSelectedItemPosition()).toString()+"时间修改完毕", Toast.LENGTH_LONG).show();
		
		
			
		
	}catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
}












//////////直坐录入

public void Click201(View v){
	
	try{
	
		
		 spinner103=(Spinner)findViewById(R.id.Spinner103);
	
			WeizhiX[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET141.getText().toString()));
			WeizhiY[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET142.getText().toString()));
			WeizhiH[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET143.getText().toString()));
			
		
			Xianshishuaxin();
		
		Toast.makeText(this, spinner103.getItemAtPosition(spinner103.getSelectedItemPosition()).toString()+"直坐录入完毕", Toast.LENGTH_LONG).show();
		
		
			
		
	}catch(Exception e){
		
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
}
//////////直坐录入

//////////激光测距

public void Clickceju(View v){
//	Intent intent=new Intent(Menuofmian.this,MainActivity.class);
//intent.setClass(Menuofmian.this,MainActivity.class);
 //  startActivity(intent);
/*	Intent intent=new Intent(Zhuyuanjisuan.this,DeviceScanActivity.class);

//	Intent intent=new Intent(Menuofmian.this,DeviceControlActivity.class);
	
    startActivity(intent);*/
	
	
	
	//finish();
	
}

//////////激光测距



//////////激光测距

public void Clickduquzuobiao(View v){
//Intent intent=new Intent(Menuofmian.this,MainActivity.class);
//intent.setClass(Menuofmian.this,MainActivity.class);
//  startActivity(intent);
try{
	SharedPreferences spf=getSharedPreferences("Art",Context.MODE_WORLD_WRITEABLE);  
	   	
	   
	SharedPreferences.Editor edit=spf.edit();

	//edit.putString("Weidumubiao", ""+Weidumubiao);
//	edit.putString("Jingdumubiao", ""+Jingdumubiao);
	//edit.putString("Xmubiao", ""+Xmubiao);
//	edit.putString("Ymubiao", ""+Ymubiao);
//	edit.putString("Hmubiao", ""+Hmubiao);

   	
	((EditText)findViewById(R.id.EditText141)).setText(spf.getString("Xmubiao","00000"));
	((EditText)findViewById(R.id.EditText142)).setText(spf.getString("Ymubiao","00000"));
	((EditText)findViewById(R.id.EditText143)).setText(spf.getString("Hmubiao","00000"));


}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}


//finish();

}

//////////激光测距








public void Click202(View v){

try{

	
	 spinner103=(Spinner)findViewById(R.id.Spinner103);

	//	WeizhiX[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET141.getText().toString()));
	//	WeizhiY[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET142.getText().toString()));
	//	WeizhiH[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET143.getText().toString()));
	Guanmufenhua=	Double.parseDouble((ET144.getText().toString()));
	Guanmuxiejuli=Double.parseDouble((ET145.getText().toString()));
	Guanmugaodijiao=Double.parseDouble((ET146.getText().toString()));
	WeizhiX[spinner103.getSelectedItemPosition()]=Use.ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Guanmuxiejuli, (Jizhunshexiang+3000-Guanmufenhua), Guanmugaodijiao);
	WeizhiY[spinner103.getSelectedItemPosition()]=Use.ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Guanmuxiejuli, (Jizhunshexiang+3000-Guanmufenhua), Guanmugaodijiao);
	WeizhiH[spinner103.getSelectedItemPosition()]=Use.ZhengyunsuanBh(ZhuguanX, ZhuguanY, ZhuguanH, Guanmuxiejuli, (Jizhunshexiang+3000-Guanmufenhua), Guanmugaodijiao);
	
	Xianshishuaxin();
	Toast.makeText(this, spinner103.getItemAtPosition(spinner103.getSelectedItemPosition()).toString()+"单观录入完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}

////////////双观录入



public void Click203(View v){

try{

	
	 spinner103=(Spinner)findViewById(R.id.Spinner103);

	//	WeizhiX[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET141.getText().toString()));
	//	WeizhiY[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET142.getText().toString()));
	//	WeizhiH[spinner103.getSelectedItemPosition()]=Double.parseDouble((ET143.getText().toString()));
	Zhuguanfenhua=	Double.parseDouble((ET147.getText().toString()));
	Ceguanfenhua=Double.parseDouble((ET148.getText().toString()));
	Zhuguangaodi=Double.parseDouble((ET149.getText().toString()));
	
	WeizhiX[spinner103.getSelectedItemPosition()]=Use.ShuangGuanMuBiaoX(Jizhunshexiang, ZhuguanX, ZhuguanY, ZhuguanH, CeguanX, CeguanY, CeguanH, Zhuguanfenhua, Ceguanfenhua, Zhuguangaodi);
	WeizhiY[spinner103.getSelectedItemPosition()]=Use.ShuangGuanMuBiaoY(Jizhunshexiang, ZhuguanX, ZhuguanY, ZhuguanH, CeguanX, CeguanY, CeguanH, Zhuguanfenhua, Ceguanfenhua, Zhuguangaodi);
	WeizhiH[spinner103.getSelectedItemPosition()]=Use.ShuangGuanMuBiaoH(Jizhunshexiang, ZhuguanX, ZhuguanY, ZhuguanH, CeguanX, CeguanY, CeguanH, Zhuguanfenhua, Ceguanfenhua, Zhuguangaodi);
	
	Xianshishuaxin();
	Toast.makeText(this, spinner103.getItemAtPosition(spinner103.getSelectedItemPosition()).toString()+"双观录入完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}



/////////////////////决定诸元



public void Click204(View v){

try{

	  ////////////静止目标
	  MubiaoX=WeizhiX[0];
	  MubiaoY=WeizhiY[0];
	  MubiaoH=WeizhiH[0];

	  WeizhiX[16]=MubiaoX;
	  WeizhiY[16]=MubiaoY;
	  WeizhiH[16]=MubiaoH;
		  
	  
	  
	int TempIII;
		for(TempIII=0;TempIII<20;TempIII=TempIII+1)
		{Jdzy.Jisuanzhuyuan();}
	
	Xianshishuaxin();
	Toast.makeText(this, "静止目标诸元计算完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}


public void Click214(View v){

try{

	  ////////////提前时间阻击点目标
	

	
	  MubiaoX=WeizhiX[4]+Tiqianmiaoshu*1000/(Haomiao[3]-Haomiao[2])*(WeizhiX[3]-WeizhiX[2]);
	  MubiaoY=WeizhiY[4]+Tiqianmiaoshu*1000/(Haomiao[3]-Haomiao[2])*(WeizhiY[3]-WeizhiY[2]);
	  MubiaoH=WeizhiH[4]+Tiqianmiaoshu*1000/(Haomiao[3]-Haomiao[2])*(WeizhiH[3]-WeizhiH[2]);
	  WeizhiX[16]=MubiaoX;
	  WeizhiY[16]=MubiaoY;
	  WeizhiH[16]=MubiaoH;
		  
	  
	
		int TempIII;
		for(TempIII=0;TempIII<20;TempIII=TempIII+1)
		{Jdzy.Jisuanzhuyuan();}
		Yundongfangxiang=Use.NiyunsuanFAB(WeizhiX[2], WeizhiY[2], WeizhiH[2], WeizhiX[3], WeizhiY[3], WeizhiH[3]);
		Cesuweiyi=Use.NiyunsuanDAB(WeizhiX[2], WeizhiY[2], WeizhiH[2], WeizhiX[3], WeizhiY[3], WeizhiH[3]);
		Yundongsudupingmian=Cesuweiyi*1000/(Haomiao[3]-Haomiao[2]);	
		WeizhiX[15]=MubiaoX-Shedanfeixingshijian*1000/(Haomiao[3]-Haomiao[2])*(WeizhiX[3]-WeizhiX[2]);
		WeizhiY[15]=MubiaoY-Shedanfeixingshijian*1000/(Haomiao[3]-Haomiao[2])*(WeizhiY[3]-WeizhiY[2]);
		WeizhiH[15]=MubiaoH-Shedanfeixingshijian*1000/(Haomiao[3]-Haomiao[2])*(WeizhiH[3]-WeizhiH[2]);
		Guanfangfenhua=3000+Jizhunshexiang-Use.NiyunsuanFAB(ZhuguanX, ZhuguanY, ZhuguanH, WeizhiX[15], WeizhiY[15], WeizhiH[15]);
		 if(Guanfangfenhua>6000){Guanfangfenhua=Guanfangfenhua-6000;}
		  if(Guanfangfenhua<0){Guanfangfenhua=Guanfangfenhua+6000;}
		

		  Xianshishuaxin();

	Fangdemiaoshu=Use.NiyunsuanDAB(WeizhiX[4], WeizhiY[4], WeizhiH[4], WeizhiX[15], WeizhiY[15], WeizhiH[15])/Yundongsudupingmian;
	Fangdehaomiaoshu=	Haomiao[4]+(long)(Fangdemiaoshu*1000);
	Timetemp=new Time(Fangdehaomiaoshu);
	Fangdeshijian=Timetemp.toLocaleString();
	
	Xianshishuaxin();
	Toast.makeText(this, "提前时间阻击点目标诸元计算完毕", Toast.LENGTH_LONG).show();
	
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}



public void Click224(View v){

try{

	  ////////////实有阻击点目标
	

	

	  MubiaoX=WeizhiX[1];
	  MubiaoY=WeizhiY[1];
	  MubiaoH=WeizhiH[1];
	  WeizhiX[16]=MubiaoX;
	  WeizhiY[16]=MubiaoY;
	  WeizhiH[16]=MubiaoH;
		  
	
		int TempIII;
		for(TempIII=0;TempIII<20;TempIII=TempIII+1)
		{Jdzy.Jisuanzhuyuan();}
		Yundongfangxiang=Use.NiyunsuanFAB(WeizhiX[2], WeizhiY[2], WeizhiH[2], WeizhiX[3], WeizhiY[3], WeizhiH[3]);
		Cesuweiyi=Use.NiyunsuanDAB(WeizhiX[2], WeizhiY[2], WeizhiH[2], WeizhiX[3], WeizhiY[3], WeizhiH[3]);
		Yundongsudupingmian=Cesuweiyi*1000/(Haomiao[3]-Haomiao[2]);	
		WeizhiX[15]=MubiaoX-Shedanfeixingshijian*1000/(Haomiao[3]-Haomiao[2])*(WeizhiX[3]-WeizhiX[2]);
		WeizhiY[15]=MubiaoY-Shedanfeixingshijian*1000/(Haomiao[3]-Haomiao[2])*(WeizhiY[3]-WeizhiY[2]);
		WeizhiH[15]=MubiaoH-Shedanfeixingshijian*1000/(Haomiao[3]-Haomiao[2])*(WeizhiH[3]-WeizhiH[2]);
		Guanfangfenhua=3000+Jizhunshexiang-Use.NiyunsuanFAB(ZhuguanX, ZhuguanY, ZhuguanH, WeizhiX[15], WeizhiY[15], WeizhiH[15]);
		 if(Guanfangfenhua>6000){Guanfangfenhua=Guanfangfenhua-6000;}
		  if(Guanfangfenhua<0){Guanfangfenhua=Guanfangfenhua+6000;}

	Xianshishuaxin();
	
	

	
	
	Fangdemiaoshu=Use.NiyunsuanDAB(WeizhiX[4], WeizhiY[4], WeizhiH[4], WeizhiX[15], WeizhiY[15], WeizhiH[15])/Yundongsudupingmian;
	Fangdehaomiaoshu=	Haomiao[4]+(long)(Fangdemiaoshu*1000);
	Timetemp=new Time(Fangdehaomiaoshu);
	Fangdeshijian=Timetemp.toLocaleString();
	Xianshishuaxin();	
	Toast.makeText(this, "实有阻击点目标诸元计算完毕", Toast.LENGTH_LONG).show();
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}

////////////整理成果
public void Click301(View v){

try{
  int Tempzhadianshu;
  
  Tempzhadianshu=0;
	PingjunzhadianX=0;
	PingjunzhadianY=0;
	PingjunzhadianH=0;
	if (Ch01.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[5];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[5];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[5];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch02.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[6];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[6];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[6];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch03.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[7];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[7];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[7];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch04.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[8];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[8];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[8];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch05.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[9];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[9];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[9];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch06.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[10];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[10];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[10];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch07.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[11];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[11];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[11];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch08.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[12];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[12];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[12];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch09.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[13];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[13];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[13];
	Tempzhadianshu=Tempzhadianshu+1;
	}	
	if (Ch10.isChecked())
	{PingjunzhadianX=PingjunzhadianX+WeizhiX[14];
	PingjunzhadianY=PingjunzhadianY+WeizhiY[14];
	PingjunzhadianH=PingjunzhadianH+WeizhiH[14];
	Tempzhadianshu=Tempzhadianshu+1;
	}
	PingjunzhadianX=PingjunzhadianX/Tempzhadianshu;
	PingjunzhadianY=PingjunzhadianY/Tempzhadianshu;
	PingjunzhadianH=PingjunzhadianH/Tempzhadianshu;
	
	//Zhenglishijian[spinner104.getSelectedItemPosition()]=this.g;
	Zhengchengcedijuli[spinner104.getSelectedItemPosition()]=Use.NiyunsuanDAB(ZhendiX, ZhendiY, ZhendiH, PingjunzhadianX, PingjunzhadianY, PingjunzhadianH);
	
	Zhengchengpianliufangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]=Pianliufangxiangxiuzhengliang;
	//Zhengchengjulibujiaxiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET404.getText().toString());
	//Zhengchengfangxiangbujiaxiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET405.getText().toString());
	Zhengchengjulixiuzhengliang[spinner104.getSelectedItemPosition()]
			=Jdzy.Fanchajuli(spinner101.getSelectedItemPosition()
					,(Biaochi-(PingjunzhadianH-ZhendiH)/10*Shimigaoxiu) )
					-Zhengchengcedijuli[spinner104.getSelectedItemPosition()];
	
	Zhengchengcedifangxiang=Use.NiyunsuanFAB(ZhendiX, ZhendiY, ZhendiH, PingjunzhadianX, PingjunzhadianY, PingjunzhadianH);
	
	Zhengchengfangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]=Kaishifangxiang-Zhengchengcedifangxiang;
	Zhengchengjulibujiaxiuzhengliang[spinner104.getSelectedItemPosition()]=Zhengchengjulixiuzhengliang[spinner104.getSelectedItemPosition()]-Julixiuzhengliang;
	Zhengchengfangxiangbujiaxiuzhengliang[spinner104.getSelectedItemPosition()]=Zhengchengfangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]-Fangxiangxiuzhengliang;
	//
	
	
	  
	   // Timetemp.toLocaleString();
	    	//ttt=timea.toLocaleString();
	//Timetemp.setTime(java.lang.System.nanoTime());
	//Zhenglishijian[spinner104.getSelectedItemPosition()]= Timetemp.toLocaleString();
	
	Timetemp=new Time(java.lang.System.currentTimeMillis());
	Zhenglishijian[spinner104.getSelectedItemPosition()]= Timetemp.toLocaleString();
	
	Xianshishuaxin();
	Toast.makeText(this, "成果"+spinner104.getItemAtPosition(spinner104.getSelectedItemPosition()).toString()+"整理完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}






public void Click402(View v){

try{

	 
	

	Xianshishuaxin();
	Toast.makeText(this, "成果"+ spinner104.getItemAtPosition(spinner104.getSelectedItemPosition()).toString()+"显示完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}

public void Click401(View v){

try{

	//WeizhiX[spinner104.getSelectedItemPosition()]=Double.parseDouble((ET401.getText().toString()));
	
	Zhenglishijian[spinner104.getSelectedItemPosition()]=((ET401.getText().toString()));
	Zhengchengcedijuli[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET402.getText().toString());
	Zhengchengpianliufangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET403.getText().toString());
	Zhengchengjulibujiaxiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET404.getText().toString());
	Zhengchengfangxiangbujiaxiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET405.getText().toString());
	Zhengchengjulixiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET406.getText().toString());
	Zhengchengfangxiangxiuzhengliang[spinner104.getSelectedItemPosition()]=Double.parseDouble(ET407.getText().toString());
	
	
	
	
	
	Xianshishuaxin();
	Toast.makeText(this, "成果"+ spinner104.getItemAtPosition(spinner104.getSelectedItemPosition()).toString()+"修改完毕", Toast.LENGTH_LONG).show();
	
	
		
	
}catch(Exception e){
	
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
}

}




public class Juedingzhuyuan

{   
    
    
    ;

   
/////////////200m   
  public void Jisuanzhuyuan(){

	  
	  
	  
	 Cedijuli=Use.NiyunsuanDAB(ZhendiX, ZhendiY, ZhendiH, MubiaoX, MubiaoY, MubiaoH); 
	 Cedifangxiang=Use.NiyunsuanFAB(ZhendiX, ZhendiY, ZhendiH, MubiaoX, MubiaoY, MubiaoH); 
	Paomugaocha=MubiaoH-ZhendiH;	
	//////简易法
	  if (Fangfashuzi==1)
	  {
		  Qiyajulixiuzhengliang=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][0],
				  Cedijuli/1000)* (Qiya -  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][11]);
		  
		  Qiwenjulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][0],
				  Cedijuli/1000)* (Qiwen -  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][11]);
		  
		  Yaowenjulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][0],
				  Cedijuli/1000)* (Yaowen -  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][11]);
		  Chusujulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][0],
				  Cedijuli/1000)* (Chusu / 0.1);
		  
		  Zongfengjulixiuzhengliang=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][0],
				  Cedijuli/1000) * Fengsu * Math.cos((Cedifangxiang - Fengxiang) / 6000 * 2 * Math.PI);
		  
		  Hengfengfangxiangxiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][0],
				  Cedijuli/1000)* Fengsu * Math.sin((Cedifangxiang - Fengxiang) / 6000 * 2 * Math.PI);
		  
		  Pianliufangxiangxiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][0],
				  Cedijuli/1000);
		  
		  
		  Julixiuzhengliang=Qiyajulixiuzhengliang + Qiwenjulixiuzhengliang + Yaowenjulixiuzhengliang + Chusujulixiuzhengliang + Zongfengjulixiuzhengliang+Julijingyanxiuzhengliang ;
		Fangxiangxiuzhengliang=Hengfengfangxiangxiuzhengliang+Pianliufangxiangxiuzhengliang+Fangxiangjingyanxiuzhengliang;
		Kaishijuli=Cedijuli+Julixiuzhengliang;
		Kaishifangxiang=Cedifangxiang+Fangxiangxiuzhengliang;
		
		 Chulimingxi();
	  }
	  
	  
		//////精密法
	 
	  if (Fangfashuzi==2)
	  {
		//  Julixiuzhengliang=Qiyajulixiuzhengliang + Qiwenjulixiuzhengliang + Yaowenjulixiuzhengliang + Chusujulixiuzhengliang + Zongfengjulixiuzhengliang+Julijingyanxiuzhengliang ;
		//Fangxiangxiuzhengliang=Hengfengfangxiangxiuzhengliang+Pianliufangxiangxiuzhengliang+Fangxiangjingyanxiuzhengliang;
		Kaishijuli=Cedijuli+Julixiuzhengliang;
		Kaishifangxiang=Cedifangxiang+Fangxiangxiuzhengliang;
		
		 Chulimingxi();
		  
		  
		  Qiyajulixiuzhengliang=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][1][0],
				  Cedijuli/1000)* (Qiyapianchadimian);
		  
		  Qiwenjulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][2][0],
				  Cedijuli/1000)* (Qiwenpiancha);
		  
		  Yaowenjulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][0],
				  Cedijuli/1000)* (Yaowen -  Dandaoyinshu[spinner101.getSelectedItemPosition()][3][11]);
		  Chusujulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][4][0],
				  Cedijuli/1000)* (Chusu / 0.1);
		  Haibajulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][5][0],
				  Cedijuli/1000)* ((ZhendiH - Dandaoyinshu[spinner101.getSelectedItemPosition()][5][11])/ 100);
		  
		  Zongfengjulixiuzhengliang=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][6][0],
				  Cedijuli/1000) * Fengsu * Math.cos((Cedifangxiang - Fengxiang) / 6000 * 2 * Math.PI);
		  Weidujulixiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][7][0],
				  Cedijuli/1000) * Math.cos(Weidu / 360 * 2 * Math.PI) * Math.sin(Cedifangxiang / 6000 * 2 * Math.PI);
		  Hengfengfangxiangxiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][8][0],
				  Cedijuli/1000)* Fengsu * Math.sin((Cedifangxiang - Fengxiang) / 6000 * 2 * Math.PI);
		  Weidufangxiangxiuzhengliang = -0.06963465 * Shedanfeixingshijian * Math.sin(Weidu / 360 * 2 * Math.PI) 
				  +9.8 / 6 / Cedijuli * 0.06963465 * Shedanfeixingshijian * Shedanfeixingshijian  * Shedanfeixingshijian  
				  * Math.cos(Weidu / 360 * 2 * Math.PI) * Math.cos(Cedifangxiang / 6000 * 2 * Math.PI);
		 //WeiDu_FangXiangXiuZhengLiang = -0.06963465 * FeiXingShiJian * Math.Sin(WeiDu / 360 * 2 * Math.PI) + 9.8 / 6 / CeDiJuli * 0.06963465 * FeiXingShiJian * FeiXingShiJian * FeiXingShiJian * Math.Cos(WeiDu / 360 * 2 * Math.PI) * Math.Cos(CeDiFangXiang / 6000 * 2 * Math.PI)
				  
				  Pianliufangxiangxiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][0],
				  Cedijuli/1000);
		  
		  
		  Julixiuzhengliang=Qiyajulixiuzhengliang + Qiwenjulixiuzhengliang 
				   + Yaowenjulixiuzhengliang + Chusujulixiuzhengliang +Haibajulixiuzhengliang
				  + Zongfengjulixiuzhengliang+Weidujulixiuzhengliang+Julijingyanxiuzhengliang ;
		Fangxiangxiuzhengliang=Hengfengfangxiangxiuzhengliang+Weidufangxiangxiuzhengliang
				+Pianliufangxiangxiuzhengliang+Fangxiangjingyanxiuzhengliang;
		Kaishijuli=Cedijuli+Julixiuzhengliang;
		Kaishifangxiang=Cedifangxiang+Fangxiangxiuzhengliang;
		
		 Chulimingxi();
		 if ((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 200)) 
		 {
			 Qiwenpiancha =  Jingmi1canshu[2][1];
                     Fengxiang = Jingmi1canshu[2][2];
                     Fengsu=Jingmi1canshu[2][3];
			 
			 
		 }
		 
		 //200-400
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 200))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 400)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(200, 400, Jingmi1canshu[2][1], Jingmi1canshu[4][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(200, 400, Jingmi1canshu[2][2], Jingmi1canshu[4][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(200, 400, Jingmi1canshu[2][3], Jingmi1canshu[4][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
			 
			 
		 }
		 //400-800
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 400))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 800)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(400, 800, Jingmi1canshu[4][1], Jingmi1canshu[8][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(400, 800, Jingmi1canshu[4][2], Jingmi1canshu[8][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(400, 800, Jingmi1canshu[4][3], Jingmi1canshu[8][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
			 
			 
		 }
		 //800-1200
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 800))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 1200)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(800, 1200, Jingmi1canshu[8][1], Jingmi1canshu[12][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(800, 1200, Jingmi1canshu[8][2], Jingmi1canshu[12][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(800, 1200, Jingmi1canshu[8][3], Jingmi1canshu[12][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
			 
			 
		 }
		 //1200-1600
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 1200))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 1600)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(1200, 1600, Jingmi1canshu[12][1], Jingmi1canshu[16][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(1200, 1600, Jingmi1canshu[12][2], Jingmi1canshu[16][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(1200, 1600, Jingmi1canshu[12][3], Jingmi1canshu[16][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
			 
			 
		 }
		 //1600-2000
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 1600))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 2000)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(1600, 2000, Jingmi1canshu[16][1], Jingmi1canshu[20][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(1600, 2000, Jingmi1canshu[16][2], Jingmi1canshu[20][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(1600, 2000, Jingmi1canshu[16][3], Jingmi1canshu[20][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
		 }
		 //2000-2400
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 2000))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 2400)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(2000, 2400, Jingmi1canshu[20][1], Jingmi1canshu[24][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(2000, 2400, Jingmi1canshu[20][2], Jingmi1canshu[24][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(2000, 2400, Jingmi1canshu[20][3], Jingmi1canshu[24][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
		 }
		 //2400-3000
		 if (((Dandaogao + ZhendiH) > (Qixiangzhangaocheng + 2400))
				 &&((Dandaogao + ZhendiH) <= (Qixiangzhangaocheng + 3000)) )
		 {
			 Qiwenpiancha =  
					 NeiCha(2400, 3000, Jingmi1canshu[24][1], Jingmi1canshu[30][1], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengxiang = NeiCha(2400, 3000, Jingmi1canshu[24][2], Jingmi1canshu[30][2], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;
                     Fengsu=NeiCha(2400, 3000, Jingmi1canshu[24][3], Jingmi1canshu[30][3], 
							 ((Dandaogao + ZhendiH) - Qixiangzhangaocheng)) ;;
		 }
		 
		 
		 
	  }
	  
		//////成果法
	  if (Fangfashuzi==3)
	  {
		 // Zhenglishijian[spinner104.getSelectedItemPosition()];
		//	Zhengchengcedijuli[spinner104.getSelectedItemPosition()];
		//	Zhengchengpianliufangxiangxiuzhengliang[spinner104.getSelectedItemPosition()];
		//	Zhengchengjulibujiaxiuzhengliang[spinner104.getSelectedItemPosition()];
		//	Zhengchengfangxiangbujiaxiuzhengliang[spinner104.getSelectedItemPosition()];
		//	Zhengchengjulixiuzhengliang[spinner104.getSelectedItemPosition()];
		//	Zhengchengfangxiangxiuzhengliang[spinner104.getSelectedItemPosition()];

		  Pianliufangxiangxiuzhengliang=0-QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][10][0],
				  Cedijuli/1000);
		  
		  
	         Julixiuzhengliang = 
	        	 Zhengchengjulixiuzhengliang[spinner102.getSelectedItemPosition()] 
	        			 * Cedijuli / Zhengchengcedijuli[spinner102.getSelectedItemPosition()];
	                    Fangxiangxiuzhengliang 
	                    = Zhengchengfangxiangxiuzhengliang[spinner102.getSelectedItemPosition()]
	                    + Pianliufangxiangxiuzhengliang 
	                    - Zhengchengpianliufangxiangxiuzhengliang[spinner102.getSelectedItemPosition()];
	                    Kaishijuli=Cedijuli+Julixiuzhengliang;
		Kaishifangxiang=Cedifangxiang+Fangxiangxiuzhengliang;
		
		 Chulimingxi();
	  }
	  
	  
	  

  }
  public void Chulimingxi()
  
  {
		
		Shimigaoxiu=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][11][0],
				  Kaishijuli/1000);
		  
		
		Juligongsuanpiancha=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][12][0],
				  Kaishijuli/1000);
		
		Fangxianggongsuanpiancha=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][13][0],
				  Kaishijuli/1000);
		Gaodigongsuanpiancha=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][14][0],
				  Kaishijuli/1000);
		Shedanfeixingshijian=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][15][0],
				  Kaishijuli/1000);
		Luojiao=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][16][0],
				  Kaishijuli/1000);
		Luosu=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][17][0],
				  Kaishijuli/1000);
		Dandaogao=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][18][0],
				  Kaishijuli/1000);
		Gaobian=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][19][0],
				  Kaishijuli/1000);
		Baibian=100/Gaobian;
		
		Kaishishejiao=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][0],
				  Kaishijuli/1000);
		
		Gaojiaoxiuzhengliang=Paomugaocha/10*Shimigaoxiu;
		Biaochi=Kaishishejiao+Gaojiaoxiuzhengliang;
	  Kaishifangxiang=Cedifangxiang+Fangxiangxiuzhengliang;
	  Fangxiang=Kaishifangxiang-Jizhunshexiang;
	  if(Fangxiang>3000){Fangxiang=Fangxiang-6000;}
	  if(Fangxiang<-3000){Fangxiang=Fangxiang+6000;}
	  
	  
	  
	  Guanmufangxiang=Use.NiyunsuanFAB(ZhuguanX,ZhuguanY, ZhuguanH, MubiaoX, MubiaoY, MubiaoH);
	  Guanmufenhua=3000+Jizhunshexiang-Guanmufangxiang;
	  if(Guanmufenhua>6000){Guanmufenhua=Guanmufenhua-6000;}
	  if(Guanmufenhua<0){Guanmufenhua=Guanmufenhua+6000;}
	  
	  Guanmugaodijiao=Use.NiyunsuanEAB(ZhuguanX, ZhuguanY, ZhuguanH, MubiaoX, MubiaoY, MubiaoH);
	  Zhuguanfenhua=Guanmufenhua;
	  Zhuguangaodi=Guanmugaodijiao;
	  Ceguanfenhua=3000+Jizhunshexiang-Use.NiyunsuanFAB(CeguanX, CeguanY, CeguanH, MubiaoX, MubiaoY, MubiaoH);
	
	  if(Ceguanfenhua>6000){Ceguanfenhua=Ceguanfenhua-6000;}
	  if(Ceguanfenhua<0){Ceguanfenhua=Ceguanfenhua+6000;}
	 
	  
	  Guanmuxiejuli=Use.NiyunsuanLAB(ZhendiX, ZhendiY, ZhendiH, MubiaoX, MubiaoY, MubiaoH);
	  Guanmupingmianjuli=Use.NiyunsuanDAB(ZhendiX, ZhendiY, ZhendiH, MubiaoX, MubiaoY, MubiaoH);
		 Guanpaojiajiao=Guanmufangxiang-Cedifangxiang;
		 
		 Fangxiangbi=Guanmupingmianjuli/Cedijuli;
		 Xiuzhenglv=Guanpaojiajiao*100/Cedijuli;;
  };
  
  public double Fanchajuli(int Danzhong,double Shurubiaochi)
  {
	//  int Tempbc;
	  
	/*	Kaishishejiao=QiJie( 
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][7],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][6],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][5],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][4],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][3],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][2],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][1],
				  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][0],
				  Kaishijuli/1000);
	  */
	  for (Fanchajuli=3000;((QiJie( 
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][7],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][6],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][5],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][4],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][3],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][2],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][1],
			  Dandaoyinshu[spinner101.getSelectedItemPosition()][31][0],
			  Fanchajuli/1000)<Shurubiaochi)&&(Fanchajuli<250000));
			  Fanchajuli=Fanchajuli+1)
	  
	  {;};
	  
	  return Fanchajuli;
  }
};;


public double QiJie(Double Xishu7, Double Xishu6, Double Xishu5, Double Xishu4, Double Xishu3, Double Xishu2, Double Xishu1, Double Xishu0, Double ShuRu) 


{

return (Xishu7 * Math.pow(ShuRu, 7) + Xishu6 * Math.pow(ShuRu, 6) + Xishu5 * Math.pow(ShuRu, 5) + Xishu4 * Math.pow(ShuRu, 4) + Xishu3 * Math.pow(ShuRu, 3) + Xishu2 * Math.pow(ShuRu, 2) + Xishu1 * ShuRu + Xishu0);
}

public double NeiCha(double BianLiangA, double BianLiangB , double ZhiA , double ZhiB  , double BianLiangC)
{if (BianLiangA != BianLiangB){
    return((BianLiangC - BianLiangA) / (BianLiangB - BianLiangA) * (ZhiB - ZhiA) + ZhiA);}
else return ZhiA;

};


}