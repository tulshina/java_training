package ru.stqa.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 02.04.2017.
 */
public class Users extends ForwardingSet<UserData> {
    private Set<UserData> delegate;

    public Users(Users contacts) {
        this.delegate = new HashSet<UserData>(contacts.delegate);
    }

    public Users() {
        this.delegate = new HashSet<UserData>();
    }

    public Users(Collection<UserData> contacts) {
        this.delegate = new HashSet<UserData>(contacts);
    }

    @Override
    protected Set<UserData> delegate() {
        return delegate;
    }

    public Users withAdded(UserData user) {
        Users contacts = new Users(this);
        contacts.add(user);
        return contacts;
    }

    public Users without (UserData user) {
        Users contacts = new Users(this);
        contacts.remove(user);
        return contacts;
    }
}
