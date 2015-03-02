package domo.general;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import domo.devices.Sensor;
import domo.devices.util.counter.Counter;
import domo.devices.util.counter.CounterImpl;

/**
 * @author Marco Versari
 *
 */
public class RoomImpl implements Room {
	
	private final String name;
	private final Map<Integer, Sensor> listSensor;
	private final Counter counter;
	private int id;
	private Point location;
	private Dimension size;
	
	/**
	 * Initialize Room Class.
	 * @param pId Room id.
	 * @param pName The room name;
	 */
	public RoomImpl(final int pId, final String pName) {
		id = pId;
		name = pName;
		listSensor = new HashMap<Integer, Sensor>();
		counter = new CounterImpl(0);
	}
	
	/**
	 * Initialize Room Class.	 * 
	 * @param pName The room name;
	 */
	public RoomImpl(final String pName) {
		name = pName;
		listSensor = new HashMap<Integer, Sensor>();
		counter = new CounterImpl(0);
	}

	@Override
	public int getId() {		
		return id;
	}
	
	@Override
	public void setId(final int pId) {		
		this.id = pId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Dimension getSize() {
		return new Dimension(size);
	}

	@Override
	public Point getLocation() {
		return new Point(location);
	}

	@Override
	public void setLocation(final Point destination) {
		location = new Point(destination);
	}

	@Override
	public int addSensor(final Sensor sensor) {
		final int ret = counter.incCounter();
		listSensor.put(ret, sensor);
		return ret;
	}

	@Override
	public void removeSensor(final int pId) {
		if (listSensor.containsKey(pId)) {
			listSensor.remove(pId);
		}		
	}

	@Override
	public void moveSensor(final int pId, final Point to) {
		// TODO Auto-generated method stub
	}

}