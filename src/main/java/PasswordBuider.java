public class PasswordBuider implements Builder {
    private  int length;
    private boolean uppercase;
    private boolean lowercase;
    private boolean number;
    private boolean underscore;

    @Override
    public void withLength(int size) {
        this.length = size;
    }

    @Override
    public void withLowercase(boolean lowercase) {
        this.lowercase = lowercase;
    }

    @Override
    public void withUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    @Override
    public void withNumber(boolean number) {
        this.number = number;
    }

    @Override
    public void withUnderscore(boolean underscore) {
        this.underscore = underscore;
    }


    public PasswordValidator generate() {
        return new PasswordValidator(this.length, this.uppercase, this.lowercase, this.number, this.underscore);
    }
}
