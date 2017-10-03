package com.regres.tests;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.NewSubclassContainer;
import com.regres.testdata.UserContainer;

public class AddNewSubclassDBTest {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;
	
	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		loginpage = loginpage.setLanguage(ChangeLanguageFields.UKRAINIAN);
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
	}

	@BeforeMethod
	public void setData() {
		registratorpage = loginpage.getRegistratorHomePage();
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}



	@Test
	public void checkSuccessfulAddedSubclassDB() throws ClassNotFoundException, SQLException {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getDataDB());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		//Assert.assertEquals(subclassesOfObjects.getNameSubclassDB().isEnabled(), true);
	//	Assert.assertTrue(subclassesOfObjects.getNameSubclassDB().getText().contains("Lviv"));

		Application application = Application.get(ApplicationSourcesRepo.getChromeLocalApplicationDb());

		Connection con = application.createDBConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select resource_type_id, type_name from registrator_db.resource_types where type_name='Lviv'");
		List<ResourceTypes> list = new ArrayList<ResourceTypes>();
		ResourceTypes r = new ResourceTypes();
		while (rs.next()) {
			r.setId(Integer.parseInt(rs.getString("resource_type_id")));
			r.setTypeName(rs.getString("type_name"));
			list.add(r);
		}
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		// Close database connection
		application.closeConnectionDB();
		// Print retrieved data
		for (ResourceTypes resourceTypes : list) {
			System.out.println(resourceTypes);
		}
		
		ResourceTypes type = list.get(0);
		assertEquals(type.TypeName, "Lviv");
	}

	public static class ResourceTypes {
		int Id;
		String TypeName;

		public void setId(int id) {
			Id = id;
		}

		public void setTypeName(String typeName) {
			TypeName = typeName;
		}

		@Override
		public String toString() {
			return "ResourceTypes [Id=" + Id + ", TypeName=" + TypeName + "]";
		}

	}
}
