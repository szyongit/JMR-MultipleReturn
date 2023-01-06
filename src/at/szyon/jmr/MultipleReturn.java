package at.szyon.jmr;

public class MultipleReturn {
    public static <V> MultipleReturn of(V value) {
        return new MultipleReturn().append(value);
    }
    public static MultipleReturn empty() {
        return new MultipleReturn();
    }
    private ReturnValue value;

    public <V> MultipleReturn append(V value) {
        if(this.value == null) {
            this.value = new ReturnValue(value);
            return this;
        }

        this.value.append(new ReturnValue(value));
        return this;
    }

    public int amount() {
        return (this.value == null ? 0 : this.value.sizeCalc(1));
    }

    public ReturnValue get(int index) {
        return (this.value == null ? null : this.value.getAtIndex(0, index));
    }
}
