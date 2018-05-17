
package model;

import java.io.IOException;

import dao.DAOFacade;

public class Settings {

	public void load() throws IOException
	{
		DAOFacade.loadSettings();
	}
}
