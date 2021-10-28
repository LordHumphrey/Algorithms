public class ShareStack {
    public int[] stackElement;
    public int stackSize;
    public int top1, top2;

    public ShareStack(int stackSize) {
        this.stackElement = new int[stackSize];
        this.stackSize = stackSize;
        this.top1 = -1;
        this.top2 = stackSize;
    }

    public static void main(String[] args) {
        ShareStack shareStack = new ShareStack(10);
        shareStack.pushIntoStack(1, 1);
        shareStack.pushIntoStack(1, 2);
        shareStack.pushIntoStack(2, 6);
        shareStack.pushIntoStack(2, 5);
        shareStack.pushIntoStack(2, 4);
        shareStack.outputStack(1);
        shareStack.outputStack(2);

        shareStack.popFromStack(1);
        shareStack.outputStack(1);

        shareStack.popFromStack(2);
        shareStack.outputStack(2);
    }

    public boolean pushIntoStack(int stackNum, int num) {
        if (stackNum == 1) {
            stackElement[++top1] = num;
            return true;
        } else if (stackNum == 2) {
            stackElement[--top2] = num;
            return true;
        }
        return false;
    }

    public int popFromStack(int stackNum) {
        int res = Integer.MAX_VALUE;
        if (stackNum == 2) {
            if ((top2 + 1) <= stackSize) {
                stackElement[top2] = Integer.MAX_VALUE;
                res = stackElement[++top2];
            }
        } else {
            if ((top1 - 1) >= 0) {
                stackElement[top1] = Integer.MAX_VALUE;
                res = stackElement[--top1];
            }
        }
        return res;
    }

    public int getStackTopElement(int stackNum) {
        if (stackNum == 2) {
            if ((top2 + 1) <= stackSize) {
                return stackElement[++top2];
            }
        } else {
            if ((top1 - 1) >= 0) {
                return stackElement[top1];
            }
        }
        return Integer.MAX_VALUE;
    }

    public void outputStack(int stackNum) {
        if (stackNum == 1) {
            for (int i =top1; i >=0; i--) {
                System.out.print(stackElement[i] + " ");
            }
            System.out.println("");
        }
        if (stackNum == 2) {
            for (int i = top2; i < stackSize; i++) {
                System.out.print(stackElement[i] + " ");
            }
            System.out.println("");
        }
    }
}
