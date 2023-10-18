SELECT
    fmb.food_menu_id,
    fmb.food_menu_name,
    fmb.food_menu_price,
    omb.order_menu_numbers,
    ob.food_id
from
	order_tb ob
left outer join order_menu_tb omb on(omb.order_id = ob.order_id)
left outer join food_menu_tb fmb on(fmb.food_menu_id = omb.menu_id)
where
    ob.order_id = 8
group by
	fmb.food_menu_id,
    omb.order_menu_numbers;