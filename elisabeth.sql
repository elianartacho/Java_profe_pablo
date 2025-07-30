-- 1
select * from tarjetas join cuentas on fk_cuenta= id_cuenta 
join clientes on fk_cliente = id_cliente 
where nif = '10481533L';

-- 2
select  id_cliente,concat(nombre,apellido1,apellido2),municipio,id_cuenta,numero
from clientes join cuentas on id_cliente=fk_cliente 
left join tarjetas  on id_cuenta =fk_cuenta
where id_tarjeta is null and provincia =  'Madrid';

-- 3

select c.fk_cliente, c.numero ,e.anyo,e.mes ,sum(importe) from cuentas c join extractos e on id_cuenta=fk_cuenta
join movimientos m on id_extracto= fk_extracto where fk_cliente = 29 
group by id_extracto;



-- 4
select id_cliente ,nombre ,apellido1,apellido2,count(id_tarjeta) cant from clientes join 
cuentas on id_cliente =fk_cliente join tarjetas on id_cuenta= fk_cuenta
group by id_cliente
having cant > 4;

-- 5
select distinct id_cliente ,nombre,apellido1,apellido2 from clientes join cuentas on id_cliente=fk_cliente
join tarjetas on id_cuenta = fk_cuenta join movimientos on id_tarjeta = fk_tarjeta 
where month(fecha) = 06 and year(fecha)= 2020 and importe <
(select avg(importe) from movimientos where month(fecha)= 06 and fk_tipo= 1);

