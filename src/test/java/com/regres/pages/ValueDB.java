package com.regres.pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

// Клас який надає базовий функціонал для роботи з базою даних
public class ValueDB {

	// Метод який приймає Connection для бази даних і назву "Підкласу обєктів" 
	// Метод вертає запис із бази даних якщо знайшло такий запис в іношму випадку пусту стрічку 
	public String getSubclassNameFromDb(Connection conn, String name) throws SQLException {
		String verifyValue = "select type_name from registrator_db.resource_types where type_name=(?)";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(verifyValue);
		// Підставляємо в запит замість знаків питання параметри
		st.setString(1, name);
		// Виконуємо запит
		ResultSet rs = st.executeQuery();
		String typeName = "";
		if (rs.next()) {
			// З результату запиту отримуємо поле type_name з бази даних
			typeName = rs.getString("type_name");
		}
		// Закриваємо обєкти які працюють з базою даних
		rs.close();
		if (st != null)
			st.close();
		
		return typeName;

	}

}
