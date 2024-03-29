package domo.graphic;


import java.util.Collection;
import java.util.Map;

import domo.devices.Sensor;
import domo.general.Flat;
import domo.general.Room;

/**
 * This abstract class must be implement from the controller in to MVC pattern structure.
 * 
 * @author Simone De Mattia simone.demattia@studio.unibo.it
 *
 */
public abstract class AbstractGuiObserver implements GUIAbstractInterface {
	
	/**
	 * the interface that the caller must implement for send message.
	 */
	protected GUIFlat guiFlat;
	
	/**
	 * Add a room and a sensors list in that specific room.
	 * @param name	the room name to create
	 * @param arrayList the sensors list to add in room
	 */
	public abstract void addRoomWithNameAndSensors(String name, Collection<Sensor> arrayList);
	
	/**
	 * Add a sensor in not specific room.
	 * @param name The name that represent the specific sensor (motion, IR, magnetic, etc..)
	 * @return	the sensor instance
	 */
	public abstract Sensor addSensorWithName(String name);
	
	/**
	 * get the room list in flat.
	 * @return a room ArrayList
	 */
	public abstract Collection<Room> getRoomList();
	
	/**
	 * Add a ArrayList of sensor to a specific room.
	 * @param arrayList sensor list
	 * @param room room to add sensors
	 */
	public abstract void addSensorToRoom(Collection<Sensor> arrayList, Room room);
	
	/**
	 * called when press the new project button .
	 */
	public abstract void newProject();
	
	/**
	 * called when the frame did begin to dispose.
	 */
	public abstract void closeProgram();
	
	/**
	 * Called when the save button is clicked.
	 * @param filePathWithName the path to save the project like home/[\]folder/[\...]/[\]filename.extetion
	 * @param imageFilePath the background image path like home/[\]folder/[\...]/[\]filename.extetion
	 */
	public abstract void save(String filePathWithName, final String imageFilePath);

	/**
	 * Called when the open file button is clicked.
	 * @param filePath the path to save the project like home/[\]folder/[\...]/[\]filename.extetion
	 * @return the flat object that represent the project
	 */
	public abstract Flat load(String filePath);
	
	/**
	 * Refresh the sensor type list available .
	 * @return a maps collection where each items is a map with
	 * the sensor data. Example name, image path, ... , ...
	 */
	public abstract Collection<Map <String, String>> refreshSensorList();	
	
	/**
	 * Call when some sensor are delete from project.
	 * @param sensors the sensor list to delete
	 */
	public abstract void deleteSensors(Collection<Sensor> sensors);

}
