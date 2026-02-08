
-- 既存テーブルがあれば削除
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS users;

-- ユーザー（ログイン用）
CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  role VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;--日本語と絵文字が安全に使える文字コード

-- 備品テーブル
CREATE TABLE items (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  stock INT NOT NULL,
  pending_usage INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
