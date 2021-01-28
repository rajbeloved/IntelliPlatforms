package com.singleton;

public class Logger {
	
	private static Logger logger;

	public Logger() {
		
	}

	public static Logger getInstance() {
		if(logger == null) {
			logger = new Logger();
		}
		return logger;
	}
}
