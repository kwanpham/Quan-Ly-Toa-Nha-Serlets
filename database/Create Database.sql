CREATE TABLE role (
  roleId       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL,
  status       INT          NOT NULL

);


CREATE TABLE user (
  userId       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
  FOREIGN KEY (roleid) REFERENCES role (roleId)

);

CREATE TABLE district (
  districtId   INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL,
  status       INT          NOT NULL
);

CREATE TABLE buildingtype (
  buildingTypeId BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name           VARCHAR(255) NOT NULL,
  createdDate    TIMESTAMP    NULL,
  modifiedDate   TIMESTAMP    NULL,
  createdBy      VARCHAR(255) NULL,
  modifiedBy     VARCHAR(255) NULL,
  status         INT          NOT NULL
);


CREATE TABLE building (
  buildingId       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name             VARCHAR(255),
  districtId       INT,
  ward             VARCHAR(255),
  street           VARCHAR(255),
  structure        VARCHAR(255),
  numberOfBasement INT,
  buildingArea     DOUBLE,
  direction        VARCHAR(255),
  levelBuilding    VARCHAR(255),
  rentArea         VARCHAR(255),
  areaDescription  VARCHAR(255),
  costRent         DECIMAL(15, 2),
  costDescription  VARCHAR(255),
  serviceCost      DECIMAL(15, 2),
  carCost          DECIMAL(15, 2),
  motorbikeCost    DECIMAL(15, 2),
  overtimeCost     DECIMAL(15, 2),
  electricityCost  DECIMAL(15, 2),
  deposit          DECIMAL(15, 2),
  payment          DECIMAL(15, 2),
  timeContract     TIMESTAMP,
  timeDecorator    TIMESTAMP,
  managerName      VARCHAR(255),
  mamagerPhone     VARCHAR(30),
  commission       DECIMAL(15, 2),
  note             VARCHAR(255),
  link             VARCHAR(255),
  location         VARCHAR(255),
  imageName        VARCHAR(255),
  thumbnailBase64  VARCHAR(255),
  createdDate      TIMESTAMP    NULL,
  modifiedDate     TIMESTAMP    NULL,
  createdBy        VARCHAR(255) NULL,
  modifiedBy       VARCHAR(255) NULL,
  status           INT          NOT NULL,


  FOREIGN KEY (districtId) REFERENCES district (districtId)


);

CREATE TABLE detailbuildingtype (
  buildingId     BIGINT       NOT NULL,
  buildingTypeId BIGINT       NOT NULL,
  createdDate    TIMESTAMP    NULL,
  modifiedDate   TIMESTAMP    NULL,
  createdBy      VARCHAR(255) NULL,
  modifiedBy     VARCHAR(255) NULL,

  PRIMARY KEY (buildingId, buildingTypeId),
  FOREIGN KEY (buildingId) REFERENCES building (buildingId),
  FOREIGN KEY (buildingTypeId) REFERENCES buildingtype (buildingTypeId)

);

CREATE TABLE detailuserbuilding (
  userId       BIGINT       NOT NULL,
  buildingId   BIGINT       NOT NULL,
  createdDate  TIMESTAMP    NULL,
  modifiedDate TIMESTAMP    NULL,
  createdBy    VARCHAR(255) NULL,
  modifiedBy   VARCHAR(255) NULL,
  PRIMARY KEY (userId, buildingId),
  FOREIGN KEY (buildingId) REFERENCES building (buildingId),
  FOREIGN KEY (userId) REFERENCES user (userId)


);



