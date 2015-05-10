package com.ogaworldexplosion.ogaheater.ui;

import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.ogaworldexplosion.ogaheater.core.Fire;

public class FireButton extends JButton {
	
	private static final long serialVersionUID = -5271504633393290147L;

	public static final URL FIRE_ON_URL = FireButton.class.getResource("/com/ogaworldexplosion/ogaheater/images/img_fire_on.png"); 
	public static final URL FIRE_OFF_URL = FireButton.class.getResource("/com/ogaworldexplosion/ogaheater/images/img_fire_off.png"); 
	public static final ImageIcon FIRE_ON_ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(FIRE_ON_URL));
	public static final ImageIcon FIRE_OFF_ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(FIRE_OFF_URL));

	private Fire fire = null;
	
	public FireButton(){
		this.setIcon(FIRE_OFF_ICON);
		this.setBorderPainted(false);
		
		this.addActionListener(act ->{
			if(this.fire == null){
				this.fire = new Fire();
				new Thread(this.fire).start();	
				this.setIcon(FIRE_ON_ICON);	
			}else if(this.fire.isOn()){
				this.fire.setOff();
				this.setIcon(FIRE_OFF_ICON);				
			}else if(this.fire.isOn() == false){
				this.fire = new Fire();
				new Thread(this.fire).start();	
				this.setIcon(FIRE_ON_ICON);
			}		
		});
	}	
}
