package com.car.common.utils;

import java.util.Map;

public class PageCondition {
    private Map<String, Object> conditions;

    private Page page;

    public Map<String, Object> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, Object> conditions) {
        this.conditions = conditions;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 通过名称获取
     *
     * @param name
     * @return
     */
    public Object getByKey(String name) {
        if (this.conditions.containsKey(name)) {
            return this.conditions.get(name);
        }
        return null;
    }

    /**
     * 判断是否存在
     *
     * @param name
     * @return
     */
    public boolean isExistByKey(String name) {
        return this.conditions.containsKey(name);
    }


    /**
     * 判断是否有值
     *
     * @param name
     * @return
     */
    public boolean isEmpty(String name) {
        if (this.conditions.containsKey(name)) {
            if (this.conditions.get(name) instanceof String) {
                String value = (String) this.conditions.get(name);
                return StringUtil.hasValue(value);
            } else {
                return true;
            }
        }
        return false;
    }


    public Map<String,Object> transferToTargetMap(){
        this.getConditions().put("page",String.valueOf(this.getPage().getPage()));
        this.getConditions().put("limit",String.valueOf(this.getPage().getNum()));
        return this.getConditions();
    }

    @Override
    public String toString() {
        return JsonUtils.writeValueAsString(this);
    }
}
