package com.epam.builder;

import com.epam.builder.builder.BuildingBuilder;

import com.epam.builder.builder.CountryStoreBuilder;
import com.epam.builder.builder.IndustrialStoreBuilder;
import com.epam.builder.builder.TownHouseBuilder;
import com.epam.builder.builder.VillageHouseBuilder;
import com.epam.builder.model.Building;
import com.epam.builder.model.BuildingEnum;

/**
 * Class is responsible for defining of necessary builder type
 * 
 * @author Pavel
 * 
 */
public class Director {
	private BuildingBuilder builder;

	public Director(BuildingEnum buildingType) {
		if (BuildingEnum.TOWN_HOUSE.equals(buildingType)) {
			builder = new TownHouseBuilder();
		} else if (BuildingEnum.VILLAGE_HOUSE.equals(buildingType)) {
			builder = new VillageHouseBuilder();
		} else if (BuildingEnum.INDUSTRIAL_STORE.equals(buildingType)) {
			builder = new IndustrialStoreBuilder();
		} else if (BuildingEnum.VILLAGE_STORE.equals(buildingType)) {
			builder = new CountryStoreBuilder();
		}
	}

	public Building constructBuilding() {
		return builder.constructBuilding();
	}
}
