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
 * <p>
 * This interface describes the various query operations that we want to perform on
 * any population implementation. All of the operations consider only the people in
 * the population.
 * </p><p>
 * If any class supports these operations, the class will be some representation of 
 * a group of people (population). The implementation of that population should
 * have internal data structure(s) that support reasonably efficient execution of
 * these operations.
 * </p><p>
 * The following statements are true about any population:
 * <ul>
 * 	<li>A person is included in the population iff he or she is a parent or a child</li>
 *  <li>
 *    No null people are allowed in the population. It is up to the class that implements
 *    the population to ensure this when it is constructed.
 *  </li>
 *  <li>
 *    Relationships do not necessarily reflect the real world. For example, it is possible
 *    for someone to be her own grandmother or aunt.
 *  </li>
 *  <li>
 *    Taking into account polygamy, divorce and remarriage, a person can have any number
 *    of parents.
 *  </li>
 *  <li>A person is never their own sibling.</li>
 * </ul>
 * </p><p>
 * <strong>Note:</strong> If any argument to a method is invalid (that is it is either
 * null or not a person in the population) then the method returns false.
 * </p>
 * @version Feb 14, 2014
 * @author gpollice
 */
public interface FamilyTreeOperations
{
    /**
     * This method determines if one person is a parent of another person.
     * @param parent person who may be the parent
     * @param child person who may be the child
     * @return true iff parent is a parent of the child
     */
    boolean isParentOf(Person parent, Person child);
    
    /**
     * This method determines if one peron is a child of another person.
     * @param child person who may be the child
     * @param parent person who may be the parent
     * @return true iff the child is a child of the parent
     */
    boolean isChildOf(Person child, Person parent);
    
    /**
     * Determine if one person is an anscestor of another person
     * @param ancestor the person who may be the ancestor
     * @param descendant the person who may be the descendant
     * @return true iff the ancestor is an ancestor of the descendant
     */
    boolean isAncestorOf(Person ancestor, Person descendant);
    
    /**
     * Determine if one perso is a sibling (brother or sister) of another
     * @param sibling1
     * @param sibling2
     * @return true iff the two people are siblings
     */
    boolean isSiblingOf(Person sibling1, Person sibling2);
    
    /**
     * <p>
     * Determine if two people are related in any way.
     * </p><p>
     * NOTE: A person is not considered related to himself or herself.
     * </p>
     * @param person1
     * @param person2
     * @return true iff the two people are related
     */
    boolean isRelated(Person person1, Person person2);
}
