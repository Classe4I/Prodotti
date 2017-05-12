/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneelencofxml.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Proprietario
 */
public class Reparto {


/*
Classe model che rispecchia un record presente sul database
Utilizza proprietà di tipi JavaFX utili per sincronizzare 
ciò che visualizzano gli elementi della GUI con i dati presenti in memoria
*/

    
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty nome = new SimpleStringProperty(); 
    
    // costruttore vuoto
    public Reparto() {  }
    
    // costruttore da un insieme di dati
    public Reparto(
            int id,
            String nome
    ) {
        this.id.set(id);
        this.nome.set(nome);
    }
    
    // costruttore da un ResultSet estratto dal database
    public Reparto(ResultSet resultSet) {
        try {
            //if(resultSet.isBeforeFirst()) {
                //resultSet.next();
                
                this.id.set(resultSet.getInt("ID_Reparto"));
                this.nome.set(resultSet.getString("NomeReparto"));
            //}
        }
        catch(SQLException ex) {
            System.out.println("Errore SQL: " + ex.getMessage());
            System.exit(0);
        }
    }
    
    // metodi get
    public int getId() {
        return this.id.get();
    }
    public String getNome() {
        return this.nome.get();
    }
    
    // metodi set
    public void setId(int id) {
        this.id.set(id);
    }
    public void setNome(String nome) {
        this.nome.set(nome);
    }
    
    // metodo toString
    @Override
    public String toString() {
        return this.nome.get();
    }
}


