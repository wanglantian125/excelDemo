package com.excel.demo.getExcel.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public abstract class TreeNode {
    @TableField(exist = false)
    private String id;
    @TableField(exist = false)
    @JSONField(serialzeFeatures = SerializerFeature.WriteNullListAsEmpty)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<? extends TreeNode> children = null;
//    @TableField(exist = false)
//    private boolean hasChildren = false;
    public List<? extends TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<? extends TreeNode> children) {
        this.children = children;
    }

//    public boolean isHasChildren() {
//        return hasChildren;
//    }

//    public void setHasChildren(boolean hasChildren) {
//        this.hasChildren = hasChildren;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getIcon();

    public abstract String getParentId();

    public abstract String getPKAttrName();

    public abstract String getLeaf();

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", children=" + children +
                '}';
    }
}
