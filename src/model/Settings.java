
package model;

import java.io.IOException;

import DAO.DAOFacade;

public class Settings {

	public void load() throws IOException
	{
		DAOFacade.loadSettings();
	}
}
