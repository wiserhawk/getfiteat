package com.indhawk.unique.sequence;

import java.io.Serializable;
import java.util.LinkedList;


public class SimpleUniqueSequenceBuilder implements UniqueSequenceBuilder<Long>, Serializable{
	
	private static final long serialVersionUID = 1000000000001L;

	private LinkedList<Identifier> elementData;
	
	private static int DEFAULT_BUFFER_ELEMENTS_SIZE =  1000;  
	
	/** if unused elements count reached to default threshold or below, 
	 * collection will create new unused elements in collection.
	 */
	private static float DEFAULT_BUFFER_THRESHOLD = 0.25f;
	
	
	private static long DEFAULT_INITIAL_ID = 100000000001L;
	
	private int size;
	
	private int unusedSize;
	
	private Identifier current;
	
	private Identifier first;
	
	private Identifier last;
	
	
	public SimpleUniqueSequenceBuilder() {
		this(DEFAULT_BUFFER_ELEMENTS_SIZE, DEFAULT_INITIAL_ID);
	}
	
	public SimpleUniqueSequenceBuilder(int bufferSize) {
		this(bufferSize, DEFAULT_INITIAL_ID);
	}
	
	public SimpleUniqueSequenceBuilder(long startWithUniqueId) {
		this(DEFAULT_BUFFER_ELEMENTS_SIZE, startWithUniqueId);
	}
	
	public SimpleUniqueSequenceBuilder(int bufferSize, long startWithUniqueId) {
		DEFAULT_BUFFER_ELEMENTS_SIZE = bufferSize;
		DEFAULT_INITIAL_ID = startWithUniqueId;
		this.elementData = new LinkedList<>();
		init(bufferSize, startWithUniqueId);
	}
	
	private synchronized void init(int bufferSize, long initialId ) {
		boolean first = true;
		for(int i = 0; i < bufferSize; i++) {
			Identifier idf = new Identifier(initialId + i, false);
			elementData.add(idf);
			if (first) {
				this.first = idf;
				this.current = idf;
				first = false;
			}
			this.last = idf;
		}
		this.size = elementData.size();
		this.unusedSize = this.size;
	}
	
	private synchronized void reload(int bufferSize, long initialId) {
		for(int i = 0; i < bufferSize; i++) {
			Identifier idf = new Identifier(initialId + i, false);
			elementData.add(idf);
			this.last = idf;
		}
		this.size = elementData.size();
		this.unusedSize = getUnusedElementsCount();

	}

	@Override
	public synchronized Long getNextId() {
		int index = elementData.indexOf(current);
		Identifier idf = elementData.get(index+1);
		long id = current.getId();
		current.setIsUsed(true);
		current = idf;
		// Create buffer elements if required.
		createBufferElements();
		// Remove Used elements if required.
		removeUsedElements();
		return id;
	}

	@Override
	public synchronized boolean isIdUsed(long id) {
		for (Identifier i : elementData) {
			if (i.getId() == id) {
				return i.isUsed;
			}
		}
		return true;
	}

	@Override
	public synchronized Long getLastId() {
		return last.getId();
	}

	@Override
	public synchronized Long getFirstId() {
		return first.getId();
	}

	@Override
	public int numberOfDefultBufferElements() {
		return DEFAULT_BUFFER_ELEMENTS_SIZE;
	}

	@Override
	public void setNumberOfDefultBufferElements(int bufferSize) {
		DEFAULT_BUFFER_ELEMENTS_SIZE = bufferSize;
	}

	@Override
	public synchronized void createBufferElements() {
		int unusedCount = getUnusedElementsCount();
		float threshold = Float.intBitsToFloat(unusedCount) / Float.intBitsToFloat(DEFAULT_BUFFER_ELEMENTS_SIZE);
		if ( threshold <= DEFAULT_BUFFER_THRESHOLD) {
			reload(DEFAULT_BUFFER_ELEMENTS_SIZE, last.getId() + 1);
		}
		
	}

	@Override
	public synchronized void removeUsedElements() {
		Object[] unusedObjects = elementData.stream().filter(i -> i.isUsed() == true).toArray();
		if (unusedObjects != null) {
			for (Object o : unusedObjects) {
				Identifier i = (Identifier) o;
				elementData.remove(i);
			}
		}
		first = elementData.getFirst();
		last = elementData.getLast();
		unusedSize = 0;
	}

	private synchronized int getUnusedElementsCount() {
		int currentIndex = elementData.indexOf(current);
		int lastIndex = elementData.size() - 1;
		int unusedCount = lastIndex - currentIndex;
		this .unusedSize = unusedCount;
		return unusedCount;
	}
	
	
	/**
	 * Identifier class is unique identifier which hold unqiueID and isUsed flag. 
	 * This is a single independent element for collection. 
	 * @author MK
	 *
	 */
	class Identifier {
		private long id;
		private boolean isUsed;
		
		public Identifier() {}
		public Identifier(long id, boolean isUsed) {
			this.id = id;
			this.isUsed = isUsed;
		}
				
		public long getId() {return id;}
		public void setId(long id) {this.id = id;}
		public boolean isUsed() {return isUsed;}
		public void setIsUsed(boolean isUsed) {this.isUsed = isUsed;}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (int) (id ^ (id >>> 32));
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Identifier other = (Identifier) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			return true;
		}
		
		private SimpleUniqueSequenceBuilder getOuterType() {
			return SimpleUniqueSequenceBuilder.this;
		}
	}


	@Override
	public int size() {
		return elementData.size();
	}

}
