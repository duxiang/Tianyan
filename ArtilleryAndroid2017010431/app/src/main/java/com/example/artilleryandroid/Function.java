package com.example.artilleryandroid;

import android.widget.Toast;

public class Function {



public @interface java {

	}



	public FunctionZuobiaojiesuan gggSuanzuobiao=new FunctionZuobiaojiesuan();
	public double WeiduAyuan=0,JingduA=0,HaibaA=0,XA=0,YA=0,//WeiduA，WeiduB是正圆心计算纬度角，不是真的纬度,WeiduAZhen,WeiduBZhen,才是
			PingmianjuliAB=0,Yuanshipingmianmiwei=0,PingmianmiweiAB=0,PingmianfuyangmiweiAB=0,XiejuliAB=0,
			WeiduB=0,JingduB=0,HaibaB=0,XB=0,YB=0,WeiduAZhen=0,WeiduBZhen=0,Xqiu1=0,Yqiu1=0,Zqiu1=0,Xqiu2=0,Yqiu2=0,Zqiu2=0,Rqiu=0,Rqiu2=0;
	public double DadiWeiduA=0,DixinWeiduA=0,GuihuaWeiduA=0,DadiWeiduB=0,DixinWeiduB=0,GuihuaWeiduB=0;

	public double Zuobiaozongxianpianjiao=0,Zhenbeifangweijiaodushu=0;

	public double Zhuanqianweidu=0,Zhuanhouweidu=0,Zhuanhouweifen=0,Zhuanhouweimiao=0
			,Zhuanqianjingdu=0,Zhuanhoujingdu=0,Zhuanhoujingfen=0,Zhuanhoujingmiao=0;
    public String Nanbei="北纬",Dongxi="东经";
		public void Duzhuandufenmiao()
		{   if(Zhuanqianweidu <0)
		{Nanbei="南纬";}
			Zhuanqianweidu = Math.abs(Zhuanqianweidu);
			Zhuanhouweidu= Math.floor(Zhuanqianweidu);//度
			Zhuanhouweifen= Math.floor((Zhuanqianweidu - Zhuanhouweidu) * 60);//分
			Zhuanhouweimiao= ((Zhuanqianweidu - Zhuanhouweidu) * 3600 % 60);//秒

			if(Zhuanqianjingdu <0)
			{Dongxi="西经";}
			Zhuanqianjingdu = Math.abs(Zhuanqianjingdu);
			Zhuanhoujingdu= Math.floor(Zhuanqianjingdu);//度
			Zhuanhoujingfen= Math.floor((Zhuanqianjingdu - Zhuanhoujingdu) * 60);//分
			Zhuanhoujingmiao= ((Zhuanqianjingdu - Zhuanhoujingdu) * 3600 % 60);//秒


		}


	public void ZuizhongQiumianzhengyunsuan(double weidua,double jingdua,double haibaa,double lab,double fab,double eab)

	{
		//	WGS 84 a = 6378137  ZuoBiaoXi为2,b=6356752.3142
		double a = 6378137,b=6356752.3142;

		DixinWeiduA=weidua;
		if(DixinWeiduA==90)
		{
			GuihuaWeiduA=90;
			DadiWeiduA=90;
		}
		else if (DixinWeiduA==-90)
	{
		GuihuaWeiduA=-90;
		DadiWeiduA=-90;
	}
		else
		{
			GuihuaWeiduA=(Math.atan((Math.tan(DixinWeiduA/360*(2*Math.PI)))*a/b))*360/(2*Math.PI);
			DadiWeiduA=(Math.atan((Math.tan(GuihuaWeiduA/360*(2*Math.PI)))*a/b))*360/(2*Math.PI);

		}
		JingduA=jingdua;
		HaibaA=haibaa;
		XiejuliAB=lab;
		PingmianmiweiAB=fab;
		PingmianfuyangmiweiAB=eab;
		XA=Geo2GausiXianX(JingduA,DixinWeiduA,  3);//wgs84大地2000坐标系
		YA=Geo2GausiXianY(JingduA,DixinWeiduA,  3);//wgs84大地2000坐标系

		Zuobiaozongxianpianjiao=JingduA-Zhongyangjingdu;
Yuanshipingmianmiwei=fab;
		PingmianmiweiAB=fab+Zuobiaozongxianpianjiao*6000/360*Math.sin(DixinWeiduA/360*(2*Math.PI));
		Zhenbeifangweijiaodushu=PingmianmiweiAB*360/6000;
		Rqiu=
				Math.sqrt(a*a
						*Math.cos(GuihuaWeiduA/360*(2*Math.PI))
						*Math.cos(GuihuaWeiduA/360*(2*Math.PI))
						+b*b
						*Math.sin(GuihuaWeiduA/360*(2*Math.PI))
						*Math.sin(GuihuaWeiduA/360*(2*Math.PI))
				);

			Xqiu1=(Rqiu)
				*Math.cos(DixinWeiduA/360*(2*Math.PI))
				*Math.cos(JingduA/360*(2*Math.PI))
					+HaibaA
					*Math.cos(DadiWeiduA/360*(2*Math.PI))
					*Math.cos(JingduA/360*(2*Math.PI))
			;
		Yqiu1=(Rqiu)
				*Math.cos(DixinWeiduA/360*(2*Math.PI))
				*Math.sin(JingduA/360*(2*Math.PI))
				+HaibaA
				*Math.cos(DadiWeiduA/360*(2*Math.PI))
				*Math.sin(JingduA/360*(2*Math.PI))
		;
		Zqiu1=(Rqiu)*Math.sin(DixinWeiduA/360*(2*Math.PI))
				+HaibaA*Math.sin(DadiWeiduA/360*(2*Math.PI));

		double Weiduqiexianjiao=0;
///椭圆纬度切线角为
		Weiduqiexianjiao=Math.asin(b*b*(Math.sqrt(Xqiu1*Xqiu1+Yqiu1*Yqiu1))/Math.sqrt(b*b*b*b*(Xqiu1*Xqiu1+Yqiu1*Yqiu1)+a*a*a*a*Zqiu1*Zqiu1));
		if(Zqiu1<0){Weiduqiexianjiao=0-Weiduqiexianjiao;}
		Xqiu2=Xqiu1
				+XiejuliAB*Math.sin((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.cos(DixinWeiduA/360*(2*Math.PI)) *Math.cos(JingduA/360*(2*Math.PI))
				-XiejuliAB*Math.cos((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.cos(PingmianmiweiAB/6000*(2*Math.PI))*Math.cos(Weiduqiexianjiao) *Math.cos(JingduA/360*(2*Math.PI))
				-XiejuliAB*Math.cos((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.sin(PingmianmiweiAB/6000*(2*Math.PI)) *Math.sin(JingduA/360*(2*Math.PI))
		;
		Yqiu2=Yqiu1
				+XiejuliAB*Math.sin((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.cos(DixinWeiduA/360*(2*Math.PI)) *Math.sin(JingduA/360*(2*Math.PI))
				-XiejuliAB*Math.cos((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.cos(PingmianmiweiAB/6000*(2*Math.PI))*Math.cos(Weiduqiexianjiao) *Math.sin(JingduA/360*(2*Math.PI))
				+XiejuliAB*Math.cos((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.sin(PingmianmiweiAB/6000*(2*Math.PI)) *Math.cos(JingduA/360*(2*Math.PI))
		;
		Zqiu2=Zqiu1+XiejuliAB*Math.sin((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.sin(DixinWeiduA/360*(2*Math.PI))
				+XiejuliAB*Math.cos((PingmianfuyangmiweiAB)/6000*(2*Math.PI)) *Math.cos(PingmianmiweiAB/6000*(2*Math.PI)) *Math.sin(Weiduqiexianjiao);



/*
		Xqiu2=Xqiu1
				+XiejuliAB*Math.sin(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.cos(weidua/360*(2*Math.PI)) *Math.cos(jingdua/360*(2*Math.PI))
				-XiejuliAB*Math.cos(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.cos(PingmianmiweiAB/6000*(2*Math.PI))*Math.sin(weidua/360*(2*Math.PI)) *Math.cos(jingdua/360*(2*Math.PI))
				-XiejuliAB*Math.cos(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.sin(PingmianmiweiAB/6000*(2*Math.PI)) *Math.sin(jingdua/360*(2*Math.PI))
		;
		Yqiu2=Yqiu1
				+XiejuliAB*Math.sin(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.cos(weidua/360*(2*Math.PI)) *Math.sin(jingdua/360*(2*Math.PI))
				-XiejuliAB*Math.cos(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.cos(PingmianmiweiAB/6000*(2*Math.PI))*Math.sin(weidua/360*(2*Math.PI)) *Math.sin(jingdua/360*(2*Math.PI))
				+XiejuliAB*Math.cos(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.sin(PingmianmiweiAB/6000*(2*Math.PI)) *Math.cos(jingdua/360*(2*Math.PI))
		;
		Zqiu2=Zqiu1+XiejuliAB*Math.sin(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.cos(weidua/360*(2*Math.PI))
				+XiejuliAB*Math.cos(PingmianfuyangmiweiAB/6000*(2*Math.PI)) *Math.cos(PingmianmiweiAB/6000*(2*Math.PI)) *Math.cos(weidua/360*(2*Math.PI));
*/

		DixinWeiduB=(Math.asin(
				Zqiu2/
						Math.sqrt(Xqiu2*Xqiu2+Yqiu2*Yqiu2+Zqiu2*Zqiu2)
		))*360/(2*Math.PI);

		if(DixinWeiduB==90)
		{
			GuihuaWeiduB=90;
			DadiWeiduB=90;
		}
		else if (DixinWeiduB==-90)
		{
			GuihuaWeiduB=-90;
			DadiWeiduB=-90;
		}
		else
		{
			GuihuaWeiduB=(Math.atan((Math.tan(DixinWeiduB/360*(2*Math.PI)))*a/b))*360/(2*Math.PI);
			DadiWeiduB=(Math.atan((Math.tan(GuihuaWeiduB/360*(2*Math.PI)))*a/b))*360/(2*Math.PI);

		}



		JingduB=(Math.acos(
				Xqiu2/
						Math.sqrt(Xqiu2*Xqiu2+Yqiu2*Yqiu2)
		))*360/(2*Math.PI);
		if(Yqiu2<0)
		{ JingduB=JingduB*(-1)  ;}

/*		Rqiu2=a*b/
				Math.sqrt(b*b
						*Math.cos(WeiduB/360*(2*Math.PI))
						*Math.cos(WeiduB/360*(2*Math.PI))
						+a*a
						*Math.sin(WeiduB/360*(2*Math.PI))
						*Math.sin(WeiduB/360*(2*Math.PI))
				);*/


		Rqiu2=				Math.sqrt(a*a
				*Math.cos(GuihuaWeiduB/360*(2*Math.PI))
				*Math.cos(GuihuaWeiduB/360*(2*Math.PI))
				+b*b
				*Math.sin(GuihuaWeiduB/360*(2*Math.PI))
				*Math.sin(GuihuaWeiduB/360*(2*Math.PI))
		);
		HaibaB=Math.sqrt(Xqiu2*Xqiu2+Yqiu2*Yqiu2+Zqiu2*Zqiu2)-Rqiu2;


		XB=Geo2GausiXianX(JingduB,DixinWeiduB,  3);//wgs84大地2000坐标系
		YB=Geo2GausiXianY(JingduB,DixinWeiduB,  3);//


	};


public double Hu1,Bx1,By1,Bh1;



	public double Sanjiaomianji(double XA,double YA,double XB,double YB,double XC,double YC)
	{ double Mianji=0,JiaoAmiwei=0,FCA=0,FBA=0,DCA=0,DBA=0;
			try {
				if((XC!=XA)||(YC!=YA))
				{	FCA = NiyunsuanFAB(XC, YC, 0, XA, YA, 0);
				DCA = NiyunsuanDAB(XC, YC, 0, XA, YA, 0);
			}
				if((XB!=XA)||(YB!=YA))
				{
					DBA = NiyunsuanDAB(XB, YB, 0, XA, YA, 0);
				FBA = NiyunsuanFAB(XB, YB, 0, XA, YA, 0);}
	JiaoAmiwei = FCA - FBA;
	Mianji = 0.5 * DCA * DBA * Math.sin(JiaoAmiwei / 6000 * 2 * Math.PI);
			}catch (Error e){


			}


		return Mianji;
	}
public double Mil2Hu(double Mil)
{
	double Hu;
	//Deg=0;
	Hu=Mil/6000*(2*Math.PI);
	//Function.this.Hu1=Hu;
	return Hu;
}
public double Hu2Mil(double Hu)
{
	double Mil;
	//Deg=0;
	Mil=Hu*6000/(2*Math.PI);
	//Function.this.Hu1=Hu;
	return Mil;
}
public double ZhengyunsuanBx(double Ax,double Ay,double Ah,double Lab,double Fab,double Eab)
{ double Bx;
Bx=0;
Bx=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));
//Function.this.Bx1=Bx;
	return Bx;
	
};
public double ZhengyunsuanBy(double Ax,double Ay,double Ah,double Lab,double Fab,double Eab)
{ double By;
By=0;
By=Ay+Lab*Math.cos(Mil2Hu(Eab))*Math.sin(Mil2Hu(Fab));
//Function.this.By1=By;
	return By;
	
};
public double ZhengyunsuanBh(double Ax,double Ay,double Ah,double Lab,double Fab,double Eab)
{ double Bh;
Bh=0;
Bh=Ah+Lab*Math.sin(Mil2Hu(Eab));
//Function.this.Bh1=Bh;
	return Bh;
	
};
public double NiyunsuanFAB(double Ax,double Ay,double Ah,double Bx,double By,double Bh)
{ double FAB;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
FAB=Math.acos((Bx-Ax)/Math.sqrt((Bx-Ax)*(Bx-Ax)+(By-Ay)*(By-Ay)));
FAB=(Hu2Mil(FAB));
if (By<Ay) FAB=6000-FAB;
return FAB;
	
};
public double NiyunsuanDAB(double Ax,double Ay,double Ah,double Bx,double By,double Bh)
{ double DAB;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
DAB=Math.sqrt((Bx-Ax)*(Bx-Ax)+(By-Ay)*(By-Ay));
//DAB=(Hu2Mil(FAB));
//if (By<Ay) FAB=6000-FAB;
return DAB;
	
};;;

public double NiyunsuanLAB(double Ax,double Ay,double Ah,double Bx,double By,double Bh)
{ double LAB;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
LAB=Math.sqrt((Bx-Ax)*(Bx-Ax)+(By-Ay)*(By-Ay)+(Bh-Ah)*(Bh-Ah));
//DAB=(Hu2Mil(FAB));
//if (By<Ay) FAB=6000-FAB;
return LAB;
	
};;;

public double NiyunsuanEAB(double Ax,double Ay,double Ah,double Bx,double By,double Bh)
{ double EAB;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
EAB=Math.asin((Bh-Ah)/Math.sqrt((Bx-Ax)*(Bx-Ax)+(By-Ay)*(By-Ay)+(Bh-Ah)*(Bh-Ah)));
EAB=(Hu2Mil(EAB));
//DAB=(Hu2Mil(FAB));
//if (By<Ay) FAB=6000-FAB;
return EAB;
	
};
public double SanBianyunsuanJiaoC(double JiaoA,double JiaoB,double LAB)
{ double JiaoC;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
JiaoC=3000-JiaoA-JiaoB;
//DAB=(Hu2Mil(FAB));
//if (By<Ay) FAB=6000-FAB;
return JiaoC;
	
};

public double SanBianyunsuanLBC(double JiaoA,double JiaoB,double LAB)
{ double LBC;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
LBC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoA));
//DAB=(Hu2Mil(FAB));
//if (By<Ay) FAB=6000-FAB;
return LBC;
	
};

public double SanBianyunsuanLAC(double JiaoA,double JiaoB,double LAB)
{ double LAC;

//FAB=Ax+Lab*Math.cos(Mil2Hu(Eab))*Math.cos(Mil2Hu(Fab));

//Function.this.Bx1=Bx;
LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
//DAB=(Hu2Mil(FAB));
//if (By<Ay) FAB=6000-FAB;
return LAC;
	
};
public double ZhengJiaoMubiaoX(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return MubiaoX;
	
};
public double ZhengJiaoMubiaoY(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return MubiaoY;
	
};
public double ZhengJiaoMubiaoH(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return MubiaoH;
	
};
public double ZhengJiaoZhuMuPingMianJuLi(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return ZhuMuPingMianJuLi;
	
};
public double ZhengJiaoZhuMuXieJuLi(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return ZhuMuXieJuLi;
	
};
public double ZhengJiaoCeX(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return CeX;
	
};
public double ZhengJiaoCeY(double Jizhunshexiang,double Jixianchang,double Zhichan,double ZhuX,double ZhuY,double ZhuH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double CeX,CeY,CeH,MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
ZhuMuPingMianJuLi= SanBianyunsuanLBC((Zhichan+3000-Ceguanfenhua),(-Zhichan+Zhuguanfenhua),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
CeY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, Jixianchang, (Jizhunshexiang+3000-Zhichan), 0);
return CeY;
	
};

//////////////////
public double ShuangGuanMuBiaoX(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return MubiaoX;
	
};


//////////////////
public double ShuangGuanMuBiaoY(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return MubiaoY;

};


//////////////////
public double ShuangGuanMuBiaoH(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return MubiaoH;

};


//////////////////
public double ShuangGuanZhuMuPingMianJuLi(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return ZhuMuPingMianJuLi;

};
//////////////////
public double ShuangGuanZhuMuXieJuLi(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return ZhuMuXieJuLi;

};

/////
public double ShuangGuanCeMuPingMianJuLi(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return CeMuPingMianJuLi;

};


/////
public double ShuangGuanJixianchang(double Jizhunshexiang,double ZhuX,double ZhuY,double ZhuH,double CeX,double CeY,double CeH,double Zhuguanfenhua,double Ceguanfenhua,double Zhuguanfuyang)
{
double MubiaoX,MubiaoY,MubiaoH,ZhuMuPingMianJuLi,ZhuMuXieJuLi,CeMuPingMianJuLi,CeMuXieJuLi,Jixianchang,ZhuCezuobiaofangweijiao,ZhuMuzuobiaofangweijiao,CeMuzuobiaofangweijiao;

//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));

ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;
Jixianchang=NiyunsuanDAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuCezuobiaofangweijiao=NiyunsuanFAB(ZhuX, ZhuY, ZhuH, CeX, CeY, CeH);
ZhuMuzuobiaofangweijiao=Jizhunshexiang+3000-Zhuguanfenhua;
CeMuzuobiaofangweijiao=Jizhunshexiang+3000-Ceguanfenhua;


ZhuMuPingMianJuLi= SanBianyunsuanLBC((ZhuCezuobiaofangweijiao+3000-CeMuzuobiaofangweijiao),(ZhuMuzuobiaofangweijiao-ZhuCezuobiaofangweijiao),Jixianchang);
MubiaoX=ZhengyunsuanBx(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoY=ZhengyunsuanBy(ZhuX, ZhuY, ZhuH, ZhuMuPingMianJuLi, (Jizhunshexiang+3000-Zhuguanfenhua), 0);
MubiaoH=ZhuH+ZhuMuPingMianJuLi*Math.tan(Mil2Hu(Zhuguanfuyang));
ZhuMuXieJuLi=Math.sqrt(ZhuMuPingMianJuLi*ZhuMuPingMianJuLi+(MubiaoH-ZhuH)*(MubiaoH-ZhuH));
CeMuPingMianJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY));
CeMuXieJuLi=Math.sqrt((MubiaoX-CeX)*(MubiaoX-CeX)+(MubiaoY-CeY)*(MubiaoY-CeY)+(MubiaoH-CeH)*(MubiaoH-CeH));
return Jixianchang;

};

public double DanDianGaoCheng(double GuanChaDianGaoCheng,double QiCaiGao,double BiaoGanGao,double XieJuLi,double FuYang)
{
double MuBiaoGaoCheng;

MuBiaoGaoCheng=GuanChaDianGaoCheng+QiCaiGao-BiaoGanGao+ZhengyunsuanBy(0, 0, 0, XieJuLi, FuYang, 0);

return MuBiaoGaoCheng;

};
public	double Fendudaikuan=0;
   public int Fendudaihao=0;
	public double Zhongyangjingdu=0;
///返回军用纵坐标，即民用横坐标
public double Geo2GausiXianX(double L,double B,int ZuoBiaoXi)
{
	
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
	 int ZoneWide = 6; // 带宽 3度带或6度带
	 int ZoneNumber;  // 带号
	 double L0;   // 中央经度
	 if (3 == ZoneWide)
	 {// 3度带
	  ZoneNumber = (int)(L - ZoneWide / 2) / ZoneWide + 1;
	 }
	 else// if (6 == ZoneWide)
	 {// 6度带
	  ZoneNumber = (int)(L) / ZoneWide + 1;
	 }
	 // 中央经度
	 L0 = (ZoneNumber - 1) * ZoneWide + ZoneWide / 2;
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
	return y;


}

///返回军用横坐标，即民用纵坐标
public double Geo2GausiXianY(double L,double B,int ZuoBiaoXi)
{
	
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
	if(ZuoBiaoXi==0) {a = 6378245; b = 6356863.0188;} ;
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
	 double dblPI = Math.PI / 180.0; // 角度弧度转换参数
	 // 求经度所在带号
	 int ZoneWide = 6; // 带宽 3度带或6度带
	 int ZoneNumber;  // 带号
	 double L0;   // 中央经度
	 if (3 == ZoneWide)
	 {// 3度带
	  ZoneNumber = (int)(L - ZoneWide / 2) / ZoneWide + 1;
	 }
	 else// if (6 == ZoneWide)
	 {// 6度带
	  ZoneNumber = (int)(L) / ZoneWide + 1;
	 }
	 // 中央经度
	 L0 = (ZoneNumber - 1) * ZoneWide + ZoneWide / 2;
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
	return x;


}

double  Geo2GausiXianbakX(double L,double B,int ZuoBiaoXi)
{
 // 椭球体
 double a = 6378245;      // 北京54
 double b = 6356863.0188;    // 北京54
 double x;
 double y;
 //double a = 6378140;     // 西安80
 //double b = 6356755.2882;    // 西安80
 //double a = 6378137;     // WGS 84
 //double b = 6356752.3142;    // WGS 84
 double RAD=180/Math.PI;
	if(ZuoBiaoXi==0) {a = 6378245; b = 6356863.0188;} ;
	if(ZuoBiaoXi==1) {a = 6378140; b = 6356755.2882;};
	if(ZuoBiaoXi==2) {a = 6378137; b = 6356752.3142;};
	if(ZuoBiaoXi==3) {a = 6378137; b = 6356752.3142;};
 double f = (a - b) / a;     // 扁率
 double e = 1 - (b / a) * (b / a);  // 第一偏心率平方
 double e2 = (a / b) * (a / b) - 1;  // 第二偏心率平方
 // 求经度所在带号
 int ZoneWide = 3; // 带宽 3度带或6度带
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
 //L、B转化成度
 //L = int( L ) + (int( L*100 ) - int( L )*100)/double(60) + (L*10000 - int(L*100)*100)/3600;
 //B = int( B ) + (int( B*100 ) - int( B )*100)/double(60) + (B*10000 - int(B*100)*100)/3600;
 double A = (L - L0)/RAD;
 double TB = Math.tan( B/RAD );
 double TB2 = TB*TB;
 double CB = Math.cos( B/RAD );
 double C = e2*CB*CB;
 double C2 = 1 + C;
 double N = (a*a/b) / Math.sqrt( C2 );//卯酉曲率半径
 double P = A*A*CB*CB;
 double P2 = Math.sin( B/RAD );
 double Q = P2*P2;
 double R = 32005.78006+Q*(133.92133+Q*0.7031);
 x = 6367558.49686*B/RAD - P2*CB*R + ( ( ( (TB2-58)*TB2 + 61)*P/30+(4*N+5)*C2-TB2)*P/12+1)*N*CB*P/2;
 y = 500000+( ( ( (TB2-18)*TB2-(58*TB2-14)*N+5)*P/20+C2-TB2)*P/6+1)*N*(A*CB);//为保证为正数，向西便偏移500公里，即＋500,000；
 return x; 

}


double  Geo2GausiXianbakY(double L,double B,int ZuoBiaoXi)
{
 // 椭球体
 double a = 6378245;      // 北京54
 double b = 6356863.0188;    // 北京54
 double x;
 double y;
 //double a = 6378140;     // 西安80
 //double b = 6356755.2882;    // 西安80
 //double a = 6378137;     // WGS 84
 //double b = 6356752.3142;    // WGS 84
 double RAD=180/Math.PI;
	if(ZuoBiaoXi==0) {a = 6378245; b = 6356863.0188;} ;
	if(ZuoBiaoXi==1) {a = 6378140; b = 6356755.2882;};
	if(ZuoBiaoXi==2) {a = 6378137; b = 6356752.3142;};
	if(ZuoBiaoXi==3) {a = 6378137; b = 6356752.3142;};
 double f = (a - b) / a;     // 扁率
 double e = 1 - (b / a) * (b / a);  // 第一偏心率平方
 double e2 = (a / b) * (a / b) - 1;  // 第二偏心率平方
 // 求经度所在带号
 int ZoneWide = 3; // 带宽 3度带或6度带
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
 //L、B转化成度
 //L = int( L ) + (int( L*100 ) - int( L )*100)/double(60) + (L*10000 - int(L*100)*100)/3600;
 //B = int( B ) + (int( B*100 ) - int( B )*100)/double(60) + (B*10000 - int(B*100)*100)/3600;
 double A = (L - L0)/RAD;
 double TB = Math.tan( B/RAD );
 double TB2 = TB*TB;
 double CB = Math.cos( B/RAD );
 double C = e2*CB*CB;
 double C2 = 1 + C;
 double N = (a*a/b) / Math.sqrt( C2 );//卯酉曲率半径
 double P = A*A*CB*CB;
 double P2 = Math.sin( B/RAD );
 double Q = P2*P2;
 double R = 32005.78006+Q*(133.92133+Q*0.7031);
 x = 6367558.49686*B/RAD - P2*CB*R + ( ( ( (TB2-58)*TB2 + 61)*P/30+(4*N+5)*C2-TB2)*P/12+1)*N*CB*P/2;
 y = 500000+( ( ( (TB2-18)*TB2-(58*TB2-14)*N+5)*P/20+C2-TB2)*P/6+1)*N*(A*CB);//为保证为正数，向西便偏移500公里，即＋500,000；
 return y; 

}


public double BuzhujixianZhuguanX
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));
//Toast.makeText(this, "", Toast.LENGTH_LONG).show();
return ZhuguanX;
	
};
public double BuzhujixianZhuguanY
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));

return ZhuguanY;
	
};
public double BuzhujixianZhuguanH
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));

return ZhuguanH;
	
};
public double BuzhujixianCeguanX
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));

return CeguanX;
	
};
public double BuzhujixianCeguanY
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));

return CeguanY;
	
};
public double BuzhujixianZhuyipingmianjuli
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));

return Zhuyipingmianjuli;
	
};
public double BuzhujixianZhuyixiejuli
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));

return Zhuyixiejuli;
	
};
public double BuzhujixianZhuchipingmianjuli
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));
//Toast.makeText(this, "", Toast.LENGTH_LONG).show();
return Zhuchipingmianjuli;
	
};

public double BuzhujixianJixianchang
(double Jizhunshexiang,double YizhidianX,double YizhidianY,double YizhidianH,
		double Zhichanfenhua,double Zhuyifenhua,double Ceyifenhua,double Zhuyifuyang,
		double Juanchichang,double Zhubiaofenhua,double Cebiaofenhua,double Zhubiaofuyang)
{
	double ZhuguanX,ZhuguanY,ZhuguanH,CeguanX,CeguanY,
	Zhuyixiejuli,Zhuyipingmianjuli,Jixianchang,Zhuchipingmianjuli;
//LAC=LAB/Math.sin(Mil2Hu(3000-JiaoA-JiaoB))*Math.sin(Mil2Hu(JiaoB));
	Zhuchipingmianjuli=ZhengyunsuanBx(0, 0, 0, Juanchichang, 0, Zhubiaofuyang);
	Jixianchang=SanBianyunsuanLBC((Zhubiaofenhua-Cebiaofenhua),((Zhichanfenhua+3000)-(3000+Zhubiaofenhua)),Zhuchipingmianjuli);
	ZhuguanX=ZhengJiaoMubiaoX((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanY=ZhengJiaoMubiaoY((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	ZhuguanH=ZhengJiaoMubiaoH((Jizhunshexiang+3000), Jixianchang, Zhichanfenhua,YizhidianX,YizhidianY,YizhidianH,Zhuyifenhua,Ceyifenhua,(0-Zhuyifuyang));
	CeguanX=ZhengyunsuanBx(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
	CeguanY=ZhengyunsuanBy(ZhuguanX, ZhuguanY, ZhuguanH, Jixianchang, (Jizhunshexiang+3000-Zhichanfenhua), 0);
Zhuyipingmianjuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY));
Zhuyixiejuli= Math.sqrt((YizhidianX-ZhuguanX)*(YizhidianX-ZhuguanX)+(YizhidianY-ZhuguanY)*(YizhidianY-ZhuguanY)+(YizhidianH-ZhuguanH)*(YizhidianH-ZhuguanH));
//Toast.makeText(this, "", Toast.LENGTH_LONG).show();
return Jixianchang;
	
};




}