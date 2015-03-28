package domo.bckRst;

import domo.general.Flat;

	/**
	 * 
	 * @author Stefano Falzaresi Stefano.Falzaresi2@studio.unibo.it
	 * 
	 * This is the interface for the backup class
	 *
	 */

public interface Backup {

	/**
	 * Start to backup everything.
	 * @param Flat, the flat to be backupped
	 * @throws Exception 
	 * @return True if backup is correctly done,False if an error occur
	 */
	boolean backupNow(Flat flatB);
}
