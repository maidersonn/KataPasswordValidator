import security.Result;

import java.util.List;

public interface Strategy {
    Result<Boolean, List<String>> execute(String password, PasswordValidator passwordInstance);
}
