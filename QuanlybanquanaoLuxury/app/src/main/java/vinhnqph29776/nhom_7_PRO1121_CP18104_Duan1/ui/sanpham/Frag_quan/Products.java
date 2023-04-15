package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.ui.sanpham.Frag_quan;

public class Products {
    String name;
    double price;
    String image;
int soluong;

    public Products(String name, double price, String image,int soluong) {
        this.name = name;
        this.price = price;
        this.image = image;
       this.soluong=soluong;
    }

    public Products() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
