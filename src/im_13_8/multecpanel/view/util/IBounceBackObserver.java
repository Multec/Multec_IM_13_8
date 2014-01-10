package im_13_8.multecpanel.view.util;

import org.mt4j.components.MTComponent;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* the interface of the observer for the bounceback event
*
*/
public interface IBounceBackObserver {
	boolean releasedOn(Object args, float travelled, MTComponent component);

	boolean hoveredOn(Object args, float travelled, MTComponent target);
}
