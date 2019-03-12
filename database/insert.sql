INSERT INTO `district` (`id`, `name`, `code` , `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`) VALUES (NULL, 'Quận 1', 'quan_1', NULL, NULL, NULL , null);
INSERT INTO `district` (`id`, `name`, `code` , `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`) VALUES (NULL, 'Quận 2', 'quan_2', NULL, NULL, NULL , null);
INSERT INTO `district` (`id`, `name`, `code` , `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`) VALUES (NULL, 'Quận 3', 'quan_3', NULL, NULL, NULL , null);
INSERT INTO `district` (`id`, `name`, `code` , `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`) VALUES (NULL, 'Quận Tân Bình', 'quan_tan_binh', NULL, NULL, NULL , null);


INSERT INTO `role` (`id`, `name`, `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`) VALUES (1, 'Admin', '2019-03-06 00:00:00', NULL, 'Admin', NULL);
INSERT INTO `role` (`id`, `name`, `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`) VALUES (2, 'Employee', '2019-03-06 00:00:00', NULL, 'Admin', NULL);

INSERT INTO `user` (`id`, `username`, `password`, `fullName`, `roleId`, `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`, `status`) VALUES (NULL, 'admin', 'admin', 'Phan Van Admin', '1', '2019-03-06 00:00:00', NULL, 'Admin', NULL, '1');
INSERT INTO `user` (`id`, `username`, `password`, `fullName`, `roleId`, `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`, `status`) VALUES (NULL, 'user1', 'user1', 'Tran Van Khanh', '2', '2019-03-06 00:00:00', NULL, 'Admin', NULL, '1');
INSERT INTO `user` (`id`, `username`, `password`, `fullName`, `roleId`, `createdDate`, `modifiedDate`, `createdBy`, `modifiedBy`, `status`) VALUES (NULL, 'user2', 'user2', 'Nguyễn Khánh Linh', '2', '2019-03-06 00:00:00', NULL, 'Admin', NULL, '1');