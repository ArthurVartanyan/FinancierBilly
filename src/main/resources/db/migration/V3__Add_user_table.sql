CREATE TABLE public.pg_user
(
    id BIGINT PRIMARY KEY NOT NULL
);

ALTER TABLE income
    ADD COLUMN user_id BIGINT REFERENCES public.pg_user (id) NOT NULL;