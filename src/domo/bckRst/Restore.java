package domo.bckRst;

	/**
	 * 
	 * @author Stefano Falzaresi Stefano.Falzaresi2@studio.unibo.it
	 * 
	 * This is the interface for the restore class
	 */
public interface Restore {

	/**
	 * Check if the configuration file is present.
	 * @return True or False
	 */
	boolean checkFilePresence();
	
	/**
	 * Restore from a specific file.
	 * @param fileName the name of the file to restore
	 * @return True if the restore is done, False if the restore process fail
	 */
	boolean restoreNow(String fileName);
}