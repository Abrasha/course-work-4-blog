DELETE FROM POSTS_TAGS;
DELETE FROM COMMENTS;
DELETE FROM POSTS;
DELETE FROM USERS_FAVOURITE_TAGS;
DELETE FROM TAGS;
DELETE FROM COLORS;
DELETE FROM USERS;

INSERT INTO COLORS (ID, HEX, COLOR_NAME) VALUES
  (1, '#FF0000', 'Red'),
  (2, '#00FF00', 'Green');
