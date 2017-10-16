import java.util.*;
import java.io.*;

//Main class
public class Process_simulation
{
  public static void main (String [] args)
  {     
    boolean system = true;
    while(system == true)
    { 
      int countInputs=1;//Initialise a counter to spot errors in the inputed data and will be used in an exception
      
      Scanner keyboard = new Scanner(System.in);
      File file = new File("Inputs_File.txt");//Text file from which the program will retrive the inlet data
      //BufferedReader br = new BufferedReader (new FileReader (file));//To read strings from the input file
      
      try
      {
        Scanner input = new Scanner(file);
        
        try
        {       
          double tolerance = input.nextDouble();//Reads from the text file the tolerance for the numerical method
          //If statement should be added to check if the value is right/acceptable (range)
          System.out.println("\nThe value of the tolerance for the numerical method is "+tolerance);
          countInputs++;
          
          double T_i = input.nextDouble();//Reads from the text file the process initial temperature
          //If statement should be added to check if the value is right/acceptable (range)
          //Also add statements to ask the user the units of the temperature and do the right changes for the equations if needed
          System.out.println("The value of the process intial inlet temperature is "+T_i);//add the units to this sentence
          countInputs++;
          
          double P_i = input.nextDouble();//Reads from the text file the process pressure
          //If statement should be added to check if the value is right/acceptable (range)
          //Also add statements to ask the user the units of the pressure and do the right changes for the equations if needed
          System.out.println("The value of the tank pressure is "+P_i);//add the units to this sentence
          countInputs++;
          
          double mass_flowrate = input.nextDouble();//Reads from the text file the mass flowrate
          //If statement should be added to check if the value is right/acceptable (range)
          //Also add statements to ask the user the units of the mass flowrate and do the right changes for the equations if needed
          System.out.println("The mass flowrate is "+mass_flowrate);//add the units to this sentence
          countInputs++;
          
          /*String type = input.nextString ();
           //If statement should be added to check if the string is either single component or mixture
           System.out.println("\nThe feed solution in a "+type);
           countInputs++; //It will read the value of the tolerance that is the first value of the file
           
           if (type == single component)//Not sure if I can do that
           {
           double z = 1;
           }
           
           else
           {
           System.out.println("How many species is ther in the mixture?");
           int number = keyborad.nextInt;
           
           for (int i = 1; i<= number; i++)
           {
           System.out.println("What is the composition of specie "+i+" ?");
           //Way to store the values one by one and be able to use them after
           }
           }*/            
          
          /*try
           { 
           System.out.println("\nChoose the simulation you want to do:");
           System.out.println("Press 1 if you specified a constant operating temperaure and want to calculate the heat to maintain the temperature");
           System.out.println("Press 2 if you entered the feed temperature and want to calculate the adiabatic flash temperature of the mixture");
           System.out.println("Press 3 if you entered the flash temperature and want to calculate the adiabatic feed temperature of the mixture");
           int simulation = keyboard.nextInt();
           
           if (simulation == 1)
           { 
           //Call the method that returns the value asked
           //Do not forget values for the liquid and vapour compositions and flowrates
           }
           
           else if (simulation == 2)
           {
           //Call the method that returns the value asked
           //Do not forget values for the liquid and vapour compositions and flowrates
           }
           
           else if (simutlation == 3)
           {
           //Call the method that returns the value asked
           //Do not forget values for the liquid and vapour compositions and flowrates
           }
           
           else
           {
           System.out.println("\nYou should write 1, 2 or 3. Please compile and run the program again");
           break;
           }
           }*/
          
        }        
        
        catch (InputMismatchException e)
        {
          System.out.println("\nYou didn't input what was asked compile and run the program again");
          break;
        }
        
        input.close();
        
        system = false;
        while(system == false)
        {
          System.out.println("\nDo you want to do another simulation? ");
          System.out.println("If you wish to continue, you can modify the input values save them then type YES");
          System.out.println("Or else type NO to end the simulation");
          String choice = keyboard.next();    
          
          if (choice.equals("YES"))
          {
            system = true;
          }
          else if (choice.equals("NO"))
          {
            System.out.println("End of the simulation");
            break;
          }
          else
          {
            System.out.println("Wrong input");
            system =false;
          }
        }        
      }
      
      /*catch (IOException e)
       {
       e.printStackTrace();
       break;
       }*/ //Exception for the string and it creates errors if left with the following exception
      
      catch (FileNotFoundException e)
      {
        System.out.println("Inputs_file can not be found, please put it into the same folder as the java codes and run the program again");
        break;
      }
      
      catch (InputMismatchException e)
      {
        System.out.println("\nThe Inputs_file was not filled the right way, the error was found at the line "+countInputs+" of the file.");
        System.out.println("Please fix the error save the file, compile and run the program again.");
        break;
      }
      
      //Create an exception for when there is a missing value in the input file using countInputs
      
      keyboard.close();
    }//End of while loop
  }//End of main method
}//End of main class
