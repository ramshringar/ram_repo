INSERT INTO USERS (emp_id, access_key, country) VALUES  ('Miller', 'TRMLLR', 'SG');
INSERT INTO USERS (emp_id, access_key, country) VALUES  ('Tessa', 'TRTSSA', 'SG');
INSERT INTO USERS (emp_id, access_key, country) VALUES  ('Dosson', 'TRDSSN', 'HK');
INSERT INTO USERS (emp_id, access_key, country) VALUES  ('Ricky', 'TRRCKY', 'SG');
INSERT INTO USERS (emp_id, access_key, country) VALUES  ('Aaron', 'TRARON', 'SG');
INSERT INTO USERS (emp_id, access_key, country) VALUES  ('Bob', 'TRBOB', 'HK');

INSERT INTO TEAMHIERARCHY (emp_id, manager_id) VALUES  ('Tessa', 'Miller');
INSERT INTO TEAMHIERARCHY (emp_id, manager_id) VALUES  ('Dosson', 'Miller');
INSERT INTO TEAMHIERARCHY (emp_id, manager_id) VALUES  ('Ricky', 'Tessa');
INSERT INTO TEAMHIERARCHY (emp_id, manager_id) VALUES  ('Aaron', 'Tessa');
INSERT INTO TEAMHIERARCHY (emp_id, manager_id) VALUES  ('Bob', 'Dosson');
