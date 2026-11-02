package cat.udl.eps.ed.practica2.stack;

public class numPartitions {
    private static class Context {
        // Parameters
        final int n;
        // Local variables
        int np1;
        int np2;
        // Entry point
        EntryPoint entryPoint;

        public Context(int n) {
            this.n = n;
            this.np1 = 0;
            this.np2 = 0;
            this.entryPoint = EntryPoint.CALL;
        }
    }

    private enum EntryPoint {
        CALL, RESUME1, RESUME2;
    }
    public static int numPartitionsIter(int sum) {
        // Precondition: sum > 0
        int count = 0;
        for (int numParts = 1; numParts <= sum; ++numParts) {
            count += numPartitionsIter(sum, numParts);
        }
        return count;
    }

    public static int numPartitionsRec(int sum, int numParts) {
        // Precondition: sum > 0
        int np1, np2;
        // CALL
        if (numParts <= 0 || numParts > sum) {
            return 0;
        } else if (numParts == sum) {
            return 1;
        } else {
            np1 = numPartitionsRec(sum - 1, numParts - 1);
            // RESUME1
            np2 = numPartitionsRec(sum - numParts, numParts);
            // RESUME2
            return np1 + np2;
        }
    }

    private static int numPartitionsIter(int sum, int numParts) {
        // Precondition: sum > 0 // Transformació a iteratiu de la funció
        int return_ = 0;
        var stack = new ArrayStack();
        stack.push(new Context(n));
        while (!stack.isEmpty()) {
            var context = stack.top();
            switch (context.entryPoint) {
                case CALL -> {

                }
            }
        }

            // numPartitionsRec(int sum, int numParts)
        return return_;
    }


}
