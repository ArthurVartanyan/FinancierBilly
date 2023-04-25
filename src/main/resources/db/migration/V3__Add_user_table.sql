CREATE TABLE public.pg_user
(
    id BIGSERIAL PRIMARY KEY NOT NULL
);

ALTER TABLE income
    ADD COLUMN user_id BIGINT REFERENCES public.pg_user (id) NOT NULL;