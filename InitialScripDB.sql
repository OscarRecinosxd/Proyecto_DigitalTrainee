


INSERT INTO roles (id,description,name) VALUES 
(1,'Rol de admin','Admins'),
(2,'Rol de cliente','Client'),
(3,'Rol de hotel owner','Hotel Owner');

INSERT INTO hotel_branch_types(id,description,name,is_deleted) VALUES 
(1,'Ideales para extranjeros','Turistico',false),
(2,'baratos a largo plazo','Larga estadia',false),
(3,'para  eventos','Eventos',false);

INSERT INTO hotel_chains(id,description,name,is_deleted) VALUES 
(1,'Cadena de hoteles playeros','Decameron',false),
(2,'Cadena de hoteles para eventos','Intercontinental',false);

INSERT INTO room_types(id,description,is_deleted) VALUES
(1,'Single room',false),
(2,'Double room',false),
(3,'Triple room',false),
(4,'Familiar room',false);

INSERT INTO users(id,email,first_name,last_name,password,phone,role_id,is_deleted) VALUES
(1,'oscarrecinos@gmail.com','Oscar','Recinos','1234','76202020',1,false);

