CREATE OR REPLACE FUNCTION DateDiff (unit VARCHAR(30), date1 TIMESTAMP, date2 TIMESTAMP) 

/*Varchar(n) – n: karakter sayısını ifade eder.
1 – 8000 karakter arasında karakter tutabilir.
Karakter sayısı daha kısa girilirse, chardaki gibi boşluklarla tamamlamaz.*/
    
	RETURNS INT AS $$
   DECLARE
     diff_interval INTERVAL; 
     diff INT = 0;
     years_diff INT = 0;
   BEGIN
     IF unit IN ('yy', 'yyyy', 'year', 'mm', 'm', 'month') THEN
       years_diff = DATE_PART('year', date2) - DATE_PART('year', date1);
 
       IF unit IN ('yy', 'yyyy', 'year') THEN
     --SQL Server geçen tam yılları saymaz (yalnızca yıl bölümleri arasındaki fark)       
	 RETURN years_diff;
       ELSE
     -- Eğer bitiş ayı başlangıç ayından küçükse, 
         RETURN years_diff * 12 + (DATE_PART('month', date2) - DATE_PART('month', date1)); 
       END IF;
     END IF;
 
     -- Eksi işlemi 'DDD günleri HH:MI:SS' aralığını döndürür   
     diff_interval = date2 - date1;
 
     diff = diff + DATE_PART('day', diff_interval);
 
     IF unit IN ('wk', 'ww', 'week') THEN
       diff = diff/7;
       RETURN diff;
     END IF;
 
     IF unit IN ('dd', 'd', 'day') THEN
       RETURN diff;
     END IF;
 
     diff = diff * 24 + DATE_PART('hour', diff_interval); 
 
     IF unit IN ('hh', 'hour') THEN
        RETURN diff;
     END IF;
 
     diff = diff * 60 + DATE_PART('minute', diff_interval);
 
     IF unit IN ('mi', 'n', 'minute') THEN
        RETURN diff;
     END IF;
 
     diff = diff * 60 + DATE_PART('second', diff_interval);
 
     RETURN diff;
   END;
   $$ LANGUAGE plpgsql;
   --ilk tarih küçük olan tarih
     SELECT DATEDIFF('month', '2022-09-30 09:54:55'::timestamp, '2022-12-30 10:56:10'::timestamp);
	 SELECT DATEDIFF('day', '2022-11-28 09:54:55'::timestamp, '2022-11-30 10:56:10'::timestamp);
	 SELECT DATEDIFF('hour', '2022-11-30 09:54:55'::timestamp, '2022-11-30 10:56:10'::timestamp);
	 SELECT DATEDIFF('minute', '2022-11-30 09:25:55'::timestamp, '2022-11-30 10:56:10'::timestamp);

	--Customerların bugün ki yaşları
     select firstname as "Ad",DATEDIFF('year',birthday,current_date::timestamp) as "Yaş"from customers

	--Müşterileri ve adreslerini getiren fonksiyon
	create or replace function customer_with_adress()
	returns table (customer_name text, customer_adress varchar, city varchar, street varchar)
	as
	$$
	begin
	return query 
	select 
	CONCAT(c.firstname,' ', c.lastname) as "Müşteri adı", at.name as "Adres Başlığı",
	city.name as "Şehir", a.street as "Mahalle Adı"
	from customers c
	inner join address a on c.id=a.customerid 
	inner join addresstitle at on a.addresstitleid=at.id 
	inner join city on a.cityid=city.id
	order by c.firstname asc;
	END
	$$
	language 'plpgsql';

	select * from customer_with_adress()
	
--------------------------------------------------------------------------------------------------------------

	--Ürünlerin adını, bedenlerini ve stok durumunu getir.
	create view products_size_with_stock
	as
	select p.name as "Ürün Adı",s.name as "Ürün Bedeni", p.stock as "Stok Durumu" 
	from products p
	inner join colorsizerelations cs 
	on p.colorsizeid=cs.sizeid
	inner join size s on cs.id=s.id
	group by p.name,s.name,p.stock

	select * from products_size_with_stock

	--Siparişlerin tarihini ve müşterilerin tüm bilgilerini getir.
	create view order_date_customer_info
	as
	select c.firstname as "Müşteri Adı",c.lastname as "Müşteri Soyadı",
	c.phonenumber as "Müşteri Telefon Nu",c.birthday as "Müşteri Doğum Tarihi",
	at.name as "Adres Başlığı",city.name as "Şehir",a.street as "Mahalle Adı"
	from orders o
	inner join customers c on o.customerid=c.id
	inner join address a on c.id=a.id
	inner join addresstitle at on a.addresstitleid=at.id
	inner join city on a.cityid=city.id
	order by c.firstname asc

	select * from order_date_customer_info













