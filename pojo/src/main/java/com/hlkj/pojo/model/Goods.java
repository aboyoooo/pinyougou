package com.hlkj.pojo.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Goods implements Serializable {

    private TbGoods goods;

    private TbGoodsDec goodsDec;

    private List<Item> itemList;
}
