alter table users
    add constraint users_email_unique
        unique (email);