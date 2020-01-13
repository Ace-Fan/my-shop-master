package com.wufan.my.shop.web.admin.abstracts;

import com.wufan.my.shop.commons.persistence.BaseEntity;
import com.wufan.my.shop.commons.persistence.BaseTreeDao;
import com.wufan.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/11 10:56
 */
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;
    /**
     * 查询全部数据
     * @return
     */
    @Override
   public List<T> selectAll(){
        return dao.selectAll();
   }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(new String[]{String.valueOf(id)});
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Override
    public T getById(Long id){
        return dao.getById(id);
    }

    /**
     * 更新
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void  update(T entity){
        dao.update(entity);
    }

    /**
     * 根据父级节点ID查询所有节点
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid){
        return dao.selectByPid(pid);
    }

}
