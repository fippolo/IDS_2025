package unicam.filierafanesicardinali.model.localizzazione;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mappa {

    /**
     * Lista degli indirizzi presenti nella mappa.
     */
    private List<Indirizzo> listaIndirizzi;

    /**
     * Istanza unica della mappa per l'implementazione del pattern Singleton.
     */
    private static Mappa instanceMap;

    /**
     * Costruttore privato per implementare il pattern Singleton.
     * Inizializza la lista degli indirizzi.
     */
    public Mappa() {
        listaIndirizzi = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza unica della mappa.
     *
     * @return L'istanza della mappa.
     */
    public static synchronized Mappa getMap() {
        if (instanceMap == null) {
            instanceMap = new Mappa();
        }
        return instanceMap;
    }

    /**
     * Aggiunge un indirizzo alla lista se non nullo.
     *
     * @param indirizzo L'indirizzo da aggiungere.
     */
    public void aggiungiIndirizzo(Indirizzo indirizzo) {
        if (indirizzo != null) {
            this.listaIndirizzi.add(indirizzo);
        }
    }

    /**
     * Rimuove un indirizzo dalla lista se presente.
     *
     * @param indirizzo L'indirizzo da rimuovere.
     */
    public void rimuoviIndirizzo(Indirizzo indirizzo) {
        this.listaIndirizzi.remove(indirizzo);
    }

    /**
     * Restituisce la lista degli indirizzi presenti nella mappa.
     *
     * @return Lista di indirizzi.
     */
    public List<Indirizzo> getListaIndirizzi() {
        return this.listaIndirizzi;
    }

    /**
     * Imposta una nuova lista di indirizzi.
     *
     * @param listaIndirizzi Nuova lista di indirizzi.
     */
    public void setListaIndirizzi(List<Indirizzo> listaIndirizzi) {
        this.listaIndirizzi = listaIndirizzi;
    }
}
