-- drop database BD_Precios;

create database BD_Precios;
use BD_Precios;

create table producto(
cod_prod int primary key  auto_increment,
nombre_prod varchar(40) not null);

insert into producto values(null,'Empanada de carne');
insert into producto values(null,'Empanada de pollo');


create table insumo(
cod_insumo int primary key auto_increment,
cod_prod int not null,
nombre_insumo varchar(40) not null,
precio_insumo decimal(8,2),
foreign key (cod_prod) REFERENCES producto (cod_prod)
);

insert into insumo values(null,1,'Carne molida 100 g',4.80);
insert into insumo values(null,1,'Harina ',4.80);
insert into insumo values(null,2,'Pollo desilachado',7.10);
insert into insumo values(null,2,'Pollo desilachado',74.0);
insert into insumo values(null,2,'Azucar ',1.20);


create table cliente(
cod_cliente int primary key  auto_increment,
nombre_cliente varchar(50) not null);

--
insert into cliente values(null,'Alex Gallozo');



create table pedido(
cod__pedido int auto_increment primary key,
fecha_de_pedido date,
fecha_de_entrega date,
cod_prod int not null,
cod_cliente int,
cantidad int, 
direccion_pedido varchar(58) not null,
estado_pedido int  default 0,
foreign key (cod_prod) references producto(cod_prod),
foreign key(cod_cliente) references cliente(cod_cliente)
);


insert into pedido values(null,curdate(),'2021-01-20',1,1,4,'Jr.Roosevel 840 Surco',1);


-- Nota para el pedido cuando el estado esta en 1 significa que ya esta cancelado o que ya se ha entregado el peido,cunado esta en 0 es porque falta entregar o cancelar
-- Nota para el pedido cuando el estado esta en 1 significa que ya esta cancelado o que ya se ha entregado el peido,cunado esta en 0 es porque falta entregar o cancelar
-- Nota para el pedido cuando el estado esta en 1 significa que ya esta cancelado o que ya se ha entregado el peido,cunado esta en 0 es porque falta entregar o cancelar


select*from pedido;
select*from insumo;
select*from producto;
select*from cliente;
select*from pedido  where estado_pedido=1;


-- Actualizacion de insumos
update insumo set  cod_prod=2,nombre_insumo='Harina en polvo',precio_insumo=10.0 where cod_insumo=1;


-- Lista de Productos y su precio
select p.nombre_prod,sum(precio_insumo) as 'suma' from insumo as i inner join producto as p
on i.cod_prod=p.cod_prod
group by(i.cod_prod);





-- Lista de los pedidos segun el estado(1) =significa que son los pedidos pendientes
select fecha_de_entrega,p.nombre_prod from pedido pe inner join producto p
on pe.cod_prod=p.cod_prod  where estado_pedido=1 ;


-- Busqueda del insumos segun el codigo de producto
select nombre_insumo,precio_insumo from insumo  where cod_prod=1;


-- Procdeures1
DELIMITER $$
create procedure lista_de_insumos(cod int)
begin
select nombre_insumo,precio_insumo from insumo  where cod_prod=cod;
end$$
DELIMITER ;


Call lista_de_insumos(1);


-- Procdeures2
DELIMITER $$
create procedure  lista_precios_productos()
begin
select p.nombre_prod,sum(precio_insumo) as 'suma' from insumo as i inner join producto as p
on i.cod_prod=p.cod_prod
group by(i.cod_prod);

end $$
DELIMITER ;

call lista_precios_productos();



DELIMITER $$
create procedure listapedido()
begin 
select cod__pedido,fecha_de_pedido,fecha_de_entrega,c.nombre_cliente,p.nombre_prod  from cliente c inner join pedido pe
on  c.cod_cliente=pe.cod_cliente inner join producto p on pe.cod_prod=p.cod_prod;
end $$
DELIMITER ;

call listapedido();

