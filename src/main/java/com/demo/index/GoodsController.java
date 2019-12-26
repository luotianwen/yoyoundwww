package com.demo.index;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;
import sun.misc.Cache;

import java.util.List;

public class GoodsController extends Controller {

    public void index(){
        String id=getPara("id");
        Record goods= Db.findFirstByCache("goods",id, Db.getSqlPara("getGoodsInfo").getSql(),id);
        set("goods",goods);
        Record d= Db.findFirstByCache("goodsd",id, Db.getSqlPara("getGoodsDInfo").getSql(),id);
        set("imgs",goods.getStr("imgs").split("\\|"));
         set("d",d);

        List<Record> brands= Db .findByCache("brands","brands",Db.getSqlPara("getBrand").getSql());
        for (Record b:brands){
            if(goods.getStr("brand_id").equals(b.getStr("brand_id"))){
                goods.set("brand_name",b.getStr("brand_name"));
                break;
            }

        }
        render("goods.html");
    }
}
