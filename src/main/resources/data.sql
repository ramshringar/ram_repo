INSERT INTO USERS (empid, accesskey, country) VALUES  ('Miller', 'TRMLLR', 'SG');
INSERT INTO USERS (empid, accesskey, country) VALUES  ('Tessa', 'TRTSSA', 'SG');
INSERT INTO USERS (empid, accesskey, country) VALUES  ('Dosson', 'TRDSSN', 'HK');
INSERT INTO USERS (empid, accesskey, country) VALUES  ('Ricky', 'TRRCKY', 'SG');
INSERT INTO USERS (empid, accesskey, country) VALUES  ('Aaron', 'TRARON', 'SG');
INSERT INTO USERS (empid, accesskey, country) VALUES  ('Bob', 'TRBOB', 'HK');

INSERT INTO TEAMHIERARCHY (empid, managerid) VALUES  ('Tessa', 'Miller');
INSERT INTO TEAMHIERARCHY (empid, managerid) VALUES  ('Dosson', 'Miller');
INSERT INTO TEAMHIERARCHY (empid, managerid) VALUES  ('Ricky', 'Tessa');
INSERT INTO TEAMHIERARCHY (empid, managerid) VALUES  ('Aaron', 'Tessa');
INSERT INTO TEAMHIERARCHY (empid, managerid) VALUES  ('Bob', 'Dosson');