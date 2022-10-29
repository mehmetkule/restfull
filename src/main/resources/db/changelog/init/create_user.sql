CREATE TABLE IF NOT EXISTS mk.user_account
(
    id          UUID                                   NOT NULL PRIMARY KEY,
    first_name  TEXT                                   NOT NULL,
    last_name   TEXT                                   NOT NULL,
    email       VARCHAR(128)                           NOT NULL,
    password    VARCHAR(60),
    secret      VARCHAR(128),
    token       TEXT,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
    updated_at  TIMESTAMP WITH TIME ZONE
                              );

CREATE UNIQUE INDEX IF NOT EXISTS user_account_email_uindex
    ON mk.user_account (email);
CREATE UNIQUE INDEX IF NOT EXISTS user_account_id_uindex
    ON mk.user_account (id);
