package com.example.artilleryandroid;

public class PositionUtil {
	
	public  final String BAIDU_LBS_TYPE = "bd09ll";
	//54 默认
	public  double pi = 3.1415926535897932384626;
	public  double x_pi = 3.1415926535897932384626*3000/180;
	public  double a = 6378245;//54a默认
	public  double ee = 0.00669342161454281815206440141558;//54第2偏心率默认

	/**
	 * 	if(ZuoBiaoXi==0) {a = 6378245; b = 6356863.0188;} ;
	 * 54第二偏心率方-0.00669342161454281815206440141558
	 * 第一偏心率方0.00673852540614646482206268993249
	if(ZuoBiaoXi==1) {a = 6378140; b = 6356755.2882;};
	80第二偏心率方-0.00669438498631479257442409078929
	第一偏心率方0.00673950180602025600576481200193
	if(ZuoBiaoXi==2) {a = 6378137; b = 6356752.3142;};
	84第二偏心率方-0.00669438000426080651558348727667
	第一偏心率方0.00673949675658688230040992463583
	if(ZuoBiaoXi==3) {a = 6378137; b = 6356752.3142;};
	wg第二偏心率方-0.00669438000426080651558348727667第一偏心率方
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 84 to 火星坐标系 (GCJ-02) World Geodetic System ==&gt; Mars Geodetic System
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 */
	public  Gps gps84_To_Gcj02(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return null;
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Gps(mgLat, mgLon);
	}

	/**
	 * * 火星坐标系 (GCJ-02) to 84 * * @param lon * @param lat * @return
	 * */
	public  Gps gcj_To_Gps84(double lat, double lon) {
		Gps gps = transform(lat, lon);
		double lontitude = lon * 2 - gps.getWgLon();
		double latitude = lat * 2 - gps.getWgLat();
		return new Gps(latitude, lontitude);
	}

	/**
	 * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
	 * 
	 * @param gg_lat
	 * @param gg_lon
	 */
	public  Gps gcj02_To_Bd09(double gg_lat, double gg_lon) {
		double x = gg_lon, y = gg_lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new Gps(bd_lat, bd_lon);
	}

	/**
	 * * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标 * * @param
	 * bd_lat * @param bd_lon * @return
	 */
	public  Gps bd09_To_Gcj02(double bd_lat, double bd_lon) {
		double x = bd_lon - 0.0065, y = bd_lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new Gps(gg_lat, gg_lon);
	}

	/**
	 * (BD-09)--&gt;84
	 * @param bd_lat
	 * @param bd_lon
	 * @return
	 */
	public  Gps bd09_To_Gps84(double bd_lat, double bd_lon) {

		Gps gcj02 =  bd09_To_Gcj02(bd_lat, bd_lon);
		Gps map84 = gcj_To_Gps84(gcj02.getWgLat(),
				gcj02.getWgLon());
		return map84;

	}

	public  Gps Gps84_To_bd09(double bd_lat, double bd_lon) {

	//	Gps gcj02 =  bd09_To_Gcj02(bd_lat, bd_lon);
	//	Gps map84 = gcj_To_Gps84(gcj02.getWgLat(),
	//			gcj02.getWgLon());
		Gps gcj02=gps84_To_Gcj02(bd_lat, bd_lon);
		Gps bd09=gcj02_To_Bd09(gcj02.getWgLat(),
						gcj02.getWgLon());
		return bd09;

	}

	
	public  boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon> 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	public  Gps transform(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return new Gps(lat, lon);
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Gps(mgLat, mgLon);
	}

	public  double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
				+ 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	public  double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
				* Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0
				* pi)) * 2.0 / 3.0;
		return ret;
	}
/*
	public  void main(String[] args) {

		// 北斗芯片获取的经纬度为WGS84地理坐标 31.426896,119.496145
		Gps gps = new Gps(31.426896, 119.496145);
		System.out.println("gps :" + gps);
		Gps gcj = gps84_To_Gcj02(gps.getWgLat(), gps.getWgLon());
		System.out.println("gcj :" + gcj);
		Gps star = gcj_To_Gps84(gcj.getWgLat(), gcj.getWgLon());
		System.out.println("star:" + star);
		Gps bd = gcj02_To_Bd09(gcj.getWgLat(), gcj.getWgLon());
		System.out.println("bd  :" + bd);
		Gps gcj2 = bd09_To_Gcj02(bd.getWgLat(), bd.getWgLon());
		System.out.println("gcj :" + gcj2);
	}*/
}

