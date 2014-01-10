package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.entiteiten.ListItem;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* Interface for observing the listitemsliderview
*
*/
public interface IListItemSliderObserver {
	/**
	 * 
	 * @param view listitemsliderview which is selected
	 * @param item listitem which is selected
	 */
	void listItemSelected(ListItemSliderView view, ListItem item);
	
	/**
	 * 
	 * @param item listitem which is doubleclicked on
	 */
	void listItemDoubleClicked(ListItem item);
}
