package beStrong.threeDay;

import java.lang.reflect.Method;

public interface Advice {
	void before(Method method);
	void after(Method method);

}
