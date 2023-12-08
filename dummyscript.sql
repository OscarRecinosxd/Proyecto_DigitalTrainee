
INSERT INTO public.roles (description,name) VALUES 
('Rol de admin','Admin'),
('Rol de cliente','Client'),
('Rol de hotel owner','Hotel Owner');

INSERT INTO hotel_branch_types(description,name,is_deleted) VALUES 
('Ideales para extranjeros','Turistico',false),
('baratos a largo plazo','Larga estadia',false),
('para  eventos','Eventos',false);

INSERT INTO hotel_chains(description,name,is_deleted) VALUES 
('Cadena de hoteles playeros','Decameron',false),
('Cadena de hoteles para eventos','Intercontinental',false);

INSERT INTO room_types(description,is_deleted) VALUES
('Single room',false),
('Double room',false),
('Triple room',false),
('Familiar room',false);

INSERT INTO users(email,first_name,last_name,password,phone,role_id,is_deleted) VALUES
('oscarrecinos@gmail.com','Oscar','Recinos','1234','76202020',1,false);

INSERT INTO hotel_branches(address,check_in_time,check_out_time,is_deleted,name,hotel_branch_type_id,hotel_chain_id) VALUES
('Puerto de acajutla, playa los cobanos','11:00','13:00',false,'Salinitas',1,1)