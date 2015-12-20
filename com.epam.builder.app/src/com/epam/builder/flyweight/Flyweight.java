package com.epam.builder.flyweight;

/**
 * Interface is responsible for demonstration of Flyweight pattern work. At this
 * app actually it is not needed for now because only objects with type
 * 'Building' can be created. But if we introduce some new entities(e.g.
 * Monuments or some technical elements like Bridge,Tunnel and others) which can
 * also be build lyweightFactorythis interface will be necessary(used at FlyweightFactory)
 * 
 * @author Pavel
 * 
 */
public interface Flyweight {
	String getShortDescription();
}
