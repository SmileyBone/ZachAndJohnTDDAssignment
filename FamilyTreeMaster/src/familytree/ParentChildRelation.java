/*******************************************************************************
 * Copyright (c) 2014 Gary F. Pollice
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
 * This class encapsulates the "is a parent of" relationship.
 * @version Feb 14, 2014
 * @author gpollice
 */
public class ParentChildRelation
{
	private final Person parent;
	private final Person child;
	
	/**
	 * Single constructor that establishes the relationship
	 * @param parent the parent Person
	 * @param child the child Person
	 */
	public ParentChildRelation(Person parent, Person child)
	{
		this.parent = parent;
		this.child = child;
	}

	/**
	 * @return the parent
	 */
	public Person getParent()
	{
		return parent;
	}

	/**
	 * @return the child
	 */
	public Person getChild()
	{
		return child;
	}
}
