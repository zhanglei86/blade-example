package win.leizhang.demo.blade.ex.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;

/**
 * Created by zealous on 2018/7/26.
 */
@Path
public class IndexController {

    @GetRoute("index")
    public String index() {
        return "index.html";
    }

}
