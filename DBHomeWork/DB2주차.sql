CREATE TABLE `A` (
   `a`   VARCHAR2(100(   NOT NULL
);

CREATE TABLE `B` (
   `b`   VARCHAR2(100)   NOT NULL,
   `a`   VARCHAR2(100(   NOT NULL
);

CREATE TABLE `C` (
   `c`   VARCHAR2(100)   NOT NULL,
   `b`   VARCHAR2(100)   NOT NULL,
   `a`   VARCHAR2(100(   NOT NULL
);

CREATE TABLE `AA` (
   `aa`   VARCHAR2(100)   NOT NULL
);

CREATE TABLE `BB` (
   `bb`   VARCHAR2(100)   NOT NULL,
   `aa`   VARCHAR2(100)   NOT NULL
);

CREATE TABLE `CC` (
   `CC`   VARCHAR2(100)   NOT NULL,
   `bb`   VARCHAR2(100)   NOT NULL
);

ALTER TABLE `A` ADD CONSTRAINT `PK_A` PRIMARY KEY (
   `a`
);

ALTER TABLE `B` ADD CONSTRAINT `PK_B` PRIMARY KEY (
   `b`,
   `a`
);

ALTER TABLE `C` ADD CONSTRAINT `PK_C` PRIMARY KEY (
   `c`,
   `b`,
   `a`
);

ALTER TABLE `AA` ADD CONSTRAINT `PK_AA` PRIMARY KEY (
   `aa`
);

ALTER TABLE `BB` ADD CONSTRAINT `PK_BB` PRIMARY KEY (
   `bb`
);

ALTER TABLE `CC` ADD CONSTRAINT `PK_CC` PRIMARY KEY (
   `CC`
);

ALTER TABLE `B` ADD CONSTRAINT `FK_A_TO_B_1` FOREIGN KEY (
   `a`
)
REFERENCES `A` (
   `a`
);

ALTER TABLE `C` ADD CONSTRAINT `FK_B_TO_C_1` FOREIGN KEY (
   `b`
)
REFERENCES `B` (
   `b`
);

ALTER TABLE `C` ADD CONSTRAINT `FK_B_TO_C_2` FOREIGN KEY (
   `a`
)
REFERENCES `B` (
   `a`
);