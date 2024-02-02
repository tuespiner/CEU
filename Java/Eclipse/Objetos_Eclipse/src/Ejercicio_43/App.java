package Ejercicio_43;

public class App {

    public static void main(String[] args) {
        Actor blas = new Actor("Blas Blau", 1983, "España");
        Actor laura = new Actor("Laura Pozo", 1981, "Italia");
        Actor marcel = new Actor("Marcel Cade", 2001, "Suiza");
        Actor violeta = new Actor("Violeta Volo", 1999, "Rusia");

        Director sara = new Director("Sara Marea", 1994, "Portugal");

        Guionista marco = new Guionista("Marco Smith", 1988, "Reino Unido");
        Guionista cheng = new Guionista("Cheng Shun", 1977, "China");

        Pelicula pelicula1 = new Pelicula(2077, "Do you know Joe Blast", marco, sara);
        pelicula1.addActores(blas);
        pelicula1.addActores(laura);

        Pelicula pelicula2 = new Pelicula(2077, "Muerte en la sombra", cheng, sara);
        pelicula1.addActores(blas);
        pelicula1.addActores(laura);
        pelicula1.addActores(violeta);
        pelicula1.addActores(marcel);

        System.out.println(pelicula1.getListaActores());
        System.out.println(pelicula1.getGuionista().getSueldo());
        pelicula2.getListaActores().remove(pelicula2.getListaActores().indexOf(marcel));
        pelicula1.addActores(marcel);

        System.out.println(pelicula1.getListaActores() + "/n" + pelicula2.getListaActores());
    }

}
