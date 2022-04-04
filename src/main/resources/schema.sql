CREATE TABLE patient (
    id          INTEGER      NOT NULL AUTO_INCREMENT,
    version     INTEGER      NOT NULL,
    del_flag    VARCHAR(1),
    name        VARCHAR(128) NOT NULL,
    age         INTEGER ,
    last_visit_date Date,
    PRIMARY KEY (id)
);