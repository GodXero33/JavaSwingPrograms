/**
 * 
 * This interface will give qualities to each defence unit that a defence unit has to be.
 * So, 'MainController' can easiely track and manage all defence units (literally make an interface for each defence unit).
 * The Observer patter?? I guess, IDK.
 * 
 */

package godxero.interfaces;

import godxero.controller.MainController;

public interface DefenceUnit {
	public void setControlRoom(MainController controlRoom, int unitID);
	public void updateAreaClearState(boolean isAreaClear);
	public void sendMessage();
	public void recieveMessage(String message);
	public void updatePositionState(int state);
	public void updateControls();
}
