public class Failure<Nothing, E> implements Result<Nothing, E>{
    private E errors;

    public Failure(E errors) {
        this.errors = errors;
    }

    @Override
    public Boolean isSuccess() {
        return Boolean.FALSE;
    }

    @Override
    public Nothing getValue() {
        return null;
    }

    @Override
    public E getError() {
        return this.errors;
    }
}
