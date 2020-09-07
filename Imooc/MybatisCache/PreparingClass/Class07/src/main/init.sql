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
INSERT INTO temp (value1, value2) VALUES ('55555', 'eeeee');
INSERT INTO temp (value1, value2) VALUES ('66666', 'fffff');
INSERT INTO temp (value1, value2) VALUES ('77777', 'ggggg');
INSERT INTO temp (value1, value2) VALUES ('88888', 'hhhhh');
INSERT INTO temp (value1, value2) VALUES ('99999', 'iiiii');
INSERT INTO temp (value1, value2) VALUES ('00000', 'jjjjj');

