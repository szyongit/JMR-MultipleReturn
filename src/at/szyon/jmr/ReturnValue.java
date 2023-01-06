package at.szyon.jmr;

public class ReturnValue<V> {
    private final V value;
    private ReturnValue next;

    ReturnValue(V value) {
        this.value = value;
    }

    public final V value() {
        return this.value;
    }
    public final <T> T castValue(Class<T> castClass) {
        return (T) castClass.cast(this.value);
    }
    public final Class getValueType() {
        return (this.value == null ? null : this.value.getClass());
    }

    final void append(ReturnValue value) {
        if(this.next == null) {
            this.next = value;
            return;
        }

        this.next.append(value);
    }

    final int sizeCalc(int start) {
        return (this.next == null ? start : this.next.sizeCalc(start + 1));
    }
    final ReturnValue getAtIndex(int currentIndex, int wishedIndex) {
        if(currentIndex == wishedIndex) {
            return this;
        }

        if(this.next == null) {
            return null;
        }

        return this.next.getAtIndex(currentIndex + 1, wishedIndex);
    }

    public String toString() {
        return this.getClass().getPackageName() + "." + this.getClass().getSimpleName() + ":["+this.value.toString()+"]";
    }
}