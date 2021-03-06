package io.appwish.wishservice.repository.impl;

/**
 * Contains queries to execute on Postgres.
 *
 * I'm not sure what's the best practice for storing String SQLs, so for now it'll stay here.
 */
public enum Query {
  FIND_ALL_WISH("SELECT * FROM wishes"),
  FIND_ONE_WISH("SELECT * FROM wishes WHERE id=$1"),
  DELETE_WISH_QUERY("DELETE FROM wishes WHERE id=$1"),
  INSERT_WISH_QUERY(
    "INSERT INTO wishes ("
      + "title, "
      + "content, "
      + "cover_image_url, "
      + "author_id, "
      + "url) "
      + "VALUES ($1, $2, $3, $4, $5) "
      + "RETURNING *"),
  UPDATE_WISH_QUERY(
    "UPDATE wishes SET "
      + "title=$1, "
      + "content=$2, "
      + "cover_image_url=$3 "
      + "WHERE id=$4 RETURNING *"),
  CREATE_WISH_TABLE(
    "CREATE TABLE IF NOT EXISTS wishes("
      + "id serial PRIMARY KEY, "
      + "title VARCHAR (50) NOT NULL, "
      + "content VARCHAR (255) NOT NULL, "
      + "cover_image_url VARCHAR (255), "
      + "author_id serial, "
      + "url VARCHAR (255));");

  private final String sql;

  Query(final String sql) {
    this.sql = sql;
  }

  public String sql() {
    return sql;
  }
}
