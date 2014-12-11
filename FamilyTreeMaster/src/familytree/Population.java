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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements the FamilyTreeOperatons interface. Students should fill
 * in all of the missing parts in order to make the tests pass. The missing
 * parts are described with line comments that begin with // TODO...
 * 
 * @version Feb 14, 2014
 * @author gpollice
 */
public class Population implements FamilyTreeOperations {
	/**
	 * Single constructor that initializes the family tree.
	 * 
	 * @param relations
	 *            the collection of parent-child relationships.
	 */

	private Collection<ParentChildRelation> familyRelations;

	public Population(Collection<ParentChildRelation> relations) {
		// TODO replace the type of the collection with a more efficient
		// structure
		this.familyRelations = relations;
	}

	/*
	 * @see familytree.FamilyTreeOperations#isParentOf(familytree.Person,
	 * familytree.Person)
	 */
	@Override
	public boolean isParentOf(Person parent, Person child) {
		// check for null values
		if (child == null || parent == null) {
			return false;
		}

		for (ParentChildRelation parentChildRelation : familyRelations) {
			if (parentChildRelation.getParent() == parent
					&& parentChildRelation.getChild() == child) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @see familytree.FamilyTreeOperations#isChildOf(familytree.Person,
	 * familytree.Person)
	 */
	@Override
	public boolean isChildOf(Person child, Person parent) {
		// check for null values
		if (child == null || parent == null) {
			return false;
		}

		for (ParentChildRelation parentChildRelation : familyRelations) {
			if (parentChildRelation.getParent() == parent
					&& parentChildRelation.getChild() == child)
				return true;
		}
		return false;
	}

	/*
	 * @see familytree.FamilyTreeOperations#isAncestorOf(familytree.Person,
	 * familytree.Person)
	 */
	@Override
	public boolean isAncestorOf(Person ancestor, Person descendant) {
		// check for null conditions
		if (ancestor == null || descendant == null) {
			return false;
		}
		// check the trivial case of direct relation
		if (this.isParentOf(ancestor, descendant)) {
			return true;
		}

		Set<Person> ancestors = new HashSet<Person>();
		ancestors.add(ancestor);
		for (ParentChildRelation pcr : familyRelations) {
			if (pcr.getChild() == descendant) {
				ancestors.add(pcr.getParent());
			}
		}
		int lastSize = 0;
		// check to see if the descendant is in the ancestors children.
		// if a child of the ancestor is not the descendant add the child to a
		// list of possible descendants

		// find all of the possible ancestors
		while (lastSize != ancestors.size()) {
			lastSize = ancestors.size();
			for (Person peep : ancestors) {
				for (ParentChildRelation pcr : familyRelations) {
					if (pcr.getChild() == peep) // if we found a parent's parent
					{
						ancestors.add(pcr.getChild());
					} else if (isSiblingOf(pcr.getParent(), peep)) {
						ancestors.add(pcr.getParent());
					}
				}
			}
		}
		for (Person p : ancestors) {
			if (p == ancestor && !isSiblingOf(p, descendant)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * @see familytree.FamilyTreeOperations#isSiblingOf(familytree.Person,
	 * familytree.Person)
	 */
	@Override
	public boolean isSiblingOf(Person sibling1, Person sibling2) {
		// TODO Auto-generated method stub
		// start by finding the parent(s) of sib1, then for each parent check to
		// see if any have sib2 as a child.
		ArrayList<Person> parents = new ArrayList<Person>();

		for (ParentChildRelation pcr : familyRelations) {
			if (sibling1 == pcr.getChild()) {
				parents.add(pcr.getParent());
			}
		}
		for (ParentChildRelation pcr : familyRelations) {
			for (Person parent : parents) {
				if (pcr.getParent() == parent) {
					if (pcr.getChild() == sibling2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * @see familytree.FamilyTreeOperations#isRelated(familytree.Person,
	 * familytree.Person)
	 */
	@Override
	public boolean isRelated(Person person1, Person person2) {

		if (person1 == person2 || person1 == null || person2 == null) {
			return false;
		}

		HashSet<Person> relations = new HashSet<Person>();
		relations.add(person1);

		// TODO this is broken, not sure why.
		int relationLength = 0;
		while (relationLength != relations.size()) {
			relationLength = relations.size();
			HashSet<Person> relationsToAdd = new HashSet<Person>();
			for (Person p : relations) {
				for (ParentChildRelation pcr : familyRelations) {
					if (pcr.getParent() == p) { // add the children of p
						relationsToAdd.add(pcr.getChild());
					}
					if (pcr.getChild() == p) { // add the parents of p
						relationsToAdd.add(pcr.getParent());
					}
				}
			}
			relations.addAll(relationsToAdd);
		}

		if (relations.contains(person2)) {
			return true;
		}

		return false;
	}

}
