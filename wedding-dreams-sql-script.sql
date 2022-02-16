
drop table assets;
drop table asset_types;
drop table attendee_meal_choices;
drop table attendee_plus_one_meal_choices;
drop table attendees;
drop table betrothed ;
drop table employees ;
drop table meal_options;
drop table users;
drop table wedding_bookings ;


/*

create table if not exists users(
 	email varchar(255),
 	user_name varchar(80),
 	pass_word varchar(80),
 	primary key(email)
	
);

create table if not exists asset_types (
	asset_id int,
	asset_type varchar(40),
	primary key(asset_id)
);

create table if not exists assets(
	new_asset_id int,
	email varchar(40),
	company_name varchar(40),
	price float,
	asset_id int,
	primary key(new_asset_id),
	foreign key(asset_id) references asset_types(asset_id)
	


);

create table if not exists wedding_bookings (
	wedding_booking_id int,
	budget float,
	wedding_date date,
	RSVP_date date,
	primary key(wedding_booking_id)
	

);



create table if not exists asset_bookings(
	wedding_booking_id int,
	wedding_date date,
	asset_booking_id int,
	primary key(asset_booking_id),
	foreign key (wedding_booking_id) references wedding_bookings(wedding_booking_id)
	

);

create table if not exists employees(
	employee_email varchar(40),
	primary key(employee_email),
	foreign key (employee_email) references users(email)
	
	
);

create table if not exists attendees(
	attendee_email varchar(40),
	wedding_booking_id int,
	RSVP_response boolean,
	PLUS_ONE_response boolean,
	primary key(attendee_email, wedding_booking_id),
	foreign key (attendee_email) references users(email),
	foreign key (wedding_booking_id) references wedding_bookings (wedding_booking_id)

);

create table if not exists betrothed (
	bethrothed_email varchar(255),
	wedding_booking_id int,
	primary key(bethrothed_email),
	foreign key (wedding_booking_id) references wedding_bookings(wedding_booking_id)
	

);

create table if not exists meal_options(
	meal_id int,
	meal_description varchar(40),
	primary key(meal_id)
);

create table if not exists attendee_meal_choices(
	attendee_email varchar(40),
	lunch_choice int,
	dinner_choice int,
	wedding_booking_id int,
	primary key(attendee_email, wedding_booking_id),
	foreign key (attendee_email, wedding_booking_id) references attendees(attendee_email, wedding_booking_id),
	foreign key (lunch_choice) references meal_options(meal_id),
	foreign key (dinner_choice) references meal_options(meal_id)

);

create table if not exists attendee_plus_one_meal_choices(
	attendee_email varchar(40),
	lunch_choice int,
	dinner_choice int,
	wedding_booking_id int,
	primary key(attendee_email, wedding_booking_id),
	foreign key (attendee_email, wedding_booking_id) references attendees(attendee_email, wedding_booking_id),
	foreign key (lunch_choice) references meal_options(meal_id),
	foreign key (dinner_choice) references meal_options(meal_id)

);

/*
insert into meal_options values 
(1, 'meat'),
(2, 'fish'),
(3, 'veggie');

insert into asset_types values 
(1, 'venues'),
(2, 'caterers'),
(3, 'florists'),
(4, 'photographers'),
(5, 'musicians');

*/
