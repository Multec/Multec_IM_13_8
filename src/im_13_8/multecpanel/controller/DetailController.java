package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.DetailInfo;

import java.util.ArrayList;

public class DetailController {
	
	public DetailInfo getDetailInfo(){
		
		DetailInfo detail = new DetailInfo("IOS Development", "In dit vak leren jullie programmeren voor de iPhone en de iPad.", "images/iosDevelopment.jpg");
		
		return detail;
	}

}
