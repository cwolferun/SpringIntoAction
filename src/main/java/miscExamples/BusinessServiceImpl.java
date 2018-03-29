package miscExamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service        //because it is a regular service
@Scope("singleton")
public class BusinessServiceImpl implements BusinessService {

//    @Autowired
   private DataService dataService;

   @Autowired               //constructor autowire
   BusinessServiceImpl(DataService dataService){
       this.dataService=dataService;
   }

    @Autowired              //setter auto wire
    public void setDataService(DataService dataService){
        this.dataService=dataService;
    }


    @Autowired
    @Qualifier("quickly")
    SortingAlgorithm sortingAlgorithm;

public void printName(String name){
    System.out.println(name);
}
}
