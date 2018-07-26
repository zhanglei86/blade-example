package win.leizhang.demo.blade.ex.controller;

import com.blade.kit.StringKit;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.http.Session;
import win.leizhang.demo.blade.ex.model.User;
import win.leizhang.demo.blade.ex.utils.CommonConstant;

/**
 * Created by zealous on 2018/7/26.
 */
@Path
public class LoginController {

    @GetRoute("login")
    public String login() {
        return "login.html";
    }

    @GetRoute("logout")
    public void logout(Session session, Response response) {
        session.removeAttribute(CommonConstant.LOGIN_SESSION_KEY);
        response.redirect("/login");
    }

    @PostRoute("login")
    public String doLogin(User user, Request request, Response response) {

        // 入参
        String userName = user.getUsername();
        String passWord = user.getPassword();

        if (StringKit.isBlank(userName)) {
            request.attribute("error", "用户名不能为空");
            return "index.html";
        }
        if (StringKit.isBlank(passWord)) {
            request.attribute("error", "密码不能为空");
            return "login.html";
        }

        if (!CommonConstant.USERNAME.equalsIgnoreCase(userName) || !CommonConstant.PASSWORD.equalsIgnoreCase(passWord)) {
            request.attribute("error", "用户名或密码错误");
            return "login.html";
        }

        request.session().attribute(CommonConstant.LOGIN_SESSION_KEY, user.getUsername());
        return "index.html";
    }

}
