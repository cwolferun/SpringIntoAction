package miscExamples;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quickly")
public class QuickSort implements SortingAlgorithm {
}
