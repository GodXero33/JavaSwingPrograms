/**
 * 
 *      _____           _  __   __
 *     / ____|         | | \ \ / /
 *    | |  __  ___   __| |  \ V / ___ _ __ ___
 *    | | |_ |/ _ \ / _` |   > < / _ \ '__/ _ \
 *    | |__| | (_) | (_| |  / . \  __/ | | (_) |
 *     \_____|\___/ \__,_| /_/ \_\___|_|  \___/
 * 
 * 
 * Project: GodXero - The Defence System for the war between Mars people and army of Elon Musk's.
 * Purpose: With this defence system Mars army will decently lose and Mars will be ours. Elon Musk is gonna thanks me.
 * 
 */

package godxero.main;

import godxero.controller.MainController;
import godxero.unit.Helicopter;
import godxero.unit.Submarine;
import godxero.unit.Tank;

class Main {
	public static void main (String[] args) {
		final MainController controller = new MainController();

		controller.addUnit(
			new Helicopter(),
			new Tank(),
			new Submarine()
		);
		controller.updateStrength();
	}
}
