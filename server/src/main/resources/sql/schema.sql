create table user (
    username varchar(32) not null,
    name varchar(64) not null,
    team varchar(64),
    email varchar(64),
    phone varchar(64),
    role varchar(32) not null,
    password varchar(255) not null,
    created_date datetime not null,
    primary key (username)
) engine=InnoDB;

create table dispenser (
    id bigint not null auto_increment,
    code varchar(64) not null,
    status varchar(32) not null,
    latitude varchar(64) not null,
    location varchar(128),
    longitude varchar(64) not null,
    feed_cnt integer,
    created_date datetime not null,
    created_username varchar(32),
    updated_date datetime,
    primary key (id)
) engine=InnoDB;

create table dispenser_status_hist (
    id bigint not null auto_increment,
    dispenser_id bigint,
    version integer not null,
    feed_percent integer,
    trash_percent integer,
    motion_status varchar(32),
    motor_status varchar(32),
    created_date datetime not null,
    primary key (id)
) engine=InnoDB;

create table user_dispenser (
    id bigint not null auto_increment,
    username varchar(32),
    dispenser_id bigint,
    created_date datetime not null,
    primary key (id)
) engine=InnoDB;

alter table dispenser
    add constraint UK_9ss9116eltkqmy30uo8oh6oyn unique (code);

alter table dispenser_status_hist
    add constraint FKb46xgo409t6olqljnk80ir6b5
    foreign key (dispenser_id)
    references dispenser (id);

alter table user_dispenser
    add constraint FK7kyw7aufhbct2b2u61jvhi14u
    foreign key (dispenser_id)
        references dispenser (id);

alter table user_dispenser
    add constraint FKt5hqtwu6ewstl5mxb6ucslt00
    foreign key (username)
    references user (username);
