package com.rectus29.nimmt;

import java.util.ResourceBundle;

public class NimmtConfiguration{

    ResourceBundle resourceBundle = ResourceBundle.getBundle("nimmt");

	public int getBattleRoundNumber() {
		return Integer.valueOf(resourceBundle.getString("player.card.number"));
	}

	private static class SingletonHolder{
		//holder to be threadsafe
		private final static NimmtConfiguration instance = new NimmtConfiguration();
	}
	
	
	public static NimmtConfiguration getInstance() {
		return SingletonHolder.instance;
	}

	private NimmtConfiguration() {
		
		
	}

	public int getMaxPlayer(){
	    return Integer.valueOf(resourceBundle.getString("player.max"));
    }
    
    public int getMaxPipeLenght(){
		return Integer.valueOf(resourceBundle.getString("pipe.lenght"));
	}
}
