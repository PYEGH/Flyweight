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
 * Class is responsible for village house construction
 * 
 * @author Pavel
 * 
 */
public class VillageHouseBuilder extends BuildingBuilder {

	
	public VillageHouseBuilder() {
		building = new Building();
	}
	/**
	 * Village House construction
	 * 
	 * @return
	 */
	@Override
	public Building constructBuilding() {
		int floorsNumber = 2;
		int numberOfLocks = 2;
		Door door = new HomeDoor(numberOfLocks, DoorMaterialEnum.WODDEN_DOOR);
		Window window = new Window(WindowEnum.WODDEN_WINDOW);
		Roof roof = new Roof(RoofEnum.COMPLEX_ROOF);
		WallEnum wallType = WallEnum.BRICK_WALL;

		building = new Building();
		building.setType(BuildingEnum.VILLAGE_HOUSE);
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

		final String fenceInfo = constructFence();
		building.addInfoToPassportOfObject(fenceInfo);

		building.finishConstruction(floorsNumber);

		return building;
	}

}
