package lv.helloit.project.rest;

import lv.helloit.project.dao.AdminDAO;
import lv.helloit.project.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private AdminDAO adminDAO;

    @Autowired
    public AdminRestController(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @GetMapping
    public List<Admin> findAll(){
        return adminDAO.findAll();
    }

    @PostMapping
    public Admin save(@RequestBody Admin admin){
        adminDAO.save(admin);
        return admin;
    }
}
