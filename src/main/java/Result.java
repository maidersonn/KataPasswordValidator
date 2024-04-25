public interface Result<V, E> {
    Boolean isSuccess();
    V getValue();
    E getError();
}
