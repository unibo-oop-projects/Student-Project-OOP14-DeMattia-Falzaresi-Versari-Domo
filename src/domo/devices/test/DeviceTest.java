package domo.devices.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import domo.devices.Sensor;
import domo.devices.loader.DynamicLoader;
import domo.devices.loader.DynamicLoaderImpl;

/**
 * 
 * @author Marco Versari
 *
 */
public class DeviceTest {

	/**
	 * 
	 */
	@Test
	public void test() {		
		final String classPath = "res" + File.separator + "SensorUpgrade";//System.getProperty("user.home") + File.separator + "SensorUpgrade";
		System.out.println(classPath);
		final DynamicLoader<Sensor> instance = new DynamicLoaderImpl<Sensor>("domo.devices", "Sensor");			
		
		instance.setModulePath(classPath);
		final Set<String> res = instance.updateModuleList();
		
		assertSame(res.size(), 1);
		
		res.forEach(x -> {
			try {
				System.out.println(instance.createClassInstance(x).getId());
				System.out.println(instance.createClassInstance(x).getName());
			} catch (Exception e) {
				fail(e.toString());
			}
		});
	}

}
