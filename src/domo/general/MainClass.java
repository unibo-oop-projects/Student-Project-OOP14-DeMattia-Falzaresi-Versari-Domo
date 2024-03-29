package domo.general;

import domo.devices.loader.DynamicLoaderImpl;
import domo.devices.loader.DynamicLoader;
import static org.junit.Assert.fail;
import domo.util.test.DomoTestImpl;
import domo.devices.Sensor;
import domo.graphic.GUIFlat;
import domo.graphic.GUIFlatImpl;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The MainClass where everythings begun.
 * @author Marco Versari
 * @author Stefano Falzaresi Stefano.Falzaresi2@studio.unibo.it
 *	@autor Simone De Mattia simone.demattia@studio.unibo.it
 */
public class MainClass {

	/**
	 * 
	 * @param args 
	 * @throws IOException 
	 */
	public static void main(final String... args) throws IOException {
		
		System.out.println("Welcome!");
		
		//used in OSX (menu on the upper screen)
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		
		final DynamicLoader<Sensor> listaClassiSensori = new DynamicLoaderImpl<Sensor>("domo.devices", "Sensor", "AbstractSensor");			
		listaClassiSensori.setModulePath("classi");
		final Set<String> resLoader = listaClassiSensori.updateModuleList();
		
		final ArrayList <Map <String, String>> sensorTypeList = new ArrayList<>();
		resLoader.forEach(x -> {
			try {
				final HashMap <String, String> t = new HashMap<>();
				t.put("name", listaClassiSensori.createClassInstance(x).getName());
				t.put("image", listaClassiSensori.createClassInstance(x).getImagePath());
				t.put("type", listaClassiSensori.createClassInstance(x).getType().toString());
				t.put("rif", x);
				sensorTypeList.add(t);
				
			} catch (Exception e) {
				fail(e.toString());
			}
		});
		
		final GUIFlat t = new GUIFlatImpl("Domo", sensorTypeList);
		final TheController controller = new TheController(t);
		controller.startTesting(new DomoTestImpl());
	}
}
