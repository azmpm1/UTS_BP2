package UTS_BP2;
public class cPembeli {
    private String nama, kode;
    private String alamat;
    cPembeli(){
        System.out.println("Default constructor pembeli..");
    }
    cPembeli(String n){
        nama=n;
    }
    cPembeli(String kd, String n, String a){
        kode=kd; nama=n; alamat=a;
        System.out.println("Object "+nama+" dibuat..");
    }
    public void setNama(String n){ nama=n; }
    public void setAlamat(String a){ alamat=a; }
    public String getKode(){ return kode; }
    public String getNama(){ return nama; }
    public String getAlamat(){ return alamat; }
    public String ToString(){
        return kode+" Nama: "+nama+" Alamat: "+alamat;
    }
}
