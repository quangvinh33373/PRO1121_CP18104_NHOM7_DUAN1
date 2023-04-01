package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.Crud;

public class ADD_Product {
    String tenSp,mota,maLoai;
    Integer soluong;
    Double size;

    public ADD_Product(String tenSp, String mota, Integer soluong, Double size) {
        this.tenSp = tenSp;
        this.mota = mota;
        this.soluong = soluong;
        this.size = size;
    }

    public ADD_Product() {
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
}
