

--FIRST ADMIN with password password
INSERT INTO db_testone.user(id,username,password) values (1, 'luana@pasticciando.it', '$2a$10$O0NpqWtRl/fPwugOvX1ztee1jE/oYiJtV3B9ywbQInBBIh/2LheOG') ON CONFLICT(id) DO NOTHING;
INSERT INTO db_testone.user(id,username,password) values (2, 'maria@pasticciando.it', '$2a$10$O0NpqWtRl/fPwugOvX1ztee1jE/oYiJtV3B9ywbQInBBIh/2LheOG') ON CONFLICT(id) DO NOTHING;

commit;
