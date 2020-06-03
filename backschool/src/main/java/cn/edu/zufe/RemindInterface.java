package cn.edu.zufe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.zufe.utils.DBUtils;

public class RemindInterface {
	public static void main(String[] args){
		Connection connection = DBUtils.getConnection();
		try {
			String data = "";
			HttpInterface httpInterface = new HttpInterface();
			//httpInterface.doPostOrGet(pathUrl, data);
			Statement st = connection.createStatement();
			String querySql = "select xh from icdc_ehall.flow_yjs_back_school where xh  is not null";
			String updateSql = "";
			ResultSet xghs = st.executeQuery(querySql);
			while(xghs.next()){
				String xh = xghs.getString("xh");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
