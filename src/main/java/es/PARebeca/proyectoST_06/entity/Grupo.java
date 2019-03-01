/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.PARebeca.proyectoST_06.entity;


/**
 *
 * > rebeca pena alvarez 
 * > 02/02/2019
 * > modo de agrupar los alimentos
 * 
 */
public enum Grupo {
    
    G1("Lacteos"),
    G2("Carnes, pescados y huevos"),
    G3("Tubérculos, legumbres, frutos secos"),
    G4("Verduras y Hortalizas"),
    G5("Frutas"),
    G6("Cereales y derivados, azúcar y dulces"),
    G7("Grasas, aceite y mantequilla"),
	G8("Agua y bebidas no alcohólicas"),
	G9("Condimentos");
	
    
    private String value;
    
    private Grupo (String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
/*
    public void setValue(String value) {
        this.value = value;
    }
  */  
}
