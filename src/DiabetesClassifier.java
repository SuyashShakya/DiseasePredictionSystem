/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;
import org.neuroph.core.CNN;
import org.neuroph.core.learning.TrainingSet;


/**
 *
 * @author Bala J
 */
public class DiabetesClassifier {
    
    CNN cnnNet;
    
    DClassifier dc;
    
    
    DiabetesClassifier(int numf)
    {
        
        cnnNet = new CNN(numf,4,2);
                
            
        dc = new DClassifier(numf);
      
        
    }
    
    int getRows(String trainfile)
    {
        
           try
           {

                 FileInputStream fstream = new FileInputStream(trainfile);

                 DataInputStream in = new DataInputStream(fstream);

                 BufferedReader br = new BufferedReader(new InputStreamReader(in));

                 String strLine;
                 int count=0;
                 while ((strLine = br.readLine()) != null)   {
                     
                     if (strLine.length()<5)
                     {
                         continue;
                     }
                     count++;
                 }
                 br.close();
                 in.close();
                 fstream.close();
                 
                 return count;
        
           }
           catch(Exception ex)
           {
               
           }
           return -1;
                 
    }
    void train(String trainfile)
    {
     
           Main.guiinst.writetologinred("Started training ...");
           dc.trainClassifier(trainfile);
           cnnNet.train(trainfile);
           try
           {

                 int totrows=getRows(trainfile)-1;
                 
                 int trainrows = (int)(totrows*.8);
                 
                 FileInputStream fstream = new FileInputStream(trainfile);

                 DataInputStream in = new DataInputStream(fstream);

                 BufferedReader br = new BufferedReader(new InputStreamReader(in));

                 String strLine;


                 
                
                 //Read File Line By Line
                 int count=0;
                 while ((strLine = br.readLine()) != null)   {

                      if (count==0)
                      {
                          count++;
                          continue;
                      }
                      if (strLine.length()<5)
                      {
                          continue;
                      }
                      if (count==(trainrows+1))
                      {
                          break;
                      }
                      
                      Main.guiinst.writetolog(strLine);
                      
                      
                      count++;
                      
                     
                 }
                 
                 
                 
                 
                 int acc=0;
                 int tot=0;
                 int dacc=0;
                 count=0;
                 while ((strLine = br.readLine()) != null)   {
                     
                     if (count==0)
                     {
                         count++;
                         continue;
                     }
                     if (strLine.length()<5) continue;
                     
                     tot++;
                     String  [] pa = strLine.split(",");
                     
                     String newstr = pa[0];
                     
                     for (int i=1;i<pa.length-1;i++)
                     {
                         newstr=newstr + "," + pa[i];
                     }
                     
                     int expresult = Integer.parseInt(pa[pa.length-1]);
                     int actresult = cnnNet.classify(newstr);
                     
                     
                     if (expresult==actresult) acc++;
                     
                     actresult = classifyD(newstr);
                     
                     if (expresult==actresult) dacc++;
                 }
                 
                 Main.guiinst.writetologinred("Total test records:" + tot);
                 Main.guiinst.writetologinred("Accurate records:" +acc);
                 
                 double accper = (acc*100.0/tot);
                 
                 Main.guiinst.writetologinred("Accuracy=" + accper);
                 String ct= "P#" + trainrows + "#" + accper;
                 
                 FileAppender.AppendtoFile("Perfg1.txt", ct);
                 
                 accper = (dacc*100.0/tot);
                 Main.guiinst.writetologinred("Decision tree Accuracy=" + accper);
                 ct= "D#" + trainrows + "#" + accper;
                 FileAppender.AppendtoFile("Perfg1.txt", ct);
                 
                 br.close();
                 in.close();
                 fstream.close();
                 
                 
                  
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
           
        
        
        
    }
    
    int classifyD(String datavalues)
    {
         return cnnNet.classD(datavalues);
    }
    int classify(String datavalues)
    {
        return cnnNet.classify(datavalues);
         
         
        
         
    }
    
    
    
    
    
}
