
package model;

import java.io.IOException;

import dao.DAOFacade;

public class Settings {
	
	DAOFacade _dao;
	
	public Settings(DAOFacade dao)
	{
		_dao = dao;
	}
	public void load() throws IOException
	{
		//DAOFacade.loadSettings();
	}
}
