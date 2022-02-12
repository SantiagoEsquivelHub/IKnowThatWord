package myProject;

public class PalabraNivel {
    private String palabra;
    private Boolean memorizada;

    public PalabraNivel() {
        this.palabra = "";
        this.memorizada = false;
    }

    public String getPalabra() {
        return palabra;
    }

    public Boolean getMemorizada() {
        return memorizada;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setMemorizada(Boolean memorizada) {
        this.memorizada = memorizada;
    }
}


