package im_13_8.multecpanel.view.util;

import org.mt4j.components.MTComponent;

public interface IBounceBackObserver {
	void releasedOn(String name, float travelled, MTComponent component);

	void hoveredOn(String name, float travelled, MTComponent target);
}
