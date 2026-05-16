package form;

public class GameStats {

    private int segons;
    private int puntuacio;
    private final String nomUsuari;
    private final int idUsuari;

    public GameStats(String nomUsuari, int idUsuari) {
        this.nomUsuari = nomUsuari;
        this.idUsuari = idUsuari;
        this.segons = 0;
        this.puntuacio = 0;
    }

    public String getNomUsuari() { return nomUsuari; }
    public int getSegons() { return segons; }
    public int getPuntuacio() { return puntuacio; }
    public int getIdUsuari() { return idUsuari; }

    public void incrementarSegons() { segons++; }
    public void incrementarPuntuacio() { puntuacio++; }

    public void reset() {
        segons = 0;
        puntuacio = 0;
    }
}