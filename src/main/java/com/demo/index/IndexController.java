package com.demo.index;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;
import java.util.Random;

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

		List<Record> getfoolrcategorys= Db.findByCache("getfoolrcategorys", "getfoolrcategorys", Db.getSqlPara("getfoolrcategorys").getSql());
		for (Record f:getfoolrcategorys
			 ) {
			List<Record> fooldrcategorys= Db.findByCache("getfooldrcategorys", f.getStr("id"), Db.getSqlPara("getfooldrcategorys").getSql(),f.getStr("id"));
			for (Record fd:fooldrcategorys
			) {

				List<Record> getfooldgoods= Db.findByCache("getfooldgoods", fd.getStr("id"), Db.getSqlPara("getfooldgoods").getSql(),fd.getStr("id"));
				fd.set("getfooldgoods",getfooldgoods);
			}
            f.set("color",randomHexStr());
			f.set("fooldrcategorys",fooldrcategorys);

		}
		set("getfoolrcategorys",getfoolrcategorys);
		render("index.html");
	}
	public static String randomHexStr() {
		try {
			StringBuffer result = new StringBuffer();
			for(int i=0;i<6;i++) {
				//随机生成0-15的数值并转换成16进制
				result.append(Integer.toHexString(new Random().nextInt(16)));
			}
			return result.toString().toUpperCase();
		} catch (Exception e) {
			System.out.println("获取16进制字符串异常，返回默认...");
			return "00CCCC";
		}
	}
}



