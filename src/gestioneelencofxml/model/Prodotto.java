package gestioneelencofxml.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/*
Classe model che rispecchia un record presente sul database
Utilizza proprietà di tipi JavaFX utili per sincronizzare 
ciò che visualizzano gli elementi della GUI con i dati presenti in memoria
*/
public class Prodotto {
    
    private SimpleIntegerProperty idProdotto = new SimpleIntegerProperty();
    private SimpleStringProperty nomeProdotto = new SimpleStringProperty(); 
    private SimpleIntegerProperty prezzoUnitario = new SimpleIntegerProperty(); 
    private SimpleObjectProperty<Date> dataScadenza = new SimpleObjectProperty(); 
    private SimpleStringProperty descrizione = new SimpleStringProperty();
    private SimpleIntegerProperty idReparto = new SimpleIntegerProperty();
    
    // costruttore vuoto
    public Prodotto() {  }
    
    // costruttore da un insieme di dati
    public Prodotto(
            int idProdotto,
            int idReparto,
            String nomeProdotto,
            int prezzoUnitario,
            Date dataScadenza,
            String descrizione
    ) {
        this.idProdotto.set(idProdotto);
        this.nomeProdotto.set(nomeProdotto);
        this.prezzoUnitario.set(prezzoUnitario);
        this.dataScadenza.set(dataScadenza);
        this.descrizione.set(descrizione);
        this.idReparto.set(idReparto);
    }
    
    // costruttore da un ResultSet estratto dal database
    public Prodotto(ResultSet resultSet) {
        try {
            //if(resultSet.isBeforeFirst()) {
                //resultSet.next();
                
                this.idProdotto.set(resultSet.getInt("ID_Prodotto"));
                this.nomeProdotto.set(resultSet.getString("NomeProdotto"));
                this.prezzoUnitario.set(resultSet.getInt("PrezzoUnitario"));
                this.dataScadenza.set(resultSet.getDate("DataScadenza"));
                this.descrizione.set(resultSet.getString("Descrizione"));
                this.idReparto.set(resultSet.getInt("ID_Reparto"));
            //}
        }
        catch(SQLException ex) {
            System.out.println("Errore SQL: " + ex.getMessage());
            System.exit(0);
        }
    }
    
    // metodi get
    public int getIdProdotto() {
        return this.idProdotto.get();
    }
    public String getNomeProdotto() {
        return this.nomeProdotto.get();
    }
    public float getPrezzoUnitario() {
        return this.prezzoUnitario.get();
    }
    public Date getDataScadenza() {
        return this.dataScadenza.get();
    }
    public String getDescrizione() {
        return this.descrizione.get();
    }

    public int getIdReparto() {
        return this.idReparto.get();
    }
    
    // metodi set
    public void setIdProdotto(int idProdotto) {
        this.idProdotto.set(idProdotto);
    }
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto.set(nomeProdotto);
    }
    public void setPrezzoUnitario(int prezzoUnitario) {
        this.prezzoUnitario.set(prezzoUnitario);
    }
    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza.set(dataScadenza);
    }
    public void setDescrizione(String descrizione) {
        this.descrizione.set(descrizione);
    }
    
    public void setIdReparto(int idReparto) {
        this.idReparto.set(idReparto);
    }
     
}
