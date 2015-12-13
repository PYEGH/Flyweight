package com.epam.builder.builder;

import com.epam.builder.model.Building;

/**
 * Class is responsible for construction of building
 * @author Pavel
 *
 */
public abstract class BuildingBuilder {
	protected Building building;
	
	/**
	 * Building construction
	 * @return
	 */
	public abstract Building constructBuilding();
}
