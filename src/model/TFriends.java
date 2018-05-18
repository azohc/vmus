package model;

import java.util.*;

public class TFriends implements Iterable {

	private List<String> friendList;
	
	public TFriends() 
	{
		friendList = new ArrayList<String>();
	}
	
	public StringIterator iterator()
	{
			return new StringIterator( friendList.iterator() );
	}
	
}
