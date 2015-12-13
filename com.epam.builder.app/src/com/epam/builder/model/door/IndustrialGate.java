package com.epam.builder.model.door;

public class IndustrialGate extends Door {
	// Let think that every industrial door is very large and heavy and engine
	// is required to open this door. This property show power of such engine.
	private int powerOfEngine;

	public IndustrialGate(int powerOfEngine) {
		super.material = DoorMaterialEnum.METAL_DOOR;
		this.powerOfEngine = powerOfEngine;
	}

	public int getPowerOfEngine() {
		return powerOfEngine;
	}

	public void setPowerOfEngine(int powerOfEngine) {
		this.powerOfEngine = powerOfEngine;
	}

	@Override
	public String getTechnicalDescription() {
		return "Door mateirial: " + super.material.getTypeValue()
				+ " Power of engine: " + this.powerOfEngine;
	}
}
