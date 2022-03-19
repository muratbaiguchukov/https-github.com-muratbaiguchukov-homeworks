create table users(
id integer primary key,
login varchar(100) not null,
email varchar(100),
password varchar(100) not null,
date_of_registration timestamp
);

create table user_logs(
id integer primary key,
user_id integer references users(id),
enter_date timestamp not null,
success varchar(10)
);