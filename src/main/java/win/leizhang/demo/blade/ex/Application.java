package win.leizhang.demo.blade.ex;

import com.blade.Blade;

/**
 * Created by zealous on 2018/7/26.
 */
public class Application {

    public static void main(String args[]) {
        Blade.of().get("/", ctx -> ctx.text("hello, leizhang!")).start(Application.class, args);
    }
}
