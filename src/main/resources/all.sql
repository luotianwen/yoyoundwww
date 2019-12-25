
#sql("getGoodsInfo")
 select goods_id,goods_sn,goods_name,click_count,brand_id,market_price,shop_price,goods_desc,original_img,goods_number,goods_brief
 from ecs_goods where goods_id=?
#end

#sql("getGoodscol")
 select img_url,img_original,thumb_url
 from ecs_goods_gallery where goods_id=?
#end
#sql("getBrand")
 select brand_id,brand_name  from ecs_brand
#end

#sql("getcategorys")
 select id,name,parent_id from s_category where del_flag=0 order by sort asc
#end
#sql("mx")
 select id,name,logo ,price from s_goods where del_flag=0 ORDER BY RAND() LIMIT 1
#end

#sql("getsjcategorys")
 select id,name,logo from s_category where del_flag=0 and parent_id<>0 and logo <>'' ORDER BY RAND() LIMIT 5
#end

#sql("sjgoods")
 select id,name,logo ,price from s_goods where del_flag=0 ORDER BY RAND() LIMIT 10
#end