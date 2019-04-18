package com.spring.estate.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by https://github.com/kwanpham
 */
@Getter
@Setter
public abstract class BaseDTO<T> {

    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private long[] ids;
    private List<T> listResult = new ArrayList<>();
    private int page;
    private int maxPageItem;
    private int totalPage;
    private int totalItem;
    private String sortName;
    private String sortBy;
    private String alert;
    private String message;
    private String ref;
}
