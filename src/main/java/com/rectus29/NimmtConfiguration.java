package com.rectus29;

public class NimmtConfiguration{

	private static class SingletonHolder{
		//holder to be threadsafe
		private final static NimmtConfiguration instance = new NimmtConfiguration();
	}
	
	
	public static NimmtConfiguration getInstance() {
		return SingletonHolder.instance;
	}

	private NimmtConfiguration() {
	}
}
