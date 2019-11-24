package mdt.desa.model.nomina;

public class Price {
    private  Integer code;
    private  String name;
    private  Double priceBuy;

    public Price(Integer code, String name, Double priceBuy){
        this.code = code;
        this.name = name;
        this.priceBuy = priceBuy;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }
}
