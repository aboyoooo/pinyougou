package com.hlkj.sellgoodsservice.mapper;

import com.hlkj.pojo.model.TbGoodsDec;
import com.hlkj.pojo.model.TbGoodsDecExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TbGoodsDecMapper {
    int countByExample(TbGoodsDecExample example);

    int deleteByExample(TbGoodsDecExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(TbGoodsDec record);

    int insertSelective(TbGoodsDec record);

    List<TbGoodsDec> selectByExample(TbGoodsDecExample example);

    TbGoodsDec selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") TbGoodsDec record, @Param("example") TbGoodsDecExample example);

    int updateByExample(@Param("record") TbGoodsDec record, @Param("example") TbGoodsDecExample example);

    int updateByPrimaryKeySelective(TbGoodsDec record);

    int updateByPrimaryKey(TbGoodsDec record);
}