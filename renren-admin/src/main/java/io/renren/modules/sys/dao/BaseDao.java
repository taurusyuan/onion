package io.renren.modules.sys.dao;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    void add(T t);

    void add(Map<String, Object> map);

    void addBatch(List<T> list);

    void save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryObject(Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryByTgNameList(Map<String, Object> map);

    List<T> queryPingList(Map<String, Object> map);

    List<T> queryTracertList(Map<String, Object> map);

    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int pingListTotal(Map<String, Object> map);

    int queryPingTotal(Map<String, Object> map);

    int queryIntervalTotal(Map<String, Object> map);

    int queryTotal();
}
