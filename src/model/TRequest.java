package model;

import java.util.*;

public class TRequest implements Iterable {

	private List<String> requestList;
	
	public TRequest() {
		requestList = new ArrayList<String>();
	}
	@Override
	public StringIterator iterator() {				
		return new StringIterator( requestList.iterator() );

	}

}
