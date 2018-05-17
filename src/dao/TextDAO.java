package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TextDAO {
	private Language lang=Language.ENGLISH;
	private boolean notification = true;
	private int volume = 100;
	private static String _infile = null;

	public TextDAO(String textFile) throws FileNotFoundException {
		this._infile = textFile;

	}

	public void loadFile() throws IOException {
		FileInputStream in = new FileInputStream(new File(_infile));
		Ini x = new Ini(in);
		List<IniSection> list = new ArrayList<IniSection>();
		list = x.getSections();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTag().equals("game_settings")) {
				this.volume = Integer.parseInt(list.get(i).getValue("volume"));
				if (list.get(i).getValue("notification").equals("off"))
					this.notification = false;
				if (list.get(i).getValue("language").equals("en"))
					this.lang = Language.ENGLISH;
				else if (list.get(i).getValue("language").equals("ro"))
					this.lang = Language.ROMANIAN;
				else if (list.get(i).getValue("language").equals("es"))
					this.lang = Language.SPANISH;

			}
		}
	}
public Language getLang()
{
	return this.lang;
}
public int getVolume()
{
	return this.volume;
}
public boolean getNotif()
{
	return this.notification;
}
	public static void main(String[] args) throws SQLException, IOException {
		TextDAO t = new TextDAO("set.ini");
		t.loadFile();
		System.out.println(t.getNotif());
		System.out.println(t.getVolume());
		System.out.println(t.getLang());


	}
}
