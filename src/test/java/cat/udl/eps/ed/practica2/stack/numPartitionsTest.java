package cat.udl.eps.ed.practica2.stack;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class numPartitionsTest {
    private final int MAX = 20;
    @Test
    void golden() {
        for (int sum = 1; sum <= MAX ; sum++) {
            var rec = numPartitions.numPartitionsRec(sum);
            var ite = numPartitions.numPartitionsIter(sum);
            assertEquals(rec, ite);
        }
    }

    @Test
    void know_value_should_match(){
        assertEquals(1, numPartitions.numPartitionsIter(1));
        assertEquals(2, numPartitions.numPartitionsIter(2));
        assertEquals(3, numPartitions.numPartitionsIter(3));
        assertEquals(5, numPartitions.numPartitionsIter(4));
        assertEquals(7, numPartitions.numPartitionsIter(5));
    }



}

