package fr.detienne.library.chrono.impl;

import java.text.DecimalFormat;

import fr.detienne.library.chrono.Chrono;


public final class ChronoImpl implements Chrono {

	private long startTime = 0;
	
	private long stopTime = 0;

	public final void start() {
		this.startTime = System.currentTimeMillis();
	}

	public final void stop() {
		this.stopTime = System.currentTimeMillis();
	}

	public final String getLap() {
		float time = (float) (stopTime - startTime);		
		DecimalFormat df = new DecimalFormat("#.###");
		String lap = df.format(time/1000) + " s";
		return lap;
	}

}