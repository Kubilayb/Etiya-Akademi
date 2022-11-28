# EtiyaAkademi

>- <h3>Soru 1</h3> --Verilen sipariş başlıklarını en azdan en çok ' a sırala:

SELECT at.name as "Sipariş başlıkları",COUNT(*) as "Sayısı" FROM orders o
right join address a
on o.addressid=a.id
inner join addresstitle at
on at.id=a.addresstitleid
GROUP BY at.name
ORDER BY COUNT(*) ASC
# EtiyaAkademi

>- **<h3>Soru 1</h3> --Verilen sipariş başlıklarını en azdan en çok ' a sırala:**

```
SELECT at.name as "Sipariş başlıkları",COUNT(*) as "Sayısı" FROM orders o
right join address a
on o.addressid=a.id
inner join addresstitle at
on at.id=a.addresstitleid
GROUP BY at.name
ORDER BY COUNT(*) ASC
 
```
#### Kod Çıktısı :

![1](https://user-images.githubusercontent.com/96656340/204249629-f18ef316-c121-4991-8d54-7c5ff68d0e5a.PNG)


-----------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 2</h3> Hangi kargo şirketinin ne kadar teslimat yaptığını büyükten küçüğe sırala:**

```
SELECT c.name as "Kargo",COUNT(o.cargoid) "Sipariş Sayısı" FROM orders o
right join cargo c
on c.id=o.cargoid
GROUP BY c.name
ORDER BY COUNT(o.cargoid) DESC
 
```

#### Kod Çıktısı :

![2](https://user-images.githubusercontent.com/96656340/204251764-4ac2f75d-c3d2-491c-aa58-a892857dc620.PNG)

-----------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 3</h3> Stok sayısı 10 ile 50 arasındaki product ' ları bize getir**

```
SELECT * from products
WHERE stock BETWEEN 10 AND 50
 
```

#### Kod Çıktısı :


![3](https://user-images.githubusercontent.com/96656340/204253222-2ca45c3d-22f3-49ff-8b8f-078d2ac1b30a.PNG)
