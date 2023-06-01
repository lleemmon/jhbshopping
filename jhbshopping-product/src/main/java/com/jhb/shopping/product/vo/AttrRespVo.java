package com.jhb.shopping.product.vo;

import lombok.Data;

import java.util.List;

@Data
public class AttrRespVo extends AttrVo{
    private String catelogName;
    private String groupName;
    private List<Long> catelogPath;
}
