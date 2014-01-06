package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.DetailInfo;

import java.util.ArrayList;

public class DetailController {
	
	public DetailInfo getDetailInfo(){
		
		DetailInfo detail = new DetailInfo("IOS", "Hier komt een omschrijving van het bepaalde vak", "/Users/rickyleemans/Desktop/design mock/ios.png");
		
		return detail;
	}

}
