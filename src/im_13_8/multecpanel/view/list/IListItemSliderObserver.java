package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.entiteiten.ListItem;

public interface IListItemSliderObserver {
	void listItemSelected(ListItemSliderView view, ListItem item);
	
	void listItemDoubleClicked(ListItem item);
}
