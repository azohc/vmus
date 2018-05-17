package model;

import enums.Language;

public class TSettings {
	private Language lang = Language.ENGLISH;
	private boolean notification = true;
	private int volume = 100;

	public Language getLang() {
		return this.lang;
	}

	public int getVolume() {
		return this.volume;
	}

	public boolean getNotif() {
		return this.notification;
	}

	public void setLanguage(Language lang) {
		this.lang = lang;
	}

	public void setVolume(int v) {
		this.volume = v;
	}

	public void setNotif(boolean n) {
		this.notification = n;
	}	
}


