package clazz;

import java.awt.Component;
import java.util.Set;

public class main {

	void main() {
		
		Reflections reflector=new Reflections("");
		Set<Class<?>> list=reflector.getTypesAnnotatedWith(Component.class);
		for(int i=0;i<3;i++) {
			
		}
	}
}
