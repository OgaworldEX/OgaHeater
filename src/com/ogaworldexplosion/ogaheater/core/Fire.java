package com.ogaworldexplosion.ogaheater.core;

public class Fire implements Runnable{
    
	private boolean isFire = true;
	
	@Override
	public void run() {
	    int i=0;
	    while(isFire){
			if(i==0){
				i++;
			}else{
				i--;
			}
		}
	}
	
	public void setOn(){this.isFire = true;}
	public void setOff(){this.isFire = false;}
	public Boolean isOn(){return this.isFire;}	
}
