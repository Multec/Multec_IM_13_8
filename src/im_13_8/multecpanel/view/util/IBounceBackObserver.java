package im_13_8.multecpanel.view.util;

import org.mt4j.components.MTComponent;

public interface IBounceBackObserver {
	void releasedOn(Object args, float travelled, MTComponent component);

	void hoveredOn(Object args, float travelled, MTComponent target);
}
