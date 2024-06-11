package model;

public class UserModel {
    private String hoVaTen;
    private String tenDangNhap;
    private String matKhau;

    public UserModel() {
    }

    public UserModel(String hoVaTen, String tenDangNhap, String matKhau) {
        this.hoVaTen = hoVaTen;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}