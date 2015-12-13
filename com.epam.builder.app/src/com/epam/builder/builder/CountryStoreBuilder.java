package com.epam.builder.builder;

import com.epam.builder.model.Building;
import com.epam.builder.model.BuildingEnum;
import com.epam.builder.model.door.Door;
import com.epam.builder.model.door.DoorMaterialEnum;
import com.epam.builder.model.door.HomeDoor;
import com.epam.builder.model.roof.Roof;
import com.epam.builder.model.roof.RoofEnum;
import com.epam.builder.model.wall.WallEnum;

/**
 * Class is responsible for country store construction
 * 
 * @author Pavel
 * 
 */
public class CountryStoreBuilder extends BuildingBuilder {

	public CountryStoreBuilder(){
		building = new Building();
	}
	
	/**
	 * Country Store construction
	 * 
	 * @return
	 */	
	@Override
	public Building constructBuilding() {
		int numberOfLocks = 2;
		int numberOfFloors = 1;
		Door door = new HomeDoor(numberOfLocks, DoorMaterialEnum.WODDEN_DOOR);
		Roof roof = new Roof(RoofEnum.FLAT_ROOF);
		WallEnum wallType = WallEnum.WODDEN_WALL;

		building.setType(BuildingEnum.VILLAGE_STORE);

		buildBase();
		buildFloor();

		final String wallInfo = buildWalls(wallType, numberOfFloors);
		building.addInfoToPassportOfObject(wallInfo);

		final String doorsInfo = installDoors(door, numberOfFloors);
		building.addInfoToPassportOfObject(doorsInfo);

		building.setFloorNumber(numberOfFloors);

		final String roofInfo = buildRoof(roof);
		building.addInfoToPassportOfObject(roofInfo);

		final String fenceInfo = constructFence();
		building.addInfoToPassportOfObject(fenceInfo);

		building.finishConstruction(numberOfFloors);

		return building;
	}

}
