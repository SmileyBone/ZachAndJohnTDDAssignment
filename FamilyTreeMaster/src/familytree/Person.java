/*******************************************************************************
 * Copyright (c) 2013 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Used in CS3733, Software Engineering at Worcester Polytechnic Institute
 *******************************************************************************/

package familytree;

/**
 * This is a simple data structure that contains the information that describes
 * a person for this example. We assume that the name of a person is all that is
 * needed for this exercise.
 * @version Feb 11, 2014
 * @author gpollice
 */
public class Person
{
	private final String name;
	
	/**
	 * Single constructor that takes the person's name.
	 * @param name
	 */
	public Person(String name)
	{
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean result;
		result = (this == obj);
		if (!result && obj != null && obj instanceof Person) {
			final Person other = (Person) obj;
			result = ((name != null) && (name.equals(other.name)));
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
