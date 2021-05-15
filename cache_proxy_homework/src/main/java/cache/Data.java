package cache;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

class Data implements Serializable {
    private String methodName;
    private Object[] args;
    private Object invoke;

    Data(String method, Object[] args, Object invoke) {
        this.methodName = method;
        this.args = args;
        this.invoke = invoke;
    }

    Data(String method, Object[] args) {
        this.methodName = method;
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals( methodName, data.methodName ) && Arrays.equals( args, data.args );
    }

    @Override
    public int hashCode() {
        int result = Objects.hash( methodName );
        result = 31 * result + Arrays.hashCode( args );
        return result;
    }

    public Object getInvoke() {
        return invoke;
    }
}