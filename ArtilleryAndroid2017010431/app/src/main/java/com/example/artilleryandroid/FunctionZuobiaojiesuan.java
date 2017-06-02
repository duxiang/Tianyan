package com.example.artilleryandroid;
import com.example.artilleryandroid.Function;
public class FunctionZuobiaojiesuan {



public @interface java {

	}

//Function Fun1=new Function();
public double Zhongyangjingdu=0;
	public int Shuruuobiaoxi=3,Fendudaihao=0;
	public double ShuruWeidu=0,Shurujingdu=0,ShuchuX=0,ShuchuY=0;
	public void Jingweizhuanzuobiao(double L,double B,int ZuoBiaoXi,int Daikuan,boolean Shoudongzhongyang,double Shuruzhongyangjingdu)
	{     //依次为经度、纬度、坐标系、分度带带宽、是否手动中央经度、中央经度数值
		Shuruuobiaoxi=ZuoBiaoXi;
		Shurujingdu=L;
		ShuruWeidu=B;


		double x;
		double y;
	/* 参数说明
	所有投影转换公式都基于椭球体
	ZuoBiaoXi 0为
    函数内x为民用纵坐标，但为军用横坐标！！！！
	椭球体长半轴
	北京54 a = 6378245  ZuoBiaoXi为0
	西安80 a = 6378140  ZuoBiaoXi为1
	WGS 84 a = 6378137  ZuoBiaoXi为2
	椭球体短半轴
	北京54 b = 6356863.0188  ZuoBiaoXi为0
	西安80 b = 6356755.2882  ZuoBiaoXi为1
	WGS 84 b = 6356752.3142  ZuoBiaoXi为2
	扁率    f = (a - b) / a
	第一偏心率   e = sqrt(1 - (b / a) * (b / a))
	第二偏心率   e' = sqrt((a / b) * (a / b) - 1)
	卯酉圈曲率半径  N = (a * a / b) / sqrt(1 + e' * e' * cosβ * cosβ
	子午圈曲率半径  R = a * (1 - e * e) / sqrt((1 - e * e * sinβ * sinβ) * (1 - e * e * sinβ * sinβ) * (1 - e * e * sinβ * sinβ))
	B -- 纬度，L -- 经度，单位弧度(RAD)
	N X -- 纵直角坐标, E Y -- 横直角坐标，单位米(M)
	//*/
		// 高斯投影转换
		double a = 6378245;
		double b = 6356863.0188;
		if(ZuoBiaoXi==0) {a = 6378245; b = 6356863.0188;};
		if(ZuoBiaoXi==1) {a = 6378140; b = 6356755.2882;};
		if(ZuoBiaoXi==2) {a = 6378137; b = 6356752.3142;};
		if(ZuoBiaoXi==3) {a = 6378137; b = 6356752.3142;};

		// 椭球体短半轴
		//double a = 6378245;     // 北京54
		//double b = 6356863.0188;    // 北京54
		//double a = 6378140;     // 西安80
		// double b = 6356755.2882;    // 西安80
		//double a = 6378137;      // WGS 84
		//double b = 6356752.3142;    // WGS 84
		double f = (a - b) / a;     // 扁率
		double e = 1 - (b / a) * (b / a);  // 第一偏心率平方
		double e2 = (a / b) * (a / b) - 1;  // 第二偏心率平方
		double dblPI = Math.PI  / 180.0; // 角度弧度转换参数
		// 求经度所在带号
		int ZoneWide = Daikuan; // 带宽 3度带或6度带
		int ZoneNumber;  // 带号
		double L0;   // 中央经度

		if (3 == ZoneWide)
		{// 3度带
			ZoneNumber = (int)(L - ZoneWide / 2) / ZoneWide + 1;
			L0 = ZoneNumber * ZoneWide ;
		}
		else// if (6 == ZoneWide)
		{// 6度带
			ZoneNumber = (int)(L) / ZoneWide + 1;
			L0 = ZoneNumber*ZoneWide - 3;
		}
		Fendudaihao=ZoneNumber;
		// 中央经度

		if(Shoudongzhongyang)
			L0=Shuruzhongyangjingdu;

		Zhongyangjingdu= L0;



		// L0 = 120;
		// 角度转换成弧度
		double L1 = L * dblPI;
		double B1 = B * dblPI;
		L0 = L0 * dblPI;
		// 子午圈曲率半径
		double R = a * (1 - e) / Math.sqrt((1 - e * Math.sin(B1) * Math.sin(B1)) * (1 - e * Math.sin(B1) * Math.sin(B1)) * (1 - e * Math.sin(B1) * Math.sin(B1)));
		double T = Math.tan(B1) * Math.tan(B1);
		double C = e2 * Math.cos(B1) * Math.cos(B1);
		double A = (L1 - L0) * Math.cos(B1);
		// 子午线弧长
		double M = a * ((1 - e / 4 - 3 * e * e / 64 - 5 * e * e * e / 256) * B1
				- (3 * e / 8 + 3 * e * e / 32 + 45 * e * e * e / 1024) * Math.sin(2 * B1)
				+ (15 * e * e / 256 + 45 * e * e * e / 1024) * Math.sin(4 * B1)
				- (35 * e * e * e / 3072) * Math.sin(6 * B1));
		// 卯酉圈曲率半径
		double N = a / Math.sqrt(1 - e * Math.sin(B1) * Math.sin(B1));
		// 东纬度偏移
		double FE = ZoneNumber * 1000000L + 500000L;
		// 高斯 - 克吕格投影比例因子
		double k0 = 1;
		// 根据投影公式计算点在投影坐标系中的位置
		x = FE + k0 * N * (A + (1 - T + C) * A * A * A / 6 + (5 - 18 * T + T * T + 14 * C - 58 * T * C) * A * A * A * A * A / 120);
		y = k0 * (M + N * Math.tan(B1) * (A * A / 2 + (5 - T + 9 * C + 4 * C * C) * A * A * A * A / 24)
				+ (61 - 58 * T + T * T + 270 * C - 330 * T * C) * A * A * A * A * A * A / 720);
		ShuchuX=y;
		ShuchuY=x;


	}


public double Zhuanhuanweidu=0,Zhuanhuanjingdu=0;

	public void Zuobiaozhuanjingweiduweidu
			(int Zuobiaoxi,double ZuobiaoX,double ZuobiaoY,int Daikuan,boolean Shoudongzhongyang,double Shuruzhongyangjingdu)

	{
		double Weidu=0,Jingdu=0;
		//    	Xyuanshi=ggg.Geo2GausiXianX(JingDu,WeiDu,  ZuoBiaoXi);
		//Xzuizhong=Xyuanshi+XiuZhengX;
		Weidu=(int)(((int)(ZuobiaoX))/100000);
		Jingdu=(int)(((int)(ZuobiaoY))/1000000)*Daikuan-3;

	Jingweizhuanzuobiao(Jingdu, Weidu, Zuobiaoxi,Daikuan,Shoudongzhongyang,Shuruzhongyangjingdu);

		while((Math.abs(ShuchuX-ZuobiaoX)>30000)||(Math.abs( ShuchuY-ZuobiaoY)>30000))

		{
			if((ShuchuX-ZuobiaoX)>0)
				Weidu=Weidu-0.1;
			else{Weidu=Weidu+0.1;}

			if(( ShuchuY-ZuobiaoY)>0)
				Jingdu=Jingdu-0.1;
			else{Jingdu=Jingdu+0.1;}

			Jingweizhuanzuobiao(Jingdu, Weidu, Zuobiaoxi,Daikuan,Shoudongzhongyang,Shuruzhongyangjingdu);
		}

		while((Math.abs(ShuchuX-ZuobiaoX)>1000)||(Math.abs( ShuchuY-ZuobiaoY)>1000))

		{
			if((ShuchuX-ZuobiaoX)>0)
				Weidu=Weidu-0.005;
			else{Weidu=Weidu+0.005;}

			if(( ShuchuY-ZuobiaoY)>0)
				Jingdu=Jingdu-0.005;
			else{Jingdu=Jingdu+0.005;}
			Jingweizhuanzuobiao(Jingdu, Weidu, Zuobiaoxi,Daikuan,Shoudongzhongyang,Shuruzhongyangjingdu);
		}

		while((Math.abs(ShuchuX-ZuobiaoX)>1)||(Math.abs( ShuchuY-ZuobiaoY)>1))

		{
			if((ShuchuX-ZuobiaoX)>0)
				Weidu=Weidu-0.00001;
			else{Weidu=Weidu+0.00001;}

			if(( ShuchuY-ZuobiaoY)>0)
				Jingdu=Jingdu-0.00001;
			else{Jingdu=Jingdu+0.00001;}
			Jingweizhuanzuobiao(Jingdu, Weidu, Zuobiaoxi,Daikuan,Shoudongzhongyang,Shuruzhongyangjingdu);
		}

		while((Math.abs(ShuchuX-ZuobiaoX)>0.1)||(Math.abs( ShuchuY-ZuobiaoY)>0.1))

		{
			if((ShuchuX-ZuobiaoX)>0)
				Weidu=Weidu-0.000001;
			else{Weidu=Weidu+0.000001;}

			if(( ShuchuY-ZuobiaoY)>0)
				Jingdu=Jingdu-0.000001;
			else{Jingdu=Jingdu+0.000001;}
			Jingweizhuanzuobiao(Jingdu, Weidu, Zuobiaoxi,Daikuan,Shoudongzhongyang,Shuruzhongyangjingdu);
		}

		Zhuanhuanweidu= Weidu;
		Zhuanhuanjingdu=Jingdu;

	}


}