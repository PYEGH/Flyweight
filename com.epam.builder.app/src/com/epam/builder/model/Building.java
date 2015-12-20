package com.epam.builder.model;

import com.epam.builder.flyweight.Flyweight;
import com.epam.builder.model.door.Door;
import com.epam.builder.model.door.DoorMaterialEnum;
import com.epam.builder.model.door.HomeDoor;
import com.epam.builder.model.roof.Roof;
import com.epam.builder.model.window.Window;
import com.epam.builder.model.window.WindowEnum;

/**
 * Class is a simulation of a building.
 * 
 * @author Pavel
 * 
 */
public class Building implements Cloneable, Flyweight {

	// During the construction passport will be filled with the information
	// about building
	private StringBuffer passportOfObject;
	private int floorNumber;
	private BuildingEnum type;
	private Door door;
	private Window window;
	private Roof roof;

	public Building() {
		passportOfObject = new StringBuffer();
		this.setFloorNumber(0);
	}

	public Building clone() throws CloneNotSupportedException {
		Building copy = (Building) super.clone();
		return copy;
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

	public void addInfoToPassportOfObject(final String newInfo) {
		this.passportOfObject.append(newInfo);
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public Roof getRoof() {
		return roof;
	}

	public void setRoof(Roof roof) {
		this.roof = roof;
	}

	/**
	 * This method is a short analogue of passport: here we can see description
	 * of materials, floor number and type. But passport is wider then this
	 * description. Because during the construction some extra info is set to
	 * passport(e.g. type of windows for particular floor).
	 * 
	 * @return
	 */
	@Override
	public String getShortDescription() {
		final StringBuffer description = new StringBuffer();
		description.append(" Building type: "
				+ this.type.getBuildingTypeValue());
		description.append(" Floors: " + this.floorNumber);
		description.append(" Doors: " + this.door.getTechnicalDescription());
		description.append(" Roof: " + this.roof.getType().getTypeValue());
		description.append(" Doors: " + this.window.getType().getTypeValue());
		return description.toString();
	}
}
