CREATE TABLE stations (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    removed BOOLEAN     NOT NULL DEFAULT FALSE,
    created timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE services (
    id BIGSERIAL PRIMARY KEY,
    station_id BIGINT NOT NULL REFERENCES stations,
    name TEXT NOT NULL,
    created timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE station_services (

)