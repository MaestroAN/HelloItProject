package lv.helloit.project.dao;

import lv.helloit.project.entity.Admin;

import java.util.List;

public interface AdminDAO {
    public List<Admin> findAll();

    public void save (Admin admin);
}
