
#sql("getGoodsInfo")
 select  id as goods_id,artNo as goods_sn,name as goods_name,sales as click_count
 ,brand_id,market_price,price as shop_price, logo as original_img, sales as goods_number,artNo as goods_brief,
 imgs
 from s_goods where  id=?
#end
#sql("getGoodsDInfo")
select  details as goods_desc  from s_goods_detail where  goods_id=?
#end
#sql("getBrand")
 select id as brand_id,name as brand_name  from s_brand
#end

#sql("getcategorys")
 select id,name,parent_id from s_category where del_flag=0 order by sort asc
#end
#sql("mx")
 select id,name,logo ,market_price as  price from s_goods where del_flag=0 and pass='1' and  state='1' ORDER BY RAND() LIMIT 1
#end

#sql("getsjcategorys")
 select id,name,logo from s_category where del_flag=0 and parent_id<>'0' and logo <>'' ORDER BY RAND() LIMIT 5
#end

#sql("sjgoods")
 select id,name,logo ,market_price as price from s_goods where del_flag=0 and pass='1' and  state='1'   ORDER BY RAND() LIMIT 10
#end


#sql("getfoolrcategorys")
 select id,name,logo from s_category where del_flag=0 and parent_id='0' and id not in('9c3febf2a1784558a3b256b453b59acf','3c3d0ec54b234e4da1ea902cdbe940c8','ff309f7136ec4faaae8b61eec7c4d145')
#end

#sql("getfooldrcategorys")
 select id,name,logo from s_category where del_flag=0 and parent_id=?   ORDER BY RAND() LIMIT 9
#end


#sql("getfooldgoods")
 select id,name,logo ,market_price as price from s_goods s ,s_goods_category c where  s.pass='1' and s.state='1' and s.del_flag=0 and s.id=c.goods_id and c.category_id=? ORDER BY RAND() LIMIT 8
#end