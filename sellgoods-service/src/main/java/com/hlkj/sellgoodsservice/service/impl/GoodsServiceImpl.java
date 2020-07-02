package com.hlkj.sellgoodsservice.service.impl;

import com.hlkj.common.utils.Result;
import com.hlkj.pojo.model.Brand;
import com.hlkj.pojo.model.Goods;
import com.hlkj.pojo.model.TbGoods;
import com.hlkj.sellgoodsservice.mapper.ItemMapper;
import com.hlkj.sellgoodsservice.mapper.TbGoodsDecMapper;
import com.hlkj.sellgoodsservice.mapper.TbGoodsMapper;
import com.hlkj.sellgoodsservice.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    TbGoodsMapper goodsMapper;
    @Resource
    TbGoodsDecMapper goodsDecMapper;
    @Resource
    ItemMapper itemMapper;

    @Override
    public List<Brand> findAllBrands() {
        return null;
    }

    @Override
    public Brand findBrandById(Long id) {
        return null;
    }

    @Override
    public int add(Goods goods) {
        if(goods.getGoods()==null){
            return -1;
        }else {
            goodsMapper.insert(goods.getGoods());
            if(goods.getGoodsDec()!=null){
                goodsDecMapper.insert(goods.getGoodsDec());
            };
            if(goods.getItemList()!=null&&goods.getItemList().size()>0){
                for(int i=0;i<goods.getItemList().size();i++){
                    itemMapper.insert(goods.getItemList().get(i));
                }
            }
            return 1;
        }
    }
}
