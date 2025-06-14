package unicam.filierafanesicardinali.model.social;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Social {


    /**
     * Lista dei contenuti social (advertisement) gestiti dalla piattaforma.
     */
    private List<ContenutoSocial> listaContenutiSocial;

    /**
     * Istanza singleton della classe Social.
     */
    private static Social instanceSocial;

    /**
     * Costruttore privato per implementare il design pattern Singleton.
     * Inizializza la lista dei contenuti social.
     */
    private Social() {
        listaContenutiSocial = new ArrayList<ContenutoSocial>();
    }

    /**
     * Restituisce l'istanza singleton della classe Social.
     * Il metodo è sincronizzato per garantire la sicurezza nel contesto di accesso concorrente.
     *
     * @return l'istanza di {@code Social}
     */
    public static synchronized Social getSocial() {
        if (instanceSocial == null) {
            instanceSocial = new Social();
        }
        return instanceSocial;
    }

    /**
     * Restituisce la lista dei contenuti social (advertisement) attualmente gestiti.
     *
     * @return la lista di {@code ContenutoSocial}
     */
    public List<ContenutoSocial> getlistaContenutiSocial() {
        return listaContenutiSocial;
    }

    /**
     * Imposta la lista dei contenuti social.
     *
     * @param listaContenutiSocial la lista di {@code ContenutoSocial} da impostare
     */
    public void setListaContenutiSocial(List<ContenutoSocial> listaContenutiSocial) {
        this.listaContenutiSocial = listaContenutiSocial;
    }

    /**
     * Aggiunge un nuovo contenuto social alla lista.
     *
     * @param social il {@code ContenutoSocial} da aggiungere
     */
    public void addContenutoSocial(ContenutoSocial social) {
        this.listaContenutiSocial.add(social);
    }

}