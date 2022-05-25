package springFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


 * @author prachi.shah
 * @date 3/16/2017
 * @concept Get resource from Spring Application Context using
 *          getResourceFromApplicationContext()
 * @study http://docs.spring.io/spring/docs/current/spring-framework-reference/html/resources.html
 * @notes Add to the build path an external library
 *        spring-beans-4.2.5.RELEASE-sources.jar Add to the build path an
 *        external library spring-context-4.2.5.RELEASE-sources.jar Add to the
 *        build path an external library
 *        spring-context-support-4.2.5.RELEASE-sources.jar Add to the build path
 *        an external Spring library commons-logging-1.1.3.jar
 
public class getResourceFromApplicationContext {

	protected static Log log = LogFactory.getLog(getResourceFromApplicationContext.class);

	public String brandLogoUrl = "file:///Users/prachi.shah/Pictures/PRACHI.jpg";

	public static void main(String[] args) throws BeansException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "If-you-have-any.xml" });
	}

}
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class getResourceFromApplicationContext {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"file:///Users/prachi.shah/Pictures/Beans.xml");

		brandLogoUrlBean obj = (brandLogoUrlBean) context.getBean("helloWorld");
		obj.getMessage();
	}

}
