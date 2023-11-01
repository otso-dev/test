select
    ot.order_id,
    ot.order_req_time,
    ot.order_delivery_day,
    ot.user_id,
    ft.food_name,
    pt.payment_price
from
    order_tb ot
left join smalleatsDB.food_tb ft on ot.food_id = ft.food_id
left join smalleatsDB.payment_tb pt on ot.order_id = pt.order_id
where
    ot.user_id = 7;

select
    ut.user_id,
    ot.order_id,
    omt.order_menu_numbers,
    fmt.food_menu_name,
    fmt.food_menu_price
from
    order_menu_tb omt
left join smalleatsDB.order_tb ot on omt.order_id = ot.order_id
left join food_menu_tb fmt on fmt.food_menu_id = omt.menu_id
left join smalleatsDB.user_tb ut on ot.user_id = ut.user_id
where
    ot.user_id = 7;