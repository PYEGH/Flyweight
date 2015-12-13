package com.epam.builder.builder;

import com.epam.builder.model.Building;
import com.epam.builder.model.door.Door;
import com.epam.builder.model.roof.Roof;
import com.epam.builder.model.wall.WallEnum;
import com.epam.builder.model.window.Window;

/**
 * Class is responsible for construction of building
 * 
 * @author Pavel
 * 
 */
public abstract class BuildingBuilder {
	private final static String ROOF_BUILT = "Roof was build.";
	private final static String BASE_BUILT = "Base was build.";
	private final static String FLOOR_BUILT = "Floor was build.";
	private final static String WALL_BUILT = "Walls were build.";

	private final static String WINDOW_INSTALLED = "Windows were installed.";
	private final static String DOORS_INSTALLED = "Doors were installed.";
	private final static String HEATING_INSTALLED = "Heating was installed.";
	private final static String FENCE_INSTALLED = "Fence was installed.";
	private final static String COMMUNICATION_INFRASTRUCTURE_INSTALLED = "Communication infrastructure  was installed.";

	private final static String FENCE_EXISTS = "Building has a fence";
	private final static String HEATING_EXISTS = "Building has a heating";
	private final static String COMMUNICATION_INFRASTRUCTURE_EXISTS = "Building has a communication infrastructure";

	protected Building building;

	/**
	 * Building construction
	 * 
	 * @return
	 */
	public abstract Building constructBuilding();

	public String buildRoof(final Roof roof) {
		building.setRoof(roof);
		final StringBuffer result = new StringBuffer();
		result.append("Roof type: ");
		result.append(roof.getType().getTypeValue());
		result.append('\n');
		System.out.println(ROOF_BUILT);
		return result.toString();
	}

	public void buildBase() {
		System.out.println(BASE_BUILT);
	}

	public void buildFloor() {
		System.out.println(FLOOR_BUILT);
	}

	public String buildWalls(WallEnum wallType, final int floor) {
		final StringBuffer result = new StringBuffer();
		result.append("Floor number " + floor + ":" + "Wall type: ");
		result.append(wallType.getTypeValue());
		result.append('\n');
		System.out.println(WALL_BUILT);
		return result.toString();
	}

	public String installWindows(final Window windows, final int floor) {
		building.setWindow(windows);
		final StringBuffer result = new StringBuffer();
		result.append("Floor number " + floor + ":" + "Window type: ");
		result.append(windows.getType().getTypeValue());
		result.append('\n');
		System.out.println(WINDOW_INSTALLED);
		return result.toString();
	}

	public String installDoors(final Door doors, final int floor) {
		building.setDoor(doors);
		final StringBuffer result = new StringBuffer();
		result.append("Floor number " + floor + ":"
				+ doors.getTechnicalDescription());
		result.append('\n');
		System.out.println(DOORS_INSTALLED);
		return result.toString();
	}

	public String installHeating() {
		final StringBuffer result = new StringBuffer();
		result.append(HEATING_EXISTS);
		result.append('\n');
		System.out.println(HEATING_INSTALLED);
		return result.toString();
	}

	public String installCommunicationInfastructure() {
		final StringBuffer result = new StringBuffer();
		result.append(COMMUNICATION_INFRASTRUCTURE_EXISTS);
		result.append('\n');
		System.out.println(COMMUNICATION_INFRASTRUCTURE_INSTALLED);
		return result.toString();
	}

	public String constructFence() {
		final StringBuffer result = new StringBuffer();
		result.append(FENCE_EXISTS);
		result.append('\n');
		System.out.println(FENCE_INSTALLED);
		return result.toString();
	}
}
