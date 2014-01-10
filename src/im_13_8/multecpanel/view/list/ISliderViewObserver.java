package im_13_8.multecpanel.view.list;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* interface for observing the sliderview
*
*/
public interface ISliderViewObserver {
	/**
	 * 
	 * @param position position where the slider is changed to
	 */
	void sliderViewChanged(int position);
}
