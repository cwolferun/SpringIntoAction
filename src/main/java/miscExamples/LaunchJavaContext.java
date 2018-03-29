package miscExamples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaunchJavaContext {


    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringContext.class);
        BusinessService service = context.getBean(BusinessService.class);
        service.printName("fe");
    }
}
