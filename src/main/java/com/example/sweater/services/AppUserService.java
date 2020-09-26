package com.example.sweater.services;


import com.example.sweater.domains.AppUser;
import com.example.sweater.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;
//    @Autowired
//    private RoleEntityRepository roleEntityRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public AppUser saveAppUser(AppUser appUser) {
//        RoleEntity userRole = roleEntityRepository.findByName("ROLE_USER");
//        userEntity.setRoleEntity(userRole);
        appUser.setPassword(appUser.getPassword());
        return appUserRepo.saveAndFlush(appUser);
    }

    public AppUser findByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

    public AppUser findByLoginAndPassword(String login, String password) {
        AppUser appUser = findByUsername(login);
        if (appUser != null) {
            if (password.equals(appUser.getPassword())) {
                return appUser;
            }
        }
        return null;
    }
}