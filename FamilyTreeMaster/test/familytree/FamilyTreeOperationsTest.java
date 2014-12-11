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

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/**
 * Test cases for the FamilyTreeOperations implementations.
 * @version Dec 27, 2013
 */
public class FamilyTreeOperationsTest
{
	private static FamilyTreeOperations population;
	
	// people in the population
	private static Person
		anson = new Person("anson"),
		bill = new Person("Bill"),
		chris = new Person("Chris"),
		emma = new Person("Emma"),
		gary = new Person("Gary"),
		harvey = new Person("Harvey"),
		josephine = new Person("Josephine"),
		lillian = new Person("Lillian"),
		lisa = new Person("Lisa"),
		margaret = new Person("Margaret"),
		sal = new Person("Sal"),
		salvatore = new Person("Salvatore"),
		scott = new Person("Scott"),
		ted = new Person("Ted"),
		vikki = new Person("Vikki"),
		win = new Person("Winifred"),
		zelda = new Person("Zelda");
	
	// the relationships
	private static ParentChildRelation[] relations = {
		new ParentChildRelation(bill, vikki),
		new ParentChildRelation(margaret, vikki),
		new ParentChildRelation(vikki, chris),
		new ParentChildRelation(null, bill),
		new ParentChildRelation(chris, emma),
		new ParentChildRelation(chris, anson),
		new ParentChildRelation(harvey, sal),
		new ParentChildRelation(salvatore, harvey),
		new ParentChildRelation(gary, chris),
		new ParentChildRelation(harvey, gary),
		new ParentChildRelation(lillian, sal),
		new ParentChildRelation(josephine, harvey),
		new ParentChildRelation(ted, scott),
		new ParentChildRelation(win, zelda),
	};
	
	@BeforeClass
	public static void setupAll()
	{
		Collection<ParentChildRelation> pop = new ArrayList<ParentChildRelation>();
		for (ParentChildRelation pcr : relations) {
			pop.add(pcr);
		}
		population = new Population(pop);
	}
	
	@Test
	public void personIsParentOfChild()
	{
		assertTrue(population.isParentOf(margaret, vikki));
	}

	@Test
	public void personIsChildOfParent()
	{
		assertTrue(population.isChildOf(chris, vikki));
	}
	
	@Test
	public void personIsNotParentOfChild()
	{
		assertFalse(population.isParentOf(vikki, bill));
	}
	
	@Test
	public void personIsNotChildOfParent()
	{
		assertFalse(population.isChildOf(gary, vikki));
	}
	
	@Test
	public void nullParentYieldsFalseRelation()
	{
		assertFalse(population.isParentOf(null, bill));
	}
	
	@Test
	public void nullChildYieldsFalseRelation()
	{
		assertFalse(population.isParentOf(chris, null));
	}
	
	@Test
	public void twoSiblings()
	{
		assertTrue(population.isSiblingOf(emma, anson));
		assertTrue(population.isSiblingOf(anson, emma));
	}
	
	@Test
	public void nonSiblings()
	{
		assertFalse(population.isSiblingOf(lisa, vikki));
	}
	
	@Test
	public void grandparentIsAncestor()
	{
		assertTrue(population.isAncestorOf(salvatore, sal));
	}
	
	@Test
	public void siblingIsNotAncestor()
	{
		assertFalse(population.isAncestorOf(emma, anson));
	}
	
	@Test
	public void twoPeopleAreRelated()
	{
		assertTrue(population.isRelated(anson, sal));
	}
	
	@Test
	public void twoPeopleAreNotRelated()
	{
		assertFalse(population.isRelated(zelda, chris));
	}
	
	@Test
	public void aPersonIsNotRelatedToSelf()
	{
		assertFalse(population.isRelated(anson, anson));
	}
	
	@Test
	public void parentIsRelatedToChild()
	{
		assertTrue(population.isRelated(win, zelda));
	}
	
	@Test
	public void childIsRelatedToParent()
	{
		assertTrue(population.isRelated(scott, ted));
	}
	@Test
	public void newTestTest()
	{
		assertFalse(population.isRelated(bill, null));
	}
}
