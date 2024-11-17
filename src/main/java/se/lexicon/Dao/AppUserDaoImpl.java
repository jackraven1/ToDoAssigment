package se.lexicon.Dao;

import se.lexicon.AppUser;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDaoImpl implements AppUserDAO {
    private ArrayList<AppUser> users = new ArrayList<>();

    public AppUserDaoImpl() {
    }


    @Override
    public AppUser persist(AppUser appUser) {
        users.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        for(AppUser user : users){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return users;
    }

    @Override
    public void remove(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }
}
