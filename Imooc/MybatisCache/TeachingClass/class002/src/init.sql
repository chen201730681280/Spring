drop table if exists temp;
create table temp
(
  id     int auto_increment primary key,
  value1 varchar(100) null,
  value2 varchar(100) null
);

INSERT INTO temp (value1, value2) VALUES ('11111', 'aaaaa');
INSERT INTO temp (value1, value2) VALUES ('22222', 'bbbbb');
INSERT INTO temp (value1, value2) VALUES ('33333', 'ccccc');
INSERT INTO temp (value1, value2) VALUES ('44444', 'ddddd');

