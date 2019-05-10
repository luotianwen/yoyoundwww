
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