package com.viacom.web.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*************************************************************************************
 * Class : GlobalVariables Purpose : This class is used for storing all the
 * global variables Remarks : none Author : Roja KC, Ifocus Modifications: 10
 * April 2017 - First created
 * 
 *
 **************************************************************************************/
public class GlobalVariables {

	// public static ArrayList<String> sections = new ArrayList<String>();
	public static ArrayList<String> trayTitles = new ArrayList<String>();
	public static String cur_video_title;
	public static String error_Msg;
	public static boolean error_flag;
	public static String error_Msg_testng;
	public static String cur_Section;
	public static boolean section_Flag;
	public static String sectionStatus;
	public static int videoCount;
	public static int adCount = 0;
	public static int failureCount = 0;
	public static boolean break_Flag = false;
	public static boolean mid_ad;
	public static boolean mid_ad_played;
	public static boolean add;
	public static int pre_ad_count;
	public static boolean runComplete = true;
	public static int mid_ad_count;
	public static int totalwaitingTime = 0;
	public static String playbackStatus = "";
	public static boolean learnMoreStatus = false;
	public static List<String> skipAdStatus = new ArrayList<String>();
	public static List<String> learnMoreStatus1 = new ArrayList<String>();
	public static List<String> AdPlaybackStatus = new ArrayList<String>();
	public static List<String> interruptStatus = new ArrayList<String>();
	public static boolean ResultAdclick = false;
	public static boolean securepubAdFlag = false;
	public static String durminutes = "";
	public static String durhrs = "";
	public static String LAHost = "";
	// public static String pwd="";
	public static String TAHost = "";
	public static String appversion="1.10.0";
	
	public static String GetDeviceName(String udid) {
		Map<String, String> DeviceNameMap = new HashMap<String, String>();
		DeviceNameMap.put("32012439840d5631", "Samsung-M20");
		DeviceNameMap.put("DRGID18101405207", "NOKIA");
		DeviceNameMap.put("MCCDU17207000772", "Amresh-Honor");
		DeviceNameMap.put("ZY322CF54R", "Moto-G5S");
		DeviceNameMap.put("421042efc4159421", "Samsung-Galaxy-J5");
		DeviceNameMap.put("5256526adf9be8076ae3722fdf985318e89b692f", "Iphone6");
		DeviceNameMap.put("ZY32279CMM", "Moto-G5SPlus");
		DeviceNameMap.put("a77a281e05af5793d1b292eaaef151095f1b87c7", "Iphone6");
		DeviceNameMap.put("52005532ec35357b", "Samsung-Galaxy-J6");
		DeviceNameMap.put("33001ef1d426c37f", "Samsung-Galaxy-J7Prime");
		DeviceNameMap.put("00008030-000A110126E0402E", "iPhone11");
		DeviceNameMap.put("00008030-000C6D4A0ED0402E", "iPhoneSE");
		DeviceNameMap.put("ZW2225DTSJ", "Unusable-Moto-E4");
		DeviceNameMap.put("d2cac7e512d8c16c1b4ad94ad6120b2ca1a6deff", "iPhone 6");
		DeviceNameMap.put("f85b0e3f", "Vivo-V20");
		DeviceNameMap.put("ce01182158387c2e0d", "Samsung-S8+");
		DeviceNameMap.put("4200a46cb468a267", "Samsung-On5");
		DeviceNameMap.put("247bbc8f4b65b79c21ef8a109aba6058b9db516a", "iPhone 6");
		DeviceNameMap.put("PD21BDD464040961", "Nokia5.4");

		
		
		return DeviceNameMap.get(udid);
		
	}
	public static String GetDeviceVersion(String udid) {
		Map<String, String> DeviceVersionMap = new HashMap<String, String>();
		DeviceVersionMap.put("32012439840d5631", "10.0.0");
		DeviceVersionMap.put("DRGID18101405207", "9.0.0");
		DeviceVersionMap.put("MCCDU17207000772", "7.0.0");
		DeviceVersionMap.put("ZY322CF54R", "7.1.1");
		DeviceVersionMap.put("421042efc4159421", "8.0.0");
		DeviceVersionMap.put("5256526adf9be8076ae3722fdf985318e89b692f", "12.4.7");
		DeviceVersionMap.put("ZY32279CMM", "7.1.1");
		DeviceVersionMap.put("a77a281e05af5793d1b292eaaef151095f1b87c7", "12.4.8");
		DeviceVersionMap.put("52005532ec35357b", "8.0.0");
		DeviceVersionMap.put("33001ef1d426c37f", "8.1.0");
		DeviceVersionMap.put("00008030-000A110126E0402E", "14.0.1");
		DeviceVersionMap.put("00008030-000C6D4A0ED0402E", "14.0.1");
		DeviceVersionMap.put("ZW2225DTSJ", "7.1.1");
		DeviceVersionMap.put("d2cac7e512d8c16c1b4ad94ad6120b2ca1a6deff", "12.4.7");
		DeviceVersionMap.put("f85b0e3f", "11");
		DeviceVersionMap.put("ce01182158387c2e0d", "9");
		DeviceVersionMap.put("4200a46cb468a267", "6");
		DeviceVersionMap.put("247bbc8f4b65b79c21ef8a109aba6058b9db516a", "12.4.4");
		DeviceVersionMap.put("PD21BDD464040961", "11");

		
		return DeviceVersionMap.get(udid);
	}
	
	

}
