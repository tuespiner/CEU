package Ejercicio_41;

public class Resultado {
    private Integer golesLocales;
    private Integer golesVisitante;

    public Integer getGolesLocales() {
        return golesLocales;
    }

    public void setGolesLocales(Integer golesLocales) {
        this.golesLocales = golesLocales;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Resultado() {
        this.golesLocales = 0;
        this.golesVisitante = 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((golesLocales == null) ? 0 : golesLocales.hashCode());
        result = prime * result + ((golesVisitante == null) ? 0 : golesVisitante.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resultado other = (Resultado) obj;
        if (golesLocales == null) {
            if (other.golesLocales != null)
                return false;
        } else if (!golesLocales.equals(other.golesLocales))
            return false;
        if (golesVisitante == null) {
            if (other.golesVisitante != null)
                return false;
        } else if (!golesVisitante.equals(other.golesVisitante))
            return false;
        return true;
    }

    public String toString() {
        return this.golesLocales + "-" + this.golesVisitante;
    }

    public Boolean isVictoriaLocal() {
        if (this.golesLocales > this.golesVisitante) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isVictoriaVisitante() {
        if (this.golesLocales < this.golesVisitante) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isEmpate() {
        if (this.golesLocales == this.golesVisitante) {
            return true;
        } else {
            return false;
        }
    }
}
