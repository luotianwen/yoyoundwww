package com.demo.index;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

public class HelpController extends Controller {

    public void index(){
        String id=getPara("id");
        if(StrKit.isBlank(id)){
            id="26";
        }
        render(id+".html");
    }
}
