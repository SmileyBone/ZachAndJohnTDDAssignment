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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * This is the concrete implementation of the route network.
 * @version Nov 7, 2014
 */
public class RouteNetworkImpl implements RouteNetwork
{
	Set<Route> routes;
	Map<String, Set<Route>> sourceMap;
	
	boolean init = false;
	
	/**
	 * Default, and only constructor.
	 */
	public RouteNetworkImpl()
	{
		//we don't need no silly constructor logic....
	}
	
	@Override
	public void initializeNetwork()
	{
		routes = new HashSet<Route>();
		sourceMap = new HashMap<>();
		init = true;
	}

	@Override
	public void initializeNetwork(Route... routes)
	{
		initializeNetwork();
		for(Route r : routes){
			try {
				this.addRoute(r);
			} catch (RouteException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addRoute(Route route) throws RouteException
	{
		if(init){
			routes.add(route);
			
			//get the value from sourceToRouteMap
			Set<Route> setOfRoutes = sourceMap.get(route.getSource());
			
			//if it is null init a new set
			if(setOfRoutes == null){
				setOfRoutes = new HashSet<>();
				sourceMap.put(route.getSource(), setOfRoutes);
			}
			
			//add the set to the sourceToRounteMap
			setOfRoutes.add(route);			
		}
		else{
			throw new RouteException("routes have not been initialized.");
		}
	}

	@Override
	public boolean isPathFrom(String source, String destination)
			throws RouteException
	{
		if (!init) throw new RouteException("You never initialized this network, gentleman/gentlelady");
		return breadthFirstGraphSearchThatOperatesOnRoutes(source, destination).length > 0;
	}

	@Override
	public Route[] getShortestPath(String source, String destination)
			throws RouteException
	{

		if (!init) throw new RouteException("You never initialized this network, sir/madam");
		return breadthFirstGraphSearchThatOperatesOnRoutes(source, destination);
	}
	
	private Route[] breadthFirstGraphSearchThatOperatesOnRoutes(String source, String destination) throws RouteException{
		
		Route current;
		Map<Route, Route> babyDaddy = new HashMap<>();
		Queue<Route> frontier = new LinkedList<>();
		Set<Route> expanded = new HashSet<>();
		//get the routes and init the frontier
		enqueueSet(bfsExpand(source), frontier);
		
		while(!frontier.isEmpty()){
			current = frontier.remove();
			
			Set<Route> newRoutes = bfsExpand(current.getDestination());
			for(Route newRoute : newRoutes){
				if(!expanded.contains(newRoute)){
					babyDaddy.put(newRoute, current);
					frontier.add(newRoute);
				}
			}
			expanded.add(current);
			if(current.getDestination().equals(destination)){
				return getPathFromMapAndStart(babyDaddy, current);
			}
		}
		throw new RouteException("No path found.");
	}
	
	private Route[] getPathFromMapAndStart(Map<Route, Route> babyDaddy, Route current) {
		List<Route> routeHome = new ArrayList<>();
		routeHome.add(current);
		Route parent = current;
		while( (parent = babyDaddy.get(parent)) != null ){
			routeHome.add(parent);
		}
		
		Collections.reverse(routeHome);
		Route[] path = routeHome.toArray(new Route[]{}); 
		
		return path;
	}

	private Set<Route> bfsExpand(String source) {
		//grab all of the things that have the same start as the start of route
		Set<Route> setOfRoutes = sourceMap.get(source); 
		if(setOfRoutes == null){
			return new HashSet<Route>();
		}
		return setOfRoutes;
	}
	
	private void enqueueSet(Set<Route> setOfRoute, Queue<Route> queue){
		for(Route r : setOfRoute){
			queue.add(r);
		}
	}
}
