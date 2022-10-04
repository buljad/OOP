
import java.util.Arrays;
public class stack {
    public int cnt = 0;
    public Number[] stack;
    public int stack_len = 1;

    public void stack_init() {
        stack = (Number[]) new Integer[0];
        cnt = 0;
    }
    public void push(Number num) {
        cnt++;
        if (cnt > stack_len) {
            stack_len *= 2;
            stack = Arrays.copyOf(stack, stack_len);
        }
        stack[cnt--] = num;
    }

    public void push_stack(Number[] new_stack) {
        for(Number i : new_stack) {
            push(i);
        }
    }

    public void pop() {
        if (cnt != 0) {
            stack[cnt] = null;
            cnt--;
        }
    }
    public void pop_stack(int num) {
        for(int i = 0; i < num; i++) {
            pop();
        }
    }

    public int count() {
        return cnt;
    }
}
