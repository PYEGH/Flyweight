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
 * @author Pavel
 *
 */
public class TownHouseBuilder extends BuildingBuilder {

	/**
	 * Town House construction
	 * @return
	 */
	@Override
	public Building constructBuilding() {
		int numberOfLocks = 2;
		int floorsNumber = 10;
		Door door = new HomeDoor(numberOfLocks,DoorMaterialEnum.METAL_DOOR);
		Window window = new Window(WindowEnum.GLAZING_WINDOW);
		Roof roof = new Roof(RoofEnum.FLAT_ROOF);
		WallEnum wallType = WallEnum.CONCRETE_BLOCK_WALL;
		
		Building building = new Building();
		building.setType(BuildingEnum.TOWN_HOUSE);
		building.buildBase();
		
		for(int i=0; i<floorsNumber; i++){
			building.buildFloor();
			building.buildWalls(wallType,i+1);
			building.installDoors(door,i+1);
			building.installWindows(window,i+1);
			building.setFloorNumber(i+1);
		}
		building.buildRoof(roof);
		building.installHeating();
		building.installCommunicationInfastructure();
		building.finishConstruction(floorsNumber);

		return building;
	}

}
