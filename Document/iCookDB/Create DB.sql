Create database iCookDB;
Use iCookDB;
create table tbl_user(
	UserID varchar(255) not null,
    UserName varchar(255) not null,
    Password varchar(255) not null,
    Role varchar(255) not null,
    primary key (UserID)
);

create table tbl_category(
	CategoryID int(11) not null  AUTO_INCREMENT,
    CategoryName varchar(500) not null,
    primary key (CategoryID)
);

create table tbl_material(
	MaterialID int(11) not null AUTO_INCREMENT,
    MateialName varchar(2000) not null,
    primary key (MaterialID)
);

create table tbl_food(
	FoodID int (11) auto_increment not null,
    FoodName varchar(500) not null,
    Tutorial varchar(8000) not null,
    Content varchar(8000) not null,
    LinkImage varchar(255) not null,
    ListMaterial varchar(2000) not null,
    MaterialInfo varchar (3000) not null,
    CategoryID int(11) not null,
    User varchar(255) not null,
    VisitNum int(11),
    primary key (FoodID),
    FOREIGN KEY (CategoryID) REFERENCES tbl_category(CategoryID)
);