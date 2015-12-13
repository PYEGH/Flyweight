package com.epam.builder.builder;

import com.epam.builder.model.Building;
import com.epam.builder.model.BuildingEnum;
import com.epam.builder.model.door.Door;
import com.epam.builder.model.door.DoorMaterialEnum;
import com.epam.builder.model.door.HomeDoor;
import com.epam.builder.model.roof.Roof;
import com.epam.builder.model.roof.RoofEnum;
import com.epam.builder.model.wall.WallEnum;
import com.epam.builder.model.window.Window;
import com.epam.builder.model.window.WindowEnum;

/**
 * Class is responsible for town house construction
 * 
 * @author Pavel
 * 
 */
public class TownHouseBuilder extends BuildingBuilder {

	public TownHouseBuilder() {
		building = new Building();
	}
	/**
	 * Town House construction
	 * 
	 * @return
	 */
	@Override
	public Building constructBuilding() {
		int numberOfLocks = 2;
		int floorsNumber = 10;
		Door door = new HomeDoor(numberOfLocks, DoorMaterialEnum.METAL_DOOR);
		Window window = new Window(WindowEnum.GLAZING_WINDOW);
		Roof roof = new Roof(RoofEnum.FLAT_ROOF);
		WallEnum wallType = WallEnum.CONCRETE_BLOCK_WALL;

		building = new Building();
		building.setType(BuildingEnum.TOWN_HOUSE);
		buildBase();

		for (int i = 0; i < floorsNumber; i++) {
			buildFloor();
			final String wallInfo = buildWalls(wallType, i + 1);
			building.addInfoToPassportOfObject(wallInfo);

			final String doorInfo = installDoors(door, i + 1);
			building.addInfoToPassportOfObject(doorInfo);

			final String windowInfo = installWindows(window, i + 1);
			building.addInfoToPassportOfObject(windowInfo);
			building.setFloorNumber(i + 1);
		}
		final String roofInfo = buildRoof(roof);
		building.addInfoToPassportOfObject(roofInfo);

		final String heatingInfo = installHeating();
		building.addInfoToPassportOfObject(heatingInfo);

		final String communicationInfastructureInfo = installCommunicationInfastructure();
		building.addInfoToPassportOfObject(communicationInfastructureInfo);

		building.finishConstruction(floorsNumber);

		return building;
	}

}
