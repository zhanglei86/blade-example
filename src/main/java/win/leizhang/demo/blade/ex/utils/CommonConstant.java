package win.leizhang.demo.blade.ex.utils;

import com.blade.Blade;
import com.blade.Environment;

/**
 * Created by zealous on 2017/12/28.
 */
public class CommonConstant {

    static {
        Environment environment = Blade.of().environment();
        USERNAME = environment.get("app.username").get();
        PASSWORD = environment.get("app.password").get();
    }

    public static final String USERNAME;
    public static final String PASSWORD;

    public static final String LOGIN_SESSION_KEY = "loginuser";

    // other

}
