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
 * @author Pavel
 *
 */
public class VillageHouseBuilder extends BuildingBuilder {

	/**
	 * Village House construction
	 * @return
	 */
	@Override
	public Building constructBuilding() {
		int floorsNumber = 2;
		int numberOfLocks = 2;
		Door door = new HomeDoor(numberOfLocks,DoorMaterialEnum.WODDEN_DOOR);
		Window window = new Window(WindowEnum.WODDEN_WINDOW);
		Roof roof = new Roof(RoofEnum.COMPLEX_ROOF);
		WallEnum wallType = WallEnum.BRICK_WALL;
		
		Building building = new Building();
		building.setType(BuildingEnum.VILLAGE_HOUSE);
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
		building.constructFence();
		building.finishConstruction(floorsNumber);
		
		return building;
	}

}
