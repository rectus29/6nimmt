package com.rectus29.nimmt.configuration;

import java.util.ResourceBundle;

public class NimmtConfigurationResourceBundle implements NimmtConfiguration {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("nimmt");

	@Override
	public int getBattleRoundNumber() {
		return Integer.valueOf(resourceBundle.getString("player.card.number"));
	}

	private static class SingletonHolder{
		//holder to be threadsafe
		private final static NimmtConfiguration instance = new NimmtConfigurationResourceBundle();
	}
	
	
	public static NimmtConfiguration getInstance() {
		return SingletonHolder.instance;
	}

	private NimmtConfigurationResourceBundle() {
		
		
	}

	@Override
	public int getMaxPlayer(){
	    return Integer.valueOf(resourceBundle.getString("player.max"));
    }
    
    @Override
	public int getMaxPipeLenght(){
		return Integer.valueOf(resourceBundle.getString("pipe.lenght"));
	}
}
