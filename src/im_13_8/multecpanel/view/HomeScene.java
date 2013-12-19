package im_13_8.multecpanel.view;

import java.util.ArrayList;

import im_13_8.multecpanel.controller.HomeController;
import im_13_8.multecpanel.entiteiten.Richting;

import org.mt4j.MTApplication;
import org.mt4j.sceneManagement.AbstractScene;

public class HomeScene extends AbstractScene {
	private HomeController controller;

	public HomeScene(MTApplication app, String name) {
		super(app, name);
		controller = new HomeController();
		ArrayList<Richting> richtingen = controller.getRichtingen();
		
	}

	@Override
	public void init() {
	}

	@Override
	public void shutDown() {
		
	}

}
