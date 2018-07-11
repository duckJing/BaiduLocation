package com.hualing.baidulocation;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;

/**
 * 2018/7/11 DuckJing <p>
 */
public class MyLocationListener extends BDAbstractLocationListener {
	TextView tv;
	public MyLocationListener(TextView tv) {
		this.tv=tv;
	}

	@Override
	public void onReceiveLocation(BDLocation location){
		//此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
		//以下只列举部分获取经纬度相关（常用）的结果信息
		//更多结果信息获取说明，请参照类参考中BDLocation类中的说明

		double latitude = location.getLatitude();    //获取纬度信息
		double longitude = location.getLongitude();    //获取经度信息
		float radius = location.getRadius();    //获取定位精度，默认值为0.0f

		String coorType = location.getCoorType();
		//获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

		int errorCode = location.getLocType();
//		Toast.makeText(location.getc, "", Toast.LENGTH_SHORT).show();
		Log.e("DuckJiing","错误："+errorCode);
		//获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
		Log.i("DuckJing","经度"+longitude);
		Log.i("DuckJing","纬度"+latitude);

		String locationDescribe = location.getLocationDescribe();    //获取位置描述信息

		String addr = location.getAddrStr();    //获取详细地址信息
		String country = location.getCountry();    //获取国家
		String province = location.getProvince();    //获取省份
		String city = location.getCity();    //获取城市
		String district = location.getDistrict();    //获取区县
		String street = location.getStreet();    //获取街道信息
//		Log.i("DuckJiing","地址："+addr);
		tv.setText("错误码："+errorCode+"地址："+addr+"  位置描述："+locationDescribe);
		Log.i("DuckJiing","地址："+addr);

	}
}
