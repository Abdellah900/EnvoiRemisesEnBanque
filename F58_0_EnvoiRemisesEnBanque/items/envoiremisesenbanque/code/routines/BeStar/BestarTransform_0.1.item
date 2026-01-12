package routines;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class BestarTransform {

	
	
	/**
     * toEBCDICPositif: transform a number to positif EBCDIC format
     * 
     * 
     * {talendTypes} Integer
     * 
     * {Category} User Defined
     * 
     * {param} integer(299) input: The montant to be transformed.
     * 
     * {example} toEBCDIC(299) # 29I
     */
    public static String toEBCDICPositif(Integer  montant) {
    	
    	return (montant>=0)?BestarTransform.toEBCDIC(montant):BestarTransform.toEBCDIC(montant*(-1));
    
    }
    
    
    
    /**
     * toEBCDIC: transform a number to EBCDIC format
     * 
     * 
     * {talendTypes} Integer
     * 
     * {Category} User Defined
     * 
     * {param} integer(299) input: The montant to be transformed.
     * 
     * {example} toEBCDIC(299) # 29I
     * {example} toEBCDIC(-299) # 29R
     */
    public static String toEBCDIC(Integer  montant) {
    	
    	String signe;
    	if (montant >= 0){
    		signe = "pos";
    	}else{
    		signe="neg";
    		montant=montant*(-1);
    	}
    	
    	String sMontant = Integer.toString(montant);
    	
    	String sMontantDebut = sMontant.substring(0, sMontant.length()-1);
    	char sMontantFin = (sMontant.substring(sMontant.length()-1, sMontant.length())).charAt(0);
        
    	//System.out.println("signe:"+signe+" montant:"+montant+" debut:"+sMontantDebut+" fin:"+sMontantFin );
    	
    	return sMontantDebut+BestarTransform.convertNumberToEBCDIC(sMontantFin, signe);
    
    }
    
    
    /**
     * convertNumberToEBCDIC: get the EBCDIC character
     * 
     * 
     * {talendTypes} char, String
     * 
     * {Category} User Defined
     * 
     * {param} integer(299) input: The char to be transformed.
     * 
     * {example} toEBCDIC(9) # I
     * {example} toEBCDIC(-9) # 29R
     */
    public static char convertNumberToEBCDIC(char  chiffre, String sense) {
    	
    	 char[] tcChiffresSignesPositifs = {0x7b, 0x41, 0x42, 0x43,0x44, 0x45, 0x46, 0x47, 0x48, 0x49 };
    	 char[] tcChiffresSignesNegatifs = { 0x7d, 0x4a, 0x4b, 0x4c,0x4d, 0x4e, 0x4f, 0x50, 0x51, 0x52 };
    	
    	int iChiffre = Character.getNumericValue(chiffre);
    	    	
    	return("pos".equals(sense))?
    			tcChiffresSignesPositifs[iChiffre]:
    				tcChiffresSignesNegatifs[iChiffre];
    	
    }
    
    
     
    /**
     * getCommercialisation: get the final commercialisation value
     * 
     * 
     * {talendTypes} boolean, boolean, String, String
     * 
     * {Category} User Defined
     * 
     * {param} 
     * 
     * {example} getCommercialisation(false, false, null, VENTE)
     */
    public static String getCommercialisation(boolean ProductReturn, boolean boolAnnulation, String ProductID_commercialisation, String Commercialisation, 
    		String basketCommercialisationAnnulationRetour, String basketCommercialisationRetour, String basketCommercialisationLoue, String basketCommercialisationAnnulationLocation, String basketCommercialisationLocation, String basketCommercialisationVendu, String basketCommercialisationAnnulationVente, String basketCommercialisationVente, String basketCommercialisationMixte) {
    /*
		System.out.print("ProductReturn:");System.out.println(ProductReturn);
		System.out.print("boolAnnulation:");System.out.println(boolAnnulation);
		System.out.print("ProductID_commercialisation:");System.out.println(ProductID_commercialisation);
		System.out.print("Commercialisation:");System.out.println(Commercialisation);
		System.out.print("basketCommercialisationVendu:");System.out.println(basketCommercialisationVendu);
	*/
		
    	String commerTemp = null;

    	if (ProductReturn)
    	    	{
    	    		if(boolAnnulation){
    	    			return basketCommercialisationAnnulationRetour;
    	    		}else{
    	    			return basketCommercialisationRetour;
    	    			}
    	    	}
    	    	else {

    	    		if (TalendString.removeAccents(Commercialisation).compareToIgnoreCase(TalendString.removeAccents(basketCommercialisationLoue)) ==0 )
    	    		{
    	    			if (boolAnnulation)
    	    			{
    	    				return basketCommercialisationAnnulationLocation;
    	    			}
    	    			else
    	    			{
    	    				return basketCommercialisationLocation;
    	    			}
    	    		}
    	    		else	
    	    		{
    	    			if (TalendString.removeAccents(Commercialisation).compareToIgnoreCase(TalendString.removeAccents(basketCommercialisationVendu)) == 0 )
    	    			{
    	    				if(boolAnnulation){
    	    					return basketCommercialisationAnnulationVente;
    	    				}
    	    				else
    	    				{
    	    					return basketCommercialisationVente;
    	    				}
    	    			}
    	    			else			
    					
    						//System.out.println("VCE: Commercialisation " + Commercialisation);
    						
    						
    	    				if (TalendString.removeAccents(Commercialisation).compareToIgnoreCase(TalendString.removeAccents(basketCommercialisationMixte)) == 0)
    	    				{
    	    					//System.out.println("VCE: Produit Mixte");
    	    					if (ProductID_commercialisation!=null){
    								//System.out.println("VCE: Produit Mixte, commercialisation != null ");
    								//System.out.println("VCE: ProductID_commercialisation = " + ProductID_commercialisation);
    								
    								
    								if (TalendString.removeAccents(ProductID_commercialisation).compareToIgnoreCase(TalendString.removeAccents(basketCommercialisationLocation)) ==0 )
    								{
    									 commerTemp = basketCommercialisationLoue;
    								}else{	
    									 commerTemp = basketCommercialisationVendu;
    								}
    								
    								
    	    						return BestarTransform.getCommercialisation(ProductReturn, boolAnnulation, ProductID_commercialisation, commerTemp,  
    	    								basketCommercialisationAnnulationRetour,  basketCommercialisationRetour,  basketCommercialisationLoue,  basketCommercialisationAnnulationLocation,  basketCommercialisationLocation,  basketCommercialisationVendu,  basketCommercialisationAnnulationVente,  basketCommercialisationVente,  basketCommercialisationMixte);
    										
    	    						}
    	    					else {
    									//System.out.println("VCE: Produit Mixte, commercialisation == null");
    	    							return BestarTransform.getCommercialisation(ProductReturn, boolAnnulation, "", basketCommercialisationVendu,
    	    									basketCommercialisationAnnulationRetour,  basketCommercialisationRetour,  basketCommercialisationLoue,  basketCommercialisationAnnulationLocation,  basketCommercialisationLocation,  basketCommercialisationVendu,  basketCommercialisationAnnulationVente,  basketCommercialisationVente,  basketCommercialisationMixte);
    											
    	    							
    	    						}
    	    				}
    	    				else
    	    				{   
    	    					
    	    					//System.out.println ("===============>"+ProductID_commercialisation);
    	    					return BestarTransform.getCommercialisation(ProductReturn, boolAnnulation, "", basketCommercialisationVendu,
	    								basketCommercialisationAnnulationRetour,  basketCommercialisationRetour,  basketCommercialisationLoue,  basketCommercialisationAnnulationLocation,  basketCommercialisationLocation,  basketCommercialisationVendu,  basketCommercialisationAnnulationVente,  basketCommercialisationVente,  basketCommercialisationMixte);

    						}    	    				
    	    		}       
    	    	}	
    }

    
    /**
     * convertAsciiToDecimal: Converts an ascii string to its decimal value
     * 
     * @param string (string to convert)
     * 
     * @return its decimal value
     * 
     * 
     * {talendTypes} string
     * 
     * {Category} User Defined
     * 
     * {param} string (string to convert)
     * 
     * {example} convertAsciiToDecimal("AMY") #657789
     * 
     */   
    public static String convertAsciiToDecimal(String stringToConvert){
    	
    	
    	int i;
    	int decimalValue;
    	Character c;
    	StringBuilder decimalValueStr = new StringBuilder();
    	
    	for (i=0; i<stringToConvert.length(); i++){
    		
    		c = new Character(stringToConvert.charAt(i));
    		//System.out.println("char:"+c);
    		decimalValue = (int)c;
    		//System.out.println("decimalValue:"+decimalValue);
    		//decimalValue:
    		decimalValueStr.append(decimalValue);
    		//System.out.println("decimalValueStr:"+decimalValueStr);
    	}
    		
    	return decimalValueStr.toString();
    }
    
    
    
}
