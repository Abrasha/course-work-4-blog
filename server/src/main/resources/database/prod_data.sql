INSERT INTO COLORS (ID, HEX, COLOR_NAME) VALUES
  (1, '#FF0000', 'Red'),
  (2, '#00FF00', 'Green');

INSERT INTO TAGS (ID, NAME, COLOR_ID) VALUES
  (1, 'test-tag-1', 1),
  (2, 'test-tag-2', 2);

INSERT INTO USERS (ID, EMAIL, PASSWORD, USERNAME) VALUES
  (1, 'email1@example.com', 'password1', 'user1'),
  (2, 'email2@example.com', 'password2', 'user2');

INSERT INTO USERS_FAVOURITE_TAGS (USER_ID, FAVOURITE_TAGS_ID) VALUES
  (1, 1),
  (2, 1),
  (2, 2);

INSERT INTO POSTS (ID, BODY, CREATION_DATE, TITLE, AUTHOR_ID) VALUES
  (1, 'body1', NULL, 'title1', 1),
  (2, 'body2', NULL, 'title2', 1),
  (3, 'body3', NULL, 'title3', 2);

INSERT INTO POSTS_TAGS (POST_ID, TAGS_ID) VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (3, 1);

INSERT INTO COMMENTS (ID, BODY, CREATION_DATE, AUTHOR_ID, POST_ID) VALUES
  (1, 'comment1', NULL, 1, 1),
  (2, 'comment2', NULL, 2, 1),
  (3, 'comment3', NULL, 1, 1);