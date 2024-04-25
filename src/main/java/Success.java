public class Success<V, Nothing> implements Result<V, Nothing>{

    private final V value;

    public Success(V value) {
        this.value = value;
    }

    @Override
    public Boolean isSuccess() {
        return Boolean.TRUE;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public Nothing getError() {
        return null;
    }
}
