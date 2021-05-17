package Sistem;

import Observer.Observable;

public class Sogutucu extends Observable{

	public boolean sogutucuDurum; // false means sogutucu is closed.
	

	public Sogutucu() {
		sogutucuDurum = false;
	}

	public boolean isSogutucuDurum() {
		return sogutucuDurum;
	}

	public void setSogutucuDurum(boolean sogutucuDurum) {
		this.sogutucuDurum = sogutucuDurum;
		observerNotification();
	}
}
