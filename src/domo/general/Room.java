package domo.general;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import domo.devices.Sensor;

/**
 * 
 * @author Marco Versari
 * 
 *  The is an interface that represents our room.
 *
 */
public interface Room {
	/**
	 * Get room id.
	 * @return room id.
	 */
	int getId();
	
	/**
	 * Set room id.
	 * @param pId Set room id.
	 */
	void setId(final int pId);
	
	/**
	 * Get room name.
	 * @return room name.
	 */
	String getName();
	
	/**
	 * Get the sensor list.
	 * @return all sensor in the room.
	 */
	Set<Sensor> getSensor();	
	
	/**
	 * Add a sensor to room.
	 * @param sensor sensor to add.
	 * @return room id.
	 */
	@Deprecated
	int addSensor(Sensor sensor);
	
	/**
	 * Add sensor to room.
	 * @param classPath where to find the sensor class.
	 * @param module the module name to load.
	 * @return sensor id.
	 * @throws IllegalAccessException if the updateModuleList fail to check the module compatibility.
	 * @throws InvocationTargetException if something go wrong on the constructor of the module.
	 * @throws InstantiationException the specified class object cannot be instantiated.
	 */
	int addSensor(String classPath, String module) throws IllegalAccessException, InvocationTargetException, InstantiationException;
	
	/**
	 * Remove a sensor from room.
	 * @param id the sensor is to remove.
	 */
	void removeSensor(int id);
	
	/**
	 * Move a sensor.
	 * @param id the sensor id.
	 * @param x the sensor x position.
	 * @param y the sensor y position.
	 */
	void moveSensor(int id, double x, double y);
}
