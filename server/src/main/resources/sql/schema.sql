create table user (
    username varchar(32) not null,
    created_date datetime not null,
    email varchar(64),
    name varchar(64) not null,
    password varchar(255) not null,
    phone varchar(64),
    role varchar(32) not null,
    team varchar(64),
    primary key (username)
) engine=InnoDB;

create table dispenser (
    id bigint not null auto_increment,
    code varchar(64) not null,
    created_date datetime not null,
    created_username varchar(32),
    feed_cnt integer,
    latitude varchar(64) not null,
    location varchar(128),
    longitude varchar(64) not null,
    status integer not null,
    updated_date datetime,
    primary key (id)
) engine=InnoDB;

create table dispenser_status_hist (
    id bigint not null auto_increment,
    created_date datetime not null,
    feed_percent integer,
    motion_status integer,
    motor_status integer,
    trash_percent integer,
    version integer not null,
    dispenser_id bigint,
    primary key (id)
) engine=InnoDB;

create table user_dispenser (
    id bigint not null auto_increment,
    created_date datetime not null,
    dispenser_id bigint,
    username varchar(32),
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
