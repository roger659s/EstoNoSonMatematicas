package cat.udl.eps.ed.practica2.stack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class numPartitionsTest {

    class PartitionsGoldenTest {
        public static final int MAX = 20;
        @Test
        void golden() {
            for (int sum = 1; sum <= MAX ; sum++) {
                var rec = numPartitions.numPartitionsRec(sum);
                var ite = numPartitions.numPartitionsIter(sum);
                assertEquals(rec, ite);
            }
        }
    }
}

