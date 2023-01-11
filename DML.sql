USE poms;

drop  table cancellation;

insert into cancellation(date_time, reason)
 values 	(curdate(), "Any" );
select * from cancellation;