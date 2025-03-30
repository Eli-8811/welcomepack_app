package com.mapfre.welcomepack.utils;

public class Time {

	private static long startTime;
	private static long endTime;

	/**
	 * Starts the timer by recording the current time in nanoseconds
	 */
	public static void start() {
	    startTime = System.nanoTime();
	}

	/**
	 * Stops the timer, calculates the duration in minutes and seconds, and returns the formatted result
	 *
	 * @return A string representing the duration in minutes and seconds
	 */
	public static String stop() {
	    endTime = System.nanoTime();
	    long durationInNano = endTime - startTime;
	    long durationInSeconds = durationInNano / 1_000_000_000;
	    long minutes = durationInSeconds / 60;
	    long seconds = durationInSeconds % 60;
	    return String.format(Messages.MINUTES_SECONDS, minutes, seconds);
	}
	
}
