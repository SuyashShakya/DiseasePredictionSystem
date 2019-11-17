/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.OptionHandler;
import weka.core.Utils;
import weka.filters.Filter;
import weka.core.Attribute;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;
import java.util.Vector;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.trees.J48;
import weka.core.FastVector;
import weka.core.Instance;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;

/**
 *
 * @author Bala J
 */
public class DClassifier {
    
    Classifier cModel;
    // These are the attriutes on which we classify whehter pateient will have disease or not.
    Attribute [] allattrib;
   
    // There are two classifation Disease or No Disease , so it is 2.
    FastVector fvClassVal = new FastVector(2);
    Attribute ClassAttribute;
    // Inclinding class label there are 9 attributes in each line. 
    FastVector fvWekaAttributes;
    Instances isTrainingSet;
    int numf;
    
    
    DClassifier(int nf)
    {
         numf=nf;  

         allattrib = new Attribute[numf];
         for (int i=0;i<allattrib.length;i++)
         {
             allattrib[i] =new Attribute("f"+i);
         }
         
         fvClassVal.addElement("1");
         fvClassVal.addElement("0");
         ClassAttribute = new Attribute("theClass", fvClassVal);

         fvWekaAttributes = new FastVector(numf+1);
         for (int i=0;i<numf;i++)
         {
             fvWekaAttributes.addElement(allattrib[i]);
         }         
         fvWekaAttributes.addElement(ClassAttribute);
         
        
        
        
    }
    
    
      public void trainClassifier(String trainfile)
    {
  
         // In this function, training.txt is read and a decision tree classifier is built. 

        int count = 0;
        
        try
        {
           FileReader fr = new FileReader(trainfile);

           BufferedReader buf=new BufferedReader(fr);

           String s;

           while ((s=buf.readLine())!=null)
           {
                 if (s.length()<2)
                 {
                     continue;
                 }
                 count++;
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        isTrainingSet = new Instances("Rel", fvWekaAttributes, count);
        // Set class index
        isTrainingSet.setClassIndex(numf);
         
        try
        {
           FileReader fr = new FileReader(trainfile);

           BufferedReader buf=new BufferedReader(fr);

           String s;

           int ct=0;
           while ((s=buf.readLine())!=null)
           {
                 if (s.length()<2)
                 {
                     continue;
                 }
                 if (ct==0)
                 {
                     ct++;
                     continue;
                 }
                
                 System.out.println(s);
                 Instance iExample = new Instance(numf+1);
                 
                 String [] parts = s.split(",");
            
                
                for (int i=0;i<numf;i++)
                {
                     iExample.setValue((Attribute)fvWekaAttributes.elementAt(i),Double.parseDouble(parts[i]));
                }
                iExample.setValue((Attribute)fvWekaAttributes.elementAt(numf),parts[numf]);
               
                isTrainingSet.add(iExample);
                
                // All data from training.txt is loaded to trainingdataset
                               
           }
           buf.close();
           fr.close();
           
           // here decision tree model is created and trained. 
           cModel = (Classifier)new J48();
            cModel.buildClassifier(isTrainingSet);
           
           
        }
        catch(Exception e)
        {
          
        }
    }
      
      // In this function , for a new patient , based on his atriutes and the decision tree model built.
      // classification is done whether diabetes are not. 
    boolean isDisease(String line)
    {
        
        String [] parts = line.split(",");
        
        Instance iExample = new Instance(numf+1);
        for (int i=0;i<numf;i++)
        {
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(i),Double.parseDouble(parts[i]));
        }
    
                
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(numf),"1");
        
        
        iExample.setDataset(isTrainingSet);
             try
             {
                 double[] fDistribution = cModel.distributionForInstance(iExample);
                 double bigval0 = fDistribution[0];
                 double bigval1 = fDistribution[1];

                 
                 if (bigval0>bigval1)
                 {
                     return true;
                 }
                 

             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        
             return false;
        
        
    }
    
    // This is unit test code to check if DClassifier is working or not 
    public static void main(String []arg)
    {
        DClassifier dc = new DClassifier(8);

        try
        {
            dc.trainClassifier("training.txt");
        
            System.out.println("Training completed!!!!");
            
            String ct = "9,170,74,31,0,44.0,0.403,43";
            
            boolean res=dc.isDisease(ct);
            
            System.out.println("Returned result:" + res);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        
    }
    
    
    
    
}