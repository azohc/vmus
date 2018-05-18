package model;

import java.util.Iterator;

public class StringIterator implements ListIterator<String>
{
	
	Iterator<String> _itr;
	
	public StringIterator(Iterator<String> iterator)
	{
		_itr = iterator;
	}
	
	@Override
	public String next() {
		return _itr.next();
	}

	@Override
	public void remove() {
		_itr.remove();
	}

	@Override
	public boolean hasNext() {
		return _itr.hasNext();
	}

	

}
