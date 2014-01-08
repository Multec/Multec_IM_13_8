package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;

import org.mt4j.sceneManagement.AbstractScene;

public class CustomScene extends AbstractScene implements IBackButtonObserver {

	protected ParentEntiteit parent;
	protected Application app;
	protected CustomTransition transition;
	private boolean goingNextScene;
	
	public CustomScene(Application app, String name, ParentEntiteit parent) {
		super(app, name);
		this.parent = parent;
		this.app = app;
		
		this.goingNextScene = false;
		transition = new CustomTransition(app);
		this.setTransition(transition);
	}

	@Override
	public void goBack() {	
		transition.setDirection("down");
		goToScene(parent.getParentSoort(), parent.getParentID(), parent.getParent());
	}
	
	public void goToScene(String soort, String id, ParentEntiteit parent) {
		if(!goingNextScene) {
			this.goingNextScene = true;
			app.goToScene(soort, id, parent);
		}
	}

	@Override
	public void init() {

	}

	@Override
	public void shutDown() {
		this.destroy();
	}

}
