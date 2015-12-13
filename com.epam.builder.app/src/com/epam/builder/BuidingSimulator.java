package com.epam.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.epam.builder.model.Building;
import com.epam.builder.model.BuildingEnum;

/**
 * Class is responsible for simulation of Constuction buildings and creation of district
 * @author Pavel
 *
 */
public class BuidingSimulator {
	public static void simulateConstructionOfAllBuildingsAndDistrictCreation(){	
		//Simulation of building construction
		Building industrialStore = simulateBuilding(BuildingEnum.INDUSTRIAL_STORE);
		Building villageStore = simulateBuilding(BuildingEnum.VILLAGE_STORE);
		Building villageHouse = simulateBuilding(BuildingEnum.VILLAGE_HOUSE);
		Building townHouse = simulateBuilding(BuildingEnum.TOWN_HOUSE);
		
		//Set contains all types of buildings
		Set<Building> availableBuildings = new HashSet<Building>();
		availableBuildings.add(industrialStore);
		availableBuildings.add(villageStore);
		availableBuildings.add(villageHouse);
		availableBuildings.add(townHouse);
		
		//Simulation of district creation
		List<Building> livingArea = simulateCreatingOfDistrict(availableBuildings);
	}

	/**
	 * Simulates building construction
	 * @param type
	 * @return
	 */
	private static Building simulateBuilding(BuildingEnum type) {

		Director director = new Director(type);
		System.out.println("START BUILDING OF " + type.getBuildingTypeValue());
		Building building = director.constructBuilding();
		System.out.println("PASSPORT OF OBJECT: ");
		System.out.println(building.getPassportOfObject());
		System.out.println("\n");
		return building;
	}

	/**
	 * Simulate creation of a district.
	 * @param availableBuildings
	 * @return
	 */
	private static List<Building> simulateCreatingOfDistrict(
			final Set<Building> availableBuildings) {
		// This is a list of buildings at living district
		List<Building> livingArea = new ArrayList<Building>();

		Iterator it = availableBuildings.iterator();
		while (it.hasNext()) {
			Building building = (Building) it.next();
			livingArea.add(building);
			if (BuildingEnum.TOWN_HOUSE.equals(building.getType())) {
				createFewBuildings(livingArea, 2, building);
			} else if (BuildingEnum.VILLAGE_HOUSE.equals(building.getType())) {
				createFewBuildings(livingArea, 10, building);
			} else if (BuildingEnum.INDUSTRIAL_STORE.equals(building.getType())) {
				createFewBuildings(livingArea, 1, building);
			} else if (BuildingEnum.VILLAGE_STORE.equals(building.getType())) {
				createFewBuildings(livingArea, 10, building);
			}
		}
		return livingArea;
	}

	/**
	 * Method clone building few times('numberOfBuildings' times).
	 * And then add this building to 'livingArea'.
	 * @param livingArea
	 * @param numberOfBuildings
	 * @param building
	 */
	private static void createFewBuildings(final List<Building> livingArea,
			final int numberOfBuildings, final Building building) {
		for (int i = 0; i < numberOfBuildings; i++) {
			Building newBuilding;
			try {
				newBuilding = building.clone();
				livingArea.add(newBuilding);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
}
