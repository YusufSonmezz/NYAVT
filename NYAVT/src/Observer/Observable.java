package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	
	private List<Observer> observerList;

	public Observable() {

		observerList = new ArrayList<>();
		
	}
	
	public void addObserver( Observer observer )
	{
		observerList.add(observer);
	}
	
	public void deleteObserver( Observer observer )
	{
		observerList.remove(observer);
	}
	
	public void observerNotification()
	{
		for(Observer observer : observerList)
		{
			observer.update(this);
		}
	}
	

}
