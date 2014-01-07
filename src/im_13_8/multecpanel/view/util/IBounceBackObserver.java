package im_13_8.multecpanel.view.util;

import org.mt4j.components.MTComponent;

public interface IBounceBackObserver {
	boolean releasedOn(Object args, float travelled, MTComponent component);

	boolean hoveredOn(Object args, float travelled, MTComponent target);
}
