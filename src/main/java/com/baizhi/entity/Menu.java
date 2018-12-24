package com.baizhi.entity;

import java.util.List;
import java.util.Objects;

/**
 * 菜单类
 */
public class Menu {
    private String id;
    private String title;
    private String iconcls;
    private String href;
    private String parentId;
    private Integer lev;
    private List<Menu> children;


    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", href='" + href + '\'' +
                ", parentId='" + parentId + '\'' +
                ", lev=" + lev +
                '}';
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(title, menu.title) &&
                Objects.equals(iconcls, menu.iconcls) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(parentId, menu.parentId) &&
                Objects.equals(lev, menu.lev) &&
                Objects.equals(children, menu.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, iconcls, href, parentId, lev, children);
    }

    public Menu() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public Menu(String id, String title, String iconcls, String href, String parentId, Integer lev, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.iconcls = iconcls;
        this.href = href;
        this.parentId = parentId;
        this.lev = lev;
        this.children = children;
    }
}
