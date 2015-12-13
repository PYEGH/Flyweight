package com.epam.builder.model.door;

public class HomeDoor extends Door{
	private int numberOfLocks;

	
	public HomeDoor(int numberOfLocks,DoorMaterialEnum material) {
		super.material = material;
		this.numberOfLocks = numberOfLocks;
	}

	public int getNumberOfLocks() {
		return numberOfLocks;
	}

	public void setNumberOfLocks(int numberOfLocks) {
		this.numberOfLocks = numberOfLocks;
	}

	@Override
	public String getTechnicalDescription() {
		return "Door mateirial: " + super.material.getTypeValue()
				+ " Number of locks: " + this.numberOfLocks;
	}
}
