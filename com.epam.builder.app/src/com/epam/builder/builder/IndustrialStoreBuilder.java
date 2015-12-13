package com.epam.builder.builder;

import com.epam.builder.model.Building;
import com.epam.builder.model.BuildingEnum;
import com.epam.builder.model.door.Door;
import com.epam.builder.model.door.DoorMaterialEnum;
import com.epam.builder.model.door.HomeDoor;
import com.epam.builder.model.door.IndustrialGate;
import com.epam.builder.model.roof.Roof;
import com.epam.builder.model.roof.RoofEnum;
import com.epam.builder.model.wall.WallEnum;
import com.epam.builder.model.window.Window;
import com.epam.builder.model.window.WindowEnum;

/**
 * Class is responsible for industrial store construction
 * 
 * @author Pavel
 * 
 */
public class IndustrialStoreBuilder extends BuildingBuilder {

	public IndustrialStoreBuilder() {
		building = new Building();
	}

	/**
	 * Industrial Store construction
	 * 
	 * @return
	 */
	@Override
	public Building constructBuilding() {
		// initial params(materials) for building
		int powerOfEngine = 75;
		int numberOfFloors = 1;
		Door door = new IndustrialGate(powerOfEngine);
		Window window = new Window(WindowEnum.GLAZING_WINDOW);
		Roof roof = new Roof(RoofEnum.FLAT_ROOF);
		WallEnum wallType = WallEnum.CONCRETE_BLOCK_WALL;

		building = new Building();
		building.setType(BuildingEnum.INDUSTRIAL_STORE);
		buildBase();

		buildFloor();
		final String wallInfo = buildWalls(wallType, numberOfFloors);
		building.addInfoToPassportOfObject(wallInfo);

		final String doorInfo = installDoors(door, numberOfFloors);
		building.addInfoToPassportOfObject(doorInfo);

		final String windowInfo = installWindows(window, numberOfFloors);
		building.addInfoToPassportOfObject(windowInfo);

		building.setFloorNumber(numberOfFloors);

		final String roofInfo = buildRoof(roof);
		building.addInfoToPassportOfObject(roofInfo);

		final String heatingInfo = installHeating();
		building.addInfoToPassportOfObject(heatingInfo);

		final String communicationInfastructureInfo = installCommunicationInfastructure();
		building.addInfoToPassportOfObject(communicationInfastructureInfo);

		final String fenceInfo = constructFence();
		building.addInfoToPassportOfObject(fenceInfo);

		building.finishConstruction(numberOfFloors);

		return building;
	}

}
