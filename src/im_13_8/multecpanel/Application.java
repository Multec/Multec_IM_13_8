package im_13_8.multecpanel;

import im_13_8.multecpanel.view.HomeScene;

import org.mt4j.MTApplication;

public class Application extends MTApplication {
	private static final long serialVersionUID = 1338975063241354882L;

	@Override
	public void startUp() {
		this.addScene(new HomeScene(this, "Home"));
	}

	public static void main(String[] args) {
		initialize();
	}

}
