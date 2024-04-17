public class PasswordBuider implements Builder {
    private  int length;
    private boolean uppercase;
    private boolean lowercase;
    private boolean haveNumber;
    private boolean haveUnderscore;

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
        this.haveNumber = number;
    }

    @Override
    public void withUnderscore(boolean underscore) {
        this.haveUnderscore = underscore;
    }


    public PasswordValidator generate() {
        return new PasswordValidator(this.length, this.uppercase, this.lowercase, this.haveNumber, this.haveUnderscore);
    }
}
