package repository;

import java.util.ArrayList;
import java.util.List;

import model.*;
import model.Karyawan;
import model.Manager;

public class RepositoryKaryawan implements RepositoryKaryawanInterface {

    private List<Karyawan> karyawans = new ArrayList<>();

    @Override
    public List<Karyawan> findKaryawans() {
        return karyawans;
    }

    @Override
    public Karyawan getKaryawan(Karyawan karyawan) {
        int indexOf = karyawans.indexOf(karyawan);
        return karyawans.get(indexOf);
    }

    @Override
    public Manager registerManager(Manager manager) {
        karyawans.add(manager);
        return manager;
    }

    @Override
    public Ob registerOb(Ob ob) {
        karyawans.add(ob);
        return ob;
    }

}
