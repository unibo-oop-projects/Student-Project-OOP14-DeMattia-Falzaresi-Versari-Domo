package domo.GUI;


import java.util.Set;

import domo.devices.Sensor;
import domo.general.Flat;
import domo.general.Room;

public abstract class GUIAbstractObserver {
	
	protected GUIFlat guiFlat;
	
	//public abstract void flatAdded(Room room);
	
	public abstract void addRoomWithNameAndSensors(String name, Set<Sensor> sensors);
	
	public abstract Sensor addSensorWithName(String name);
	
	public abstract Set<Room> getRoomList();
	
	public abstract void addSensorToRoom(Set <Sensor> sensors, Room room);
	
	public abstract void newProject();
	
	public abstract void closeProgram();
	
	public abstract void save(String filePathWithName);

	public abstract void load(String filePath, Flat flat);
	
	public abstract void refreshSensorList();	

}
