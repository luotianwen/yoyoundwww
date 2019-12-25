package com.demo.index;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		List<Record> categorys= Db.findByCache("categorys", "categorys", Db.getSqlPara("getcategorys").getSql());
		setSessionAttr("categorys",categorys);
		Record mx=Db.findFirstByCache("mx","mx",Db.getSqlPara("mx").getSql());
		set("mx",mx);
		List<Record> getsjcategorys= Db.findByCache("getsjcategorys", "getsjcategorys", Db.getSqlPara("getsjcategorys").getSql());
		setSessionAttr("getsjcategorys",null);
		List<Record> fkqgs= Db.findByCache("fkqgs", "fkqgs", Db.getSqlPara("sjgoods").getSql());
		set("fkqgs",fkqgs);
		List<Record> rxphs= Db.findByCache("rxphs", "rxphs", Db.getSqlPara("sjgoods").getSql());
		set("rxphs",rxphs);
		List<Record> scrxs= Db.findByCache("scrxs", "scrxs", Db.getSqlPara("sjgoods").getSql());
		set("scrxs",scrxs);
		List<Record> scjps= Db.findByCache("scjps", "scjps", Db.getSqlPara("sjgoods").getSql());
		set("scjps",scjps);
		List<Record> xps= Db.findByCache("xps", "xps", Db.getSqlPara("sjgoods").getSql());
		set("xps",xps);
		render("index.html");
	}
}



