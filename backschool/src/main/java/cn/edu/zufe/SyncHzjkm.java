package cn.edu.zufe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.zufe.utils.DBUtils;

public class SyncHzjkm {
	public static void main(String[] args){
		Connection connection = DBUtils.getConnection();
		try {
			//HttpInterface httpInterface = new HttpInterface();
			//httpInterface.doPostOrGet(pathUrl, data);
			Statement st = connection.createStatement();
			String querySql = "select * from icdc_xx.hzjkm where mzt is null";
			//String updateSql = "";
			ResultSet xghs = st.executeQuery(querySql);
			while(xghs.next()){
				String xh = xghs.getString("xgh");
				System.out.println("xh: " + xh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
