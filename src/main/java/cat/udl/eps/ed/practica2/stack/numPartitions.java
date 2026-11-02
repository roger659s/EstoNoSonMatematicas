package cat.udl.eps.ed.practica2.stack;

public class numPartitions {
    private static class Context {
        // Parameters
        final int sum;
        final int numParts;
        // Local variables
        int np1;
        int np2;
        // Entry point
        EntryPoint entryPoint;

        public Context(int sum, int numParts) {
            this.sum = sum;
            this.numParts = numParts;
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

    public static int numPartitionsRec(int sum) {
        // Precondition: sum > 0
        int count = 0;
        for (int numParts = 1; numParts <= sum; ++numParts) {
            count += numPartitionsRec(sum, numParts);
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
        // Precondition: sum > 0
        int return_ = 0;
        var stack = new ArrayStack<Context>();/*MIRAR*/
        stack.push(new Context(sum, numParts));
        while (!stack.isEmpty()) {
            var context = stack.top();
            switch (context.entryPoint) {
                case CALL -> {
                    if (context.numParts <= 0 || context.numParts > context.sum) {
                        return_ = 0;
                        stack.pop();
                    } else if (context.numParts == context.sum){
                        return_ = 1;
                        stack.pop();
                    } else {
                        context.entryPoint = EntryPoint.RESUME1;
                        stack.push(new Context(context.sum - 1, context.numParts - 1));
                    }
                }
                case RESUME1 -> {
                    context.np1 = return_;
                    context.entryPoint = EntryPoint.RESUME2;
                    stack.push(new Context(context.sum - context.numParts, context.numParts));
                }
                case RESUME2 -> {
                    context.np2 = return_;
                    return_ = context.np1 + context.np2;
                    stack.pop();
                }
            }
        }
        return return_;
    }
}
