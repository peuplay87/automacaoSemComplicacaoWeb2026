package br.com.chronosacademy;

public class Media {

    public String calculaMedia(double v, double v1) {
        double Media = (v + v1) / 2;
        if (Media < 5) {
            return "Reprovado";
        }
        return "Aprovado";
    }
}

