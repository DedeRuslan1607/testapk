package repository;

import java.util.List;

import model.Ob;
import model.Karyawan;
import model.Manager;

public interface RepositoryKaryawanInterface {

    public Manager registerManager(Manager manager);

    public Ob registerOb(Ob manager);

    public List<Karyawan> findKaryawans();

    public Karyawan getKaryawan(Karyawan karyawan);

}
