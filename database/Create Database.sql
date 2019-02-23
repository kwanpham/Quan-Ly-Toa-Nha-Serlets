CREATE TABLE role (
  id       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL,
  status       INT          NOT NULL
);


CREATE TABLE user (
  id       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username     VARCHAR(150) NOT NULL,
  password     VARCHAR(150) NOT NULL,
  fullName     VARCHAR(150) NULL,
  roleId       BIGINT       NOT NULL,
  managerId    BIGINT       NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL,
  status       INT          NOT NULL,
  FOREIGN KEY (managerid) REFERENCES user (userId),
  FOREIGN KEY (roleid) REFERENCES role (id)
);

CREATE TABLE district (
  id           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  code         VARCHAR(255) NOT NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL
);


CREATE TABLE building (
  id               BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name             VARCHAR(255),
  district         VARCHAR(255),
  ward             VARCHAR(255),
  street           VARCHAR(255),
  structure        VARCHAR(255),
  numberOfBasement INT,
  buildingArea     DOUBLE,
  direction        VARCHAR(255),
  levelBuilding    VARCHAR(255),
  rentArea         TEXT,
  areaDescription  VARCHAR(255),
  costRent         INTEGER,
  costDescription  VARCHAR(255),
  serviceCost      VARCHAR(255),
  carCost          VARCHAR(255),
  motorbikeCost    VARCHAR(255),
  overtimeCost     VARCHAR(255),
  electricityCost  VARCHAR(255),
  deposit          VARCHAR(255),
  payment          VARCHAR(255),
  timeContract     VARCHAR(255),
  timeDecorator    VARCHAR(255),
  managerName      VARCHAR(255),
  mamagerPhone     VARCHAR(30),
  commission       VARCHAR(255),
  note             VARCHAR(255),
  link             VARCHAR(255),
  location         VARCHAR(255),
  image            VARCHAR(255),
  type             TEXT NULL,
  createdDate      TIMESTAMP    NULL,
  modifiedDate     TIMESTAMP    NULL,
  createdBy        VARCHAR(255) NULL,
  modifiedBy       VARCHAR(255) NULL,
);

CREATE TABLE assignment (
  userId       BIGINT       NOT NULL,
  buildingId   BIGINT       NOT NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL,
  PRIMARY KEY (userId, buildingId),
  FOREIGN KEY (buildingId) REFERENCES building (id),
  FOREIGN KEY (userId) REFERENCES user (id)
);



