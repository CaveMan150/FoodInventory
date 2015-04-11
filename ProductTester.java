import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


class ProductTester{
   //Declaration of Variables
   
   private Scanner file;//filename
   String name;//name of prod
   Double prices;/// price of prod
   int upc;
   int quant;
   Date exp;
   String str;//strings inside file
   String quantstr;///quantity in string gotten from file
   String pricesstr;// price in string gotten from file
   String expstr; //experiration in string gotten from file
   String upcstr; // upc in string gotten from file
   FoodInventory list;
   TreeSet<FoodInventory> products  = new TreeSet<FoodInventory>();
   TreeSet<Object> Expiry = new TreeSet<Object>();
   
      
   //Main class
   public static void main(String args[]) throws FileNotFoundException {
  
  
      ProductTester start  = new ProductTester();
      start.RUN();
       
   }
   public void RUN()throws FileNotFoundException{
       ProductTester obj = new ProductTester();
         obj.File();
      

      char choice;
    try{
      do{
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("Please choose an option from the following menu:"); 
         System.out.println("U: Upload product information for a delivery.");
         System.out.println("P: Print the current inventory sorted by product name");
         System.out.println("E: List the current inventory sorted by expiration date");
         System.out.println("S: Search for an item by product name");
         System.out.println("D: Decrement the quantity for an item");
         System.out.println("R: Remove/discontinue an item");
         System.out.println("Q: Quit the system");
      
         Scanner input = new Scanner(System.in);
         choice = input.next().charAt(0);
         if( choice == 'U'){
           obj.UploadFile(); 
         }
         else if(choice == 'P'){
            obj.Display();
          }
         else if(choice == 'E'){
            obj.TrackExp();
            }
         else if(choice == 'S'){
            obj.FindAnItem();
           }
         else if(choice == 'D'){
            obj.Decrement_Item();
           }
         else if(choice =='R'){
            obj.remove();
          }
         else if(choice == 'Q'){
            
            break;
          }
       }while(choice != 'Q');
       }catch (Exception e){
        
       }
      
   }
  
          
   
    public void File() throws FileNotFoundException{
     
       int c = 0;
         
         FileInputStream file = null;        
         try {
            
           file = new FileInputStream(new File("inventory.txt"));
         } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file ");
         }
            DataInputStream input = new DataInputStream(file);
            BufferedReader bufr = new BufferedReader(new InputStreamReader(input));
            
            try {
               while((str =  bufr.readLine()) != null){
                 c++; 
                  String[] arr = str.split(" ");
                  for (int i = 0; i<arr.length; i++){
                     if (i == 0) {
                       
                        name = arr[i];
               
                     }
                     else if (i == 1){
                        upcstr = arr[i];
                        upc = Integer.valueOf(upcstr);
                     }
                     else if (i == 2){
                        quantstr = arr[i];
                        quant = Integer.valueOf(quantstr);
                     }
                     else if (i == 3){
                        pricesstr = arr[i];
                        prices = Double.valueOf(pricesstr);
                     }
                     else if (i == 4){
                        if (arr[i].length() == 7){
                           expstr = "0" + arr[i];
                        }
                        else{
                           expstr = arr[i];
                        }
                        Date date = null;
                        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                        try {
                            date = sdf.parse(expstr);
                        } catch (ParseException ex) {
                        }
                        exp = date;
                     }
                  }
 
                  
                  list = new FoodInventory(name, upc, quant, prices, exp);
                
                  products.add(list);
              
                  Expiry.add(list.getByExp());
                  
                  
               
                
                  }
            } catch (IOException e) {
               
            }
            System.out.println("The inventory in the file inventory.txt has been successfully imported.");
               
         
        }
        

   public void UploadFile() throws FileNotFoundException{
     
       int c = 0;
         
         FileInputStream file = null;        
         try {
            Scanner userInput = new Scanner(System.in);
            String File_To_Upload;
            System.out.println("Please enter the file name be sure to add(.txt) Like (File.txt) : ");
            File_To_Upload = userInput.nextLine();
            
            file = new FileInputStream(new File(File_To_Upload));
         } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
         }
            DataInputStream input = new DataInputStream(file);
            BufferedReader bufr = new BufferedReader(new InputStreamReader(input));
            
            try {
               while((str =  bufr.readLine()) != null){
                 c++; 
                  String[] arr = str.split(" ");
                  for (int i = 0; i<arr.length; i++){
                     if (i == 0) {
                       
                        name = arr[i];
               
                     }
                     else if (i == 1){
                        upcstr = arr[i];
                        upc = Integer.valueOf(upcstr);
                     }
                     else if (i == 2){
                        quantstr = arr[i];
                        quant = Integer.valueOf(quantstr);
                     }
                     else if (i == 3){
                        pricesstr = arr[i];
                        prices = Double.valueOf(pricesstr);
                     }
                     else if (i == 4){
                        if (arr[i].length() == 7){
                           expstr = "0" + arr[i];
                        }
                        else{
                           expstr = arr[i];
                        }
                        Date date = null;
                        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                        try {
                            date = sdf.parse(expstr);
                        } catch (ParseException ex) {
                        }
                        exp = date;
                     }
                  }
 
                  
                  list = new FoodInventory(name, upc, quant, prices, exp);
                
                  products.add(list);
              
                  Expiry.add(list.getByExp());
                  
                  
               
                
                  }
            } catch (IOException e) {
            
            }
            System.out.println("The inventory in the file inventory.txt has been successfully imported.");
               
         
        
   }
      
   public void Display(){
     for(Product product: products) {
            System.out.println(product);
        }
        
      }

  public void TrackExp(){
   
      System.out.println(" List below is being printed based on product expiration date  : ");
      for(Object expiration: Expiry){
      System.out.println(expiration);
      }

      }
 //Finds an item from the inventory and returns it
  public void FindAnItem(){
     try{
     Scanner userInput = new Scanner(System.in);
     String Product_Name;
     System.out.println("Please Enter the Product Name  : ");
     Product_Name = userInput.next();
     for(Product Find_In_Items: products){
           if(Find_In_Items.getName().equals(Product_Name)){
               
              System.out.println(Find_In_Items);
               }
               }
               }catch(Exception e){
                  System.out.println("ERROR ");
                }
     
         
     }
     //Decrements an item from its UPC
     public void Decrement_Item(){
     Scanner userInput = new Scanner(System.in);
     int Product_Number;
     System.out.println("Please Enter the Product Number (UPC)  : ");
     Product_Number = userInput.nextInt();
     try{
            for(FoodInventory Decrement_Item: products){
               if(Decrement_Item.getUPC() == Product_Number){
                     System.out.println(Decrement_Item);
                      Decrement_Item.decrement();
                      System.out.println(Decrement_Item);
                      if(Decrement_Item.getQuantity() == 0){
                           System.out.println("This product is no longer available (Out of Stock ");
                       }
                     
              }
              
            }
            }catch(Exception e){
                  System.out.println("ERROR ");
                }
            
      }
      ///removes an item
     public void remove(){
     Scanner userInput = new Scanner(System.in);
     int Product_Number;
     System.out.println("Please Enter the Product Number (UPC) to remove  : ");
     Product_Number = userInput.nextInt();
     try{
            for(FoodInventory Item_To_Remove: products){
               if(Item_To_Remove.getUPC() == Product_Number){
                     if(Item_To_Remove.getQuantity() == 0){
                           System.out.println("This product is no longer available (Out of Stock ");
                           System.out.println(Item_To_Remove);
                           products.remove(Item_To_Remove);
                          System.out.println(Item_To_Remove);

                       }
                     
              }
              
            }
            }catch(Exception e){
                  System.out.println("ERROR ");;
                }
            
      }

     
}
