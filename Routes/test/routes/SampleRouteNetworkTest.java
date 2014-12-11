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

package routes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Route Network problem.
 * @version Nov 7, 2014
 */
public class SampleRouteNetworkTest
{

	private RouteNetwork network;
	
	@Before
	public void setup(){
		network = new RouteNetworkImpl();
	
	}
	
	@Test
	public void routeToString(){
		assertNotNull( new Route("A", "B").toString());
	}
	
	@Test
	public void routeEquals(){
		
		Route r0 = new Route("A", "B");
		Route r1 = new Route("A", "B");
		Route r2 = new Route("A", "C");
		Route rDumb = new Route(null, null);
		assertFalse(r0.equals(rDumb));
		assertTrue(r0.equals(r1));
		assertFalse(r0.equals(r2));
		assertTrue(r2.equals(r2));
		assertFalse(r2.equals(null));
		assertFalse(r2.equals(12));
		assertFalse(r0.equals("Hello world"));
		
		
	}
	
	@Test (expected = RouteException.class)
	public void notInitYet() throws RouteException{
		network.isPathFrom("A", "B");	
	}
	
	@Test (expected = RouteException.class)
	public void notInitYet2() throws RouteException{
		network.getShortestPath("A", "B");	
	}
	
	
	@Test
	public void circRef() throws RouteException{
	
		network.initializeNetwork( 
				new Route("A", "B"),
				new Route("B", "C"),
				new Route("C", "A") );
		assertTrue(network.isPathFrom("A", "A"));
		
		
		
		Route[] path = network.getShortestPath("A", "A");
		assertTrue(path.length == 3);
		assertEquals(path[0], new Route("A", "B"));
		assertEquals(path[2], new Route("C", "A"));
	
	}
	
	
	@Test(expected=RouteException.class)
	public void noPathExists() throws RouteException{
		
		network.initializeNetwork(
				new Route("A", "B"),
				new Route("C", "A"));
		assertFalse(network.isPathFrom("A", "C"));
		
	}
	
	@Test(expected=RouteException.class)
	public void test() throws RouteException
	{
		new RouteNetworkImpl().addRoute(new Route("A", "B"));
	}
	
	@Test
	public void addRouteToNetwork() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork();
		network.addRoute(new Route("A", "B"));
		assertTrue(network.isPathFrom("A", "B"));
	}

	@Test
	public void initializeRoutes() throws RouteException
	{
		RouteNetwork network = new RouteNetworkImpl();
		network.initializeNetwork( new Route[] {
				new Route("A", "B"),
				new Route("B", "C"),
				new Route("X", "Y")
			}
		);
		assertTrue(network.isPathFrom("A", "B"));
	}
}
