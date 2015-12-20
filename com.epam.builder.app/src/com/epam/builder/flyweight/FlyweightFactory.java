package com.epam.builder.flyweight;

import java.util.HashMap;
import java.util.Map;

import com.epam.builder.builder.BuildingBuilder;
import com.epam.builder.builder.CountryStoreBuilder;
import com.epam.builder.builder.IndustrialStoreBuilder;
import com.epam.builder.builder.TownHouseBuilder;
import com.epam.builder.builder.VillageHouseBuilder;
import com.epam.builder.model.BuildingEnum;

/**
 * Demonstrate Flyweight pattern principles.
 * @author Pavel
 *
 */
public class FlyweightFactory {
	private static FlyweightFactory flyweightFactory;
	private Map<BuildingEnum, Flyweight> flyweightPool;

	public FlyweightFactory() {
		flyweightPool = new HashMap<BuildingEnum, Flyweight>();
	}

	private FlyweightFactory getInstance() {
		if (flyweightFactory == null) {
			flyweightFactory = new FlyweightFactory();
		}
		return flyweightFactory;
	}

	public Flyweight getFlyweight(BuildingEnum key) {
		if (flyweightPool.containsKey(key)) {
			return flyweightPool.get(key);
		} else {
			Flyweight flyweight = null;
			BuildingBuilder builder = null;
			if (BuildingEnum.INDUSTRIAL_STORE.equals(key)) {
				builder = new IndustrialStoreBuilder();
			} else if (BuildingEnum.TOWN_HOUSE.equals(key)) {
				builder = new TownHouseBuilder();
			} else if (BuildingEnum.VILLAGE_HOUSE.equals(key)) {
				builder = new VillageHouseBuilder();
			} else if (BuildingEnum.VILLAGE_STORE.equals(key)) {
				builder = new CountryStoreBuilder();
			}
			flyweight = builder.constructBuilding();
			flyweightPool.put(key, flyweight);
			return flyweight;
		}
	}
}
