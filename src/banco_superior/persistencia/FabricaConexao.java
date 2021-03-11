package banco_superior.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import banco_superior.util.ConstantesUtil;

public class FabricaConexao {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://" + ConstantesUtil.BANCO_SUPERIOR_DATABASE_IP + ":"
					+ ConstantesUtil.BANCO_SUPERIOR_DATABASE_PORT + "/" + ConstantesUtil.BANCO_SUPERIOR_DATABASE_NAME,
					"root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
