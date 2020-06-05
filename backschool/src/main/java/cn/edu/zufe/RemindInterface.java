package cn.edu.zufe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.zufe.utils.DBUtils;
import cn.edu.zufe.utils.IfsUtils;

public class RemindInterface {
	
	public static String PREFIX_PARAM = "http://one.zufe.edu.cn/dcp/ifs?sysid=zufe_ehall&param=";
	public static String AFTER_PARAM = "module=remind&function=getRemindList&pageNo=1&rc_id=5&idNumber=09901&pageSize=10";
	public static String 	KEY = "onezufe_ehall_xuwpqoncmdj";

	
	
	public static void main(String[] args){
		
		try {
			String desEncode = IfsUtils.desEncode(AFTER_PARAM, KEY);
			String response = HttpClient2Interface.doGet(PREFIX_PARAM +desEncode , "UTF-8");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
