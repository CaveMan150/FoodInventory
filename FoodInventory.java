import java.util.*;
import java.text.*;
/**
    Class FoodInventory stores the essential information needed to model an inventory food numbers
    it is drived from Product class, it uses it to get Pirce and quantatiy as well as the name
    This class has the declaration of the expiration date of the products and products numbers
    in stock.
*/
  
public class FoodInventory extends Product {
   Date Exp;// Product Expiration Date (Date Type)
   int prodNum; //Product Number (Integer Type)
   String EX; // Product Expiration Date(String Type) for function to prints based on Expiration Date 
   Locale currentLocale = new Locale.Builder().setLanguage("en").setRegion("US").build(); // A local object from Locale.Builder
   //Gets currency instance from Locale
   Currency currentCurrency = Currency.getInstance(currentLocale);
   // Currency Formatter to Locale
   NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
     
     
    /**
     Nondefault constructor to initialize a product.
     @param n the name of a food product
     @param u the product number of a food product
     @param q the quantity of a food product
     @param p the price of a food product
     @param e the expiry date of a food product
   */

   public FoodInventory(String n, int u,int q, Double p, Date e){
      super(n, q, p);
      
      Exp = e;
      prodNum = u;
      EX = "";
      EX += "Expiry Date: " + Exp;
      EX += " Name: " + this.getName() + " ";
      EX += "Product Number: " + prodNum + " "; 
      EX += "Price: " + currencyFormatter.format(price) + " ";
      EX += "Quantity: " + quantity + " ";
      
     
      }
   /**
    Change the Product Number of the item.
    @param up  the updated product number of the item
   */  
   public void setUPC(int up){
      prodNum = up;
      
    }
    /**
    Accessor method for the product number.
    @return the product number
   */
   public int getUPC(){
      return prodNum;
    }
     /**
    Change the Product Expiry of the item.
    @param ex the updated product expiration Date of the item
   */ 
   public void setExp(Date ex){
      Exp = ex;
     }
   /**
    Accessor method for Expiration Date.
    @return the Expiry date of the product
   */
   public Date getExp(){
      return Exp;
   }
    /**
    Accessor method for Price gets the price from the product class.
    @return calls the accessor of get price to return the price of the product
   */
   public Double getPrice(){
      return super.getPrice();
   }
    
    /**
    Accessor method for Quantity gets the Quantity from the product class.
    @return calls the accessor of get Quantity to return the Quantity of the product
   */
   public int getQuantity() {
       return super.getQuantity();
   }
   /**
    Accessor method for Name gets the Name from the product class.
    @return calls the accessor of get Name to return the Name of the product
   */
   public String getName(){
      return super.getName();
   }
    /**
     Works as ToString Convert the information concerning a food product to a string but starting with product expiry Date.
     @return the string representing the  expiration Date,  name, productn Number, price in USD, and quantity in that order
   */
   public String getByExp(){
   
      //assumes price is in US dollars
      
        return EX;
   }
  
   
   
  
  /**
    Compare two FoodInventory to see if they are equal based on Expiration Date.
    @return true if the Expirations match and false if they are not
   */
  public int compareTo(FoodInventory Product1) {
      
     return this.getExp().compareTo(Product1.getExp());
       
      }
    
         
     
   /**
     Convert the information concerning FoodInventory to a string.
     @return the string representing the name, productn Number, price in USD, and quantity, expiration Date in that order
   */

   @Override
   public String toString(){
   
      //assumes price is in US dollars
      Locale currentLocale = 
             new Locale.Builder().setLanguage("en").setRegion("US").build();
      Currency currentCurrency = Currency.getInstance(currentLocale);
      NumberFormat currencyFormatter = 
             NumberFormat.getCurrencyInstance(currentLocale);
        
      
      String s = "";
      s +=  "Name: " + this.getName() + " ";
      s += "Product Number: " + prodNum + " "; 
      s += "Price: " + currencyFormatter.format(price) + " ";
      s += "Quantity: " + quantity + " ";
      s += "Expiry Date: " + Exp;
      return s;
   }

 





}