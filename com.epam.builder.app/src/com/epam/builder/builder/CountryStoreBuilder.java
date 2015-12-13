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
 * @author Pavel
 *
 */
public class CountryStoreBuilder extends BuildingBuilder {

	/**
	 * Country Store construction
	 * @return
	 */
	@Override
	public Building constructBuilding() {
		int numberOfLocks = 2;
		int numberOfFloors = 1;
		Door door = new HomeDoor(numberOfLocks, DoorMaterialEnum.WODDEN_DOOR);
		Roof roof = new Roof(RoofEnum.FLAT_ROOF);
		WallEnum wallType = WallEnum.WODDEN_WALL;

		Building building = new Building();
		building.setType(BuildingEnum.VILLAGE_STORE);
		building.buildBase();

		building.buildFloor();
		building.buildWalls(wallType,numberOfFloors);
		building.installDoors(door,numberOfFloors);
		building.setFloorNumber(numberOfFloors);

		building.buildRoof(roof);
		building.constructFence();
		building.finishConstruction(numberOfFloors);

		return building;
	}

}
