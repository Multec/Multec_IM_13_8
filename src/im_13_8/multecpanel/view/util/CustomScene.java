package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;

import org.mt4j.sceneManagement.AbstractScene;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* the basic scene of all our scenes
*
*/
public class CustomScene extends AbstractScene implements IBackButtonObserver {

	protected ParentEntiteit parent;
	protected Application app;
	protected CustomTransition transition;
	private boolean goingNextScene;
	
	/**
	 * 
	 * @param app the application
	 * @param name name of the scene
	 * @param parent name of the parent of the scene
	 */
	public CustomScene(Application app, String name, ParentEntiteit parent) {
		super(app, name);
		this.parent = parent;
		this.app = app;
		
		this.goingNextScene = false;
		transition = new CustomTransition(app);
		this.setTransition(transition);
	}

	/**
	 * goes back to the previous scene
	 */
	@Override
	public void goBack() {	
		transition.setDirection("down");
		goToScene(parent.getParentSoort(), parent.getParentID(), parent.getParent());
	}
	
	/**
	 * 
	 * @param soort 
	 * @param id scene id
	 * @param parent name of the parent of the scene
	 */
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
