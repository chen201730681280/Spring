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

drop table if exists test;
create table test
(
  id     int auto_increment primary key,
  value1 varchar(100) null,
  value2 varchar(100) null
);

INSERT INTO test (value1, value2) VALUES ('11111', 'aaaaa');
INSERT INTO test (value1, value2) VALUES ('22222', 'bbbbb');
INSERT INTO test (value1, value2) VALUES ('33333', 'ccccc');
INSERT INTO test (value1, value2) VALUES ('44444', 'ddddd');