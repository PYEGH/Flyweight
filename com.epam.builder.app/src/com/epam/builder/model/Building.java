package com.epam.builder.model;

import com.epam.builder.model.door.Door;
import com.epam.builder.model.roof.Roof;
import com.epam.builder.model.wall.WallEnum;
import com.epam.builder.model.window.Window;

/**
 * Class is a simulation of a building.
 * @author Pavel
 *
 */
public class Building implements Cloneable{

	private final static String BASE_BUILT = "Base was build.";
	private final static String FLOOR_BUILT = "Floor was build.";
	private final static String WALL_BUILT = "Walls were build.";
	private final static String ROOF_BUILT = "Roof was build.";
	private final static String WINDOW_INSTALLED = "Windows were installed.";
	private final static String DOORS_INSTALLED = "Doors were installed.";
	private final static String HEATING_INSTALLED = "Heating was installed.";
	private final static String FENCE_INSTALLED = "Fence was installed.";
	private final static String COMMUNICATION_INFRASTRUCTURE_INSTALLED = "Communication infrastructure  was installed.";

	private final static String FENCE_EXISTS = "Building has a fence";
	private final static String HEATING_EXISTS = "Building has a heating";
	private final static String COMMUNICATION_INFRASTRUCTURE_EXISTS = "Building has a communication infrastructure";

	// During the construction passport will be filled with the information
	// about building
	private StringBuffer passportOfObject;
	private int floorNumber;
	private BuildingEnum type;

	public Building() {
		passportOfObject = new StringBuffer();
		this.setFloorNumber(0);
	}
	
	public Building clone() throws CloneNotSupportedException{
		Building copy = (Building) super.clone();
		return copy;
	}

	public void buildBase() {
		System.out.println(BASE_BUILT);
	}

	public void buildFloor() {
		System.out.println(FLOOR_BUILT);
	}

	public void buildWalls(WallEnum wallType, final int floor) {
		this.passportOfObject.append("Floor number " + floor + ":"+  "Wall type: ");
		this.passportOfObject.append(wallType.getTypeValue());
		this.passportOfObject.append('\n');
		System.out.println(WALL_BUILT);
	}

	public void buildRoof(final Roof roof) {
		this.passportOfObject.append("Roof type: ");
		this.passportOfObject.append(roof.getType().getTypeValue());
		this.passportOfObject.append('\n');
		System.out.println(ROOF_BUILT);
	}

	public void installWindows(final Window windows, final int floor) {
		this.passportOfObject.append("Floor number " + floor + ":"+  "Window type: ");
		this.passportOfObject.append(windows.getType().getTypeValue());
		this.passportOfObject.append('\n');
		System.out.println(WINDOW_INSTALLED);
	}

	public void installDoors(final Door doors, final int floor) {
		this.passportOfObject.append("Floor number " + floor + ":"+  doors.getTechnicalDescription());
		this.passportOfObject.append('\n');
		System.out.println(DOORS_INSTALLED);
	}

	public void installHeating() {
		this.passportOfObject.append(HEATING_EXISTS);
		this.passportOfObject.append('\n');
		System.out.println(HEATING_INSTALLED);
	}

	public void installCommunicationInfastructure() {
		this.passportOfObject.append(COMMUNICATION_INFRASTRUCTURE_EXISTS);
		this.passportOfObject.append('\n');
		System.out.println(COMMUNICATION_INFRASTRUCTURE_INSTALLED);
	}

	public void constructFence() {
		this.passportOfObject.append(FENCE_EXISTS);
		this.passportOfObject.append('\n');
		System.out.println(FENCE_INSTALLED);

	}

	public void finishConstruction(int floorNumber) {
		this.passportOfObject.append("Floor number: " + floorNumber);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public BuildingEnum getType() {
		return type;
	}

	public void setType(BuildingEnum type) {
		this.type = type;
	}

	public StringBuffer getPassportOfObject() {
		return passportOfObject;
	}
}
