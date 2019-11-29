package com.indhawk.unique.sequence;

public interface UniqueSequenceBuilder<T> {
	
	public T getNextId();
	
	public boolean isIdUsed(long id);
	
	public T getLastId();
	
	public T getFirstId();
	
	public int numberOfDefultBufferElements();
	
	public void setNumberOfDefultBufferElements(int bufferSize);
	
	public void createBufferElements();
	
	public void removeUsedElements();
	
	public int size();

}
