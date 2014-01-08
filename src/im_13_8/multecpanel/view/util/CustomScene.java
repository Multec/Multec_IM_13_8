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
		if(!goingNextScene) {
			transition.setDirection("down");
			app.goToScene(parent.getParentSoort(), parent.getParentID(), parent.getParent());
			this.goingNextScene = true;
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
