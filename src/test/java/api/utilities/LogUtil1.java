package api.utilities;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

public class LogUtil1 {
	
	
	@Test
	public void testLog1() {
		
		Logger log = LogManager.getLogger("LogUtil");
		System.out.println("This is log demo");
		log.info("This is for info only");
		log.debug("This is debug message");
		log.error("This is error message");
		log.warn("This is warnig message");
		
	}

}
