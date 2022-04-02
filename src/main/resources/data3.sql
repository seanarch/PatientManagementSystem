CREATE TABLE `users` (
`email` varchar(50) NOT NULL,
`firstname` varchar(50) NOT NULL,
`lastname` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`admin` boolean,
PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `users` values(
'email@email.com',
'fname',
'lname',
'password',
true
),(
'email2@email.com',
'fname2',
'lname2',
'password',
false
);