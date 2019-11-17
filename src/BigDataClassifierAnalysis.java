/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Iterator;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.KeyValueTextInputFormat;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.mapreduce.Mapper.Context;
/**
 *
 * @author Bala J
 */
public class BigDataClassifierAnalysis {
    
    public static DiabetesClassifier ec;
    
    public static int poscount=0;
    
    public  static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

         public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
             
               String st = value.toString();
              
               String[] vt = st.split("#");
                       
               
               int ret = ec.classify(vt[1]);
               
              
               if (ret==0)
               {
                   FileAppender.AppendtoFile("results.txt", vt[0] + ",Tested Negative");
                   output.collect(new Text("No Disease"), new IntWritable(1));
               }
               else
               {
                   FileAppender.AppendtoFile("results.txt", vt[0] + ",Tested Positive");
                   output.collect(new Text("Disease"), new IntWritable(1));
                   poscount++;
               }
               
               
               
         }
    }
    
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

            public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

                  int sum=0;
                  
                  while (values.hasNext())
                  {
                      int c = values.next().get();
                      sum = sum + c;
                      
                  }
                  
                  output.collect(key, new IntWritable(sum));  
                
        
            }
    }
    
    
}
