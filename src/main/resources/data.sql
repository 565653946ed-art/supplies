-- ユーザー初期データ
INSERT INTO users (username, password,role)
VALUES
  ('admin', '$2a$10$sxAxlH90e.mPRHkeO9GBNumyIDwv8yaXqeHzDgyY.eIGwklDCDncO',
  	'ROLE_ADMIN'),
  ('user', '$2a$10$4lYxEvBfj2XMzCkU/n5sV.6H0jdQ86x/PGFT8ea1Dv70wFAF.Ryz2',
  'ROLE_USER');

-- 備品初期データ
INSERT INTO items (name, stock,pending_usage)
VALUES
  ('ドリル', 5,0),
  ('チップ', 10,0),
  ('エンドミル', 7,0),
  ('超硬ドリル', 3,0);
